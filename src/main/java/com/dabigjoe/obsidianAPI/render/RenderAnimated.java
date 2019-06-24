package com.dabigjoe.obsidianAPI.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

@SuppressWarnings("rawtypes")
public class RenderAnimated extends RenderLiving implements IRenderAnimated
{

	private ModelAnimated model;
	
	public RenderAnimated(ModelAnimated model)
	{
		this(model, 1.0F);
	}
	
	public RenderAnimated(ModelAnimated model, float shadowSize)
	{
		super(Minecraft.getMinecraft().getRenderManager(), model, shadowSize);
		this.model = model;
	}
	
	public RenderAnimated(RenderManager manager,ModelAnimated model, float shadowSize)
	{
		super(manager, model, shadowSize);
		this.model = model;
	}
	
	@Override
	public ModelAnimated getModel() {
		return model;
	}
	
	@Override
	protected ResourceLocation getEntityTexture(Entity entity) 
	{
		return model.getTexture(entity);
	}

}
