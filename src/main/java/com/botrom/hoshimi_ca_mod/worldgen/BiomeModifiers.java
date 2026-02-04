package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.registry.ModPlacedFeatures;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

public class BiomeModifiers {
    public static final ResourceKey<BiomeModifier> ADD_TREE_PALM = registerKey("add_tree_palm");
    public static final ResourceKey<BiomeModifier> ADD_SEASHELLS = registerKey("add_seashells");
    public static final ResourceKey<BiomeModifier> ADD_SEASHELLS_UNDERWATER = registerKey("add_seashells_underwater");

    public static final ResourceKey<BiomeModifier> ADD_BUSHES = registerKey("add_bushes");
    public static final ResourceKey<BiomeModifier> ADD_FIREFLY_BUSHES = registerKey("add_firefly_bushes");
    public static final ResourceKey<BiomeModifier> ADD_FIREFLY_BUSHES_SWAMP = registerKey("add_firefly_bushes_swamp");
    public static final ResourceKey<BiomeModifier> ADD_WILDFLOWERS_MEADOW = registerKey("add_wildflowers_meadow");
    public static final ResourceKey<BiomeModifier> ADD_WILDFLOWERS_BIRCH = registerKey("add_wildflowers_birch");
    public static final ResourceKey<BiomeModifier> ADD_DRY_GRASS_BADLANDS = registerKey("add_dry_grass_badlands");
    public static final ResourceKey<BiomeModifier> ADD_DRY_GRASS_DESERT = registerKey("add_dry_grass_desert");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_OAK = registerKey("add_fallen_oak");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_BIRCH = registerKey("add_fallen_birch");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_BIRCH_RARELY = registerKey("add_fallen_birch_rarely");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_SUPER_BIRCH = registerKey("add_fallen_super_birch");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_JUNGLE = registerKey("add_fallen_jungle");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_SPRUCE = registerKey("add_fallen_spruce");
    public static final ResourceKey<BiomeModifier> ADD_FALLEN_SPRUCE_RARELY = registerKey("add_fallen_spruce_rarely");
    public static final ResourceKey<BiomeModifier> ADD_LEAF_LITTER = registerKey("add_leaf_litter");
    public static final ResourceKey<BiomeModifier> ADD_LEAF_LITTER_PATCH = registerKey("add_leaf_litter_patches");
    public static final ResourceKey<BiomeModifier> ADD_CACTUS_FLOWER = registerKey("add_cactus_flower");

    public static final ResourceKey<BiomeModifier> SPAWN_ARMADILLO_FREQUENT = registerKey("spawn_armadillo_frequent");
    public static final ResourceKey<BiomeModifier> SPAWN_ARMADILLO = registerKey("spawn_armadillo");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_TREE_PALM, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BEACH)),
                HolderSet.direct(placedFeatures.getOrThrow(CDPlacedFeatures.PALM_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEASHELLS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.BEACH)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(CDPlacedFeatures.SEASHELLS_PLACED_KEY)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_SEASHELLS_UNDERWATER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.OCEAN),
                        biomes.getOrThrow(Biomes.WARM_OCEAN),
                        biomes.getOrThrow(Biomes.LUKEWARM_OCEAN),
                        biomes.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(CDPlacedFeatures.SEASHELLS_PLACED_KEY_UNDERWATER)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_BUSHES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_BUSHES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_BUSH)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FIREFLY_BUSHES, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FIREFLY_BUSHES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FIREFLY_BUSHES_SWAMP, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FIREFLY_BUSHES_SWAMP),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_WILDFLOWERS_MEADOW, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_NOISE_BASED_WILDFLOWERS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WILDFLOWERS_MEADOW)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_WILDFLOWERS_BIRCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_WILDFLOWERS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.WILDFLOWERS_BIRCH_FOREST)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_DRY_GRASS_DESERT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_DRY_GRASS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_DRY_GRASS_DESERT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_DRY_GRASS_BADLANDS, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_DRY_GRASS_RARELY),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_DRY_GRASS_BADLANDS)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_OAK, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_OAK_TREES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_FALLEN_OAK_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_BIRCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_BIRCH_TREES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_FALLEN_BIRCH_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_BIRCH_RARELY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_BIRCH_TREES_RARELY),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_RARE_FALLEN_BIRCH_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_SUPER_BIRCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_SUPER_BIRCH_TREES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_FALLEN_SUPER_BIRCH_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_JUNGLE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_JUNGLE_TREES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_FALLEN_JUNGLE_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_SPRUCE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_SPRUCE_TREES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_FALLEN_SPRUCE_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_FALLEN_SPRUCE_RARELY, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_FALLEN_SPRUCE_TREES_RARELY),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_RARE_FALLEN_SPRUCE_TREE)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_LEAF_LITTER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_LEAF_LITTER),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.LEAF_LITTER)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_LEAF_LITTER_PATCH, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_LEAF_LITTER_PATCHES),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_LEAF_LITTER)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(ADD_CACTUS_FLOWER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.DESERT),
                        biomes.getOrThrow(Biomes.BADLANDS),
                        biomes.getOrThrow(Biomes.ERODED_BADLANDS),
                        biomes.getOrThrow(Biomes.WOODED_BADLANDS)
                ),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.CACTUS_FLOWER)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

        context.register(SPAWN_ARMADILLO_FREQUENT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_ARMADILLOS_FREQUENTLY),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.ARMADILLO.get(), 10, 2, 3))
        ));

        context.register(SPAWN_ARMADILLO, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_ARMADILLOS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.ARMADILLO.get(), 6,1, 2))
        ));
    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(HoshimiCulinaryMod.MOD_ID, name));
    }
}
