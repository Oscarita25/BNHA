package com.oscar.data.types;

import com.oscar.BNHA;
import com.oscar.data.packets.MM;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class ModelID implements IModelID {
	
	protected EntityPlayer player;
	private int model = 1;
	private static final String keyModel = "bnhamodel";
	private static final ResourceLocation id = new ResourceLocation(Reference.MOD_ID ,"model");

	/*
	 * Don't call this constructor 
	 * it is just there for the factory
	 */
	public ModelID() {}
	public ModelID(EntityPlayer player) {
		this.player = player;
	}
	
	@Override
	public boolean setModelID(int QID) {
		this.model = QID;
		
		if(QID < 0)
		{
			this.model = 0;
		}
		else
		{
			this.model = QID;
			this.synchronize();
			return true;
		}
		this.synchronize();
		return false;
	}


	@Override
	public int getModelID() {
		return this.model;
	}



	@SuppressWarnings("static-access")
	@Override
	public ResourceLocation getID() {
		return this.id;
	}


	@Override
	public void synchronize() {
		if(this.player instanceof EntityPlayerMP){
			BNHA.NETWORK.sendTo(new MM(this.model), (EntityPlayerMP) this.player);

		}				
	}


	@Override
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side) {	
		nbt.setInteger(keyModel, this.model);

		return nbt;
	}


	@Override
	public void deserialize(NBTBase nbt) {	
		this.model = ((NBTTagCompound) nbt).getInteger(keyModel);
		
	}




}
