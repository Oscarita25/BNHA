package com.oscar;

import java.io.File;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.MessageEXP;
import com.oscar.data.packets.MessageLEVEL;
import com.oscar.data.packets.MessageNEXP;
import com.oscar.data.packets.MessageQuirkID;
import com.oscar.data.packets.MessageRequestActivate;
import com.oscar.data.packets.MessageRequestActivate.HandleRequestActivate;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestEXP.HandleRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestLEVEL.HandleRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestNEXP.HandleRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.packets.MessageRequestQuirkID.HandleRequestQuirkID;
import com.oscar.data.types.exp.ExpFactory;
import com.oscar.data.types.exp.ExpStorage;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQName;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.level.LevelFactory;
import com.oscar.data.types.level.LevelStorage;
import com.oscar.data.types.nexp.NExpFactory;
import com.oscar.data.types.nexp.NExpStorage;
import com.oscar.data.types.quirk.act.QActFactory;
import com.oscar.data.types.quirk.act.QActStorage;
import com.oscar.data.types.quirk.cool.QCoolFactory;
import com.oscar.data.types.quirk.cool.QCoolStorage;
import com.oscar.data.types.quirk.id.QuirkIDFactory;
import com.oscar.data.types.quirk.id.QuirkIDStorage;
import com.oscar.data.types.quirk.maxact.QMaxActFactory;
import com.oscar.data.types.quirk.maxact.QMaxActStorage;
import com.oscar.data.types.quirk.maxcool.QMaxCoolFactory;
import com.oscar.data.types.quirk.maxcool.QMaxCoolStorage;
import com.oscar.data.types.quirk.name.QNameFactory;
import com.oscar.data.types.quirk.name.QNameStorage;
import com.oscar.init.ModItems;
import com.oscar.proxy.CommonProxy;
import com.oscar.quirk.CustomSpawnable;
import com.oscar.quirk.Icicle;
import com.oscar.util.BNHAConfig;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;
import com.oscar.util.handlers.Eventhandler;
import com.oscar.util.handlers.KeyInputHandler;
import com.oscar.util.handlers.KeyInputHandler.Keybinds;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
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
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS, useMetadata = true )
public class BNHA 
{
    public static int ID = 0;
    public static int nextEntityID = 1;
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
    
	
	private void registerEntity(Class<? extends Entity> entity, String name) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entity, name, nextEntityID++,this, 64, 20, true);
	}	
	
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
       CapabilityManager.INSTANCE.register(IQuirkID.class, new QuirkIDStorage(), new QuirkIDFactory());
       CapabilityManager.INSTANCE.register(IQMaxCool.class, new QMaxCoolStorage(), new QMaxCoolFactory());
       CapabilityManager.INSTANCE.register(IQCool.class, new QCoolStorage(), new QCoolFactory());
       CapabilityManager.INSTANCE.register(IQAct.class, new QActStorage(), new QActFactory());
       CapabilityManager.INSTANCE.register(IQMaxAct.class, new QMaxActStorage(), new QMaxActFactory());
       CapabilityManager.INSTANCE.register(IQName.class, new QNameStorage(), new QNameFactory());

       MinecraftForge.EVENT_BUS.register(new Capabilities());
       //Packets
       NETWORK.registerMessage(HandleRequestEXP.class, MessageRequestEXP.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestLEVEL.class, MessageRequestLEVEL.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestNEXP.class, MessageRequestNEXP.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestActivate.class, MessageRequestActivate.class, ID++, Side.SERVER);
       NETWORK.registerMessage(HandleRequestQuirkID.class, MessageRequestQuirkID.class, ID++, Side.SERVER);

       
       NETWORK.registerMessage(MessageEXP.HandleMessageEXP.class, MessageEXP.class, ID++, Side.CLIENT);
       NETWORK.registerMessage(MessageLEVEL.HandleMessageLEVEL.class, MessageLEVEL.class, ID++, Side.CLIENT);
       NETWORK.registerMessage(MessageNEXP.HandleMessageNEXP.class, MessageNEXP.class, ID++, Side.CLIENT);
       NETWORK.registerMessage(MessageQuirkID.HandleMessageQuirkID.class, MessageQuirkID.class, ID++, Side.CLIENT);

       //Keybinds
       Keybinds.initKeybindings();
       MinecraftForge.EVENT_BUS.register(new KeyInputHandler());

       

    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       LoggingUtil.info("BNHA Mod initialisation started!");
       registerEntity(CustomSpawnable.class, "Hellfire");
       registerEntity(Icicle.class, "Iicle");
       MinecraftForge.EVENT_BUS.register(new Eventhandler()); 
       proxy.registerRenders();
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

