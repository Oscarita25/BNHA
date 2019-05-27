package com.oscar.data.types.stamina;

import com.oscar.data.types.interfaces.IStamina;

public class Stamina implements IStamina
{

    private int stamina = 1;

    @Override
    public void setStamina(int stamina) {
        this.stamina = stamina;
    }

    @Override
    public int getStamina() {
        return stamina;
    }
}
