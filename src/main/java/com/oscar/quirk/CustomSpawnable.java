package com.oscar.quirk;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CustomSpawnable extends EntityThrowable{

	float vel = 0.03F;
	boolean qtp = false;
	EnumParticleTypes type = EnumParticleTypes.LAVA;
	
    public CustomSpawnable(World worldIn){
        super(worldIn);
        setSize(0.1F,0.1F);
    }	
	
    public CustomSpawnable(World worldIn, EntityLivingBase entitylivingbase){
        super(worldIn, entitylivingbase);
        setSize(0.1F,0.1F);
    }

    @SideOnly(Side.CLIENT)
    public CustomSpawnable(World worldIn, double x, double y, double z,EntityPlayerMP source,boolean qtp,float incvel, float velx, float vely, float velz)
    {
        super(worldIn, x, y, z);
        setSize(0.1F,0.1F);
        setSource(source);
        setQTp(qtp);
        setVelocity(velx, vely, velz);
        setincVel(incvel);
    }


    private void setSource(EntityPlayerMP source) {
		this.thrower = source;
	}
    
    private void setQTp(boolean qtp) {
		this.qtp = qtp;
	}
    
    private void setincVel(float incvel) {
    	this.vel = incvel;
    }
    
    @Override
    protected float getGravityVelocity()
    {
        return vel;
    }
    
    
	@Override
    protected void onImpact(RayTraceResult result)
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        if (result.entityHit != null)
        {
        	result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), 20.0F);
        }

        for (int i = 0; i < 32; ++i)
        {
            this.world.spawnParticle(type, this.posX, this.posY + this.rand.nextDouble() * 2.0D, this.posZ, this.rand.nextGaussian(), 0.0D, this.rand.nextGaussian(), new int[0]);
        }

        if (!this.world.isRemote)
        {
            if (entitylivingbase instanceof EntityPlayerMP && qtp == true)
            {
                EntityPlayerMP entityplayermp = (EntityPlayerMP)entitylivingbase;

                if (entityplayermp.world == this.world && !entityplayermp.isPlayerSleeping())
                {
                    net.minecraftforge.event.entity.living.EnderTeleportEvent event = new net.minecraftforge.event.entity.living.EnderTeleportEvent(entityplayermp, this.posX, this.posY, this.posZ, 5.0F);
                    if (!net.minecraftforge.common.MinecraftForge.EVENT_BUS.post(event))
                    { // Don't indent to lower patch size

                    if (entitylivingbase.isRiding())
                    {
                        entitylivingbase.dismountEntity((Entity)null);
                    }

                    entitylivingbase.setPositionAndUpdate(event.getTargetX(), event.getTargetY(), event.getTargetZ());
                    entitylivingbase.fallDistance = 0.0F;
                    entitylivingbase.attackEntityFrom(DamageSource.FALL, event.getAttackDamage());
                    }
                }
            }
            
            this.setDead();
        }
    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        EntityLivingBase entitylivingbase = this.getThrower();
        
        
        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }
        else
        {
            super.onUpdate();
        }
    }


}