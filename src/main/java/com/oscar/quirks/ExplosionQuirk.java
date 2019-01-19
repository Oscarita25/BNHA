package com.oscar.quirks;

import com.oscar.data.types.quirk.Quirk;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ServerTickEvent;

public class ExplosionQuirk extends Quirk{
	private static EntityPlayer p;
	
	public ExplosionQuirk() {
		super("explosion");
		setMaxCooldown(120);
		setMaxActivatedTime(1);		
		init();
	}

	
	@Override
	public void onPlayerUse(EntityPlayer player) {
		p = player;
		if(available) {
			//BNHA.NETWORK.sendToServer(new MessageExplosion(level * 0.2F));
			player.sendMessage(new TextComponentString("YOU USED IT!!!"));
			available = false;
		}
	}	

	@SubscribeEvent
	public static void tick(ServerTickEvent event) {
		if(!available) {
			cooldown++;
			if(cooldown >= maxCooldown) {
				available = true;
				cooldown = 0;
			}
		}

	}

}
