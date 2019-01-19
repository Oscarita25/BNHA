package com.oscar.proxy;

import com.oscar.init.Keybinds;
import com.oscar.models.ClothModel;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class ClientProxy extends CommonProxy {

	private static final ClothModel ClothModellayer2 = new ClothModel(0f);
	private static final ClothModel ClothModellayer1 = new ClothModel(0.1f);
	
	
	@Override
	public void preInit(FMLPreInitializationEvent event)
	{
		Keybinds.initKeybindings();
		super.preInit(event);
	}

	@Override
	public void init(FMLInitializationEvent event)
	{
		super.init(event);
	}

	@Override
	public void postInit(FMLPostInitializationEvent event)
	{
		super.postInit(event);
	}

	@Override
	public void registerItemRenderer(Item item, int meta, String id) {
		ModelLoader.setCustomModelResourceLocation(item, meta, new ModelResourceLocation(item.getRegistryName(), id));
	}
	
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
	

}