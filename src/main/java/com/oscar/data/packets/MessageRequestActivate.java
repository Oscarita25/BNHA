package com.oscar.data.packets;

import com.oscar.data.types.quirk.Quirk;
import com.oscar.quirk.CustomSpawnable;
import com.oscar.quirk.Icicle;
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
		    playerWorldServer.addScheduledTask(() -> {

		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.quirkless) {
		    			sendingPlayer.sendMessage(new TextComponentString("Youre Trying to do something ... nothing happens"));
		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.explosionquirk) {
		    			//WORK IN PROGRESS
		    			playerWorldServer.createExplosion(sendingPlayer, sendingPlayer.lastTickPosX + sendingPlayer.getLookVec().x , sendingPlayer.lastTickPosY + 1, sendingPlayer.lastTickPosZ + sendingPlayer.getLookVec().z , 1, false);

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.engine) {
		    			//WORK IN PROGRESS
		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.hellfire) {
		    			//WORKING
			    			playerWorldServer.spawnEntity(
			    					new CustomSpawnable(playerWorldServer,
			    					sendingPlayer.lastTickPosX + sendingPlayer.getLookVec().x *5 ,
			    					sendingPlayer.lastTickPosY,
			    					sendingPlayer.lastTickPosZ + sendingPlayer.getLookVec().z *5,
			    					sendingPlayer,
			    					false,
			    					sendingPlayer.getLookVec().x,
			    					sendingPlayer.getLookVec().y,
			    					sendingPlayer.getLookVec().z));
		    			
		    				
		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.icequirk) {
		    			//WORK IN PROGRESS
		    			playerWorldServer.spawnEntity(
		    					new Icicle(playerWorldServer,
		    					sendingPlayer,
		    					sendingPlayer.lastTickPosX + sendingPlayer.getLookVec().x *2 ,
		    					sendingPlayer.lastTickPosY,
		    					sendingPlayer.lastTickPosZ + sendingPlayer.getLookVec().z *2));
		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.electrification) {
		    			//WORK IN PROGRESS

		    		}
		    		if(Quirk.getQuirkID(sendingPlayer) == Reference.tail) {
		    			//WORK IN PROGRESS

		    		}
		    	
		    });
		    
			return null;
		}

	}
	
}
