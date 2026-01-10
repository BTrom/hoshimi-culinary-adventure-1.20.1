package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.effects.particle.AcidParticle;
import com.botrom.hoshimi_ca_mod.effects.particle.ShockwaveParticle;
import com.botrom.hoshimi_ca_mod.effects.particle.SurgeParticle;
import com.botrom.hoshimi_ca_mod.entities.models.*;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.registry.ModParticleTypes;
import com.botrom.hoshimi_ca_mod.utils.BlueprintDataUtils;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.registries.RegistryObject;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ClientEvents {
//	private static final List<RegistryObject<Block>> FOLIAGE_COLOR_BLOCKS = Arrays.asList(ModBlocks.LUCUMA_LEAVES, ModBlocks.LUCUMA_LEAF_PILE);
	private static final List<RegistryObject<Block>> GRASS_COLOR_BLOCKS = Collections.emptyList();

	@SubscribeEvent
	public void registerBlockColors(RegisterColorHandlersEvent.Block e) {
//		if (!FOLIAGE_COLOR_BLOCKS.isEmpty()) {
//			DataUtil.registerBlockColor(e.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageFoliageColor(tint, pos) : FoliageColor.getDefaultColor(), FOLIAGE_COLOR_BLOCKS);
//		}
		if (!GRASS_COLOR_BLOCKS.isEmpty()) {
			BlueprintDataUtils.registerBlockColor(e.getBlockColors(), (state, tint, pos, u) -> pos != null && tint != null ? BiomeColors.getAverageGrassColor(tint, pos) : GrassColor.getDefaultColor(), GRASS_COLOR_BLOCKS);
		}
	}

//	@SubscribeEvent
//	public void registerItemColors(RegisterColorHandlersEvent.Item event) {
//		if (!FOLIAGE_COLOR_BLOCKS.isEmpty()) {
//			BlueprintDataUtils.registerBlockItemColor(event.getItemColors(), (stack, c) -> event.getBlockColors().getColor(((BlockItem) stack.getItem()).getBlock().defaultBlockState(), null, null, c), FOLIAGE_COLOR_BLOCKS);
//		}
//	}

	@SubscribeEvent
	public void registerLayerDefinition(EntityRenderersEvent.RegisterLayerDefinitions e) {
		e.registerLayerDefinition(TigerPrawnRenderer.LAYER_LOCATION, TigerPrawnModel::createBodyLayer);
		e.registerLayerDefinition(UrchinRenderer.LAYER_LOCATION, UrchinModel::createBodyLayer);
		e.registerLayerDefinition(PlatinumBassRenderer.LAYER_LOCATION, PlatinumBassModel::createBodyLayer);
		e.registerLayerDefinition(ChieftainCrabRenderer.LAYER_LOCATION, ChieftainCrabModel::createBodyLayer);
		e.registerLayerDefinition(ClamRenderer.LAYER_LOCATION, ClamModel::createBodyLayer);
	}


	@SubscribeEvent
	public void registerEntityRenders(EntityRenderersEvent.RegisterRenderers e) {
		e.registerEntityRenderer(ModEntities.TIGER_PRAWN.get(), TigerPrawnRenderer::new);
		e.registerEntityRenderer(ModEntities.URCHIN.get(), UrchinRenderer::new);
		e.registerEntityRenderer(ModEntities.PLATINUM_BASS.get(), PlatinumBassRenderer::new);
		e.registerEntityRenderer(ModEntities.CHIEFTAIN_CRAB.get(), ChieftainCrabRenderer::new);
		e.registerEntityRenderer(ModEntities.CLAM.get(), ClamRenderer::new);
//		e.registerEntityRenderer(ModEntities.URCHIN_DART.get(), UrchinDartRenderer::new);
//		e.registerEntityRenderer(ModEntities.SHIMMERING_PEARL.get(), ThrownItemRenderer::new);
	}

	@SubscribeEvent
	public void registerParticles(RegisterParticleProvidersEvent e) {
		e.registerSpriteSet(ModParticleTypes.ACID.get(), AcidParticle.Provider::new);
		e.registerSpriteSet(ModParticleTypes.SHOCKWAVE.get(), ShockwaveParticle.Provider::new);
		e.registerSpriteSet(ModParticleTypes.SURGE.get(), SurgeParticle.Provider::new);
	}

	/*
	@SubscribeEvent
    public void setupClient(FMLClientSetupEvent e){
    }
	*/
}