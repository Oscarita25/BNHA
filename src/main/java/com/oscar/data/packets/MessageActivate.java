package com.oscar.data.packets;

import org.lwjgl.Sys;

import com.oscar.BNHA;
import com.oscar.data.types.interfaces.IQuirk;
import com.oscar.data.types.quirk.Quirk;
import com.oscar.data.types.quirk.QuirkProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.world.WorldServer;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class MessageActivate implements IMessage {

	public MessageActivate() {}
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class MessageHandlerActivateServer implements IMessageHandler<MessageActivate, IMessage> {

		@Override
		public IMessage onMessage(MessageActivate message, MessageContext ctx) {
			
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
		    		
		    		IQuirk iquirk = sendingPlayer.getCapability(QuirkProvider.QUIRK_CAP, null);
		    		Quirk q = iquirk.getQuirks().get(0);
		    		q.onPlayerUse(sendingPlayer);
		    		BNHA.NETWORK.sendToDimension(new MessageActivate(), sendingPlayer.dimension);
		    		System.out.println("test");
		    		
		    		
		    	}
		    });
		    
			return null;
		}

	}
	
}
