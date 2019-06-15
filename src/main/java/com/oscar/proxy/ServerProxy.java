package com.oscar.proxy;

import com.oscar.BNHA;
import com.oscar.data.packets.MRA;
import com.oscar.data.packets.MRA.HMRA;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import net.minecraftforge.fml.relauncher.Side;

public class ServerProxy implements IProxy{
	
	
	@Override
	public void preInit(FMLPreInitializationEvent event) {
		registerPackets();
	}
	
	@Override
	public void init(FMLInitializationEvent event) {
	}
	
	@Override
	public void postInit(FMLPostInitializationEvent event) {
		
	}
	@Override
	public void serverStarting(FMLServerStartingEvent event) {
	}
	@Override
	public EntityPlayer getPlayerEntityFromContext(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}

	public void registerPackets() {
		BNHA.NETWORK.registerMessage(HMRA.class, MRA.class, 1, Side.SERVER);
	}	
}
