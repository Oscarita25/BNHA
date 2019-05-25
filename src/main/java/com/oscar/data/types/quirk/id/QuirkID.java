package com.oscar.data.types.quirk.id;

import com.oscar.data.types.interfaces.IQuirkID;

public class QuirkID implements IQuirkID {
	
	private int quirkID = 0;

	@Override
	public void setID(int ID) {
		this.quirkID = ID;
	}

	@Override
	public int getID() {
		return this.quirkID;
	}
}
