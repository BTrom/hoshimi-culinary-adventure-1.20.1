package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;
import net.minecraft.world.level.material.Fluids;
import net.minecraftforge.registries.DeferredRegister;

import java.util.List;

public class ModPlacedFeatures {
    public static final DeferredRegister<PlacedFeature> FEATURES = DeferredRegister.create(Registries.PLACED_FEATURE, HoshimiCulinaryMod.MOD_ID);

    // TREE PLACEMENTS
    public static final ResourceKey<PlacedFeature> PALE_OAK_CHECKED = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_oak_checked"));
    public static final ResourceKey<PlacedFeature> PALE_OAK_CREAKING_CHECKED = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_oak_creaking_checked"));
    public static final ResourceKey<PlacedFeature> FALLEN_OAK_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_oak_tree"));
    public static final ResourceKey<PlacedFeature> FALLEN_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_birch_tree"));
    public static final ResourceKey<PlacedFeature> FALLEN_SUPER_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_super_birch_tree"));
    public static final ResourceKey<PlacedFeature> FALLEN_JUNGLE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_jungle_tree"));
    public static final ResourceKey<PlacedFeature> FALLEN_SPRUCE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_spruce_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_FALLEN_OAK_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_fallen_oak_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_RARE_FALLEN_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_rare_fallen_birch_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_FALLEN_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_fallen_birch_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_FALLEN_SUPER_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_fallen_super_birch_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_FALLEN_JUNGLE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_fallen_jungle_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_FALLEN_SPRUCE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_fallen_spruce_tree"));
    public static final ResourceKey<PlacedFeature> PLACED_RARE_FALLEN_SPRUCE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("placed_rare_fallen_spruce_tree"));
    
    // VEGETATION PLACEMENTS
    public static final ResourceKey<PlacedFeature> FLOWER_PALE_GARDEN = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("flower_pale_garden"));
    public static final ResourceKey<PlacedFeature> PALE_GARDEN_VEGETATION = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_garden_vegetation"));
    public static final ResourceKey<PlacedFeature> PALE_GARDEN_FLOWERS = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_garden_flowers"));
    public static final ResourceKey<PlacedFeature> PALE_MOSS_PATCH = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_moss_patch"));
    public static final ResourceKey<PlacedFeature> PATCH_BUSH = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_bush"));
    public static final ResourceKey<PlacedFeature> PATCH_FIREFLY_BUSH_NEAR_WATER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_firefly_bush_near_water"));
    public static final ResourceKey<PlacedFeature> PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_firefly_bush_near_water_swamp"));
    public static final ResourceKey<PlacedFeature> PATCH_FIREFLY_BUSH_SWAMP = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_firefly_bush_swamp"));
    public static final ResourceKey<PlacedFeature> WILDFLOWERS_BIRCH_FOREST = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("wildflowers_birch_forest"));
    public static final ResourceKey<PlacedFeature> WILDFLOWERS_MEADOW = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("wildflowers_meadow"));
    public static final ResourceKey<PlacedFeature> PATCH_DRY_GRASS_BADLANDS = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_dry_grass_badlands"));
    public static final ResourceKey<PlacedFeature> PATCH_DRY_GRASS_DESERT = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_dry_grass_desert"));
    public static final ResourceKey<PlacedFeature> PATCH_LEAF_LITTER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_leaf_litter"));
    public static final ResourceKey<PlacedFeature> LEAF_LITTER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("leaf_litter"));
    public static final ResourceKey<PlacedFeature> CACTUS_FLOWER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("cactus_flower"));

    public static void bootstrap(BootstapContext<PlacedFeature> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        Holder<ConfiguredFeature<?, ?>> patch = features.getOrThrow(ModConfiguredFeatures.PATCH_FIREFLY_BUSH);

        // TREE PLACEMENTS
        ModFeatures.register(context, PALE_OAK_CHECKED, features.getOrThrow(ModConfiguredFeatures.PALE_OAK), PlacementUtils.filteredByBlockSurvival(ModBlocks.PALE_OAK_SAPLING.get()));
        ModFeatures.register(context, PALE_OAK_CREAKING_CHECKED, features.getOrThrow(ModConfiguredFeatures.PALE_OAK_CREAKING), PlacementUtils.filteredByBlockSurvival(ModBlocks.PALE_OAK_SAPLING.get()));
        // VEGETATION PLACEMENTS
        ModFeatures.register(context, PATCH_BUSH, features.getOrThrow(ModConfiguredFeatures.PATCH_BUSH), RarityFilter.onAverageOnceEvery(4), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModFeatures.register(context, PATCH_FIREFLY_BUSH_NEAR_WATER, patch, CountPlacement.of(2), InSquarePlacement.spread(), HeightmapPlacement.onHeightmap(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES), BiomeFilter.biome(), nearWaterPredicate(ModBlocks.FIREFLY_BUSH.get()));
        ModFeatures.register(context, PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP, patch, CountPlacement.of(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome(), nearWaterPredicate(ModBlocks.FIREFLY_BUSH.get()));
        ModFeatures.register(context, PATCH_FIREFLY_BUSH_SWAMP, patch, RarityFilter.onAverageOnceEvery(8), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModFeatures.register(context, WILDFLOWERS_BIRCH_FOREST, features.getOrThrow(ModConfiguredFeatures.WILDFLOWERS_BIRCH_FOREST), CountPlacement.of(3), RarityFilter.onAverageOnceEvery(2), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModFeatures.register(context, WILDFLOWERS_MEADOW, features.getOrThrow(ModConfiguredFeatures.WILDFLOWERS_MEADOW), NoiseThresholdCountPlacement.of(-0.8, 5, 10), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModFeatures.register(context, PATCH_DRY_GRASS_BADLANDS, features.getOrThrow(ModConfiguredFeatures.PATCH_DRY_GRASS), RarityFilter.onAverageOnceEvery(6), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModFeatures.register(context, PATCH_DRY_GRASS_DESERT, features.getOrThrow(ModConfiguredFeatures.PATCH_DRY_GRASS), RarityFilter.onAverageOnceEvery(3), InSquarePlacement.spread(), PlacementUtils.HEIGHTMAP, BiomeFilter.biome());
        ModFeatures.register(context, PATCH_LEAF_LITTER, features.getOrThrow(ModConfiguredFeatures.PATCH_LEAF_LITTER), VegetationPlacements.worldSurfaceSquaredWithCount(2));
        ModFeatures.register(context, FALLEN_OAK_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_OAK_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.OAK_SAPLING));
        ModFeatures.register(context, FALLEN_BIRCH_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_BIRCH_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
        ModFeatures.register(context, FALLEN_SUPER_BIRCH_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_SUPER_BIRCH_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.BIRCH_SAPLING));
        ModFeatures.register(context, FALLEN_SPRUCE_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_SPRUCE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.SPRUCE_SAPLING));
        ModFeatures.register(context, FALLEN_JUNGLE_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_JUNGLE_TREE), PlacementUtils.filteredByBlockSurvival(Blocks.JUNGLE_SAPLING));
        ModFeatures.register(context, LEAF_LITTER, features.getOrThrow(ModConfiguredFeatures.LEAF_LITTER), VegetationPlacements.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1)));
        ModFeatures.register(context, CACTUS_FLOWER, features.getOrThrow(ModConfiguredFeatures.CACTUS_FLOWER), VegetationPlacements.treePlacement(PlacementUtils.countExtra(16, 0.1F, 1)));
        ModFeatures.register(context, PLACED_FALLEN_OAK_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_OAK_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(80), Blocks.OAK_SAPLING));
        ModFeatures.register(context, PLACED_RARE_FALLEN_BIRCH_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_BIRCH_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(400), Blocks.BIRCH_SAPLING));
        ModFeatures.register(context, PLACED_FALLEN_BIRCH_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_BIRCH_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(80), Blocks.BIRCH_SAPLING));
        ModFeatures.register(context, PLACED_FALLEN_SUPER_BIRCH_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_SUPER_BIRCH_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(160), Blocks.BIRCH_SAPLING));
        ModFeatures.register(context, PLACED_FALLEN_JUNGLE_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_JUNGLE_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(80), Blocks.JUNGLE_SAPLING));
        ModFeatures.register(context, PLACED_FALLEN_SPRUCE_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_SPRUCE_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(80), Blocks.SPRUCE_SAPLING));
        ModFeatures.register(context, PLACED_RARE_FALLEN_SPRUCE_TREE, features.getOrThrow(ModConfiguredFeatures.FALLEN_SPRUCE_TREE), VegetationPlacements.treePlacement(RarityFilter.onAverageOnceEvery(120), Blocks.SPRUCE_SAPLING));
    }

    public static BlockPredicateFilter nearWaterPredicate(Block block) {
        return BlockPredicateFilter.forPredicate(
                BlockPredicate.allOf(
                        BlockPredicate.ONLY_IN_AIR_PREDICATE,
                        BlockPredicate.wouldSurvive(block.defaultBlockState(), BlockPos.ZERO),
                        BlockPredicate.anyOf(
                                BlockPredicate.matchesFluids(new BlockPos(1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                                BlockPredicate.matchesFluids(new BlockPos(-1, -1, 0), Fluids.WATER, Fluids.FLOWING_WATER),
                                BlockPredicate.matchesFluids(new BlockPos(0, -1, 1), Fluids.WATER, Fluids.FLOWING_WATER),
                                BlockPredicate.matchesFluids(new BlockPos(0, -1, -1), Fluids.WATER, Fluids.FLOWING_WATER)
                        )
                )
        );
    }
}