package com.oscar.data.types.quirk.maxcool;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQMaxCool;

public class QMaxCoolFactory implements Callable<IQMaxCool>{

	@Override
	public IQMaxCool call() throws Exception {
		return new QMaxCool();
	}

}
