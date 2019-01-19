package com.oscar.data.types.level;

import com.oscar.data.types.interfaces.ILevel;

public class Level implements ILevel {
	
	private int level = 1;


	@Override
	public void setlvl(int level) {		
		this.level = level;
	}


	@Override
	public int getlvl() {
		return this.level;
	}


}
