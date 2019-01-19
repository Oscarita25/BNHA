package com.oscar.init;

import org.lwjgl.input.Keyboard;

import com.oscar.util.Reference;

import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.registry.ClientRegistry;

public class Keybinds {
	public static KeyBinding[] keyBindings;
	
	public static void initKeybindings() {
		keyBindings = new KeyBinding[2]; 
		keyBindings[0] = new KeyBinding("key.activate", Keyboard.KEY_Y, "key.categories." + Reference.MOD_ID);
		
		ClientRegistry.registerKeyBinding(keyBindings[0]);
	}
}
