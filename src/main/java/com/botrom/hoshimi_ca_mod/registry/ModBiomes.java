package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;

public class ModBiomes {
    public static final ResourceKey<Biome> PALE_GARDEN = createBiome("pale_garden");

    private static ResourceKey<Biome> createBiome(String name) {
        return ResourceKey.create(Registries.BIOME, Utils.createResourceLocation(name));
    }
}
