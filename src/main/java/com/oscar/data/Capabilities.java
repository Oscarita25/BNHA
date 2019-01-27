package com.oscar.data;

import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.QuirkProvider;
import com.oscar.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Capabilities {
	
	public static final ResourceLocation LEVEL_CAP = new ResourceLocation(Reference.MOD_ID, "level");
	public static final ResourceLocation EXP_CAP = new ResourceLocation(Reference.MOD_ID, "expc");
	public static final ResourceLocation NEXP_CAP = new ResourceLocation(Reference.MOD_ID, "expn");
	public static final ResourceLocation QUIRK_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 

	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Entity> event) {
		if (canHaveAttributes(event.getObject())) {
			EntityLivingBase ent = (EntityLivingBase) event.getObject();
			
			if (ent instanceof EntityPlayer || ent instanceof EntityPlayerMP) {
				event.addCapability(LEVEL_CAP, new LevelProvider());
				event.addCapability(EXP_CAP, new ExpProvider());
				event.addCapability(NEXP_CAP, new NExpProvider());
				event.addCapability(QUIRK_CAP, new QuirkProvider()); 
				System.out.println("added level cap");
				System.out.println("added Exp cap");
				System.out.println("added Needed Exp cap");
				System.out.println("added Quirk cap");
			}
		}
		
	}
	
	public static boolean canHaveAttributes(Entity e) {
		if (e instanceof EntityLivingBase)
			return true;
		return false;
	}

}
