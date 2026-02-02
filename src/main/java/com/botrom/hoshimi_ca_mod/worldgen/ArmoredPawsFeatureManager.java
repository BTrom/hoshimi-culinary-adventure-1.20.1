package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeContext;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeWriter;
import net.minecraft.tags.BiomeTags;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class ArmoredPawsFeatureManager extends FeatureManager {
    public ArmoredPawsFeatureManager(BiomeContext context, BiomeWriter writer) {
        super(context, writer);
    }

    @Override
    public void bootstrap() {
        this.addIf(ModConfig.hasArmadillos, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_ARMADILLOS_FREQUENTLY)
                .add(() -> writer.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARMADILLO.get(), 10, 2, 3)));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_ARMADILLOS)
                .add(() -> writer.addSpawn(MobCategory.CREATURE, new MobSpawnSettings.SpawnerData(ModEntities.ARMADILLO.get(), 6, 1, 2)));
        });
    }
}