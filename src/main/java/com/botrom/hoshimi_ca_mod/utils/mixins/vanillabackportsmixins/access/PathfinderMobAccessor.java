package com.botrom.hoshimi_ca_mod.utils.mixins.vanillabackportsmixins.access;

import net.minecraft.world.entity.PathfinderMob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(PathfinderMob.class)
public interface PathfinderMobAccessor {
    @Invoker boolean callShouldStayCloseToLeashHolder();

    @Invoker double callFollowLeashSpeed();

    @Invoker void callOnLeashDistance(float distance);
}