package com.oscar.data.types.interfaces;

public interface IQuirk {
	
	
	String name = "null";
	static int quirkID = 0;

	static int cooldown = 0;
	static int maxCooldown = 0 ;

	static int act = 0;
	static int maxAct = 0;
	
	static boolean activated = false;
	static boolean available = true;
	
	public void setName(String name);
	public void setMaxCooldown(int _maxCooldown);
	public void setMaxActivatedTime(int _maxAct);
	public void setAct(int act);
	public void setActivated(boolean activated);
	public void setCooldown(int cooldown);
	public void setAvailable(boolean available);
	public void setQuirkID(int quirkID);
	
	public String getName();
	public int getMaxCooldown();
	public int getMaxActivatedTime();
	public int getAct();
	public boolean getActivated();
	public int getCooldown();
	public boolean getAvailable();
	public int getQuirkID();

}
