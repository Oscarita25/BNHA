package com.oscar.data.types.quirk.cool;

import com.oscar.data.types.interfaces.IQCool;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QCoolStorage implements IStorage<IQCool>{

	@Override
	public NBTBase writeNBT(Capability<IQCool> capability, IQCool instance, EnumFacing side) {
		return new NBTTagInt(instance.getcool());
	}

	@Override
	public void readNBT(Capability<IQCool> capability, IQCool instance, EnumFacing side, NBTBase nbt) {
		instance.setcool(((NBTPrimitive) nbt).getInt());
	}

}
