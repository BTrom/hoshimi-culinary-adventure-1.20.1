package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.entities.ChickenVariant;
import com.botrom.hoshimi_ca_mod.entities.CowVariant;
import com.botrom.hoshimi_ca_mod.entities.PigVariant;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.serialization.Codec;
import com.mojang.serialization.Lifecycle;
import net.minecraft.core.MappedRegistry;
import net.minecraft.core.Registry;
import net.minecraft.resources.ResourceKey;

import java.util.function.Supplier;

public class ModRegistries {
//    public static final RegistryBuilder BUILDER = RegistryBuilder.create(HoshimiCulinaryMod.MOD_ID);

//    public static final ResourceKey<Registry<WolfSoundVariant>> WOLF_SOUND_VARIANT_KEY = BUILDER.resource("wolf_sound_variant");
//    public static final Supplier<Registry<WolfSoundVariant>> WOLF_SOUND_VARIANT = BUILDER.registry(WOLF_SOUND_VARIANT_KEY);

    public static final ResourceKey<Registry<CowVariant>> COW_VARIANT_KEY = ResourceKey.createRegistryKey(Utils.createResourceLocation("cow_variant"));
    public static final Supplier<Registry<CowVariant>> COW_VARIANT = () -> new MappedRegistry<>(COW_VARIANT_KEY, Lifecycle.stable());

    public static final ResourceKey<Registry<ChickenVariant>> CHICKEN_VARIANT_KEY = ResourceKey.createRegistryKey(Utils.createResourceLocation("chicken_variant"));
    public static final Supplier<Registry<ChickenVariant>> CHICKEN_VARIANT = () -> new MappedRegistry<>(CHICKEN_VARIANT_KEY, Lifecycle.stable());

    public static final ResourceKey<Registry<PigVariant>> PIG_VARIANT_KEY = ResourceKey.createRegistryKey(Utils.createResourceLocation("pig_variant"));
    public static final Supplier<Registry<PigVariant>> PIG_VARIANT = () -> new MappedRegistry<>(PIG_VARIANT_KEY, Lifecycle.stable());

//    public static final ResourceKey<Registry<WolfVariant>> WOLF_VARIANT_KEY = BUILDER.resource("wolf_variant");
//    public static final Supplier<Registry<WolfVariant>> WOLF_VARIANT = BUILDER.registry(WOLF_VARIANT_KEY);

    public static final ResourceKey<Registry<Codec<? extends SpawnCondition>>> SPAWN_CONDITION_TYPE_KEY = ResourceKey.createRegistryKey(Utils.createResourceLocation("spawn_condition_type"));
    public static final Supplier<Registry<Codec<? extends SpawnCondition>>> SPAWN_CONDITION_TYPE = () -> new MappedRegistry<>(SPAWN_CONDITION_TYPE_KEY, Lifecycle.stable());
}
