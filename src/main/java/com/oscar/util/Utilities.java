package com.oscar.util;

import java.util.Random;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;

public class Utilities {

	protected static int RandomIntChoose(){return new Random().nextInt(Reference.TotalQuirks);}

	
	public static void RandomQuirkChoose(EntityPlayer player) {
		int random = RandomIntChoose();
		System.out.println(random + " Quirk NONE");
		
		switch (random) {
			case Reference.quirkless:
				System.out.println(random + " Quirk quirkless");
					if(BNHAConfig.Quirks.Quirkless == false) 
						RandomQuirkChoose(player);	
					else
						Quirk.setQuirkID(player,random);
				break;
			case Reference.explosionquirk:
				System.out.println(random + " Quirk Explosion");
					if(BNHAConfig.Quirks.Explosion == false) 
						RandomQuirkChoose(player);
					else
						Quirk.setQuirkID(player,random);
				break;
			case Reference.engine:
				System.out.println(random + " Quirk Engine");
					if(BNHAConfig.Quirks.Engine == false) 
						RandomQuirkChoose(player);
					else
						Quirk.setQuirkID(player,random);
				break;
			case Reference.hellfire:
				System.out.println(random + " Quirk HellFire");
					if(BNHAConfig.Quirks.Hellfire == false) 					
						RandomQuirkChoose(player);
					else
						Quirk.setQuirkID(player,random);
				break;
			case Reference.icequirk:
					System.out.println(random + " Quirk Icequirk");
						if(BNHAConfig.Quirks.Ice == false) 
							RandomQuirkChoose(player);
						else
							Quirk.setQuirkID(player,random);
				break;
			case Reference.electrification:
				System.out.println(random + " Quirk Electrification");
					if(BNHAConfig.Quirks.Electrification == false) 
						RandomQuirkChoose(player);
					else
						Quirk.setQuirkID(player,random);
				break;
			case Reference.tail:
				System.out.println(random + " Quirk Tail");
					if(BNHAConfig.Quirks.Tail == false) 
						RandomQuirkChoose(player);
					else
						Quirk.setQuirkID(player,random);
				break;
			case Reference.steel:
				System.out.println(random + " Quirk Steel");
				if(BNHAConfig.Quirks.Steel == false) 
					RandomQuirkChoose(player);
				else
					Quirk.setQuirkID(player,random);
				break;
			case Reference.hardening:
				System.out.println(random + " Quirk Hardening");
				if(BNHAConfig.Quirks.Hardening == false) 
					RandomQuirkChoose(player);
				else
					Quirk.setQuirkID(player,random);
				break;

            default:
					RandomQuirkChoose(player);
				break;
				
		}


		
	}
	

	public static String getQNamebyID(int quirkid) {
		switch (quirkid) {
		case 1:
			return "Quirkless";
		case 2:
			return "Explosion";
		case 3:
			return "Engine";
		case 4:
			return "Hellfire";
		case 5:
			return "Ice";
		case 6:
			return "Electrification";
		case 7:
			return "Tail";
		case 8:
			return "Steel";
		case 9:
			return "Hardening";
		default:
			return "this should not be displayed";
		}
	}

	
}

	
