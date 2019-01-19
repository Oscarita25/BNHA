package com.oscar.data.packets;

import com.oscar.data.types.quirk.QuirkProvider;

import io.netty.buffer.ByteBuf;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageRequestQuirk implements IMessage{

	public MessageRequestQuirk() {}

	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}
	
	public static class HandleRequestQuirk implements IMessageHandler<MessageRequestQuirk, MessageQuirk> {

	    @Override
	    public MessageQuirk onMessage(MessageRequestQuirk message, MessageContext ctx) {
	        EntityPlayerMP mp = ctx.getServerHandler().player;
			NBTTagCompound tag = (NBTTagCompound) mp.getCapability(QuirkProvider.QUIRK_CAP, null);
			
			tag.getBoolean("activated");
			tag.getBoolean("aviable");
			//Cooldown
			tag.getInteger("maxCooldown");
			tag.getInteger("cooldown");

			//Activation Time
			tag.getInteger("maxAct");
			tag.getInteger("act");
				
	        return null;
	    }




	} 
}
