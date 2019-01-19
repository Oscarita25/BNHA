package com.oscar.data.types.exp;	

import com.oscar.data.types.interfaces.IExp;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class ExpProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IExp.class)
		public static final Capability<IExp> EXP_CAP = null;
		
		private IExp instance = EXP_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == EXP_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == EXP_CAP ? EXP_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return EXP_CAP.getStorage().writeNBT(EXP_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			EXP_CAP.getStorage().readNBT(EXP_CAP, this.instance, null, nbt);
		}
}

