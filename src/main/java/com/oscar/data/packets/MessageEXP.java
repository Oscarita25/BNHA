package com.oscar.data.packets;

import com.oscar.data.types.exp.ExpProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageEXP implements IMessage{
	int exp;
	
	public MessageEXP() {}
	
	public MessageEXP(int exp){
		this.exp = exp;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		exp = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
        buf.writeInt(exp);
		
	}
	
	public static class HandleMessageEXP implements IMessageHandler<MessageEXP, IMessage> {

	    @Override
	    public IMessage onMessage(MessageEXP message, MessageContext ctx) {
	        Minecraft.getMinecraft().addScheduledTask(() -> {
	            Minecraft.getMinecraft().player.getCapability(ExpProvider.EXP_CAP, null).setexp(message.exp);
	            
	        });
	            
	        return null;
	    }



	} 
	
}

