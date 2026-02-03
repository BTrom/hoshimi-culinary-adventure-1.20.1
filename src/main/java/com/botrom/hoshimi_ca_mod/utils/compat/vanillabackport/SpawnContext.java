package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;

public record SpawnContext(BlockPos pos, ServerLevelAccessor level, Holder<Biome> biome) {
    public static SpawnContext create(ServerLevelAccessor level, BlockPos pos) {
        Holder<Biome> biome = level.getBiome(pos);
        return new SpawnContext(pos, level, biome);
    }
}