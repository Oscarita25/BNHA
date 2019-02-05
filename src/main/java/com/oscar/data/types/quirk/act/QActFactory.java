package com.oscar.data.types.quirk.act;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQAct;

public class QActFactory implements Callable<IQAct>{

	@Override
	public IQAct call() throws Exception {
		return new QAct();
	}

}
