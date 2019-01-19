package com.oscar.data.packets;

import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.nexp.NExpProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestNEXP implements IMessage {

	public MessageRequestNEXP(){
		
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestNEXP implements IMessageHandler<MessageRequestNEXP, MessageNEXP>{


	    @Override
	    public MessageNEXP onMessage(MessageRequestNEXP message, MessageContext ctx) {
	        
	        EntityPlayerMP mp = ctx.getServerHandler().player;
	        INExp nexp = mp.getCapability(NExpProvider.NEXP_CAP, null);
	        return new MessageNEXP(nexp.getnexp());
	    }

	} 
	
}
