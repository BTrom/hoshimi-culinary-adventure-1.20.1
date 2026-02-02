package com.botrom.hoshimi_ca_mod.entities.ai;

import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.navigation.GroundPathNavigation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.pathfinder.Path;

import java.util.Set;

public class CopperGolemNavigation extends GroundPathNavigation {
    private float requiredPathLength = 16.0F;
    private boolean canPathToTargetsBelowSurface = false;
    
    public CopperGolemNavigation(Mob mob, Level level) {
        super(mob, level);
    }

    public void setRequiredPathLength(float requiredPathLength) {
        this.requiredPathLength = requiredPathLength;
    }

    public float getRequiredPathLength() {
        return this.requiredPathLength;
    }

    public void setCanPathToTargetsBelowSurface(boolean canPathToTargetsBelowSurface) {
        this.canPathToTargetsBelowSurface = canPathToTargetsBelowSurface;
    }

    public boolean canPathToTargetsBelowSurface() {
        return this.canPathToTargetsBelowSurface;
    }

    @Override
    public Path createPath(BlockPos pos, int accuracy) {
        if (!this.canPathToTargetsBelowSurface) {
            return super.createPath(pos, accuracy);
        }

        LevelChunk chunk = this.level
            .getChunkSource()
            .getChunkNow(SectionPos.blockToSectionCoord(pos.getX()), SectionPos.blockToSectionCoord(pos.getZ()));
        if (chunk == null) {
            return null;
        }

        return this.createPathDirect(pos, accuracy);
    }

    private Path createPathDirect(BlockPos pos, int accuracy) {
        return super.createPath(Set.of(pos), 8, false, accuracy);
    }
}

