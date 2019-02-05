package com.oscar.util.render.gui;

import java.io.IOException;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class NewMainMenu extends GuiScreen {
	
    private static ResourceLocation MenuBackground = new ResourceLocation("bnha","textures/gui/background.png");

	
    @Override
    public void drawScreen(int mouseX, int mouseY, float partialTicks) {
        try {
			drawParralaxBackground(mouseX, mouseY);
		} catch (IOException e) {
			e.printStackTrace();
		}
        super.drawScreen(mouseX, mouseY, partialTicks);
    }

    @Override
    public void initGui() {
        super.initGui();
    }

    @Override
    protected void actionPerformed(GuiButton button) throws IOException {
        super.actionPerformed(button);
    }

    @Override
    protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
        super.mouseClicked(mouseX, mouseY, mouseButton);
    }
    
    public void drawParralaxBackground(int mouseX, int mouseY) throws IOException {
        this.mc.getTextureManager().bindTexture(MenuBackground);
        this.drawTexturedModalRect(1,1,1,1,40,40);
    }
}
