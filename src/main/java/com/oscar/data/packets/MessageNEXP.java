package com.oscar.data.packets;

import com.oscar.data.types.nexp.NExpProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageNEXP implements IMessage{
	int nexp;
	
	public MessageNEXP() {}
	
	public MessageNEXP(int nexp){
		this.nexp = nexp;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		nexp = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
        buf.writeInt(nexp);
		
	}
	
	public static class HandleMessageNEXP implements IMessageHandler<MessageNEXP, IMessage> {

	    @Override
	    public IMessage onMessage(MessageNEXP message, MessageContext ctx) {
	        Minecraft.getMinecraft().addScheduledTask(() -> {
	            Minecraft.getMinecraft().player.getCapability(NExpProvider.NEXP_CAP, null).setnexp(message.nexp);
	            
	        });
	            
	        return null;
	    }



	} 
	
}

