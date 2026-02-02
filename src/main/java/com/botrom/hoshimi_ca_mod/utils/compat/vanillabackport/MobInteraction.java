package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;

public interface MobInteraction {
    InteractionResult onInteract(Player var1, Entity var2, InteractionHand var3);
}
