package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.mojang.serialization.Codec;
import net.minecraft.core.Holder;
import net.minecraft.tags.BiomeTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.MobSpawnSettings;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ModifiableBiomeInfo;
import org.jetbrains.annotations.NotNull;

public class NaturalistAddAnimalsBiomeModifier implements BiomeModifier {
    @Override
    public void modify(Holder<Biome> biome, Phase phase, ModifiableBiomeInfo.BiomeInfo.Builder builder) {
        if (phase.equals(Phase.ADD)) {
//            /* BLUEJAY */ if (NaturalistConfig.bluejaySpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_BLUEJAY)) addMobSpawn(builder, biome, ModTags.HAS_BLUEJAY, MobCategory.CREATURE, ModEntities.BLUEJAY.get(), ModConfig.bluejaySpawnWeight, ModConfig.bluejaySpawnMinGroupSize, ModConfig.bluejaySpawnMaxGroupSize);
            /* BUTTERFLY */ if (ModConfig.butterflySpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_BUTTERFLY)) addMobSpawn(builder, biome, ModTags.HAS_BUTTERFLY, MobCategory.CREATURE, ModEntities.BUTTERFLY.get(), ModConfig.butterflySpawnWeight, ModConfig.butterflySpawnMinGroupSize, ModConfig.butterflySpawnMaxGroupSize);
//            /* CANARY */ if (ModConfig.canarySpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_CANARY)) addMobSpawn(builder, biome, ModTags.HAS_CANARY, MobCategory.CREATURE, ModEntities.CANARY.get(), ModConfig.canarySpawnWeight, ModConfig.canarySpawnMinGroupSize, ModConfig.canarySpawnMaxGroupSize);
            /* CARDINAL */ if (ModConfig.cardinalSpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_CARDINAL)) addMobSpawn(builder, biome, ModTags.HAS_CARDINAL, MobCategory.CREATURE, ModEntities.CARDINAL.get(), ModConfig.cardinalSpawnWeight, ModConfig.cardinalSpawnMinGroupSize, ModConfig.cardinalSpawnMaxGroupSize);
            /* LIZARD */ if (ModConfig.lizardSpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_LIZARD)) addMobSpawn(builder, biome, ModTags.HAS_LIZARD, MobCategory.CREATURE, ModEntities.LIZARD.get(), ModConfig.lizardSpawnWeight, ModConfig.lizardSpawnMinGroupSize, ModConfig.lizardSpawnMaxGroupSize);
//            /* ROBIN */ if (ModConfig.robinSpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_ROBIN)) addMobSpawn(builder, biome, ModTags.HAS_ROBIN, MobCategory.CREATURE, ModEntities.ROBIN.get(), ModConfig.robinSpawnWeight, ModConfig.robinSpawnMinGroupSize, ModConfig.robinSpawnMaxGroupSize);
            /* SNAIL */ if (ModConfig.snailSpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_SNAIL)) addMobSpawn(builder, biome, ModTags.HAS_SNAIL, MobCategory.CREATURE, ModEntities.SNAIL.get(), ModConfig.snailSpawnWeight, ModConfig.snailSpawnMinGroupSize, ModConfig.snailSpawnMaxGroupSize);
            /* SPARROW */ if (ModConfig.sparrowSpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_SPARROW)) addMobSpawn(builder, biome, ModTags.HAS_SPARROW, MobCategory.CREATURE, ModEntities.SPARROW.get(), ModConfig.sparrowSpawnWeight, ModConfig.sparrowSpawnMinGroupSize, ModConfig.sparrowSpawnMaxGroupSize);
            /* TORTOISE */ if (ModConfig.tortoiseSpawnWeight != 0 && !biome.is(ModTags.BLACKLIST_TORTOISE)) addMobSpawn(builder, biome, ModTags.HAS_TORTOISE, MobCategory.CREATURE, ModEntities.TORTOISE.get(), ModConfig.tortoiseSpawnWeight, ModConfig.tortoiseSpawnMinGroupSize, ModConfig.tortoiseSpawnMaxGroupSize);
        }
    }


    void addMobSpawn(ModifiableBiomeInfo.BiomeInfo.Builder builder, Holder<Biome> biome, TagKey<Biome> tag, MobCategory mobCategory, EntityType<?> entityType, int weight, int minGroupSize, int maxGroupSize) {
        if (biome.is(tag)) {
            builder.getMobSpawnSettings().addSpawn(mobCategory, new MobSpawnSettings.SpawnerData(entityType, weight, minGroupSize, maxGroupSize));
        }
    }

    @Override
    public @NotNull Codec<? extends BiomeModifier> codec() {
        return BiomeModifiers.ADD_ANIMALS_CODEC.get();
    }
}
