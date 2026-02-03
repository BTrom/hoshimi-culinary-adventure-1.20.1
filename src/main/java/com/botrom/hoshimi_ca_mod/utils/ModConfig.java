package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.google.common.collect.Lists;

import java.util.List;

public class ModConfig {

    // Alex
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
        } catch (Exception e) {
            HoshimiCulinaryMod.loggerWarn("An exception was caused trying to load the config for Alex's Mobs side of Hoshimi's Mod.");
            e.printStackTrace();
        }
    }
}
