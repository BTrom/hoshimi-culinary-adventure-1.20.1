package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModelAndTexture;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.SpawnPrioritySelectors;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.biomes.BiomeCheck;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class PigVariants {
    public static final ResourceKey<PigVariant> TEMPERATE = register("temperate", PigVariant.ModelType.NORMAL, "pig", SpawnPrioritySelectors.fallback(0));
    public static final ResourceKey<PigVariant> WARM = register("warm", PigVariant.ModelType.NORMAL, "warm_pig", ModTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final ResourceKey<PigVariant> COLD = register("cold", PigVariant.ModelType.COLD, "cold_pig", ModTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static ResourceKey<PigVariant> register(String key, PigVariant.ModelType type, String assetId, TagKey<Biome> biome) {
        return register(key, type, assetId, SpawnPrioritySelectors.single(new BiomeCheck(biome), 1));
    }

    private static ResourceKey<PigVariant> register(String key, PigVariant.ModelType type, String assetId, SpawnPrioritySelectors selectors) {
        ResourceLocation path = Utils.createResourceLocation("entity/pig/" + assetId);
        return ModBuiltinRegistries.PIG_VARIANTS.resource(key, new PigVariant(new ModelAndTexture<>(type, path), selectors));
    }
}