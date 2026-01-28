package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.items.AngelWingsItem;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, value = Dist.CLIENT)
public class ClientWingInputHandler {

    private static boolean wasSpaceDown = false;
    private static boolean wasShiftDown = false;
    private static boolean wasBackDown = false; // FIX 2: Track 'S' key state

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null) return;

        ItemStack stack = mc.player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(stack.getItem() instanceof AngelWingsItem)) return;

        boolean spaceDown = mc.options.keyJump.isDown();
        boolean shiftDown = mc.options.keyShift.isDown();
        boolean backDown = mc.options.keyDown.isDown(); // The 'S' key

        // Detect "Just Pressed" (Rising Edge)
        boolean spacePressed = spaceDown && !wasSpaceDown;
        boolean shiftPressed = shiftDown && !wasShiftDown;

        // 1. Client-Side Prediction (Instant Feel)
        // This runs the jump/dash logic immediately on your screen
        if (spacePressed || shiftPressed) {
            WingLogicHandler.onInputPress(mc.player, stack, spacePressed, shiftPressed);
        }

        // 2. Sync to Server
        // Send packet if:
        // - We triggered an action (Pressed Space/Shift)
        // - OR any state changed (Held Space/Shift/Back changed from true to false or vice versa)
        if (spacePressed || shiftPressed || (spaceDown != wasSpaceDown) || (shiftDown != wasShiftDown) || (backDown != wasBackDown)) {
            HoshimiCulinaryMod.NETWORK.sendToServer(
                    new WingInputPacket(spaceDown, shiftPressed, spacePressed, backDown)
            );
        }
        wasSpaceDown = spaceDown;
        wasShiftDown = shiftDown;
        wasBackDown = backDown;
    }
}