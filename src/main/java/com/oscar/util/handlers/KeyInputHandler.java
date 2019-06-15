package com.oscar.util.handlers;

import org.lwjgl.input.Keyboard;

import com.oscar.BNHA;
import com.oscar.client.render.gui.Statsgui;
import com.oscar.data.packets.MRA;
import com.oscar.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class KeyInputHandler {
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent
	public void onClientTickEvent(TickEvent.ClientTickEvent event) throws Exception {
		if(event.phase.equals(Phase.END)){
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
		if(keyBindings[0].isPressed()){
			BNHA.NETWORK.sendToServer(new MRA());
		}
		if(keyBindings[1].isPressed()) {
			Minecraft mc = Minecraft.getMinecraft();
			
			if(!FMLClientHandler.instance().isGUIOpen(Statsgui.class)) {
				mc.displayGuiScreen(new Statsgui(mc));
				}
		}
		}
	}
	
	public static class Keybinds {
		public static KeyBinding[] keyBindings;
		
		
		public static void initKeybindings() {
			keyBindings = new KeyBinding[2]; 
			keyBindings[0] = new KeyBinding("key.quirk", Keyboard.KEY_Y, "key.categories." + Reference.MOD_ID);
			keyBindings[1] = new KeyBinding("key.stats", Keyboard.KEY_X, "key.categories." + Reference.MOD_ID);
			
			ClientRegistry.registerKeyBinding(keyBindings[0]);
			ClientRegistry.registerKeyBinding(keyBindings[1]);
		}
	}

}
