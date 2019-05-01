package com.oscar.util.handlers;

import com.oscar.BNHA;
import com.oscar.client.render.QuirkPlayerRender;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQName;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;
import com.oscar.data.types.quirk.name.QNameProvider;
import com.oscar.util.Reference;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.text.TextComponentString;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;


public class Eventhandler {


	@SubscribeEvent
	public void RenderPlayerEvent(RenderPlayerEvent.Pre event) {
		
		RenderingRegistry.registerEntityRenderingHandler(EntityPlayer.class, new QuirkPlayerRender(event.getRenderer().getRenderManager()));
	}
	
	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		IQName iqname = player.getCapability(QNameProvider.QURIKNAME_CAP, null);
		IQuirkID iqID = player.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
		
		BNHA.NETWORK.sendToServer(new MessageRequestLEVEL());
		BNHA.NETWORK.sendToServer(new MessageRequestEXP());
		BNHA.NETWORK.sendToServer(new MessageRequestNEXP());
		BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());

		player.sendMessage(new TextComponentString("Your level is: " + level.getlvl()));
		player.sendMessage(new TextComponentString("Your exp is: " + exp.getexp()));
		player.sendMessage(new TextComponentString("Exp needed for the next level: " + (nexp.getnexp() - exp.getexp())));
		
		if(!player.world.isRemote) {

			if(iqID.getID() == Reference.none) {
				//Random quirk choose
				Reference.RandomQuirkChoose(player);
			}
			
			if(iqID.getID() != Reference.none) {
				player.sendMessage(new TextComponentString("Your Quirk is: "+ iqname.getname()));
				
			}else {
			
				player.sendMessage(new TextComponentString("You are "+ iqname.getname()));
				}
			
			if(iqID.getID() == Reference.engine || iqID.getID() == Reference.tail){
				QuirkPlayerRender.setModel(true);
			}
			
			}
			

		}

	
	
	@SubscribeEvent
	public void onPlayerClone(PlayerEvent.Clone event) {
		//copy's capabilities
		EntityPlayer player = event.getEntityPlayer();
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		ILevel oldLevel = event.getOriginal().getCapability(LevelProvider.LEVEL_CAP, null);
		
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		IExp oldExp = event.getOriginal().getCapability(ExpProvider.EXP_CAP, null);
		
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		INExp oldNExp = event.getOriginal().getCapability(NExpProvider.NEXP_CAP, null);
		
		IQName iqname = player.getCapability(QNameProvider.QURIKNAME_CAP, null);
		IQName oldIQName = event.getOriginal().getCapability(QNameProvider.QURIKNAME_CAP, null);
		
		IQMaxAct iqmact = player.getCapability(QMaxActProvider.QMaxAct_CAP, null);
		IQMaxAct oldiqmact =  event.getOriginal().getCapability(QMaxActProvider.QMaxAct_CAP, null);

		IQAct iqact = player.getCapability(QActProvider.QACT_CAP, null);
		IQAct oldiqact =  event.getOriginal().getCapability(QActProvider.QACT_CAP, null);

		IQCool iqcool = player.getCapability(QCoolProvider.COOL_CAP, null);
		IQCool oldiqcool =  event.getOriginal().getCapability(QCoolProvider.COOL_CAP, null);

		IQMaxCool iqmcool = player.getCapability(QMaxCoolProvider.MAXCOOl_CAP, null);
		IQMaxCool oldiqmcool =  event.getOriginal().getCapability(QMaxCoolProvider.MAXCOOl_CAP, null);

		IQuirkID iqid = player.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
		IQuirkID oldiqid =  event.getOriginal().getCapability(QuirkIDProvider.QUIRKID_CAP, null);


		
		if(event.isWasDeath()) {
		iqname.setname(oldIQName.getname());
		iqmact.setmact(oldiqmact.getmact());
		iqact.setact(oldiqact.getact());
		iqcool.setcool(oldiqcool.getcool());
		iqmcool.setmcool(oldiqmcool.getmcool());
		iqid.setID(oldiqid.getID());
		level.setlvl(oldLevel.getlvl());
		exp.setexp(oldExp.getexp());
		nexp.setnexp(oldNExp.getnexp());

		}
	}
	
	
	@SubscribeEvent
	public void onPlayerTick(PlayerTickEvent event) {
		EntityPlayer player = event.player;
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		
		if (!player.world.isRemote) {

			//checking for level ups
			if(exp.getexp() >= nexp.getnexp()) {
				level.setlvl(level.getlvl() + 1);
				nexp.setnexp(nexp.getnexp()*(level.getlvl() ^ 1));
		        exp.setexp(0);
				player.sendMessage(new TextComponentString("You reached Level " + level.getlvl()));
				}
			}else return;
		
	}
	

 //Exp from killing entities
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
	            }
	          }
	          else
	          {
	        	exp.setexp(exp.getexp() + 1);
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
	            }
	          }
	          else
	          {
	        	exp.setexp(exp.getexp() + 1);
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
	            }
	          }
	          else
	          {
	        	exp.setexp(exp.getexp() + 1);
	          }
	        }
	      
	    }
	  
	    

}
