package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.carver.ConfiguredWorldCarver;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;

import java.util.function.BiConsumer;

public abstract class BiomeWriter {
    public BiomeWriter() {
    }

    public void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        modifier.accept(this, this.context());
    }

    public abstract ResourceLocation name();

    public abstract BiomeContext context();

    public abstract void addFeature(GenerationStep.Decoration var1, ResourceKey<PlacedFeature> var2);

    public abstract void removeFeature(GenerationStep.Decoration var1, ResourceKey<PlacedFeature> var2);

    public void replaceFeature(GenerationStep.Decoration decoration, ResourceKey<PlacedFeature> feature, ResourceKey<PlacedFeature> replacement) {
        if (this.context().hasFeature(feature)) {
            this.removeFeature(decoration, feature);
            this.addFeature(decoration, replacement);
        }

    }

    public abstract void addCarver(GenerationStep.Carving var1, ResourceKey<ConfiguredWorldCarver<?>> var2);

    public abstract void removeCarver(GenerationStep.Carving var1, ResourceKey<ConfiguredWorldCarver<?>> var2);

    public abstract void addSpawn(MobCategory var1, MobSpawnSettings.SpawnerData var2);

    public abstract void removeSpawn(EntityType<?> var1);

    public void replaceSpawn(MobCategory category, MobSpawnSettings.SpawnerData data) {
        if (this.context().hasEntity(() -> {
            return data.type;
        })) {
            this.removeSpawn(data.type);
            this.addSpawn(category, data);
        }

    }
}