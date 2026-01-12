package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.entities.SeagullEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.phys.Vec3;

import java.util.EnumSet;

public class SeagullAIRevealTreasure extends Goal {

    private final SeagullEntity seagull;
    private BlockPos sitPos;

    public SeagullAIRevealTreasure(SeagullEntity entitySeagull) {
        this.seagull = entitySeagull;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.TARGET));
    }

    @Override
    public boolean canUse() {
        return seagull.getTreasurePos() != null && seagull.treasureSitTime > 0;
    }

    public void start(){
        seagull.aiItemFlag = true;
        sitPos = seagull.getSeagullGround(seagull.getTreasurePos());
    }

    public void stop(){
        sitPos = null;
        seagull.setSitting(false);
        seagull.aiItemFlag = false;
    }

    public void tick(){
        if(sitPos != null){
            if(seagull.distanceToSqr(new Vec3(sitPos.getX() + 0.5F, seagull.getY(), sitPos.getZ() + 0.5F)) > 2.5F){
                seagull.getMoveControl().setWantedPosition(sitPos.getX() + 0.5F, sitPos.getY() + 2, sitPos.getZ() + 0.5F, 1F);
                if(!seagull.onGround()){
                    seagull.setFlying(true);
                }
            }else{
                Vec3 vec = Vec3.upFromBottomCenterOf(sitPos, 1.0F);
                if(vec.subtract(seagull.position()).length() > 0.04F){
                    seagull.setDeltaMovement(vec.subtract(seagull.position()).scale(0.2F));
                }
                seagull.eatItem();
                seagull.treasureSitTime = Math.min(seagull.treasureSitTime, 100);
                seagull.setFlying(false);
                seagull.setSitting(true);
            }
        }
    }

}
