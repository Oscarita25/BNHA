package com.oscar.data.packets;


import java.io.IOException;

import com.oscar.data.Capabilities;
import com.oscar.data.packets.AbstractMessage.AbstractClientMessage;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.PacketBuffer;
import net.minecraftforge.fml.relauncher.Side;


/**
 * MessageModel for Synchronizing the ModelID Capability
 *  to the {@link  net.minecraft.client.entity.EntityPlayerSP Player}
 */
public class MM extends AbstractClientMessage<MM> {
	int model;
	NBTTagCompound player;
	
	public MM() {}
	
	public MM(int model, EntityPlayerMP player){
		this.player = player.getEntityData();
		this.model = model;
	}

	@Override
	protected void read(PacketBuffer buf) throws IOException {
		model = buf.readInt();
		player = buf.readCompoundTag();
		
	}

	@Override
	protected void write(PacketBuffer buf) throws IOException {
        buf.writeInt(model);
		buf.writeCompoundTag(player);
		
	}

	@Override
	public void process(EntityPlayer player, Side side) {
		player.world.getPlayerEntityByUUID(this.player.getUniqueId("UUID")).getCapability(Capabilities.modelid, null).setModelID(this.model);
		
	}

	
}
