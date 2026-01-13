package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.network.ServerboundRenamePizzaPacket;
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
import net.minecraftforge.network.simple.SimpleChannel;

import java.util.Objects;

public class ModNetwork
{
    public static final ResourceLocation CHANNEL_NAME = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "network");
    public static final String NETWORK_VERSION = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "1").toString();
    public static final ResourceLocation SYNC_SATURATION = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "sync_saturation");

    public static SimpleChannel registerNetworkChannel()
    {
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

        return channel;
    }

    public static void collectPackets(PacketSink sink, Side side, ResourceLocation id, FriendlyByteBuf buf) {
        throw new AssertionError();
    }

    public static void sendToPlayer(ServerPlayer player, ResourceLocation id, FriendlyByteBuf buf) {
        collectPackets(PacketSink.ofPlayer(player), serverToClient(), id, buf);
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
}