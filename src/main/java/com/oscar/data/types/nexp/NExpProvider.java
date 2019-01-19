package com.oscar.data.types.nexp;

import com.oscar.data.types.interfaces.INExp;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class NExpProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(INExp.class)
		public static final Capability<INExp> NEXP_CAP = null;
		
		private INExp instance = NEXP_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == NEXP_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == NEXP_CAP ? NEXP_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return NEXP_CAP.getStorage().writeNBT(NEXP_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			NEXP_CAP.getStorage().readNBT(NEXP_CAP, this.instance, null, nbt);
		}
}

