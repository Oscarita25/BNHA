package com.oscar.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.minecraft.client.Minecraft;
import net.minecraft.util.text.TextComponentString;

public class CombAtt {
	
	public static List<String> active_comb; 
	public static List<String> explosion_comb;  
	public static List<String> hellfire_comb ;  
	
	
	public static void init() {
		active_comb = new ArrayList<String>();
		explosion_comb = Arrays.asList(new String[]{"L","R","R","L","R"});
		hellfire_comb = Arrays.asList(new String[] {"L","R","LR"});
	}
	public static void onCombo(String key) {
			switch(key) {
				case "L":
					active_comb.add("L");
					if(!(checkForComb().equals("no comb"))) {
						Minecraft.getMinecraft().player.sendMessage(new TextComponentString(checkForComb()));
					}
					break;
				case "R":
					active_comb.add("R");
					if(!(checkForComb().equals("no comb"))) {
						Minecraft.getMinecraft().player.sendMessage(new TextComponentString(checkForComb()));
					}
					break;
				case "LR":
					active_comb.add("LR");
					if(!(checkForComb().contains("no comb"))) {
						Minecraft.getMinecraft().player.sendMessage(new TextComponentString(checkForComb()));
					}
					break;
				default:
					System.out.println("ERROR : Wrong Key Argument Passed");
					break;
			}
			

	}
	
	public static void clearCombo() {
		active_comb.clear();
	}
	
	
	public static String checkForComb() {
		if(active_comb.equals(explosion_comb)) {
			return "explosion_comb";			
		}
		if(active_comb == hellfire_comb) {
			
		}
		return "no comb";
	}
}
