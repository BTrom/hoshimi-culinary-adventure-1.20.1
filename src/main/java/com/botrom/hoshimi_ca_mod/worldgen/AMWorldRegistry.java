package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.compat.AMBiomeConfig;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderSet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.structure.BuiltinStructures;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import net.minecraftforge.common.world.ModifiableStructureInfo;
import net.minecraftforge.fml.common.Mod;
import org.apache.commons.lang3.tuple.Pair;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class AMWorldRegistry {

    private static ResourceLocation getBiomeName(Holder<Biome> biome) {
        return biome.unwrap().map((resourceKey) -> resourceKey.location(), (noKey) -> null);
    }

    public static boolean testBiome(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome) {
        boolean result = false;
        try {
            result = AMBiomeConfig.test(entry, biome, getBiomeName(biome));
        } catch (Exception e) {
            HoshimiCulinaryMod.loggerWarn("could not test biome config for " + entry.getLeft() + ", defaulting to no spawns for mob");
            result = false;
        }
        return result;
    }

    public static void addBiomeSpawns(Holder<Biome> biome, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (testBiome(AMBiomeConfig.lobster, biome) && ModConfig.lobsterSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(ModEntities.LOBSTER.get(), ModConfig.lobsterSpawnWeight, 3, 5));
        }
        if (testBiome(AMBiomeConfig.mimic_octopus, biome) && ModConfig.mimicOctopusSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(ModEntities.MIMIC_OCTOPUS.get(), ModConfig.mimicOctopusSpawnWeight, 1, 2));
        }
        if (testBiome(AMBiomeConfig.seagull, biome) && ModConfig.seagullSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.CREATURE).add(new MobSpawnSettings.SpawnerData(ModEntities.SEAGULL.get(), ModConfig.seagullSpawnWeight, 3, 6));
        }
        if (testBiome(AMBiomeConfig.comb_jelly, biome) && ModConfig.combJellySpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(ModEntities.COMB_JELLY.get(), ModConfig.combJellySpawnWeight, 2, 3));
        }
        if (testBiome(AMBiomeConfig.giant_squid, biome) && ModConfig.giantSquidSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.WATER_CREATURE).add(new MobSpawnSettings.SpawnerData(ModEntities.GIANT_SQUID.get(), ModConfig.giantSquidSpawnWeight, 1, 2));
        }
        if (testBiome(AMBiomeConfig.catfish, biome) && ModConfig.catfishSpawnWeight > 0) {
            builder.getMobSpawnSettings().getSpawner(MobCategory.WATER_AMBIENT).add(new MobSpawnSettings.SpawnerData(ModEntities.CATFISH.get(), ModConfig.catfishSpawnWeight, 1, 3));
        }
    }
}
