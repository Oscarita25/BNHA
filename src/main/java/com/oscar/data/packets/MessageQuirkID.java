package com.oscar.data.packets;

import com.oscar.data.Capabilities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageQuirkID implements IMessage{
	int quirkID;
	
	public MessageQuirkID() {}
	
	public MessageQuirkID(int quirkID){
		this.quirkID = quirkID;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		quirkID = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
        buf.writeInt(quirkID);
		
	}
	
	public static class HandleMessageQuirkID implements IMessageHandler<MessageQuirkID, IMessage> {

	    @Override
	    public IMessage onMessage(MessageQuirkID message, MessageContext ctx) {
		    Minecraft.getMinecraft().addScheduledTask(() -> {
		    	
	            Minecraft.getMinecraft().player.getCapability(Capabilities.quirkid, null).setQID(message.quirkID);
	            
	        });
	            
	        return null;
	    }



	} 
	
}

