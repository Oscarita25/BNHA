package com.oscar.data.types.nexp;

import com.oscar.data.types.interfaces.INExp;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagDouble;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class NExpStorage implements IStorage<INExp>{

	@Override
	public NBTBase writeNBT(Capability<INExp> capability, INExp instance, EnumFacing side) {
		return new NBTTagDouble(instance.getnexp());
	}

	@Override
	public void readNBT(Capability<INExp> capability, INExp instance, EnumFacing side, NBTBase nbt) {
		instance.setnexp(((NBTPrimitive) nbt).getInt());
	}

}
