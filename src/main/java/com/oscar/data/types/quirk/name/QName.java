package com.oscar.data.types.quirk.name;

import com.oscar.data.types.interfaces.IQName;

public class QName implements IQName {
	
	private String name = "";


	@Override
	public void setname(String name) {
		this.name = name;
	}


	@Override
	public String getname() {
		return this.name;
	}
	
}
