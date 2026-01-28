package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.WingInputPacket;
import com.botrom.hoshimi_ca_mod.utils.compat.ClientboundBubbleStatePacket;
import com.botrom.hoshimi_ca_mod.utils.compat.chester.OpenChesterScreenPacket;
import com.botrom.hoshimi_ca_mod.utils.compat.chester.SitNearbyChesterPacket;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.PacketFoodCounter;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.network.ServerboundRenamePizzaPacket;
import com.botrom.hoshimi_ca_mod.utils.compat.SyncSaturationPacket;
import io.netty.buffer.Unpooled;
import net.minecraft.client.Minecraft;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.Packet;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.PacketDistributor;
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Objects;
import java.util.ServiceLoader;

public class ModNetwork {
    public static final ResourceLocation CHANNEL_NAME = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "network");
    public static final String NETWORK_VERSION = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "1").toString();
    public static final ResourceLocation SYNC_SATURATION = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "sync_saturation");

    public static SimpleChannel registerNetworkChannel() {
        final SimpleChannel channel = NetworkRegistry.ChannelBuilder.named(CHANNEL_NAME)
                .clientAcceptedVersions(version -> true)
                .serverAcceptedVersions(version -> true)
                .networkProtocolVersion(() -> NETWORK_VERSION)
                .simpleChannel();

        HoshimiCulinaryMod.NETWORK = channel;

        channel.messageBuilder(ServerboundRenamePizzaPacket.class, 0)
                .decoder(ServerboundRenamePizzaPacket::decode)
                .encoder(ServerboundRenamePizzaPacket::encode)
                .consumerMainThread(ServerboundRenamePizzaPacket::handle)
                .add();

        channel.messageBuilder(PacketFoodCounter.class, 1)
                .decoder(PacketFoodCounter::deserialize)
                .encoder(PacketFoodCounter::serialize)
                .consumerMainThread(PacketFoodCounter::handle)
                .add();

        channel.messageBuilder(OpenChesterScreenPacket.class, 2)
                .decoder(OpenChesterScreenPacket::new)
                .encoder(OpenChesterScreenPacket::encode)
                .consumerMainThread(OpenChesterScreenPacket.Handler::onMessage)
                .add();
        channel.messageBuilder(SitNearbyChesterPacket.class, 3)
                .decoder(SitNearbyChesterPacket::new)
                .encoder(SitNearbyChesterPacket::encode)
                .consumerMainThread(SitNearbyChesterPacket.Handler::onMessage)
                .add();

        ClientboundBubbleStatePacket.Handler bubbleHandler = new ClientboundBubbleStatePacket.Handler();

        channel.messageBuilder(ClientboundBubbleStatePacket.class, 4)
                .decoder(bubbleHandler::read)
                .encoder(bubbleHandler::write)
                .consumerMainThread(bubbleHandler::handle)
                .add();

        channel.messageBuilder(WingInputPacket.class, 5)
                .decoder(WingInputPacket::decode)
                .encoder(WingInputPacket::encode)
                .consumerMainThread(WingInputPacket::handle)
                .add();

        return channel;
    }
    public static void collectPackets(PacketSink sink, Side side, ResourceLocation id, FriendlyByteBuf buf) {
        throw new AssertionError();
    }

    public static void sendToPlayer(ServerPlayer player, ResourceLocation id, FriendlyByteBuf buf) {
        collectPackets(PacketSink.ofPlayer(player), serverToClient(), id, buf);
    }

    public static <MSG> void sendToPlayer(ServerPlayer player, MSG msg) {
        HoshimiCulinaryMod.NETWORK.send(PacketDistributor.PLAYER.with(() -> player), msg);
    }

    // Helper to send to everyone tracking an entity (S2C)
    // This effectively replaces "BUBBLE_STATE.sendToTracking"
    public static <MSG> void sendToTracking(Entity entity, MSG msg) {
        HoshimiCulinaryMod.NETWORK.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), msg);
    }

    public static <MSG> void sendToAllTracking(Entity entity, MSG msg) {
        HoshimiCulinaryMod.NETWORK.send(PacketDistributor.TRACKING_ENTITY.with(() -> entity), msg);
    }

    public static void sendSaturationSync(SyncSaturationPacket packet, Entity entity) {
        if (entity.level() instanceof ServerLevel serverLevel) {
            for (ServerPlayer player : serverLevel.players()) {
                FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
                SyncSaturationPacket.encode(packet, buf);
                sendToPlayer(player, SYNC_SATURATION, buf);
            }
        }
    }

    public static Side serverToClient() {
        return Side.S2C;
    }

    public enum Side {
        S2C,
        C2S
    }

    public interface PacketSink {
        static PacketSink ofPlayer(ServerPlayer player) {
            return packet -> Objects.requireNonNull(player, "Unable to send packet to a 'null' player!").connection.send(packet);
        }

        static PacketSink ofPlayers(Iterable<? extends ServerPlayer> players) {
            return packet -> {
                for (var player : players) {
                    Objects.requireNonNull(player, "Unable to send packet to a 'null' player!").connection.send(packet);
                }
            };
        }

        static PacketSink client() {
            return packet -> {
                if (Minecraft.getInstance().getConnection() != null) {
                    Minecraft.getInstance().getConnection().send(packet);
                } else {
                    throw new IllegalStateException("Unable to send packet to the server while not in game!");
                }
            };
        }

        void accept(Packet<?> packet);
    }

    public interface IPacketHandler<T> {

        T read(FriendlyByteBuf byteBuf);

        void write(T packet, FriendlyByteBuf byteBuf);

        void handle(T packet);

    }
}