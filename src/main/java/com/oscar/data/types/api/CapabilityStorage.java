package com.oscar.data.types.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class CapabilityStorage<T extends ICapability> implements IStorage<T>
{
	@Override
	public NBTBase writeNBT(Capability<T> capability, T instance, EnumFacing side)
	{
		return instance.serialize(side);
	}

	@Override
	public void readNBT(Capability<T> capability, T instance, EnumFacing side, NBTBase nbt)
	{
		instance.deserialize(nbt);
	}
}
