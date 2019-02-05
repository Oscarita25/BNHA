package com.oscar.data.types.quirk.cool;	

import com.oscar.data.types.interfaces.IQCool;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QCoolProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IQCool.class)
		public static final Capability<IQCool> COOL_CAP = null;
		
		private IQCool instance = COOL_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == COOL_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == COOL_CAP ? COOL_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return COOL_CAP.getStorage().writeNBT(COOL_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			COOL_CAP.getStorage().readNBT(COOL_CAP, this.instance, null, nbt);
		}
}

