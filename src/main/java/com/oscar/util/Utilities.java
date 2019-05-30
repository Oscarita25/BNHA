package com.oscar.util;

import java.util.Random;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;

public class Utilities {
	
	
	public static int RandomIntChoose(){
		Random rand = new Random();

		return rand.nextInt(Reference.TotalQuirks);
	}

	
	public static void RandomQuirkChoose(EntityPlayer player) {
		int random = Utilities.RandomIntChoose();
		System.out.println(random + " Quirk NONE");
		Quirk.setQuirkID(player,random);
		
		if(Quirk.getQuirkID(player) == Reference.quirkless) {
			System.out.println(random + " Quirk quirkless");				
		}
		if(Quirk.getQuirkID(player) == Reference.explosionquirk) {
			
			System.out.println(random + " Quirk Explosion");
		}
		if(Quirk.getQuirkID(player) == Reference.engine) {
			
			System.out.println(random + " Quirk Engine");
		}
		if(Quirk.getQuirkID(player) == Reference.hellfire) {
			
			System.out.println(random + " Quirk HellFire");
		}
		if(Quirk.getQuirkID(player) == Reference.icequirk) {
			
			System.out.println(random + " Quirk Icequirk");
		}
		if(Quirk.getQuirkID(player) == Reference.electrification) {
			
			System.out.println(random + " Quirk Electrification");
		}
		if(Quirk.getQuirkID(player) == Reference.tail) {
			
			System.out.println(random + " Quirk Tail");
		}
		
		if(Quirk.getQuirkID(player) == Reference.none) {
			RandomQuirkChoose(player);
		}
	}
	

	public static String getQNamebyID(int quirkid) {
		if(quirkid == 1)
			return "Quirkless";
		if(quirkid == 2)
			return "Explosion";
		if(quirkid == 3)
			return "Engine";
		if(quirkid == 4)
			return "Hellfire";
		if(quirkid == 5)
			return "Ice";
		if(quirkid == 6)
			return "Electrification";
		if(quirkid == 7)
			return "Tail";
		else
			return "this should not be displayed";
	}

}
