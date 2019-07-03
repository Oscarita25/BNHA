package com.oscar.data.types.interfaces;

import com.oscar.data.types.api.ICapability;

public interface IStamina extends ICapability{
    boolean setStamina(int stamina);
    boolean setMaxStamina(int stamina);

    int getStamina();
    int getMaxStamina();


}
