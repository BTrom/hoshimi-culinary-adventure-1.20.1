package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.blocks.SeashellBlock;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModStateProviders;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;

public class RandomSeashellStateProvider extends BlockStateProvider {
    private final boolean waterlogged;

    public RandomSeashellStateProvider(boolean waterlogged) {
        this.waterlogged = waterlogged;
    }

    public static final Codec<RandomSeashellStateProvider> CODEC =
            RecordCodecBuilder.create(instance ->
                    instance.group(Codec.BOOL.optionalFieldOf("waterlogged", false).forGetter(p -> p.waterlogged)).apply(instance, RandomSeashellStateProvider::new)
            );

    @Override
    protected BlockStateProviderType<?> type() {
        return ModStateProviders.RANDOM_SEASHELL.get();
    }

    @Override
    public BlockState getState(RandomSource random, BlockPos pos) {
        int variant = random.nextInt(7);
        Direction facing = Direction.Plane.HORIZONTAL.getRandomDirection(random);

        return ModBlocks.SEASHELLS.get().defaultBlockState()
                .setValue(SeashellBlock.VARIANT, variant)
                .setValue(SeashellBlock.FACING, facing)
                .setValue(SeashellBlock.WATERLOGGED, waterlogged);
    }
}
