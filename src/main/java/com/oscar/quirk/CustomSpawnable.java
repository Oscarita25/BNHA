package com.oscar.quirk;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;

import com.google.common.collect.Lists;
import com.google.common.collect.Sets;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.enchantment.EnchantmentProtection;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.entity.projectile.EntityThrowable;
import net.minecraft.init.Blocks;
import net.minecraft.network.play.server.SPacketExplosion;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EntityDamageSourceIndirect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.AxisAlignedBB;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.Explosion;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Config;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;


public class CustomSpawnable extends Explosion{
		/**
		 * Returns an explosion damage source with the thrower of the explosive, if
		 * available, set as the indirect entity.
		 */
		public static DamageSource getExplosionSource(CustomSpawnable explosion) {
			if (explosion.exploder instanceof EntityThrowable) {
				return new EntityDamageSourceIndirect("explosion", explosion.exploder, ((EntityThrowable) explosion.exploder).getThrower()).setExplosion().setDifficultyScaled();
			}
			return DamageSource.causeExplosionDamage(explosion);
		}

		/** Type of liquids to ignore when calculating which blocks to affect */
		public static enum IgnoreLiquid{NONE, ALL, WATER, LAVA};

		// Duplicate final private values in Explosion class
		public final boolean isSmoking;
		public final boolean isFlaming;
		public final double explosionX;
		public final double explosionY;
		public final double explosionZ;
		public final Entity exploder;
		public final float explosionSize;
		// Super class field not needed as none of the super methods are called
		private final List<BlockPos> affectedBlockPositions;

		/**
		 * Creates an explosion based on the BombType given, automatically applying
		 * various characteristics. If more versatility than this is required, create a
		 * CustomExplosion object from scratch rather than using the static methods and
		 * call doExplosionA(), then doExplosionB().
		 */
		
	/*----- TODO	public static void createExplosion(World world, double x, double y, double z, float radius, BombType type) {
			createExplosion(new EntityBomb(world).setType(type), world, x, y, z, radius, 0.0F, true);
		}

		/**
		 * Creates an explosion based on the IEntityBomb given, automatically applying
		 * various characteristics. If more versatility than this is required, create a
		 * CustomExplosion object from scratch rather than using the static methods and
		 * call doExplosionA(), then doExplosionB().
		 * @param damage Use 0.0F for vanilla explosion damage; amounts above zero will cause a flat amount regardless of distance
		 */
		
	/*--- TODO	public static void createExplosion(IEntityBomb bomb, World world, double x, double y, double z, float radius, float damage, boolean canGrief) {
			CustomSpawnable explosion = new CustomSpawnable(world, (Entity) bomb, x, y, z, radius, canGrief, false).setDamage(damage);
			BombType type = bomb.getType();
			// TODO Adventure Mode is only set per player, not per world
			//boolean isAdventureMode = (world.getWorldInfo().getGameType() == GameType.ADVENTURE);
			boolean restrictBlocks = false; // (isAdventureMode && !bomb.canGriefAdventureMode());
			explosion.setMotionFactor(bomb.getMotionFactor());
			explosion.scalesWithDistance = (damage == 0.0F);
			explosion.targetBlock = null;
			explosion.ignoreLiquidType = type.ignoreLiquidType;
			float f = bomb.getDestructionFactor();
			// TODO doesn't allow for any other 'hell' type dimensions...
			if (world.provider.getDimensionType().getName().equals("Nether") && type != BombType.BOMB_FIRE) {
				f *= 0.5F;
			}
			explosion.restrictExplosionBy(f);
			explosion.doExplosionA();
			explosion.doExplosionB(true);
			if (bomb.hasPostExplosionEffect()) {
				type.postExplosionEffect(world, explosion);
			}
		}

		/** Whether or not this explosion will damage entities within the blast explosionSize */
		public boolean inflictsDamage = true;

		/** Whether the damage amount scales with distance from explosion's center, as well as chance of catching fire */
		public boolean scalesWithDistance = true;

		/** Exclude a certain type of liquid when determining which blocks are affected, usually making the explosion more devastating */
		public IgnoreLiquid ignoreLiquidType = IgnoreLiquid.NONE;

		/** Specific block to target, if any (defaults to all blocks) */
		public Block targetBlock = null;

		/** Type of DamageSource that this explosion will cause; leave null for vanilla explosion damage */
		protected DamageSource source = null;

		/** Amount of damage to inflict; if 0.0F, vanilla explosion damage amount will be used instead */
		protected float damage = 0.0F;

		/** Amount of time for which affected entities will be set on fire; only if explosion isFlaming */
		protected int burnTime = 0;

		/** Factor by which affected entity's motion will be multiplied */
		protected float motionFactor = 1.0F;

		/** Maximum explosionSize within which blocks can be affected, regardless of explosion size */
		protected static final int MAX_RADIUS = 16;

		/** Restricts (or expands) the blast radius for destroying blocks by this factor */
		protected float restrictExplosion = 1.0F;

		/** Originally private Random from super class */
		protected final Random rand = new Random();

		/** Originally private World object from super class */
		protected final World worldObj;

		/** Maps players to the knockback vector applied by the explosion, to send to the client; private in original class */
		protected Map<EntityPlayer, Vec3d> playerKnockbackMap = new HashMap<EntityPlayer, Vec3d>();

		@SideOnly(Side.CLIENT)
		public CustomSpawnable(World world, Entity exploder, double x, double y, double z, float explosionSize, boolean isSmoking, boolean isFlaming, List<BlockPos> affectedBlocks) {
			this(world, exploder, x, y, z, explosionSize, isSmoking, isFlaming);
			this.affectedBlockPositions.addAll(affectedBlocks);
		}

		/**
		 * Creates a custom explosion; isSmoking is true by default, and isFlaming is false by default
		 */
		public CustomSpawnable(World world, Entity exploder, double x, double y, double z, float explosionSize) {
			this(world, exploder, x, y, z, explosionSize, true, false);
		}

		public CustomSpawnable(World world, Entity exploder, double x, double y, double z, float explosionSize, boolean isSmoking, boolean isFlaming) {
			super(world, exploder, x, y, z, explosionSize, isSmoking, isFlaming);
			this.worldObj = world;
			this.isSmoking = isSmoking;
			this.isFlaming = isFlaming;
			this.explosionX = x;
			this.explosionY = y;
			this.explosionZ = z;
			this.explosionSize = explosionSize;
			this.exploder = exploder;
			this.affectedBlockPositions = Lists.newArrayList();
		}

		/**
		 * Sets the DamageSource this explosion will cause; returns itself for convenience
		 */
		public CustomSpawnable setSource(DamageSource source) {
			this.source = source;
			return this;
		}

		/**
		 * Returns the damage source to use; if source is null, default explosion-type DamageSource is used
		 */
		protected DamageSource getDamageSource() {
			return (source != null ? source : CustomSpawnable.getExplosionSource(this));
		}

		/**
		 * Sets amount of damage this explosion will cause; returns itself for convenience
		 */
		public CustomSpawnable setDamage(float amount) {
			damage = amount;
			return this;
		}

		/**
		 * Sets amount of time for which affected entities will burn; returns itself for convenience
		 */
		public CustomSpawnable setBurnTime(int ticks) {
			burnTime = ticks;
			return this;
		}

		/**
		 * Sets amount by which entity's motion will be multiplied
		 */
		public CustomSpawnable setMotionFactor(float amount) {
			motionFactor = amount;
			return this;
		}

		/**
		 * Sets the factor by which to restrict block destruction (smaller factor means less destruction; 1.0F is normal size);
		 * returns itself for convenience
		 */
		public CustomSpawnable restrictExplosionBy(float factor) {
			restrictExplosion = factor;
			return this;
		}

		/**
		 * Does the first part of the explosion (destroy blocks)
		 */
		@Override
		public void doExplosionA() {
			if (isSmoking && restrictExplosion > 0) {
				populateAffectedBlocksList();
			}
			if (inflictsDamage) {
				affectEntitiesWithin();
			}
		}

		/**
		 * Does the second part of the explosion (sound, particles, drop spawn)
		 */
	/*------- TODO	@Override
		public void doExplosionB(boolean spawnExtraParticles) {
			worldObj.playSoundEffect(explosionX, explosionY, explosionZ, Sounds.EXPLOSION, 4.0F, (1.0F + (worldObj.rand.nextFloat() - worldObj.rand.nextFloat()) * 0.2F) * 0.7F);
			if (explosionSize >= 2.0F && isSmoking) {
				worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D);
			} else {
				worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_LARGE, explosionX, explosionY, explosionZ, 1.0D, 0.0D, 0.0D);
			}

			Iterator<BlockPos> iterator;
			BlockPos blockpos;
			Block block;
			if (isSmoking) {
				iterator = affectedBlockPositions.iterator();
				while (iterator.hasNext()) {
					blockpos = iterator.next();
					block = worldObj.getBlockState(blockpos).getBlock();
					explodeBlockAt(block, blockpos, spawnExtraParticles);
				}
			}

			if (isFlaming) {
				iterator = affectedBlockPositions.iterator();
				while (iterator.hasNext()) {
					blockpos = iterator.next();
					block = worldObj.getBlockState(blockpos).getBlock();
					if (block == Blocks.AIR && worldObj.getBlockState(blockpos.down()).getBlock().isFullBlock(null) && rand.nextInt(3) == 0) {
						worldObj.setBlockState(blockpos, Blocks.FIRE.getDefaultState());
					}
				}
			}

			notifyClients();
		}

		/**
		 * Actually explodes the block and spawns particles if allowed
		 */
		private void explodeBlockAt(Block block, BlockPos blockpos, boolean spawnExtraParticles) {
			if (spawnExtraParticles) {
				double d0 = (double)((float) blockpos.getX() + worldObj.rand.nextFloat());
				double d1 = (double)((float) blockpos.getY() + worldObj.rand.nextFloat());
				double d2 = (double)((float) blockpos.getZ() + worldObj.rand.nextFloat());
				double d3 = d0 - explosionX;
				double d4 = d1 - explosionY;
				double d5 = d2 - explosionZ;
				double d6 = (double) MathHelper.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
				d3 /= d6;
				d4 /= d6;
				d5 /= d6;
				double d7 = 0.5D / (d6 / (double) explosionSize + 0.1D);
				d7 *= (double)(worldObj.rand.nextFloat() * worldObj.rand.nextFloat() + 0.3F);
				d3 *= d7;
				d4 *= d7;
				d5 *= d7;
				worldObj.spawnParticle(EnumParticleTypes.EXPLOSION_NORMAL, (d0 + explosionX * 1.0D) / 2.0D, (d1 + explosionY * 1.0D) / 2.0D, (d2 + explosionZ * 1.0D) / 2.0D, d3, d4, d5);
				worldObj.spawnParticle(EnumParticleTypes.SMOKE_NORMAL, d0, d1, d2, d3, d4, d5);
			}
			if (block.getMaterial(null) != Material.AIR) {
				if (block.canDropFromExplosion(this)) {
					block.dropBlockAsItemWithChance(worldObj, blockpos, worldObj.getBlockState(blockpos), 1.0F /  explosionSize, 0);
				}
				block.onBlockExploded(worldObj, blockpos, this);
			}
		}

		/**
		 * Populates the affectedBlocksList with any blocks that should be affected by this explosion
		 */
		protected void populateAffectedBlocksList() {
			HashSet<BlockPos> hashset = Sets.newHashSet();
			float radius = Math.min(explosionSize * restrictExplosion, 16.0F);
			for (int i = 0; i < MAX_RADIUS; ++i) {
				for (int j = 0; j < MAX_RADIUS; ++j) {
					for (int k = 0; k < MAX_RADIUS; ++k) {
						if (i == 0 || i == MAX_RADIUS - 1 || j == 0 || j == MAX_RADIUS - 1 || k == 0 || k == MAX_RADIUS - 1)
						{
							double d3 = (double)((float)i / ((float) MAX_RADIUS - 1.0F) * 2.0F - 1.0F);
							double d4 = (double)((float)j / ((float) MAX_RADIUS - 1.0F) * 2.0F - 1.0F);
							double d5 = (double)((float)k / ((float) MAX_RADIUS - 1.0F) * 2.0F - 1.0F);
							double d6 = Math.sqrt(d3 * d3 + d4 * d4 + d5 * d5);
							d3 /= d6;
							d4 /= d6;
							d5 /= d6;
							float f1 = radius * (0.7F + worldObj.rand.nextFloat() * 0.6F);
							double d0 = explosionX;
							double d1 = explosionY;
							double d2 = explosionZ;

							for (float f2 = 0.3F; f1 > 0.0F; f1 -= 0.22500001F)
							{
								int l = MathHelper.floor(d0);
								int i1 = MathHelper.floor(d1);
								int j1 = MathHelper.floor(d2);
								BlockPos blockpos = new BlockPos(l, i1, j1);
								IBlockState iblockstate = worldObj.getBlockState(blockpos);
								Block block = iblockstate.getBlock();
								Material material = block.getMaterial(null);
								if (material != Material.AIR) {
									// True if block resistance should reduce the explosion radius
									boolean flag = !material.isLiquid() || ignoreLiquidType == IgnoreLiquid.NONE || 
											(ignoreLiquidType == IgnoreLiquid.WATER && material != Material.WATER) ||
											(ignoreLiquidType == IgnoreLiquid.LAVA && material != Material.LAVA);
									if (flag) {
										float f3 = exploder != null ? exploder.getExplosionResistance(this, worldObj, blockpos, iblockstate) : block.getExplosionResistance(worldObj, blockpos, null, this);
										f1 -= (f3 + 0.3F) * 0.3F;
									}
								}
								if (f1 > 0.0F && (targetBlock == null || block == targetBlock ) &&
										(exploder == null || exploder.canExplosionDestroyBlock(this, worldObj, blockpos, iblockstate, f1)))
								{
									hashset.add(blockpos);
								}

								d0 += d3 * (double)f2;
								d1 += d4 * (double)f2;
								d2 += d5 * (double)f2;
							}
						}
					}
				}
			}

			affectedBlockPositions.addAll(hashset);
		}

		/**
		 * Affects all entities within the explosion, causing damage if flagged to do so
		 */
		protected void affectEntitiesWithin() {
			float diameter = explosionSize * 2.0F;
			int i1 = MathHelper.floor(explosionX - (double) explosionSize - 1.0D);
			int j1 = MathHelper.floor(explosionY - (double) explosionSize - 1.0D);
			int k1 = MathHelper.floor(explosionZ - (double) explosionSize - 1.0D);
			int i2 = MathHelper.floor(explosionX + (double) explosionSize + 1.0D);
			int j2 = MathHelper.floor(explosionY + (double) explosionSize + 1.0D);
			int k2 = MathHelper.floor(explosionZ + (double) explosionSize + 1.0D);
			List<Entity> list = worldObj.getEntitiesWithinAABBExcludingEntity(exploder, new AxisAlignedBB((double)i1, (double)j1, (double)k1, (double)i2, (double)j2, (double)k2));
			net.minecraftforge.event.ForgeEventFactory.onExplosionDetonate(worldObj, this, list, diameter);
			Vec3d vec3 = new Vec3d(explosionX, explosionY, explosionZ);
			for (int n = 0; n < list.size(); ++n) {
				Entity entity = list.get(n);
				if (entity.isImmuneToExplosions()) {
					continue;
				}
				double d7 = (scalesWithDistance ? entity.getDistance(explosionX, explosionY, explosionZ) / (double) diameter : 0.0D);
				if (d7 <= 1.0D) {
					double d0 = entity.posX - explosionX;
					double d1 = entity.posY + (double) entity.getEyeHeight() - explosionY;
					double d2 = entity.posZ - explosionZ;
					double d8 = (double) MathHelper.sqrt(d0 * d0 + d1 * d1 + d2 * d2);
					if (d8 != 0.0D) {
						d0 /= d8;
						d1 /= d8;
						d2 /= d8;
						double d9 = (double) worldObj.getBlockDensity(vec3, entity.getEntityBoundingBox());
						double d10 = (1.0D - d7) * d9;
						float amount = (damage == 0.0F ? (float)((int)((d10 * d10 + d10) / 2.0D * 8.0D * diameter + 1.0D)) : damage * (float) d10);
						if (entity.attackEntityFrom(getDamageSource(), amount) && isFlaming && !entity.isImmuneToFire()) {
							if (!scalesWithDistance || rand.nextFloat() < d10) {
								entity.setFire(burnTime);
							}
						}
						double d11 = EnchantmentProtection.getBlastDamageReduction((EntityLivingBase) entity, d10);
						entity.motionX += d0 * d11 * motionFactor;
						entity.motionY += d1 * d11 * motionFactor;
						entity.motionZ += d2 * d11 * motionFactor;
						if (entity instanceof EntityPlayer) {
							playerKnockbackMap.put((EntityPlayer) entity, new Vec3d(d0 * d10, d1 * d10, d2 * d10));
						}
					}
				}
			}
		}

		/** Returns map of affected players */
		@Override
		public Map<EntityPlayer, Vec3d> getPlayerKnockbackMap() { return playerKnockbackMap; }

		protected void notifyClients() {
			if (!worldObj.isRemote) {
				Iterator<EntityPlayer> iterator = worldObj.playerEntities.iterator();
				while (iterator.hasNext()) {
					EntityPlayer player = iterator.next();
					if (player.getDistanceSq(explosionX, explosionY, explosionZ) < 4096.0D) {
						((EntityPlayerMP) player).getServerWorld().sendPacketToServer(new SPacketExplosion(explosionX, explosionY, explosionZ, explosionSize, affectedBlockPositions, (Vec3d) this.getPlayerKnockbackMap().get(player)));
					}
				}
			}
		}
}
