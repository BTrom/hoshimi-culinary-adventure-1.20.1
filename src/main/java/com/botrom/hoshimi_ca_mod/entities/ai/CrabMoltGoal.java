package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.entities.AbstractCrabEntity;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;

import java.util.Random;

public class CrabMoltGoal extends Goal {
    private final AbstractCrabEntity crab;
    private final double chance;
    private final Random random = new Random();
    private BlockState comfortBlock;
    private int moltingTimer = 0;

    public CrabMoltGoal(AbstractCrabEntity crab,double chance){
        this.crab = crab;
        this.chance = chance;
    }

    @Override
    public boolean canUse() {
        comfortBlock = crab.level().getBlockState(crab.blockPosition().below());
        return crab.getMoltingCooldown() <= 0 && random.nextDouble() <= chance && comfortBlock.is(ModTags.CRAB_COMFORT_BLOCKS) && crab.canMolt();
    }

    @Override
    public boolean canContinueToUse() {
        BlockState blockUnderCrab = crab.level().getBlockState(crab.blockPosition().below());
        return blockUnderCrab.is(ModTags.CRAB_COMFORT_BLOCKS) &&
                crab.getMoltingCooldown() == 0 && moltingTimer < 100;
    }

    @Override
    public void start(){
        moltingTimer = 0;
        crab.setIsMolting(true);
        crab.getNavigation().stop();
        super.start();
    }

    @Override
    public void tick(){
        moltingTimer++;
        double x = crab.getX();
        double y = crab.getY();
        double z = crab.getZ();
        crab.addEffect(new MobEffectInstance(MobEffects.REGENERATION,20,5,false,false),crab);
        if (moltingTimer <= 20 && crab.level() instanceof ServerLevel serverLevel) {
            serverLevel.sendParticles(ParticleTypes.HAPPY_VILLAGER, x, y+0.4, z, 5, random.nextGaussian() * 0.02, random.nextGaussian() * 0.02, random.nextGaussian() * 0.02, 0.1);
        } else {
            moltingTimer = 100;
            ItemEntity itemEntity = new ItemEntity(crab.level(),x, y,z, new ItemStack(ModItems.CRAB_SHELL.get()));
            crab.level().addFreshEntity(itemEntity);
        }
        super.tick();
    }

    @Override
    public void stop() {
        moltingTimer = 0;
        crab.setIsMolting(false);
        crab.setMoltingCooldown(random.nextInt(288000) + 14400);
        super.stop();
    }
}
