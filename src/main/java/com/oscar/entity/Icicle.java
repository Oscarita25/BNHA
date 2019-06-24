package com.oscar.entity;

import com.oscar.init.ModHolder;

import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.world.World;

public class Icicle extends EntityLiving{
	
	private EntityPlayerMP source;
	private float damage = 0.5F;
    private double i = 0;
	private double zlook;
	private double xlook;

    public Icicle(World worldIn){
        super(worldIn);
        setSize(1F, 2F);
    }	
	
    public Icicle(World worldIn, EntityPlayerMP src,double x,double y,double z,float damage){
        super(worldIn);
        this.setLocationAndAngles(x, y, z, src.rotationYaw, src.rotationPitch);
        this.setSize(1F, 3F);
        this.setDamage(damage);
        this.setSource(src);
        this.setXLook(src.getLookVec().x);
        this.setZLook(src.getLookVec().z);
    }


    private void setZLook(double z) {
    	this.zlook = z;
	}

	private void setXLook(double x) {
		this.xlook = x;		
	}

	private double getZLook() {
		return this.zlook;
	}
	
	private double getXLook() {
		return this.xlook;
	}
	
	private void setDamage(float damage) {
    	this.damage = damage;
	}

    @Override
    public void onCollideWithPlayer(EntityPlayer entityIn){
        EntityLivingBase entitylivingbase = this.source;
    	entityIn.attackEntityFrom(DamageSource.causeIndirectDamage(entityIn, entitylivingbase), getDamage());
        ((EntityLivingBase) entityIn).addPotionEffect(new PotionEffect(Potion.getPotionById(Potion.getIdFromPotion(ModHolder.FROZEN))));
    }
    
	
	@Override
    public boolean canBeCollidedWith()
    {
        return false;
    }
	
    @Override
    public boolean canBePushed() {
    	return false;
    }
    
    @Override
    public boolean getIsInvulnerable() {
    	return true;
    }
    
    @Override
    protected boolean canEquipItem(ItemStack stack){
        return false;
    }
    
    private float getDamage() {
    	return this.damage;
    }
    
	private void setSource(EntityPlayerMP src) {
		this.source = src;
	} 
	

    /**
     * Called to update the entity's position/logic.
     */
    @Override
    public void onUpdate(){
        super.onUpdate();
        EntityLivingBase entitylivingbase = this.source;
        AxisAlignedBB box = this.getEntityBoundingBox();


        for (Entity entity : this.world.getEntitiesWithinAABBExcludingEntity(this, box))
        {
            if (entity instanceof EntityLiving && !(entity instanceof Icicle) && !(entity instanceof EntityPlayer))
            {
            		entity.attackEntityFrom(DamageSource.causeIndirectDamage(entity, entitylivingbase), getDamage());
                    ((EntityLivingBase) entity).addPotionEffect(new PotionEffect(Potion.getPotionById(Potion.getIdFromPotion(ModHolder.FROZEN))));
            	
            }
        }
        
        /*if(ticksExisted % 20 == 0) {
        	if(entitylivingbase instanceof EntityPlayerMP) {
        		if(ticksExisted == 20)
        			entitylivingbase.sendMessage(new TextComponentString("existed 1 second"));
        		if(ticksExisted == 40)
        			entitylivingbase.sendMessage(new TextComponentString("existed 2 seconds"));
        		if(ticksExisted == 60)
        			entitylivingbase.sendMessage(new TextComponentString("existed 3 seconds"));

        	}
        }
        		unneeded debugging stuff for now
        */

        if(ticksExisted % 1 == 0) {
        	if(entitylivingbase instanceof EntityPlayerMP) {
        		this.setPositionAndUpdate((this.posX + (getXLook() * i)), this.posY, (this.posZ + (getZLook() * i)));
                for (int i = 0; i < 32; ++i)
                {
          	  	this.world.spawnParticle(EnumParticleTypes.FLAME, this.posX, this.posY + this.rand.nextDouble() * 2.4D, this.posZ, this.rand.nextGaussian() * 0.1D, 0.2D, this.rand.nextGaussian() * 0.1D, new int[0]);
                }
          	  	i += 0.009D;
        	}
        }
        
        
        if(ticksExisted == 60) {
        	this.setDead();
        }
        
        
        
        if (entitylivingbase != null && entitylivingbase instanceof EntityPlayer && !entitylivingbase.isEntityAlive())
        {
            this.setDead();
        }

    }




}
