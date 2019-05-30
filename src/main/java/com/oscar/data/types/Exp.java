package com.oscar.data.types;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageEXP;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class Exp implements IExp {
	
	protected EntityPlayer player;
	private int exp = 0;
	private static final String keyExp = "bnhaexp";
	private static final ResourceLocation id = new ResourceLocation(Reference.MOD_ID ,"exp");
	
	/*
	 * Don't call this constructor 
	 * it is just there for the factory
	 */
	public Exp(){}
	public Exp(EntityPlayer player)	{
		this.player = player;
	}


	@Override
	public boolean setexp(int exp) {		
		this.exp = exp;
		
		if(exp < 0)
		{
			this.exp = 0;
		}
		else
		{
			this.exp = exp;
			this.synchronize();
			return true;
		}
		this.synchronize();
		return false;	
		
	}

	@Override
	public int getexp() {
		return this.exp;
	}


	@SuppressWarnings("static-access")
	@Override
	public ResourceLocation getID() {
		return this.id;
	}



	@Override
	public void synchronize() {
		if(this.player instanceof EntityPlayerMP)
		{
		BNHA.NETWORK.sendTo(new MessageEXP(this.exp), (EntityPlayerMP) this.player);
		}		
	}



	@Override
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side) {
		nbt.setInteger(keyExp, this.exp);

		return nbt;
	}



	@Override
	public void deserialize(NBTBase nbt) {
		this.exp = ((NBTTagCompound) nbt).getInteger(keyExp);
		
	}
	
	
}
