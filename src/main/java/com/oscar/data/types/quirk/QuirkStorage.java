package com.oscar.data.types.quirk;

import com.oscar.data.types.interfaces.IQuirk;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagByte;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagString;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QuirkStorage implements IStorage<IQuirk>{

	@Override
	public NBTBase writeNBT(Capability<IQuirk> capability, IQuirk instance, EnumFacing side) {
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setString("name", instance.name);
		
		tag.setBoolean("activated", instance.activated);
		tag.setBoolean("available",instance.available);
		//Cooldown
		tag.setInteger("maxCooldown", instance.maxCooldown);
		tag.setInteger("cooldown", instance.cooldown);
		
		//Activation Time
		tag.setInteger("maxAct", instance.maxAct);
		tag.setInteger("act", instance.act);
		
		return tag;
	}

	 
	@Override
	public void readNBT(Capability<IQuirk> capability, IQuirk instance, EnumFacing side, NBTBase nbt) {
		NBTTagCompound tag = (NBTTagCompound) nbt;
		
		tag.getBoolean("activated");
		tag.getBoolean("aviable");
		//Cooldown
		tag.getInteger("maxCooldown");
		tag.getInteger("cooldown");

		//Activation Time
		tag.getInteger("maxAct");
		tag.getInteger("act");
			
		}
	}



