package com.oscar.data.types.exp;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IExp;

public class ExpFactory implements Callable<IExp>{

	@Override
	public IExp call() throws Exception {
		return new Exp();
	}

}
