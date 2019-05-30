package com.oscar.data.types;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageLEVEL;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class Level implements ILevel {
	
	protected EntityPlayer player;
	private int level = 1;
	private static final String keyLevel = "bnhalevel";
	private static final ResourceLocation id = new ResourceLocation(Reference.MOD_ID ,"level");

	/*
	 * Don't call this constructor 
	 * it is just there for the factory
	 */
	public Level() {}
	public Level(EntityPlayer player) {
		this.player = player;
	}
	
	@Override
	public boolean setlvl(int level) {
		this.level = level;
		
		if(level < 1)
		{
			this.level = 1;
		}
		else
		{
			this.level = level;
			this.synchronize();
			return true;
		}
		this.synchronize();
		return false;
	}


	@Override
	public int getlvl() {
		return this.level;
	}



	@SuppressWarnings("static-access")
	@Override
	public ResourceLocation getID() {
		return this.id;
	}


	@Override
	public void synchronize() {
		if(this.player instanceof EntityPlayerMP){
		BNHA.NETWORK.sendTo(new MessageLEVEL(this.level), (EntityPlayerMP) this.player);
		}				
	}


	@Override
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side) {	
		nbt.setInteger(keyLevel, this.level);

		return nbt;
	}


	@Override
	public void deserialize(NBTBase nbt) {	
		this.level = ((NBTTagCompound) nbt).getInteger(keyLevel);
		
	}


}
