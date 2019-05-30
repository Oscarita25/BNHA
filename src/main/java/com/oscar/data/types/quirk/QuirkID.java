package com.oscar.data.types.quirk;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageQuirkID;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class QuirkID implements IQuirkID {
	
	protected EntityPlayer player;
	private int QID = 1;
	private static final String keyQID = "bnhaqid";
	private static final ResourceLocation id = new ResourceLocation(Reference.MOD_ID ,"qid");

	/*
	 * Don't call this constructor 
	 * it is just there for the factory
	 */
	public QuirkID() {}
	public QuirkID(EntityPlayer player) {
		this.player = player;
	}
	
	@Override
	public boolean setQID(int QID) {
		this.QID = QID;
		
		if(QID < 0)
		{
			this.QID = 0;
		}
		else
		{
			this.QID = QID;
			this.synchronize();
			return true;
		}
		this.synchronize();
		return false;
	}


	@Override
	public int getQID() {
		return this.QID;
	}



	@SuppressWarnings("static-access")
	@Override
	public ResourceLocation getID() {
		return this.id;
	}


	@Override
	public void synchronize() {
		if(this.player instanceof EntityPlayerMP){
		BNHA.NETWORK.sendTo(new MessageQuirkID(this.QID), (EntityPlayerMP) this.player);
		}				
	}


	@Override
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side) {	
		nbt.setInteger(keyQID, this.QID);

		return nbt;
	}


	@Override
	public void deserialize(NBTBase nbt) {	
		this.QID = ((NBTTagCompound) nbt).getInteger(keyQID);
		
	}


}
