package com.oscar.items;

import com.oscar.BNHA;
import com.oscar.init.ModItems;
import com.oscar.util.IHasModel;

import net.minecraft.item.Item;

public class ItemBase extends Item implements IHasModel {

	public ItemBase(String name) {
		setUnlocalizedName(name);
		setRegistryName(name);
		setCreativeTab(BNHA.BNHA);
		
		ModItems.ITEMS.add(this);
	}
	@Override
	public void registerModels() {
		BNHA.proxy.registerItemRenderer(this, 0, "inventory");
	}

}