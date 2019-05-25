package com.oscar;

import java.io.File;

import com.oscar.commands.QuirkChange;
import com.oscar.init.ModItems;
import com.oscar.proxy.CommonProxy;
import com.oscar.util.BNHAConfig;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;
import com.oscar.util.handlers.Eventhandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import obsidiansuite.obsidianAPI.ObsidianEventHandler;
import obsidiansuite.obsidianAPI.network.AnimationNetworkHandler;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, useMetadata = true )
public class BNHA {

    @Mod.Instance
    public static BNHA instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    public static CreativeTabs BNHA = new CreativeTabs("bnha")
    {@Override public ItemStack getTabIconItem() {return new ItemStack(ModItems.UA_SPORTS_CHESTPLATE);}};
    
	public static Configuration config;
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	
    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       LoggingUtil.BNHALogger = event.getModLog();
       LoggingUtil.info("BNHA Mod pre initialisation started!");
      
       File dir = event.getModConfigurationDirectory();
       config = new Configuration(new File(dir.getPath(), "bnha.cfg"));
       BNHAConfig.readCfg();

       proxy.registerCapabilites();
       proxy.registerPackets();
       proxy.initKeybindings();

    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
       LoggingUtil.info("BNHA Mod initialisation started!");
       proxy.registerEntities();
       proxy.registerRenders();
       proxy.registerAnimations();
       AnimationNetworkHandler.init();
    }
    
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
       LoggingUtil.info("BNHA Mod post initialisation started!");
		if (config.hasChanged()) {
			config.save();
		}
		proxy.registerRendersPost();
		
    }
    
    @EventHandler
    public void load(FMLInitializationEvent event)
    {
       LoggingUtil.info("Loading - Handlers");
       proxy.registerClientHandler();
       MinecraftForge.EVENT_BUS.register(new Eventhandler()); 
       MinecraftForge.EVENT_BUS.register(new ObsidianEventHandler());
    }

    @EventHandler
    public void serverLoad(FMLServerStartingEvent event)
    {
        LoggingUtil.info("Loading - Commands");
        event.registerServerCommand(new QuirkChange());
        event.getServer().setAllowFlight(true);
    }
	
}

