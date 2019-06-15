package com.oscar.data.packets;

import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;


/**
 * MessageQuirkID for Synchronizing the QuirkID Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class MQID extends AbstractClientMessage<MQID>{
	int quirkID;
	
	public MQID() {}
	
	public MQID(int quirkID){
		this.quirkID = quirkID;
	}

	@Override
	protected void read(PacketBuffer buf) throws IOException {
		quirkID = buf.readInt();
		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(quirkID);
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(Capabilities.quirkid, null).setQID(this.quirkID);
		
	} 
	
}

