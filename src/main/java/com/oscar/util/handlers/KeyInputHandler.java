package com.oscar.util.handlers;

import org.lwjgl.input.Keyboard;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestActivate;
import com.oscar.util.Reference;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;

public class KeyInputHandler {
	
	@SubscribeEvent
	public void onClientTickEvent(TickEvent.ClientTickEvent event) throws Exception {
		if(event.phase.equals(Phase.END)){
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
		if(keyBindings[0].isPressed()){
			System.out.println("hello you pressed me?");
			BNHA.NETWORK.sendToServer(new MessageRequestActivate());
		}
		}
	}
	
	public static class Keybinds {
		public static KeyBinding[] keyBindings;
		
		public static void initKeybindings() {
			keyBindings = new KeyBinding[2]; 
			keyBindings[0] = new KeyBinding("key.quirk", Keyboard.KEY_Y, "key.categories." + Reference.MOD_ID);
			keyBindings[1] = new KeyBinding("key.test", Keyboard.KEY_X, "key.categories." + Reference.MOD_ID);
			
			ClientRegistry.registerKeyBinding(keyBindings[0]);
			ClientRegistry.registerKeyBinding(keyBindings[1]);
		}
	}

}
