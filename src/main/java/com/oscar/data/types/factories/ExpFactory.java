package com.oscar.data.types.factories;

import java.util.concurrent.Callable;

import com.oscar.data.types.Exp;
import com.oscar.data.types.interfaces.IExp;

public class ExpFactory implements Callable<IExp>{

	@Override
	public IExp call() throws Exception {
		return new Exp();
	}

}
