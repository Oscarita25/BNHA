package com.oscar.util;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageQuirk;
import com.oscar.data.types.interfaces.IQuirk;

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
	
	public static void RandomQuirkChoose(IQuirk iquirk,EntityPlayer player) {
		if(iquirk.getQuirkID() == Reference.none) {
			int random = Reference.RandomIntChoose();
			System.out.println(random + "Quirk NONE");
			iquirk.setQuirkID(random);
			BNHA.NETWORK.sendToServer(new MessageQuirk());
			
			if(iquirk.getQuirkID() == Reference.quirkless) {
				System.out.println(random + "Quirk QUIRKLESS");
				iquirk.setName("Quirkless");
				BNHA.NETWORK.sendToServer(new MessageQuirk());
				
			}else if(iquirk.getQuirkID() == Reference.explosionquirk) {
				System.out.println(random + "Quirk EXPLOSION");
				iquirk.setName("Explosion Quirk");
				BNHA.NETWORK.sendToServer(new MessageQuirk());
		}
			
			if(iquirk.getQuirkID() == Reference.quirkless) {
				player.sendMessage(new TextComponentString("You are " + iquirk.getName()));
			}else {
				player.sendMessage(new TextComponentString("Your Quirk is: " + iquirk.getName()));
				}
			}
	}
}
