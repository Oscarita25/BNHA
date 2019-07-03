package com.oscar.data.types.quirk;

import java.util.Random;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.SoundEvents;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.SoundCategory;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;

public class ExplosionQuirk extends Explosion
{

    
    /** whether or not this explosion spawns smoke particles */
    private final World world;
    private final double x;
    private final double y;
    private final double z;
    private Random rand;
    private Vec3d position;
	private float size;
	private Entity entity;
    /** A list of ChunkPositions of blocks affected by this explosion */




    public ExplosionQuirk(World worldIn, Entity entityIn, double x, double y, double z, float size, boolean flaming)
    {
    	super(worldIn,entityIn,x,y,z,size,flaming,false);
        this.world = worldIn;
        this.x = x;
        this.y = y;
        this.z = z;
        this.size = size;
        this.entity = entityIn;
        this.rand = new Random();
        this.position = new Vec3d(this.x, this.y, this.z);
    }



    /**
     * Does the second part of the explosion (sound, particles, drop spawn)
     */
    @Override
    public void doExplosionB(boolean spawnParticles)
    {
        this.world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, this.entity.posX, this.entity.posY + this.world.rand.nextDouble() * 2.4D, this.entity.posZ, this.world.rand.nextGaussian() * 0.1D, 0.2D, this.world.rand.nextGaussian() * 0.1D);
        this.world.playSound((EntityPlayer)null, this.x, this.y, this.z, SoundEvents.ENTITY_GENERIC_EXPLODE, SoundCategory.BLOCKS, 4.0F, (1.0F + (this.world.rand.nextFloat() - this.world.rand.nextFloat()) * 0.2F) * 0.7F);        
    }
 
    @Override
    public Vec3d getPosition(){ return this.position; }


}