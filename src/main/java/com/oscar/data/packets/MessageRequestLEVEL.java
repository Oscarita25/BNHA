package com.oscar.data.packets;

import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.level.LevelProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestLEVEL implements IMessage {

	public MessageRequestLEVEL(){
		
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestLEVEL implements IMessageHandler<MessageRequestLEVEL, MessageLEVEL>{


	    @Override
	    public MessageLEVEL onMessage(MessageRequestLEVEL message, MessageContext ctx) {
	        
	        EntityPlayerMP mp = ctx.getServerHandler().player;
	        ILevel lvl = mp.getCapability(LevelProvider.LEVEL_CAP, null);
	        return new MessageLEVEL(lvl.getlvl());
	    }

	} 
	
}
