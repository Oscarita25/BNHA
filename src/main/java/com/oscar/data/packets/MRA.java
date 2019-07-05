package com.oscar.data.packets;

import java.io.IOException;

import javax.annotation.Nullable;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractServerMessage;
import com.oscar.data.types.interfaces.IStamina;
import com.oscar.data.types.quirk.ExplosionQuirk;
import com.oscar.data.types.quirk.Quirk;
import com.oscar.entity.Fireball;
import com.oscar.entity.Icicle;
import com.oscar.util.Reference;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.network.PacketBuffer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.Explosion;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.relauncher.Side;


/**
 * MessageRequestActivation for Requesting the "Quirk" Usage
 */
public class MRA extends AbstractServerMessage<MRA> {
	
	
	private Vec3d loc;

	@Override
	protected void read(PacketBuffer buffer) throws IOException {}
	@Override
	protected void write(PacketBuffer buffer) throws IOException {}
	
	
	/**
	 *HandleMessageRequestActivation for Handling {@link  com.oscar.data.packets.MRA MessageRequestActivation}
	 *(Logic of Quirk SuperPowers)
	 */
	@Override
	public void process(EntityPlayer player, Side side) {

	    
	    if (player == null || !(player instanceof EntityPlayerMP)) {
	    	System.err.println("EntityPlayerMP was null or just an EntityPlayer when MessageActivate was received");
	    	return;
	    }
	    
	    final WorldServer playerWorldServer = ((EntityPlayerMP)player).getServerWorld();
	    playerWorldServer.addScheduledTask(() -> {
	    	activateQuirk(Quirk.getQuirkID(player), (EntityPlayerMP)player, playerWorldServer);
	    });		
	}
	
	private void activateQuirk(int quirkID, EntityPlayerMP sendingPlayer, WorldServer playerWorldServer) {
		final BlockPos playerPos = new BlockPos(sendingPlayer);
        IStamina stamina = sendingPlayer.getCapability(Capabilities.stamina, null);
        

		if(stamina.getStamina() != 0) {
		switch (quirkID) {
			case Reference.none:
    			sendingPlayer.sendMessage(new TextComponentString(TextFormatting.DARK_RED +"something went wrong .. inform the mod author if this apears often"));
				break;
				
			case Reference.quirkless:
    			sendingPlayer.sendMessage(new TextComponentString(TextFormatting.ITALIC +"Youre Trying to do something ... nothing happens"));
				break;
				
			case Reference.explosionquirk:
				setLoc(sendingPlayer);
    			playerWorldServer.createExplosion(
    					sendingPlayer, sendingPlayer.lastTickPosX + getLoc().x ,
    					sendingPlayer.lastTickPosY + 1,
    					sendingPlayer.lastTickPosZ + getLoc().z ,
    					Quirk.getQuirkStrengh(sendingPlayer), false);
    			/*this.newExplosion(sendingPlayer,
    					sendingPlayer.lastTickPosX + getLoc().x,
    					sendingPlayer.lastTickPosY +1, sendingPlayer.lastTickPosZ + getLoc().z,
    					Quirk.getQuirkStrengh(sendingPlayer),
    					playerWorldServer);
    			*/
    			stamina.setStamina(stamina.getStamina() -1);
				break;
				
			case Reference.engine:
				break;
					
			case Reference.hellfire:
				setLoc(sendingPlayer);
				
    			playerWorldServer.spawnEntity(
    					new Fireball(playerWorldServer,
    					sendingPlayer.lastTickPosX + getLoc().x *2 ,
    					sendingPlayer.lastTickPosY + 1,
    					sendingPlayer.lastTickPosZ + getLoc().z *2,
    					sendingPlayer,
    					getLoc().x,
    					getLoc().y,
    					getLoc().z,
    					Quirk.getQuirkStrengh(sendingPlayer)));
    			stamina.setStamina(stamina.getStamina() -1);
				break;
				
			case Reference.icequirk:
				setLoc(sendingPlayer);
    			if(sendingPlayer.onGround)
        			playerWorldServer.spawnEntity(
        					new Icicle(playerWorldServer,
        					sendingPlayer,
        					sendingPlayer.lastTickPosX + getLoc().x *2 ,
        					playerPos.getY(),
        					sendingPlayer.lastTickPosZ + getLoc().z *2,
        					Quirk.getQuirkStrengh(sendingPlayer)));
        			else
    	    			playerWorldServer.spawnEntity(
    	    					new Icicle(playerWorldServer,
    	    					sendingPlayer,
    	    					sendingPlayer.lastTickPosX + getLoc().x *2 ,
    	    					playerPos.getY(),
    	    					sendingPlayer.lastTickPosZ + getLoc().z *2,
    	    					Quirk.getQuirkStrengh(sendingPlayer)));
    			
    			stamina.setStamina(stamina.getStamina() -1);
				break;
				
			case Reference.electrification:
				break;
				
			case Reference.tail:
				break;
			case Reference.steel:
				break;
			case Reference.hardening:
				break;
		}
		}else {
	        for (int i = 0; i < 32; ++i){
	        	if(playerWorldServer instanceof WorldServer) {
	            ((WorldServer)playerWorldServer).spawnParticle(EnumParticleTypes.CRIT, sendingPlayer.posX, sendingPlayer.posY + (double)sendingPlayer.eyeHeight * 0.6D, sendingPlayer.posZ , 1, 0.1D, 0.05D, 0.02D, 0.2D);
	        	}
	        }
		}
		
	}


	

	private void setLoc(EntityPlayerMP sendingPlayer) {
		loc = sendingPlayer.getLookVec();			
	}
	
	private Vec3d getLoc() {
		return loc;
	}

	
    public Explosion newExplosion(@Nullable Entity entity, double x, double y, double z, float strength, WorldServer world)
    {
    	ExplosionQuirk explosion = new ExplosionQuirk(world, entity, x, y, z, strength, false);
        if (net.minecraftforge.event.ForgeEventFactory.onExplosionStart(world, explosion)) return explosion;
        explosion.doExplosionA();
        explosion.doExplosionB(true);
  	  world.spawnParticle(EnumParticleTypes.EXPLOSION_HUGE, entity.posX, entity.posY + world.rand.nextDouble() * 2.4D, entity.posZ, world.rand.nextGaussian() * 0.1D, 0.2D, world.rand.nextGaussian() * 0.1D, new int[0]);
        return explosion;
    }

}
