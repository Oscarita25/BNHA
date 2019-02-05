package com.oscar.data.types.quirk.maxcool;

import com.oscar.data.types.interfaces.IQMaxCool;

public class QMaxCool implements IQMaxCool {
	
	private int maxcooldown = 0;

	
	@Override
	public void setmcool(int maxcooldown) { 
		this.maxcooldown = maxcooldown;
	}


	@Override
	public int getmcool() {
		return this.maxcooldown;
	}
	
}
