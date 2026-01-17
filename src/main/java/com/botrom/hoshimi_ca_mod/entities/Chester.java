package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.EyeBoneBlockEntity;
import com.botrom.hoshimi_ca_mod.entities.ai.ChesterPickupItemGoal;
import com.botrom.hoshimi_ca_mod.entities.ai.FollowEyeBoneGoal;
import com.botrom.hoshimi_ca_mod.items.EyeBoneBlockItem;
import com.botrom.hoshimi_ca_mod.registry.ModSounds;
import com.botrom.hoshimi_ca_mod.utils.compat.chester.ChesterMenu;
import com.botrom.hoshimi_ca_mod.utils.compat.chester.OpenChesterScreenPacket;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.*;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.minecraftforge.network.PacketDistributor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.keyframe.event.SoundKeyframeEvent;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public class Chester extends TamableAnimal implements ContainerListener, GeoEntity {

    private static final EntityDataAccessor<Optional<UUID>> EYE_BONE_UUID_DATA = SynchedEntityData.defineId(Chester.class, EntityDataSerializers.OPTIONAL_UUID);
    public static final String EYE_BONE_UUID_TAG = "EyeBoneUUID";
    public static final String EYE_BONE_OPEN_TAG = "EyeBoneOpen";
    public static final String RESPAWN_COOLDOWN_TAG = "RespawnCooldown";
    public static final String INVENTORY_TAG = "Inventory";
    public static final int MAX_RESPAWN_COOLDOWN = 200; // Ticks (Should be 24000)
//    private final UUID EYE_BONE_UUID;
    private final AnimatableInstanceCache cache = GeckoLibUtil.createInstanceCache(this);
    private int idleSoundTimes = 0;
    private int ticksIdling = 0;
    private boolean wasMouthOpen = false;
    private int soundCooldown = 15; // TODO: Remove

    private SimpleContainer inventory;
    private LazyOptional<?> itemHandler = null;
    private int fetchCooldown = 0;
    private boolean tryingToFetchItem;
    private boolean isInventoryOpen;

//    Chester has 3 times Wilson's health, so it should have 30 hearts, or 60 half hearts

    public Chester(EntityType<? extends TamableAnimal> type, Level level) {
        super(type, level);
        this.setPathfindingMalus(BlockPathTypes.LEAVES, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.FENCE, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.COCOA, -1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.setPathfindingMalus(BlockPathTypes.UNPASSABLE_RAIL, 0.0F);
        this.createInventory();
        HoshimiCulinaryMod.LOGGER.info("Chester Entity created at {}, {}, {}", this.blockPosition().getX(), this.blockPosition().getY(), this.blockPosition().getZ());
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(0, new FloatGoal(this));
        this.goalSelector.addGoal(1, new ChesterPickupItemGoal(this));
        this.goalSelector.addGoal(2, new FollowEyeBoneGoal(this, 1.0, 5.0F, 2.0F));
    }

    public static AttributeSupplier.Builder registerAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 60.0D)
                .add(Attributes.MOVEMENT_SPEED, 0.35D);
    }

    public void setLinkedEyeBoneUUID(UUID eyeBoneUUID) {
        this.entityData.set(EYE_BONE_UUID_DATA, Optional.ofNullable(eyeBoneUUID));
    }

    public UUID getLinkedEyeBoneUUID() {
        return this.entityData.get(EYE_BONE_UUID_DATA).orElse(null);
    }

    @Override
    public void die(DamageSource cause) {
        super.die(cause);

        if (!this.level().isClientSide && this.getLinkedEyeBoneUUID() != null) {
            UUID targetBoneId = this.getLinkedEyeBoneUUID();

            // 1. Try to find the Bone in a Player's Inventory
            for (Player player : this.level().players()) {
                if (updateBoneInInventory(player, targetBoneId)) {
                    return;
                }
            }

            List<ItemEntity> items = this.level().getEntitiesOfClass(ItemEntity.class, this.getBoundingBox().inflate(100));
            for (ItemEntity item : items) {
                if (FollowEyeBoneGoal.isBoneItem(item.getItem(), targetBoneId)) {
                    CompoundTag tag = item.getItem().getTag();
                    if (tag != null && tag.getUUID(Chester.EYE_BONE_UUID_TAG).equals(targetBoneId)) {
                        tag.putInt(Chester.RESPAWN_COOLDOWN_TAG, MAX_RESPAWN_COOLDOWN);
                        return;
                    }
                }
            }

            BlockPos chesterPos = this.blockPosition();
            int radius = 16;
            for (BlockPos pos : BlockPos.betweenClosed(chesterPos.offset(-radius, -radius, -radius), chesterPos.offset(radius, radius, radius))) {
                if (this.level().getBlockEntity(pos) instanceof EyeBoneBlockEntity eyeBoneBlockEntity) {
                    if (eyeBoneBlockEntity.getEyeBoneUUID().equals(targetBoneId)) {
                        eyeBoneBlockEntity.setRespawnCooldown(MAX_RESPAWN_COOLDOWN);
                        return;
                    }
                }
            }
        }
    }

    private boolean updateBoneInInventory(Player player, UUID targetId) {
        // Scan main inventory
        for (ItemStack stack : player.getInventory().items) {
            if (stack.getItem() instanceof EyeBoneBlockItem && stack.hasTag()) {
                if (stack.getTag().getUUID(Chester.EYE_BONE_UUID_TAG).equals(targetId)) {
                    stack.getTag().putInt(Chester.RESPAWN_COOLDOWN_TAG, MAX_RESPAWN_COOLDOWN);
                    return true;
                }
            }
        }
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel level, AgeableMob mob) {
        return null;
    }

    //override tame logic to prevent the advancement for taming a mob to be granted
    @Override
    public void tame(Player player) {
//        this.setTame(true);
//        this.setOwnerUUID(player.getUUID());
    }

    //no attacking
    @Override
    public boolean wantsToAttack(LivingEntity owner, LivingEntity target) {
        return false;
    }

    @Override
    public boolean removeWhenFarAway(double dist) {
        return false;
    }

    @Override
    public boolean causeFallDamage(float dist, float mult, DamageSource source) {
        return false;
    }

	@Override
	public void checkDespawn() {
	}

	@Override
	public boolean canBeLeashed(Player player) {
		return false;
	}

	@Override
	public boolean isIgnoringBlockTriggers() {
		return true;
	}

	@Override
	public boolean isSteppingCarefully() {
		return true;
	}

    //-----------------------------------------//
    //                SAVE DATA                //
    //-----------------------------------------//

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(EYE_BONE_UUID_DATA, Optional.empty());
    }

    @Override
    public void addAdditionalSaveData(@NotNull CompoundTag tag) {
        super.addAdditionalSaveData(tag);
        ListTag listtag = new ListTag();

        tag.putUUID(EYE_BONE_UUID_TAG, this.getLinkedEyeBoneUUID() == null ? UUID.randomUUID() : this.getLinkedEyeBoneUUID());

        for (int i = 0; i < this.inventory.getContainerSize(); ++i) {
            ItemStack itemstack = this.inventory.getItem(i);
            if (!itemstack.isEmpty()) {
                CompoundTag compoundtag = new CompoundTag();
                compoundtag.putByte("Slot", (byte) i);
                itemstack.save(compoundtag);
                listtag.add(compoundtag);
            }
        }

        tag.put("Items", listtag);
    }

    @Override
    public void readAdditionalSaveData(@NotNull CompoundTag tag) {
        super.readAdditionalSaveData(tag);
        ListTag listtag = tag.getList("Items", 10);

        this.setLinkedEyeBoneUUID(tag.getUUID(EYE_BONE_UUID_TAG));

        for (int i = 0; i < listtag.size(); ++i) {
            CompoundTag compoundtag = listtag.getCompound(i);
            int j = compoundtag.getByte("Slot") & 255;
            if (j < this.inventory.getContainerSize()) {
                this.inventory.setItem(j, ItemStack.of(compoundtag));
            }
        }
    }

    //------------------------------------------//
    //            INVENTORY HANDLING            //
    //------------------------------------------//

    private void createInventory() {
        SimpleContainer simplecontainer = this.inventory;
        this.inventory = new SimpleContainer(27);
        if (simplecontainer != null) {
            simplecontainer.removeListener(this);
            int i = Math.min(simplecontainer.getContainerSize(), this.inventory.getContainerSize());

            for (int j = 0; j < i; ++j) {
                ItemStack itemstack = simplecontainer.getItem(j);
                if (!itemstack.isEmpty()) {
                    this.inventory.setItem(j, itemstack.copy());
                }
            }
        }

        this.inventory.addListener(this);
        this.itemHandler = LazyOptional.of(() -> new InvWrapper(this.inventory));
    }

    public SimpleContainer getInventory() {
        return this.inventory;
    }

    @Override
    public void containerChanged(Container container) {}

    public boolean hasInventoryChanged(Container container) {
        return this.inventory != container;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(Capability<T> capability, @Nullable Direction facing) {
        if (this.isAlive() && capability == ForgeCapabilities.ITEM_HANDLER && this.itemHandler != null)
            return this.itemHandler.cast();
        return super.getCapability(capability, facing);
    }

    @Override
    public void invalidateCaps() {
        super.invalidateCaps();
        if (this.itemHandler != null) {
            LazyOptional<?> oldHandler = this.itemHandler;
            this.itemHandler = null;
            oldHandler.invalidate();
        }
    }

    //------------------------------------------//
    //                   MISC                   //
    //------------------------------------------//

    public boolean isTryingToFetchItem() {
        return this.tryingToFetchItem;
    }

    public void setTryingToFetchItem(boolean fetch) {
        this.tryingToFetchItem = fetch;
    }

    public int getFetchCooldown() {
        return this.fetchCooldown;
    }

    public void setFetchCooldown(int cooldown) {
        this.fetchCooldown = cooldown;
    }

    public boolean isInventoryOpen() {
        return this.isInventoryOpen;
    }

    public void setInventoryOpen(boolean open) {
        this.isInventoryOpen = open;
    }

    @Override
    public void aiStep() {
        super.aiStep();

        if (this.fetchCooldown > 0) {
            this.fetchCooldown--;
        }

        if (this.isInSittingPose() && this.tickCount % 10 == 0) {
            this.level().addParticle(ParticleTypes.NOTE,
                    this.getX() + (this.getRandom().nextDouble() - 0.5D) * this.getBbWidth(),
                    this.getY() + this.getEyeHeight() + 0.25D,
                    this.getZ() + (this.getRandom().nextDouble() - 0.5D) * this.getBbWidth(),
                    this.getRandom().nextDouble(),
                    0.0D,
                    0.0D);
        }
    }

    public int getSoundCooldown() {
        return this.soundCooldown;
    }

    public void setSoundCooldown(int cooldown) {
        this.soundCooldown = cooldown;
    }

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource pDamageSource) {
        return ModSounds.CHESTER_HURT.get();
    }

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.CHESTER_DEATH.get();
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        if (this.isAlive()) {
            ItemStack stack = player.getItemInHand(hand);
            if (stack.is(Items.NAME_TAG)) return InteractionResult.PASS;

                this.level().gameEvent(player, GameEvent.CONTAINER_OPEN, player.blockPosition());
                //prevents sound from playing 4 times (twice on server only). Apparently interactAt fires 4 times????
                if (this.getSoundCooldown() == 0) {
                    this.playSound(SoundEvents.CHEST_OPEN, 0.5F, this.getRandom().nextFloat() * 0.1F + 0.9F);
                    this.setSoundCooldown(5);
                }
                if (!this.level().isClientSide()) {
                    ServerPlayer sp = (ServerPlayer) player;
                    if (sp.containerMenu != sp.inventoryMenu) sp.closeContainer();

                    sp.nextContainerCounter();
                    HoshimiCulinaryMod.NETWORK.send(PacketDistributor.PLAYER.with(() -> sp), new OpenChesterScreenPacket(sp.containerCounter, this.getId()));
                    sp.containerMenu = new ChesterMenu(sp.containerCounter, sp.getInventory(), this.inventory, this);
                    sp.initMenu(sp.containerMenu);
                    this.isInventoryOpen = true; // TODO: Replace with mouth logic
                    MinecraftForge.EVENT_BUS.post(new PlayerContainerEvent.Open(sp, sp.containerMenu));
                }
            return InteractionResult.sidedSuccess(this.level().isClientSide());
        }
        return InteractionResult.PASS;
    }

    @Override
    public void remove(RemovalReason reason) {
        if (reason == RemovalReason.KILLED) {
            this.getInventory().removeAllItems().forEach(this::spawnAtLocation);
            this.spawnAnim();
//            this.playSound(ModSounds.LUGGAGE_KILLED.get(), 8.0F, 1.0F);
        }
        super.remove(reason);
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        // 1. Idle Controller (Handles looking around when standing still)
        AnimationController<Chester> idleController = new AnimationController<>(this, "idle_controller", 0, this::predicateIdle);
        idleController.setSoundKeyframeHandler(this::handleSoundKeyframes);
        controllers.add(idleController);
        // 2. Jump Controller (Handles movement animations)
        AnimationController<Chester> jumpController = new AnimationController<>(this, "jump_controller", 0, this::predicateJump);
        jumpController.setSoundKeyframeHandler(this::handleSoundKeyframes);
        controllers.add(jumpController);
        // 3. Mouth Controller (Handles opening/closing)
        AnimationController<Chester> openController = new AnimationController<>(this, "open_controller", 0, this::predicateMouth);
        openController.setSoundKeyframeHandler(this::handleSoundKeyframes);
        controllers.add(openController);
    }

    private PlayState predicateIdle (AnimationState<Chester> event) {
        // Logic: If we are jumping, we are NOT idling.
        if (event.isMoving() || !this.onGround()) {
            this.ticksIdling = 0;
            return PlayState.STOP;
        }

        this.ticksIdling++;

        // Reset sound counter if we just started idling or mouth changed
        if (this.isInventoryOpen != this.wasMouthOpen || this.ticksIdling < 5) {
            this.idleSoundTimes = 0;
        }
        this.wasMouthOpen = this.isInventoryOpen; // TODO: Replace with mouth logic

        // Only play the idle look-around if we've been still for a bit
        if (this.ticksIdling >= 5) {
            event.getController().setAnimationSpeed(1.1);
            return event.setAndContinue(RawAnimation.begin().then("animation.chester.idle", Animation.LoopType.LOOP));
        }
        return PlayState.STOP;
    }

    private PlayState predicateJump (AnimationState<Chester> event) {
        // BUG FIX: Strictly check movement. If moving, we JUMP. If not, we STOP.
        // We use a small threshold (0.01) because 'isMoving' can sometimes be finicky.
        boolean isMoving = event.isMoving() && this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6;

        if (isMoving && this.onGround() && !this.isInventoryOpen) {
            // Priority: Start Jump -> Loop Jump
            // The controller naturally transitions to the next one in the chain
            return event.setAndContinue(RawAnimation.begin()
                    .then("animation.chester.init_jump", Animation.LoopType.PLAY_ONCE)
                    .then("animation.chester.jump", Animation.LoopType.LOOP));
        } else if (!isMoving && this.onGround()) {
            // If we were jumping but just stopped, play the landing animation
            // We check if the CURRENT animation is 'jump' or 'init_jump' to avoid spamming 'stop_jump' while standing still
            String currentAnim = event.getController().getCurrentRawAnimation() != null ? event.getController().getCurrentAnimation().animation().name() : "";

            if (currentAnim.equals("animation.chester.jump") || currentAnim.equals("animation.chester.init_jump")) {
                return event.setAndContinue(RawAnimation.begin().then("animation.chester.stop_jump", Animation.LoopType.PLAY_ONCE));
            }
        }

        return PlayState.CONTINUE; // Let the 'stop_jump' finish playing if it's running
    }

    private PlayState predicateMouth (AnimationState<Chester> event) {
        if (this.ticksIdling < 5) return PlayState.STOP;

        if (this.isInventoryOpen) {
            return event.setAndContinue(RawAnimation.begin()
                    .then("animation.chester.open_mouth", Animation.LoopType.PLAY_ONCE)
                    .then("animation.chester.idle_mouth", Animation.LoopType.PLAY_ONCE));
        } else {
            // If we are currently in the 'open' state, play close.
            String currentAnim = event.getController().getCurrentRawAnimation() != null ? event.getController().getCurrentAnimation().animation().name() : "";
            if (currentAnim.equals("animation.chester.idle_mouth") || currentAnim.equals("animation.chester.open_mouth")) {
                return event.setAndContinue(RawAnimation.begin().then("animation.chester.close_mouth", Animation.LoopType.PLAY_ONCE));
            }
        }
        return PlayState.CONTINUE;
    }

    private void handleSoundKeyframes (SoundKeyframeEvent<Chester> event) {
        // Map string keys from Blockbench to actual code execution
        String soundName = event.getKeyframeData().getSound();
        Level level = event.getAnimatable().level();
        HoshimiCulinaryMod.LOGGER.info("Trying to play sound: {}", soundName);

        // Note: Replace 'ModSounds.CHESTER_...' with your actual SoundEvents
        switch (soundName) {
            case "idle" -> {
                this.idleSoundTimes++;
                float volume = Math.max(0.025F, 0.1F - (float)this.idleSoundTimes * 0.005F);
                this.playSound(ModSounds.CHESTER_IDLE.get(), volume, 1.0F);

                HoshimiCulinaryMod.LOGGER.info("Trying to play idle sound???");
            }
            case "jump" -> this.playSound(ModSounds.CHESTER_JUMP.get(), 0.15F, 1.0F);
            case "open_mouth" -> this.playSound(ModSounds.CHESTER_OPEN_MOUTH.get(), 0.5F, 1.0F);
            case "close_mouth" -> this.playSound(ModSounds.CHESTER_CLOSE_MOUTH.get(), 0.5F, 1.0F);
        }
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.cache;
    }
}
