package com.oscar.proxy;

import net.minecraft.client.model.ModelBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.network.simpleimpl.MessageContext;
import obsidiansuite.obsidianAPI.registry.AnimationRegistry;

public class CommonProxy{ 

	public void registerItemRenderer(Item item, int meta, String id) {}

	public ModelBase getModel(int id) {
		return null;
	}

	public EntityPlayer getPlayer(MessageContext ctx) {
		return ctx.getServerHandler().player;
	}

	public void registerRenders() {}

	public void registerAnimations() {
		AnimationRegistry.init();
	}

	public void initKeybindings() {}

	public void registerClientHandler() {}

	public void registerRendersPost() {	}
}
