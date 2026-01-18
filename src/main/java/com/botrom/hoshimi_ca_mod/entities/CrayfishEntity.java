package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;

public class CrayfishEntity extends AbstractCrabEntity implements GeoEntity, NeutralMob {
    
    private static final EntityDataAccessor<Boolean> IS_CRAZY = SynchedEntityData.defineId(CrayfishEntity.class, EntityDataSerializers.BOOLEAN);
    private static final UniformInt ANGER_TIME_RANGE = TimeUtil.rangeOfSeconds(10, 20);
    private int angerTime;
    @Nullable
    private UUID angryAt;
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public CrayfishEntity(EntityType<? extends AbstractCrabEntity> entityType, Level level) {
        super(entityType, level, false, false);
        this.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).setBaseValue(1.0F); // setStepHeight
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F); // setPathfindingPenalty
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 5)
                .add(Attributes.ARMOR, 1)
                .add(Attributes.ATTACK_DAMAGE, 2.0f)
                .add(Attributes.ATTACK_SPEED, 0.7f)
                .add(Attributes.FOLLOW_RANGE, 24.0f)
                .add(Attributes.ATTACK_KNOCKBACK, 0f)
                .add(Attributes.MOVEMENT_SPEED, 0.30f);
    }

    @Override
    public void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new MoonlightConfusion(this, 1.0F));
        this.goalSelector.addGoal(0, new CrayfishEscapeFromDangerGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 2.5));
        this.goalSelector.addGoal(2, new MeleeAttackGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 1.2, false));
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED)));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this, new Class[0]));
    }

    public static boolean canSpawn(EntityType<? extends WaterAnimal> type, LevelAccessor level, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        int topY = level.getSeaLevel() - 10;
        int bottomY = level.getSeaLevel() - 60;
        return pos.getY() >= bottomY && pos.getY() <= topY && level.getBlockState(pos.below()).is(ModTags.CRAB_SPAWN_BLOCKS) && (level.isWaterAt(pos) || level.isEmptyBlock(pos));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.getEntityData().define(IS_CRAZY, false);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        super.addAdditionalSaveData(compound);
        compound.putBoolean("IsCrazy", this.isCrazy());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        super.readAdditionalSaveData(compound);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.CRAYFISH_BUCKET.get());
    }
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 10, this::predicate));
        controllers.add(new AnimationController<>(this, "attackcontroller", 0, this::attackPredicate));
    }

    protected <E extends CrayfishEntity> PlayState predicate(final AnimationState<E> event) {
        if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("crayfish.model.walk", Animation.LoopType.LOOP));
            event.getController().setAnimationSpeed(3.0D);
        } else {
            event.getController().setAnimation(RawAnimation.begin().then("crayfish.model.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    protected <E extends CrayfishEntity> PlayState attackPredicate(final AnimationState<E> event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().then("crayfish.model.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }

    public boolean isCrazy() {
        return this.entityData.get(IS_CRAZY);
    }

    public void setCrazy(boolean bl) {
        this.entityData.set(IS_CRAZY, bl);
    }

    @Override
    public int getRemainingPersistentAngerTime() {
        return this.angerTime;
    }

    @Override
    public void setRemainingPersistentAngerTime(int time) { // setAngerTime
        this.angerTime = time;
    }

    @Override
    public @Nullable UUID getPersistentAngerTarget() {
        return this.angryAt;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID target) { // setAngryAt
        this.angryAt = target;
    }

    @Override
    public void startPersistentAngerTimer() { // chooseRandomAngerTime
        this.setRemainingPersistentAngerTime(ANGER_TIME_RANGE.sample(this.random));
    }

    static class MoonlightConfusion extends MoveToBlockGoal {
        private final CrayfishEntity crayfish;

        public MoonlightConfusion(CrayfishEntity crayfish, double speed) {
            super(crayfish, speed, 16, 2);
            this.crayfish = crayfish;
        }

        @Override
        public boolean canUse() {
            return this.crayfish.level().isNight() && this.crayfish.isInWater() && this.crayfish.level().dimensionType().moonPhase(this.crayfish.level().dayTime()) == 0;
        }

        @Override
        public void start() {
            this.crayfish.setCrazy(true);
            super.start();
        }

        @Override
        public boolean canContinueToUse() {
            return super.canContinueToUse();
        }

        @Override
        protected boolean isValidTarget(LevelReader levelReader, BlockPos pos) {
            BlockPos blockPos = pos.above();
            return levelReader.isEmptyBlock(blockPos) && levelReader.getBlockState(pos).isFaceSturdy(levelReader, pos, Direction.UP);
        }

        @Override
        public void stop() {
            this.crayfish.setCrazy(false);
            super.stop();
        }
    }

    static class CrayfishEscapeFromDangerGoal extends PanicGoal {
        public CrayfishEscapeFromDangerGoal(PathfinderMob mob, double speed) {
            super(mob, speed);
        }

        @Override
        public boolean shouldPanic() {
            return this.mob.isFreezing() || this.mob.isOnFire() || (this.mob.getHealth() < this.mob.getMaxHealth() * 0.5 && this.mob.getLastHurtByMob() != null);
        }
    }
}
