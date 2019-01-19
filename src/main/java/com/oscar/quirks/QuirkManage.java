package com.oscar.quirks;

import java.util.ArrayList;
import java.util.List;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.eventhandler.EventBus;

public class QuirkManage {
	public static List<Quirk> QUIRKS = new ArrayList<Quirk>();
	
	//Quirks
	
		public static ExplosionQuirk explosion;


		public static void init() {
			explosion = new ExplosionQuirk();

		}
		
		public static void registerEvents(EventBus bus) {
			for(Quirk q:QUIRKS) {
				bus.register(q.getClass());
			}
		}
		
		public static Quirk getQuirkByName(String name) {
			for(Quirk q:QUIRKS) {
				if(q.getName() == name || name == q.getName() || (q.getName().indexOf(name) == 0 && name.indexOf(q.getName()) == 0)) {
					return q;
				}
			}
			return null;
		}

		public static void useByName(String quirk, EntityPlayer player) {
			quirk = quirk.replaceAll(" ", "");
			for(Quirk q:QUIRKS) {
				if(q.getName() == quirk || quirk == q.getName() || (q.getName().indexOf(quirk) == 0 && quirk.indexOf(q.getName()) == 0)) {
					q.onPlayerUse(player);
				}
			}
	}
}
