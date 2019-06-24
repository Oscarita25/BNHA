package com.oscar.data.types;

import com.oscar.data.packets.MM;
import com.oscar.data.packets.PacketDispatcher;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.datasync.DataParameter;
import net.minecraft.network.datasync.DataSerializers;
import net.minecraft.network.datasync.EntityDataManager;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class ModelID implements IModelID {
	
    private static final DataParameter<Integer> MODEL_ID = EntityDataManager.<Integer>createKey(EntityPlayer.class, DataSerializers.VARINT);
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
		player.getDataManager().register(MODEL_ID, 0);
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


	@Override
	public int getModelDATA() {
		return player.getDataManager().get(MODEL_ID).intValue();

	}

	@SuppressWarnings("static-access")
	@Override
	public ResourceLocation getID() {
		return this.id;
	}


	@Override
	public void synchronize() {
		if(this.player instanceof EntityPlayerMP){
			PacketDispatcher.sendTo(new MM(this.model),(EntityPlayerMP) this.player);
			player.getDataManager().set(MODEL_ID, this.model);
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
