package com.oscar.data.types.quirk.cool;

import com.oscar.data.types.interfaces.IQCool;

public class QCool implements IQCool {
	
	private int cooldown = 0;


	@Override
	public void setcool(int cooldown) {
		this.cooldown = cooldown;		
	}


	@Override
	public int getcool() {
		return this.cooldown;
	}
	
}
