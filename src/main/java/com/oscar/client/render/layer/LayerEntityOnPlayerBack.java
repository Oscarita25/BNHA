package com.oscar.client.render.layer;

import java.util.ArrayList;
import java.util.List;

import com.oscar.client.render.entities.RenderEngine;
import com.oscar.data.Capabilities;
import com.oscar.entity.Fireball;
import com.oscar.models.EngineModel;
import com.oscar.util.Reference;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerEntityOnPlayerBack implements LayerRenderer<EntityLivingBase>{

    private final RenderManager renderManager;
    protected Render<Fireball> Renderer;
    private ModelBiped Model = new EngineModel(0F);
    private ResourceLocation Resource = RenderEngine.ENGINE_TEXTURE;
	public static List<EntityPlayer> playerlist = new ArrayList<EntityPlayer>();
	public static List<NBTTagCompound> playerNBT = new ArrayList<NBTTagCompound>();

	
    public LayerEntityOnPlayerBack(RenderManager rendermanager)
    {
        this.renderManager = rendermanager;
    }

    public void doRenderLayer(EntityLivingBase player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	this.renderTailModel(player,limbSwing,limbSwingAmount,partialTicks,ageInTicks,netHeadYaw,headPitch,scale);
    	this.renderEngineModel(player,limbSwing,limbSwingAmount,partialTicks,ageInTicks,netHeadYaw,headPitch,scale);        
    }

    private void renderEngineModel(EntityLivingBase player, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
    	
    	
    	if (player.getCapability(Capabilities.modelid, null).getModelDATA() == Reference.engine)
    	{
    		  
              GlStateManager.enableRescaleNormal();
              GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);
              GlStateManager.pushMatrix();

              	if(Renderer == null) 
              	Renderer = new RenderEngine(this.renderManager);
              	
              	Renderer.bindTexture(Resource);
              	
              	
                  GlStateManager.pushMatrix();
                  float f = player.isSneaking() ? -1.3F : -1.5F;
                  GlStateManager.translate(0.0F, f, 0.0F);
                  
                  ageInTicks = 0.0F;

                  Model.setLivingAnimations(player, limbSwing, limbSwingAmount, partialTicks);
                  Model.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, player);
                  Model.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                  
                  Model.isSneak = player.isSneaking();
                  Model.isRiding = player.isRiding();
                  Model.isChild = player.isChild();
                  GlStateManager.popMatrix();
              GlStateManager.popMatrix();


              GlStateManager.disableRescaleNormal();
          }
          		
	}

	private void renderTailModel(EntityLivingBase player, float limbSwing, float limbSwingAmount, float partialTicks,float ageInTicks, float netHeadYaw, float headPitch, float scale) {

    /*	  if (player.getCapability(Capabilities.modelid, null).getModelDATA() == Reference.tail)
        {
            GlStateManager.enableRescaleNormal();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

            	if(Renderer == null) 
            	Renderer = new RenderParrot(this.renderManager);
            	
            	Renderer.bindTexture(Resource);
            	
            	
                GlStateManager.pushMatrix();
                float f = player.isSneaking() ? -1.3F : -1.5F;
                GlStateManager.translate(0.0F, f, 0.0F);
                
                ageInTicks = 0.0F;

                Model.setLivingAnimations(player, limbSwing, limbSwingAmount, partialTicks);
                Model.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, player);
                Model.render(player, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.popMatrix();
            

            GlStateManager.disableRescaleNormal();
        }*/
	}

	public boolean shouldCombineTextures()
    {
        return false;
    }





}
