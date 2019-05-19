package com.oscar.data.packets;

import com.oscar.data.types.interfaces.IModelID;
import com.oscar.data.types.model.ModelProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestModel implements IMessage {

	public MessageRequestModel(){
		
	}	
	
	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}

	public static class HandleRequestModel implements IMessageHandler<MessageRequestModel, MessageModel>{


	    @Override
	    public MessageModel onMessage(MessageRequestModel message, MessageContext ctx) {
	        
	        EntityPlayerMP mp = ctx.getServerHandler().player;
            IModelID model = mp.getCapability(ModelProvider.MODEL_CAP, null);
	        return new MessageModel(model.getModelID());
	    }

	} 
	
}
