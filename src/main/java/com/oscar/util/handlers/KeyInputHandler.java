package com.oscar.util.handlers;

import org.lwjgl.input.Keyboard;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestActivate;
import com.oscar.util.Reference;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.ClientTickEvent;

public class KeyInputHandler {
	
	@SubscribeEvent
	public static void onKeyInput(ClientTickEvent event) {
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
		if(keyBindings[0].isPressed()){
			BNHA.NETWORK.sendToServer(new MessageRequestActivate());
		}
	}
	
	public static class Keybinds {
		public static KeyBinding[] keyBindings;
		
		public static void initKeybindings() {
			keyBindings = new KeyBinding[1]; 
			keyBindings[0] = new KeyBinding("key.quirk", Keyboard.KEY_Y, "key.categories." + Reference.MOD_ID);
			
			ClientRegistry.registerKeyBinding(keyBindings[0]);
		}
	}

}
