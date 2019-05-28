package com.oscar.data.types.stamina;

import com.oscar.data.types.interfaces.IStamina;
import net.minecraft.nbt.NBTBase;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class StaminaProvidor implements ICapabilitySerializable<NBTBase> {


    @CapabilityInject(IStamina.class)
    public static final Capability<IStamina> STAMINA_CAP = null;

    private IStamina instance = STAMINA_CAP.getDefaultInstance();

    @Override
    public boolean hasCapability(@Nonnull Capability<?> capability, @Nullable EnumFacing facing) {
        return capability == STAMINA_CAP;
    }

    @Nullable
    @Override
    public <T> T getCapability(@Nonnull Capability<T> capability, @Nullable EnumFacing facing) {
        return  capability == STAMINA_CAP ? STAMINA_CAP.<T> cast(this.instance) : null;
    }

    @Override
    public NBTBase serializeNBT() {
        return STAMINA_CAP.getStorage().writeNBT(STAMINA_CAP, this.instance, null);
    }

    @Override
    public void deserializeNBT(NBTBase nbt) {
        STAMINA_CAP.getStorage().readNBT(STAMINA_CAP, this.instance, null, nbt);
    }
}
