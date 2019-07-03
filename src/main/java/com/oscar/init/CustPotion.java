package com.oscar.init;

import com.oscar.util.Reference;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.potion.Potion;

public class CustPotion extends Potion {
	

	
	
    public CustPotion(boolean isBadEffectIn, int liquidColorIn, String name) {
		super(isBadEffectIn, liquidColorIn);
		this.setPotionName(name);
		this.setRegistryName(Reference.MOD_ID,name);
		this.setIconIndex(1, 2);
		this.setEffectiveness(0.25D);
	}

    
    
    @Override
    public void performEffect(EntityLivingBase entityLivingBaseIn, int amplifier){
    	entityLivingBaseIn.getEntityAttribute(SharedMonsterAttributes.MOVEMENT_SPEED).setBaseValue(0.02);

    }
    

    @Override
    public boolean isReady(int duration, int amplifier)
   {
           return this == ModHolder.FROZEN;
       
   }
 
}
