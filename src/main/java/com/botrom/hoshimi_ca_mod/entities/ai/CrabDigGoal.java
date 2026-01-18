package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.entities.AbstractCrabEntity;
import com.botrom.hoshimi_ca_mod.registry.ModLootModifiers;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;

import java.util.List;
import java.util.Objects;
import java.util.Random;

public class CrabDigGoal extends Goal {
    private final AbstractCrabEntity crab;
    private final double chance;
    private final Random random =new Random();
    private BlockState diggableBlock;
    private int diggingTimer =0;

    public CrabDigGoal(AbstractCrabEntity crab, double chance) {
        this.crab = crab;
        this.chance = chance;
    }

    @Override
    public boolean canUse() {
        diggableBlock  = crab.level().getBlockState(crab.blockPosition().below());
        List<Player> players = crab.level().getEntities(EntityType.PLAYER, crab.getBoundingBox().inflate(24), player -> true);
        boolean playerNearby = players.stream().anyMatch(player -> player.position().distanceToSqr(crab.position()) <= 576);
        return crab.getDiggingCooldown() <= 0 && random.nextDouble() <= chance && diggableBlock.is(ModTags.CRAB_DIGGABLE_BLOCKS) && crab.canDig() && playerNearby;
    }

    @Override
    public void start() {
        diggingTimer = 0;
        crab.setDigging(true);
        crab.getNavigation().stop();
        super.start();
    }

    @Override
    public void tick() {
            diggingTimer++;
            double x = crab.getX();
            double y = crab.getY();
            double z = crab.getZ();

            if (diggingTimer <= 20) {
                if (crab.level() instanceof ServerLevel serverLevel)
                    serverLevel.sendParticles(ParticleTypes.POOF, x, y, z, 3, 0.0, 0.0, 0.0, 0.0);
            } else {
                diggingTimer = 100;
                LootParams lootParams = new LootParams.Builder((ServerLevel) crab.level())
                        .withParameter(LootContextParams.BLOCK_STATE, diggableBlock)
                        .withParameter(LootContextParams.ORIGIN, crab.position())
                        .withParameter(LootContextParams.TOOL, ItemStack.EMPTY)
                        .withParameter(LootContextParams.THIS_ENTITY, crab)
                        .create(LootContextParamSets.BLOCK);
                LootTable lootTable = Objects.requireNonNull(crab.level().getServer()).getLootData().getLootTable(ModLootModifiers.CRAB_DIG_LOOT);
                List<ItemStack> loot = lootTable.getRandomItems(lootParams);

                for (ItemStack lootItem : loot) {
                    ItemEntity itemEntity = new ItemEntity(crab.level(), x, y, z, lootItem);
                    crab.level().addFreshEntity(itemEntity);
                }
            }
        super.tick();
    }

    @Override
    public boolean canContinueToUse() {
        BlockState blockUnderCrab = crab.level().getBlockState(crab.blockPosition().below());
        return blockUnderCrab.is(ModTags.CRAB_DIGGABLE_BLOCKS) &&
                crab.getDiggingCooldown() <= 0 && diggingTimer < 100;
    }

    @Override
    public void stop() {
        diggingTimer = 0;
        crab.setDigging(false);
        crab.setDiggingCooldown(random.nextInt(12000) + 1200);
        super.stop();
    }
}
