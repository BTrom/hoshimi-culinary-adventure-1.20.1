package com.botrom.hoshimi_ca_mod.blocks;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;

public class PlateOfFriedDumpling extends FeastBlock {
    protected static final VoxelShape PLATE_SHAPE = Block.box(2.0, 0.0, 2.0, 14.0, 1.0, 14.0);
    protected static final VoxelShape PIE_SHAPE;

    public PlateOfFriedDumpling(Properties properties) {
        super(Properties.copy(Blocks.CAKE), ModItems.BOWL_OF_FRIED_DUMPLING, true);
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return (Integer) state.getValue(SERVINGS) == 0 ? PLATE_SHAPE : PIE_SHAPE;
    }

    static {
        PIE_SHAPE = PLATE_SHAPE;
    }
}
