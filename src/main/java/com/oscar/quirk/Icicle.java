package com.oscar.quirk;

import net.minecraft.entity.Entity;
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
        setAIMoveSpeed(0);
    }	
	
    public Icicle(World worldIn, EntityPlayerMP source,double x,double y,double z){
        super(worldIn);
        this.posX = x;
        this.posY = y;
        this.posZ = z;
        setSource(source);
        setAIMoveSpeed(0);
    }


    private void setSource(EntityPlayerMP source) {
		this.source = source;
	} 
    
    /**
     * Called to update the entity's position/logic.
     */
    public void onUpdate()
    {
        EntityLivingBase entitylivingbase = this.source;
        AxisAlignedBB box = this.getEntityBoundingBox();

        for (Entity entity : this.world.getEntitiesWithinAABBExcludingEntity(this, box))
        {
            if (entity instanceof EntityLiving)
            {
                ((EntityLiving) entity).setHealth(((EntityLiving) entity).getHealth() - 0.5F);
            }
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
