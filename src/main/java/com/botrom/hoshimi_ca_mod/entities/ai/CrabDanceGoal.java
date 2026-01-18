package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.entities.AbstractCrabEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.ChestBlockEntity;

public class CrabDanceGoal extends Goal {
    private final AbstractCrabEntity crab;

    public CrabDanceGoal(AbstractCrabEntity crab) {
        this.crab = crab;
    }

    @Override
    public boolean canUse() {
        int startX = (int) (crab.getX() - 5);
        int startY = (int) (crab.getY()-5);
        int startZ = (int) (crab.getZ() - 5);
        int endX = (int) (crab.getX() + 5);
        int endY = (int) (crab.getY() + 5);
        int endZ = (int) (crab.getZ() + 5);
        for (int x = startX; x <= endX; x++) {
            for (int y = startY; y <= endY; y++) {
                for (int z = startZ; z <= endZ; z++) {
                    BlockPos nearbyPos = new BlockPos(x, y, z);
                    Block chest = crab.level().getBlockState(nearbyPos).getBlock();
                    BlockEntity blockEntity = crab.level().getBlockEntity(nearbyPos);
                    if (chest == Blocks.CHEST && blockEntity instanceof ChestBlockEntity) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void start() {
        crab.setIsDancing(true);
        crab.getNavigation().stop();
        super.start();
    }

    @Override
    public void stop() {
        super.stop();
        crab.setIsDancing(false);
    }
}
