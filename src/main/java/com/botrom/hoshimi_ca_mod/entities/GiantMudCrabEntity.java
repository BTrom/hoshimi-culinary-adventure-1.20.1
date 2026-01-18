package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.entities.AbstractCrabEntity;
import com.botrom.hoshimi_ca_mod.entities.ai.CrabDigGoal;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.util.TimeUtil;
import net.minecraft.util.valueproviders.UniformInt;
import net.minecraft.world.Difficulty;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.MoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.monster.Slime;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.monster.Zombie;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.UUID;

// Note: Angerable maps to NeutralMob in Mojang mappings
public class GiantMudCrabEntity extends AbstractCrabEntity implements NeutralMob, GeoEntity {

    private static final UniformInt ANGER_TIME_RANGE = TimeUtil.rangeOfSeconds(40, 50);
    private int angerTime;
    @Nullable
    private UUID angryAt;
    protected final WaterBoundPathNavigation waterNavigation;
    protected final GroundPathNavigation landNavigation;
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public GiantMudCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, Level level) {
        super(entityType, level, true, true);
        this.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).setBaseValue(1.0F); // setStepHeight
        this.moveControl = new GiantMudCrabMoveControl(this);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F); // setPathfindingPenalty
        this.waterNavigation = new WaterBoundPathNavigation(this, level);
        this.landNavigation = new GroundPathNavigation(this, level);
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH, 20)
                .add(Attributes.ARMOR, 10)
                .add(Attributes.ATTACK_DAMAGE, 8.0f)
                .add(Attributes.ATTACK_SPEED, 1.2f)
                .add(Attributes.FOLLOW_RANGE, 32.0f)
                .add(Attributes.ATTACK_KNOCKBACK, 0f)
                .add(Attributes.MOVEMENT_SPEED, 0.4f);
    }

    @Override
    protected void registerGoals() { // initGoals
        super.registerGoals();

        // Goals
        this.goalSelector.addGoal(0, new GiantMudCrabEscapeFromDangerGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 1.5));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 2, false));
        this.goalSelector.addGoal(4, new WaterAvoidingRandomStrollGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED))); // WanderAround usually maps here, or RandomStrollGoal
        this.goalSelector.addGoal(4, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(4, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(5, new RandomSwimmingGoal(this, 1, 1)); // SwimAroundGoal
        this.goalSelector.addGoal(2, new CrabDigGoal(this, 0.35));

        // Targets
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Zombie.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Slime.class, true));
        this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Spider.class, true));
        // Assuming HairyCrabEntity and SandCrabEntity are your classes and successfully translated
        this.targetSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, SandCrabEntity.class, true));
        this.targetSelector.addGoal(0, new HurtByTargetGoal(this)); // RevengeGoal
    }

    @Override
    public boolean canBreatheUnderwater() { // shouldSwimInFluids / equivalent logic check
        return this.isTargetingUnderwater();
    }

    @Override
    public ItemStack getBucketItemStack() { // getBucketItem
        return new ItemStack(ModItems.GIANT_MUD_CRAB_BUCKET.get()); // Note: Forge items are usually RegistryObjects, so .get() is needed
    }

    // Note: In Forge, spawning registration is usually done in the Main class or ModEventBus,
    // but the logic here is static and can be called from there.
    public static boolean canSpawn(EntityType<? extends WaterAnimal> type, LevelAccessor level, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        int bottomY = level.getSeaLevel() - 12;
        return pos.getY() >= bottomY && level.getBlockState(pos.below()).is(ModTags.CRAB_SPAWN_BLOCKS) && (level.isWaterAt(pos) || level.isEmptyBlock(pos));
    }

    // tickWaterBreathingAir usually doesn't exist in Forge/Mojang mappings directly in the same way.
    // If this was to prevent drowning, NeutralMob handles some of it, but generally handled by WaterAnimal logic.

    @Override
    public void startPersistentAngerTimer() { // chooseRandomAngerTime
        this.setRemainingPersistentAngerTime(ANGER_TIME_RANGE.sample(this.random));
    }

    @Override
    public void setRemainingPersistentAngerTime(int time) { // setAngerTime
        this.angerTime = time;
    }

    @Override
    public int getRemainingPersistentAngerTime() { // getAngerTime
        return this.angerTime;
    }

    @Override
    public void setPersistentAngerTarget(@Nullable UUID target) { // setAngryAt
        this.angryAt = target;
    }

    @Nullable
    @Override
    public UUID getPersistentAngerTarget() { // getAngryAt
        return this.angryAt;
    }

    @Override
    public boolean doHurtTarget(@NotNull Entity entity) { // tryAttack
        if (entity instanceof LivingEntity livingEntity) {
            ItemStack chest = livingEntity.getItemBySlot(EquipmentSlot.CHEST);
            ItemStack leggings = livingEntity.getItemBySlot(EquipmentSlot.LEGS);
            ItemStack boots = livingEntity.getItemBySlot(EquipmentSlot.FEET);

            if (!chest.isEmpty() && chest.isDamageableItem()) {
                chest.hurtAndBreak(30, livingEntity, (e) -> e.broadcastBreakEvent(EquipmentSlot.CHEST));
            }
            if (!leggings.isEmpty() && leggings.isDamageableItem()) {
                leggings.hurtAndBreak(30, livingEntity, (e) -> e.broadcastBreakEvent(EquipmentSlot.LEGS));
            }
            if (!boots.isEmpty() && boots.isDamageableItem()) {
                boots.hurtAndBreak(30, livingEntity, (e) -> e.broadcastBreakEvent(EquipmentSlot.FEET));
            }
        }
        return super.doHurtTarget(entity);
    }

    boolean isTargetingUnderwater() {
        LivingEntity livingEntity = this.getTarget();
        return livingEntity != null && livingEntity.isInWater();
    }

    @Override
    public void tick() { // updateSwimming logic usually goes into tick or aiStep
        super.tick();
        if (!this.level().isClientSide) {
            if (this.isEffectiveAi() && this.isInWater() && this.isTargetingUnderwater()) {
                this.navigation = this.waterNavigation;
                this.setSwimming(true);
            } else {
                this.navigation = this.landNavigation;
                this.setSwimming(false);
            }
        }
    }

    @Override
    public void travel(Vec3 movementInput) {
        if (this.isEffectiveAi() && this.isInWater()) {
            this.moveRelative(0.01F, movementInput);
            this.move(MoverType.SELF, this.getDeltaMovement());
            this.setDeltaMovement(this.getDeltaMovement().scale(1.0)); // .multiply
        } else {
            super.travel(movementInput);
        }
    }

    // GeckoLib implementation
    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this, "controller", 10, this::predicate));
        controllers.add(new AnimationController<>(this, "attackcontroller", 0, this::attackPredicate));
    }

    protected <E extends GiantMudCrabEntity> PlayState predicate(final AnimationState<E> event) {
        if (this.canDig() && this.isDigging()) {
            event.getController().setAnimation(RawAnimation.begin().then("giant_mud_crab.model.dig", Animation.LoopType.PLAY_ONCE));
        } else if (this.isInWater() && this.isSwimming()) {
            event.getController().setAnimation(RawAnimation.begin().then("giant_mud_crab.model.swim", Animation.LoopType.LOOP));
            event.getController().setAnimationSpeed(2.5D);
        } else if (event.isMoving()) {
            event.getController().setAnimation(RawAnimation.begin().then("giant_mud_crab.model.walk", Animation.LoopType.LOOP));
            event.getController().setAnimationSpeed(3.0D);
        } else {
            event.getController().setAnimation(RawAnimation.begin().then("giant_mud_crab.model.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }

    protected <E extends GiantMudCrabEntity> PlayState attackPredicate(final AnimationState<E> event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            event.getController().forceAnimationReset();
            if (random.nextFloat() <= 0.5) {
                event.getController().setAnimation(RawAnimation.begin().then("giant_mud_crab.model.attack", Animation.LoopType.PLAY_ONCE));
            } else {
                event.getController().setAnimation(RawAnimation.begin().then("giant_mud_crab.model.attack2", Animation.LoopType.PLAY_ONCE));
            }
            this.swinging = false; // handSwinging
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    // Inner Classes

    static class GiantMudCrabEscapeFromDangerGoal extends PanicGoal { // EscapeDangerGoal -> PanicGoal
        public GiantMudCrabEscapeFromDangerGoal(PathfinderMob mob, double speed) {
            super(mob, speed);
        }

        @Override
        protected boolean shouldPanic() { // isInDanger
            return this.mob.isFreezing() || this.mob.isOnFire() || (this.mob.getHealth() < this.mob.getMaxHealth() * 0.2 && this.mob.getLastHurtByMob() != null);
        }
    }

    private static class GiantMudCrabMoveControl extends MoveControl {
        private final GiantMudCrabEntity crab;

        public GiantMudCrabMoveControl(GiantMudCrabEntity crab) {
            super(crab);
            this.crab = crab;
        }

        @Override
        public void tick() {
            LivingEntity livingEntity = this.crab.getTarget();
            if (this.crab.isTargetingUnderwater() && this.crab.isInWater()) {
                if (livingEntity != null && livingEntity.getY() > this.crab.getY()) {
                    this.crab.setDeltaMovement(this.crab.getDeltaMovement().add(0.0, 0.002, 0.0));
                }
                if (this.operation != Operation.MOVE_TO || this.crab.getNavigation().isDone()) {
                    this.crab.setSpeed(0.0F);
                    return;
                }
                double d = this.wantedX - this.crab.getX();
                double e = this.wantedY - this.crab.getY();
                double f = this.wantedZ - this.crab.getZ();
                double g = Math.sqrt(d * d + e * e + f * f);
                e /= g;
                float h = (float) (Mth.atan2(f, d) * 57.2957763671875) - 90.0F;
                this.crab.setYRot(this.rotlerp(this.crab.getYRot(), h, 90.0F)); // wrapDegrees -> rotlerp usually
                this.crab.yBodyRot = this.crab.getYRot();
                float i = (float) (this.speedModifier * this.crab.getAttributeValue(Attributes.MOVEMENT_SPEED));
                float j = Mth.lerp(0.125F, this.crab.getSpeed(), i);
                this.crab.setSpeed(j);
                this.crab.setDeltaMovement(this.crab.getDeltaMovement().add((double) j * d * 0.005, (double) j * e * 0.1, (double) j * f * 0.005));
            } else {
                if (!this.crab.onGround()) {
                    this.crab.setDeltaMovement(this.crab.getDeltaMovement().add(0.0, -0.008, 0.0));
                }
                super.tick();
            }
        }
    }
}