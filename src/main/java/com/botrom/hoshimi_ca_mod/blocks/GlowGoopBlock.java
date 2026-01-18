package com.botrom.hoshimi_ca_mod.blocks;


import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.BlockParticleOption;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.BarrierBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.SimpleWaterloggedBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.level.pathfinder.PathComputationType;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.function.ToIntFunction;

public class GlowGoopBlock extends Block implements SimpleWaterloggedBlock {
    public static final int MIN_GOOP = 1;
    public static final int MAX_GOOP = 3;
    public static final BooleanProperty WATERLOGGED;
    public static final @NotNull ToIntFunction<BlockState> LIGHT_EMISSION;
    public static IntegerProperty GOOP;

    public GlowGoopBlock(Properties properties) {
        super(properties);
        this.registerDefaultState(this.stateDefinition.any()
            .setValue(GOOP, MIN_GOOP)
            .setValue(WATERLOGGED, false));
    }

    private void decreaseGoop(Level level, BlockPos pos, BlockState state) {
        level.playSound(null, pos, SoundEvents.HONEY_BLOCK_BREAK, SoundSource.BLOCKS, 0.7F, 0.9F + level.random.nextFloat() * 0.2F);
        int i = state.getValue(GOOP);
        if (i <= 1) {
            level.destroyBlock(pos, false);
        } else {
            level.setBlock(pos, state.setValue(GOOP, i - 1), 2);
            level.gameEvent(GameEvent.BLOCK_DESTROY, pos, GameEvent.Context.of(state));
            level.levelEvent(2001, pos, Block.getId(state));
        }
    }
    public void playerDestroy(Level level, Player player, BlockPos pos, BlockState state, @Nullable BlockEntity blockEntity, ItemStack tool) {
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
        this.decreaseGoop(level, pos, state);
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(BlockGetter level, BlockPos pos, BlockState state) {
        return ModItems.GLOW_GOOP.get().asItem().getDefaultInstance();
    }

    @Override
    public BlockState getStateForPlacement(@NotNull BlockPlaceContext context) {
        BlockState blockState = context.getLevel().getBlockState(context.getClickedPos());
        if (blockState.is(this)) {
            return blockState.setValue(GOOP, Math.min(MAX_GOOP, blockState.getValue(GOOP) + 1));
        } else {
            FluidState fluidState = context.getLevel().getFluidState(context.getClickedPos());
            boolean bl = fluidState.getType() == Fluids.WATER;
            return super.getStateForPlacement(context).setValue(WATERLOGGED, bl);
        }
    }

    @Override
    public @NotNull FluidState getFluidState(@NotNull BlockState state) {
        return state.getValue(WATERLOGGED) ? Fluids.WATER.getSource(false) : super.getFluidState(state);
    }

    @Override
    public boolean canBeReplaced(BlockState state, @NotNull BlockPlaceContext context) {
        ItemStack stack = context.getItemInHand();
        Level level = context.getLevel();
        BlockPos pos = context.getClickedPos();
        int currentGoop = state.getValue(GOOP);

        if (stack.is(this.asItem()) && !context.isSecondaryUseActive() && currentGoop < MAX_GOOP) {
            return true;
        }

        if (!stack.is(this.asItem())) {
            if (!level.isClientSide()) {
                ItemStack itemStack = new ItemStack(ModItems.GLOW_GOOP.get(), currentGoop);
                popResource(level, pos, itemStack);

                level.removeBlock(pos, false);
            }
            return true;
        }

        return super.canBeReplaced(state, context);
    }



    @Override
    protected void createBlockStateDefinition(StateDefinition.@NotNull Builder<Block, BlockState> builder) {
        builder.add(GOOP, WATERLOGGED);
    }

    public RenderShape getRenderShape(BlockState state) {
        return RenderShape.INVISIBLE;
    }

    @Override
    public boolean isPathfindable(BlockState state, BlockGetter level, BlockPos pos, PathComputationType type) {
        return true;
    }

    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        return context.isHoldingItem(ModItems.GLOW_GOOP.get()) ? Shapes.block() : Shapes.empty();
    }

    public boolean propagatesSkylightDown(BlockState state, BlockGetter level, BlockPos pos) {
        return true;
    }

    public float getShadeBrightness(BlockState state, BlockGetter level, BlockPos pos) {
        return 1.0F;
    }

    static {
        GOOP = IntegerProperty.create("goop", MIN_GOOP, MAX_GOOP);
        WATERLOGGED = BlockStateProperties.WATERLOGGED;
        LIGHT_EMISSION = (blockState) -> blockState.getValue(GOOP) * 5;
    }

    @Override
    public void animateTick(BlockState state, Level level, BlockPos pos, RandomSource pRandom) {
        // 1. Get the client player
        Player player = Minecraft.getInstance().player;

        // 2. Check if player exists and is holding the specific item
        if (player != null && (isHoldingGlowGoop(player))) {

            // 3. Spawn the particle at the center of the block
            // You can replace 'ParticleTypes.BARRIER' with your specific particle
            level.addParticle(new BlockParticleOption(ParticleTypes.BLOCK_MARKER, state),
                    pos.getX() + 0.5D,
                    pos.getY() + 0.5D,
                    pos.getZ() + 0.5D,
                    0.0D, 0.0D, 0.0D
            );
        }
    }
    private boolean isHoldingGlowGoop(Player player) {
        // Adjust 'NaturalistRegistry.GLOW_GOOP.get()' to match your item registry
        return player.getMainHandItem().is(ModItems.GLOW_GOOP.get()) ||
                player.getOffhandItem().is(ModItems.GLOW_GOOP.get());
    }
}
