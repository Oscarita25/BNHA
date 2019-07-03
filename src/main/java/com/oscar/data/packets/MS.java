package com.oscar.data.packets;

import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;

public class MS extends AbstractClientMessage<MS>{
	
	
	int stamina;
	int maxstamina;
	
	public MS() {}
	
	public MS(int stamina, int maxstamina){
		this.stamina = stamina;
	}



	@Override
	protected void read(PacketBuffer buf) throws IOException {
		stamina = buf.readInt();
		maxstamina = buf.readInt();
		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(stamina);
        buf.writeInt(maxstamina);

		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.getCapability(Capabilities.stamina, null).setStamina(this.stamina);
		player.getCapability(Capabilities.stamina, null).setMaxStamina(this.maxstamina);
        
	} 
	
}
