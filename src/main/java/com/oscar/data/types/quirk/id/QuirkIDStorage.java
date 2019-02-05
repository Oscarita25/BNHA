package com.oscar.data.types.quirk.id;

import com.oscar.data.types.interfaces.IQuirkID;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QuirkIDStorage implements IStorage<IQuirkID>{

	@Override
	public NBTBase writeNBT(Capability<IQuirkID> capability, IQuirkID instance, EnumFacing side) {
		return new NBTTagInt(instance.getID());
	}

	@Override
	public void readNBT(Capability<IQuirkID> capability, IQuirkID instance, EnumFacing side, NBTBase nbt) {
		instance.setID(((NBTPrimitive) nbt).getInt());
	}

}
