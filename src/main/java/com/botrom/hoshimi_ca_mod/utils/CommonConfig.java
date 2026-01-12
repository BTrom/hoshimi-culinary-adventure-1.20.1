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
    public final ForgeConfigSpec.BooleanValue seagullStealing;
    public final ForgeConfigSpec.ConfigValue<List<? extends String>> seagullStealingBlacklist;

    public CommonConfig(final ForgeConfigSpec.Builder builder) {
        builder.push("general");
        seagullStealing = buildBoolean(builder, "seagullStealing", "all", true, "Whether seagulls should steal food out of players' hotbar slots.");
        seagullStealingBlacklist = builder.comment("List of items that seagulls cannot take from players.").defineList("seagullStealingBlacklist", Lists.newArrayList(), o -> o instanceof String);
        builder.pop();
        builder.push("spawning");
        catfishSpawnWeight = buildInt(builder, "catfishSpawnWeight", "spawns", ModConfig.catfishSpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        catfishSpawnRolls = buildInt(builder, "catfishSpawnRolls", "spawns", ModConfig.catfishSpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        lobsterSpawnWeight = buildInt(builder, "lobsterSpawnWeight", "spawns", ModConfig.lobsterSpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        lobsterSpawnRolls = buildInt(builder, "lobsterSpawnRolls", "spawns", ModConfig.lobsterSpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        giantSquidSpawnWeight = buildInt(builder, "giantSquidSpawnWeight", "spawns", ModConfig.giantSquidSpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        giantSquidSpawnRolls = buildInt(builder, "giantSquidSpawnRolls", "spawns", ModConfig.giantSquidSpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        terrapinSpawnWeight = buildInt(builder, "terrapinSpawnWeight", "spawns", ModConfig.terrapinSpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        terrapinSpawnRolls = buildInt(builder, "terrapinSpawnRolls", "spawns", ModConfig.terrapinSpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        combJellySpawnWeight = buildInt(builder, "combJellySpawnWeight", "spawns", ModConfig.combJellySpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        combJellySpawnRolls = buildInt(builder, "combJellySpawnRolls", "spawns", ModConfig.combJellySpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        mimicOctopusSpawnWeight = buildInt(builder, "mimicOctopusSpawnWeight", "spawns", ModConfig.mimicOctopusSpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        mimicOctopusSpawnRolls = buildInt(builder, "mimicOctopusSpawnRolls", "spawns", ModConfig.mimicOctopusSpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        seagullSpawnWeight = buildInt(builder, "seagullSpawnWeight", "spawns", ModConfig.seagullSpawnWeight, 0, 1000, "Spawn Weight, added to a pool of other mobs for each biome. Higher number = higher chance of spawning. 0 = disable spawn");
        seagullSpawnRolls = buildInt(builder, "seagullSpawnRolls", "spawns", ModConfig.seagullSpawnRolls, 0, Integer.MAX_VALUE, "Random roll chance to enable mob spawning. Higher number = lower chance of spawning");
        builder.pop();
    }
    
    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String catagory, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(name).define(name, defaultValue);
    }

    private static ForgeConfigSpec.IntValue buildInt(ForgeConfigSpec.Builder builder, String name, String catagory, int defaultValue, int min, int max, String comment) {
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }

    private static ForgeConfigSpec.DoubleValue buildDouble(ForgeConfigSpec.Builder builder, String name, String catagory, double defaultValue, double min, double max, String comment) {
        return builder.comment(comment).translation(name).defineInRange(name, defaultValue, min, max);
    }
}
