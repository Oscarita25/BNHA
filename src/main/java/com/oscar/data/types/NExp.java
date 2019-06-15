package com.oscar.data.types;

import com.oscar.data.packets.MNE;
import com.oscar.data.packets.PacketDispatcher;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.util.Reference;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;

public class NExp implements INExp {
	
	protected EntityPlayer player;
	private int nexp = 3;
	private static final String keyNExp = "bnhanexp";
	private static final ResourceLocation id = new ResourceLocation(Reference.MOD_ID ,"nexp");

	/*
	 * Don't call this constructor 
	 * it is just there for the factory
	 */
	public NExp() {}
	public NExp(EntityPlayer player)
	{
		this.player = player;
	}


	
	@Override
	public boolean setnexp(int nexp) {		
		this.nexp = nexp;
		
		if(nexp < 3)
		{
			this.nexp = 3;
		}
		else
		{
			this.nexp = nexp;
			this.synchronize();
			return true;
		}
		this.synchronize();
		return false;
		
		
	}


	@Override
	public int getnexp() {
		return this.nexp;
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
			PacketDispatcher.sendTo(new MNE(this.nexp), (EntityPlayerMP) this.player);
		}		
	}



	@Override
	public NBTTagCompound serialize(NBTTagCompound nbt, EnumFacing side) {
		nbt.setInteger(keyNExp, this.nexp);

		return nbt;
	}



	@Override
	public void deserialize(NBTBase nbt) {
		this.nexp = ((NBTTagCompound) nbt).getInteger(keyNExp);
		
	}
	
	
}
