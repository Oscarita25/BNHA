package com.oscar.data.types.quirk.name;

import com.oscar.data.types.interfaces.IQName;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QNameStorage implements IStorage<IQName>{

	@Override
	public NBTBase writeNBT(Capability<IQName> capability, IQName instance, EnumFacing side) {
		return new NBTTagString(instance.getname());
	}

	@Override
	public void readNBT(Capability<IQName> capability, IQName instance, EnumFacing side, NBTBase nbt) {
		instance.setname(((NBTTagString) nbt).getString());
	}

}
