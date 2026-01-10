package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.animal.AbstractFish;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class PlatinumBass extends AbstractFish {
	public final AnimationState swimAnimationState = new AnimationState();
	public final AnimationState drownAnimationState = new AnimationState();

	public PlatinumBass(EntityType<? extends AbstractFish> type, Level level) {
		super(type, level);
	}

	public static AttributeSupplier.@NotNull Builder createAttributes() {
		return Mob.createMobAttributes()
			.add(Attributes.MOVEMENT_SPEED, 1D)
			.add(Attributes.MAX_HEALTH, 8D);
	}

	@Override
	protected @NotNull SoundEvent getFlopSound() {
		return SoundEvents.SALMON_FLOP;
	}

	@Nullable
	@Override
	protected SoundEvent getDeathSound() {
		return SoundEvents.SALMON_DEATH;
	}

	@Nullable
	@Override
	protected SoundEvent getHurtSound(@NotNull DamageSource source) {
		return SoundEvents.SALMON_HURT;
	}

	@Override
	public @NotNull ItemStack getBucketItemStack() {
		return ModItems.PLATINUM_BASS_BUCKET.get().getDefaultInstance();
	}

	private boolean isMovingInWater() {
		return this.getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D && this.isInWaterOrBubble();
	}

	@Override
	public void tick() {
		if (this.level().isClientSide()) {
			if (this.isDeadOrDying() || this.getAirSupply() < this.getMaxAirSupply() - 20) {
				this.drownAnimationState.startIfStopped(this.tickCount);
			} else {
				this.drownAnimationState.stop();
				if (this.isMovingInWater()) {
					this.swimAnimationState.startIfStopped(this.tickCount);
				} else {
					this.swimAnimationState.stop();
				}
			}
		}
		super.tick();
	}
}