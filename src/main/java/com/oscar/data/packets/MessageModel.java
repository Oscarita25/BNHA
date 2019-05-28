package com.oscar.data.packets;


import com.oscar.data.types.model.ModelProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.text.TextComponentString;
import net.minecraft.util.text.TextFormatting;
import net.minecraft.world.WorldServer;
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
		    final EntityPlayerMP sendingPlayer = ctx.getServerHandler().player;
		    final WorldServer playerWorldServer = sendingPlayer.getServerWorld();
		    playerWorldServer.addScheduledTask(() -> {

		    	sendingPlayer.getCapability(ModelProvider.MODEL_CAP, null).setModelID(message.model, sendingPlayer);
	        	
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	System.out.println("HAIII");
		    	
		    	sendingPlayer.sendMessage(new TextComponentString(TextFormatting.BOLD+"HAI DU MISSIT"));
	        	
	        });
	            
	        return null;
	    }



	} 
	
}
