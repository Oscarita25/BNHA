package com.oscar.data.types.nexp;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.types.interfaces.INExp;

public class NExp implements INExp {
	
	private int nexp = 3;

	
	@Override
	public void setnexp(int nexp) { 
		this.nexp = nexp;
	}


	@Override
	public int getnexp() {
		return this.nexp;
	}
	
}
