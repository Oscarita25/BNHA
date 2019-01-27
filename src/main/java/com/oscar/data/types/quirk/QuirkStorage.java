package com.oscar.data.types.quirk;

import com.oscar.data.types.interfaces.IQuirk;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.Capability.IStorage;

public class QuirkStorage implements IStorage<IQuirk>{

	@Override
	public NBTBase writeNBT(Capability<IQuirk> capability, IQuirk instance, EnumFacing side) {
		NBTTagCompound tag = new NBTTagCompound();
		
		tag.setString("name", instance.getName());
		
		tag.setBoolean("activated", instance.getActivated());
		tag.setBoolean("available",instance.getAvailable());
		//Cooldown
		tag.setInteger("maxCooldown", instance.getMaxCooldown());
		tag.setInteger("cooldown", instance.getCooldown());
		
		//Activation Time
		tag.setInteger("maxAct", instance.getMaxActivatedTime());
		tag.setInteger("act", instance.getAct());
		
		//Quirk ID
		tag.setInteger("quirkid", instance.getQuirkID());
		
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
			
		//Quirk ID
		tag.getInteger("quirkid");
		}
	}



