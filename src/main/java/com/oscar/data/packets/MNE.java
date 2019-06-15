package com.oscar.data.packets;

import com.oscar.data.Capabilities;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;


/**
 * MessageNextExpierence for Synchronizing the NextExpierence Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
 
public class MNE implements IMessage{
	int nexp;
	
	public MNE() {}
	
	public MNE(int nexp){
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
	
	/**
	 *HandleMessageNextExpierence for Handling {@link  com.oscar.data.packets.MNE MessageNextExpierence}
	 */
	public static class HMNE implements IMessageHandler<MNE, IMessage> {

	    @Override
	    public IMessage onMessage(MNE message, MessageContext ctx) {
			    Minecraft.getMinecraft().addScheduledTask(() -> {

			    	Minecraft.getMinecraft().player.getCapability(Capabilities.nexp, null).setnexp(message.nexp);
		            
		        });

	        return null;
	    }



	} 
	
}

