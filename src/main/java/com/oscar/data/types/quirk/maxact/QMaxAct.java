package com.oscar.data.types.quirk.maxact;

import com.oscar.data.types.interfaces.IQMaxAct;

public class QMaxAct implements IQMaxAct {
	
	private int maxact = 0;

	@Override
	public void setmact(int maxact) {
		this.maxact = maxact;
	}

	@Override
	public int getmact() {
		return this.maxact;
	}


}
