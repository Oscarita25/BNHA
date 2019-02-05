package com.oscar.data.types.quirk.maxact;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQMaxAct;

public class QMaxActFactory implements Callable<IQMaxAct>{

	@Override
	public IQMaxAct call() throws Exception {
		return new QMaxAct();
	}

}
