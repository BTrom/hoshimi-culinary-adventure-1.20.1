package com.botrom.hoshimi_ca_mod.utils.compat.crockpot;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModCriteriaTriggers;
import com.botrom.hoshimi_ca_mod.registry.ModNetwork;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import net.minecraftforge.event.entity.living.LivingEntityUseItemEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID)
public class FoodCounterCapabilityHandler {
    public static final Capability<IFoodCounter> FOOD_COUNTER_CAPABILITY = CapabilityManager.get(new CapabilityToken<>() {
    });
    public static final ResourceLocation FOOD_COUNTER = Utils.createResourceLocation("food_counter");

    @SubscribeEvent
    public static void registerCaps(RegisterCapabilitiesEvent event) {
        event.register(IFoodCounter.class);
    }

    @SubscribeEvent
    public static void attachPlayerCapability(AttachCapabilitiesEvent<Entity> event) {
        if (event.getObject() instanceof Player) {
            event.addCapability(FOOD_COUNTER, new FoodCounterProvider());
        }
    }

    @SubscribeEvent
    public static void onPlayerAppear(EntityJoinLevelEvent event) {
        if (event.getEntity() instanceof ServerPlayer player) {
            syncFoodCounter(player);
        }
    }

    @SubscribeEvent
    public static void onPlayerClone(PlayerEvent.Clone event) {
        var player = event.getEntity();
        var oldPlayer = event.getOriginal();
        oldPlayer.revive();
        oldPlayer.getCapability(FOOD_COUNTER_CAPABILITY).ifPresent(oldFoodCounter -> player.getCapability(FOOD_COUNTER_CAPABILITY)
                .ifPresent(newFoodCounter -> newFoodCounter.deserializeNBT(oldFoodCounter.serializeNBT()))
        );
    }

    @SubscribeEvent
    public static void onFoodEaten(LivingEntityUseItemEvent.Finish event) {
        if (!(event.getEntity() instanceof ServerPlayer player) || !event.getItem().isEdible()) {
            return;
        }
        player.getCapability(FoodCounterCapabilityHandler.FOOD_COUNTER_CAPABILITY).ifPresent(foodCounter -> {
            var stack = event.getItem();
            foodCounter.addFood(stack.getItem());
            ModCriteriaTriggers.EAT_FOOD_TRIGGER.trigger(player, stack, foodCounter.getCount(stack.getItem()));
        });
        syncFoodCounter(player);
    }

    public static void syncFoodCounter(Player player) {
        if (player instanceof ServerPlayer serverPlayer) {
            serverPlayer.getCapability(FOOD_COUNTER_CAPABILITY).ifPresent(foodCounter -> ModNetwork.sendToPlayer(serverPlayer, new PacketFoodCounter(foodCounter.serializeNBT())));
        }
    }
}
