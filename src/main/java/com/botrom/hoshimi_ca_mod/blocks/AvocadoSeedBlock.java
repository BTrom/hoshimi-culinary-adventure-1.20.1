package com.botrom.hoshimi_ca_mod.blocks;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SaplingBlock;
import net.minecraft.world.level.block.grower.AbstractTreeGrower;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;

public class AvocadoSeedBlock extends SaplingBlock {

    private static final VoxelShape SHAPE_PIT = Block.box(6, 0, 6, 10, 3, 10);

    public AvocadoSeedBlock(AbstractTreeGrower treeIn, Properties properties) {
        super(treeIn, properties);
    }

    @Override
    public VoxelShape getShape(BlockState state, BlockGetter worldIn, BlockPos pos, CollisionContext context) {
        return SHAPE_PIT;
    }
}
