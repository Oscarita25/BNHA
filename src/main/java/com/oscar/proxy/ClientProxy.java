package com.oscar.proxy;

import com.oscar.client.render.gui.Lvlgui;
import com.oscar.client.render.gui.Statsgui;
import com.oscar.client.render.layer.LayerEntityOnPlayerBack;
import com.oscar.models.ClothModel;
import com.oscar.util.handlers.ClientEventHandler;
import com.oscar.util.handlers.KeyInputHandler;
import com.oscar.util.handlers.KeyInputHandler.Keybinds;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ClientProxy implements IProxy {
	
	private static final ClothModel ClothModellayer2 = new ClothModel(0f);;
	private static final ClothModel ClothModellayer1 = new ClothModel(0.1f);
	
	public void registerRenders() {	
		
		LayerEntityOnPlayerBack layer = new LayerEntityOnPlayerBack(Minecraft.getMinecraft().getRenderManager());
		for (RenderPlayer playerRender : Minecraft.getMinecraft().getRenderManager().getSkinMap().values()) {
			
			playerRender.addLayer(layer);
		}
		
		MinecraftForge.EVENT_BUS.register(new Lvlgui(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new Statsgui(Minecraft.getMinecraft()));		
	}
	

	
	public void initKeybindings() {
		Keybinds.initKeybindings();
	    MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
	}

	
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}

	@Override
	public void preInit(FMLPreInitializationEvent event) {
		initKeybindings();		
	}

	@Override
	public void init(FMLInitializationEvent event) {
		registerRenders();
	    MinecraftForge.EVENT_BUS.register(new ClientEventHandler());

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {	
	}

	@Override
	public void serverStarting(FMLServerStartingEvent event) {		
	}

	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) {
		return (ctx.side.isClient() ? Minecraft.getMinecraft().player : null);
	}
	

	@SideOnly(Side.CLIENT)
	public static ModelBase getModel(int id) {
		 
		switch (id) {
		  case 0:
			  return ClothModellayer2;
		  case 1:
			  return ClothModellayer1;  
			}
		 return null;
	}
	
}