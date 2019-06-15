package com.oscar.data.packets;


import com.oscar.data.Capabilities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


/**
 * MessageModel for Synchronizing the ModelID Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class MM implements IMessage {
	int model;
	
	public MM() {}
	
	public MM(int model){
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

	/**
	 *HandleMessageLevelClient for Handling {@link  com.oscar.data.packets.MM MessageModel}
	 */
	public static class HMM implements IMessageHandler<MM, IMessage> {

	    @Override
	    public IMessage onMessage(MM message, MessageContext ctx) {	
	    		Minecraft.getMinecraft().addScheduledTask(() -> {
	    			
	    			Minecraft.getMinecraft().player.getCapability(Capabilities.modelid, null).setModelID(message.model);
	        
	        	});
	    	
	            
	        return null;
	    }
	}

	
}
