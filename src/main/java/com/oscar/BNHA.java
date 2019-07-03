package com.oscar;

import java.io.File;

import com.oscar.commands.QuirkChange;
import com.oscar.commands.QuirkRoll;
import com.oscar.data.Capabilities;
import com.oscar.data.packets.PacketDispatcher;
import com.oscar.data.types.Exp;
import com.oscar.data.types.Level;
import com.oscar.data.types.ModelID;
import com.oscar.data.types.NExp;
import com.oscar.data.types.Stamina;
import com.oscar.data.types.api.CapabilityStorage;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.interfaces.IStamina;
import com.oscar.data.types.quirk.QuirkID;
import com.oscar.data.types.quirk.act.QActFactory;
import com.oscar.data.types.quirk.act.QActStorage;
import com.oscar.data.types.quirk.cool.QCoolFactory;
import com.oscar.data.types.quirk.cool.QCoolStorage;
import com.oscar.data.types.quirk.maxact.QMaxActFactory;
import com.oscar.data.types.quirk.maxact.QMaxActStorage;
import com.oscar.data.types.quirk.maxcool.QMaxCoolFactory;
import com.oscar.data.types.quirk.maxcool.QMaxCoolStorage;
import com.oscar.init.ModHolder;
import com.oscar.obsidianAPI.event.ObsidianEventBus;
import com.oscar.proxy.IProxy;
import com.oscar.util.CombAtt;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;
import com.oscar.util.handlers.Eventhandler;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;

@Mod(modid = Reference.MOD_ID,
	name = Reference.NAME,
	version = Reference.VERSION,
	acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS,
	useMetadata = true)
public class BNHA {
	
    public static int ID = 0;

    @Mod.Instance
    public static BNHA instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
    public static IProxy proxy;
	
    public static CreativeTabs BNHA = new CreativeTabs("bnha")
    {@Override public ItemStack getTabIconItem() {return new ItemStack(ModHolder.UA_SPORTS_CHESTPLATE);}};
    
	public static Configuration config;
	public static File dir;
    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    
    public static final ObsidianEventBus ANIMATION_EVENT_BUS = new ObsidianEventBus();


    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       LoggingUtil.BNHALogger = event.getModLog();
       dir = event.getModConfigurationDirectory();
       config = new Configuration(new File(dir.getPath(), "bnha.cfg"));
       proxy.preInit(event);
    }
    
    @Mod.EventHandler
    public void init(FMLInitializationEvent event){
		registerCapabilites();
		PacketDispatcher.registerPackets();
	       		LoggingUtil.info("Loading - Handlers");
	       MinecraftForge.EVENT_BUS.register(new Eventhandler()); 
	       MinecraftForge.EVENT_BUS.register(ANIMATION_EVENT_BUS);
	       CombAtt.init();
       proxy.init(event);
    }
    
	@Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
		proxy.postInit(event);
    }

	@Mod.EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		event.registerServerCommand(new QuirkChange());
        event.registerServerCommand(new QuirkRoll());
		proxy.serverStarting(event);
	}
    
 
	public void registerCapabilites() {
	       CapabilityManager.INSTANCE.register(ILevel.class, new CapabilityStorage<ILevel>(), Level::new);
	       CapabilityManager.INSTANCE.register(IExp.class, new CapabilityStorage<IExp>(), Exp::new);
	       CapabilityManager.INSTANCE.register(INExp.class, new CapabilityStorage<INExp>(), NExp::new);
	       CapabilityManager.INSTANCE.register(IQuirkID.class, new CapabilityStorage<IQuirkID>(), QuirkID::new);
	       CapabilityManager.INSTANCE.register(IQMaxCool.class, new QMaxCoolStorage(), new QMaxCoolFactory());
	       CapabilityManager.INSTANCE.register(IQCool.class, new QCoolStorage(), new QCoolFactory());
	       CapabilityManager.INSTANCE.register(IQAct.class, new QActStorage(), new QActFactory());
	       CapabilityManager.INSTANCE.register(IQMaxAct.class, new QMaxActStorage(), new QMaxActFactory());
	       CapabilityManager.INSTANCE.register(IModelID.class, new CapabilityStorage<IModelID>(), ModelID::new);		
	       CapabilityManager.INSTANCE.register(IStamina.class, new CapabilityStorage<IStamina>(), Stamina::new);		

	       
	       MinecraftForge.EVENT_BUS.register(new Capabilities());
	}


	
	

}

