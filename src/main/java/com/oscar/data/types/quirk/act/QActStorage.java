package com.oscar.data.types.quirk.act;

import com.oscar.data.types.interfaces.IQAct;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QActStorage implements IStorage<IQAct>{

	@Override
	public NBTBase writeNBT(Capability<IQAct> capability, IQAct instance, EnumFacing side) {
		return new NBTTagInt(instance.getact());
	}

	@Override
	public void readNBT(Capability<IQAct> capability, IQAct instance, EnumFacing side, NBTBase nbt) {
		instance.setact(((NBTPrimitive) nbt).getInt());
	}

}
