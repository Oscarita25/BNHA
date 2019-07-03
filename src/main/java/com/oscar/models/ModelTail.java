package com.oscar.models;

import com.oscar.obsidianAPI.render.ModelAnimated;
import com.oscar.obsidianAPI.render.wavefront.WavefrontObject;

import net.minecraft.util.ResourceLocation;

public class ModelTail extends ModelAnimated{

	public ModelTail(String entityName, WavefrontObject wavefrontObj, ResourceLocation textureLocation) {
		super(entityName, wavefrontObj, textureLocation);
	}

}
