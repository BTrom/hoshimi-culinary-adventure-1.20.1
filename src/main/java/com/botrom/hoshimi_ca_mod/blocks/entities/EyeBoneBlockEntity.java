package com.botrom.hoshimi_ca_mod.blocks.entities;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.registry.ModBlockEntityTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.Connection;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoBlockEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.keyframe.event.CustomInstructionKeyframeEvent;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;

public class EyeBoneBlockEntity extends BlockEntity implements GeoBlockEntity {
    private UUID eyeBoneUUID;
    private int respawnCooldown = 0; // TODO: Remember to set this as 0 when testing is over
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    public boolean isClosedVisual = false;

    public EyeBoneBlockEntity(BlockPos blockPos, BlockState state) {
        super(ModBlockEntityTypes.EYE_BONE_BLOCK_ENTITY.get(), blockPos, state);
        HoshimiCulinaryMod.LOGGER.info("EyeBoneBlockEntity created at {} with UUID: {}", blockPos, eyeBoneUUID);
    }

    public void setEyeBoneUUID (UUID eyeBoneUUID) {
        this.eyeBoneUUID = eyeBoneUUID;
        setChanged();
        HoshimiCulinaryMod.LOGGER.info("EyeBoneBlockEntity at {} updated with UUID: {}", worldPosition, eyeBoneUUID);
    }

    public UUID getEyeBoneUUID () {
        return eyeBoneUUID;
    }

    public void setRespawnCooldown(int respawnCooldown) {
        this.respawnCooldown = respawnCooldown;
    }

    public int getRespawnCooldown() {
        return respawnCooldown;
    }

    public void setClosedVisual(boolean isOpen) {
        this.isClosedVisual = isOpen;
    }

    public boolean isClosedVisual() {
        return isClosedVisual;
    }

    public static void tick(Level level, BlockPos pos, BlockState state, EyeBoneBlockEntity blockEntity) {
        if (level.isClientSide) return;

        if (blockEntity.respawnCooldown > 0) {
            blockEntity.respawnCooldown--;
            blockEntity.setChanged();
            if (blockEntity.respawnCooldown == 0) {
                // Play sound
                level.sendBlockUpdated(pos, state, state, 3);
                level.playSound(null, pos, SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
                HoshimiCulinaryMod.LOGGER.info("EyeBoneBlockEntity at {} respawn cooldown finished!", pos);
            }
        }
    }

    @Override
    protected void saveAdditional(@NotNull CompoundTag tag) {
        super.saveAdditional(tag);
        if (eyeBoneUUID != null) {
            tag.putUUID(Chester.EYE_BONE_UUID_TAG, eyeBoneUUID);
            tag.putInt(Chester.RESPAWN_COOLDOWN_TAG, respawnCooldown);
        } else {
            HoshimiCulinaryMod.LOGGER.error("EyeBoneBlockEntity at {} has no UUID!", worldPosition);
        }
    }

    @Override
    public void load(@NotNull CompoundTag tag) {
        super.load(tag);
        if (tag.hasUUID(Chester.EYE_BONE_UUID_TAG)) {
            this.eyeBoneUUID = tag.getUUID(Chester.EYE_BONE_UUID_TAG);
        }
        if (tag.contains(Chester.RESPAWN_COOLDOWN_TAG)) {
            this.respawnCooldown = tag.getInt(Chester.RESPAWN_COOLDOWN_TAG);
        }
    }

    @Nullable
    @Override
    public Packet<ClientGamePacketListener> getUpdatePacket() {
        // Creates a packet using getUpdateTag()
        return ClientboundBlockEntityDataPacket.create(this);
    }

    @NotNull
    @Override
    public CompoundTag getUpdateTag() {
        // Serializes the data to be sent to the client
        return this.saveWithoutMetadata();
    }

    @Override
    public void onDataPacket(Connection net, ClientboundBlockEntityDataPacket pkt) {
        // Client receives packet and loads it
        this.load(pkt.getTag());
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        AnimationController<EyeBoneBlockEntity> controller = new AnimationController<>(this, "idle_controller", 1, this::predicate);
        controller.setCustomInstructionKeyframeHandler(this::handleInstructions);
        controllers.add(controller);
    }

    private PlayState predicate(AnimationState<EyeBoneBlockEntity> event) {
        // Always loop the idle animation.
        // The animation itself contains the keys that trigger the "open" and "close" events.
        return event.setAndContinue(RawAnimation.begin().then("animation.eye_bone.idle", Animation.LoopType.LOOP));
    }

    private void handleInstructions(CustomInstructionKeyframeEvent<EyeBoneBlockEntity> event) {
        String instruction = event.getKeyframeData().getInstructions();

        if (instruction.equals("open")) {
            this.isClosedVisual = false;
        } else if (instruction.equals("close")) {
            this.isClosedVisual = true;
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}