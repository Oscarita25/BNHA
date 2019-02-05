package com.oscar.data.types.quirk.id;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.IQuirkID;

public class QuirkIDFactory implements Callable<IQuirkID>{

	@Override
	public IQuirkID call() throws Exception {
		return new QuirkID();
	}

}
