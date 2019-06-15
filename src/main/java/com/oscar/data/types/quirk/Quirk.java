package com.oscar.data.types.quirk;

import com.oscar.data.Capabilities;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;

public class Quirk {
	
	//Just some convinient methods
	
	public static int getQuirkact(EntityPlayer player) {
		IQAct iqact = player.getCapability(QActProvider.QACT_CAP, null);
		return iqact.getact();
	}
	
	public static int getQuirkmaxact(EntityPlayer player) {
		IQMaxAct iqmact = player.getCapability(QMaxActProvider.QMaxAct_CAP, null);
		return iqmact.getmact();
	}
	
	
	
	public static int getQuirkcool(EntityPlayer player) {
		IQCool iqcool = player.getCapability(QCoolProvider.COOL_CAP, null);
		return iqcool.getcool();
	}
	
	public static int getQuirkmaxcool(EntityPlayer player) {
		IQMaxCool iqmcool = player.getCapability(QMaxCoolProvider.MAXCOOl_CAP, null);
		return iqmcool.getmcool();
	}
	
	
	
	public static int getQuirkID(EntityPlayer player) {
		IQuirkID iqid = player.getCapability(Capabilities.quirkid, null);
		return iqid.getQID();
	}
	
	public static void setQuirkact(EntityPlayer player, int act) {
		IQAct iqact = player.getCapability(QActProvider.QACT_CAP, null);
		iqact.setact(act);
	}
	
	public static void setQuirkmaxact(EntityPlayer player,int maxact) {
		IQMaxAct iqmact = player.getCapability(QMaxActProvider.QMaxAct_CAP, null);
		iqmact.setmact(maxact);
	}
	
	
	
	public static void setQuirkcool(EntityPlayer player, int cooldown) {
		IQCool iqcool = player.getCapability(QCoolProvider.COOL_CAP, null);
		iqcool.setcool(cooldown);
	}
	
	public static void setQuirkmaxcool(EntityPlayer player, int maxcooldown) {
		IQMaxCool iqmcool = player.getCapability(QMaxCoolProvider.MAXCOOl_CAP, null);
		iqmcool.setmcool(maxcooldown);
	}
	
	
	
	public static void setQuirkID(EntityPlayer player, int quirkID) {
		IQuirkID iqid = player.getCapability(Capabilities.quirkid, null);
		IModelID modelid = player.getCapability(Capabilities.modelid, null);

		iqid.setQID(quirkID);
		modelid.setModelID(quirkID);
		
	}

	public static float getQuirkStrengh(EntityPlayer player) {
		int defaultstrengh = 1;
		
		IQuirkID iqid = player.getCapability(Capabilities.quirkid, null);
		ILevel lvl = player.getCapability(Capabilities.level, null);

		int quirkID = iqid.getQID();
		int level = lvl.getlvl();
		
		float strengh = level,
			  strenghexplosion = level * 1.3F,
			  strenghIce = level * 1.1F,
			  strenghDurQuirks = level * 1.7F;
		
		

		
		switch (quirkID) {
		case Reference.none:
			return defaultstrengh;
			
		case Reference.quirkless:
			return defaultstrengh;
			
		case Reference.explosionquirk:
			return strenghexplosion;
			
		case Reference.engine:
			return strengh;
			
		case Reference.hellfire:
			return strengh;
			
		case Reference.icequirk:
			return strenghIce;

			
		case Reference.electrification:
			return strengh;

		case Reference.tail:
			return strengh;
			
		case Reference.hardening:
			return strenghDurQuirks;
			
		case Reference.steel:
			return strenghDurQuirks;

	}
		return defaultstrengh;
		
}

	
	
	
	
	
	
	
	

	
}
