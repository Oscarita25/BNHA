package com.oscar.data.packets;


import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;


/**
 * MessageModel for Synchronizing the ModelID Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class MM extends AbstractClientMessage<MM> {
	int model;

	
	public MM() {}
	
	public MM(int model){
		
		this.model = model;
	}

	@Override
	protected void read(PacketBuffer buf) throws IOException {
		model = buf.readInt();

		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(model);

		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(Capabilities.modelid, null).setModelID(this.model);
		
	}

	
}
