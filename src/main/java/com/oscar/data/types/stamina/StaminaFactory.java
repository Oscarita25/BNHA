package com.oscar.data.types.stamina;

import com.oscar.data.types.interfaces.IStamina;

import java.util.concurrent.Callable;

public class StaminaFactory implements Callable<IStamina>
{
    @Override
    public IStamina call() throws Exception {
        return new Stamina();
    }
}
