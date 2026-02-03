package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModelAndTexture;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.SpawnPrioritySelectors;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.biomes.BiomeCheck;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class CowVariants {
    public static final ResourceKey<CowVariant> TEMPERATE = register("temperate", CowVariant.ModelType.NORMAL, "cow", SpawnPrioritySelectors.fallback(0));
    public static final ResourceKey<CowVariant> WARM = register("warm", CowVariant.ModelType.WARM, "warm_cow", ModTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final ResourceKey<CowVariant> COLD = register("cold", CowVariant.ModelType.COLD, "cold_cow", ModTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static ResourceKey<CowVariant> register(String key, CowVariant.ModelType type, String assetId, TagKey<Biome> biome) {
        return register(key, type, assetId, SpawnPrioritySelectors.single(new BiomeCheck(biome), 1));
    }

    private static ResourceKey<CowVariant> register(String key, CowVariant.ModelType type, String assetId, SpawnPrioritySelectors selectors) {
        ResourceLocation path = Utils.createResourceLocation("entity/cow/" + assetId);
        return ModBuiltinRegistries.COW_VARIANTS.resource(key, new CowVariant(new ModelAndTexture<>(type, path), selectors));
    }
}