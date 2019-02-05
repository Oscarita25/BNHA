package com.oscar.data.types.quirk.maxact;

import com.oscar.data.types.interfaces.IQMaxAct;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QMaxActStorage implements IStorage<IQMaxAct>{

	@Override
	public NBTBase writeNBT(Capability<IQMaxAct> capability, IQMaxAct instance, EnumFacing side) {
		return new NBTTagInt(instance.getmact());
	}

	@Override
	public void readNBT(Capability<IQMaxAct> capability, IQMaxAct instance, EnumFacing side, NBTBase nbt) {
		instance.setmact(((NBTPrimitive) nbt).getInt());
	}



}
