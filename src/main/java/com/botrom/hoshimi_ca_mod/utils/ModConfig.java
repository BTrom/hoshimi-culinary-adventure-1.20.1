package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.worldgen.DefaultBiomes;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeConfig;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import com.google.common.collect.Lists;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ModConfig {

    // Alex
    private static boolean init = false;
    private static final Map<String, SpawnBiomeData> biomeConfigValues = new HashMap<>();
    public static int catfishSpawnWeight = 4;
    public static int catfishSpawnRolls = 2;
    public static int lobsterSpawnWeight = 7;
    public static int lobsterSpawnRolls = 0;
    public static int giantSquidSpawnWeight = 3;
    public static int giantSquidSpawnRolls = 0;
    public static int combJellySpawnWeight = 5;
    public static int combJellySpawnRolls = 1;
    public static int terrapinSpawnWeight = 4;
    public static int terrapinSpawnRolls = 0;
    public static int mimicOctopusSpawnWeight = 9;
    public static int mimicOctopusSpawnRolls = 0;
    public static int seagullSpawnWeight = 21;
    public static int seagullSpawnRolls = 0;
    public static int flySpawnRolls = 1;
    public static int hummingbirdSpawnWeight = 19;
    public static int hummingbirdSpawnRolls = 0;
    public static int hammerheadSharkSpawnWeight = 8;
    public static int hammerheadSharkSpawnRolls = 1;
    public static int crowSpawnWeight = 10;
    public static int crowSpawnRolls = 0;
    public static int mantisShrimpSpawnWeight = 15;
    public static int mantisShrimpSpawnRolls = 0;
    public static int cachalotWhaleSpawnWeight = 2;
    public static int cachalotWhaleSpawnRolls = 0;
    public static int flyingFishSpawnWeight = 8;
    public static int flyingFishSpawnRolls = 0;
    public static boolean crowsStealCrops = true;
    public static boolean seagullStealing = true;
    public static List<? extends String> seagullStealingBlacklist = Lists.newArrayList();
    public static boolean beachedCachalotWhales = true;
    public static boolean cachalotDestruction = true;
    public static double cachalotVolume = 3;
    public static int beachedCachalotWhaleSpawnChance = 5;
    public static int beachedCachalotWhaleSpawnDelay = 24000;
    public static boolean dolphinsAttackFlyingFish = true;
    public static int pathfindingThreads = 5;
    public static double rainbowGlassFidelity = 16.0F;
    public static final Pair<String, SpawnBiomeData> hummingbird = Pair.of(HoshimiCulinaryMod.MOD_ID + ":hummingbird_spawns", DefaultBiomes.HUMMINGBIRD);
    public static final Pair<String, SpawnBiomeData> hammerheadShark = Pair.of(HoshimiCulinaryMod.MOD_ID + ":hammerhead_shark_spawns", DefaultBiomes.HAMMERHEAD);
    public static final Pair<String, SpawnBiomeData> lobster = Pair.of(HoshimiCulinaryMod.MOD_ID + ":lobster_spawns", DefaultBiomes.LOBSTER);
    public static final Pair<String, SpawnBiomeData> crow = Pair.of(HoshimiCulinaryMod.MOD_ID + ":crow_spawns", DefaultBiomes. CROW);
    public static final Pair<String, SpawnBiomeData> mantisShrimp = Pair.of(HoshimiCulinaryMod.MOD_ID + ":mantis_shrimp_spawns", DefaultBiomes.MANTIS_SHRIMP);
    public static final Pair<String, SpawnBiomeData> cachalot_whale_spawns = Pair.of(HoshimiCulinaryMod.MOD_ID + ":cachalot_whale_spawns", DefaultBiomes.CACHALOT_WHALE);
    public static final Pair<String, SpawnBiomeData> cachalot_whale_beached_spawns = Pair.of(HoshimiCulinaryMod.MOD_ID + ":cachalot_whale_beached_spawns", DefaultBiomes.BEACHED_CACHALOT_WHALE);
    public static final Pair<String, SpawnBiomeData> mimic_octopus = Pair.of(HoshimiCulinaryMod.MOD_ID + ":mimic_octopus_spawns", DefaultBiomes.MIMIC_OCTOPUS);
    public static final Pair<String, SpawnBiomeData> seagull = Pair.of(HoshimiCulinaryMod.MOD_ID + ":seagull_spawns", DefaultBiomes.SEAGULL);
    public static final Pair<String, SpawnBiomeData> terrapin = Pair.of(HoshimiCulinaryMod.MOD_ID + ":terrapin_spawns", DefaultBiomes.ICE_FREE_RIVER);
    public static final Pair<String, SpawnBiomeData> comb_jelly = Pair.of(HoshimiCulinaryMod.MOD_ID + ":comb_jelly_spawns", DefaultBiomes.COMB_JELLY);
    public static final Pair<String, SpawnBiomeData> giant_squid = Pair.of(HoshimiCulinaryMod.MOD_ID + ":giant_squid_spawns", DefaultBiomes.GIANT_SQUID);
    public static final Pair<String, SpawnBiomeData> catfish = Pair.of(HoshimiCulinaryMod.MOD_ID + ":catfish_spawns", DefaultBiomes.CATFISH);
    public static final Pair<String, SpawnBiomeData> flying_fish = Pair.of(HoshimiCulinaryMod.MOD_ID + ":flying_fish_spawns", DefaultBiomes.FLYING_FISH);
    // Crockpot
    public static double crockPotSpeedModifier = 0.15F;
    public static boolean showFoodValuesTooltip = true;
    public static boolean showFoodEffectsTooltip = true;
    public static boolean gnawsGiftHungerOverlay = true;
    // Salt
    public static double dissolvingChance;
    public static boolean dissolvingInRain;
    public static double dissolvingInRainChance;
    public static double meltingBlockChance;
    public static double evaporationChance;
    public static double saltClusterGrowingChance;
    public static int rockSaltSize;
    public static double rockSaltClusterChance;
    // Vanilla
    public static boolean hasArmadillos;
    public static boolean hasResin;
    public static boolean hasPaleGarden;
    public static boolean hasPaleTrades;
    public static int creakingParticleColor;
    public static int creakingParticleReverseColor;
    public static boolean hasBushes;
    public static boolean hasFireflyBushes;
    public static boolean hasWildflowers;
    public static boolean hasDryGrass;
    public static boolean hasFallenTrees;
    public static boolean hasLeafLitter;
    public static boolean hasCactusFlowers;
    public static boolean hasFarmAnimalVariants;
    public static boolean hasWolfSoundVariants;
    public static boolean hasSpringTrades;
    public static boolean hasDriedGhasts;
    public static boolean leashDropConnections;
    public static boolean hasTearsMusicDisc;
    public static double happyGhastSpeedModifier;
    public static boolean hasUpdatedBatModel;
    public static boolean golemPressesButtons;
    public static int buttonPressChancePercent;
    public static int golemTransportStackSize;
    public static int weatheringTickFrom;
    public static int weatheringTickTo;
    public static boolean endFlashEnabled;
    // Gaia
    public static boolean spawnDaysPassed;
    public static int spawnDaysSet;
    // Naturalist
//    public static boolean bluejayRemoved = false;
//    public static int bluejaySpawnWeight = 10;
//    public static int bluejaySpawnMinGroupSize = 3;
//    public static int bluejaySpawnMaxGroupSize = 4;
    public static boolean butterflyRemoved;
    public static int butterflySpawnWeight;
    public static int butterflySpawnMinGroupSize;
    public static int butterflySpawnMaxGroupSize;
//    public static boolean canaryRemoved = false;
//    public static int canarySpawnWeight = 10;
//    public static int canarySpawnMinGroupSize = 3;
//    public static int canarySpawnMaxGroupSize = 4;
    public static boolean cardinalRemoved;
    public static int cardinalSpawnWeight;
    public static int cardinalSpawnMinGroupSize;
    public static int cardinalSpawnMaxGroupSize;
    public static boolean lizardRemoved;
    public static int lizardSpawnWeight;
    public static int lizardSpawnMinGroupSize;
    public static int lizardSpawnMaxGroupSize;
//    public static boolean robinRemoved = false;
//    public static int robinSpawnWeight = 10;
//    public static int robinSpawnMinGroupSize = 3;
//    public static int robinSpawnMaxGroupSize = 4;
    public static boolean snailRemoved;
    public static int snailSpawnWeight;
    public static int snailSpawnMinGroupSize;
    public static int snailSpawnMaxGroupSize;
    public static boolean sparrowRemoved;
    public static int sparrowSpawnWeight;
    public static int sparrowSpawnMinGroupSize;
    public static int sparrowSpawnMaxGroupSize;
    public static boolean tortoiseRemoved;
    public static int tortoiseSpawnWeight;
    public static int tortoiseSpawnMinGroupSize;
    public static int tortoiseSpawnMaxGroupSize;


    public static void bake(net.minecraftforge.fml.config.ModConfig config) {
        try {
            catfishSpawnWeight = ConfigHolder.COMMON.catfishSpawnWeight.get();
            catfishSpawnRolls = ConfigHolder.COMMON.catfishSpawnRolls.get();
            lobsterSpawnWeight = ConfigHolder.COMMON.lobsterSpawnWeight.get();
            lobsterSpawnRolls = ConfigHolder.COMMON.lobsterSpawnRolls.get();
            giantSquidSpawnWeight = ConfigHolder.COMMON.giantSquidSpawnWeight.get();
            giantSquidSpawnRolls = ConfigHolder.COMMON.giantSquidSpawnRolls.get();
            terrapinSpawnWeight = ConfigHolder.COMMON.terrapinSpawnWeight.get();
            terrapinSpawnRolls = ConfigHolder.COMMON.terrapinSpawnRolls.get();
            combJellySpawnWeight = ConfigHolder.COMMON.combJellySpawnWeight.get();
            combJellySpawnRolls = ConfigHolder.COMMON.combJellySpawnRolls.get();
            mimicOctopusSpawnWeight = ConfigHolder.COMMON.mimicOctopusSpawnWeight.get();
            mimicOctopusSpawnRolls = ConfigHolder.COMMON.mimicOctopusSpawnRolls.get();
            seagullSpawnWeight = ConfigHolder.COMMON.seagullSpawnWeight.get();
            seagullSpawnRolls = ConfigHolder.COMMON.seagullSpawnRolls.get();
            hummingbirdSpawnWeight = ConfigHolder.COMMON.hummingbirdSpawnWeight.get();
            hummingbirdSpawnRolls = ConfigHolder.COMMON.hummingbirdSpawnRolls.get();
            hammerheadSharkSpawnWeight = ConfigHolder.COMMON.hammerheadSharkSpawnWeight.get();
            hammerheadSharkSpawnRolls = ConfigHolder.COMMON.hammerheadSharkSpawnRolls.get();
            crowSpawnWeight = ConfigHolder.COMMON.crowSpawnWeight.get();
            crowSpawnRolls = ConfigHolder.COMMON.crowSpawnRolls.get();
            mantisShrimpSpawnWeight = ConfigHolder.COMMON.mantisShrimpSpawnWeight.get();
            mantisShrimpSpawnRolls = ConfigHolder.COMMON.mantisShrimpSpawnRolls.get();
            cachalotWhaleSpawnWeight = ConfigHolder.COMMON.cachalotWhaleSpawnWeight.get();
            cachalotWhaleSpawnRolls = ConfigHolder.COMMON.cachalotWhaleSpawnRolls.get();
            flyingFishSpawnWeight = ConfigHolder.COMMON.flyingFishSpawnWeight.get();
            flyingFishSpawnRolls = ConfigHolder.COMMON.flyingFishSpawnRolls.get();
            crowsStealCrops = ConfigHolder.COMMON.crowsStealCrops.get();
            seagullStealing = ConfigHolder.COMMON.seagullStealing.get();
            seagullStealingBlacklist = (List<? extends String>) ConfigHolder.COMMON.seagullStealingBlacklist.get();
            beachedCachalotWhales = ConfigHolder.COMMON.beachedCachalotWhales.get();
            cachalotDestruction = ConfigHolder.COMMON.cachalotDestruction.get();
            cachalotVolume = ConfigHolder.COMMON.cachalotVolume.get();
            beachedCachalotWhaleSpawnChance = ConfigHolder.COMMON.beachedCachalotWhaleSpawnChance.get();
            beachedCachalotWhaleSpawnDelay = ConfigHolder.COMMON.beachedCachalotWhaleSpawnDelay.get();
            dolphinsAttackFlyingFish = ConfigHolder.COMMON.dolphinsAttackFlyingFish.get();
            pathfindingThreads = ConfigHolder.COMMON.pathfindingThreads.get();
            rainbowGlassFidelity = ConfigHolder.COMMON.rainbowGlassFidelity.get();

            crockPotSpeedModifier = ConfigHolder.COMMON.crockPotSpeedModifier.get();
            showFoodValuesTooltip = ConfigHolder.CLIENT.showFoodValuesTooltip.get();
            showFoodEffectsTooltip = ConfigHolder.CLIENT.showFoodEffectsTooltip.get();
            gnawsGiftHungerOverlay = ConfigHolder.CLIENT.gnawsGiftHungerOverlay.get();

            dissolvingChance = ConfigHolder.COMMON.dissolvingChance.get();
            dissolvingInRain = ConfigHolder.COMMON.dissolvingInRain.get();
            dissolvingInRainChance = ConfigHolder.COMMON.dissolvingInRainChance.get();
            meltingBlockChance = ConfigHolder.COMMON.meltingBlockChance.get();
            evaporationChance = ConfigHolder.COMMON.evaporationChance.get();
            saltClusterGrowingChance = ConfigHolder.COMMON.saltClusterGrowingChance.get();
            rockSaltSize = ConfigHolder.COMMON.rockSaltSize.get();
            rockSaltClusterChance = ConfigHolder.COMMON.rockSaltClusterChance.get();

            hasArmadillos = ConfigHolder.COMMON.hasArmadillos.get();
            hasResin = ConfigHolder.COMMON.hasResin.get();
            hasPaleGarden = ConfigHolder.COMMON.hasPaleGarden.get();
            hasPaleTrades = ConfigHolder.COMMON.hasPaleTrades.get();
            creakingParticleColor = ConfigHolder.COMMON.creakingParticleColor.get();
            creakingParticleReverseColor = ConfigHolder.COMMON.creakingParticleReverseColor.get();
            hasBushes = ConfigHolder.COMMON.hasBushes.get();
            hasFireflyBushes = ConfigHolder.COMMON.hasFireflyBushes.get();
            hasWildflowers = ConfigHolder.COMMON.hasWildflowers.get();
            hasDryGrass = ConfigHolder.COMMON.hasDryGrass.get();
            hasFallenTrees = ConfigHolder.COMMON.hasFallenTrees.get();
            hasLeafLitter = ConfigHolder.COMMON.hasLeafLitter.get();
            hasCactusFlowers = ConfigHolder.COMMON.hasCactusFlowers.get();
            hasFarmAnimalVariants = ConfigHolder.COMMON.hasFarmAnimalVariants.get();
            hasWolfSoundVariants = ConfigHolder.COMMON.hasWolfSoundVariants.get();
            hasSpringTrades = ConfigHolder.COMMON.hasSpringTrades.get();
            hasDriedGhasts = ConfigHolder.COMMON.hasDriedGhasts.get();
            leashDropConnections = ConfigHolder.COMMON.leashDropConnections.get();
            hasTearsMusicDisc = ConfigHolder.COMMON.hasTearsMusicDisc.get();
            happyGhastSpeedModifier = ConfigHolder.COMMON.happyGhastSpeedModifier.get();
            hasUpdatedBatModel = ConfigHolder.CLIENT.hasUpdatedBatModel.get();
            golemPressesButtons = ConfigHolder.COMMON.golemPressesButtons.get();
            buttonPressChancePercent = ConfigHolder.COMMON.buttonPressChancePercent.get();
            golemTransportStackSize = ConfigHolder.COMMON.golemTransportStackSize.get();
            weatheringTickFrom = ConfigHolder.COMMON.weatheringTickFrom.get();
            weatheringTickTo = ConfigHolder.COMMON.weatheringTickTo.get();
            endFlashEnabled = ConfigHolder.COMMON.endFlashEnabled.get();
            spawnDaysPassed = ConfigHolder.COMMON.spawnDaysPassed.get();
            spawnDaysSet = ConfigHolder.COMMON.spawnDaysSet.get();

            butterflyRemoved = ConfigHolder.COMMON.butterflyRemoved.get();
            butterflySpawnWeight = ConfigHolder.COMMON.butterflySpawnWeight.get();
            butterflySpawnMinGroupSize = ConfigHolder.COMMON.butterflySpawnMinGroupSize.get();
            butterflySpawnMaxGroupSize = ConfigHolder.COMMON.butterflySpawnMaxGroupSize.get();
            cardinalRemoved = ConfigHolder.COMMON.cardinalRemoved.get();
            cardinalSpawnWeight = ConfigHolder.COMMON.cardinalSpawnWeight.get();
            cardinalSpawnMinGroupSize = ConfigHolder.COMMON.cardinalSpawnMinGroupSize.get();
            cardinalSpawnMaxGroupSize = ConfigHolder.COMMON.cardinalSpawnMaxGroupSize.get();
            lizardRemoved = ConfigHolder.COMMON.lizardRemoved.get();
            lizardSpawnWeight = ConfigHolder.COMMON.lizardSpawnWeight.get();
            lizardSpawnMinGroupSize = ConfigHolder.COMMON.lizardSpawnMinGroupSize.get();
            lizardSpawnMaxGroupSize = ConfigHolder.COMMON.lizardSpawnMaxGroupSize.get();
            snailRemoved = ConfigHolder.COMMON.snailRemoved.get();
            snailSpawnWeight = ConfigHolder.COMMON.snailSpawnWeight.get();
            snailSpawnMinGroupSize = ConfigHolder.COMMON.snailSpawnMinGroupSize.get();
            snailSpawnMaxGroupSize = ConfigHolder.COMMON.snailSpawnMaxGroupSize.get();
            sparrowRemoved = ConfigHolder.COMMON.sparrowRemoved.get();
            sparrowSpawnWeight = ConfigHolder.COMMON.sparrowSpawnWeight.get();
            sparrowSpawnMinGroupSize = ConfigHolder.COMMON.sparrowSpawnMinGroupSize.get();
            sparrowSpawnMaxGroupSize = ConfigHolder.COMMON.sparrowSpawnMaxGroupSize.get();
            tortoiseRemoved = ConfigHolder.COMMON.tortoiseRemoved.get();
            tortoiseSpawnWeight = ConfigHolder.COMMON.tortoiseSpawnWeight.get();
            tortoiseSpawnMinGroupSize = ConfigHolder.COMMON.tortoiseSpawnMinGroupSize.get();
            tortoiseSpawnMaxGroupSize = ConfigHolder.COMMON.tortoiseSpawnMaxGroupSize.get();

        } catch (Exception e) {
            HoshimiCulinaryMod.loggerWarn("An exception was caused trying to load the config for Alex's Mobs side of Hoshimi's Mod.");
            e.printStackTrace();
        }
    }

    public static void init() {
        try {
            for (Field f : ModConfig.class.getDeclaredFields()) {
                Object obj = f.get(null);
                if(obj instanceof Pair){
                    String id = (String)((Pair) obj).getLeft();
                    SpawnBiomeData data = (SpawnBiomeData)((Pair) obj).getRight();
                    biomeConfigValues.put(id, SpawnBiomeConfig.create(new ResourceLocation(id), data));
                }
            }
        }catch (Exception e){
            HoshimiCulinaryMod.LOGGER.warn("Encountered error building alexsmobs biome config .json files");
            e.printStackTrace();
        }
        init = true;
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome, ResourceLocation name){
        if(!init){
            return false;
        }
        return biomeConfigValues.get(entry.getKey()).matches(biome, name);
    }
}
