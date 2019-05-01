package com.oscar.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.entity.Entity;

public class ModelCustomSpawnable extends ModelBiped {

    public ModelCustomSpawnable() {
    	super(1.0F, 0, 16,16);
    }
    
    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
    	
    }
}
