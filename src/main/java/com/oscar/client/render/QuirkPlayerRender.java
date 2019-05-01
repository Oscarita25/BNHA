package com.oscar.client.render;

import com.oscar.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class QuirkPlayerRender extends RenderPlayer	 {

	EntityPlayer player = Minecraft.getMinecraft().player;
	static boolean model = false;
	
	public QuirkPlayerRender(RenderManager renderManager) {
        this(renderManager, false);
	}
	
	public QuirkPlayerRender(RenderManager renderManager, boolean useSmallArms) {
		super(renderManager, useSmallArms);
		if(getModel() == true) {
		GlStateManager.pushMatrix();
		GlStateManager.translate(0, player.height - 1.25, 0);
		GlStateManager.rotate(-player.renderYawOffset, 0, 1, 0);
		RenderingUtil.renderModel(SRRLModelCache.INSTANCE.getBakedModel(new ResourceLocation(Reference.MOD_ID, "tail")));
		GlStateManager.popMatrix();	
		}
	}
	
	
    public void doRender(AbstractClientPlayer entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
		GlStateManager.pushMatrix();

		GlStateManager.popMatrix();	

    
	}
    
    public static boolean getModel() {
		return model;
    }
   
    public static void setModel(boolean showmodel) {
    	model = showmodel;
    }

}
