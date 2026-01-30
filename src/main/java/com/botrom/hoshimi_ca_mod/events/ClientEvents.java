package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.models.*;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.utils.BlueprintDataUtils;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.WingHudOverlay;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterGuiOverlaysEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.List;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientEvents {

	public static int renderStaticScreenFor = 0;

	private static final List<RegistryObject<Block>> GRASS_COLOR_BLOCKS = Collections.emptyList();

	@SubscribeEvent
	public void registerBlockColors(RegisterColorHandlersEvent.Block e) {
		if (!GRASS_COLOR_BLOCKS.isEmpty()) {
			BlueprintDataUtils.registerBlockColor(e.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageGrassColor(tint, pos) : GrassColor.getDefaultColor(), GRASS_COLOR_BLOCKS);
		}
		e.getBlockColors().register((pState, pLevel, pPos, pTintIndex) -> pLevel != null && pPos != null ? BiomeColors.getAverageFoliageColor(pLevel, pPos) : FoliageColor.getDefaultColor(), ModBlocks.PALM_LEAVES.get());
	}

	@SubscribeEvent
	public void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions e) {
		e.registerLayerDefinition(TigerPrawnRenderer.LAYER_LOCATION, TigerPrawnModel::createBodyLayer);
		e.registerLayerDefinition(UrchinRenderer.LAYER_LOCATION, UrchinModel::createBodyLayer);
		e.registerLayerDefinition(PlatinumBassRenderer.LAYER_LOCATION, PlatinumBassModel::createBodyLayer);
		e.registerLayerDefinition(ChieftainCrabRenderer.LAYER_LOCATION, ChieftainCrabModel::createBodyLayer);
		e.registerLayerDefinition(ClamRenderer.LAYER_LOCATION, ClamModel::createBodyLayer);
		e.registerLayerDefinition(FiddlerCrabModel.LAYER_LOCATION, FiddlerCrabModel::createBodyLayer);
		e.registerLayerDefinition(new ModelLayerLocation(Utils.createResourceLocation("shiba"), "main"), ShibaModel::createBodyLayer);
		e.registerLayerDefinition(CoconutCrabModel.LAYER_LOCATION, CoconutCrabModel::createBodyLayer);
		e.registerLayerDefinition(NautilusRenderer.LAYER_MAIN, NautilusModel::createBodyLayer);
		e.registerLayerDefinition(NautilusRenderer.LAYER_BABY, NautilusModel::createBabyBodyLayer);
		e.registerLayerDefinition(NautilusRenderer.LAYER_SADDLE, NautilusModel::createSaddleLayer);
		e.registerLayerDefinition(NautilusRenderer.LAYER_ARMOR, NautilusModel::createArmorLayer);
	}


	@SubscribeEvent
	public void registerEntityRenders(EntityRenderersEvent.RegisterRenderers e) {

	}


	@SubscribeEvent
	public void registerParticles(RegisterParticleProvidersEvent e) {

	}

	@SubscribeEvent
	public static void registerItemProperties(FMLClientSetupEvent event) {
		event.enqueueWork(() -> {
			ItemProperties.register(
					ModItems.ANGEL_WINGS.get(), // Your RegistryObject
					new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "wing_open"),
					(stack, level, entity, seed) -> {
						// Returns 1.0 if Open, 0.0 if Closed
						return stack.getOrCreateTag().getBoolean("WingState") ? 1.0F : 0.0F;
					}
			);
		});
	}

	// Register the HUD
	@SubscribeEvent
	public static void registerGuiOverlays(RegisterGuiOverlaysEvent event) {
		event.registerAboveAll("angel_wings_hud", new WingHudOverlay());
	}
}