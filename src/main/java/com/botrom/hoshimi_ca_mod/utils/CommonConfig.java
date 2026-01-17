package com.botrom.hoshimi_ca_mod.utils;

import com.google.common.collect.Lists;
import net.minecraftforge.common.ForgeConfigSpec;

import java.util.List;

public class CommonConfig {
    
    public final ForgeConfigSpec.IntValue catfishSpawnWeight;
    public final ForgeConfigSpec.IntValue catfishSpawnRolls;
    public final ForgeConfigSpec.IntValue lobsterSpawnWeight;
    public final ForgeConfigSpec.IntValue lobsterSpawnRolls;
    public final ForgeConfigSpec.IntValue giantSquidSpawnWeight;
    public final ForgeConfigSpec.IntValue giantSquidSpawnRolls;
    public final ForgeConfigSpec.IntValue terrapinSpawnRolls;
    public final ForgeConfigSpec.IntValue terrapinSpawnWeight;
    public final ForgeConfigSpec.IntValue combJellySpawnRolls;
    public final ForgeConfigSpec.IntValue combJellySpawnWeight;
    public final ForgeConfigSpec.IntValue mimicOctopusSpawnWeight;
    public final ForgeConfigSpec.IntValue mimicOctopusSpawnRolls;
    public final ForgeConfigSpec.IntValue seagullSpawnWeight;
    public final ForgeConfigSpec.IntValue seagullSpawnRolls;
    public final ForgeConfigSpec.IntValue hummingbirdSpawnWeight;
    public final ForgeConfigSpec.IntValue hummingbirdSpawnRolls;
    public final ForgeConfigSpec.IntValue hammerheadSharkSpawnWeight;
    public final ForgeConfigSpec.IntValue hammerheadSharkSpawnRolls;
    public final ForgeConfigSpec.IntValue crowSpawnWeight;
    public final ForgeConfigSpec.IntValue crowSpawnRolls;
    public final ForgeConfigSpec.IntValue mantisShrimpSpawnWeight;
    public final ForgeConfigSpec.IntValue mantisShrimpSpawnRolls;
    public final ForgeConfigSpec.IntValue cachalotWhaleSpawnWeight;
    public final ForgeConfigSpec.IntValue cachalotWhaleSpawnRolls;
    public final ForgeConfigSpec.IntValue flyingFishSpawnWeight;
    public final ForgeConfigSpec.IntValue flyingFishSpawnRolls;
    public final ForgeConfigSpec.BooleanValue crowsStealCrops;
    public final ForgeConfigSpec.BooleanValue seagullStealing;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> seagullStealingBlacklist;
    public ForgeConfigSpec.IntValue pathfindingThreads;
    public final ForgeConfigSpec.BooleanValue beachedCachalotWhales;
    public final ForgeConfigSpec.BooleanValue cachalotDestruction;
    public final ForgeConfigSpec.DoubleValue cachalotVolume;
    public final ForgeConfigSpec.IntValue beachedCachalotWhaleSpawnChance;
    public final ForgeConfigSpec.IntValue beachedCachalotWhaleSpawnDelay;
    public final ForgeConfigSpec.BooleanValue dolphinsAttackFlyingFish;
    public final ForgeConfigSpec.DoubleValue rainbowGlassFidelity;
    public final ForgeConfigSpec.DoubleValue crockPotSpeedModifier;

    public CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.comment("General settings").push("general");
        crowsStealCrops = buildBoolean(builder,
                "crowsStealCrops", "all", true,
                "Whether wild crows steal crops from farmland.");
        seagullStealing = buildBoolean(builder,
                "seagullStealing", "all", ModConfig.seagullStealing,
                "Whether seagulls should steal food out of players' hotbar slots.");
        seagullStealingBlacklist = builder.comment("List of items that seagulls cannot take from players.").defineList("seagullStealingBlacklist", Lists.newArrayList(), o -> o instanceof String);
        rainbowGlassFidelity = buildDouble(builder,
                "rainbowGlassFidelity", "all", ModConfig.rainbowGlassFidelity, 1.0F, 10000.0F,
                "The visual zoom of the rainbow pattern on the rainbow glass block. Higher number = bigger pattern.");
        cachalotDestruction = buildBoolean(builder,
                "cachalotDestruction", "all", true,
                "Whether cachalots can destroy wood blocks if angry.");
        cachalotVolume = buildDouble(builder,
                "cachalotVolume", "all", 3D, 0D, 10D,
                "Relative volume of cachalot whales compared to other animals. Note that irl they are the loudest animal. Turn this down if you find their clicks annoying.");
        beachedCachalotWhales = buildBoolean(builder,
                "beachedCachalotWhales", "uniqueSpawning", true,
                "Whether to enable beached cachalot whales to spawn on beaches during thunder storms.");
        beachedCachalotWhaleSpawnChance = buildInt(builder,
                "beachedCachalotWhaleSpawnChance", "uniqueSpawning", ModConfig.beachedCachalotWhaleSpawnChance, 0, 100,
                "Percent chance increase for each failed attempt to spawn a beached cachalot whale. Higher value = more spawns.");
        beachedCachalotWhaleSpawnDelay = buildInt(builder,
                "beachedCachalotWhaleSpawnDelay", "uniqueSpawning", ModConfig.beachedCachalotWhaleSpawnDelay, 0, Integer.MAX_VALUE,
                "Delay (in ticks) between attempts to spawn beached cachalot whales. Default is a single day. Works like wandering traders.");
        dolphinsAttackFlyingFish = buildBoolean(builder,
                "dolphinsAttackFlyingFish", "all", true,
                "Whether dolphins should target flying fish mobs.");
        crockPotSpeedModifier = buildDouble(builder,
                "crockPotSpeedModifier", "all", ModConfig.crockPotSpeedModifier, 0.0F, 1.0F,
                "Set this value to change Crock Pot speed modifier. Higher tier Crock Pot will cook faster.\nactualCookingTime = cookingTime * (1.0 - crockPotSpeedModifier * potLevel)");
        builder.pop();
        builder.comment("Spawning settings").push("spawning");
        catfishSpawnWeight = buildInt(builder,
                "catfishSpawnWeight", "spawns", ModConfig.catfishSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        catfishSpawnRolls = buildInt(builder,
                "catfishSpawnRolls", "spawns", ModConfig.catfishSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        lobsterSpawnWeight = buildInt(builder,
                "lobsterSpawnWeight", "spawns", ModConfig.lobsterSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        lobsterSpawnRolls = buildInt(builder,
                "lobsterSpawnRolls", "spawns", ModConfig.lobsterSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        giantSquidSpawnWeight = buildInt(builder,
                "giantSquidSpawnWeight", "spawns", ModConfig.giantSquidSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        giantSquidSpawnRolls = buildInt(builder,
                "giantSquidSpawnRolls", "spawns", ModConfig.giantSquidSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        terrapinSpawnWeight = buildInt(builder,
                "terrapinSpawnWeight", "spawns", ModConfig.terrapinSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        terrapinSpawnRolls = buildInt(builder,
                "terrapinSpawnRolls", "spawns", ModConfig.terrapinSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        combJellySpawnWeight = buildInt(builder,
                "combJellySpawnWeight", "spawns", ModConfig.combJellySpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        combJellySpawnRolls = buildInt(builder,
                "combJellySpawnRolls", "spawns", ModConfig.combJellySpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        mimicOctopusSpawnWeight = buildInt(builder,
                "mimicOctopusSpawnWeight", "spawns", ModConfig.mimicOctopusSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        mimicOctopusSpawnRolls = buildInt(builder,
                "mimicOctopusSpawnRolls", "spawns", ModConfig.mimicOctopusSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        seagullSpawnWeight = buildInt(builder,
                "seagullSpawnWeight", "spawns", ModConfig.seagullSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        seagullSpawnRolls = buildInt(builder,
                "seagullSpawnRolls", "spawns", ModConfig.seagullSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        hummingbirdSpawnWeight = buildInt(builder,
                "hummingbirdSpawnWeight", "spawns", ModConfig.hummingbirdSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        hummingbirdSpawnRolls = buildInt(builder,
                "hummingbirdSpawnRolls", "spawns", ModConfig.flySpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        hammerheadSharkSpawnWeight = buildInt(builder,
                "hammerheadSharkSpawnWeight", "spawns", ModConfig.hammerheadSharkSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        hammerheadSharkSpawnRolls = buildInt(builder,
                "hammerheadSharkSpawnRolls", "spawns", ModConfig.hammerheadSharkSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        crowSpawnWeight = buildInt(builder,
                "crowSpawnWeight", "spawns", ModConfig.crowSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        crowSpawnRolls = buildInt(builder,
                "crowSpawnRolls", "spawns", ModConfig.crowSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        mantisShrimpSpawnWeight = buildInt(builder,
                "mantisShrimpSpawnWeight", "spawns", ModConfig.mantisShrimpSpawnWeight, 0,
                1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        mantisShrimpSpawnRolls = buildInt(builder,
                "mantisShrimpSpawnRolls", "spawns", ModConfig.mantisShrimpSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        cachalotWhaleSpawnWeight = buildInt(builder,
                "cachalotWhaleSpawnWeight", "spawns", ModConfig.cachalotWhaleSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        cachalotWhaleSpawnRolls = buildInt(builder,
                "cachalotWhaleSpawnRolls", "spawns", ModConfig.cachalotWhaleSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        flyingFishSpawnWeight = buildInt(builder,
                "flyingFishSpawnWeight", "spawns", ModConfig.flyingFishSpawnWeight, 0, 1000,
                "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        flyingFishSpawnRolls = buildInt(builder,
                "flyingFishSpawnRolls", "spawns", ModConfig.flyingFishSpawnRolls, 0, Integer.MAX_VALUE,
                "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        builder.pop();
        builder.comment("Danger Zone").push("dangerZone");
        pathfindingThreads = buildInt(builder,
                "pathfindingThreads", "dangerZone", ModConfig.pathfindingThreads, 1, 100,
                "How many cpu cores some mobs(elephants, leafcutter ants, bison etc) should utilize when pathing. Bigger number = less impact on TPS");
        builder.pop();
    }
    
    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String category, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(name).define(name, defaultValue);
    }

    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String category, int defaultValue, int min, int max, String comment) {
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }

    private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String name, String category, double defaultValue, double min, double max, String comment) {
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }
}
