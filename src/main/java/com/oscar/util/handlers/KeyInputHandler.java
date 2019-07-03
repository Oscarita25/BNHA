package com.oscar.util.handlers;

import org.lwjgl.input.Keyboard;

import com.oscar.BNHA;
import com.oscar.client.render.gui.Statsgui;
import com.oscar.data.packets.MRA;
import com.oscar.util.CombAtt;
import com.oscar.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;
import net.minecraftforge.fml.client.FMLClientHandler;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.gameevent.InputEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent;
import net.minecraftforge.fml.common.gameevent.TickEvent.Phase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class KeyInputHandler {
	
	public static boolean battlemode = false;
	
	@SubscribeEvent
	public void onClientTickEvent(TickEvent.ClientTickEvent event) throws Exception {
		if(event.phase.equals(Phase.END)){
	    KeyBinding[] keyBindings = Keybinds.keyBindings;

		if(keyBindings[1].isPressed()) {
			Minecraft mc = Minecraft.getMinecraft();
			
			if(!FMLClientHandler.instance().isGUIOpen(Statsgui.class)) {
				mc.displayGuiScreen(new Statsgui(mc));
				}
		}
		}
	}
	
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = false)
    public void onEvent(InputEvent.MouseInputEvent event){
    	
        GameSettings gs = Minecraft.getMinecraft().gameSettings;
      
        /*
         * Left Mouse Press (in BattleMode)
         */

        if (gs.keyBindAttack.isPressed() ){
        	
            if(!(KeyInputHandler.battlemode) ) {
            	KeyBinding.onTick(gs.keyBindAttack.getKeyCode());
            }
            if(KeyInputHandler.battlemode) {
            KeyBinding.setKeyBindState(gs.keyBindAttack.getKeyCode(), false);
			BNHA.NETWORK.sendToServer(new MRA());
			CombAtt.onCombo("L");
            }
        }
        

        

        if (gs.keyBindUseItem.isPressed()){
            if(!(KeyInputHandler.battlemode) ) {
            	KeyBinding.onTick(gs.keyBindUseItem.getKeyCode());
            }
        	if(KeyInputHandler.battlemode) {
            KeyBinding.setKeyBindState(gs.keyBindUseItem.getKeyCode(), false);
			BNHA.NETWORK.sendToServer(new MRA());
			CombAtt.onCombo("R");
        	}
        } 
        
        
        
        if(CombAtt.active_comb.size() == 5) {
        	CombAtt.clearCombo();
        
    	}
    }
	
    @SubscribeEvent(priority = EventPriority.NORMAL, receiveCanceled = true)
    public void onEvent(InputEvent.KeyInputEvent event){
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
        /*
         *  Deactivate & Activate BattleMode
         */
		if(keyBindings[0].isPressed()){
			if(!battlemode) {
			battlemode = true;			
			}else if(battlemode) {
			battlemode = false;
			CombAtt.clearCombo();
			}
		}
    }


	
	public static class Keybinds {
		public static KeyBinding[] keyBindings;
		
		
		public static void initKeybindings() {
			keyBindings = new KeyBinding[2]; 
			keyBindings[0] = new KeyBinding("key.quirk", Keyboard.KEY_R, "key.categories." + Reference.MOD_ID);
			keyBindings[1] = new KeyBinding("key.stats", Keyboard.KEY_X, "key.categories." + Reference.MOD_ID);
			
			ClientRegistry.registerKeyBinding(keyBindings[0]);
			ClientRegistry.registerKeyBinding(keyBindings[1]);
		}
	}
	
	

	}
