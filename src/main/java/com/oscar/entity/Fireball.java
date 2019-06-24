package com.oscar.entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.world.World;

public class Fireball extends EntityThrowable{

	EnumParticleTypes type = EnumParticleTypes.LAVA;
	private float damage;

    public Fireball(World worldIn){
        super(worldIn);
    }	
	
    public Fireball(World worldIn, EntityLivingBase entitylivingbase){
        super(worldIn, entitylivingbase);
    }

    public Fireball(World worldIn, double x, double y, double z,EntityPlayerMP source,double velx,double vely,double velz,float strengh)
    {
        super(worldIn, x, y, z);
        setSize(0.1F,0.1F);
        setSource(source);
        shoot(velx, vely, velz, 1, 1);
        setDamage(strengh);
        super.setFire(300);
     }


    private void setDamage(float strengh) {
    	this.damage = strengh;
	}

	private void setSource(EntityPlayerMP source) {
		this.thrower = source;
	}
    
	private float getDamage() {
		return this.damage;
	}

    @Override
    protected float getGravityVelocity()
    {
        return 0.001F;
    }
    
    
	@Override
    protected void onImpact(RayTraceResult result)
    {
        EntityLivingBase entitylivingbase = this.getThrower();

        
        
        if (result.entityHit != null && entitylivingbase != null)
        {
         	
        	result.entityHit.attackEntityFrom(DamageSource.causeThrownDamage(this, entitylivingbase), getDamage());
        }

        for (int i = 0; i < 32; ++i)
        {
        	  this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + this.rand.nextDouble() * 2.4D, this.posZ, this.rand.nextGaussian() * 0.1D, 0.2D, this.rand.nextGaussian() * 0.1D, new int[0]);
        }
        
        this.setDead();

    }

    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
    	
        EntityLivingBase entitylivingbase = this.getThrower();
        
        if(this.ticksExisted >= 100) {
        	this.setDead();
        }

        
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