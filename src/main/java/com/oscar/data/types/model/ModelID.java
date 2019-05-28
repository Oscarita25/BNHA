package com.oscar.data.types.model;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageModel;
import com.oscar.data.types.interfaces.IModelID;

import net.minecraft.entity.player.EntityPlayerMP;

public class ModelID implements IModelID {
	
	private int model = 0;


	@Override
	public void setModelID(int model, EntityPlayerMP player) {
		this.model = model;
		if(player instanceof EntityPlayerMP) {
		markDirty(player);
		}
		
	}
	
	@Override
	public int getModelID() {
		return this.model;
	}

	private void markDirty(EntityPlayerMP player) {
		BNHA.NETWORK.sendTo(new MessageModel(), player);
	}



}
