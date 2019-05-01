package com.oscar.util.handlers;

import java.util.HashSet;

import com.oscar.client.render.SRRLModelCache;
import com.oscar.util.Reference;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.resources.IReloadableResourceManager;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.registry.IRegistry;
import net.minecraftforge.client.event.ModelBakeEvent;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.event.TextureStitchEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

@Mod.EventBusSubscriber(modid = Reference.MOD_ID)
public class ClientEventHandler {

	@SubscribeEvent
	public static void onRegisterModelsEvent(final ModelRegistryEvent event) {
	((IReloadableResourceManager) Minecraft.getMinecraft().getResourceManager()).registerReloadListener(SRRLModelCache.INSTANCE);
	}
	
	@SubscribeEvent
	public static void onModelBakeEvent(final ModelBakeEvent event) {
		final IRegistry<ModelResourceLocation, IBakedModel> registry = event.getModelRegistry();

		injectModels(registry);

	}
	
	@SubscribeEvent
	public static void TextureStiching(TextureStitchEvent.Pre event) {
			TextureMap map = event.getMap();
			map.registerSprite(new ResourceLocation(Reference.MOD_ID,"tail/tailskincolour"));
			map.registerSprite(new ResourceLocation(Reference.MOD_ID,"tail/tailhaircolour"));
	}
	
	private static void injectModels(final IRegistry<ModelResourceLocation, IBakedModel> registry) {
		final HashSet<ResourceLocation> modelLocations = new HashSet<>();

		modelLocations.add(new ResourceLocation(Reference.MOD_ID, "tail"));

		for (final ResourceLocation modelLocation : modelLocations) {
			try {
				/* modified from code made by Draco18s */
				final ModelResourceLocation location = new ModelResourceLocation(modelLocation.toString());

				final IBakedModel bakedModel = SRRLModelCache.INSTANCE.getBakedModel(modelLocation);

				registry.putObject(location, bakedModel);
				System.out.println("Sucessfully injected " + modelLocation.toString() + " into Model Registry");
			} catch (final Exception e) {
				System.out.println("Error injecting model " + modelLocation.toString() + " into Model Registry");
			}
		}
	}
}
