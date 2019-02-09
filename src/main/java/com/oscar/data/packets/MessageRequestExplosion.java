package com.oscar.data.packets;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageRequestExplosion implements IMessage {

	public MessageRequestExplosion() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestExplosion implements IMessageHandler<MessageRequestExplosion, IMessage> {

		@Override
		public IMessage onMessage(MessageRequestExplosion message, MessageContext ctx) {
			
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


		    	}
		    });
		    
			return null;
		}

	}
	
}
