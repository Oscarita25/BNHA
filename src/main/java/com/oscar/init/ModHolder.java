package com.oscar.init;

import java.util.ArrayList;
import java.util.List;

import com.oscar.util.Reference;

import net.minecraft.item.Item;
import net.minecraft.potion.Potion;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ModHolder {
	
	public static final List<Item> ITEMS = new ArrayList<Item>();
	
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "ua_sports_chestplate")
    public static final Item UA_SPORTS_CHESTPLATE = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "ua_sports_leggings")
    public static final Item UA_SPORTS_LEGGINGS = null;

    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "deku_armor_chestplate")
    public static final Item DEKU_CHESTPLATE = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "deku_armor_leggings")
    public static final Item DEKU_LEGGINGS = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "deku_armor_feet")
    public static final Item DEKU_FEET = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "bakugo_armor_head")
    public static final Item BAKUGO_HEAD = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "bakugo_armor_chestplate")
    public static final Item BAKUGO_CHESTPLATE = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "bakugo_armor_leggings")
    public static final Item BAKUGO_LEGGINS = null;
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "bakugo_armor_feet")
    public static final Item BAKUGO_FEET = null;

    // Potion Effects
    
    
    @GameRegistry.ObjectHolder(value = Reference.MOD_ID +":"+ "frozen")
 	public static final Potion FROZEN = null;
	


}