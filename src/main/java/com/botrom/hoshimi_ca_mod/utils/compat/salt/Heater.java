package com.botrom.hoshimi_ca_mod.utils.compat.salt;

import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class Heater {
    public static boolean isHeatSource(BlockState blockState) {
        return blockState.is(ModTags.HEATERS) &&
                (!blockState.hasProperty(BlockStateProperties.LIT) || blockState.getValue(BlockStateProperties.LIT));
    }
}
