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
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;

public class ClientProxy extends CommonProxy {

	private static final ClothModel ClothModellayer2 = new ClothModel(0f);
	private static final ClothModel ClothModellayer1 = new ClothModel(0.1f);
	

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
	//returns model
	@Override
	public ModelBase getModel(int id) {
		 
		switch (id) {
		  case 0:
			  return ClothModellayer2;
		  case 1:
			  return ClothModellayer1;  
			}
		 return null;
		}
	
	public static void registerModel() {
	}
	
	
	@Override
	public void registerRenders() {
		MinecraftForge.EVENT_BUS.register(new Lvlgui(Minecraft.getMinecraft()));
		MinecraftForge.EVENT_BUS.register(new Statsgui(Minecraft.getMinecraft()));		
	
	}
	
	@Override
	public void initKeybindings() {
		Keybinds.initKeybindings();
	    MinecraftForge.EVENT_BUS.register(new KeyInputHandler());
	}
	
	@Override
	public void registerClientHandler() {
	    MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
	}
	
	@Override
	public void registerRendersPost() {	
		
		LayerEntityOnPlayerBack layer = new LayerEntityOnPlayerBack(Minecraft.getMinecraft().getRenderManager());
		for (RenderPlayer playerRender : Minecraft.getMinecraft().getRenderManager().getSkinMap().values()) {
			
			playerRender.addLayer(layer);
		}
	}
}