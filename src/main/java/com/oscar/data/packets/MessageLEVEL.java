package com.oscar.data.packets;

import com.oscar.data.types.level.LevelProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageLEVEL implements IMessage{
	int lvl;
	
	public MessageLEVEL() {}
	
	public MessageLEVEL(int lvl){
		this.lvl = lvl;
	}

	@Override
	public void fromBytes(ByteBuf buf) {
		lvl = buf.readInt();
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
        buf.writeInt(lvl);
		
	}
	
	public static class HandleMessageLEVEL implements IMessageHandler<MessageLEVEL, IMessage> {

	    @Override
	    public IMessage onMessage(MessageLEVEL message, MessageContext ctx) {
	        Minecraft.getMinecraft().addScheduledTask(() -> {
	            Minecraft.getMinecraft().player.getCapability(LevelProvider.LEVEL_CAP, null).setlvl(message.lvl);
	            
	        });
	            
	        return null;
	    }



	} 
	
}

