package com.botrom.hoshimi_ca_mod.effects;

import com.botrom.hoshimi_ca_mod.registry.ModParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.LivingEntity;
import org.jetbrains.annotations.NotNull;

public class CorrosionEffect extends MobEffect {
	/**
	 * The player will emit acid particles that destroy incoming projectiles
	 * Used weapon will take extra durability damage
	 */
    public CorrosionEffect() {
		super(MobEffectCategory.BENEFICIAL, 0x4EFF35);
	}

	/**
	 * Checks whether the effect is ready to be applied this tick.
	 */
	@Override
	public boolean isDurationEffectTick(int duration, int amplifier) {
		return false;
	}

	public static void emitParticles(@NotNull LivingEntity entity, int amount) {
		if (entity.level() instanceof ServerLevel server) {
			for (int i = 0; i < (amount + 2) * 2; i ++) {
				server.sendParticles(
					ModParticleTypes.ACID.get(),
					entity.getRandomX(0.75D),
					entity.getRandomY() + 0.4D,
					entity.getRandomZ(0.75D),
					1,
					0D,
					0D,
					0D,
					0D
				);
			}
		}
	}
}