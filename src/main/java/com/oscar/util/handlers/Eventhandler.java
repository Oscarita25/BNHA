package com.oscar.util.handlers;

import java.util.Random;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageEXP;
import com.oscar.data.packets.MessageLEVEL;
import com.oscar.data.packets.MessageNEXP;
import com.oscar.data.packets.MessageQuirk;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirk;
import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQuirk;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.Quirk;
import com.oscar.data.types.quirk.QuirkProvider;
import com.oscar.init.Keybinds;
import com.oscar.quirks.QuirkManage;
import com.oscar.quirks.QuirkNone;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Eventhandler {
	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		IQuirk iquirk = player.getCapability(QuirkProvider.QUIRK_CAP, null);
		
		BNHA.NETWORK.sendToServer(new MessageLEVEL());
		BNHA.NETWORK.sendToServer(new MessageEXP());
		BNHA.NETWORK.sendToServer(new MessageNEXP());
		
		player.sendMessage(new TextComponentString("Your level is: " + level.getlvl()));
		player.sendMessage(new TextComponentString("Your exp is: " + exp.getexp()));
		player.sendMessage(new TextComponentString("Exp needed for the next level: " + (nexp.getnexp() - exp.getexp())));
		
		System.out.println("IS_EMPTY: " + iquirk.getQuirks().isEmpty());
		if(iquirk.getQuirks().isEmpty()) {
			int i = new Random().nextInt(QuirkManage.QUIRKS.size()*3+1);
			
			if(i < QuirkManage.QUIRKS.size()*3) {
				Quirk q = QuirkManage.QUIRKS.get(i%QuirkManage.QUIRKS.size());
				q.init();
				
				try {
					iquirk.addQuirks(q.getClass().newInstance());
				} catch (InstantiationException | IllegalAccessException e) {
					iquirk.addQuirks(q);
				}
				player.sendMessage(new TextComponentString("You got a quirk.It's " + q.getName()));
					
			} else {
				Quirk q = new QuirkNone();
				iquirk.addQuirks(q);
				event.player.sendMessage(new TextComponentString("Bad luck. You got no quirks. Maybe you can find some in the wild"));
			}
			
			System.out.println("QUIRK: " + iquirk.getQuirks().get(0));
			System.out.println("IS_EMPTY: " + iquirk.getQuirks().isEmpty());
		}
		iquirk.getQuirks().get(0).init();
		MinecraftForge.EVENT_BUS.register(iquirk.getQuirks().get(0).getClass());
		
		}

	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		EntityPlayer player = event.getEntityPlayer();
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		ILevel oldLevel = event.getOriginal().getCapability(LevelProvider.LEVEL_CAP, null);
		
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		IExp oldExp = event.getOriginal().getCapability(ExpProvider.EXP_CAP, null);
		
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		INExp oldNExp = event.getOriginal().getCapability(NExpProvider.NEXP_CAP, null);
		
		IQuirk cap = player.getCapability(QuirkProvider.QUIRK_CAP, null);
		IQuirk capold = event.getOriginal().getCapability(QuirkProvider.QUIRK_CAP, null);

		cap.setMaxCooldown(capold.maxCooldown);
		cap.setMaxActivatedTime(capold.maxAct);
		cap.setMultipliers(capold.multipliers);
		cap.setCooldown(capold.cooldown);
		cap.setAct(capold.act);
		cap.setActivated(capold.activated);
		cap.setAvailable(capold.available);
		level.setlvl(oldLevel.getlvl());
		exp.setexp(oldExp.getexp());
		nexp.setnexp(oldNExp.getnexp());
		
		BNHA.NETWORK.sendToServer(new MessageLEVEL());
		BNHA.NETWORK.sendToServer(new MessageEXP());
		BNHA.NETWORK.sendToServer(new MessageNEXP());
		BNHA.NETWORK.sendToServer(new MessageQuirk());
		BNHA.NETWORK.sendTo(new MessageRequestLEVEL(), (EntityPlayerMP) player);
		BNHA.NETWORK.sendTo(new MessageRequestEXP(), (EntityPlayerMP) player);
		BNHA.NETWORK.sendTo(new MessageRequestNEXP(), (EntityPlayerMP) player);
		BNHA.NETWORK.sendTo(new MessageRequestQuirk(),(EntityPlayerMP) player);

	}
	
	
	@SubscribeEvent
	public void onPlayerTick(LivingUpdateEvent event) {
		if (event.getEntity() instanceof EntityPlayer) {
		EntityPlayer player = (EntityPlayer) event.getEntity();
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		if (!player.world.isRemote) {
			if(exp.getexp() >= nexp.getnexp()) {
				level.setlvl(level.getlvl() + 1);
				BNHA.NETWORK.sendToServer(new MessageLEVEL());
				nexp.setnexp(nexp.getnexp()*(level.getlvl() ^ 1));
				BNHA.NETWORK.sendToServer(new MessageNEXP());
		        exp.setexp(0);
				BNHA.NETWORK.sendToServer(new MessageEXP());
				player.sendMessage(new TextComponentString("You reached Level " + level.getlvl()));
				}
			}else return;
		}
	}
	
/*
	@SubscribeEvent
	  public void onExpKill(LivingDeathEvent event)
	  {
	    if (!event.getEntity().world.isRemote)
	    {
	      if (((event.getSource().getTrueSource() instanceof EntityPlayer)))
	      {
	        EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);

	          if (((event.getEntity() instanceof EntityAnimal)) || ((event.getEntity() instanceof EntityWaterMob)) || ((event.getEntity() instanceof EntityAmbientCreature))) {
	            return;
	          }
	          if ((event.getEntity() instanceof EntitySlime))
	          {
	            if ((EntitySlime)event.getEntity() != null)
	            {
	              if (((EntitySlime)event.getEntity()).getSlimeSize() <= 1) {
	                return;
	              }
	              exp.setexp(exp.getexp() + 1);
					BNHA.NETWORK.sendToServer(new MessageEXP());
	            }
	          }
	          else
	          {
	        	exp.setexp(exp.getexp() + 1);
				BNHA.NETWORK.sendToServer(new MessageEXP());
	          }
	        }
	      }
	      else if (((event.getSource().getImmediateSource() instanceof EntityThrowable)) && ((event.getSource().getTrueSource() instanceof EntityPlayer)))
	      {
	        EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);

	          if (((event.getEntity() instanceof EntityAnimal)) || ((event.getEntity() instanceof EntityWaterMob)) || ((event.getEntity() instanceof EntityAmbientCreature))) {
	            return;
	          }
	          if ((event.getEntity() instanceof EntitySlime))
	          {
	            if ((EntitySlime)event.getEntity() != null)
	            {
	              if (((EntitySlime)event.getEntity()).getSlimeSize() <= 1) {
	                return;
	              }
	              exp.setexp(exp.getexp() + 1);
					BNHA.NETWORK.sendToServer(new MessageEXP());
	            }
	          }
	          else
	          {
	        	exp.setexp(exp.getexp() + 1);
				BNHA.NETWORK.sendToServer(new MessageEXP());
	          }
	        }
	      
	      else if (((event.getSource().getImmediateSource() instanceof EntityArrow)) && ((event.getSource().getTrueSource() instanceof EntityPlayer)))
	      {
	        EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);

	          if (((event.getEntity() instanceof EntityAnimal)) || ((event.getEntity() instanceof EntityWaterMob)) || ((event.getEntity() instanceof EntityAmbientCreature))) {
	        	  return;
	          }
	          if ((event.getEntity() instanceof EntitySlime))
	          {
	            if ((EntitySlime)event.getEntity() != null)
	            {
	              if (((EntitySlime)event.getEntity()).getSlimeSize() <= 1) {
	                return;
	              }
	              exp.setexp(exp.getexp() + 1);
					BNHA.NETWORK.sendToServer(new MessageEXP());
	            }
	          }
	          else
	          {
	        	exp.setexp(exp.getexp() + 1);
				BNHA.NETWORK.sendToServer(new MessageEXP());
	          }
	        }
	      
	    }
	  */
	    
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public static void onKeyInput(ClientTickEvent event) {
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
		if(keyBindings[0].isPressed()){
			Minecraft.getMinecraft().player.sendChatMessage("HEEEELLLOOOO");
			System.out.println("KEY Y");
		//	BNHA.NETWORK.sendToServer(new MessageActivate());
		}
	}
}
