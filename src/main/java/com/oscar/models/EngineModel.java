package com.oscar.models;
//Made with Blockbench By MegaBee
//Paste this code into your mod.

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelBox;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

public class EngineModel extends ModelBiped {

	//high
	private final ModelRenderer highright;
	private final ModelRenderer highleft;
	
		private final ModelRenderer righig;
		private final ModelRenderer lefhig;
	
		private final ModelRenderer righig2;
		private final ModelRenderer lefhig2;

	//mid
	private final ModelRenderer middleright;
	private final ModelRenderer middleleft;
	
		private final ModelRenderer rigmid2;
		private final ModelRenderer lefmid2;
	
		private final ModelRenderer rigmid;
		private final ModelRenderer lefmid;
	
	//low
	private final ModelRenderer lowright;
	private final ModelRenderer lowleft;
	
		private final ModelRenderer riglow;
		private final ModelRenderer leflow;
	
		private final ModelRenderer riglow2;
		private final ModelRenderer leflow2;

	public EngineModel(float size) {
    	super(size, 0, 16,16);

    	
        this.textureWidth = 16;
        this.textureHeight = 16;

    	

		lowright = new ModelRenderer(this);
		lowright.setRotationPoint(1.5F, 9.5F, 2.5F);
		setRotationAngle(lowright, 0.2618F, 0.0F, 0.0F);
		

		lowleft = new ModelRenderer(this);
		lowleft.setRotationPoint(-1.5F, 9.5F, 2.5F);
		setRotationAngle(lowleft, 0.2618F, 0.0F, 0.0F);



		middleright = new ModelRenderer(this);
		middleright.setRotationPoint(1.5F, 6.5F, 2.5F);
		setRotationAngle(middleright, 0.2618F, 0.0F, 0.0F);
		

		middleleft = new ModelRenderer(this);
		middleleft.setRotationPoint(-1.5F, 6.5F, 2.5F);
		setRotationAngle(middleleft, 0.2618F, 0.0F, 0.0F);


		highright = new ModelRenderer(this);
		highright.setRotationPoint(1.5F, 3.5F, 2.5F);
		setRotationAngle(highright, 0.2618F, 0.0F, 0.0F);
		
		highleft = new ModelRenderer(this);
		highleft.setRotationPoint(-1.5F, 3.5F, 2.5F);
		setRotationAngle(highleft, 0.2618F, 0.0F, 0.0F);


		
		//right high
		righig = new ModelRenderer(this);
		righig.setRotationPoint(-1.5F, 0.0F, 0.5F);
		highright.addChild(righig);
		righig.cubeList.add(new ModelBox(righig, 6, 13, -0.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		righig.cubeList.add(new ModelBox(righig, 6, 13, 0.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		righig.cubeList.add(new ModelBox(righig, 6, 13, -0.5F, -0.5F, -1.1F, 1, 1, 0, 0.0F, false));

		//left high
		lefhig = new ModelRenderer(this);
		lefhig.setRotationPoint(-1.5F, 0.0F, 0.5F);
		highleft.addChild(lefhig);
		lefhig.cubeList.add(new ModelBox(lefhig, 6, 13, 2.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		lefhig.cubeList.add(new ModelBox(lefhig, 6, 13, 3.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		lefhig.cubeList.add(new ModelBox(lefhig, 6, 13, 2.5F, -0.5F, -1.1F, 1, 1, 0, 0.0F, false));
		
		//right high 2
		righig2 = new ModelRenderer(this);
		righig2.setRotationPoint(-1.5F, 0.0F, 0.5F);
		setRotationAngle(righig2, 0.0F, 0.0F, 1.5708F);
		highright.addChild(righig2);
		righig2.cubeList.add(new ModelBox(righig2, 6, 13, -0.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		righig2.cubeList.add(new ModelBox(righig2, 6, 13, 0.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		
		//left high 2
		lefhig2 = new ModelRenderer(this);
		lefhig2.setRotationPoint(-1.5F, 0.0F, 0.5F);
		highleft.addChild(lefhig2);
		setRotationAngle(lefhig2, 0.0F, 0.0F, 1.5708F);
		lefhig2.cubeList.add(new ModelBox(lefhig2, 6, 13, -0.5F, -3.5F, -1.0F, 0, 1, 2, 0.0F, false));
		lefhig2.cubeList.add(new ModelBox(lefhig2, 6, 13, 0.4F, -3.5F, -1.0F, 0, 1, 2, 0.0F, false));
		
		
		//--
		
		//right middle
		rigmid = new ModelRenderer(this);
		rigmid.setRotationPoint(-1.5F, 0.0F, 0.5F);
		setRotationAngle(rigmid, 0.0F, 0.0F, 1.5708F);
		middleright.addChild(rigmid);
		rigmid.cubeList.add(new ModelBox(rigmid, 6, 13, -0.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		rigmid.cubeList.add(new ModelBox(rigmid, 6, 13, 0.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));

		//left middle
		lefmid = new ModelRenderer(this);
		lefmid.setRotationPoint(-1.5F, 0.0F, 0.5F);
		setRotationAngle(lefmid, 0.0F, 0.0F, 1.5708F);
		middleleft.addChild(lefmid);
		lefmid.cubeList.add(new ModelBox(lefmid, 6, 13, -0.5F, -3.5F, -1.0F, 0, 1, 2, 0.0F, false));
		lefmid.cubeList.add(new ModelBox(lefmid, 6, 13, 0.4F, -3.5F, -1.0F, 0, 1, 2, 0.0F, false));

		//right middle 2
		rigmid2 = new ModelRenderer(this);
		rigmid2.setRotationPoint(-1.5F, 0.0F, 0.5F);
		middleright.addChild(rigmid2);
		rigmid2.cubeList.add(new ModelBox(rigmid2, 6, 13, -0.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		rigmid2.cubeList.add(new ModelBox(rigmid2, 6, 13, 0.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		rigmid2.cubeList.add(new ModelBox(rigmid2, 6, 13, -0.5F, -0.5F, -1.1F, 1, 1, 0, 0.0F, false));
		
		//left middle 2 
		lefmid2 = new ModelRenderer(this);
		lefmid2.setRotationPoint(-1.5F, 0.0F, 0.5F);
		middleleft.addChild(lefmid2);
		lefmid2.cubeList.add(new ModelBox(lefmid2, 6, 13, 2.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		lefmid2.cubeList.add(new ModelBox(lefmid2, 6, 13, 3.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		lefmid2.cubeList.add(new ModelBox(lefmid2, 6, 13, 2.5F, -0.5F, -1.1F, 1, 1, 0, 0.0F, false));
		
		//--
		
		
		//right lowest
		riglow = new ModelRenderer(this);
		riglow.setRotationPoint(-1.5F, 0.0F, 0.5F);
		lowright.addChild(riglow);
		riglow.cubeList.add(new ModelBox(riglow, 6, 13, -0.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		riglow.cubeList.add(new ModelBox(riglow, 6, 13, 0.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		riglow.cubeList.add(new ModelBox(riglow, 6, 13, -0.5F, -0.5F, -1.1F, 1, 1, 0, 0.0F, false));
		
		
		//left lowest
		leflow = new ModelRenderer(this);
		leflow.setRotationPoint(-1.5F, 0.0F, 0.5F);
		lowleft.addChild(leflow);
		leflow.cubeList.add(new ModelBox(leflow, 6, 13, 2.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		leflow.cubeList.add(new ModelBox(leflow, 6, 13, 3.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		leflow.cubeList.add(new ModelBox(leflow, 6, 13, 2.5F, -0.5F, -1.1F, 1, 1, 0, 0.0F, false));

		
		//right lowest 2
		riglow2 = new ModelRenderer(this);
		riglow2.setRotationPoint(-1.5F, 0.0F, 0.5F);
		setRotationAngle(riglow2, 0.0F, 0.0F, 1.5708F);
		lowright.addChild(riglow2);
		riglow2.cubeList.add(new ModelBox(riglow2, 6, 13, -0.5F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		riglow2.cubeList.add(new ModelBox(riglow2, 6, 13, 0.4F, -0.5F, -1.0F, 0, 1, 2, 0.0F, false));
		
		//left lowest 2
		leflow2 = new ModelRenderer(this);
		leflow2.setRotationPoint(-1.5F, 0.0F, 0.5F);
		setRotationAngle(leflow2, 0.0F, 0.0F, 1.5708F);
		lowleft.addChild(leflow2);
		leflow2.cubeList.add(new ModelBox(leflow2, 6, 13, -0.5F, -3.5F, -1.0F, 0, 1, 2, 0.0F, false));
		leflow2.cubeList.add(new ModelBox(leflow2, 6, 13, 0.4F, -3.5F, -1.0F, 0, 1, 2, 0.0F, false));
		

	}
	
	public void addChildmodels(ModelBiped model) {
		model.bipedRightLeg.addChild(highright);
		model.bipedRightLeg.addChild(middleright);
		model.bipedRightLeg.addChild(lowright);
		
		model.bipedLeftLeg.addChild(highleft);
		model.bipedLeftLeg.addChild(middleleft);
		model.bipedLeftLeg.addChild(lowleft);
	}

	@Override
	public void render(Entity entityIn, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {
		bipedLeftLeg.render(scale);
		bipedRightLeg.render(scale);
		

	}
	
	@Override
	public void setRotationAngles(float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scaleFactor, Entity entityIn){
		super.setRotationAngles(limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scaleFactor, entityIn);
/*		
        boolean flag = entityIn instanceof EntityLivingBase && ((EntityLivingBase)entityIn).getTicksElytraFlying() > 4;

        float f = 1.0F;

        if (flag)
        {
            f = (float)(entityIn.motionX * entityIn.motionX + entityIn.motionY * entityIn.motionY + entityIn.motionZ * entityIn.motionZ);
            f = f / 0.2F;
            f = f * f * f;
        }

        if (f < 1.0F)
        {
            f = 1.0F;
        }
       
	 this.highright.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f) /4F;
	 this.middleright.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f) /4F;
	 this.lowright.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F) * 1.4F * limbSwingAmount / f) /4F;


     this.highleft.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f) /2.2F;
     this.middleleft.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f) /2.2F;
     this.lowleft.rotateAngleX = (MathHelper.cos(limbSwing * 0.6662F + (float)Math.PI) * 1.4F * limbSwingAmount / f) /2.2F;

     
     if (this.isRiding)
     {
         this.highright.rotateAngleX = -1.4137167F;
         this.middleright.rotateAngleX = -1.4137167F;
         this.lowright.rotateAngleX = -1.4137167F;
         
         this.highright.rotateAngleY = ((float)Math.PI / 10F);
         this.middleright.rotateAngleY = ((float)Math.PI / 10F);
         this.lowright.rotateAngleY = ((float)Math.PI / 10F);

         this.highright.rotateAngleZ = 0.07853982F;
         this.middleright.rotateAngleZ = 0.07853982F;
         this.lowright.rotateAngleZ = 0.07853982F;

         this.highleft.rotateAngleX = -1.4137167F;
         this.middleleft.rotateAngleX = -1.4137167F;
         this.lowleft.rotateAngleX = -1.4137167F;

         this.highleft.rotateAngleY = -((float)Math.PI / 10F);
         this.middleleft.rotateAngleY = -((float)Math.PI / 10F);
         this.lowleft.rotateAngleY = -((float)Math.PI / 10F);

         this.highleft.rotateAngleZ = -0.07853982F;
         this.middleleft.rotateAngleZ = -0.07853982F;
         this.lowleft.rotateAngleZ = -0.07853982F;
     }
     

     if (this.isSneak)
     {

         this.rightcontrol.rotationPointZ = 4.0F;
         this.leftcontrol.rotationPointZ = 4.0F;
         this.rightcontrol.rotationPointY = 9.0F;
         this.leftcontrol.rotationPointY = 9.0F;
     }
     */
	}
	
	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}