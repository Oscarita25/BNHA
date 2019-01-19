package com.oscar;

import com.oscar.data.packets.MessageActivate;
import com.oscar.data.packets.MessageActivate.MessageHandlerActivateServer;
import com.oscar.data.packets.MessageEXP;
import com.oscar.data.packets.MessageLEVEL;
import com.oscar.data.packets.MessageNEXP;
import com.oscar.data.packets.MessageQuirk;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestEXP.HandleRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestLEVEL.HandleRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestNEXP.HandleRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirk;
import com.oscar.data.packets.MessageRequestQuirk.HandleRequestQuirk;
import com.oscar.init.ModItems;
import com.oscar.proxy.ClientProxy;
import com.oscar.proxy.CommonProxy;
import com.oscar.quirks.QuirkManage;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;
import net.minecraftforge.common.MinecraftForge;
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

    @Instance
    public static BNHA instance;
    
    @SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.COMMON_PROXY_CLASS)
    public static CommonProxy proxy;
    public static ClientProxy clientproxy;

    public static final SimpleNetworkWrapper NETWORK = NetworkRegistry.INSTANCE.newSimpleChannel(Reference.MOD_ID);
    
    @EventHandler
    public void preInit(FMLPreInitializationEvent event)
    {
       LoggingUtil.BNHALogger = event.getModLog();
       LoggingUtil.info("BNHA Mod pre initialisation started!");
       proxy.preInit(event);
       
    	proxy.registerData();

		QuirkManage.init();
    	
    	NETWORK.registerMessage(HandleRequestEXP.class, MessageRequestEXP.class, ID++, Side.SERVER);
    	NETWORK.registerMessage(HandleRequestLEVEL.class, MessageRequestLEVEL.class, ID++, Side.SERVER);
    	NETWORK.registerMessage(HandleRequestNEXP.class, MessageRequestNEXP.class, ID++, Side.SERVER);
		NETWORK.registerMessage(MessageHandlerActivateServer.class, MessageActivate.class, ID++, Side.SERVER);
		NETWORK.registerMessage(HandleRequestQuirk.class, MessageRequestQuirk.class, ID++, Side.SERVER);
		
		NETWORK.registerMessage(MessageEXP.HandleMessageEXP.class, MessageEXP.class, ID++, Side.CLIENT);
        NETWORK.registerMessage(MessageLEVEL.HandleMessageLEVEL.class, MessageLEVEL.class, ID++, Side.CLIENT);
        NETWORK.registerMessage(MessageNEXP.HandleMessageNEXP.class, MessageNEXP.class, ID++, Side.CLIENT);
        NETWORK.registerMessage(MessageQuirk.HandleMessageQuirk.class, MessageQuirk.class, ID++, Side.CLIENT);
    }
    @EventHandler
    public void init(FMLInitializationEvent event)
    {
       LoggingUtil.info("BNHA Mod initialisation started!");
       MinecraftForge.EVENT_BUS.register(new com.oscar.util.handlers.Eventhandler());
       QuirkManage.registerEvents(MinecraftForge.EVENT_BUS);
       proxy.init(event);
    }
    
    @EventHandler
    public void postInit(FMLPostInitializationEvent event)
    {
       LoggingUtil.info("BNHA Mod post initialisation started!");

       proxy.postInit(event);
    }
    
    public static CreativeTabs BNHA = new CreativeTabs("bnha") 
	{
		@Override
		public ItemStack getTabIconItem() 
		{
			return new ItemStack(ModItems.UA_SPORTS_CHESTPLATE);
		}
	};
	
}

