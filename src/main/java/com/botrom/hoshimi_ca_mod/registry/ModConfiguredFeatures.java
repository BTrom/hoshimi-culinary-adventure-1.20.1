package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.features.FallenTreeConfiguration;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.treedecorators.AttachedToLogsDecorator;
import com.google.common.collect.ImmutableList;
import net.minecraft.core.Direction;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.random.SimpleWeightedRandomList;
import net.minecraft.util.valueproviders.ConstantInt;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.PinkPetalsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.levelgen.blockpredicates.BlockPredicate;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.*;
import net.minecraft.world.level.levelgen.feature.featuresize.ThreeLayersFeatureSize;
import net.minecraft.world.level.levelgen.feature.foliageplacers.DarkOakFoliagePlacer;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.WeightedStateProvider;
import net.minecraft.world.level.levelgen.feature.treedecorators.TrunkVineDecorator;
import net.minecraft.world.level.levelgen.feature.trunkplacers.DarkOakTrunkPlacer;
import net.minecraft.world.level.levelgen.placement.BlockPredicateFilter;
import net.minecraft.world.level.levelgen.placement.CaveSurface;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.registries.DeferredRegister;
import vectorwing.farmersdelight.common.world.configuration.WildCropConfiguration;
import vectorwing.farmersdelight.common.world.feature.WildCropFeature;

import java.util.List;
import java.util.OptionalInt;

public class ModConfiguredFeatures {

    public static final DeferredRegister<ConfiguredFeature<?, ?>> FEATURES = DeferredRegister.create(Registries.CONFIGURED_FEATURE, HoshimiCulinaryMod.MOD_ID);

    // VEGETATION FEATURES
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DRAGON_FRUIT = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_dragon_fruit"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_BUSH = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_FIREFLY_BUSH = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_firefly_bush"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILDFLOWERS_BIRCH_FOREST = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("wildflowers_birch_forest"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> WILDFLOWERS_MEADOW = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("wildflowers_meadow"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_DRY_GRASS = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_dry_grass"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PATCH_LEAF_LITTER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("patch_leaf_litter"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAF_LITTER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("leaf_litter"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> CACTUS_FLOWER = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("cactus_flower"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLOWER_PALE_GARDEN = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("flower_pale_garden"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_GARDEN_FLOWERS = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_garden_flowers"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_GARDEN_VEGETATION = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_garden_vegetation"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_MOSS_VEGETATION = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_moss_vegetation"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_moss_patch"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_MOSS_PATCH_BONEMEAL = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_moss_patch_bonemeal"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEA_ANEMONE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("gencontrol.anemone_configured"));

    // TREE FEATURES
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_OAK_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_oak_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_birch_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_SUPER_BIRCH_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_super_birch_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_JUNGLE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_jungle_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> FALLEN_SPRUCE_TREE = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("fallen_spruce_tree"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_OAK = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_oak"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_OAK_BONEMEAL = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_oak_bonemeal"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALE_OAK_CREAKING = ResourceKey.create(FEATURES.getRegistryKey(), Utils.createResourceLocation("pale_oak_creaking"));


    public static void bootstrap(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<ConfiguredFeature<?, ?>> features = context.lookup(Registries.CONFIGURED_FEATURE);
        HolderGetter<PlacedFeature> placements = context.lookup(Registries.PLACED_FEATURE);

        // VEGETATION FEATURES
        ModFeatures.register(context, PATCH_BUSH, Feature.RANDOM_PATCH, new RandomPatchConfiguration(25, 5, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.BUSH.get())))));
        ModFeatures.register(context, PATCH_FIREFLY_BUSH, Feature.RANDOM_PATCH, new RandomPatchConfiguration(20, 4, 3, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.FIREFLY_BUSH.get())))));
        ModFeatures.register(context, WILDFLOWERS_BIRCH_FOREST, Feature.FLOWER, new RandomPatchConfiguration(64, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(flowerBedPatchBuilder(ModBlocks.WILDFLOWERS.get()))))));
        ModFeatures.register(context, WILDFLOWERS_MEADOW, Feature.FLOWER, new RandomPatchConfiguration(8, 6, 2, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(flowerBedPatchBuilder(ModBlocks.WILDFLOWERS.get()))))));
        ModFeatures.register(context, PATCH_DRY_GRASS, Feature.RANDOM_PATCH, grassPatch(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.SHORT_DRY_GRASS.get().defaultBlockState(), 1).add(ModBlocks.TALL_DRY_GRASS.get().defaultBlockState(), 1).build()), 64));
        ModFeatures.register(context, PATCH_LEAF_LITTER, Feature.RANDOM_PATCH, FeatureUtils.simpleRandomPatchConfiguration(32, PlacementUtils.filtered(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(leafLitterPatchBuilder(1, 3))), BlockPredicate.allOf(BlockPredicate.ONLY_IN_AIR_PREDICATE, BlockPredicate.matchesBlocks(Direction.DOWN.getNormal(), Blocks.GRASS_BLOCK)))));
        ModFeatures.register(context, FALLEN_OAK_TREE, ModFeatures.FALLEN_TREE.get(), createFallenOak().build());
        ModFeatures.register(context, FALLEN_BIRCH_TREE, ModFeatures.FALLEN_TREE.get(), createFallenBirch(8).build());
        ModFeatures.register(context, FALLEN_SUPER_BIRCH_TREE, ModFeatures.FALLEN_TREE.get(), createFallenBirch(15).build());
        ModFeatures.register(context, FALLEN_JUNGLE_TREE, ModFeatures.FALLEN_TREE.get(), createFallenJungle().build());
        ModFeatures.register(context, FALLEN_SPRUCE_TREE, ModFeatures.FALLEN_TREE.get(), createFallenSpruce().build());
        ModFeatures.register(context, LEAF_LITTER, ModFeatures.LEAF_LITTER.get(), FeatureConfiguration.NONE);
        ModFeatures.register(context, CACTUS_FLOWER, ModFeatures.CACTUS_FLOWER.get(), FeatureConfiguration.NONE);
        ModFeatures.register(context, FLOWER_PALE_GARDEN, Feature.FLOWER, new RandomPatchConfiguration(1, 0, 0, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CLOSED_EYEBLOSSOM.get())))));
        ModFeatures.register(context, PALE_GARDEN_FLOWERS, Feature.RANDOM_PATCH, FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.CLOSED_EYEBLOSSOM.get()))));
        ModFeatures.register(context, PALE_MOSS_VEGETATION, Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(ModBlocks.PALE_MOSS_CARPET.get().defaultBlockState(), 25).add(Blocks.GRASS.defaultBlockState(), 25).add(Blocks.TALL_GRASS.defaultBlockState(), 10))));
        ModFeatures.register(context, PALE_MOSS_PATCH, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(ModBlocks.PALE_MOSS_BLOCK.get()), PlacementUtils.inlinePlaced(features.getOrThrow(PALE_MOSS_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.3F, UniformInt.of(2, 4), 0.75F));
        ModFeatures.register(context, PALE_MOSS_PATCH_BONEMEAL, Feature.VEGETATION_PATCH, new VegetationPatchConfiguration(BlockTags.MOSS_REPLACEABLE, BlockStateProvider.simple(ModBlocks.PALE_MOSS_BLOCK.get()), PlacementUtils.inlinePlaced(features.getOrThrow(PALE_MOSS_VEGETATION)), CaveSurface.FLOOR, ConstantInt.of(1), 0.0F, 5, 0.6F, UniformInt.of(1, 2), 0.75F));
        ModFeatures.register(context, SEA_ANEMONE, ModFeatures.SEA_ANEMONE.get(), new CountConfiguration(4));

        ModFeatures.register(context, PALE_OAK, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PALE_OAK_LOG.get()), // Ensure you have these blocks
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.simple(ModBlocks.PALE_OAK_LEAVES.get()),
                new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 0, OptionalInt.empty())
        ).build());

        ModFeatures.register(context, PALE_OAK_CREAKING, Feature.TREE, new TreeConfiguration.TreeConfigurationBuilder(
                BlockStateProvider.simple(ModBlocks.PALE_OAK_LOG.get()),
                new DarkOakTrunkPlacer(6, 2, 1),
                BlockStateProvider.simple(ModBlocks.PALE_OAK_LEAVES.get()),
                new DarkOakFoliagePlacer(ConstantInt.of(0), ConstantInt.of(0)),
                new ThreeLayersFeatureSize(1, 1, 0, 1, 0, OptionalInt.empty())
        ).build());

        var paleOakChecked = PlacementUtils.inlinePlaced(
                features.getOrThrow(PALE_OAK),
                PlacementUtils.filteredByBlockSurvival(ModBlocks.PALE_OAK_SAPLING.get())
        );

        var paleOakCreakingChecked = PlacementUtils.inlinePlaced(
                features.getOrThrow(PALE_OAK_CREAKING),
                PlacementUtils.filteredByBlockSurvival(ModBlocks.PALE_OAK_SAPLING.get())
        );

        ModFeatures.register(context, PALE_GARDEN_VEGETATION, Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(
                List.of(
                        new WeightedPlacedFeature(paleOakCreakingChecked, 0.1F),
                        new WeightedPlacedFeature(paleOakChecked, 0.9F)
                ), paleOakChecked
        ));

        ModFeatures.register(context, PATCH_DRAGON_FRUIT,
                vectorwing.farmersdelight.common.registry.ModBiomeFeatures.WILD_CROP.get(),
                new WildCropConfiguration(25, 5, 3, PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(ModBlocks.DRAGON_BUSH.get())),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.matchesTag(Direction.DOWN.getNormal(), ModTags.DRAGON_FRUIT_SPAWNABLE_ON)
                        ))
                ), PlacementUtils.inlinePlaced(
                        Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(vectorwing.farmersdelight.common.registry.ModBlocks.SANDY_SHRUB.get())),
                        BlockPredicateFilter.forPredicate(BlockPredicate.allOf(
                                BlockPredicate.ONLY_IN_AIR_PREDICATE,
                                BlockPredicate.matchesTag(Direction.DOWN.getNormal(), ModTags.DRAGON_FRUIT_SPAWNABLE_ON)
                        ))
                ), null)
        );
    }

    private static RandomPatchConfiguration grassPatch(BlockStateProvider provider, int tries) {
        return FeatureUtils.simpleRandomPatchConfiguration(tries, PlacementUtils.onlyWhenEmpty(Feature.SIMPLE_BLOCK, new SimpleBlockConfiguration(provider)));
    }

    private static SimpleWeightedRandomList.Builder<BlockState> flowerBedPatchBuilder(Block block) {
        return segmentedBlockPatchBuilder(block, 1, 4, PinkPetalsBlock.AMOUNT, PinkPetalsBlock.FACING);
    }

    private static SimpleWeightedRandomList.Builder<BlockState> leafLitterPatchBuilder(int min, int max) {
        return segmentedBlockPatchBuilder(ModBlocks.LEAF_LITTER.get(), min, max, PinkPetalsBlock.AMOUNT, PinkPetalsBlock.FACING);
    }

    private static SimpleWeightedRandomList.Builder<BlockState> segmentedBlockPatchBuilder(Block block, int min, int max, IntegerProperty amount, EnumProperty<Direction> facing) {
        SimpleWeightedRandomList.Builder<BlockState> builder = SimpleWeightedRandomList.builder();
        for (int i = min; i <= max; i++) {
            for (Direction direction : Direction.Plane.HORIZONTAL) {
                builder.add(block.defaultBlockState().setValue(amount, i).setValue(facing, direction), 1);
            }
        }
        return builder;
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenOak() {
        return createFallenTrees(Blocks.OAK_LOG, 4, 7).stumpDecorators(ImmutableList.of(TrunkVineDecorator.INSTANCE));
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenBirch(int i) {
        return createFallenTrees(Blocks.BIRCH_LOG, 5, i);
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenJungle() {
        return createFallenTrees(Blocks.JUNGLE_LOG, 4, 11).stumpDecorators(ImmutableList.of(TrunkVineDecorator.INSTANCE));
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenSpruce() {
        return createFallenTrees(Blocks.SPRUCE_LOG, 6, 10);
    }

    private static FallenTreeConfiguration.FallenTreeConfigurationBuilder createFallenTrees(Block block, int minLength, int maxLength) {
        return new FallenTreeConfiguration.FallenTreeConfigurationBuilder(BlockStateProvider.simple(block), UniformInt.of(minLength, maxLength)).logDecorators(ImmutableList.of(new AttachedToLogsDecorator(0.1F, new WeightedStateProvider(SimpleWeightedRandomList.<BlockState>builder().add(Blocks.RED_MUSHROOM.defaultBlockState(), 2).add(Blocks.BROWN_MUSHROOM.defaultBlockState(), 1)), List.of(Direction.UP))));
    }
}
