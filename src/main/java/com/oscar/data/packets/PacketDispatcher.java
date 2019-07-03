package com.oscar.data.packets;

import com.oscar.BNHA;
import com.oscar.obsidianAPI.network.AnimationNetworkHandler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.IMessage;
import net.minecraftforge.fml.common.network.simpleimpl.IMessageHandler;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;


public class PacketDispatcher
{
	private static byte packetId = 0;


	private static final SimpleNetworkWrapper dispatcher = BNHA.NETWORK;


	public static final void registerPackets() {

		registerMessage(MS.class);
		registerMessage(ME.class);
		registerMessage(ML.class);
		registerMessage(MM.class);
		registerMessage(MNE.class);
		registerMessage(MQID.class);
		registerMessage(MRA.class);
		
		AnimationNetworkHandler.init();

	}


	private static final <T extends AbstractMessage<T> & IMessageHandler<T, IMessage>> void registerMessage(Class<T> clazz) {

		if (AbstractMessage.AbstractClientMessage.class.isAssignableFrom(clazz)) {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.CLIENT);
		} else if (AbstractMessage.AbstractServerMessage.class.isAssignableFrom(clazz)) {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.SERVER);
		} else {
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId, Side.CLIENT);
			PacketDispatcher.dispatcher.registerMessage(clazz, clazz, packetId++, Side.SERVER);
		}
	}


	public static final void sendTo(IMessage message, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendTo(message, player);
	}

	
	public static final void sendToAllTracking(IMessage message, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendToAllTracking(message, player);
	}
	
	public static final void sendToAllTrackingAndPlayer(IMessage message, EntityPlayerMP player) {
		PacketDispatcher.dispatcher.sendTo(message, player);
		PacketDispatcher.dispatcher.sendToAllTracking(message, player);
	}

	public static void sendToAll(IMessage message) {
		PacketDispatcher.dispatcher.sendToAll(message);
	}

	public static final void sendToAllAround(IMessage message, NetworkRegistry.TargetPoint point) {
		PacketDispatcher.dispatcher.sendToAllAround(message, point);
	}


	public static final void sendToAllAround(IMessage message, int dimension, double x, double y, double z, double range) {
		PacketDispatcher.sendToAllAround(message, new NetworkRegistry.TargetPoint(dimension, x, y, z, range));
	}


	public static final void sendToAllAround(IMessage message, EntityPlayer player, double range) {
		PacketDispatcher.sendToAllAround(message, player.dimension, player.posX, player.posY, player.posZ, range);
	}


	public static final void sendToDimension(IMessage message, int dimensionId) {
		PacketDispatcher.dispatcher.sendToDimension(message, dimensionId);
	}


	public static final void sendToServer(IMessage message) {
		PacketDispatcher.dispatcher.sendToServer(message);
	}
}
