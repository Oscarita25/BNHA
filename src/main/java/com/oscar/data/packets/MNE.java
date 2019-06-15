package com.oscar.data.packets;

import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;


/**
 * MessageNextExpierence for Synchronizing the NextExpierence Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
 
public class MNE extends AbstractClientMessage<MNE>{
	int nexp;
	
	public MNE() {}
	
	public MNE(int nexp){
		this.nexp = nexp;
	}


	@Override
	protected void read(PacketBuffer buf) throws IOException {
		nexp = buf.readInt();
		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(nexp);
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(Capabilities.nexp, null).setnexp(this.nexp);
		
	} 
	
}

