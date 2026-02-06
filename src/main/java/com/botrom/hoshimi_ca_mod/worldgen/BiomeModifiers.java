package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.registry.ModPlacedFeatures;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.mojang.serialization.Codec;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class BiomeModifiers {
    public static DeferredRegister<Codec<? extends BiomeModifier>> NAT_BIOME_MODIFIER_SERIALIZER = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, HoshimiCulinaryMod.MOD_ID);
    public static RegistryObject<Codec<NaturalistAddAnimalsBiomeModifier>> ADD_ANIMALS_CODEC = NAT_BIOME_MODIFIER_SERIALIZER.register("add_animals",() -> Codec.unit(NaturalistAddAnimalsBiomeModifier::new));
    public static final DeferredRegister<Codec<? extends BiomeModifier>> AM_BIOME_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, HoshimiCulinaryMod.MOD_ID);


    public static final ResourceKey<BiomeModifier> ADD_DRAGON_FRUIT = registerKey("patch_dragon_fruit");
    public static final ResourceKey<BiomeModifier> ADD_TREE_PALM = registerKey("add_tree_palm");
    public static final ResourceKey<BiomeModifier> ADD_SEASHELLS = registerKey("add_seashells");
    public static final ResourceKey<BiomeModifier> ADD_SEASHELLS_UNDERWATER = registerKey("add_seashells_underwater");
    public static final ResourceKey<BiomeModifier> ADD_SEA_ANEMONE = registerKey("add_sea_anemone");
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

    public static final ResourceKey<BiomeModifier> SPAWN_CHIEFTAIN_CRAB = registerKey("spawn_chieftain_crab");
    public static final ResourceKey<BiomeModifier> SPAWN_CLAM = registerKey("spawn_clam");
    public static final ResourceKey<BiomeModifier> SPAWN_PLATINUM_BASS = registerKey("spawn_platinum_bass");
    public static final ResourceKey<BiomeModifier> SPAWN_TIGER_PRAWN = registerKey("spawn_tiger_prawn");
    public static final ResourceKey<BiomeModifier> SPAWN_URCHIN = registerKey("spawn_urchin");
    public static final ResourceKey<BiomeModifier> SPAWN_FIDDLER_CRAB = registerKey("spawn_fiddler_crab");
    public static final ResourceKey<BiomeModifier> SPAWN_DUMBO_OCTOPUS = registerKey("spawn_dumbo_octopus");
    public static final ResourceKey<BiomeModifier> SPAWN_DUMBO_OCTOPUS_RARE = registerKey("spawn_dumbo_octopus_rare");
    public static final ResourceKey<BiomeModifier> SPAWN_KOI_FISH = registerKey("spawn_koi_fish");
    public static final ResourceKey<BiomeModifier> SPAWN_SHIMA_ENAGA = registerKey("spawn_shima_enaga");
    public static final ResourceKey<BiomeModifier> SPAWN_SHIBA = registerKey("spawn_shiba");
    public static final ResourceKey<BiomeModifier> SPAWN_MUD_CRAB = registerKey("spawn_mud_crab");
    public static final ResourceKey<BiomeModifier> SPAWN_KING_CRAB = registerKey("spawn_king_crab");
    public static final ResourceKey<BiomeModifier> SPAWN_SAND_CRAB = registerKey("spawn_sand_crab");
    public static final ResourceKey<BiomeModifier> SPAWN_CRAYFISH = registerKey("spawn_crayfish");
    public static final ResourceKey<BiomeModifier> SPAWN_WHALE = registerKey("spawn_whale");
    public static final ResourceKey<BiomeModifier> SPAWN_ARMADILLO = registerKey("spawn_armadillo");
    public static final ResourceKey<BiomeModifier> SPAWN_ARMADILLO_FREQUENT = registerKey("spawn_armadillo_frequent");
    public static final ResourceKey<BiomeModifier> SPAWN_NAUTILUS = registerKey("spawn_nautilus");
    public static final ResourceKey<BiomeModifier> SPAWN_SINGLE_NAUTILUS = registerKey("spawn_single_nautilus");
    public static final ResourceKey<BiomeModifier> SPAWN_SUCCUBUS = registerKey("spawn_succubus");


    public static void bootstrap(BootstapContext<BiomeModifier> context) {
        var placedFeatures = context.lookup(Registries.PLACED_FEATURE);
        var biomes = context.lookup(Registries.BIOME);

        context.register(ADD_DRAGON_FRUIT, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(ModTags.DRAGON_FRUIT_SPAWNS),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PATCH_DRAGON_FRUIT)),
                GenerationStep.Decoration.VEGETAL_DECORATION));

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

        context.register(ADD_SEA_ANEMONE, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),
                HolderSet.direct(placedFeatures.getOrThrow(ModPlacedFeatures.PLACED_SEA_ANEMONE)),
                GenerationStep.Decoration.VEGETAL_DECORATION
        ));


        // ENTITIES

        context.register(SPAWN_CHIEFTAIN_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.CHIEFTAIN_CRAB_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CHIEFTAIN_CRAB.get(), 5, 1, 3))
        ));

        context.register(SPAWN_CLAM, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.CLAM_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CLAM.get(), 1, 1, 1))
        ));

        context.register(SPAWN_PLATINUM_BASS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.PLATINUM_BASS_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.PLATINUM_BASS.get(), 1, 1, 2))
        ));

        context.register(SPAWN_TIGER_PRAWN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.TIGER_PRAWN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.TIGER_PRAWN.get(), 2, 1, 2))
        ));

        context.register(SPAWN_URCHIN, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.URCHIN_SPAWNS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.URCHIN.get(), 1, 1, 2))
        ));

        context.register(SPAWN_FIDDLER_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP),
                        biomes.getOrThrow(Biomes.SWAMP),
                        biomes.getOrThrow(Biomes.BEACH),
                        biomes.getOrThrow(Biomes.STONY_SHORE),
                        biomes.getOrThrow(Biomes.SNOWY_BEACH)
                ),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.FIDDLER_CRAB.get(), 5, 2, 5))
        ));

        context.register(SPAWN_DUMBO_OCTOPUS_RARE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_DUMBO_OCTOPUS_RARELY),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.DUMBO_OCTOPUS.get(), 4, 1, 1))
        ));

        context.register(SPAWN_DUMBO_OCTOPUS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.WARM_OCEAN),
                        biomes.getOrThrow(Biomes.LUKEWARM_OCEAN),
                        biomes.getOrThrow(Biomes.DEEP_LUKEWARM_OCEAN)
                ),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.DUMBO_OCTOPUS.get(), 8, 1, 1))
        ));

        context.register(SPAWN_KOI_FISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_RIVER),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.KOI_FISH.get(), 4, 2, 5))
        ));

        context.register(SPAWN_SHIMA_ENAGA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.SNOWY_PLAINS)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SHIMA_ENAGA.get(), 3, 2, 3))
        ));

        context.register(SPAWN_SHIBA, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_MOUNTAIN),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SHIBA.get(), 40, 1, 3))
        ));

        context.register(SPAWN_MUD_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.MANGROVE_SWAMP),
                        biomes.getOrThrow(Biomes.SWAMP)
                ),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.GIANT_MUD_CRAB.get(), 10, 2, 3))
        ));

        context.register(SPAWN_KING_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(
                        biomes.getOrThrow(Biomes.COLD_OCEAN),
                        biomes.getOrThrow(Biomes.DEEP_COLD_OCEAN)
                ), List.of(new MobSpawnSettings.SpawnerData(ModEntities.KING_CRAB.get(), 6, 2, 3))
        ));

        context.register(SPAWN_SAND_CRAB, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.BEACH)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SAND_CRAB.get(), 10, 2, 4))
        ));

        context.register(SPAWN_CRAYFISH, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.RIVER)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.CRAYFISH.get(), 6, 2, 3))
        ));

        context.register(SPAWN_SINGLE_NAUTILUS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                HolderSet.direct(biomes.getOrThrow(Biomes.FROZEN_OCEAN)),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.NAUTILUS.get(), 8, 1, 1))
        ));

        context.register(SPAWN_NAUTILUS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_NAUTILUS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.NAUTILUS.get(), 8, 1, 3))
        ));

        context.register(SPAWN_ARMADILLO_FREQUENT, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_ARMADILLOS_FREQUENTLY),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.ARMADILLO.get(), 10, 2, 3))
        ));

        context.register(SPAWN_ARMADILLO, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(ModTags.SPAWNS_ARMADILLOS),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.ARMADILLO.get(), 6,1, 2))
        ));

        context.register(SPAWN_SUCCUBUS, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_NETHER),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.SUCCUBUS.get(), 16,4, 2))
        ));

        context.register(SPAWN_WHALE, new ForgeBiomeModifiers.AddSpawnsBiomeModifier(
                biomes.getOrThrow(BiomeTags.IS_OCEAN),
                List.of(new MobSpawnSettings.SpawnerData(ModEntities.BALEEN_WHALE.get(), 1,1, 2))
        ));


    }

    private static ResourceKey<BiomeModifier> registerKey(String name) {
        return ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, new ResourceLocation(HoshimiCulinaryMod.MOD_ID, name));
    }
}
