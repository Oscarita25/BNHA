package com.oscar.data.types.quirk.maxact;	

import com.oscar.data.types.interfaces.IQMaxAct;

import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

public class QMaxActProvider implements ICapabilitySerializable<NBTBase>{

		@CapabilityInject(IQMaxAct.class)
		public static final Capability<IQMaxAct> QMaxAct_CAP = null;
		
		private IQMaxAct instance = QMaxAct_CAP.getDefaultInstance();
		
		@Override
		public boolean hasCapability(Capability<?> capability, EnumFacing facing) {
			return capability == QMaxAct_CAP;
		}

		@Override
		public <T> T getCapability(Capability<T> capability, EnumFacing facing) {
			return capability == QMaxAct_CAP ? QMaxAct_CAP.<T> cast(this.instance) : null;
		}

		@Override
		public NBTBase serializeNBT() {
			return QMaxAct_CAP.getStorage().writeNBT(QMaxAct_CAP, this.instance, null);
		}

		@Override
		public void deserializeNBT(NBTBase nbt) {
			QMaxAct_CAP.getStorage().readNBT(QMaxAct_CAP, this.instance, null, nbt);
		}
}

