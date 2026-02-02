package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.mojang.serialization.Codec;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.function.Supplier;

public class VanillaBackportModRegistries {
    public static final RegistryBuilder BUILDER = RegistryBuilder.create(HoshimiCulinaryMod.MOD_ID);

//    public static final ResourceKey<Registry<CowVariant>> COW_VARIANT_KEY = BUILDER.resource("cow_variant");
//    public static final Supplier<Registry<CowVariant>> COW_VARIANT = BUILDER.registry(COW_VARIANT_KEY);
//
//    public static final ResourceKey<Registry<ChickenVariant>> CHICKEN_VARIANT_KEY = BUILDER.resource("chicken_variant");
//    public static final Supplier<Registry<ChickenVariant>> CHICKEN_VARIANT = BUILDER.registry(CHICKEN_VARIANT_KEY);
//
//    public static final ResourceKey<Registry<PigVariant>> PIG_VARIANT_KEY = BUILDER.resource("pig_variant");
//    public static final Supplier<Registry<PigVariant>> PIG_VARIANT = BUILDER.registry(PIG_VARIANT_KEY);
//
//    public static final ResourceKey<Registry<Codec<? extends SpawnCondition>>> SPAWN_CONDITION_TYPE_KEY = BUILDER.resource("spawn_condition_type");
//    public static final Supplier<Registry<Codec<? extends SpawnCondition>>> SPAWN_CONDITION_TYPE = BUILDER.registry(SPAWN_CONDITION_TYPE_KEY);
}