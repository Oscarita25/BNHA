package com.oscar.client.render.gui;

import com.oscar.BNHA;
import com.oscar.data.packets.MessageRequestEXP;
import com.oscar.data.packets.MessageRequestLEVEL;
import com.oscar.data.packets.MessageRequestNEXP;
import com.oscar.data.packets.MessageRequestQuirkID;
import com.oscar.data.types.exp.ExpProvider;
import com.oscar.data.types.interfaces.IExp;
import com.oscar.data.types.interfaces.ILevel;
import com.oscar.data.types.interfaces.INExp;
import com.oscar.data.types.level.LevelProvider;
import com.oscar.data.types.nexp.NExpProvider;
import com.oscar.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.minecraftforge.fml.common.eventhandler.EventPriority;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class Lvlgui extends GuiScreen{
		
		private static final ResourceLocation texture = new ResourceLocation(Reference.MOD_ID, "textures/gui/expbar.png");
		
		public Lvlgui(Minecraft mc) {
			super();
		}


		
		@SubscribeEvent(priority=EventPriority.NORMAL)
		public void onRenderExperienceBar(RenderGameOverlayEvent.Post event) {
			
			EntityPlayer player = Minecraft.getMinecraft().player;
			if (player == null) {
				return;
			}
		    
	        IExp exp = player.getCapability(ExpProvider.EXP_CAP, null);
	        INExp nexp = player.getCapability(NExpProvider.NEXP_CAP, null);
	        ILevel level = player.getCapability(LevelProvider.LEVEL_CAP, null);
			
	        
			BNHA.NETWORK.sendToServer(new MessageRequestLEVEL());
			BNHA.NETWORK.sendToServer(new MessageRequestEXP());
			BNHA.NETWORK.sendToServer(new MessageRequestNEXP());
			BNHA.NETWORK.sendToServer(new MessageRequestQuirkID());

	        
			if (event.getType() != ElementType.EXPERIENCE) return;
			
	        
			ScaledResolution sr = new ScaledResolution(Minecraft.getMinecraft());
			int yPos = ((sr.getScaledHeight() /2) + (sr.getScaledHeight() / 2)) - 30 , xPos = (sr.getScaledWidth() /2) + (sr.getScaledWidth() / 4);
			
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);

			drawTexturedModalRect(xPos, yPos, 0, 0, 128, 11);
			
			drawTexturedModalRect(xPos, yPos + 2, 1, 12, exp.getexp() / nexp.getnexp() * 82, 11);
			String y = "Level " + level.getlvl();
			String s = exp.getexp() + "/" + nexp.getnexp();
			yPos -= 10;
			Minecraft.getMinecraft().fontRenderer.drawString(s, xPos + 20, yPos, 2550000, true);
			Minecraft.getMinecraft().fontRenderer.drawString(y, xPos + 20, yPos + 11, 2550000, true);

			}

		
		
	}
