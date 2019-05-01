package com.oscar.data.packets;

import com.oscar.data.types.quirk.Quirk;
import com.oscar.quirk.CustomSpawnable;
import com.oscar.util.Reference;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageRequestActivate implements IMessage {

	public MessageRequestActivate() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestActivate implements IMessageHandler<MessageRequestActivate, IMessage> {

		@Override
		public IMessage onMessage(MessageRequestActivate message, MessageContext ctx) {
			
			if (ctx.side != Side.SERVER) {
				System.err.println("MessageActivate received on wrong side:" + ctx.side);
				return null;
			}
		    
		    final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
		    if (sendingPlayer == null) {
		    	System.err.println("EntityPlayerMP was null when MessageActivate was received");
		    	return null;
		    }
		    
		    final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
		    playerWorldServer.addScheduledTask(new Runnable() {
		    	public void run() {

		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.quirkless) {
		    			sendingPlayer.sendMessage(new TextComponentString("Youre Trying to do something ... nothing happens"));
		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.explosionquirk) {
		    			playerWorldServer.createExplosion(sendingPlayer, sendingPlayer.lastTickPosX + sendingPlayer.getLookVec().x , sendingPlayer.lastTickPosY + 1, sendingPlayer.lastTickPosZ + sendingPlayer.getLookVec().z , 1, false);

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.engine) {
		    			//new MessageExplosion();

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.hellfire) {
		    			playerWorldServer.spawnEntity(
		    					new CustomSpawnable(playerWorldServer,
		    					sendingPlayer.lastTickPosX + sendingPlayer.getLookVec().x *5 ,
		    					sendingPlayer.lastTickPosY,
		    					sendingPlayer.lastTickPosZ + sendingPlayer.getLookVec().z *5,
		    					sendingPlayer,
		    					false,
		    					0.02F,
		    					(float)sendingPlayer.getLookVec().x,
		    					(float)sendingPlayer.getLookVec().y,
		    					(float)sendingPlayer.getLookVec().z));
		    			System.out.println("hi");

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.icequirk) {
		    			//new MessageExplosion();

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.electrification) {
		    			//new MessageExplosion();

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.tail) {
		    			//new MessageExplosion();

		    		}
		    	}
		    });
		    
			return null;
		}

	}
	
}
