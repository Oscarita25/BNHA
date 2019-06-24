package com.oscar.client.render.gui;

import com.oscar.data.Capabilities;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.util.Reference;
import com.oscar.util.handlers.KeyInputHandler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.renderer.BufferBuilder;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.text.TextFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Lvlgui extends GuiScreen{
		
		private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/expbar.png");
		public int nx = 0;
		public float ux = 0;

		public Lvlgui(Minecraft mc) {
			super();
		}
		
		@SubscribeEvent(priority=EventPriority.NORMAL)
		public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
			
			
			EntityPlayer player = Minecraft.getMinecraft().player;
			if (player == null) {
				return;
			}
		    
			//Capabilities and Packets
	        IExp exp = player.getCapability(Capabilities.exp, null);
	        INExp nexp = player.getCapability(Capabilities.nexp, null);
	        ILevel level = player.getCapability(Capabilities.level, null);

	        if(exp == null || nexp == null || level == null) return;
	        
	        
			if (event.getType() != ElementType.EXPERIENCE) return;
						
			//just so the bar sticks on the right lower corner even if resolution is changed
			ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
			int yPos = ((sr.getScaledHeight() /2) + (sr.getScaledHeight() / 2)) - 30 , xPos = (sr.getScaledWidth() /2) + (sr.getScaledWidth() / 4);
			
			//Binding the Texture
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

			//Background of the Bar
			drawTexturedModalRect(xPos, yPos, 0, 0, 128, 11);
			
			//just some math to get the percentage of the exp drawn as actual Bar

			int x = ((exp.getexp()*100 / nexp.getnexp()*100) * 82)/10000;

			
			if(player.ticksExisted % 1 == 0) {
				if(this.ux <= 1F)
				this.ux += 0.1F;
				
				
			}
			
			if(player.ticksExisted % 20 == 0) {
				if(this.nx != x) {
					this.nx = x;
					this.ux = 0F;
					}
			}


			//here drawing the Bar
			drawsomeshitidunno(xPos, yPos + 2, 1, 12, nx , 11, ux);
			
			// Text for the Level Bar
			String a = "Level " + level.getlvl();
			String b = exp.getexp() + "/" + nexp.getnexp();
			//String c = "x: " + x +"; nx: " +nx + "; ux: " + ux;
			String d = "";
			if(KeyInputHandler.battlemode)
				d = TextFormatting.WHITE+"Battle Mode: "+TextFormatting.GREEN+ "On";
			else
				d = TextFormatting.WHITE+"Battle Mode: "+TextFormatting.RED+ "Off";
			
			yPos -= 10;
			Minecraft.getMinecraft().fontRenderer.drawString(a, xPos + 20, yPos, 2550000, true);
			Minecraft.getMinecraft().fontRenderer.drawString(b, xPos + 20, yPos + 11, 2550000, true);
			//Minecraft.getMinecraft().fontRenderer.drawString(c, xPos - 30, yPos - 20, 2550000, true);
		    Minecraft.getMinecraft().fontRenderer.drawString(d, xPos , yPos - 10, 2550000, true);
			}

		
		
	    /**
	     * Draws a textured rectangle at the current z-value.
	     */
	    public void drawsomeshitidunno(int x, int y, int textureX, int textureY, int width, int height, float progress)
	    {
	        
	        Tessellator tessellator = Tessellator.getInstance();
	        BufferBuilder bufferbuilder = tessellator.getBuffer();
	        bufferbuilder.begin(7, DefaultVertexFormats.POSITION_TEX);
	        bufferbuilder.pos((double)(x + 0), (double)(y + height), (double)this.zLevel).tex((double)((float)(textureX + 0) * 0.00390625F), (double)((float)(textureY + height) * 0.00390625F)).endVertex();
	        bufferbuilder.pos((double)(x + width + progress ), (double)(y + height), (double)this.zLevel).tex((double)((float)(textureX + width + progress) * 0.00390625F), (double)((float)(textureY + height) * 0.00390625F)).endVertex();
	        bufferbuilder.pos((double)(x + width + progress ), (double)(y + 0), (double)this.zLevel).tex((double)((float)(textureX + width + progress) * 0.00390625F), (double)((float)(textureY + 0) * 0.00390625F)).endVertex();
	        bufferbuilder.pos((double)(x + 0), (double)(y + 0), (double)this.zLevel).tex((double)((float)(textureX + 0) * 0.00390625F), (double)((float)(textureY + 0) * 0.00390625F)).endVertex();
	        
	        
	        tessellator.draw();
	    }
		
		
		
	}
