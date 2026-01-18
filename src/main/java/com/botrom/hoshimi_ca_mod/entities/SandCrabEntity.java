package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WallClimberNavigation;
import net.minecraft.world.entity.animal.Turtle;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraftforge.common.ForgeMod;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.*;
import software.bernie.geckolib.core.object.PlayState;
import software.bernie.geckolib.util.GeckoLibUtil;

import java.util.Random;

public class SandCrabEntity extends AbstractCrabEntity implements GeoEntity {

    private final AnimatableInstanceCache geoCache = GeckoLibUtil.createInstanceCache(this);

    public SandCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, Level level) {
        super(entityType, level, false,true);
        this.getAttribute(ForgeMod.STEP_HEIGHT_ADDITION.get()).setBaseValue(1.0F);
        this.setPathfindingMalus(BlockPathTypes.WATER,-1.0F);
    }

    public static AttributeSupplier.Builder setAttributes(){
        return createLivingAttributes()
                .add(Attributes.MAX_HEALTH,5)
                .add(Attributes.ARMOR,1)
                .add(Attributes.ATTACK_DAMAGE,1.0f)
                .add(Attributes.ATTACK_SPEED,1.0f)
                .add(Attributes.FOLLOW_RANGE,16.0f)
                .add(Attributes.ATTACK_KNOCKBACK,0f)
                .add(Attributes.MOVEMENT_SPEED,0.35f);
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(0, new PanicGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 2));
        this.goalSelector.addGoal(1, new AvoidEntityGoal<>(this, Player.class, 16.0F, 1.0D, 1.2D));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED) * 1.5, false));
        this.goalSelector.addGoal(3, new WaterAvoidingRandomStrollGoal(this, this.getAttributeValue(Attributes.MOVEMENT_SPEED)));
        this.goalSelector.addGoal(3, new LookAtPlayerGoal(this, Player.class, 6.0F));
        this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(1, new NearestAttackableTargetGoal<>(this, Turtle.class, false, (entity) -> entity instanceof AgeableMob && ((AgeableMob) entity).isBaby()));
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);
        if(itemStack.is(Items.GOLD_INGOT) && random.nextInt()<= 0.333){
            this.playSound(SoundEvents.GHAST_AMBIENT, 0.5F, 0.5F);
            itemStack.shrink(1);
            ItemEntity itemEntity = new ItemEntity(this.level(), this.getX(), this.getY(), this.getZ(), Items.GHAST_TEAR.getDefaultInstance());
            this.level().addFreshEntity(itemEntity);
            return InteractionResult.sidedSuccess(this.level().isClientSide);
        }else {
            return super.mobInteract(player, hand);
        }
    }

    @Override
    public boolean canBreatheUnderwater() {
        return super.canBreatheUnderwater();
    }

    @Override
    public ItemStack getBucketItemStack() {
        return new ItemStack(ModItems.SAND_CRAB_BUCKET.get());
    }

    public static boolean canSpawn(EntityType<? extends WaterAnimal> type, LevelAccessor level, MobSpawnType spawnReason, BlockPos pos, RandomSource random) {
        return level.getBlockState(pos.below()).is(ModTags.CRAB_SPAWN_BLOCKS);
    }

    @NotNull
    @Override
    protected PathNavigation createNavigation(@NotNull Level level) {
        return new WallClimberNavigation(this, level);
    }
    
    @Override
    public void tick(){
        super.tick();
        if(!this.level().isClientSide){
            this.setClimbingWall(this.horizontalCollision);
        }
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllers) {
        controllers.add(new AnimationController<>(this,"controller",10,this::predicate));
        controllers.add(new AnimationController<>(this,"attackcontroller",0,this::attackPredicate));
    }
    
    protected <E extends SandCrabEntity> PlayState predicate(final AnimationState<E> event) {
        if(event.isMoving()){
            event.getController().setAnimation(RawAnimation.begin().then("sand_crab.model.walk", Animation.LoopType.LOOP));
            event.getController().setAnimationSpeed(3.0D);
        } else{
            event.getController().setAnimation(RawAnimation.begin().then("sand_crab.model.idle", Animation.LoopType.LOOP));
        }
        return PlayState.CONTINUE;
    }
    
    protected <E extends SandCrabEntity> PlayState attackPredicate(final AnimationState<E> event) {
        if (this.swinging && event.getController().getAnimationState().equals(AnimationController.State.STOPPED)) {
            event.getController().forceAnimationReset();
            event.getController().setAnimation(RawAnimation.begin().then("sand_crab.model.attack", Animation.LoopType.PLAY_ONCE));
            this.swinging = false;
        }
        return PlayState.CONTINUE;
    }
    
    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return geoCache;
    }
}
