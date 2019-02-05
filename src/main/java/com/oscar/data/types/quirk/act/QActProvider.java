package com.oscar.data.types.quirk.act;	

import com.oscar.data.types.interfaces.IQAct;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QActProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IQAct.class)
		public static final Capability<IQAct> QACT_CAP = null;
		
		private IQAct instance = QACT_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == QACT_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == QACT_CAP ? QACT_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return QACT_CAP.getStorage().writeNBT(QACT_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			QACT_CAP.getStorage().readNBT(QACT_CAP, this.instance, null, nbt);
		}
}

