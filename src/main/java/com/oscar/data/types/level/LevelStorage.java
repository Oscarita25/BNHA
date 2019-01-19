package com.oscar.data.types.level;

import com.oscar.data.types.interfaces.ILevel;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class LevelStorage implements IStorage<ILevel>{

	@Override
	public NBTBase writeNBT(Capability<ILevel> capability, ILevel instance, EnumFacing side) {
		return new NBTTagInt(instance.getlvl());
	}

	@Override
	public void readNBT(Capability<ILevel> capability, ILevel instance, EnumFacing side, NBTBase nbt) {
		instance.setlvl(((NBTPrimitive) nbt).getInt());
	}

}