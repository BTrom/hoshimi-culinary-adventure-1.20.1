package com.botrom.hoshimi_ca_mod.worldgen;

import com.github.alexthe666.citadel.config.biome.BiomeEntryType;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;

public class DefaultBiomes {

    public static final SpawnBiomeData EMPTY = new SpawnBiomeData();

    public static final SpawnBiomeData HUMMINGBIRD = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:flower_forest", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:sunflower_plains", 1)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_jungle", 2)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:meadow", 3)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:cherry_grove", 4);

    public static final SpawnBiomeData HAMMERHEAD = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_ocean", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_hot/overworld", 0);

    public static final SpawnBiomeData LOBSTER = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_beach", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:stony_shore", 1);

    public static final SpawnBiomeData CROW = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "minecraft:is_savanna", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_plains", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 1)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_forest", 1)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 2)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_taiga", 2)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:cherry_grove", 3);

    public static final SpawnBiomeData MANTIS_SHRIMP = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_ocean", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_hot/overworld", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:mangrove_swamp", 1);

    public static final SpawnBiomeData ICE_FREE_RIVER = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_river", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "forge:is_cold/overworld", 0);

    public static final SpawnBiomeData CACHALOT_WHALE = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_ocean", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_cold/overworld", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:lukewarm_ocean", 1)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_ocean", 2)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_lukewarm_ocean", 3);

    public static final SpawnBiomeData BEACHED_CACHALOT_WHALE = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_beach", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:stony_shore", 1);

    public static final SpawnBiomeData MIMIC_OCTOPUS = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_hot/overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_ocean", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, true, "minecraft:deep_warm_ocean", 0);

    public static final SpawnBiomeData SEAGULL = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_beach", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:stony_shore", 1);

    public static final SpawnBiomeData COMB_JELLY = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:frozen_ocean", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, false, "minecraft:deep_frozen_ocean", 1);

    public static final SpawnBiomeData GIANT_SQUID = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_deep_ocean", 0);

    public static final SpawnBiomeData CATFISH = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_swamp", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, true, "minecraft:mangrove_swamp", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 1)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_river", 1)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "forge:is_cold/overworld", 1);

    public static final SpawnBiomeData LARGE_CATFISH = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "forge:is_swamp", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, true, "minecraft:mangrove_swamp", 0);

    public static final SpawnBiomeData FLYING_FISH = new SpawnBiomeData()
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, false, "minecraft:is_ocean", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "forge:is_cold/overworld", 0)
            .addBiomeEntry(BiomeEntryType.BIOME_TAG, true, "forge:is_hot/overworld", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, true, "minecraft:deep_ocean", 0)
            .addBiomeEntry(BiomeEntryType.REGISTRY_NAME, true, "minecraft:deep_lukewarm_ocean", 0);

}