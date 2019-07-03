package com.oscar.client.render.entities;

import com.oscar.obsidianAPI.render.ModelAnimated;
import com.oscar.obsidianAPI.render.RenderAnimated;
import com.oscar.util.Reference;

import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderTail extends RenderAnimated{

    public static final ResourceLocation TAIL_TEXTURE = new ResourceLocation(Reference.MOD_ID,"textures/quirks/OSCARPUTTEXTUREHERE.png");
    public static final ResourceLocation TAIL_MODEL = new ResourceLocation(Reference.MOD_ID,"models/quirks/OSCARPUTMODELHERE");

	
	public RenderTail(ModelAnimated model) {
		super(model);
	}
	
	public RenderTail(ModelAnimated model,float shadowsize) {
		super(model,shadowsize);
	}
	
	public RenderTail(RenderManager manager,ModelAnimated model, float shadowSize) {
		super(manager,model,shadowSize);
	}




}
