package com.botrom.hoshimi_ca_mod.utils.compat.chester;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.gui.ChesterScreen;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenChesterScreenPacket {

	private final int containerId;
	private final int entityId;

	public OpenChesterScreenPacket(int containerId, int entityId) {
		this.containerId = containerId;
		this.entityId = entityId;
	}

	public OpenChesterScreenPacket(FriendlyByteBuf buf) {
		this.containerId = buf.readUnsignedByte();
		this.entityId = buf.readInt();
	}

	public void encode(FriendlyByteBuf buf) {
		buf.writeByte(this.containerId);
		buf.writeInt(this.entityId);
	}

	public static class Handler {

		@SuppressWarnings("Convert2Lambda")
		public static void onMessage(OpenChesterScreenPacket message, Supplier<NetworkEvent.Context> ctx) {
			ctx.get().enqueueWork(new Runnable() {
				@Override
				public void run() {
					assert Minecraft.getInstance().level != null;
					Entity entity = Minecraft.getInstance().level.getEntity(message.entityId);
					if (entity instanceof Chester chester) {
						LocalPlayer localplayer = Minecraft.getInstance().player;
//						SimpleContainer simplecontainer = new SimpleContainer(chester.hasExtendedInventory() ? 54 : 27);
						SimpleContainer simplecontainer = new SimpleContainer(27);
						assert localplayer != null;
						ChesterMenu menu = new ChesterMenu(message.containerId, localplayer.getInventory(), simplecontainer, chester);
						localplayer.containerMenu = menu;
						Minecraft.getInstance().setScreen(new ChesterScreen(menu, localplayer.getInventory(), chester));
					}
				}
			});
			ctx.get().setPacketHandled(true);
		}
	}
}
