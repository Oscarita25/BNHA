package com.oscar.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public interface IProxy
{

    void preInit(FMLPreInitializationEvent event);


    void init(FMLInitializationEvent event);


    void postInit(FMLPostInitializationEvent event);

    void serverStarting(FMLServerStartingEvent event);

    EntityPlayer getPlayerEntityFromContext(MessageContext parContext);


}
