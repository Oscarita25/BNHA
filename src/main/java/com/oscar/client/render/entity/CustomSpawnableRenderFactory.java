package com.oscar.client.render.entity;

import com.oscar.quirk.CustomSpawnable;

import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class CustomSpawnableRenderFactory implements IRenderFactory<CustomSpawnable> {

	@Override
	public Render<CustomSpawnable> createRenderFor(RenderManager manager) {
		return new RenderCustomSpawnable(manager);
	}

}
