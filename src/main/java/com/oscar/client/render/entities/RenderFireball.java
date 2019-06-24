package com.oscar.client.render.entities;

import com.oscar.entity.Fireball;
import com.oscar.util.Reference;

import net.minecraft.client.model.ModelShulkerBullet;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.math.MathHelper;
import net.minecraftforge.fml.client.registry.IRenderFactory;

public class RenderFireball extends Render<Fireball>
{

    private static final ResourceLocation FIREBALL_TEXTURE = new ResourceLocation(Reference.MOD_ID,"textures/quirks/fireball.png");
    private final ModelShulkerBullet model = new ModelShulkerBullet();

    public RenderFireball(RenderManager manager)
    {
        super(manager);
    }

    private float rotLerp(float x, float y, float z)
    {
        float f;

        for (f = y - x; f < -180.0F; f += 360.0F)
        {
            ;
        }

        while (f >= 180.0F)
        {
            f -= 360.0F;
        }

        return x + z * f;
    }

    /**
     * Renders the desired {@code T} type Entity.
     */
    public void doRender(Fireball entity, double x, double y, double z, float entityYaw, float partialTicks)
    {
        GlStateManager.pushMatrix();
        float f = this.rotLerp(entity.prevRotationYaw, entity.rotationYaw, partialTicks);
        float f1 = entity.prevRotationPitch + (entity.rotationPitch - entity.prevRotationPitch) * partialTicks;
        float f2 = (float)entity.ticksExisted + partialTicks;
        GlStateManager.translate((float)x, (float)y + 0.15F, (float)z);
        GlStateManager.rotate(MathHelper.sin(f2 * 0.1F) * 180.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(MathHelper.cos(f2 * 0.1F) * 180.0F, 1.0F, 0.0F, 0.0F);
        GlStateManager.rotate(MathHelper.sin(f2 * 0.15F) * 360.0F, 0.0F, 0.0F, 1.0F);
        GlStateManager.enableRescaleNormal();
        GlStateManager.scale(-1.0F, -1.0F, 1.0F);
        this.bindEntityTexture(entity);
        this.model.render(entity, 0.0F, 0.0F, 0.0F, f, f1, 0.03125F);
        GlStateManager.enableBlend();
        GlStateManager.color(1.0F, 1.0F, 1.0F, 0.5F);
        GlStateManager.scale(1.5F, 1.5F, 1.5F);
        this.model.render(entity, 0.0F, 0.0F, 0.0F, f, f1, 0.03125F);
        GlStateManager.disableBlend();
        GlStateManager.popMatrix();
        super.doRender(entity, x, y, z, entityYaw, partialTicks);
    }

    /**
     * Returns the location of an entity's texture. Doesn't seem to be called unless you call Render.bindEntityTexture.
     */
    protected ResourceLocation getEntityTexture(Fireball entity)
    {
        return FIREBALL_TEXTURE;
    }

    public static class RenderFireballFac implements IRenderFactory<Fireball> {

        public static final RenderFireballFac INSTANCE = new RenderFireballFac();

        @Override
        public Render<? super Fireball> createRenderFor(RenderManager manager) {
            return new RenderFireball(manager);
        }

    }

}
