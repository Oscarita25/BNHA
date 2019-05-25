package com.oscar.models;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

/**
 * ModelBiped - Either Mojang or a mod author
 * Created using Tabula 4.1.1
 */
public class Ice_Arm extends ModelBiped {
    public ModelRenderer IceArm;
    public ModelRenderer Spike1;
    public ModelRenderer Spike2;
    public ModelRenderer Spike3;
    public ModelRenderer Spike4;
    public ModelRenderer Spike5;
    public ModelRenderer Spike6;
    public ModelRenderer Spike7;
    public ModelRenderer Spike8;
    public ModelRenderer Spike9;
    public ModelRenderer Spike10;
    public ModelRenderer Spike11;
    public ModelRenderer Spike12;
    public ModelRenderer Spike13;
    public ModelRenderer Spike14;
    public ModelRenderer Spike15;
    public ModelRenderer Spike16;
    public ModelRenderer Spike17;
    public ModelRenderer Spike18;

    /* TODO make use of this model !!
     * 
     *  it is a awesome model that should be used
     */
    
    
    
    public Ice_Arm() {
        this.textureWidth = 64;
        this.textureHeight = 32;
        
        this.IceArm = new ModelRenderer(this, 6, 5);
        this.IceArm.setRotationPoint(-8.2F, -0.5F, -2.5F);
        this.IceArm.addBox(0.0F, 0.0F, 0.0F, 4, 13, 4, 0.0F);
        this.setRotateAngle(IceArm, 0.0F, -0.005759586531581288F, 0.0F);
        
        this.Spike1 = new ModelRenderer(this, 54, 0);
        this.Spike1.setRotationPoint(-7.9F, -1.1F, -1.6000000000000005F);
        this.Spike1.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Spike1, 0.0F, 0.0F, 0.6610878749656024F);
        
        this.Spike2 = new ModelRenderer(this, 54, 5);
        this.Spike2.setRotationPoint(-8.0F, -1.5F, -1.3000000000000003F);
        this.Spike2.addBox(0.0F, 0.0F, 0.0F, 2, 1, 2, 0.0F);
        this.setRotateAngle(Spike2, 0.0F, 0.0F, 0.1367768017170213F);
        
        this.Spike3 = new ModelRenderer(this, 54, 10);
        this.Spike3.setRotationPoint(-8.1F, -2.2F, -1.0999999999999999F);
        this.Spike3.addBox(0.0F, 0.0F, 0.0F, 1, 1, 2, 0.0F);
        this.setRotateAngle(Spike3, 0.0F, 0.0F, -0.19376713576578017F);
        
        this.Spike4 = new ModelRenderer(this, 57, 14);
        this.Spike4.setRotationPoint(-8.0F, -3.8F, -0.5F);
        this.Spike4.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, 0.0F);
        this.setRotateAngle(Spike4, 0.0F, 0.0F, -0.32916909692613056F);
        
        this.Spike5 = new ModelRenderer(this, 30, 0);
        this.Spike5.setRotationPoint(-9.6F, -2.8F, -0.9F);
        this.Spike5.addBox(0.0F, 0.0F, 0.0F, 1, 6, 1, 0.0F);
        this.setRotateAngle(Spike5, 0.0F, 0.0F, -0.285012266850674F);
        
        this.Spike6 = new ModelRenderer(this, 24, 4);
        this.Spike6.setRotationPoint(-9.5F, -0.4F, -0.9F);
        this.Spike6.addBox(0.0F, 0.0F, 0.0F, 2, 2, 1, 0.0F);
        this.setRotateAngle(Spike6, 0.0F, 0.0F, -0.4387757739513744F);
        
        this.Spike7 = new ModelRenderer(this, 56, 20);
        this.Spike7.mirror = true;
        this.Spike7.setRotationPoint(-9.3F, 5.3F, -1.1F);
        this.Spike7.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, -0.1F);
        
        this.Spike8 = new ModelRenderer(this, 56, 26);
        this.Spike8.setRotationPoint(-9.0F, 4.9F, 0.2F);
        this.Spike8.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, -0.1F);
        this.setRotateAngle(Spike8, 0.0F, 0.0F, -0.3755948550291797F);
        
        this.Spike9 = new ModelRenderer(this, 47, 17);
        this.Spike9.setRotationPoint(-7.1F, 7.5F, 1.7F);
        this.Spike9.addBox(0.0F, 0.0F, 0.0F, 2, 4, 2, -0.1F);
        this.setRotateAngle(Spike9, -0.2546435378659727F, 0.0F, -0.024434609527920613F);
        
        this.Spike10 = new ModelRenderer(this, 38, 18);
        this.Spike10.setRotationPoint(-7.0F, 6.1F, 1.3F);
        this.Spike10.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, -0.1F);
        this.setRotateAngle(Spike10, -0.28047441079548874F, 0.0F, 0.0F);
        
        this.Spike11 = new ModelRenderer(this, 37, 26);
        this.Spike11.setRotationPoint(-6.9F, 0.9F, -3.4F);
        this.Spike11.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, -0.1F);
        this.setRotateAngle(Spike11, 0.5326744877086693F, 0.0F, 0.0F);
        
        this.Spike12 = new ModelRenderer(this, 47, 26);
        this.Spike12.setRotationPoint(-6.9F, 0.0F, -3.1F);
        this.Spike12.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, -0.1F);
        this.setRotateAngle(Spike12, 0.27104963283471933F, 0.0F, -0.0F);
        
        this.Spike13 = new ModelRenderer(this, 37, 26);
        this.Spike13.setRotationPoint(-7.7F, 6.3F, -3.0F);
        this.Spike13.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, -0.1F);
        this.setRotateAngle(Spike13, 0.12147491593880534F, 0.0F, 0.0F);
        
        this.Spike14 = new ModelRenderer(this, 37, 26);
        this.Spike14.setRotationPoint(-6.7F, 5.8F, -3.7F);
        this.Spike14.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, -0.1F);
        this.setRotateAngle(Spike14, 0.364424747816416F, 0.0F, 0.0F);
        
        this.Spike15 = new ModelRenderer(this, 37, 26);
        this.Spike15.setRotationPoint(-9.0F, 8.2F, -1.1F);
        this.Spike15.addBox(0.0F, 0.0F, 0.0F, 2, 3, 2, -0.1F);
        this.setRotateAngle(Spike15, 0.0F, 0.0F, -0.29914943379182807F);

        this.Spike16 = new ModelRenderer(this, 47, 26);
        this.Spike16.setRotationPoint(-9.0F, 5.0F, -2.4F);
        this.Spike16.addBox(0.0F, 0.0F, 0.0F, 2, 2, 2, -0.1F);
        this.setRotateAngle(Spike16, 0.0F, 0.0F, -0.26162485487395F);
        
        this.setRotateAngle(Spike7, 0.0F, 0.0F, -0.28797932657906433F);
        this.Spike17 = new ModelRenderer(this, 56, 26);
        this.Spike17.setRotationPoint(-6.5F, 3.3F, 1.5F);
        this.Spike17.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, -0.1F);
        this.setRotateAngle(Spike17, -0.27104963283471933F, 0.0F, 0.0F);
        
        this.Spike18 = new ModelRenderer(this, 56, 26);
        this.Spike18.setRotationPoint(-6.5F, 0.0F, 1.5F);
        this.Spike18.addBox(0.0F, 0.0F, 0.0F, 1, 4, 2, -0.1F);
        this.setRotateAngle(Spike18, -0.19617500792416265F, 0.0F, 0.0F);
        
        
        this.IceArm.addChild(Spike1);
        this.IceArm.addChild(Spike2);
        this.IceArm.addChild(Spike3);
        this.IceArm.addChild(Spike4);
        this.IceArm.addChild(Spike5);
        this.IceArm.addChild(Spike6);
        this.IceArm.addChild(Spike7);
        this.IceArm.addChild(Spike8);
        this.IceArm.addChild(Spike9);
        this.IceArm.addChild(Spike10);
        this.IceArm.addChild(Spike11);
        this.IceArm.addChild(Spike12);
        this.IceArm.addChild(Spike13);
        this.IceArm.addChild(Spike14);
        this.IceArm.addChild(Spike15);
        this.IceArm.addChild(Spike16);
        this.IceArm.addChild(Spike17);
        this.IceArm.addChild(Spike18);
        
        super.bipedLeftArm.addChild(IceArm);
        
        
    }

    @Override
    public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) { 
        this.Spike16.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike14.offsetX, this.Spike14.offsetY, this.Spike14.offsetZ);
        GL11.glTranslatef(this.Spike14.rotationPointX * f5, this.Spike14.rotationPointY * f5, this.Spike14.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike14.offsetX, -this.Spike14.offsetY, -this.Spike14.offsetZ);
        GL11.glTranslatef(-this.Spike14.rotationPointX * f5, -this.Spike14.rotationPointY * f5, -this.Spike14.rotationPointZ * f5);
        this.Spike14.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike2.offsetX, this.Spike2.offsetY, this.Spike2.offsetZ);
        GL11.glTranslatef(this.Spike2.rotationPointX * f5, this.Spike2.rotationPointY * f5, this.Spike2.rotationPointZ * f5);
        GL11.glScaled(1.9487171000000014D, 3.1124909521200026D, 1.4641000000000006D);
        GL11.glTranslatef(-this.Spike2.offsetX, -this.Spike2.offsetY, -this.Spike2.offsetZ);
        GL11.glTranslatef(-this.Spike2.rotationPointX * f5, -this.Spike2.rotationPointY * f5, -this.Spike2.rotationPointZ * f5);
        this.Spike2.render(f5);
        GL11.glPopMatrix();
        this.Spike8.render(f5);
        this.Spike7.render(f5);
        this.Spike17.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike12.offsetX, this.Spike12.offsetY, this.Spike12.offsetZ);
        GL11.glTranslatef(this.Spike12.rotationPointX * f5, this.Spike12.rotationPointY * f5, this.Spike12.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike12.offsetX, -this.Spike12.offsetY, -this.Spike12.offsetZ);
        GL11.glTranslatef(-this.Spike12.rotationPointX * f5, -this.Spike12.rotationPointY * f5, -this.Spike12.rotationPointZ * f5);
        this.Spike12.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike10.offsetX, this.Spike10.offsetY, this.Spike10.offsetZ);
        GL11.glTranslatef(this.Spike10.rotationPointX * f5, this.Spike10.rotationPointY * f5, this.Spike10.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike10.offsetX, -this.Spike10.offsetY, -this.Spike10.offsetZ);
        GL11.glTranslatef(-this.Spike10.rotationPointX * f5, -this.Spike10.rotationPointY * f5, -this.Spike10.rotationPointZ * f5);
        this.Spike10.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike6.offsetX, this.Spike6.offsetY, this.Spike6.offsetZ);
        GL11.glTranslatef(this.Spike6.rotationPointX * f5, this.Spike6.rotationPointY * f5, this.Spike6.rotationPointZ * f5);
        GL11.glScaled(1.2D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike6.offsetX, -this.Spike6.offsetY, -this.Spike6.offsetZ);
        GL11.glTranslatef(-this.Spike6.rotationPointX * f5, -this.Spike6.rotationPointY * f5, -this.Spike6.rotationPointZ * f5);
        this.Spike6.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.IceArm.offsetX, this.IceArm.offsetY, this.IceArm.offsetZ);
        GL11.glTranslatef(this.IceArm.rotationPointX * f5, this.IceArm.rotationPointY * f5, this.IceArm.rotationPointZ * f5);
        GL11.glScaled(1.02D, 0.98D, 1.22D);
        GL11.glTranslatef(-this.IceArm.offsetX, -this.IceArm.offsetY, -this.IceArm.offsetZ);
        GL11.glTranslatef(-this.IceArm.rotationPointX * f5, -this.IceArm.rotationPointY * f5, -this.IceArm.rotationPointZ * f5);
        this.IceArm.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike11.offsetX, this.Spike11.offsetY, this.Spike11.offsetZ);
        GL11.glTranslatef(this.Spike11.rotationPointX * f5, this.Spike11.rotationPointY * f5, this.Spike11.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike11.offsetX, -this.Spike11.offsetY, -this.Spike11.offsetZ);
        GL11.glTranslatef(-this.Spike11.rotationPointX * f5, -this.Spike11.rotationPointY * f5, -this.Spike11.rotationPointZ * f5);
        this.Spike11.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike3.offsetX, this.Spike3.offsetY, this.Spike3.offsetZ);
        GL11.glTranslatef(this.Spike3.rotationPointX * f5, this.Spike3.rotationPointY * f5, this.Spike3.rotationPointZ * f5);
        GL11.glScaled(1.9487171000000014D, 3.1124909521200026D, 1.1712800000000003D);
        GL11.glTranslatef(-this.Spike3.offsetX, -this.Spike3.offsetY, -this.Spike3.offsetZ);
        GL11.glTranslatef(-this.Spike3.rotationPointX * f5, -this.Spike3.rotationPointY * f5, -this.Spike3.rotationPointZ * f5);
        this.Spike3.render(f5);
        GL11.glPopMatrix();
        this.Spike9.render(f5);
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike4.offsetX, this.Spike4.offsetY, this.Spike4.offsetZ);
        GL11.glTranslatef(this.Spike4.rotationPointX * f5, this.Spike4.rotationPointY * f5, this.Spike4.rotationPointZ * f5);
        GL11.glScaled(1.36D, 1.29D, 0.74D);
        GL11.glTranslatef(-this.Spike4.offsetX, -this.Spike4.offsetY, -this.Spike4.offsetZ);
        GL11.glTranslatef(-this.Spike4.rotationPointX * f5, -this.Spike4.rotationPointY * f5, -this.Spike4.rotationPointZ * f5);
        this.Spike4.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike5.offsetX, this.Spike5.offsetY, this.Spike5.offsetZ);
        GL11.glTranslatef(this.Spike5.rotationPointX * f5, this.Spike5.rotationPointY * f5, this.Spike5.rotationPointZ * f5);
        GL11.glScaled(1.0D, 1.0D, 0.9D);
        GL11.glTranslatef(-this.Spike5.offsetX, -this.Spike5.offsetY, -this.Spike5.offsetZ);
        GL11.glTranslatef(-this.Spike5.rotationPointX * f5, -this.Spike5.rotationPointY * f5, -this.Spike5.rotationPointZ * f5);
        this.Spike5.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike13.offsetX, this.Spike13.offsetY, this.Spike13.offsetZ);
        GL11.glTranslatef(this.Spike13.rotationPointX * f5, this.Spike13.rotationPointY * f5, this.Spike13.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike13.offsetX, -this.Spike13.offsetY, -this.Spike13.offsetZ);
        GL11.glTranslatef(-this.Spike13.rotationPointX * f5, -this.Spike13.rotationPointY * f5, -this.Spike13.rotationPointZ * f5);
        this.Spike13.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike15.offsetX, this.Spike15.offsetY, this.Spike15.offsetZ);
        GL11.glTranslatef(this.Spike15.rotationPointX * f5, this.Spike15.rotationPointY * f5, this.Spike15.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike15.offsetX, -this.Spike15.offsetY, -this.Spike15.offsetZ);
        GL11.glTranslatef(-this.Spike15.rotationPointX * f5, -this.Spike15.rotationPointY * f5, -this.Spike15.rotationPointZ * f5);
        this.Spike15.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike18.offsetX, this.Spike18.offsetY, this.Spike18.offsetZ);
        GL11.glTranslatef(this.Spike18.rotationPointX * f5, this.Spike18.rotationPointY * f5, this.Spike18.rotationPointZ * f5);
        GL11.glScaled(0.9D, 1.0D, 1.0D);
        GL11.glTranslatef(-this.Spike18.offsetX, -this.Spike18.offsetY, -this.Spike18.offsetZ);
        GL11.glTranslatef(-this.Spike18.rotationPointX * f5, -this.Spike18.rotationPointY * f5, -this.Spike18.rotationPointZ * f5);
        this.Spike18.render(f5);
        GL11.glPopMatrix();
        GL11.glPushMatrix();
        GL11.glTranslatef(this.Spike1.offsetX, this.Spike1.offsetY, this.Spike1.offsetZ);
        GL11.glTranslatef(this.Spike1.rotationPointX * f5, this.Spike1.rotationPointY * f5, this.Spike1.rotationPointZ * f5);
        GL11.glScaled(1.9487171000000014D, 3.1124909521200026D, 1.4641000000000006D);
        GL11.glTranslatef(-this.Spike1.offsetX, -this.Spike1.offsetY, -this.Spike1.offsetZ);
        GL11.glTranslatef(-this.Spike1.rotationPointX * f5, -this.Spike1.rotationPointY * f5, -this.Spike1.rotationPointZ * f5);
        this.Spike1.render(f5);
        GL11.glPopMatrix();
    }

    public void setRotateAngle(ModelRenderer modelRenderer, float x, float y, float z) {
        modelRenderer.rotateAngleX = x;
        modelRenderer.rotateAngleY = y;
        modelRenderer.rotateAngleZ = z;
    }
}
