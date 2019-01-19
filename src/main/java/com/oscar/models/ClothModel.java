package com.oscar.models;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;


public class ClothModel extends ModelBiped {
    private ModelRenderer RArm;
    private ModelRenderer LLeg;
    private ModelRenderer Head;
    private ModelRenderer Body;
    private ModelRenderer LArm;
    private ModelRenderer RLeg;
    
    public ClothModel(float size) {
    	super(size, 0, 64,32);
    	
        this.textureWidth = 64;
        this.textureHeight = 32;
        
        this.LArm = new ModelRenderer(this, 40, 16);
        this.LArm.addBox(-1.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);

        this.Body = new ModelRenderer(this, 16, 16);
        this.Body.addBox(-4.0F, 0.0F, -2.0F, 8, 12, 4, 0.0F);
        
        this.RLeg = new ModelRenderer(this, 0, 16);
        this.RLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        this.RLeg.mirror = true;
        
        this.LLeg = new ModelRenderer(this, 0, 16);
        this.LLeg.addBox(-2.0F, 0.0F, -2.0F, 4, 12, 4, 0.0F);
        
        this.RArm = new ModelRenderer(this, 40, 16);
        this.RArm.addBox(-3.0F, -2.0F, -2.0F, 4, 12, 4, 0.0F);
        
        

        this.Head = new ModelRenderer(this, 0, 0);
        this.Head.addBox(-4.0F, -8.0F, -4.0F, 8, 8, 8, 0.0F);
        
        bipedLeftArm.addChild(LArm);
        bipedBody.addChild(Body);        
        bipedRightLeg.addChild(RLeg);
        bipedLeftLeg.addChild(LLeg);
        bipedRightArm.addChild(RArm);
        bipedHead.addChild(Head);
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
   	 	 super.render(entity, f, f1, f2, f3, f4, f5);
   	 	 LArm.isHidden = true;
   	 	 Body.isHidden = true;
   	 	 RLeg.isHidden = true;
   	 	 LLeg.isHidden = true;
   	 	 RArm.isHidden = true;
   	 	 Head.isHidden = true;
    }
}