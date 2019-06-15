package com.oscar.data.packets;

import com.oscar.data.Capabilities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


/**
 * MessageQuirkID for Synchronizing the QuirkID Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class MQID implements IMessage{
	int quirkID;
	
	public MQID() {}
	
	public MQID(int quirkID){
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
	
	/**
	 *HandleMessageQuirkID for Handling {@link  com.oscar.data.packets.MQID MessageQuirkID}
	 */
	public static class HMQID implements IMessageHandler<MQID, IMessage> {

	    @Override
	    public IMessage onMessage(MQID message, MessageContext ctx) {
		    Minecraft.getMinecraft().addScheduledTask(() -> {
		    	
	            Minecraft.getMinecraft().player.getCapability(Capabilities.quirkid, null).setQID(message.quirkID);
	            
	        });
	            
	        return null;
	    }



	} 
	
}

