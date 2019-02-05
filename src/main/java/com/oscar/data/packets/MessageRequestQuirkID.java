package com.oscar.data.packets;

import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.quirk.id.QuirkIDProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestQuirkID implements IMessage {

	public MessageRequestQuirkID(){
		
	}
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestQuirkID implements IMessageHandler<MessageRequestQuirkID, MessageQuirkID>{


	    @Override
	    public MessageQuirkID onMessage(MessageRequestQuirkID message, MessageContext ctx) {
	        
	        EntityPlayerMP mp = ctx.getServerHandler().player;
			IQuirkID iqID = mp.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
	        return new MessageQuirkID(iqID.getID());
	    }

	} 
	
}
