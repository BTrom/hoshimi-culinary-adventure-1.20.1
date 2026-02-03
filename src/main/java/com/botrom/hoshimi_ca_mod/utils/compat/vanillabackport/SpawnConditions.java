package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.biomes.BiomeCheck;
import com.mojang.serialization.Codec;

import java.util.function.Supplier;

public class SpawnConditions {
    public static final CoreRegistry<Codec<? extends SpawnCondition>> CONDITIONS = CoreRegistry.create(ModRegistries.SPAWN_CONDITION_TYPE.get(), HoshimiCulinaryMod.MOD_ID);

    public static final Supplier<Codec<? extends SpawnCondition>> STRUCTURE = CONDITIONS.register("structure", () -> StructureCheck.CODEC);
    public static final Supplier<Codec<? extends SpawnCondition>> MOON_BRIGHTNESS = CONDITIONS.register("moon_brightness", () -> MoonBrightnessCheck.CODEC);
    public static final Supplier<Codec<? extends SpawnCondition>> BIOME = CONDITIONS.register("biome", () -> BiomeCheck.CODEC);
}