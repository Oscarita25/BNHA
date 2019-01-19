package com.oscar.proxy;

import java.io.File;

import com.oscar.data.Capabilities;
import com.oscar.data.types.exp.ExpFactory;
import com.oscar.data.types.exp.ExpStorage;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQuirk;
import com.oscar.data.types.level.LevelFactory;
import com.oscar.data.types.level.LevelStorage;
import com.oscar.data.types.nexp.NExpFactory;
import com.oscar.data.types.nexp.NExpStorage;
import com.oscar.data.types.quirk.QuirkFactory;
import com.oscar.data.types.quirk.QuirkStorage;
import com.oscar.util.BNHAConfig;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;

public class CommonProxy {

	public static Configuration config;

	public void preInit(FMLPreInitializationEvent event)
	{
		File dir = event.getModConfigurationDirectory();
		config = new Configuration(new File(dir.getPath(), "initiative.cfg"));
		BNHAConfig.readCfg();
	}

	public void init(FMLInitializationEvent event)
	{

	}

	public void postInit(FMLPostInitializationEvent event)
	{
		if (config.hasChanged()) {
			config.save();
		}

	}

	public void registerData() {
		CapabilityManager.INSTANCE.register(ILevel.class, new LevelStorage(), new LevelFactory());
		CapabilityManager.INSTANCE.register(IExp.class, new ExpStorage(), new ExpFactory());
		CapabilityManager.INSTANCE.register(INExp.class, new NExpStorage(), new NExpFactory());
		CapabilityManager.INSTANCE.register(IQuirk.class, new QuirkStorage(), new QuirkFactory());

		MinecraftForge.EVENT_BUS.register(new Capabilities());
	}
	
	public void registerItemRenderer(Item item, int meta, String id) {}

	public ModelBase getModel(int id) {
		return null;
	}

	public EntityPlayer getPlayer(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}
}
