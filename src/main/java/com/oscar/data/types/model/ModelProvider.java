package com.oscar.data.types.model;

import com.oscar.data.types.interfaces.IModelID;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ModelProvider implements ICapabilitySerializable<NBTBase>{

	@CapabilityInject(IModelID.class)
	public static final Capability<IModelID> MODEL_CAP = null;
	
	private IModelID instance = MODEL_CAP.getDefaultInstance();
	
	@Override
	public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
		return capability == MODEL_CAP;
	}

	@Override
	public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
		return capability == MODEL_CAP ? MODEL_CAP.<T> cast(this.instance) : null;
	}

	@Override
	public NBTBase serializeNBT() {
		return MODEL_CAP.getStorage().writeNBT(MODEL_CAP, this.instance, null);
	}

	@Override
	public void deserializeNBT(NBTBase nbt) {
		MODEL_CAP.getStorage().readNBT(MODEL_CAP, this.instance, null, nbt);
	}

}

