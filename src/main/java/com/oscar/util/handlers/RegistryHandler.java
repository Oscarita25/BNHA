package com.oscar.util.handlers;

import com.oscar.items.ClothArmor;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.util.EnumHelper;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class RegistryHandler {
	
	public static final ItemArmor.ArmorMaterial UA_SPORTS_MAT = 
			EnumHelper.addArmorMaterial
         (Reference.MOD_ID +":ua_sports",Reference.MOD_ID +":ua_sports",15,
		 new int[]{1, 4, 5, 2},12,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,(float) 0);	
	
	public static  final ItemArmor.ArmorMaterial BAKUGO_ARMOR_MAT =
			EnumHelper.addArmorMaterial
		 (Reference.MOD_ID +":bakugo_armor",Reference.MOD_ID +":bakugo_armor",15,
		 new int[]{1, 4, 5, 2},12,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,(float) 0);
	
	public static final ItemArmor.ArmorMaterial DEKU_ARMOR_MAT =
			EnumHelper.addArmorMaterial
		 (Reference.MOD_ID +":deku_armor",Reference.MOD_ID +":deku_armor",15,
		 new int[]{1, 4, 5, 2},12,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,(float) 0);
	
	
	@SubscribeEvent
	public static void onItemRegister(RegistryEvent.Register<Item> event) {
		event.getRegistry().registerAll(
				new ClothArmor("ua_sports_chestplate",UA_SPORTS_MAT,1,EntityEquipmentSlot.CHEST),
				new ClothArmor("ua_sports_leggings",UA_SPORTS_MAT,2,EntityEquipmentSlot.LEGS),
				new ClothArmor("deku_armor_chestplate",DEKU_ARMOR_MAT,1,EntityEquipmentSlot.CHEST),
				new ClothArmor("deku_armor_leggings",DEKU_ARMOR_MAT,2,EntityEquipmentSlot.LEGS),
				new ClothArmor("deku_armor_feet",DEKU_ARMOR_MAT,1,EntityEquipmentSlot.FEET),
				new ClothArmor("bakugo_armor_head",BAKUGO_ARMOR_MAT,1,EntityEquipmentSlot.HEAD),
				new ClothArmor("bakugo_armor_chestplate",BAKUGO_ARMOR_MAT,1,EntityEquipmentSlot.CHEST),
				new ClothArmor("bakugo_armor_leggings",BAKUGO_ARMOR_MAT,2,EntityEquipmentSlot.LEGS),
				new ClothArmor("bakugo_armor_feet",BAKUGO_ARMOR_MAT,1,EntityEquipmentSlot.FEET));
		
		LoggingUtil.BNHALogger.info("Registered Items");
	}
	
	
	@SubscribeEvent
	public static void registerModels(ModelRegistryEvent event)
	{
		

		ForgeRegistries.ITEMS.getValuesCollection().stream().filter(i -> i.getRegistryName().getResourceDomain().equals(Reference.MOD_ID)).forEach(
				i -> ModelLoader.setCustomModelResourceLocation(i, 0, new ModelResourceLocation(i.getRegistryName(), "inventory")));
		
		LoggingUtil.BNHALogger.info("Registered models");
	}



	
}
