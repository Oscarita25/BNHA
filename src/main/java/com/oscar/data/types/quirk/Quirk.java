package com.oscar.data.types.quirk;

import java.util.ArrayList;
import java.util.List;

import com.oscar.data.types.interfaces.IQuirk;
import com.oscar.quirks.QuirkManage;
import com.oscar.util.Multipliers;

import net.minecraft.entity.player.EntityPlayer;

public class Quirk implements IQuirk {
	
	List<Quirk> quirks = new ArrayList<Quirk>();
	
	protected static String name;
	protected static int cooldown = 0;
	protected static int maxCooldown = 0 ;

	protected static int act = 0;
	protected static int maxAct = 0;
	
	protected static boolean activated = false;
	protected static boolean available = true;
	protected static Multipliers multipliers = null;
	
	public Quirk() {
		
	}

	public Quirk(String name) {
		this.name = name;
		QuirkManage.QUIRKS.add(this);
	}

	public static void init() {
		if(multipliers == null) return;
		
		maxCooldown = (int) (maxCooldown * Math.pow(multipliers.getCooldownMultiplier(), 0));
		maxAct = (int) (maxAct * Math.pow(multipliers.getActivatedMultiplier(), 0));
	}
	
	@Override
	public void setMultipliers(Multipliers _multipliers) {this.multipliers = _multipliers;}
	
	@Override
	public void setMaxCooldown(int _maxCooldown) {this.maxCooldown = _maxCooldown;}
	
	@Override
	public void setMaxActivatedTime(int _maxAct) {this.maxAct = _maxAct;}
	
	@Override
	public void setCooldown(int cooldown) {this.cooldown = cooldown;}
	
	@Override
	public void setAct(int act) {this.act = act;}
	
	@Override
	public void setActivated(boolean activated) {this.activated = activated;}
	
	@Override
	public void setAvailable(boolean available) {this.available = available;}
	

	@Override
	public String getName() {
		return name;
	}
	@Override
	public void onPlayerUse(EntityPlayer player) {
		
	}

	public List<Quirk> getQuirks() {
		return quirks;
	}
	
	@Override
	public void addQuirks(Quirk... quirk) {
		for(Quirk q:quirk) {
			if(!quirks.contains(q))
				quirks.add(q);
		}
	}
	@Override
	public void removeQuirks(Quirk... quirk) {
		for(Quirk q:quirk) {
			if(quirks.contains(quirk))
				quirks.remove(quirk);
		}
	}
	@Override
	public void reset() {
		quirks.clear();
	}



	
	
}
