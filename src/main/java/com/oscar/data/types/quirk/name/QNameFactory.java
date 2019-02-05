package com.oscar.data.types.quirk.name;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQName;

public class QNameFactory implements Callable<IQName>{

	@Override
	public IQName call() throws Exception {
		return new QName();
	}

}
