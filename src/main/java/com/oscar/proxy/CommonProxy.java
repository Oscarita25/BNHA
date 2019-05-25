package com.oscar.proxy;

import com.oscar.BNHA;
import com.oscar.data.Capabilities;
import com.oscar.data.packets.MessageEXP;
import com.oscar.data.packets.MessageLEVEL;
import com.oscar.data.packets.MessageModel;
import com.oscar.data.packets.MessageNEXP;
import com.oscar.data.packets.MessageQuirkID;
import com.oscar.data.packets.MessageRequestActivate;
import com.oscar.data.packets.MessageRequestActivate.HandleRequestActivate;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestEXP.HandleRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestLEVEL.HandleRequestLEVEL;
import com.oscar.data.packets.MessageRequestModel;
import com.oscar.data.packets.MessageRequestModel.HandleRequestModel;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestNEXP.HandleRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.packets.MessageRequestQuirkID.HandleRequestQuirkID;
import com.oscar.data.types.exp.ExpFactory;
import com.oscar.data.types.exp.ExpStorage;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.level.LevelFactory;
import com.oscar.data.types.level.LevelStorage;
import com.oscar.data.types.model.ModelFactory;
import com.oscar.data.types.model.ModelStorage;
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
import com.oscar.quirk.CustomSpawnable;
import com.oscar.quirk.Icicle;
import com.oscar.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.fml.common.registry.EntityRegistry;
import net.minecraftforge.fml.relauncher.Side;
import obsidiansuite.obsidianAPI.registry.AnimationRegistry;

public class CommonProxy{ 

    public static int ID = 0;
    public static int nextEntityID = 1;
	
    //client proxy methods that are not being used in the common proxy:
	public void registerItemRenderer(Item item, int meta, String id) {}
	public ModelBase getModel(int id) {return null;}
	public void registerRenders() {}
	public void initKeybindings() {}	
	public void registerClientHandler() {}
	public void registerRendersPost() {}

	// methods that are actually being executed in the common proxy: 
	public void registerAnimations() {AnimationRegistry.init();}
	public void registerPackets() {
	       BNHA.NETWORK.registerMessage(HandleRequestEXP.class, MessageRequestEXP.class, ID++, Side.SERVER);
	       BNHA.NETWORK.registerMessage(HandleRequestLEVEL.class, MessageRequestLEVEL.class, ID++, Side.SERVER);
	       BNHA.NETWORK.registerMessage(HandleRequestNEXP.class, MessageRequestNEXP.class, ID++, Side.SERVER);
	       BNHA.NETWORK.registerMessage(HandleRequestActivate.class, MessageRequestActivate.class, ID++, Side.SERVER);
	       BNHA.NETWORK.registerMessage(HandleRequestQuirkID.class, MessageRequestQuirkID.class, ID++, Side.SERVER);
	       BNHA.NETWORK.registerMessage(HandleRequestModel.class, MessageRequestModel.class, ID++, Side.SERVER);
	       
	       BNHA.NETWORK.registerMessage(MessageEXP.HandleMessageEXP.class, MessageEXP.class, ID++, Side.CLIENT);
	       BNHA.NETWORK.registerMessage(MessageLEVEL.HandleMessageLEVEL.class, MessageLEVEL.class, ID++, Side.CLIENT);
	       BNHA.NETWORK.registerMessage(MessageNEXP.HandleMessageNEXP.class, MessageNEXP.class, ID++, Side.CLIENT);
	       BNHA.NETWORK.registerMessage(MessageQuirkID.HandleMessageQuirkID.class, MessageQuirkID.class, ID++, Side.CLIENT);
	       BNHA.NETWORK.registerMessage(MessageModel.HandleMessageModel.class, MessageModel.class, ID++, Side.CLIENT);		
	}
	
	public void registerCapabilites() {
	       CapabilityManager.INSTANCE.register(ILevel.class, new LevelStorage(), new LevelFactory());
	       CapabilityManager.INSTANCE.register(IExp.class, new ExpStorage(), new ExpFactory());
	       CapabilityManager.INSTANCE.register(INExp.class, new NExpStorage(), new NExpFactory());
	       CapabilityManager.INSTANCE.register(IQuirkID.class, new QuirkIDStorage(), new QuirkIDFactory());
	       CapabilityManager.INSTANCE.register(IQMaxCool.class, new QMaxCoolStorage(), new QMaxCoolFactory());
	       CapabilityManager.INSTANCE.register(IQCool.class, new QCoolStorage(), new QCoolFactory());
	       CapabilityManager.INSTANCE.register(IQAct.class, new QActStorage(), new QActFactory());
	       CapabilityManager.INSTANCE.register(IQMaxAct.class, new QMaxActStorage(), new QMaxActFactory());
	       CapabilityManager.INSTANCE.register(IModelID.class, new ModelStorage(), new ModelFactory());		
	       
	       MinecraftForge.EVENT_BUS.register(new Capabilities());
	}

	public void registerEntities() {
        registerEntity(CustomSpawnable.class, "Hellfire");
        registerEntity(Icicle.class, "Icicle");				
	}
	
	private void registerEntity(Class<? extends Entity> entity, String name) {
		EntityRegistry.registerModEntity(new ResourceLocation(Reference.MOD_ID, name), entity, name, nextEntityID++,BNHA.instance, 64, 20, true);
	}	
}
