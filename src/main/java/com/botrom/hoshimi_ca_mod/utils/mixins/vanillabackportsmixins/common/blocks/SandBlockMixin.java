package com.botrom.hoshimi_ca_mod.utils.mixins.vanillabackportsmixins.common.blocks;

import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.AmbientDesertBlockSoundsPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SandBlock;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(SandBlock.class)
public class SandBlockMixin extends Block {
    public SandBlockMixin(Properties properties) {
        super(properties);
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource random) {
        AmbientDesertBlockSoundsPlayer.playAmbientSandSounds(level, pos, random);
        super.animateTick(state, level, pos, random);
    }
}