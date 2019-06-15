package com.oscar.data.packets;

import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;
/**
 * MessageExp for Synchronizing the Experience Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class ME extends AbstractClientMessage<ME>{
	
	
	int exp;
	
	public ME() {}
	
	public ME(int exp){
		this.exp = exp;
	}



	@Override
	protected void read(PacketBuffer buf) throws IOException {
		exp = buf.readInt();
		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(exp);
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(Capabilities.exp, null).setexp(this.exp);
        
	} 
	
}

