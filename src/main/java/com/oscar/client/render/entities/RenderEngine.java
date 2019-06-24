package com.oscar.client.render.entities;

import com.oscar.entity.Fireball;
import com.oscar.util.Reference;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;

public class RenderEngine extends Render<Fireball>{

    public static final ResourceLocation ENGINE_TEXTURE = new ResourceLocation(Reference.MOD_ID,"textures/quirks/engine.png");

    public RenderEngine(RenderManager manager)
    {
        super(manager);
    }


    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(Fireball entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
      
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

	@Override
	protected ResourceLocation getEntityTexture(Fireball entity) {
		return ENGINE_TEXTURE;
	}

}
