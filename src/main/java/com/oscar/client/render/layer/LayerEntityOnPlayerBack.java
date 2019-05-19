package com.oscar.client.render.layer;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestModel;
import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.model.ModelProvider;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelParrot;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.RenderLivingBase;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderParrot;
import net.minecraft.client.renderer.entity.layers.LayerRenderer;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class LayerEntityOnPlayerBack implements LayerRenderer<EntityLivingBase>{

    private final RenderManager renderManager;
    protected RenderLivingBase <? extends EntityLivingBase > Renderer;
    private ModelBase Model = new ModelParrot();
    private ResourceLocation Resource = RenderParrot.PARROT_TEXTURES[2];


    public LayerEntityOnPlayerBack(RenderManager rendermanager)
    {
        this.renderManager = rendermanager;
    }

    public void doRenderLayer(EntityLivingBase entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch, float scale)
    {
    	IModelID model = entitylivingbaseIn.getCapability(ModelProvider.MODEL_CAP, null);
    	
    	if(ageInTicks % 2000 == 0)
		BNHA.NETWORK.sendToServer(new MessageRequestModel());

    	
    	//System.out.println("ID: " + model.getModelID());
    	
        if (model.getModelID() != 0 && model.getModelID() != 5)
        {
            GlStateManager.enableRescaleNormal();
            GlStateManager.color(1.0F, 1.0F, 1.0F, 1.0F);

            if (model.getModelID() == 1)
            {
            	if(Renderer == null) 
            	Renderer = new RenderParrot(this.renderManager);
            	
            	Renderer.bindTexture(Resource);
            	
            	
                GlStateManager.pushMatrix();
                float f = entitylivingbaseIn.isSneaking() ? -1.3F : -1.5F;
                GlStateManager.translate(0.0F, f, 0.0F);
                
                ageInTicks = 0.0F;

                Model.setLivingAnimations(entitylivingbaseIn, limbSwing, limbSwingAmount, partialTicks);
                Model.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale, entitylivingbaseIn);
                Model.render(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
                GlStateManager.popMatrix();
            }

            GlStateManager.disableRescaleNormal();
        }
    }

    public boolean shouldCombineTextures()
    {
        return false;
    }





}
