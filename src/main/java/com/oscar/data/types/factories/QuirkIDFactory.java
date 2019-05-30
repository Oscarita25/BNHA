package com.oscar.data.types.factories;

import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.quirk.QuirkID;

public class QuirkIDFactory implements Callable<IQuirkID>{

	@Override
	public IQuirkID call() throws Exception {
		return new QuirkID();
	}

}