package com.oscar.data.types.quirk;

import com.oscar.data.types.interfaces.IQuirk;

public class Quirk implements IQuirk {
		
	protected static String name = "null";
	protected static int quirkID = 0;
	protected static int cooldown = 0;
	protected static int maxCooldown = 0 ;

	protected static int act = 0;
	protected static int maxAct = 0;
	
	protected static boolean activated = false;
	protected static boolean available = true;
	

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
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public int getMaxCooldown() {
		return this.maxCooldown;
	}

	@Override
	public int getMaxActivatedTime() {
		return this.maxAct;
	}

	@Override
	public int getAct() {
		return this.act;
	}

	@Override
	public boolean getActivated() {
		return this.activated;
	}

	@Override
	public int getCooldown() {
		return this.cooldown;
	}

	@Override
	public boolean getAvailable() {
		return this.available;
	}

	@Override
	public void setQuirkID(int quirkID) {
		this.quirkID = quirkID;
	}

	@Override
	public int getQuirkID() {
		return this.quirkID;
	}

	
}
