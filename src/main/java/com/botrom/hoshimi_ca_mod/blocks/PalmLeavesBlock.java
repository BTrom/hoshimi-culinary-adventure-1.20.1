package com.botrom.hoshimi_ca_mod.blocks;

import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;

public class PalmLeavesBlock extends LeavesBlock {
    public static final BooleanProperty GENERATED = BooleanProperty.create("generated");

    public PalmLeavesBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.defaultBlockState().setValue(GENERATED, false));
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 60;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 30;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(GENERATED);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        // Player-placed leaves decay normally
        if (!state.getValue(GENERATED) && !state.getValue(PERSISTENT)) {
            super.randomTick(state, level, pos, random);
            return;
        }

        // Generated leaves decay if no palm log within 4 blocks, checking diagonals
        if (state.getValue(GENERATED)) {
            boolean connected = hasPalmLogNearby(level, pos, 4);
            if (!connected) {
                level.destroyBlock(pos, true);
            }
        }
    }

    private boolean hasPalmLogNearby(Level level, BlockPos pos, int range) {
        for (int dx = -range; dx <= range; dx++) {
            for (int dy = -range; dy <= range; dy++) {
                for (int dz = -range; dz <= range; dz++) {
                    if (dx == 0 && dy == 0 && dz == 0) continue;
                    BlockPos checkPos = pos.offset(dx, dy, dz);
                    BlockState state = level.getBlockState(checkPos);
                    if (state.is(ModBlocks.PALM_LOG.get())) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public boolean isRandomlyTicking(BlockState state) {
        return !state.getValue(PERSISTENT) || state.getValue(GENERATED);
    }

}
