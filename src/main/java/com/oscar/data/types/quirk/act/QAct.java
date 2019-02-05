package com.oscar.data.types.quirk.act;

import com.oscar.data.types.interfaces.IQAct;

public class QAct implements IQAct {
	
	private int act = 0;

	
	@Override
	public void setact(int act) { 
		this.act = act;
	}


	@Override
	public int getact() {
		return this.act;
	}
	
}
