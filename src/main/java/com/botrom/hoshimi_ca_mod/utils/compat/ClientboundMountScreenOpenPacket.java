package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.gui.NautilusScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class ClientboundMountScreenOpenPacket /*implements Packet<ClientGamePacketListener>*/ {
//    public static final StreamCodec<FriendlyByteBuf, ClientboundMountScreenOpenPacket> STREAM_CODEC = Packet.codec(
//            ClientboundMountScreenOpenPacket::write, ClientboundMountScreenOpenPacket::new
//    );
    private final int containerId;
    private final int inventoryColumns;
    private final int entityId;

    public ClientboundMountScreenOpenPacket(int containerId, int inventoryColumns, int entityId) {
        this.containerId = containerId;
        this.inventoryColumns = inventoryColumns;
        this.entityId = entityId;
    }

    public ClientboundMountScreenOpenPacket(FriendlyByteBuf buffer) {
        this.containerId = buffer.readInt();
        this.inventoryColumns = buffer.readVarInt();
        this.entityId = buffer.readInt();
    }

//    private void write(FriendlyByteBuf p_452661_) {
//        p_452661_.writeContainerId(this.containerId);
//        p_452661_.writeVarInt(this.inventoryColumns);
//        p_452661_.writeInt(this.entityId);
//    }

    public void encode(FriendlyByteBuf buffer) {
        buffer.writeInt(this.containerId);
        buffer.writeVarInt(this.inventoryColumns);
        buffer.writeInt(this.entityId);
    }

//    @Override
//    public PacketType<ClientboundMountScreenOpenPacket> type() {
//        return GamePacketTypes.CLIENTBOUND_MOUNT_SCREEN_OPEN;
//    }

//    public void handle(ClientGamePacketListener p_457099_) {
//        p_457099_.handleMountScreenOpen(this);
//    }

    // This handle method depends on your mod loader (Forge/Fabric)
    // You will need to call this from your packet handler
//    public void handle(ClientGamePacketListener listener) {
//        // In 1.20.1, there is no handleMountScreenOpen.
//        // You must implement the logic to open the screen on the CLIENT side here.
//        // Example logic to put in your ClientPacketHandler:
//        Minecraft.getInstance().execute(() -> {
//             Entity entity = Minecraft.getInstance().level.getEntity(this.entityId);
//             if (entity instanceof AbstractNautilus nautilus) {
//                 LocalPlayer player = Minecraft.getInstance().player;
//                 NautilusInventoryMenu menu = new NautilusInventoryMenu(this.containerId, player.getInventory(), nautilus.inventory, nautilus, this.inventoryColumns);
//                 Minecraft.getInstance().setScreen(new NautilusScreen(menu, player.getInventory(), nautilus));
//             }
//        });
//    }

    public void handle(Supplier<NetworkEvent.Context> context) {
        context.get().enqueueWork(() -> {
            // Client-Side Logic: Open the Screen
            // Note: You must strictly use client-side only classes (Minecraft) here
            Entity entity = Minecraft.getInstance().level.getEntity(this.entityId);
            if (entity instanceof AbstractNautilus nautilus) {
                Player player = Minecraft.getInstance().player;

                // Create the Menu on the client
                NautilusInventoryMenu menu = new NautilusInventoryMenu(this.containerId, player.getInventory(), nautilus.getInventory(), nautilus, this.inventoryColumns);
                player.containerMenu = menu;

                // Open the Screen
                // You need a Screen class (e.g., NautilusScreen) registered for this.
                // Assuming you have a generic NautilusScreen or similar:
                // Minecraft.getInstance().setScreen(new NautilusScreen(menu, player.getInventory(), nautilus));

                // IMPORTANT: If you have registered the MenuType and Screen in ClientSetup,
                // you might just be able to use the standard MenuScreens.create(...) if the menu matches.
                // However, custom mount screens usually require manual opening like this:
                Minecraft.getInstance().setScreen(new NautilusScreen(menu, player.getInventory(), nautilus));
                // ^ Replace HorseInventoryScreen with your custom screen class if you have one.
            }
        });
        context.get().setPacketHandled(true);
    }

//    public int getContainerId() {
//        return this.containerId;
//    }
//
//    public int getInventoryColumns() {
//        return this.inventoryColumns;
//    }
//
//    public int getEntityId() {
//        return this.entityId;
//    }
}
