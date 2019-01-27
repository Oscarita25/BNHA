package com.oscar;

import java.io.File;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.MessageEXP;
import com.oscar.data.packets.MessageLEVEL;
import com.oscar.data.packets.MessageNEXP;
import com.oscar.data.packets.MessageQuirk;
import com.oscar.data.packets.MessageRequestActivate;
import com.oscar.data.packets.MessageRequestActivate.HandleRequestActivate;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestEXP.HandleRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestLEVEL.HandleRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestNEXP.HandleRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirk;
import com.oscar.data.packets.MessageRequestQuirk.HandleRequestQuirk;
import com.oscar.data.types.exp.ExpFactory;
import com.oscar.data.types.exp.ExpStorage;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQuirk;
import com.oscar.data.types.level.LevelFactory;
import com.oscar.data.types.level.LevelStorage;
import com.oscar.data.types.nexp.NExpFactory;
import com.oscar.data.types.nexp.NExpStorage;
import com.oscar.data.types.quirk.QuirkFactory;
import com.oscar.data.types.quirk.QuirkStorage;
import com.oscar.init.ModItems;
import com.oscar.proxy.CommonProxy;
import com.oscar.util.BNHAConfig;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;
import com.oscar.util.handlers.Eventhandler;
import com.oscar.util.handlers.KeyInputHandler;
import com.oscar.util.handlers.KeyInputHandler.Keybinds;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class BNHA 
{
    public static int ID = 0;
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
	public static Configuration config;

    @Instance
    public static BNHA instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;

    //Creative Tab
    public static CreativeTabs BNHA = new CreativeTabs("bnha") 
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ModItems.UA_SPORTS_CHESTPLATE);
		}
	};
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       LoggingUtil.BNHALogger = event.getModLog();
       LoggingUtil.info("BNHA Mod pre initialisation started!");
      
       //config
       File dir = event.getModConfigurationDirectory();
       config = new Configuration(new File(dir.getPath(), "bnha.cfg"));
       BNHAConfig.readCfg();
       
       //Capabilities
       CapabilityManager.INSTANCE.register(ILevel.class, new LevelStorage(), new LevelFactory());
       CapabilityManager.INSTANCE.register(IExp.class, new ExpStorage(), new ExpFactory());
       CapabilityManager.INSTANCE.register(INExp.class, new NExpStorage(), new NExpFactory());
       CapabilityManager.INSTANCE.register(IQuirk.class, new QuirkStorage(), new QuirkFactory());
       
       MinecraftForge.EVENT_BUS.register(new Capabilities());
       //Packets
       NETWORK.registerMessage(HandleRequestEXP.class, MessageRequestEXP.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestLEVEL.class, MessageRequestLEVEL.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestNEXP.class, MessageRequestNEXP.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestActivate.class, MessageRequestActivate.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestQuirk.class, MessageRequestQuirk.class, ID++, Side.SERVER);
		
       NETWORK.registerMessage(MessageEXP.HandleMessageEXP.class, MessageEXP.class, ID++, Side.CLIENT);
       NETWORK.registerMessage(MessageLEVEL.HandleMessageLEVEL.class, MessageLEVEL.class, ID++, Side.CLIENT);
       NETWORK.registerMessage(MessageNEXP.HandleMessageNEXP.class, MessageNEXP.class, ID++, Side.CLIENT);
       NETWORK.registerMessage(MessageQuirk.HandleMessageQuirk.class, MessageQuirk.class, ID++, Side.CLIENT);
       
       //Keybinds
       Keybinds.initKeybindings();
       MinecraftForge.EVENT_BUS.register(new KeyInputHandler());

       

    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       LoggingUtil.info("BNHA Mod initialisation started!");
       MinecraftForge.EVENT_BUS.register(new Eventhandler());       
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
       LoggingUtil.info("BNHA Mod post initialisation started!");
		if (config.hasChanged()) {
			config.save();
		}
    }
    

	
}

