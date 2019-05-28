package com.oscar.data.types.stamina;

import com.oscar.data.types.interfaces.IStamina;
import net.minecraft.nbt.NBTBase;
import net.minecraft.nbt.NBTPrimitive;
import net.minecraft.nbt.NBTTagInt;
import net.minecraft.util.EnumFacing;
import net.minecraftforge.common.capabilities.Capability;

import javax.annotation.Nullable;

public class StaminaStorage implements Capability.IStorage<IStamina>
{
    @Nullable
    @Override
    public NBTBase writeNBT(Capability<IStamina> capability, IStamina instance, EnumFacing side) {
        return new NBTTagInt(instance.getStamina());
    }

    @Override
    public void readNBT(Capability<IStamina> capability, IStamina instance, EnumFacing side, NBTBase nbt) {
        instance.setStamina(((NBTPrimitive) nbt).getInt());
    }
}
