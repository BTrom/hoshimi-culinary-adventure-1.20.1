package com.botrom.hoshimi_ca_mod.worldgen.features;

import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.CountConfiguration;

public class FeatureSeaAnemone extends Feature<CountConfiguration> {

    public FeatureSeaAnemone(Codec<CountConfiguration> p_i231987_1_) {
        super(p_i231987_1_);
    }

    public boolean place(FeaturePlaceContext<CountConfiguration> context) {
        RandomSource rand = context.level().getRandom();
        WorldGenLevel world = context.level();
        BlockPos pos = world.getHeightmapPos(Heightmap.Types.OCEAN_FLOOR, context.origin());

        if (pos.getY() > 44 && pos.getY() < 62) {
            int i = 0;
            int m = rand.nextInt(3);
            Block type = switch (m) {
                case 1 -> ModBlocks.ANEMONE_SAND.get();
                case 2 -> ModBlocks.ANEMONE_SEBAE.get();
                default -> ModBlocks.ANEMONE_ROSE_BULB.get();
            };
            for(int j = 0; j < context.config().count().sample(rand); ++j) {
                int k = rand.nextInt(8) - rand.nextInt(8);
                int l = rand.nextInt(8) - rand.nextInt(8);
                int i1 = world.getHeight(Heightmap.Types.OCEAN_FLOOR, pos.getX() + k, pos.getZ() + l);
                BlockPos blockpos = new BlockPos(pos.getX() + k, i1, pos.getZ() + l);
                BlockState blockstate = type.defaultBlockState();
                if (i1 < 62 && world.getBlockState(blockpos).is(Blocks.WATER) && blockstate.canSurvive(world, blockpos)) {
                    world.setBlock(blockpos, blockstate, 2);
                    ++i;
                }
            }

            return i > 0;
        }
        return false;
    }
}