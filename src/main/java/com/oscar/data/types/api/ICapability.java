package com.oscar.data.types.api;

import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public interface ICapability
{
	/**
	 * Retrieves the capability's unique ID in form of a ResourceLocation.
	 */
	public ResourceLocation getID();

	/**
	 * Synchronizes data between two sides.
	 */
	public void synchronize();

	/**
	 * Serializes the capability instance to an existing NBT tag.
	 */
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side);

	/**
	 * Serializes the capability instance to a new NBT tag.
	 */
	public default NBTBase serialize(EnumFacing side)
	{
		return this.serialize(new NBTTagCompound(), side);
	}

	/**
	 * Read the capability instance from an NBT tag.
	 */
	public void deserialize(NBTBase nbt);
}