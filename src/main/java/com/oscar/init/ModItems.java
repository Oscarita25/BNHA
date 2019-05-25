package com.oscar.init;

import java.util.ArrayList;
import java.util.List;

import com.oscar.items.ClothArmor;
import com.oscar.util.Reference;

import net.minecraft.init.SoundEvents;
import net.minecraft.inventory.EntityEquipmentSlot;
import net.minecraft.item.Item;
import net.minecraft.item.ItemArmor;
import net.minecraftforge.common.util.EnumHelper;

public class ModItems {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();

	//Materials
	public static final ItemArmor.ArmorMaterial UA_SPORTS_MAT = 
			EnumHelper.addArmorMaterial
         (Reference.MOD_ID +":ua_sports",Reference.MOD_ID +":ua_sports",15,
		 new int[]{1, 4, 5, 2},12,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,(float) 0);	
	
	public static final ItemArmor.ArmorMaterial BAKUGO_ARMOR_MAT =
			EnumHelper.addArmorMaterial
		 (Reference.MOD_ID +":bakugo_armor",Reference.MOD_ID +":bakugo_armor",15,
		 new int[]{1, 4, 5, 2},12,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,(float) 0);
	
	public static final ItemArmor.ArmorMaterial DEKU_ARMOR_MAT =
			EnumHelper.addArmorMaterial
		 (Reference.MOD_ID +":deku_armor",Reference.MOD_ID +":deku_armor",15,
		 new int[]{1, 4, 5, 2},12,SoundEvents.ITEM_ARMOR_EQUIP_LEATHER,(float) 0);
	

	
	//Items (Clothing Pieces)
	public static final Item UA_SPORTS_CHESTPLATE = 
		new ClothArmor("ua_sports_chestplate",UA_SPORTS_MAT,1,EntityEquipmentSlot.CHEST);

	public static final Item UA_SPORTS_LEGGINGS = 
		new ClothArmor("ua_sports_leggings",UA_SPORTS_MAT,2,EntityEquipmentSlot.LEGS);	
	
	
	public static final Item DEKU_CHESTPLATE = 
		new ClothArmor("deku_armor_chestplate",DEKU_ARMOR_MAT,1,EntityEquipmentSlot.CHEST);
	
	public static final Item DEKU_LEGGINGS = 
		new ClothArmor("deku_armor_leggings",DEKU_ARMOR_MAT,2,EntityEquipmentSlot.LEGS);
	
	public static final Item DEKU_FEET = 
		new ClothArmor("deku_armor_feet",DEKU_ARMOR_MAT,1,EntityEquipmentSlot.FEET);
	
	
	public static final Item BAKUGO_HEAD = 
		new ClothArmor("bakugo_armor_head",BAKUGO_ARMOR_MAT,1,EntityEquipmentSlot.HEAD);
	
	public static final Item BAKUGO_CHESTPLATE = 
		new ClothArmor("bakugo_armor_chestplate",BAKUGO_ARMOR_MAT,1,EntityEquipmentSlot.CHEST);
	
	public static final Item BAKUGO_LEGGINGS = 
		new ClothArmor("bakugo_armor_leggings",BAKUGO_ARMOR_MAT,2,EntityEquipmentSlot.LEGS);
	
	public static final Item BAKUGO_FEET = 
		new ClothArmor("bakugo_armor_feet",BAKUGO_ARMOR_MAT,1,EntityEquipmentSlot.FEET);

}