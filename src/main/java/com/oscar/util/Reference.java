package com.oscar.util;

import java.util.Random;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;

public class Reference {
	public static final String MOD_ID = "bnha";
	public static final String NAME = "Mine Hero Academia";
	public static final String VERSION = "0.0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "com.oscar.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.oscar.proxy.CommonProxy";
	public static final int TotalQuirks = 7;
	public static final int none = 0;
	public static final int quirkless = 1;
	public static final int explosionquirk = 2;
	public static final int engine = 3;
	public static final int hellfire = 4;
	public static final int icequirk = 5;
	public static final int electrification = 6;
	public static final int tail = 7;
	
	public static int RandomIntChoose(){
		Random rand = new Random();

		return rand.nextInt(Reference.TotalQuirks);
	}
	
	public static void RandomQuirkChoose(EntityPlayer player) {
			int random = Reference.RandomIntChoose();
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
