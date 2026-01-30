package com.botrom.hoshimi_ca_mod.effects;

import com.botrom.hoshimi_ca_mod.registry.ModEffects;
import net.minecraft.tags.FluidTags;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.WeakHashMap;

@Mod.EventBusSubscriber
public class NautilusEffectHandler {

    // Store the air value at the start of the tick
    private static final WeakHashMap<Player, Integer> AIR_CACHE = new WeakHashMap<>();

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        Player player = event.player;

        // Logic only applies if player is underwater and has the effect
        if (player.isEyeInFluid(FluidTags.WATER) && player.hasEffect(ModEffects.BREATH_OF_THE_NAUTILUS.get())) {

            if (event.phase == TickEvent.Phase.START) {
                // 1. Capture the air supply BEFORE vanilla decreases it
                AIR_CACHE.put(player, player.getAirSupply());

            } else if (event.phase == TickEvent.Phase.END) {
                // 2. Restore the air supply AFTER vanilla tried to decrease it
                if (AIR_CACHE.containsKey(player)) {
                    int previousAir = AIR_CACHE.get(player);

                    // Only restore if the vanilla logic lowered it (prevents infinite formatting fights)
                    // and ensure we don't accidentally revive a dead player (though unlikely here)
                    if (player.getAirSupply() < previousAir) {
                        player.setAirSupply(previousAir);
                    }
                }
            }
        }
    }
}