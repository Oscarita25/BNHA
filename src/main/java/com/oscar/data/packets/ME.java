package com.oscar.data.packets;

import com.oscar.data.Capabilities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

/**
 * MessageExp for Synchronizing the Experience Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class ME implements IMessage{
	
	
	int exp;
	
	public ME() {}
	
	public ME(int exp){
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
	/**
	 *HandleMessageExpierence for Handling {@link  com.oscar.data.packets.ME MessageExpierence}
	 */
	public static class HME implements IMessageHandler<ME, IMessage> {

	    @Override
	    public IMessage onMessage(ME message, MessageContext ctx) {
				Minecraft.getMinecraft().addScheduledTask(() -> {
					Minecraft.getMinecraft().player.getCapability(Capabilities.exp, null).setexp(message.exp);
		            
		        });

	        return null;
	    }



	} 
	
}

