package com.oscar.data.packets;

import com.oscar.data.types.interfaces.IQuirk;
import com.oscar.data.types.quirk.Quirk;
import com.oscar.data.types.quirk.QuirkProvider;
import com.oscar.util.Multipliers;

import io.netty.buffer.ByteBuf;
import net.minecraft.client.Minecraft;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class MessageQuirk implements IMessage{
	Quirk quirk;

	static int act;
	static int maxAct;
		
	static Multipliers multipliers;
	
	
	public MessageQuirk() {}

	
	@Override
	public void fromBytes(ByteBuf buf) {
		
	}

	@Override
	public void toBytes(ByteBuf buf) {
		
	}
	
	public static class HandleMessageQuirk implements IMessageHandler<MessageQuirk, IMessage> {

	    @Override
	    public IMessage onMessage(MessageQuirk message, MessageContext ctx) {
	        Minecraft.getMinecraft().addScheduledTask(() -> {
	        	
	        	IQuirk instance = ctx.getServerHandler().player.getCapability(QuirkProvider.QUIRK_CAP, null);
	        	
	    		NBTTagCompound tag = new NBTTagCompound();
	    		
	    		tag.setString("name", instance.name);
	    		
	    		tag.setBoolean("activated", instance.activated);
	    		tag.setBoolean("available",instance.available);
	    		//Cooldown
	    		tag.setInteger("maxCooldown", instance.maxCooldown);
	    		tag.setInteger("cooldown", instance.cooldown);
	    		
	    		//Activation Time
	    		tag.setInteger("maxAct", instance.maxAct);
	    		tag.setInteger("act", instance.act);
	    		
	        });
	            
	        return null;
	    }




	} 
}
