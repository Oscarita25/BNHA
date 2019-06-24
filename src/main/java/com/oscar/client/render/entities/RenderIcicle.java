package com.oscar.client.render.entities;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLiving;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderIcicle implements IRenderFactory<EntityLiving>{

	public static final RenderIcicle INSTANCE = new RenderIcicle();

	@Override
	public Render<? super EntityLiving> createRenderFor(RenderManager manager) {
		return null;
	}

}
