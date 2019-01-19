package com.oscar.data.packets;

import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.interfaces.IExp;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestEXP implements IMessage {

	public MessageRequestEXP(){
		
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestEXP implements IMessageHandler<MessageRequestEXP, MessageEXP>{


	    @Override
	    public MessageEXP onMessage(MessageRequestEXP message, MessageContext ctx) {
	        
	        EntityPlayerMP mp = ctx.getServerHandler().player;
	        IExp exp = mp.getCapability(ExpProvider.EXP_CAP, null);
	        return new MessageEXP(exp.getexp());
	    }

	} 
	
}
