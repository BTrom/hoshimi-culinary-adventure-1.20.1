package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.entities.ai.CrabMoltGoal;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.MobType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.animal.Bucketable;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class AbstractCrabEntity extends WaterAnimal implements Bucketable {
    private static final EntityDataAccessor<Boolean> IS_DIGGING = SynchedEntityData.defineId(AbstractCrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_MOLTING = SynchedEntityData.defineId(AbstractCrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> IS_DANCING = SynchedEntityData.defineId(AbstractCrabEntity.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Byte> CRAB_FLAGS = SynchedEntityData.defineId(AbstractCrabEntity.class, EntityDataSerializers.BYTE);
    private static final EntityDataAccessor<Boolean> FROM_BUCKET = SynchedEntityData.defineId(AbstractCrabEntity .class, EntityDataSerializers.BOOLEAN);
    public static final String DIGGING_COOLDOWN_KEY = "DiggingCooldown";
    public static final String MOLTING_COOLDOWN_KEY = "MoltingCooldown";
    private int diggingCooldown;
    private int moltingCooldown = 144000;
    private final boolean canDig;
    private final boolean canMolt;

    public AbstractCrabEntity(EntityType<? extends AbstractCrabEntity> entityType, Level world, boolean canDig, boolean canMolt) {
        super(entityType, world);
        this.canDig = canDig;
        this.canMolt = canMolt;
    }

    @Override
    protected void registerGoals() {
        super.registerGoals();
        this.goalSelector.addGoal(4, new CrabMoltGoal(this, 0.25F));
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_DIGGING, false);
        this.entityData.define(IS_MOLTING, false);
        this.entityData.define(IS_DANCING, false);
        this.entityData.define(CRAB_FLAGS, (byte) 0);
        this.entityData.define(FROM_BUCKET, false);
    }

    @Override
    public int getMaxSpawnClusterSize() {
        return 3;
    }

    @Nullable
    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor levelAccessor, DifficultyInstance difficultyInstance, MobSpawnType mobSpawnType, @Nullable SpawnGroupData spawnGroupData, @Nullable CompoundTag compoundTag) {
        // Reimplement initialization for Forge
        return super.finalizeSpawn(levelAccessor, difficultyInstance, mobSpawnType, spawnGroupData, compoundTag);
    }

    @Override
    public void addAdditionalSaveData(CompoundTag compound) {
        compound.putInt("DiggingCooldown", diggingCooldown);
        compound.putInt("MoltingCooldown", moltingCooldown);
        compound.putBoolean("IsMolting", isMolting());
        compound.putBoolean("IsDancing", isDancing());
        super.addAdditionalSaveData(compound);
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound) {
        this.diggingCooldown = compound.getInt("DiggingCooldown");
        this.moltingCooldown = compound.getInt("MoltingCooldown");
        this.setIsMolting(compound.getBoolean("IsMolting"));
        this.setIsDancing(compound.getBoolean("IsDancing"));
        super.readAdditionalSaveData(compound);
    }

    @Override
    public void tick(){
        super.tick();
        if(this.getDiggingCooldown()>0){
            setDiggingCooldown(getDiggingCooldown()-1);
            if(this.isDigging()){
                this.setSpeed(0.0f);
            }
        }
        if(this.getMoltingCooldown()>0){
            setMoltingCooldown(getMoltingCooldown()-1);
            if(this.isMolting()){
                this.setSpeed(0.0f);
            }
        }
        if(!this.level().isClientSide && this.isInWater() && !this.isSwimming()){
            this.setClimbingWall(this.horizontalCollision);
        }
    }

    @NotNull
    @Override
    public MobType getMobType() {
        return MobType.ARTHROPOD;
    }

    @Override
    public boolean onClimbable() {
        return super.onClimbable();
    }

    @Override
    public boolean canBeCollidedWith() {
        return true;
    }

    public boolean isClimbingWall() {
        return this.entityData.get(CRAB_FLAGS) != 0;
    }

    public void setClimbingWall(boolean climbing) {
        byte flags = this.entityData.get(CRAB_FLAGS);
        if (climbing) {
            this.entityData.set(CRAB_FLAGS, (byte) (flags | 0x02));
        } else {
            this.entityData.set(CRAB_FLAGS, (byte) (flags & ~0x02));
        }
    }

    public boolean isDigging() {
        return this.entityData.get(IS_DIGGING);
    }

    public boolean isMolting() {
        return this.entityData.get(IS_MOLTING);
    }

    public boolean isDancing() {
        return this.entityData.get(IS_DANCING);
    }

    public boolean canDig() {
        return this.canDig;
    }

    public boolean canMolt() {
        return this.canMolt;
    }

    public int getDiggingCooldown() {
        return this.diggingCooldown;
    }

    public void setDiggingCooldown(int cooldown) {
        this.diggingCooldown = cooldown;
    }

    public int getMoltingCooldown() {
        return this.moltingCooldown;
    }

    public void setMoltingCooldown(int cooldown) {
        this.moltingCooldown = cooldown;
    }

    public void setDigging(boolean digging) {
        this.entityData.set(IS_DIGGING, digging);
    }

    public void setIsMolting(boolean molting) {
        this.entityData.set(IS_MOLTING, molting);
    }

    public void setIsDancing(boolean dancing) {
        this.entityData.set(IS_DANCING, dancing);
    }

    @Override
    public boolean fromBucket() {
        return this.entityData.get(FROM_BUCKET);
    }

    @Override
    public void setFromBucket(boolean fromBucket) {
        this.entityData.set(FROM_BUCKET, fromBucket);
    }

    @Override
    public void saveToBucketTag(ItemStack itemStack) {
        Bucketable.saveDefaultDataToBucketTag(this, itemStack);
    }

    @Override
    public void loadFromBucketTag(CompoundTag compoundTag) {
        Bucketable.loadDefaultDataFromBucketTag(this, compoundTag);
    }

    @Override
    public ItemStack getBucketItemStack() {
        return ModItems.GIANT_MUD_CRAB_BUCKET.get().getDefaultInstance();
    }

    @Override
    public SoundEvent getPickupSound() {
        return SoundEvents.BUCKET_FILL_FISH;
    }

    @Override
    protected InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemStack = player.getItemInHand(hand);

        if (itemStack.is(ModItems.CLAM.get()) || itemStack.is(ModItems.CLAM_MEAT.get())) {
            if (this.getHealth() < this.getMaxHealth()) {
                if (!player.getAbilities().instabuild) {
                    itemStack.shrink(1);
                }
                this.heal(4.0F);
            }
            if (!this.isDigging() && this.canDig()) {
                this.setDiggingCooldown(this.getDiggingCooldown() - 3600);
            }
            return InteractionResult.SUCCESS;
        } else {
            return Bucketable.bucketMobPickup(player, hand, this).orElse(super.mobInteract(player, hand));
        }
    }

    @Override
    public boolean removeWhenFarAway(double distanceSquared) {
        return !this.fromBucket() && !this.hasCustomName();
    }

    @Override
    public boolean canChangeDimensions() {
        return super.canChangeDimensions() || this.fromBucket();
    }
}
