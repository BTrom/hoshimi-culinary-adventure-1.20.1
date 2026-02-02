package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.google.common.collect.ImmutableSet;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.Arrays;
import java.util.Objects;
import java.util.Set;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public interface BiomeContext {
    Predicate<BiomeContext> OVERWORLD_BIOME = (context) -> {
        Stream<ResourceKey<Biome>> var10000 = MultiNoiseBiomeSourceParameterList.Preset.OVERWORLD.usedBiomes();
        Objects.requireNonNull(context);
        return var10000.anyMatch(context::is);
    };

    ResourceKey<Biome> resource();

    Biome biome();

    boolean is(TagKey<Biome> var1);

    boolean is(ResourceKey<Biome> var1);

    boolean is(Predicate<BiomeContext> var1);

    boolean hasFeature(ResourceKey<PlacedFeature> var1);

    default boolean hasEntity(Supplier<EntityType<?>> entities) {
        return this.hasEntity(ImmutableSet.of(entities));
    }

    default boolean hasEntity(Set<Supplier<EntityType<?>>> entitySet) {
        Set<EntityType<?>> entities = (Set)entitySet.stream().map(Supplier::get).collect(Collectors.toSet());
        MobSpawnSettings settings = this.biome().getMobSettings();
        return Arrays.stream(MobCategory.values()).flatMap((category) -> {
            return settings.getMobs(category).unwrap().stream();
        }).anyMatch((spawner) -> {
            return entities.contains(spawner.type);
        });
    }
}