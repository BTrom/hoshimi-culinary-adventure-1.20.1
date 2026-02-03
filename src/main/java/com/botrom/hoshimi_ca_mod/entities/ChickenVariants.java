package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.biomes.BiomeCheck;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModelAndTexture;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.SpawnPrioritySelectors;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

public class ChickenVariants {
    public static final ResourceKey<ChickenVariant> TEMPERATE = register("temperate", ChickenVariant.ModelType.NORMAL, new ResourceLocation("minecraft", "entity/chicken"), SpawnPrioritySelectors.fallback(0));
    public static final ResourceKey<ChickenVariant> WARM = register("warm", ChickenVariant.ModelType.NORMAL, "warm_chicken", ModTags.SPAWNS_WARM_VARIANT_FARM_ANIMALS);
    public static final ResourceKey<ChickenVariant> COLD = register("cold", ChickenVariant.ModelType.COLD, "cold_chicken", ModTags.SPAWNS_COLD_VARIANT_FARM_ANIMALS);

    private static ResourceKey<ChickenVariant> register(String key, ChickenVariant.ModelType type, String assetId, TagKey<Biome> biome) {
        // HolderSet<Biome> biomes = Utils.getRegistryAccess().lookup(Registries.BIOME).get().getOrThrow(biome);
        // return register(key, type, assetId, SpawnPrioritySelectors.single(new BiomeCheck(biomes), 1));
        return register(key, type, assetId, SpawnPrioritySelectors.single(new BiomeCheck(biome), 1));
    }

    private static ResourceKey<ChickenVariant> register(String key, ChickenVariant.ModelType type, String assetId, SpawnPrioritySelectors selectors) {
        ResourceLocation path = Utils.createResourceLocation("entity/chicken/" + assetId);
        return ModBuiltinRegistries.CHICKEN_VARIANTS.resource(key, new ChickenVariant(new ModelAndTexture<>(type, path), selectors));
    }

    private static ResourceKey<ChickenVariant> register(String key, ChickenVariant.ModelType type, ResourceLocation assetId, SpawnPrioritySelectors selectors) {
        return ModBuiltinRegistries.CHICKEN_VARIANTS.resource(key, new ChickenVariant(new ModelAndTexture<>(type, assetId), selectors));
    }
}