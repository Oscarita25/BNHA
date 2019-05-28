package com.oscar.util.handlers;

import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.model.ModelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;
import com.oscar.util.Reference;
import com.oscar.util.Utilities;

import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAmbientCreature;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityWaterMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.PlayerEvent.PlayerLoggedInEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.PlayerTickEvent;


public class Eventhandler {

	
	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerLoggedInEvent event) {
		EntityPlayer player = event.player;
		EntityPlayerMP p = (EntityPlayerMP) event.player;
		
		//Capabilities and Packets
		ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
		IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
		INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
		IQuirkID iqID = player.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
		IModelID model = player.getCapability(ModelProvider.MODEL_CAP, null);

		
		if(!player.world.isRemote) {
			
			level.setlvl(level.getlvl());
			exp.setexp(exp.getexp());
			nexp.setnexp(nexp.getnexp());
			iqID.setID(iqID.getID());
			model.setModelID(model.getModelID(), p);;

			//Join Message (Status Info)
			player.sendMessage(new TextComponentString("Your level is: " + level.getlvl()));
			player.sendMessage(new TextComponentString("Your exp is: " + exp.getexp()));
			player.sendMessage(new TextComponentString("Exp needed for the next level: " + (nexp.getnexp() - exp.getexp())));	
			player.sendMessage(new TextComponentString(TextFormatting.DARK_RED +"DEBUG MODEL: " + model.getModelID()));
			
			//Choose Quirk if there is none
			if(iqID.getID() == Reference.none) {Utilities.RandomQuirkChoose(player);}
			
			//Join Message which Quirk you have (Status Info)
			if(iqID.getID() != Reference.none) {
				player.sendMessage(new TextComponentString("Your Quirk is: "+ TextFormatting.BOLD + Utilities.getQNamebyID(iqID.getID())));
				
			}else {
			
				player.sendMessage(new TextComponentString("You are "+ TextFormatting.BOLD + Utilities.getQNamebyID(iqID.getID())));
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
		
		IModelID modelid = player.getCapability(ModelProvider.MODEL_CAP, null);
		IModelID oldmodelid =  event.getOriginal().getCapability(ModelProvider.MODEL_CAP, null);
		
		
		if(event.isWasDeath()) {
		iqmact.setmact(oldiqmact.getmact());
		iqact.setact(oldiqact.getact());
		iqcool.setcool(oldiqcool.getcool());
		iqmcool.setmcool(oldiqmcool.getmcool());
		iqid.setID(oldiqid.getID());
		level.setlvl(oldLevel.getlvl());
		exp.setexp(oldExp.getexp());
		nexp.setnexp(oldNExp.getnexp());
		modelid.setModelID(oldmodelid.getModelID(), (EntityPlayerMP) player);
		
		
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
				nexp.setnexp((nexp.getnexp() * 15)/10);
		        exp.setexp(0);
				player.sendMessage(new TextComponentString("You reached Level " + level.getlvl()));
				}
			
			}else return;
		
	}
	

 //experience from killing entities
	@SubscribeEvent
	  public void onExpKill(LivingDeathEvent event)
	  {
	    if (!event.getEntity().world.isRemote)
	    {
	    	
	    //Killed By Player with >> Close Combat <<
	      if (((event.getSource().getTrueSource() instanceof EntityPlayer)))
	      {
	        EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);

	        //No experience from friendlies :D
	          if (((event.getEntity() instanceof EntityAnimal)) || ((event.getEntity() instanceof EntityWaterMob)) || ((event.getEntity() instanceof EntityAmbientCreature))) {
	            return;
	          }
	          //experience from Slimes 
	          if ((event.getEntity() instanceof EntitySlime)){
	            if ((EntitySlime)event.getEntity() != null){
	            	//The Smallest Slimes don't give experience
	              if (((EntitySlime)event.getEntity()).getSlimeSize() <= 1) {return;}
	              
	              /*
	               * How much experience a Slime should give:
	               *  1 Exp
	               */
	              exp.setexp(exp.getexp() + 1);
	            }
	          }
	          else{
	        	 /*
	        	  * experience By Everything else that is
	        	  *  
	        	  * 	unfriendly(Zombies,Skeletons,...) 
	        	  * 		or 
	        	  * 	neutral(IronGolem,..)
	        	  * 
	        	  *  1 Exp
	        	  */
	        	exp.setexp(exp.getexp() + 1);
	          }
	        }
	      }
	    
	    //Killed by Player with >> Throwable <<
	      else if (((event.getSource().getImmediateSource() instanceof EntityThrowable)) && ((event.getSource().getTrueSource() instanceof EntityPlayer))){
	    	  
	        EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
	        
	        //No experience from friendlies :D
	          if (((event.getEntity() instanceof EntityAnimal)) || ((event.getEntity() instanceof EntityWaterMob)) || ((event.getEntity() instanceof EntityAmbientCreature))) {
	            return;
	          }
	          
	          //experience from Slimes 
	          if ((event.getEntity() instanceof EntitySlime)){
	            if ((EntitySlime)event.getEntity() != null){
	            	//The Smallest Slimes don't give experience
	            	if (((EntitySlime)event.getEntity()).getSlimeSize() <= 1) {return;}
	            	
		            /*
		             * How much experience a Slime should give:
		             *  1 Exp
		             */
	            	exp.setexp(exp.getexp() + 1);
	            }
	          }
	          else{
	        	 /*
	        	  * experience By Everything else that is
	        	  *  
	        	  * 	unfriendly(Zombies,Skeletons,...) 
	        	  * 		or 
	        	  * 	neutral(IronGolem,..)
	        	  * 
	        	  *  1 Exp
	        	  */
	        	exp.setexp(exp.getexp() + 1);
	          }
	        }
	      
	    //Killed by Player with >> Arrow <<
	      else if (((event.getSource().getImmediateSource() instanceof EntityArrow)) && ((event.getSource().getTrueSource() instanceof EntityPlayer)))
	      {
	        EntityPlayer player = (EntityPlayer)event.getSource().getTrueSource();
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);

	        //No experience from friendlies :D
	          if (((event.getEntity() instanceof EntityAnimal)) || ((event.getEntity() instanceof EntityWaterMob)) || ((event.getEntity() instanceof EntityAmbientCreature))) {
	        	  return;
	          }
	          
	          //experience from Slimes 
	          if ((event.getEntity() instanceof EntitySlime)){
	            if ((EntitySlime)event.getEntity() != null){
	            	//The Smallest Slimes don't give experience
	              if (((EntitySlime)event.getEntity()).getSlimeSize() <= 1) {return;}
	              
		          /*
		           * How much experience a Slime should give:
		           *  1 Exp
		           */
	              exp.setexp(exp.getexp() + 1);
	            }
	          }
	          else{
		         /*
		       	  * experience By Everything else that is
		       	  *  
		       	  * 	unfriendly(Zombies,Skeletons,...) 
		       	  * 		or 
		       	  * 	neutral(IronGolem,..)
		       	  * 
		       	  *  1 Exp
		       	  */    	  
	        	exp.setexp(exp.getexp() + 1);
	          }
	        }
	      
	    }
	  
	    

}
