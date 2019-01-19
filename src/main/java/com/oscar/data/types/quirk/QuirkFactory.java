package com.oscar.data.types.quirk;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQuirk;

public class QuirkFactory implements Callable<IQuirk>{

	@Override
	public IQuirk call() throws Exception {
		return new Quirk();
	}

}
