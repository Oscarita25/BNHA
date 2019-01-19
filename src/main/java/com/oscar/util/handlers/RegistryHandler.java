package com.oscar.util.handlers;

import com.oscar.init.ModItems;
import com.oscar.util.IHasModel;

import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@EventBusSubscriber
public class RegistryHandler {

	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(ModItems.ITEMS.toArray(new Item[0]));
	}


	@SubscribeEvent
	public static void onModelRegister(ModelRegistryEvent event) {
		for(Item item : ModItems.ITEMS) {
			if(item instanceof IHasModel) {
				((IHasModel)item).registerModels();
			}
		}

	}
/*
	public static void registerEntities()
	{
		ResourceLocation speedGelBallRL = new ResourceLocation(Reference.MOD_ID, "lb_gel_speed_ball");

		EntityEntry speedGelBallEntity = EntityEntryBuilder.create().entity(EntitySpeedGelBall.class)
				.id(speedGelBallRL, 1).name("lb_gel_speed_ball").tracker(64, 20, true).build();

		ForgeRegistries.ENTITIES.register(speedGelBallEntity);
	}
	*/
}
