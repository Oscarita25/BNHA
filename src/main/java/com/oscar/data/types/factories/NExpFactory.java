package com.oscar.data.types.factories;

import java.util.concurrent.Callable;

import com.oscar.data.types.NExp;
import com.oscar.data.types.interfaces.INExp;

public class NExpFactory implements Callable<INExp>{

	@Override
	public INExp call() throws Exception {
		return new NExp();
	}

}