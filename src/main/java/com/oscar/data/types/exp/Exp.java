package com.oscar.data.types.exp;

import com.oscar.data.types.interfaces.IExp;

public class Exp implements IExp {
	
	private int exp = 0;

	
	@Override
	public void setexp(int exp) { 
		this.exp = exp;
	}


	@Override
	public int getexp() {
		return this.exp;
	}
	

	
}
