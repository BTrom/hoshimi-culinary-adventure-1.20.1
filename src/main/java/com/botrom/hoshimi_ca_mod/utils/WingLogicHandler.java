package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.items.AngelWingsItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec3;

public class WingLogicHandler {

    // Tuning Constants
    private static final double SMALL_FLAP_FORCE = 0.6;         // ~2 blocks high
    private static final double BIG_FLAP_SPEED = 1.5;           // Forward burst
    private static final double GLIDE_GRAVITY_OPEN = -0.025;    // Very slow fall
    private static final double GLIDE_GRAVITY_CLOSED = -0.05;   // Less effective glide
    private static final double BRAKING_DRAG = 0.8;             // Air friction when holding S
    private static final double OPEN_WING_DRAG = 0.9;           // 0.9 = 10% speed loss per tick (Braking)

    public static final String WING_STATE_TAG = "WingState";
    public static final String LAST_FLAP_TAG = "LastFlapWasSmall";
    public static final String SMALL_FLAP_COOLDOWN_TAG = "SmallFlapCd";
    public static final String BIG_FLAP_COOLDOWN_TAG = "BigFlapCd";
    public static final String INPUT_SPACE_TAG = "InputSpace";
    public static final String INPUT_BACK_TAG = "InputBack";



    public static void handleInput(Player player, boolean spaceHeld, boolean shiftPressed, boolean backHeld) {
        ItemStack chest = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chest.getItem() instanceof AngelWingsItem)) return;

        boolean wingsOpen = chest.getOrCreateTag().getBoolean(WING_STATE_TAG);
        // --- 1. Small Flap (Space Pressed) ---
        // We detect a "new" press if space is held but we weren't just flapping,
        // effectively handled by the client sending the packet on press.
        // For this logic, we assume 'spaceHeld' triggers the Glide,
        // but we need a specific signal for the Jump.
        // (Simplified: We assume the packet sends a flag for "Just Pressed Jump")

        // *Note: In actual implementation, separating 'Held' vs 'Pressed' is best done client side.*
        // *Here we assume the caller calls this method with 'shiftPressed' ONLY on the rising edge.*
        if (shiftPressed) {
            toggleWings(player, chest);
        }

        if (backHeld) {
            Vec3 motion = player.getDeltaMovement();
            // Apply heavy drag to X and Z
            player.setDeltaMovement(motion.multiply(BRAKING_DRAG, 1.0, BRAKING_DRAG));
        }
    }

    // Called specifically when Client sends a "Space Just Pressed" packet
    public static void performSmallFlap(Player player, ItemStack stack) {
        if (getCooldown(stack, SMALL_FLAP_COOLDOWN_TAG) > 0 || player.onGround() || player.isInWater() || player.getAbilities().flying) return;

        boolean wingsOpen = isWingsOpen(stack);
        double force = wingsOpen ? SMALL_FLAP_FORCE : (SMALL_FLAP_FORCE / 2.0); // Half height if closed TODO: Parametrize

        Vec3 motion = player.getDeltaMovement();
        // Reset Y slightly to ensure consistent height gain
        player.setDeltaMovement(motion.x, force, motion.z);
        player.resetFallDistance(); // Reset fall distance so you don't die on landing after a jump

        setCooldown(stack, SMALL_FLAP_COOLDOWN_TAG, 20); // 1 second (20 ticks) TODO: Parametrize
        stack.getOrCreateTag().putBoolean(LAST_FLAP_TAG, true);

        // Visual/Sound cues here
    }

    private static void performBigFlap(Player player, ItemStack stack) {
        if (getCooldown(stack, BIG_FLAP_COOLDOWN_TAG) > 0 || player.onGround() || player.isInWater() || player.getAbilities().flying) return;

        // Logic 1a: Check if we just did a small flap
        boolean lastWasSmall = stack.getOrCreateTag().getBoolean(LAST_FLAP_TAG);
        double boostStrength = BIG_FLAP_SPEED;

        Vec3 look = player.getLookAngle();
        Vec3 motion = player.getDeltaMovement();

        if (lastWasSmall) {
            // Cut off the small flap height
            if (motion.y > 0) {
                motion = new Vec3(motion.x, 0, motion.z); // Kill vertical momentum
            }
            // Add extra speed to forward momentum
            boostStrength *= 1.2; // TODO: Parametrize
        }

        // --- FIX: SPEED CAPPING ---
        // Instead of blindly adding velocity, we check our current forward speed.
        // We want to boost the player, but not exceed a "Max Speed" too easily.

        // 1. Calculate how fast we are already going in the direction we are looking
        double currentSpeedInLookDir = motion.dot(look);
        // 2. Define a "Soft Cap" for speed (e.g., 2.0 blocks/tick is very fast)
        double maxSpeed = 2.0; // TODO: Parametrize
        // 3. Calculate how much we are ALLOWED to add.
        // If we are already at maxSpeed, we add 0. If we are at 0, we add full boost.
        double allowedBoost = Math.max(0, maxSpeed - currentSpeedInLookDir);
        // 4. Take the smaller of "Raw Boost" and "Allowed Boost"
        // This ensures that if you are already zooming, the dash just maintains speed, not doubles it.
        double finalBoost = Math.min(boostStrength, allowedBoost);
        // Apply forward boost in direction of look
        player.setDeltaMovement(
                motion.x + (look.x * finalBoost),
                motion.y + (look.y * finalBoost),
                motion.z + (look.z * finalBoost)
        );

        setCooldown(stack, BIG_FLAP_COOLDOWN_TAG, 40); // 2 seconds TODO: Parametrize
        stack.getOrCreateTag().putBoolean(LAST_FLAP_TAG, false);
    }

    public static boolean isWingsOpen(ItemStack stack) {
        return stack.getOrCreateTag().getBoolean(WING_STATE_TAG);
    }

    private static void toggleWings(Player player, ItemStack stack) {
        boolean currentlyOpen = stack.getOrCreateTag().getBoolean(WING_STATE_TAG);
        boolean newOpenState = !currentlyOpen;

        stack.getOrCreateTag().putBoolean(WING_STATE_TAG, newOpenState);

        if (!newOpenState) {
            // We just CLOSED the wings -> Trigger BIG FLAP
            performBigFlap(player, stack);

            // CRITICAL: Force Vanilla Flight to start immediately
            if (!player.onGround()) {
                player.startFallFlying();
            }
        } else {
            // --- CASE: Opening Wings (Closed -> Open) ---
            // User: "Opening the wings should also cause some braking"
            // The physics tick will handle the continuous drag, but we can add an instant "pop" of drag here.
            Vec3 motion = player.getDeltaMovement();
            player.setDeltaMovement(motion.multiply(1.1, 1.0, 1.1)); // ~~Lose 50% horizontal speed instantly~~ No braking TODO: Parametrize

            // Stop Vanilla Flight (Elytra mode ends because canElytraFly checks the tag)
//            player.stopFallFlying(); TODO: Check the effects
        }
    }

    private static void applyPassivePhysics(Player player, ItemStack stack, boolean isSpaceHeld, boolean isBackHeld) {
        boolean wingsOpen = isWingsOpen(stack);
        Vec3 motion = player.getDeltaMovement();

        // --- Glide Logic ---
        if (wingsOpen) {
            player.setDeltaMovement(motion.multiply(OPEN_WING_DRAG, 1.0, OPEN_WING_DRAG));
            // Minecraft applies gravity (-0.08) every tick. We want to override this.
            // We set the Y motion to decay much slower.
            // Note: This is simplified. For exact specific gravity, you effectively cancel
            // vanilla gravity by adding it back, then subtracting yours.

            // If Space is being HELD (requires player.isJumping state or stored packet state)
            // Assuming we check a 'isGliding' flag stored from input:
            if (motion.y < 0 && isSpaceHeld) {
                player.setDeltaMovement(player.getDeltaMovement().x, Math.max(motion.y, GLIDE_GRAVITY_OPEN), player.getDeltaMovement().z);
                player.resetFallDistance(); // Prevent fall damage while hovering
            }
        }

        // --- Drag Logic ---
        // Logic 2: Horizontal drag is halved while wings are closed
        else {
            // Vanilla handles the gliding speed/physics because canElytraFly() returns true.
            // We only need to handle the "Air Brake" (S key) manually if desired
            if (isBackHeld) {
                player.setDeltaMovement(motion.multiply(0.8, 1.0, 0.8)); // TODO: Parametrize
            }
            // (Note: Multiplying > 1.0 compensates for vanilla air friction)
        }
    }

    // --- 2. Active Physics (Triggers on Button Press) ---
    // Called by Client (Input Event) AND Server (Packet Receive)
    public static void onInputPress(Player player, ItemStack stack, boolean isSpace, boolean isShift) {
        // FIX: Ignore inputs if in Creative Flight
        if (player.getAbilities().flying) return;

        if (isSpace) performSmallFlap(player, stack);
        if (isShift) toggleWings(player, stack);
    }

    public static void onTick(Player player, ItemStack stack) {
        if (player.getAbilities().flying) return;

        handleCooldowns(stack);

        if (!player.onGround() && !player.isInWater()) {
            boolean isSpaceHeld;
            boolean isBackHeld;

            if (player.level().isClientSide) {
                // CLIENT: Read inputs directly from keyboard for instant response
                isSpaceHeld = Minecraft.getInstance().options.keyJump.isDown();
                isBackHeld = Minecraft.getInstance().options.keyDown.isDown();
            } else {
                // SERVER: Read inputs from NBT (synced by packet)
                isSpaceHeld = stack.getOrCreateTag().getBoolean(INPUT_SPACE_TAG);
                isBackHeld = stack.getOrCreateTag().getBoolean(INPUT_BACK_TAG);
            }

            applyPassivePhysics(player, stack, isSpaceHeld, isBackHeld);
        }
    }

    // Helper for NBT Cooldowns
    private static void handleCooldowns(ItemStack stack) {
        int small = getCooldown(stack, SMALL_FLAP_COOLDOWN_TAG);
        int big = getCooldown(stack, BIG_FLAP_COOLDOWN_TAG);
        if (small > 0) setCooldown(stack, SMALL_FLAP_COOLDOWN_TAG, small - 1);
        if (big > 0) setCooldown(stack, BIG_FLAP_COOLDOWN_TAG, big - 1);
    }

    private static int getCooldown(ItemStack stack, String key) {
        return stack.getOrCreateTag().getInt(key);
    }

    private static void setCooldown(ItemStack stack, String key, int cooldown) {
        stack.getOrCreateTag().putInt(key, cooldown);
    }
}
