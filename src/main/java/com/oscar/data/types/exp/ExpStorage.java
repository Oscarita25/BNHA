package com.oscar.data.types.exp;

import com.oscar.data.types.interfaces.IExp;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class ExpStorage implements IStorage<IExp>{

	@Override
	public NBTBase writeNBT(Capability<IExp> capability, IExp instance, EnumFacing side) {
		return new NBTTagInt(instance.getexp());
	}

	@Override
	public void readNBT(Capability<IExp> capability, IExp instance, EnumFacing side, NBTBase nbt) {
		instance.setexp(((NBTPrimitive) nbt).getInt());
	}

}
