package com.botrom.hoshimi_ca_mod.utils;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

// Packet to notify server of specific inputs
public class WingInputPacket {
    private final boolean spaceHeld;
    private final boolean shiftPressed; // True only on the specific tick it was pressed
    private final boolean spacePressed; // True only on the specific tick it was pressed
    private final boolean backHeld;     // 'S' key

    public WingInputPacket(boolean spaceHeld, boolean shiftPressed, boolean spacePressed, boolean backHeld) {
        this.spaceHeld = spaceHeld;
        this.shiftPressed = shiftPressed;
        this.spacePressed = spacePressed;
        this.backHeld = backHeld;
    }

    public static WingInputPacket decode(FriendlyByteBuf byteBuf) {
        return new WingInputPacket(byteBuf.readBoolean(), byteBuf.readBoolean(), byteBuf.readBoolean(), byteBuf.readBoolean());
    }

    public static void encode(WingInputPacket msg, FriendlyByteBuf byteBuf) {
        byteBuf.writeBoolean(msg.spaceHeld);
        byteBuf.writeBoolean(msg.shiftPressed);
        byteBuf.writeBoolean(msg.spacePressed);
        byteBuf.writeBoolean(msg.backHeld);
    }

    public static void handle(WingInputPacket msg, Supplier<NetworkEvent.Context> ctx) {
        ctx.get().enqueueWork(() -> {
            ServerPlayer player = ctx.get().getSender();
            if (player == null) return;
            ItemStack stack = player.getItemBySlot(EquipmentSlot.CHEST);

            // 1. Sync State for Passive Physics (Glide/Drag)
            stack.getOrCreateTag().putBoolean("InputSpace", msg.spaceHeld);
            stack.getOrCreateTag().putBoolean("InputBack", msg.backHeld);

            // 2. Trigger Active Physics (Flaps/Toggles)
            WingLogicHandler.onInputPress(player, stack, msg.spacePressed, msg.shiftPressed);
        });
        ctx.get().setPacketHandled(true);
    }
}
