package com.oscar.data.types.interfaces;

import java.util.ArrayList;
import java.util.List;

import com.oscar.data.types.quirk.Quirk;
import com.oscar.util.Multipliers;

import net.minecraft.entity.player.EntityPlayer;

public interface IQuirk {
	
	List<Quirk> quirks = new ArrayList<Quirk>();
	
	String name = "";
	boolean isUsable = true;

	static int cooldown = 0;
	static int maxCooldown = 0 ;

	static int act = 0;
	static int maxAct = 0;
	
	static boolean activated = false;
	static boolean available = true;
	
	static Multipliers multipliers = null;
	
	public String getName();
	
	public void setMaxCooldown(int _maxCooldown);
	public void setMaxActivatedTime(int _maxAct);
	public void setAct(int act);
	public void setActivated(boolean activated);
	
	public void setCooldown(int cooldown);
	public void setAvailable(boolean available);
	public void setMultipliers(Multipliers _multipliers);
	public void onPlayerUse(EntityPlayer player);
	public List<Quirk> getQuirks();

	public void addQuirks(Quirk... quirk);
	public void removeQuirks(Quirk... quirk);
	public void reset();


	
}
