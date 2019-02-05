package com.oscar.data;

import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;
import com.oscar.data.types.quirk.name.QNameProvider;
import com.oscar.util.Reference;

import ibxm.Player;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Capabilities {
	
	public static final ResourceLocation LEVEL_CAP = new ResourceLocation(Reference.MOD_ID, "level");
	public static final ResourceLocation EXP_CAP = new ResourceLocation(Reference.MOD_ID, "expc");
	public static final ResourceLocation NEXP_CAP = new ResourceLocation(Reference.MOD_ID, "expn");
	public static final ResourceLocation QURIKNAME_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 
	public static final ResourceLocation QMaxAct_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 
	public static final ResourceLocation QACT_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 
	public static final ResourceLocation COOL_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 
	public static final ResourceLocation MAXCOOl_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 
	public static final ResourceLocation QUIRKID_CAP = new ResourceLocation(Reference.MOD_ID, "quirk"); 

	
	@SubscribeEvent
	public void attachCapability(AttachCapabilitiesEvent<Player> event) {

				event.addCapability(LEVEL_CAP, new LevelProvider());
				System.out.println("added level cap");
				
				event.addCapability(EXP_CAP, new ExpProvider());
				System.out.println("added Exp cap");
				
				event.addCapability(NEXP_CAP, new NExpProvider());
				System.out.println("added Needed Exp cap");

				event.addCapability(QUIRKID_CAP, new QuirkIDProvider());
				event.addCapability(MAXCOOl_CAP, new QMaxCoolProvider()); 
				event.addCapability(COOL_CAP, new QCoolProvider()); 
				event.addCapability(QACT_CAP, new QActProvider()); 
				event.addCapability(QMaxAct_CAP, new QMaxActProvider()); 
				event.addCapability(QURIKNAME_CAP, new QNameProvider()); 
				System.out.println("added Quirk caps");
			}

}
