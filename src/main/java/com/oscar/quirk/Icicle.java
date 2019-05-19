package com.oscar.quirk;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class Icicle extends EntityLiving{
	
	private EntityPlayerMP source = null;

    public Icicle(World worldIn){
        super(worldIn);
        setAIMoveSpeed(1);
    }	
	
    public Icicle(World worldIn, EntityPlayerMP source,double x,double y,double z){
        super(worldIn);
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        setSource(source);
        setAIMoveSpeed(1);
    }


    private void setSource(EntityPlayerMP source) {
		this.source = source;
	} 
    
    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate()
    {
        super.onUpdate();

        EntityLivingBase entitylivingbase = this.source;
        AxisAlignedBB box = this.getEntityBoundingBox();
/*
        for (Entity entity : this.world.getEntitiesWithinAABBExcludingEntity(this, box))
        {
            if (entity instanceof EntityLiving && entity != this.source)
            {
/*            	if(ticksExisted % 20 == 0) {
            		entity.attackEntityFrom((new DamageSource("Ice")).setMagicDamage(), 0.2F);    
            		entity.performHurtAnimation();
            	}
            }
        }*/
        
        if(ticksExisted == 10) {
        	this.setDead();
        }
        
        
        
        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }

    }




}
