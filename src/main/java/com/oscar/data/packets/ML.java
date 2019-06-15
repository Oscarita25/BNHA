package com.oscar.data.packets;

import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;


/**
 * MessageLevel for Synchronizing the Level Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class ML extends AbstractClientMessage<ML>{
	int lvl;
	
	public ML() {}
	
	public ML(int lvl){
		this.lvl = lvl;
	}



	@Override
	protected void read(PacketBuffer buf) throws IOException {
		lvl = buf.readInt();
		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(lvl);
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(Capabilities.level, null).setlvl(this.lvl);
		
	} 
	
}

