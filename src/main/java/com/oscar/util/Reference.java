package com.oscar.util;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;

public class Reference {
	public static final String MOD_ID = "bnha";
	public static final String NAME = "Mine Hero Academia";
	public static final String VERSION = "0.0.1";
	public static final String ACCEPTED_VERSIONS = "[1.12.2]";
	public static final String CLIENT_PROXY_CLASS = "com.oscar.proxy.ClientProxy";
	public static final String COMMON_PROXY_CLASS = "com.oscar.proxy.CommonProxy";
	public static final int TotalQuirks = 2;
	public static final int none = 0;
	public static final int quirkless = 1;
	public static final int explosionquirk = 2;
	
	public static int RandomIntChoose(){
		return (Math.random() <= 0.5) ? 1 : 2;
	}
	
	public static void RandomQuirkChoose(EntityPlayer player) {
			int random = Reference.RandomIntChoose();
			System.out.println(random + "Quirk NONE");
			Quirk.setQuirkID(player,random);
			
			if(Quirk.getQuirkID(player) == Reference.quirkless) {
				System.out.println(random + "Quirk QUIRKLESS");
				Quirk.setQuirkName(player,"Quirkless");
				
			}else if(Quirk.getQuirkID(player) == Reference.explosionquirk) {
				System.out.println(random + "Quirk EXPLOSION");
				Quirk.setQuirkName(player,"Explosion Quirk");
		}
		
	}
}
