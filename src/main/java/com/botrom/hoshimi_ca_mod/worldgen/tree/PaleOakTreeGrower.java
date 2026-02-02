package com.botrom.hoshimi_ca_mod.worldgen.tree;

import com.botrom.hoshimi_ca_mod.registry.ModConfiguredFeatures;
import net.minecraft.resources.ResourceKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.grower.AbstractMegaTreeGrower;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;

public class PaleOakTreeGrower extends AbstractMegaTreeGrower {
    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredFeature(RandomSource random, boolean hasFlowers) {
        return null;
    }

    @Override
    protected ResourceKey<ConfiguredFeature<?, ?>> getConfiguredMegaFeature(RandomSource random) {
        return ModConfiguredFeatures.PALE_OAK_BONEMEAL;
    }
}