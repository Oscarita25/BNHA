package com.oscar.data;

import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.model.ModelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;
import com.oscar.data.types.stamina.StaminaProvidor;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Capabilities {
	
	/*
	 * 		Attaching Capabilities on the Player
	 * 
	 */
	
	public static final ResourceLocation LEVEL_CAP = new ResourceLocation(Reference.MOD_ID, "level");
	public static final ResourceLocation EXP_CAP = new ResourceLocation(Reference.MOD_ID, "expc");
	public static final ResourceLocation NEXP_CAP = new ResourceLocation(Reference.MOD_ID, "expn");
	public static final ResourceLocation QUIRKNAME_CAP = new ResourceLocation(Reference.MOD_ID, "quirkname"); 
	public static final ResourceLocation QMaxAct_CAP = new ResourceLocation(Reference.MOD_ID, "qmaxact"); 
	public static final ResourceLocation QACT_CAP = new ResourceLocation(Reference.MOD_ID, "qact"); 
	public static final ResourceLocation COOL_CAP = new ResourceLocation(Reference.MOD_ID, "qcooldown"); 
	public static final ResourceLocation MAXCOOl_CAP = new ResourceLocation(Reference.MOD_ID, "qmaxcooldown"); 
	public static final ResourceLocation QUIRKID_CAP = new ResourceLocation(Reference.MOD_ID, "quirkid"); 
	public static final ResourceLocation MODELID = new ResourceLocation(Reference.MOD_ID, "modelid");
	public static final ResourceLocation STAMINA_CAP = new ResourceLocation(Reference.MOD_ID, "stamina");
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

		if (canHaveAttributes(event.getObject())) {
			EntityLivingBase ent = (EntityLivingBase) event.getObject();
			
			if (ent instanceof EntityPlayer) {
				event.addCapability(LEVEL_CAP, new LevelProvider());				
				event.addCapability(EXP_CAP, new ExpProvider());
				event.addCapability(NEXP_CAP, new NExpProvider());
				
				LoggingUtil.BNHALogger.info("added Level System Capability's");

				event.addCapability(QUIRKID_CAP, new QuirkIDProvider());
				event.addCapability(MAXCOOl_CAP, new QMaxCoolProvider()); 
				event.addCapability(COOL_CAP, new QCoolProvider()); 
				event.addCapability(QACT_CAP, new QActProvider()); 
				event.addCapability(QMaxAct_CAP, new QMaxActProvider());
				event.addCapability(STAMINA_CAP, new StaminaProvidor());
				
				LoggingUtil.BNHALogger.info("added Quirk Capability's");
				
				event.addCapability(MODELID, new ModelProvider()); 
				
				LoggingUtil.BNHALogger.info("added Model Capability");

			}
		}
	}
	


	public static boolean canHaveAttributes(Entity e) {
		if (e instanceof EntityLivingBase)
			return true;
		return false;
	}

}
