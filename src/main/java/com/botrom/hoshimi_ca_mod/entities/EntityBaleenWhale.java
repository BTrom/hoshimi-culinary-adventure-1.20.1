package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.entities.ai.BaleenWhaleFeedGoal;
import com.botrom.hoshimi_ca_mod.entities.ai.WhaleBreachGoal;
import com.botrom.hoshimi_ca_mod.entities.ai.WhaleSwimmingGoal;
import net.minecraft.core.Holder;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.Mth;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.control.SmoothSwimmingLookControl;
import net.minecraft.world.entity.ai.control.SmoothSwimmingMoveControl;
import net.minecraft.world.entity.ai.goal.*;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.ai.navigation.WaterBoundPathNavigation;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.pathfinder.BlockPathTypes;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.entity.PartEntity;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class EntityBaleenWhale extends Animal {

    private static final EntityDataAccessor<Boolean> IS_EATING = SynchedEntityData.defineId(EntityBaleenWhale.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Boolean> LONG_FINS = SynchedEntityData.defineId(EntityBaleenWhale.class, EntityDataSerializers.BOOLEAN);
    private static final EntityDataAccessor<Integer> VARIANT = SynchedEntityData.defineId(EntityBaleenWhale.class, EntityDataSerializers.INT);
    private static final EntityDataAccessor<Integer> SKIN = SynchedEntityData.defineId(EntityBaleenWhale.class, EntityDataSerializers.INT);
    public static HashMap<String, HashMap<Integer, ArrayList<ResourceLocation>>> TEXTURES_COMMON = new HashMap<>();
    public static HashMap<String, HashMap<Integer, ArrayList<ResourceLocation>>> TEXTURES_RARE = new HashMap<>();

    public int length;
    public EntityWhalePart[] whale_parts;
    public int ringBufferIndex = -1;
    public final double[][] ringBuffer = new double[64][3];
    public float yRotO; // Previous Y Rotation, needed for smoothing

    public int gulpProgress;

    static {
        // Initialize the map for this entity
        HashMap<Integer, ArrayList<ResourceLocation>> whaleTextures = new HashMap<>();

        // Create list for Variant 0
        ArrayList<ResourceLocation> variant0 = new ArrayList<>();
        variant0.add(new ResourceLocation("hoshimimod", "textures/entity/baleen_whale/fin.png")); // Ensure this file exists
        // Add more skins to variant0 if needed

        whaleTextures.put(0, variant0);

        // Register under the entity's registry name path (e.g., "baleen_whale")
        TEXTURES_COMMON.put("baleen_whale", whaleTextures);
    }

    public EntityBaleenWhale(EntityType<? extends Animal> type, Level worldIn) {
        super(type, worldIn);
        this.setPathfindingMalus(BlockPathTypes.WATER, 0.0F);
        this.moveControl = new SmoothSwimmingMoveControl(this, 85, 10, 0.02F, 0.1F, true);
        this.lookControl = new SmoothSwimmingLookControl(this, 10);

        // Define parts based on default scale, updateAttributes will refine this
        this.length = getMultiparts();
        this.whale_parts = new EntityWhalePart[this.length];
        for (int i = 0; i < this.length; i++) {
            this.whale_parts[i] = new EntityWhalePart(this, this.getBbWidth(), this.getBbHeight());
        }
    }

    @Override
    protected void defineSynchedData() {
        super.defineSynchedData();
        this.entityData.define(IS_EATING, false);
        this.entityData.define(LONG_FINS, false);
        this.entityData.define(VARIANT, 0); // Default variant 0
        this.entityData.define(SKIN, 0);
    }

    @Override
    protected PathNavigation createNavigation(Level pLevel) {
        return new WaterBoundPathNavigation(this, pLevel);
    }

    // --- Attributes ---
    public static AttributeSupplier.Builder registerAttributes() {
        return LivingEntity.createLivingAttributes()
                .add(Attributes.ATTACK_DAMAGE, 3.0D)
                .add(Attributes.ATTACK_KNOCKBACK, 1.6D)
                .add(Attributes.MOVEMENT_SPEED, 0.8D)
                .add(Attributes.FOLLOW_RANGE, 32.0D) // Increased range needed for water mobs
                .add(Attributes.MAX_HEALTH, 200.0D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .add(Attributes.ARMOR, 6D);
    }

    @Override
    public void registerGoals() {
        // Standard water goals + originals
        this.goalSelector.addGoal(0, new BreathAirGoal(this));
        this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.3D, false));
        // this.goalSelector.addGoal(2, new SmartMateGoal(this, 1D));
        this.goalSelector.addGoal(4, new WhaleSwimmingGoal(this));
        this.goalSelector.addGoal(5, new WhaleBreachGoal(this, 10));
        this.goalSelector.addGoal(5, new BaleenWhaleFeedGoal(this, 400));

        // Placeholder simple goals to ensure it moves if you don't have the custom ones yet:
//        this.goalSelector.addGoal(4, new RandomSwimmingGoal(this, 1.0D, 10));
        this.goalSelector.addGoal(6, new RandomLookAroundGoal(this));
        this.goalSelector.addGoal(7, new LookAtPlayerGoal(this, Player.class, 6.0F));

        this.targetSelector.addGoal(3, new HurtByTargetGoal(this));
    }

    @Override
    public void aiStep() {
        if (!this.isInWater() && this.onGround() && this.tickCount % 20 == 0) {
            this.playSound(getFlopSound(), this.getSoundVolume(), this.getVoicePitch());
        }
        super.aiStep();

        if (!this.level().isClientSide && this.level().getGameTime() % 4000 == 0) {
            this.heal(1.0F);
        }

        if (!this.isNoAi() && !this.isBaby()) {
            if (this.ringBufferIndex < 0) {
                for (int i = 0; i < this.ringBuffer.length; ++i) {
                    this.ringBuffer[i][0] = this.getYRot();
                    this.ringBuffer[i][1] = this.getY();
                }
            }
            this.ringBufferIndex++;
            if (this.ringBufferIndex == this.ringBuffer.length) {
                this.ringBufferIndex = 0;
            }

            // Replaced deprecated yRotO usage logic with current rotation wrapping
            // Note: In 1.20.1 yRotO is still available (this.yRotO)
            this.ringBuffer[this.ringBufferIndex][0] = this.yRotO + 0.5F * Mth.wrapDegrees(this.getYRot() - this.yRotO);
            this.ringBuffer[ringBufferIndex][1] = this.getY();

            Vec3[] avector3d = new Vec3[this.whale_parts.length];

            for (int j = 0; j < this.whale_parts.length; ++j) {
                this.whale_parts[j].collideWithNearbyEntities();
                avector3d[j] = new Vec3(this.whale_parts[j].getX(), this.whale_parts[j].getY(), this.whale_parts[j].getZ());
            }

            float f15 = (float) (this.getMovementOffsets(5, 1.0F)[1] - this.getMovementOffsets(10, 1.0F)[1]) * 10.0F * ((float) Math.PI / 180F);
            float f16 = Mth.cos(f15);
            float yaw = this.getYRot() * ((float) Math.PI / 180F);
            float pitch = this.getXRot() * ((float) Math.PI / 180F);
            float f3 = Mth.sin(yaw) * (1 - Math.abs(this.getXRot() / 90F));
            float f18 = Mth.cos(yaw) * (1 - Math.abs(this.getXRot() / 90F));

            double[] adouble = this.getMovementOffsets(5, 1.0F);

            float var = 1;
            for (int k = 0; k < getMultiparts(); ++k) {
                EntityWhalePart whale_part = this.whale_parts[k];

                double[] adouble1 = this.getMovementOffsets(5 + k * 2, 1.0F);
                float f7 = yaw + (float) Mth.wrapDegrees(adouble1[0] - adouble[0]) * ((float) Math.PI / 180F);
                float f20 = Mth.sin(f7) * (1 - Math.abs(this.getXRot() / 90F));
                float f21 = Mth.cos(f7) * (1 - Math.abs(this.getXRot() / 90F));
                float offset = k % 2 == 0 ? -1 : 1;
                if (k % 2 == 0) {
                    var++;
                }
                float f23 = var * 1.5F * offset;
                float value = Mth.clamp(pitch * k, (float)Math.toRadians(-40), (float)Math.toRadians(40));

                this.setPartPosition(whale_part, -(f3 * 0.5 + f20 * f23) * f16, value * -offset, (f18 * 0.5 + f21 * f23) * f16);

                this.whale_parts[k].xo = avector3d[k].x;
                this.whale_parts[k].yo = avector3d[k].y;
                this.whale_parts[k].zo = avector3d[k].z;
                this.whale_parts[k].xOld = avector3d[k].x;
                this.whale_parts[k].yOld = avector3d[k].y;
                this.whale_parts[k].zOld = avector3d[k].z;
            }
        }
        if (this.level().isClientSide && this.isFeeding() && this.gulpProgress < 50) {
            this.gulpProgress += 1;
        } else if (this.level().isClientSide && !this.isFeeding() && this.gulpProgress > 0) {
            this.gulpProgress -= 1;
        }
    }

    private void setPartPosition(EntityWhalePart part, double offsetX, double offsetY, double offsetZ) {
        part.setPos(this.getX() + offsetX * part.scale, this.getY() + offsetY * part.scale, this.getZ() + offsetZ * part.scale);
    }

    @Override
    public boolean isMultipartEntity() {
        return true;
    }

    @Override
    public PartEntity<?>[] getParts() {
        return this.whale_parts;
    }

    public double[] getMovementOffsets(int offset, float partialTicks) {
        if (this.isDeadOrDying()) {
            partialTicks = 0.0F;
        }
        partialTicks = 1.0F - partialTicks;
        int i = this.ringBufferIndex - offset & 63;
        int j = this.ringBufferIndex - offset - 1 & 63;
        double[] adouble = new double[3];
        double d0 = this.ringBuffer[i][0];
        double d1 = this.ringBuffer[j][0] - d0;
        adouble[0] = d0 + d1 * (double) partialTicks;
        d0 = this.ringBuffer[i][1];
        d1 = this.ringBuffer[j][1] - d0;
        adouble[1] = d0 + d1 * (double) partialTicks;
        adouble[2] = Mth.lerp(0.5F, this.ringBuffer[i][2], this.ringBuffer[j][2]);
        return adouble;
    }

    // --- Breeding & Interaction ---

    public boolean wantsToBreed() {
        // Inlined logic from super.wantsToBreed() and EntityUtils
        if (this.isFeeding()) return false; // Don't breed while feeding

        if (!this.isSleeping() && this.getAge() == 0 && this.getHealth() >= this.getMaxHealth()) {
            List<EntityBaleenWhale> list = this.level().getEntitiesOfClass(EntityBaleenWhale.class, this.getBoundingBox().inflate(6.0D, 4.0D, 6.0D));
            // Removed complex predicate, simple check:
            list.removeIf(input -> input == this || input.getAge() != 0 || input.getType() != this.getType());

            if (list.size() >= 1) {
                // Pregnancy logic usually simpler in vanilla, but keeping this:
                // Note: getPregnancyTime() was likely in ComplexMob. Hardcoding roughly:
                int pregnancyTime = 6000;
                this.setAge(pregnancyTime);
                list.get(0).setAge(pregnancyTime);
                return true;
            }
        }
        return false;
    }

    @Nullable
    @Override
    public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageableEntity) {
        // Replace with YOUR registry item
        // return ModEntities.BALEEN_WHALE.get().create(serverWorld);
        return (EntityBaleenWhale) this.getType().create(serverWorld);
    }

    @Override
    public InteractionResult mobInteract(Player player, InteractionHand hand) {
        ItemStack itemstack = player.getItemInHand(hand);

        if (hand == InteractionHand.MAIN_HAND && !this.level().isClientSide()) {
            // Debug stick for feeding animation testing
            if (itemstack.getItem() == Items.BLAZE_ROD) {
                this.setFeeding(!this.isFeeding());
                return InteractionResult.SUCCESS;
            }
        }
        return super.mobInteract(player, hand);
    }

    @Override
    public int getMaxAirSupply() {
        return 6000;
    }

    @Override
    protected int increaseAirSupply(int currentAir) {
        return super.getMaxAirSupply();
    }

    public boolean attackEntityPartFrom(EntityWhalePart whale_part, DamageSource source, float amount) {
        return this.hurt(source, amount);
    }

    // --- Data / Getters / Setters ---

    public boolean hasLongFins(){ return (this.entityData.get(LONG_FINS)); }
    private void setLongFins(boolean long_fins){ this.entityData.set(LONG_FINS, long_fins); }

    public int getVariant() { return this.entityData.get(VARIANT); }
    public void setVariant(int variant) { this.entityData.set(VARIANT, variant); }

    public boolean isFeeding() { return entityData.get(IS_EATING); }
    public void setFeeding(boolean bool) { entityData.set(IS_EATING, bool); }

    @Override
    public void addAdditionalSaveData(CompoundTag compound){
        super.addAdditionalSaveData(compound);
        compound.putBoolean("hasLongFins", this.hasLongFins());
        compound.putInt("Variant", this.getVariant());
        compound.putInt("Skin", this.getVariant());
    }

    @Override
    public void readAdditionalSaveData(CompoundTag compound){
        super.readAdditionalSaveData(compound);
        this.setLongFins(compound.getBoolean("hasLongFins"));
        this.setVariant(compound.getInt("Variant"));
        this.setVariant(compound.getInt("Skin"));

        // Initialize multiparts on load
        this.refreshDimensions();
    }

    // --- Model Scale Logic (Simulated) ---
        @Override
    public float getScale() {
        return WhaleVariant.byId(this.getVariant()).scale;
    }

    public int getMultiparts() {
        return 3 + (int)((this.getScale() - 1) * 4);
    }

    public boolean canBeTargeted() { return false; } // Whales shouldn't be targeted? logic from original

    protected SoundEvent getFlopSound() {
        return SoundEvents.GUARDIAN_FLOP;
    }

    public ResourceLocation getTexture() {
        ResourceLocation key = getType().builtInRegistryHolder().key().location();
        if (key != null) {
            String name = key.getPath();

            // Check RARE textures
            if (getSkin() > 99 && TEXTURES_RARE.containsKey(name) && TEXTURES_RARE.get(name).containsKey(getVariant())) {
                ArrayList<ResourceLocation> textures = TEXTURES_RARE.get(name).get(getVariant());
                return textures.get(Math.min(getSkin() - 100, textures.size() - 1));
            }

            // Check COMMON textures
            if (getVariant() >= 0 && TEXTURES_COMMON.containsKey(name) && TEXTURES_COMMON.get(name).containsKey(getVariant())) {
                ArrayList<ResourceLocation> textures = TEXTURES_COMMON.get(name).get(getVariant());
                if (textures != null && !textures.isEmpty()) {
                    return textures.get(Math.min(getSkin(), textures.size() - 1));
                }
            }
        }
        // Fallback to prevent crash if textures aren't loaded yet
        return new ResourceLocation("hoshimimod", "textures/entity/baleen_whale/fin.png"); // Point this to a real file!
    }

    public int getSkin() {
        return this.entityData.get(SKIN);
    }

    @Override
    public SpawnGroupData finalizeSpawn(ServerLevelAccessor level, @NotNull DifficultyInstance difficulty, @NotNull MobSpawnType reason, @Nullable SpawnGroupData spawnData, @Nullable CompoundTag dataTag) {
        Holder<Biome> biomeHolder = level.getBiome(this.blockPosition());

        // Find all variants that are allowed in this biome
        List<WhaleVariant> validVariants = new ArrayList<>();
        for (WhaleVariant variant : WhaleVariant.values()) {
            // Check if the current biome key matches any of the variant's allowed biomes
            if (variant.spawnBiomes.stream().anyMatch(biomeHolder::is)) {
                validVariants.add(variant);
            }
        }

        // If no specific match (e.g. we spawned in a modded ocean), fallback to Minke or random
        if (validVariants.isEmpty()) {
            validVariants.add(WhaleVariant.MINKE);
        }

        // Pick a random one from the valid list
        // Note: You can add weighted logic here (e.g., make Minke more common) if you want
        WhaleVariant selected = validVariants.get(this.random.nextInt(validVariants.size()));

        this.setVariant(selected.id);
        this.setLongFins(selected.hasLongFins);

        // IMPORTANT: Apply the size change immediately
        this.refreshDimensions();

        return super.finalizeSpawn(level, difficulty, reason, spawnData, dataTag);
    }

    @Override
    public EntityDimensions getDimensions(Pose pose) {
        // Get the base dimensions defined in the Registry (2.6 x 1.6)
        EntityDimensions base = super.getDimensions(pose);

        // Get the scale modifier from our Variant enum
        float scaleMod = WhaleVariant.byId(this.getVariant()).scale;

        return base.scale(scaleMod);
    }

    @Override
    public void onSyncedDataUpdated(EntityDataAccessor<?> key) {
        if (VARIANT.equals(key)) {
            this.refreshDimensions();
        }
        super.onSyncedDataUpdated(key);
    }

    // --- Inner Class: Whale Part ---
    public static class EntityWhalePart extends PartEntity<EntityBaleenWhale> {

        private final EntityDimensions size;
        public float scale = 1;

        public EntityWhalePart(EntityBaleenWhale parent, float sizeX, float sizeY) {
            super(parent);
            this.size = EntityDimensions.scalable(sizeX, sizeY);
            this.refreshDimensions();
        }

        protected void collideWithNearbyEntities() {
            List<Entity> entities = this.level().getEntities(this, this.getBoundingBox().inflate(0.2D, 0.0D, 0.2D));
            Entity parent = this.getParent();
            if (parent != null) {
                entities.stream().filter(entity -> entity != parent &&
                                !(entity instanceof EntityWhalePart && ((EntityWhalePart) entity).getParent() == parent) &&
                                entity.isPushable())
                        .forEach(entity -> entity.push(parent));
            }
        }

        @Override
        public InteractionResult interact(Player player, InteractionHand hand) {
            return this.getParent() == null ? InteractionResult.PASS : this.getParent().mobInteract(player, hand);
        }

        @Override
        public boolean isPickable() {
            return true;
        }

        @Override
        public boolean hurt(DamageSource source, float amount) {
            return !this.isInvulnerableTo(source) && this.getParent().attackEntityPartFrom(this, source, amount);
        }

        @Override
        protected void defineSynchedData() { }

        @Override
        protected void readAdditionalSaveData(CompoundTag compound) { }

        @Override
        protected void addAdditionalSaveData(CompoundTag compound) { }

        @Override
        public boolean is(Entity entityIn) {
            return this == entityIn || this.getParent() == entityIn;
        }

        @Override
        public Packet<ClientGamePacketListener> getAddEntityPacket() {
            throw new UnsupportedOperationException();
        }

        @Override
        public EntityDimensions getDimensions(Pose poseIn) {
            return this.size.scale(scale);
        }
    }

    public enum WhaleVariant {
        BLUE(0, 1.8F, false, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN),
        FIN(1, 1.6F, false, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN),
        GRAY(2, 1.3F, false, Biomes.COLD_OCEAN, Biomes.OCEAN),
        HUMPBACK(3, 1.3F, true, Biomes.DEEP_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN),
        MINKE(4, 1.0F, false, Biomes.COLD_OCEAN, Biomes.DEEP_COLD_OCEAN, Biomes.OCEAN, Biomes.DEEP_OCEAN, Biomes.FROZEN_OCEAN, Biomes.DEEP_FROZEN_OCEAN, Biomes.DEEP_LUKEWARM_OCEAN),
        SEI(5, 1.35F, false, Biomes.DEEP_COLD_OCEAN, Biomes.DEEP_OCEAN);

        final int id;
        final float scale;
        final boolean hasLongFins;
        final List<ResourceKey<Biome>> spawnBiomes;

        @SafeVarargs
        WhaleVariant(int id, float scale, boolean hasLongFins, ResourceKey<Biome>... biomes) {
            this.id = id;
            this.scale = scale;
            this.hasLongFins = hasLongFins;
            this.spawnBiomes = List.of(biomes);
        }

        public static WhaleVariant byId(int id) {
            for (WhaleVariant v : values()) {
                if (v.id == id) return v;
            }
            return BLUE; // Default fallback
        }
    }
}