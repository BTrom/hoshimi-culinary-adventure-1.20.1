package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.EyeBoneBlockEntity;
import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;
import org.apache.logging.log4j.Level;

import java.util.EnumSet;
import java.util.List;
import java.util.UUID;

public class FollowEyeBoneGoal extends Goal {
    private static final int SEARCHING_RANGE = 100;
    private static final int TELEPORT_WHEN_DISTANCE_IS = 64;
    private static final int MIN_HORIZONTAL_DISTANCE_FROM_EYE_WHEN_TELEPORTING = 3;
    private static final int MAX_HORIZONTAL_DISTANCE_FROM_EYE_WHEN_TELEPORTING = 5;
    private static final int MAX_VERTICAL_DISTANCE_FROM_EYE_WHEN_TELEPORTING = 1;
    private static final int RECALC_COOLDOWN = 10;
    private static final int MAX_LOGGER_FREQUENCY = 10;
    private static int loggerFrequency = 0;
    private final double speedModifier;
    private final float stopDistance;
    private final float startDistance;
    private final Chester chester;

    private Vec3 targetPos;
    private int recalcCooldown;

    public FollowEyeBoneGoal(Chester chester, double speedModifier, float startDistance, float stopDistance) {
        this.chester = chester;
        this.speedModifier = speedModifier;
        this.startDistance = startDistance;
        this.stopDistance = stopDistance;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.JUMP));
    }


    @Override
    public boolean canUse() {
        // 1. If Chester doesn't have a linked UUID, he can't follow anything.
        if (this.chester.getLinkedEyeBoneUUID() == null) {
//            if (loggerFrequency == 0)
//                HoshimiCulinaryMod.LOGGER.info("Chester doesn't have a linked UUID!");
            return false;
        }

        // 2. Find the target location (Player, ItemEntity, or Block)
        this.targetPos = findEyeBoneLocation();

        // 3. If no target found, or target is too close, don't move.
        if (this.targetPos == null) {
            return false;
        }

        return this.chester.distanceToSqr(this.targetPos) > (this.startDistance * this.startDistance);
    }

    @Override
    public boolean canContinueToUse() {
        // Continue if we have a target, it's far enough, and we aren't stuck
        return this.targetPos != null &&
                this.chester.distanceToSqr(this.targetPos) > (this.stopDistance * this.stopDistance) &&
                !this.chester.getNavigation().isStuck();
    }

    @Override
    public void start() {
        this.recalcCooldown = 0;
    }

    @Override
    public void tick() {
        // Recalculate path periodically (every 10 ticks) to save performance
        if (--this.recalcCooldown <= 0) {
            this.recalcCooldown = RECALC_COOLDOWN;
            this.targetPos = findEyeBoneLocation();

            if (this.targetPos != null) {
//                if (loggerFrequency == 0)
//                    HoshimiCulinaryMod.LOGGER.info("Traveling to {}...", targetPos);
                this.chester.getNavigation().moveTo(targetPos.x, targetPos.y, targetPos.z, this.speedModifier);
            }
        }
    }

    private Vec3 findEyeBoneLocation() {
        UUID targetUUID = this.chester.getLinkedEyeBoneUUID();
        boolean logEnabled = loggerFrequency == 0;
//        if (logEnabled)
//            HoshimiCulinaryMod.LOGGER.info("Searching for Eye Bone with UUID: {}...", targetUUID);

        // PRIORITY 1: Is a Player holding it?
        // Note: This checks main hand and offhand. You might want to iterate full inventory.
        List<Player> players = this.chester.level().getEntitiesOfClass(Player.class, this.chester.getBoundingBox().inflate(SEARCHING_RANGE));

        for (Player player : players) {
            if (hasBone(player, targetUUID)) {
//                if (logEnabled)
//                    HoshimiCulinaryMod.LOGGER.info("Found Eye Bone on Player {}", player.getDisplayName());
                return player.position();
            }
        }

        // PRIORITY 2: Is it an Item Entity on the floor?
        List<ItemEntity> items = this.chester.level().getEntitiesOfClass(ItemEntity.class, this.chester.getBoundingBox().inflate(SEARCHING_RANGE));

        for (ItemEntity item : items) {
            if (isBoneItem(item.getItem(), targetUUID)) {
//                if (logEnabled)
//                    HoshimiCulinaryMod.LOGGER.info("Found Eye Bone as a dropped item, at position: {}, {}, {}", item.getX(), item.getY(), item.getZ());
                return item.position();
            }
        }

        // PRIORITY 3: Is it a placed Block Entity?
        // Scanning blocks is expensive, so we scan a smaller range or rely on memory.
        // For simplicity, here is a small radius scan.
        BlockPos chesterPos = this.chester.blockPosition();
        int radius = 16; //TODO: This is a small radius for performance saving, but we can profile the impact of a bigger radius once it all works
        for (BlockPos pos : BlockPos.betweenClosed(chesterPos.offset(-radius, -radius, -radius), chesterPos.offset(radius, radius, radius))) {

            if (this.chester.level().getBlockEntity(pos) instanceof EyeBoneBlockEntity eyeBoneBlockEntity) {
//                if (logEnabled)
//                    HoshimiCulinaryMod.LOGGER.info("Found an Eye Bone at position: {}, {}, {}; UUID: {}", pos.getX(), pos.getY(), pos.getZ(), eyeBoneBlockEntity.getEyeBoneUUID());
                if (eyeBoneBlockEntity.getEyeBoneUUID().equals(targetUUID)) {
                    return Vec3.atCenterOf(pos);
                }
            }
        }

//        loggerFrequency++;
//        if (loggerFrequency >= MAX_LOGGER_FREQUENCY)
//            loggerFrequency = 0;

        //TODO:
//        GEMINI: Recommendation: Give your Chester entity a private BlockPos lastKnownBonePos.
//        If he sees the Player or ItemEntity, clear lastKnownBonePos.
//        If he sees neither, check lastKnownBonePos first.
//        Only do the expensive "Radius Scan" for the BlockEntity if he has completely lost track of the target for a few seconds.

//        ME: So I guess, essentially, we want to cache a last known position, then start the search small and repeat it in the normal
//        interval, with increasing radius each time, until it finds it or reaches the maximum radius. It should probably also do a
//        similar operation when it "knows" the item is in someone's inventory.

        return null;
    }
//    TODO: Ask if saving which of the three options is the case by listening/broadcasting all transfers would save in performance and efficiency

    private boolean hasBone(Player player, UUID eyeBoneId) {
        if (isBoneItem(player.getMainHandItem(), eyeBoneId)) return true;
        if (isBoneItem(player.getOffhandItem(), eyeBoneId)) return true;
        for (ItemStack stack : player.getInventory().items) {
            if (isBoneItem(stack, eyeBoneId)) return true;
        }
        return false;
    }

    public static boolean isBoneItem(ItemStack stack, UUID targetEyeBoneId) {
        if (!stack.isEmpty() && stack.getItem() == ModItems.EYE_BONE.get()) {
            if (stack.hasTag() && stack.getTag().hasUUID(Chester.EYE_BONE_UUID_TAG)) {
                return stack.getTag().getUUID(Chester.EYE_BONE_UUID_TAG).equals(targetEyeBoneId);
            }
        }
        return false;
    }
}
