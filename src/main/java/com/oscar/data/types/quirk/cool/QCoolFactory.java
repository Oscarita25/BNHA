package com.oscar.data.types.quirk.cool;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQCool;

public class QCoolFactory implements Callable<IQCool>{

	@Override
	public IQCool call() throws Exception {
		return new QCool();
	}

}
