package com.oscar.data;

import com.oscar.data.types.Exp;
import com.oscar.data.types.Level;
import com.oscar.data.types.ModelID;
import com.oscar.data.types.NExp;
import com.oscar.data.types.Stamina;
import com.oscar.data.types.api.CapabilityProvider;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.interfaces.IStamina;
import com.oscar.data.types.quirk.QuirkID;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;
import com.oscar.util.LoggingUtil;
import com.oscar.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Capabilities {
	
	@CapabilityInject(IExp.class)
	public static Capability<IExp> exp;
	
	@CapabilityInject(INExp.class)
	public static Capability<INExp> nexp;
	
	@CapabilityInject(ILevel.class)
	public static Capability<ILevel> level;
	
	@CapabilityInject(IQuirkID.class)
	public static Capability<IQuirkID> quirkid;
	
	@CapabilityInject(IModelID.class)
	public static Capability<IModelID> modelid;
	
	@CapabilityInject(IStamina.class)
	public static Capability<IStamina> stamina;
	
	/*
	 * 		Attaching Capabilities on the Player
	 * 
	 */	
	public static final ResourceLocation QMaxAct_CAP = new ResourceLocation(Reference.MOD_ID, "qmaxact"); 
	public static final ResourceLocation QACT_CAP = new ResourceLocation(Reference.MOD_ID, "qact"); 
	public static final ResourceLocation COOL_CAP = new ResourceLocation(Reference.MOD_ID, "qcooldown"); 
	public static final ResourceLocation MAXCOOl_CAP = new ResourceLocation(Reference.MOD_ID, "qmaxcooldown"); 
	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {

		if (canHaveAttributes(event.getObject())) {
			EntityLivingBase ent = (EntityLivingBase) event.getObject();
			
			if (ent instanceof EntityPlayer) {
				
				Level capabilityLevel = new Level((EntityPlayer)ent);				
				Exp capabilityExp = new Exp((EntityPlayer)ent);
				NExp capabilityNExp = new NExp((EntityPlayer)ent);
				QuirkID capabilityQuirkID = new QuirkID((EntityPlayer)ent);
				ModelID capabilityModel = new ModelID((EntityPlayer)ent);
				Stamina capabilityStamina = new Stamina((EntityPlayer)ent);

				
				event.addCapability(capabilityNExp.getID(), new CapabilityProvider(Capabilities.nexp,capabilityNExp ,null));
				event.addCapability(capabilityLevel.getID(), new CapabilityProvider(Capabilities.level,capabilityLevel ,null));					
				event.addCapability(capabilityExp.getID(), new CapabilityProvider(Capabilities.exp,capabilityExp ,null));
				
				LoggingUtil.BNHALogger.info("added Level System Capability's");

				event.addCapability(capabilityQuirkID.getID(), new CapabilityProvider(Capabilities.quirkid,capabilityQuirkID ,null));
				event.addCapability(MAXCOOl_CAP, new QMaxCoolProvider()); 
				event.addCapability(COOL_CAP, new QCoolProvider()); 
				event.addCapability(QACT_CAP, new QActProvider()); 
				event.addCapability(QMaxAct_CAP, new QMaxActProvider());
				event.addCapability(capabilityStamina.getID(), new CapabilityProvider(Capabilities.stamina,capabilityStamina,null)); 

				
				LoggingUtil.BNHALogger.info("added Quirk Capability's");
				
				event.addCapability(capabilityModel.getID(), new CapabilityProvider(Capabilities.modelid,capabilityModel,null)); 
				
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
