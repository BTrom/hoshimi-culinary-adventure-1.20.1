package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.entities.models.*;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.utils.BlueprintDataUtils;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Collections;
import java.util.List;

public class ClientEvents {

	public static int renderStaticScreenFor = 0;

	private static final List<RegistryObject<Block>> GRASS_COLOR_BLOCKS = Collections.emptyList();

	@SubscribeEvent
	public void registerBlockColors(RegisterColorHandlersEvent.Block e) {
		if (!GRASS_COLOR_BLOCKS.isEmpty()) {
			BlueprintDataUtils.registerBlockColor(e.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageGrassColor(tint, pos) : GrassColor.getDefaultColor(), GRASS_COLOR_BLOCKS);
		}
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
	}


	@SubscribeEvent
	public void registerEntityRenders(EntityRenderersEvent.RegisterRenderers e) {

	}


	@SubscribeEvent
	public void registerParticles(RegisterParticleProvidersEvent e) {

	}
}