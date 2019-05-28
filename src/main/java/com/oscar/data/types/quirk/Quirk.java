package com.oscar.data.types.quirk;

import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.interfaces.IQAct;
import com.oscar.data.types.interfaces.IQCool;
import com.oscar.data.types.interfaces.IQMaxAct;
import com.oscar.data.types.interfaces.IQMaxCool;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.model.ModelProvider;
import com.oscar.data.types.quirk.act.QActProvider;
import com.oscar.data.types.quirk.cool.QCoolProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
import com.oscar.data.types.quirk.maxact.QMaxActProvider;
import com.oscar.data.types.quirk.maxcool.QMaxCoolProvider;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;

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
		IQuirkID iqid = player.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
		return iqid.getID();
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
		IQuirkID iqid = player.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
		IModelID modelid = player.getCapability(ModelProvider.MODEL_CAP, null);

		iqid.setID(quirkID);
		modelid.setModelID(quirkID, (EntityPlayerMP) player);
		
	}

	
	
	
	
	
	
	
	

	
}
