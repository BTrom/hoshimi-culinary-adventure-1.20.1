package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.models.*;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.utils.BlueprintDataUtils;
import com.botrom.hoshimi_ca_mod.utils.EmissiveBakedModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.WingHudOverlay;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.DryFoliageColorReloadListener;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.api.DryFoliageColor;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.api.LeafColors;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.*;
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
		e.getBlockColors().register((state, level, pos, tint) -> level != null && pos != null ? LeafColors.getAverageDryFoliageColor(pos) : DryFoliageColor.FOLIAGE_DRY_DEFAULT, ModBlocks.LEAF_LITTER.get());
		e.getBlockColors().register((state, level, pos, tint) -> level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.getDefaultColor(), ModBlocks.BUSH.get());
		e.getBlockColors().register((state, level, pos, tint) -> {
			if (tint != 0) {
				return level != null && pos != null ? BiomeColors.getAverageGrassColor(level, pos) : GrassColor.getDefaultColor();
			} else {
				return -1;
			}}, ModBlocks.WILDFLOWERS.get());
	}

	@SubscribeEvent
	public void registerItemColors(RegisterColorHandlersEvent.Item e) {
		e.register((stack, tintIndex) -> {
					BlockState state = ((BlockItem) stack.getItem()).getBlock().defaultBlockState();
					return e.getBlockColors().getColor(state, null, null, tintIndex);
				}, ModBlocks.BUSH.get());
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
		e.registerLayerDefinition(BatRendererModule.LAYER_LOCATION, BatModel::createBodyLayer);
		e.registerLayerDefinition(ArmadilloRenderer.LAYER_LOCATION, ArmadilloModel::createBodyLayer);
		e.registerLayerDefinition(HappyGhastRenderer.HAPPY_GHAST_LAYER_LOCATION, () -> HappyGhastModel.createBodyLayer(false, CubeDeformation.NONE));
		e.registerLayerDefinition(HappyGhastRenderer.HAPPY_GHAST_BABY_LAYER_LOCATION, () -> HappyGhastModel.createBodyLayer(true, CubeDeformation.NONE));
		e.registerLayerDefinition(HappyGhastRenderer.HAPPY_GHAST_HARNESS_LAYER_LOCATION, HappyGhastHarnessModel::createHarnessLayer);
		e.registerLayerDefinition(HappyGhastRenderer.HAPPY_GHAST_ROPES_LAYER_LOCATION, () -> HappyGhastModel.createBodyLayer(false, new CubeDeformation(0.2F)));
		e.registerLayerDefinition(HappyGhastRenderer.HAPPY_GHAST_BABY_ROPES_LAYER_LOCATION, () -> HappyGhastModel.createBodyLayer(true, new CubeDeformation(0.2F)));
		e.registerLayerDefinition(PigVariantRenderer.COLD_PIG, ColdPigModel::createBodyLayer);
		e.registerLayerDefinition(ChickenVariantRenderer.COLD_CHICKEN, ColdChickenModel::createBodyLayer);
		e.registerLayerDefinition(CowVariantRenderer.COLD_COW, ColdCowModel::createBodyLayer);
		e.registerLayerDefinition(CowVariantRenderer.WARM_COW, WarmCowModel::createBodyLayer);
//		e.registerLayerDefinition(ModModelLayers.SHEEP_WOOL_UNDERCOAT, SheepModel::createBodyLayer);
		e.registerLayerDefinition(new ModelLayerLocation(Utils.createResourceLocation("succubus"), "main"), SuccubusModel::createBodyLayer);
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

	private static final ResourceLocation FIREFLY_BUSH_EMISSIVE = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block/firefly_bush_emissive");
	private static final ResourceLocation OPEN_EYEBLOSSOM_EMISSIVE = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block/open_eyeblossom_emissive");

	@SubscribeEvent
	public static void registerAdditionalModels(ModelEvent.RegisterAdditional event) {
		// We must force the game to load/bake this model even though no BlockState uses it directly
		event.register(FIREFLY_BUSH_EMISSIVE);
		event.register(OPEN_EYEBLOSSOM_EMISSIVE);
	}

	@SubscribeEvent
	public void registerReloadListeners(RegisterClientReloadListenersEvent event) {
		// This registers the listener to the resource manager
		event.registerReloadListener(DryFoliageColorReloadListener.INSTANCE);

		// If you also have the LeafColorReloadListener from the other code, register it here too:
		// event.registerReloadListener(LeafColorReloadListener.INSTANCE);
	}

	@SubscribeEvent
	public static void onModelBake(ModelEvent.ModifyBakingResult event) {
		for (var entry : event.getModels().entrySet()) {
			ResourceLocation modelLoc = entry.getKey();

			// Check if this model belongs to our Firefly Bush
			// We use the registry name string check
			if (modelLoc.getNamespace().equals(HoshimiCulinaryMod.MOD_ID)) {
				if (modelLoc.getPath().contains("firefly_bush") && !modelLoc.getPath().contains("emissive")) {
					if (entry.getValue() != null && event.getModels().get(FIREFLY_BUSH_EMISSIVE) != null) {
						event.getModels().put(modelLoc, new EmissiveBakedModel(entry.getValue(), event.getModels().get(FIREFLY_BUSH_EMISSIVE)));
					}
				} else if (modelLoc.getPath().contains("open_eyeblossom") && !modelLoc.getPath().contains("emissive")) {
					if (entry.getValue() != null && event.getModels().get(OPEN_EYEBLOSSOM_EMISSIVE) != null) {
						event.getModels().put(modelLoc, new EmissiveBakedModel(entry.getValue(), event.getModels().get(OPEN_EYEBLOSSOM_EMISSIVE)));
					}
				}
			}
		}
	}
}