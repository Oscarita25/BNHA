package com.oscar.data.packets;

import com.oscar.data.types.model.ModelProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageModel implements IMessage {
	int model;
	
	public MessageModel() {}
	
	public MessageModel(int model){
		this.model = model;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		model = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
        buf.writeInt(model);
		
	}
	
	public static class HandleMessageModel implements IMessageHandler<MessageModel, IMessage> {

	    @Override
	    public IMessage onMessage(MessageModel message, MessageContext ctx) {
	        Minecraft.getMinecraft().addScheduledTask(() -> {
	        	Minecraft.getMinecraft().player.getCapability(ModelProvider.MODEL_CAP, null).setModelID(message.model);
	        	
	        });
	            
	        return null;
	    }



	} 
	
}
