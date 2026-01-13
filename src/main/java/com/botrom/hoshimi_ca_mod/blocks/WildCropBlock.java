package com.botrom.hoshimi_ca_mod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class WildCropBlock extends vectorwing.farmersdelight.common.block.WildCropBlock {
    public WildCropBlock(MobEffect suspiciousStewEffect, int effectDuration, Properties properties) {
        super(suspiciousStewEffect, effectDuration, properties);
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        // Make sure we only generate this crop on dirt blocks.
        return state.is(BlockTags.DIRT);
    }
}