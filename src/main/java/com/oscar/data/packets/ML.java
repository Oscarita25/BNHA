package com.oscar.data.packets;

import com.oscar.data.Capabilities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


/**
 * MessageLevel for Synchronizing the Level Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class ML implements IMessage{
	int lvl;
	
	public ML() {}
	
	public ML(int lvl){
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
	
	
	/**
	 *HandleMessageLevel for Handling {@link  com.oscar.data.packets.ML MessageLevel}
	 */
	public static class HML implements IMessageHandler<ML, IMessage> {

	    @Override
	    public IMessage onMessage(ML message, MessageContext ctx) {
			    Minecraft.getMinecraft().addScheduledTask(() -> {
			    	
			    	Minecraft.getMinecraft().player.getCapability(Capabilities.level, null).setlvl(message.lvl);;
		            
		        });
			

	        return null;
	    }



	} 
	
}

