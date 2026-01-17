package com.botrom.hoshimi_ca_mod.blocks;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.EyeBoneBlockEntity;
import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.items.EyeBoneBlockItem;
import com.botrom.hoshimi_ca_mod.registry.ModBlockEntityTypes;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.EntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.UUID;

@SuppressWarnings("deprecation")
public class EyeBoneBlock extends Block implements EntityBlock {
    private static final VoxelShape EYE = Block.box(4.5D, 12D, 4.5D, 11.5D, 19D, 11.5D);
    private static final VoxelShape GRIP = Block.box(7D, 1D, 7D, 9D, 12D, 9D);
    private static final VoxelShape BASE_NS = Block.box(5.5D, 0.0D, 7D, 10.5D, 2D, 9D);
    private static final VoxelShape BASE_WE = Block.box(7D, 0.0D, 5.5D, 9D, 2D, 10.5D);
    private static final VoxelShape FULL_NS = Shapes.or(BASE_NS, EYE, GRIP);
    private static final VoxelShape FULL_WE = Shapes.or(BASE_WE, EYE, GRIP);
    private static final DirectionProperty FACING = DirectionProperty.create("facing", dir -> dir.getAxis().isHorizontal());

    public EyeBoneBlock() {
        super(BlockBehaviour.Properties.copy(Blocks.BONE_BLOCK).instabreak().noLootTable().noOcclusion());
        this.registerDefaultState(this.stateDefinition.any().setValue(FACING, Direction.NORTH));
        HoshimiCulinaryMod.LOGGER.info("EyeBoneBlock created.");
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos blockPos, BlockState blockState) {
        return new EyeBoneBlockEntity(blockPos, blockState);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder.add(FACING));
    }

    // TRANSFER 1: Item -> Block Entity (On Place)
    @Override
    public void setPlacedBy(Level level, BlockPos pos, BlockState state, @Nullable LivingEntity player, ItemStack stack) {
        super.setPlacedBy(level, pos, state, player, stack);
        if (!level.isClientSide && level.getBlockEntity(pos) instanceof EyeBoneBlockEntity boneBlockEntity) {
            CompoundTag tag = stack.getOrCreateTag();
            // 1. Transfer UUID (Existing)
            boneBlockEntity.setEyeBoneUUID(EyeBoneBlockItem.getOrCreateUUID(stack));
            // 2. Transfer Cooldown (New)
            if (tag.contains(Chester.RESPAWN_COOLDOWN_TAG)) {
                boneBlockEntity.setRespawnCooldown(tag.getInt(Chester.RESPAWN_COOLDOWN_TAG));
            }
            HoshimiCulinaryMod.LOGGER.info("Eye Bone Block placed at {} with UUID: {}; Respawn cooldown: {}", pos, boneBlockEntity.getEyeBoneUUID(), boneBlockEntity.getRespawnCooldown());
        }

    }

    // TRANSFER 2: Block Entity -> Item (On Break)
    @Override
    public void onRemove(BlockState state, Level level, BlockPos pos, BlockState newState, boolean movedByPiston) {
        // Only run if the block is actually changing to a completely different block (not just state change)
        if (!state.is(newState.getBlock())) {
            if (level.getBlockEntity(pos) instanceof EyeBoneBlockEntity boneBlockEntity && boneBlockEntity.getEyeBoneUUID() != null) {
                ItemStack drop = new ItemStack(ModItems.EYE_BONE.get());
                CompoundTag tag = drop.getOrCreateTag();
                // 1. Transfer UUID
                tag.putUUID(Chester.EYE_BONE_UUID_TAG, boneBlockEntity.getEyeBoneUUID());
                // 2. Transfer Cooldown
                tag.putInt(Chester.RESPAWN_COOLDOWN_TAG, boneBlockEntity.getRespawnCooldown());

                Containers.dropItemStack(level, pos.getX(), pos.getY(), pos.getZ(), drop);
//                drop.getOrCreateTag().putUUID(Chester.EYE_BONE_UUID_TAG, boneBlockEntity.getEyeBoneUUID());
                HoshimiCulinaryMod.LOGGER.info("Eye Bone Block destroyed. Dropped item with UUID: {}; Respawn cooldown: {}", boneBlockEntity.getEyeBoneUUID(), boneBlockEntity.getRespawnCooldown());
            }
        }// Always call super so standard cleanup happens
        super.onRemove(state, level, pos, newState, movedByPiston);
    }

    // Cloning would likely create a new Eye Bone with a new UUID, but I think it's best if we prevent it from being cloneable entirely
    @Override
    public ItemStack getCloneItemStack(BlockState state, HitResult target, BlockGetter level, BlockPos pos, Player player) {
        return Blocks.AIR.defaultBlockState().getCloneItemStack(target, level, pos, player);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(FACING, context.getHorizontalDirection().getOpposite());
    }

    @NotNull
    @Override
    public VoxelShape getShape(BlockState state, BlockGetter level, BlockPos pos, CollisionContext context) {
        Direction direction = state.getValue(FACING);
        return (direction == Direction.NORTH || direction == Direction.SOUTH) ? FULL_NS : FULL_WE;
    }

    @Nullable
    @Override
    public <T extends BlockEntity> BlockEntityTicker<T> getTicker(Level level, BlockState state, BlockEntityType<T> type) {
        if (!level.isClientSide) {
            return (lvl, pos, blkState, t) -> {
                if (t instanceof EyeBoneBlockEntity eyeBoneBlockEntity) {
                    eyeBoneBlockEntity.tick(lvl, pos, blkState, eyeBoneBlockEntity);
                }
            };
        }
        return null;
    }
}
