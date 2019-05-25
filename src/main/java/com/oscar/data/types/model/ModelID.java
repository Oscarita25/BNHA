package com.oscar.data.types.model;

import com.oscar.data.types.interfaces.IModelID;

public class ModelID implements IModelID {
	
	private int model = 0;


	@Override
	public void setModelID(int model) {
		this.model = model;
	}
	
	@Override
	public int getModelID() {
		return this.model;
	}






}
