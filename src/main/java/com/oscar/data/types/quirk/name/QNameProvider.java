package com.oscar.data.types.quirk.name;	

import com.oscar.data.types.interfaces.IQName;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QNameProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IQName.class)
		public static final Capability<IQName> QURIKNAME_CAP = null;
		
		private IQName instance = QURIKNAME_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == QURIKNAME_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == QURIKNAME_CAP ? QURIKNAME_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return QURIKNAME_CAP.getStorage().writeNBT(QURIKNAME_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			QURIKNAME_CAP.getStorage().readNBT(QURIKNAME_CAP, this.instance, null, nbt);
		}
}

