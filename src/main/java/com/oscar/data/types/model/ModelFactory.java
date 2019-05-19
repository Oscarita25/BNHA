package com.oscar.data.types.model;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IModelID;

public class ModelFactory implements Callable<IModelID>{

	@Override
	public IModelID call() throws Exception {
		return new ModelID();
	}

}
