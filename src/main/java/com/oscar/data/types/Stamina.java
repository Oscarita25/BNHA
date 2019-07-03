package com.oscar.data.types;

import com.oscar.data.packets.MS;
import com.oscar.data.packets.PacketDispatcher;
import com.oscar.data.types.interfaces.IStamina;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class Stamina implements IStamina
{

	
	protected EntityPlayer player;
	private int stamina = 10;
	private int maxstamina = 10;
	private static final String keySTAMINA = "bnhastamina";
	private static final String keyMAXSTAMINA = "bnhamaxstamina";
	private static final ResourceLocation id = new ResourceLocation(Reference.MOD_ID ,"stamina");

	/*
	 * Don't call this constructor 
	 * it is just there for the factory
	 */
	public Stamina() {}
	public Stamina(EntityPlayer player)
	{
		this.player = player;
	}


	
	@Override
	public boolean setStamina(int stamina) {		
		this.stamina = stamina;
		
		if(stamina < 0)
		{
		
			this.stamina = 0;
			this.synchronize();
			return true;
		}else if(stamina > 0){
			this.stamina = stamina;
			this.synchronize();
			return true;
		}
		this.synchronize();
		return false;
		
		
	}


	@Override
	public int getStamina() {
		return this.stamina;
	}

	@Override
	public boolean setMaxStamina(int maxstamina) {
		if(maxstamina < 10)
		{
			this.maxstamina = 10;
			this.synchronize();
			return true;
		}else if(maxstamina > 10){
			this.maxstamina = maxstamina;
			this.synchronize();
			return true;
		}
		
		this.synchronize();
		return false;
		
	}
	@Override
	public int getMaxStamina() {
		return this.maxstamina;
	}
	
	
	@SuppressWarnings("static-access")
	@Override
	public ResourceLocation getID() {
		return this.id;
	}



	@Override
	public void synchronize() {
		if(this.player instanceof EntityPlayerMP){
			PacketDispatcher.sendTo(new MS(this.stamina,this.maxstamina), (EntityPlayerMP) this.player);
		}		
	}



	@Override
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side) {
		nbt.setInteger(keySTAMINA, this.stamina);
		
		nbt.setInteger(keyMAXSTAMINA, this.maxstamina);
		
		return nbt;
	}



	@Override
	public void deserialize(NBTBase nbt) {
		this.stamina = ((NBTTagCompound) nbt).getInteger(keySTAMINA);
		this.maxstamina = ((NBTTagCompound) nbt).getInteger(keyMAXSTAMINA);
		
	}


}
