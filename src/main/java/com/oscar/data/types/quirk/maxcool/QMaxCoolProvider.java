package com.oscar.data.types.quirk.maxcool;	

import com.oscar.data.types.interfaces.IQMaxCool;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QMaxCoolProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IQMaxCool.class)
		public static final Capability<IQMaxCool> MAXCOOl_CAP = null;
		
		private IQMaxCool instance = MAXCOOl_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == MAXCOOl_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == MAXCOOl_CAP ? MAXCOOl_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return MAXCOOl_CAP.getStorage().writeNBT(MAXCOOl_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			MAXCOOl_CAP.getStorage().readNBT(MAXCOOl_CAP, this.instance, null, nbt);
		}
}

