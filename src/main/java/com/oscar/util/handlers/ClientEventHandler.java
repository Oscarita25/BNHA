package com.oscar.util.handlers;

import com.oscar.init.ModHolder;
import com.oscar.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID, value = Side.CLIENT)
public class ClientEventHandler {	
	
	
    @SubscribeEvent
    public static void registerItemRenderer(ModelRegistryEvent event) {
		for(Item item : ModHolder.ITEMS) {
			ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(item.getRegistryName(), "inventory"));
		}
    }
	
	

}
