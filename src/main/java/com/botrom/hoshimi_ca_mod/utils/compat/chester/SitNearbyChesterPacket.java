package com.botrom.hoshimi_ca_mod.utils.compat.chester;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkEvent;

import java.util.List;
import java.util.function.Supplier;

public class SitNearbyChesterPacket {
	public SitNearbyChesterPacket() {}

	public SitNearbyChesterPacket(FriendlyByteBuf buf) {}

	public void encode(FriendlyByteBuf buf) {}

	public static class Handler {
		public static void onMessage(SitNearbyChesterPacket message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(() -> {
				ServerPlayer player = ctx.get().getSender();
				if (player != null) {
					List<Chester> nearbyOwnedChester = player.level().getEntitiesOfClass(Chester.class, player.getBoundingBox().inflate(8.0F), entity -> entity.getOwner() == player);
					if (!nearbyOwnedChester.isEmpty()) {
						for (Chester chester : nearbyOwnedChester) {
							chester.setInSittingPose(!chester.isInSittingPose());
						}
					}
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}
