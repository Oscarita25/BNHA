package com.oscar.quirks;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;

public class QuirkNone extends Quirk {

	public QuirkNone() {
		super("none");
		
	}

	@Override
	public void onPlayerUse(EntityPlayer player) {
		System.out.println("hi");
	}

}
