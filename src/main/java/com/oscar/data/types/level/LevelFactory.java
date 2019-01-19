package com.oscar.data.types.level;
import java.util.concurrent.Callable;

import com.oscar.data.types.interfaces.ILevel;

public class LevelFactory implements Callable<ILevel>{

	@Override
	public ILevel call() throws Exception {
		return new Level();
	}

}
