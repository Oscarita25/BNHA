package com.oscar.client.render.entity;

import com.oscar.models.ModelCustomSpawnable;
import com.oscar.quirk.CustomSpawnable;
import com.oscar.util.Reference;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderCustomSpawnable extends Render<CustomSpawnable> {

	private ModelBase model;

	
	public RenderCustomSpawnable(RenderManager rendermanagerIn) {
		super(rendermanagerIn);
		model = new ModelCustomSpawnable();
	}

	@Override
	protected ResourceLocation getEntityTexture(CustomSpawnable entity) {
		return new ResourceLocation(Reference.MOD_ID,"textures/quirks/fire.png");
	}
	
	@Override
	public void doRender(CustomSpawnable entity, double x, double y, double z, float entityYaw, float partialTicks){
	        super.doRender(entity, x, y, z, entityYaw, partialTicks);
	        GlStateManager.pushMatrix();
	        GlStateManager.translate(x, y, z);
	        model.render(entity, 0.0F, 0.0F, 0.0F, 0.0F, 0.0F, 0.0625F);


	    }

	
	
}
