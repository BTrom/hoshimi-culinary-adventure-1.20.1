package com.botrom.hoshimi_ca_mod.utils.mixins.vanillabackportsmixins.access;

import net.minecraft.world.entity.AnimationState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

@Mixin(AnimationState.class)
public interface AnimationStateAccessor {
    @Accessor
    void setAccumulatedTime(long accumulatedTime);
}
