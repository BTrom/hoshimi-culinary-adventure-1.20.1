package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.registry.ModBiomes;
import com.botrom.hoshimi_ca_mod.registry.ModPlacedFeatures;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeContext;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeWriter;
import net.minecraft.data.worldgen.placement.VegetationPlacements;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.level.biome.MobSpawnSettings;

public class SpringToLifeFeatureManager extends FeatureManager {
    public SpringToLifeFeatureManager(BiomeContext context, BiomeWriter writer) {
        super(context, writer);
    }

    @Override
    public void bootstrap() {
        this.addIf(ModConfig.hasBushes, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_BUSHES).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_BUSH));
        });

        this.addIf(ModConfig.hasFireflyBushes, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FIREFLY_BUSHES).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER));

            this.getOrCreateBiomeBuilder(context.is(ModTags.SPAWNS_FIREFLY_BUSHES_SWAMP) && !context.is(ModTags.SPAWNS_FIREFLY_BUSHES)).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_FIREFLY_BUSH_SWAMP)).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_FIREFLY_BUSH_NEAR_WATER_SWAMP));
        });

        this.addIf(ModConfig.hasWildflowers, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_NOISE_BASED_WILDFLOWERS).add(() -> this.addVegetation(ModPlacedFeatures.WILDFLOWERS_MEADOW));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_WILDFLOWERS).add(() -> this.addVegetation(ModPlacedFeatures.WILDFLOWERS_BIRCH_FOREST));
        });

        this.addIf(ModConfig.hasDryGrass, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_DRY_GRASS).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_DRY_GRASS_DESERT));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_DRY_GRASS_RARELY).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_DRY_GRASS_BADLANDS));
        });

        this.addIf(ModConfig.hasFallenTrees, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FALLEN_OAK_TREES).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_FALLEN_OAK_TREE));

            this.getOrCreateBiomeBuilder(ctx -> ctx.is(ModTags.SPAWNS_FALLEN_BIRCH_TREES_RARELY) && !ctx.is(ModBiomes.PALE_GARDEN)).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_RARE_FALLEN_BIRCH_TREE));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FALLEN_BIRCH_TREES).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_FALLEN_BIRCH_TREE));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FALLEN_SUPER_BIRCH_TREES).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_FALLEN_SUPER_BIRCH_TREE));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FALLEN_JUNGLE_TREES).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_FALLEN_JUNGLE_TREE));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FALLEN_SPRUCE_TREES).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_FALLEN_SPRUCE_TREE));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_FALLEN_SPRUCE_TREES_RARELY).add(() -> this.addVegetation(ModPlacedFeatures.PLACED_RARE_FALLEN_SPRUCE_TREE));
        });

        this.addIf(ModConfig.hasLeafLitter, (context, writer) -> {
            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_LEAF_LITTER_PATCHES).add(() -> this.addVegetation(ModPlacedFeatures.PATCH_LEAF_LITTER));

            this.getOrCreateBiomeBuilder(ModTags.SPAWNS_LEAF_LITTER).add(() -> this.addVegetation(ModPlacedFeatures.LEAF_LITTER));
        });

        this.addIf(ModConfig.hasCactusFlowers, (context, writer) -> {
            if (context.hasFeature(VegetationPlacements.PATCH_CACTUS_DECORATED) || context.hasFeature(VegetationPlacements.PATCH_CACTUS_DESERT)) {
                this.addVegetation(ModPlacedFeatures.CACTUS_FLOWER);
            }
        });
    }
}