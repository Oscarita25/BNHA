package com.oscar.init;

import com.oscar.util.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.potion.Potion;
import net.minecraft.util.DamageSource;

public class CustPotion extends Potion {
	
 
	
	
    public CustPotion(boolean isBadEffectIn, int liquidColorIn, String name) {
		super(isBadEffectIn, liquidColorIn);
		this.setRegistryName(Reference.MOD_ID,name);
	}

    
    
    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier)
    {
      
         if (this == ModHolder.FROZEN)
        {
            if (entityLivingBaseIn.getHealth() > 1.0F)
            {
                entityLivingBaseIn.attackEntityFrom(DamageSource.MAGIC, 1.0F);
            }
        }
    }
    
    @Override
    public boolean isReady(int duration, int amplifier)
    {
    	if (this == ModHolder.FROZEN)
        {
            int j = 25 >> amplifier;

            if (j > 0)
            {
                return duration % j == 0;
            }
            else
            {
                return true;
            }
        }
    	
    	
		return super.isReady(duration, amplifier);

    }
    

    

}
