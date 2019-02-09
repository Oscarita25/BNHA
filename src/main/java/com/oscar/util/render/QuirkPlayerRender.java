package com.oscar.util.render;

import com.oscar.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class QuirkPlayerRender extends RenderPlayer	 {

	EntityPlayer player = Minecraft.getMinecraft().player;
	
	public QuirkPlayerRender(RenderManager renderManager) {
        this(renderManager, false);
	}
	
	public QuirkPlayerRender(RenderManager renderManager, boolean useSmallArms) {
		super(renderManager, useSmallArms);
        GlStateManager.pushMatrix();
		GlStateManager.rotate(-player.rotationYaw, 0, 1, 0);
		RenderingUtil.renderModel(SRRLModelCache.INSTANCE.getBakedModel(new ResourceLocation(Reference.MOD_ID, "quirk/tail"),SRRLModelCache.DEFAULTMODELSTATE,
				DefaultVertexFormats.ITEM,SRRLModelCache.DEFAULTTEXTUREGETTER));
        GlStateManager.popMatrix();

	}
	



}
