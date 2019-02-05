package com.oscar.data.types.quirk.id;	

import com.oscar.data.types.interfaces.IQuirkID;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QuirkIDProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IQuirkID.class)
		public static final Capability<IQuirkID> QUIRKID_CAP = null;
		
		private IQuirkID instance = QUIRKID_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == QUIRKID_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == QUIRKID_CAP ? QUIRKID_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return QUIRKID_CAP.getStorage().writeNBT(QUIRKID_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			QUIRKID_CAP.getStorage().readNBT(QUIRKID_CAP, this.instance, null, nbt);
		}
}

