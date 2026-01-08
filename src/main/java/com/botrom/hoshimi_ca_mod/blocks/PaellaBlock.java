package com.botrom.hoshimi_ca_mod.blocks;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition.Builder;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import vectorwing.farmersdelight.common.block.FeastBlock;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;

public class PaellaBlock extends FeastBlock {
    public static final IntegerProperty PAELLA_SERVINGS = IntegerProperty.create("servings", 0, 8);
    protected static final VoxelShape PLATE_SHAPE = Block.box(1.0, 0.0, 1.0, 15.0, 4.0, 15.0);
    public final List<Supplier<Item>> SERVINGS;
    public final int MAX_SERVINGS = 4;

    public PaellaBlock(Properties properties) {
        super(properties, ModItems.PAELLA_ITEM, true);
        this.SERVINGS = Arrays.asList(ModItems.PAELLA_ITEM, ModItems.PAELLA_ITEM, ModItems.PAELLA_ITEM, ModItems.PAELLA_ITEM);
    }

    public IntegerProperty getServingsProperty() {
        return PAELLA_SERVINGS;
    }

    public int getMaxServings() {
        return MAX_SERVINGS;
    }

    public ItemStack getServingItem(BlockState state) {
        return new ItemStack((ItemLike)((Supplier)this.SERVINGS.get((Integer)state.getValue(this.getServingsProperty()) - 1)).get());
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return PLATE_SHAPE;
    }

    protected void createBlockStateDefinition(Builder<Block, BlockState> builder) {
        builder.add(new Property[]{FACING, PAELLA_SERVINGS});
    }
}
