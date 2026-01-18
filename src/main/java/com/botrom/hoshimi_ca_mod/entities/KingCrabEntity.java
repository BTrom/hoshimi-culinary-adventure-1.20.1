package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.entities.ai.CrabDigGoal;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.BlockPos;
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

public class KingCrabEntity extends AbstractCrabEntity implements NeutralMob, GeoEntity {

    private static final UniformInt ANGER_TIME_RANGE = TimeUtil.rangeOfSeconds(10, 20);
    private int angerTime;
    @Nullable
    private UUID angryAt;
    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public KingCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, Level level) {
        super(entityType, level, true,true);
        this.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).setBaseValue(1.25F); // setStepHeight
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
    }

    public static AttributeSupplier.Builder setAttributes() {
        return Mob.createMobAttributes()
                .add(Attributes.MAX_HEALTH,15)
                .add(Attributes.ATTACK_DAMAGE,4.0f)
                .add(Attributes.ATTACK_SPEED,1.0f)
                .add(Attributes.FOLLOW_RANGE,24.0f)
                .add(Attributes.ATTACK_KNOCKBACK,0f)
                .add(Attributes.MOVEMENT_SPEED,0.35f);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(1, new AttackGoal());
        this.goalSelector.addGoal(1, new TryFindWaterGoal(this));
        this.goalSelector.addGoal(0, new KingCrabEscapeFromDangerGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 2));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED)));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(2, new CrabDigGoal(this, 0.10));
        this.targetSelector.addGoal(1, new HurtByTargetGoal(this));
    }

    @Override
    public boolean canBreatheUnderwater() {
        return super.canBreatheUnderwater();
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.KING_CRAB_BUCKET.get());
    }

    public static boolean canSpawn(EntityType<? extends WaterAnimal> type, LevelAccessor level, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        int topY = level.getSeaLevel() - 10;
        int bottomY = level.getSeaLevel() - 60;
        return pos.getY() >= bottomY && pos.getY() <= topY && level.getBlockState(pos.below()).is(ModTags.CRAB_SPAWN_BLOCKS) && (level.isWaterAt(pos) || level.isEmptyBlock(pos));
    }

    @Override
    public void startPersistentAngerTimer() {
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
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller",10,this::predicate));
        controllers.add(new AnimationController<>(this,"attackcontroller",0,this::attackPredicate));
    }

    protected <E extends KingCrabEntity> PlayState predicate(final AnimationState<E> event) {
        if(this.isDigging() && this.canDig()){
            event.getController().setAnimation(RawAnimation.begin().then("king_crab.model.dig", Animation.LoopType.PLAY_ONCE));
        } else if(event.isMoving()){
            event.getController().setAnimation(RawAnimation.begin().then("king_crab.model.walk", Animation.LoopType.LOOP));
            event.getController().setAnimationSpeed(3.0D);
        } else{
            event.getController().setAnimation(RawAnimation.begin().then("king_crab.model.idle", Animation.LoopType.LOOP));
        }

        return PlayState.CONTINUE;
    }

    protected <E extends KingCrabEntity> PlayState attackPredicate(final AnimationState<E> event){
        if(this.swinging && event.getController().getAnimationState().equals(AnimationController.State.STOPPED)){
            event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().then("king_crab.model.attack",Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return this.geoCache;
    }

    static class KingCrabEscapeFromDangerGoal extends PanicGoal {

        public KingCrabEscapeFromDangerGoal(PathfinderMob mob, double speed) {
            super(mob, speed);
        }

        @Override
        protected boolean shouldPanic() { // isInDanger
            return this.mob.isFreezing() || this.mob.isOnFire() || (this.mob.getHealth() < this.mob.getMaxHealth() * 0.2 && this.mob.getLastHurtByMob() != null);
        }
    }

    private class AttackGoal extends MeleeAttackGoal {
        public AttackGoal() {
            super(KingCrabEntity.this, 1.0f, true);
        }

        protected double getSquaredMaxAttackDistance(LivingEntity entity) {
            float f = KingCrabEntity.this.getBbWidth() - 0.5F;
            return (f * 2.0F * f * 2.0F + entity.getBbWidth());
        }
    }
}
