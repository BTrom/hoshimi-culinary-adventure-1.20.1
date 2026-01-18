package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.registry.ModNetwork;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public record ClientboundBubbleStatePacket(boolean state, int playerId) {

    public static class Handler {
        public ClientboundBubbleStatePacket read(FriendlyByteBuf byteBuf) {
            return new ClientboundBubbleStatePacket(byteBuf.readBoolean(), byteBuf.readInt());
        }

        public void write(ClientboundBubbleStatePacket packet, FriendlyByteBuf byteBuf) {
            byteBuf.writeBoolean(packet.state);
            byteBuf.writeInt(packet.playerId);
        }

        // --- THE IMPORTANT CHANGE ---
        // Forge requires the second parameter: Supplier<NetworkEvent.Context>
        public void handle(ClientboundBubbleStatePacket packet, Supplier<NetworkEvent.Context> ctx) {
            ctx.get().enqueueWork(() -> {
                // We are now on the main thread (safe to touch the world/entities)

                // Be careful calling Minecraft.getInstance() directly if this packet
                // might ever exist on a dedicated server, but for "Clientbound" it is usually fine.
                if (Minecraft.getInstance().level != null) {
                    Player player = (Player) Minecraft.getInstance().level.getEntity(packet.playerId);

                    if (player instanceof IBubbleState bubbleState) {
                        bubbleState.setBubbleActive(packet.state);
                    }
                }
            });

            // Always mark the packet as handled
            ctx.get().setPacketHandled(true);
        }
    }
}