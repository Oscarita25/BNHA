package com.oscar.data.types.quirk.maxcool;

import com.oscar.data.types.interfaces.IQMaxCool;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QMaxCoolStorage implements IStorage<IQMaxCool>{

	@Override
	public NBTBase writeNBT(Capability<IQMaxCool> capability, IQMaxCool instance, EnumFacing side) {
		return new NBTTagInt(instance.getmcool());
	}

	@Override
	public void readNBT(Capability<IQMaxCool> capability, IQMaxCool instance, EnumFacing side, NBTBase nbt) {
		instance.setmcool(((NBTPrimitive) nbt).getInt());
	}

}
