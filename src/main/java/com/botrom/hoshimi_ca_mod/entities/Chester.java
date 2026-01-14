package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.entities.ai.ChesterSitAi;
import com.botrom.hoshimi_ca_mod.entities.animations.ChesterAnimation;
import com.botrom.hoshimi_ca_mod.utils.ChesterInventory;
import com.syllient.livingchest.entity.ai.helper.ChesterMoveHelper;
import net.minecraft.client.renderer.EffectInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.FollowOwnerGoal;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.animatable.GeoEntity;
import software.bernie.geckolib.core.animatable.instance.AnimatableInstanceCache;
import software.bernie.geckolib.core.animation.AnimatableManager;

public class Chester extends TamableAnimal implements GeoEntity, MenuProvider {
    private static final EntityDataAccessor<Boolean> IS_MOUTH_OPEN = SynchedEntityData.defineId(Chester.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_MOVING = SynchedEntityData.defineId(Chester.class, EntityDataSerializers.BOOLEAN);
    private final ChesterInventory inventory = new ChesterInventory(this, 27);
//    private final ChesterAnimation animation = new ChesterAnimation(this);
    private BlockPos eyeBone;

    public Chester(EntityType<? extends Chester> type, Level level) {
        super(type, level);
        this.addEffect(new MobEffectInstance(MobEffects.REGENERATION, Integer.MAX_VALUE, 1, false, false));
//        this.field_70765_h = new ChesterMoveHelper(this);
//        this.field_70158_ak = true;
//        setTame(false);
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_MOUTH_OPEN, false);
        this.entityData.define(IS_MOVING, false);
    }

    @Override
    protected void registerGoals() {
        this.goalSelector.addGoal(1, new FloatGoal(this));
        this.goalSelector.addGoal(2, new ChesterSitAi(this));
        this.goalSelector.addGoal(3, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F, false));
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compoundTag) {
        ListTag listTag = new ListTag();


        super.addAdditionalSaveData(compoundTag);
    }

    public void openMouth() {

    }

    @Override
    public @Nullable AgeableMob getBreedOffspring(ServerLevel serverLevel, AgeableMob ageableMob) {
        return null;
    }

    @Override
    public @Nullable AbstractContainerMenu createMenu(int i, Inventory inventory, Player player) {
        return null;
    }

    @Override
    public void registerControllers(AnimatableManager.ControllerRegistrar controllerRegistrar) {

    }

    @Override
    public AnimatableInstanceCache getAnimatableInstanceCache() {
        return null;
    }
}