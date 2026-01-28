package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.items.AngelWingsItem;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.client.gui.overlay.ForgeGui;
import net.minecraftforge.client.gui.overlay.IGuiOverlay;

public class WingHudOverlay implements IGuiOverlay {

    private static final int OFFHAND_SLOT_X_OFFSET = -117; // Standard offhand X
    private static final int ICON_SIZE = 16;
    private static final int Y_OFFSET_FROM_BOTTOM = 22 + 18; // 22 (hotbar height) + 18 (one slot up)

    @Override
    public void render(ForgeGui gui, GuiGraphics guiGraphics, float partialTick, int screenWidth, int screenHeight) {
        Minecraft mc = Minecraft.getInstance();
        Player player = mc.player;
        if (player == null || player.isSpectator()) return;

        // 1. Check if wearing wings
        ItemStack chestStack = player.getItemBySlot(EquipmentSlot.CHEST);
        if (!(chestStack.getItem() instanceof AngelWingsItem)) return;

        // 2. Calculate Position
        int x = (screenWidth / 2) + OFFHAND_SLOT_X_OFFSET;
        int y = screenHeight - Y_OFFSET_FROM_BOTTOM;

        // 3. Render the Item Icon
        // Note: This relies on ItemProperties (Step 2) to pick the Open/Closed texture automatically
        guiGraphics.renderItem(chestStack, x, y);

        // 4. Render Custom Cooldown Overlay
        // We use the "Big Flap" cooldown because it's the most important one (2 seconds)
        int cooldownTicks = chestStack.getOrCreateTag().getInt(WingLogicHandler.SMALL_FLAP_COOLDOWN_TAG);
        float maxCooldown = 20.0f; // 1 second = 20 ticks

        if (cooldownTicks > 0) {
            float progress = cooldownTicks / maxCooldown;
            renderCustomCooldown(guiGraphics, x, y, progress);
        }
    }

    private void renderCustomCooldown(GuiGraphics guiGraphics, int x, int y, float progress) {

        // Draw the white "swipe" effect
        // 1.20.1 uses guiGraphics directly, but for precise cooldown quads we usually mimic ItemRenderer

        int step = Mth.ceil(progress * 16.0F);
        int offset = 16 - step; // How much of the icon is covered

        guiGraphics.pose().pushPose();
        guiGraphics.pose().translate(0.0F, 0.0F, 200.0F);

        // Draw a semi-transparent white box over the icon representing the cooldown
        // This is a simplified version of the vanilla cooldown render
        guiGraphics.fill(x, y + offset, x + 16, y + 16, 0x7FFFFFFF); // 0x7F alpha white
        guiGraphics.pose().popPose();
    }
}
