package com.oscar.data.types.factories;

import java.util.concurrent.Callable;

import com.oscar.data.types.ModelID;
import com.oscar.data.types.interfaces.IModelID;

public class ModelIDFactory implements Callable<IModelID>{

	@Override
	public IModelID call() throws Exception {
		return new ModelID();
	}

}

