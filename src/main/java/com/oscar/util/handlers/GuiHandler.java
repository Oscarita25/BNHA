package com.oscar.util.handlers;

import com.oscar.util.render.gui.NewMainMenu;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraftforge.client.event.GuiOpenEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class GuiHandler {
	
    @SubscribeEvent
    public void onGuiInit(GuiOpenEvent event){
        if (Minecraft.getMinecraft().currentScreen != null && Minecraft.getMinecraft().currentScreen.getClass() == GuiMainMenu.class){
        	Minecraft.getMinecraft().currentScreen = new NewMainMenu();	         
        }
    }
}
