package com.oscar.client.render.gui;

import java.io.IOException;

import org.lwjgl.opengl.GL11;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.interfaces.IQuirkID;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.data.types.quirk.id.QuirkIDProvider;
import com.oscar.util.Reference;
import com.oscar.util.handlers.KeyInputHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.OpenGlHelper;
import net.minecraft.client.renderer.RenderHelper;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

public class Statsgui extends GuiScreen {
	
    protected int xSize = 748;
    protected int ySize = 457;
    
    private static final ResourceLocation BACKGROUND = new ResourceLocation(Reference.MOD_ID + ":textures/gui/statsscreen.png");
    
	public Statsgui(Minecraft mc) {
		super();
		this.mc = mc;
	}
    
    
    @Override
    public void drawScreen(int mouseX, int mouseY, float ticks) {

    	Minecraft mc = Minecraft.getMinecraft();
    	
		EntityPlayer player = mc.player;
		if (player == null) {
			return;
		}
	    
        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
        INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
        ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
        IQuirkID quirkid = player.getCapability(QuirkIDProvider.QUIRKID_CAP, null);
		    	
    	
    	
		BNHA.NETWORK.sendToServer(new MessageRequestLEVEL());
		BNHA.NETWORK.sendToServer(new MessageRequestEXP());
		BNHA.NETWORK.sendToServer(new MessageRequestNEXP());
		BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());
    	
        this.drawDefaultBackground();
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(BACKGROUND);
        float scale = 0.5F;
        int k = (Math.round((width / 2) / scale) - Math.round(xSize / 2));
        int l = (Math.round((height / 2) / scale) - Math.round(ySize / 2));
        int k2 = (Math.round((width / 2) / 1.5F) - Math.round(xSize / 2));
        int l2 = (Math.round((height / 2) / 1.5F) - Math.round(ySize / 2));
        GlStateManager.scale(scale, scale, 1F);
        Statsgui.drawModalRectWithCustomSizedTexture(k , l , 0, 0, this.xSize, this.ySize, this.xSize, this.ySize);
        GlStateManager.pushMatrix();
        GlStateManager.scale(3F, 3F, 1F);
        drawEntityOnScreen((k + 200) / 3, (l + 390) /3, 60, (float)(k - 180) - mouseX, (float)(l - 70) - mouseY, this.mc.player);
        GlStateManager.popMatrix();
        GlStateManager.scale(3F, 3F, 3F);
        this.fontRenderer.drawString("Name: "+ mc.player.getName(), k2 + 400, l2 + 165, 2222);
        this.fontRenderer.drawString("Quirk: �4"+ Reference.getQNamebyID(quirkid.getID()), k2 + 400, l2 + 200, 2222);
        this.fontRenderer.drawString("Level: �4"+ level.getlvl(),k2 + 400, l2 + 225, 2222);
        this.fontRenderer.drawString("Exp: �4"+ exp.getexp()+"/"+nexp.getnexp(), k2 + 400, l2 + 235, 2222);
        this.fontRenderer.drawString("PlaceHolder: ", k2 + 400, l2 + 245, 2222);
        this.fontRenderer.drawString("PlaceHolder: ", k2 + 400, l2 + 255, 2222);
        this.fontRenderer.drawString("PlaceHolder: ", k2 + 400, l2 + 265, 2222);
 
        
        super.drawScreen(mouseX, mouseY, ticks);
    }

    public static void drawEntityOnScreen(int posX, int posY, int scale, float mouseX, float mouseY, EntityLivingBase ent){
        GlStateManager.enableColorMaterial();
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)posX, (float)posY, 50.0F);
        GlStateManager.scale((float)(-scale), (float)scale, (float)scale);
        GlStateManager.rotate(180.0F, 0.0F, 0.0F, 1.0F);
        float f = ent.renderYawOffset;
        float f1 = ent.rotationYaw;
        float f2 = ent.rotationPitch;
        float f3 = ent.prevRotationYawHead;
        float f4 = ent.rotationYawHead;
        GlStateManager.rotate(135.0F, 0.0F, 180.0F, 0.0F);
        RenderHelper.enableStandardItemLighting();
        GlStateManager.rotate(-135.0F, 0.0F, 1.0F, 0.0F);
        GlStateManager.rotate(-((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F, 1.0F, 0.0F, 0.0F);
        ent.renderYawOffset = (float)Math.atan((double)(mouseX / 40.0F)) * 20.0F;
        ent.rotationYaw = (float)Math.atan((double)(mouseX / 40.0F)) * 40.0F;
        ent.rotationPitch = -((float)Math.atan((double)(mouseY / 40.0F))) * 20.0F;
        ent.rotationYawHead = ent.rotationYaw;
        ent.prevRotationYawHead = ent.rotationYaw;
        GlStateManager.translate(0.0F, 0.0F, 0.0F);
        RenderManager rendermanager = Minecraft.getMinecraft().getRenderManager();
        rendermanager.setPlayerViewY(180.0F);
        rendermanager.setRenderShadow(false);
        rendermanager.renderEntity(ent, 0.0D, 0.0D, 0.0D, 0.0F, 1.0F, false);
        rendermanager.setRenderShadow(true);
        ent.renderYawOffset = f;
        ent.rotationYaw = f1;
        ent.rotationPitch = f2;
        ent.prevRotationYawHead = f3;
        ent.rotationYawHead = f4;
        GlStateManager.popMatrix();
        RenderHelper.disableStandardItemLighting();
        GlStateManager.disableRescaleNormal();
        GlStateManager.setActiveTexture(OpenGlHelper.lightmapTexUnit);
        GlStateManager.disableTexture2D();
        GlStateManager.setActiveTexture(OpenGlHelper.defaultTexUnit);
    }
    
	@Override
    public void updateScreen() {
        super.updateScreen();
	}
	
	@Override
	  public boolean doesGuiPauseGame()
    {
        return false;
    }
	
	@Override
	protected void keyTyped(char c, int keyCode) {
		try {
			super.keyTyped(c, keyCode);
		} catch (IOException e) {
			e.printStackTrace();
		}
		if (keyCode == KeyInputHandler.Keybinds.keyBindings[1].getKeyCode()) {
			mc.player.closeScreen();
		}
	}
}
