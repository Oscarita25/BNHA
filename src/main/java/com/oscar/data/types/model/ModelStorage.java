package com.oscar.data.types.model;

import com.oscar.data.types.interfaces.IModelID;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ModelStorage implements IStorage<IModelID>{

	@Override
	public NBTBase writeNBT(Capability<IModelID> capability, IModelID instance, EnumFacing side) {
		return new NBTTagInt(instance.getModelID());
	}
	

	

	@Override
	public void readNBT(Capability<IModelID> capability, IModelID instance, EnumFacing side, NBTBase nbt) {
		instance.setModelID(((NBTPrimitive) nbt).getInt(), null);
	}

}