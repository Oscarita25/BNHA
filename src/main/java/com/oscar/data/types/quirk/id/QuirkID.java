package com.oscar.data.types.quirk.id;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.types.interfaces.IQuirkID;

public class QuirkID implements IQuirkID {
	
	private int quirkID = 0;

	@Override
	public void setID(int ID) {
		this.quirkID = ID;
    	BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
	}

	@Override
	public int getID() {
    	BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
		return this.quirkID;
	}
}
