package com.botrom.hoshimi_ca_mod.utils.compat.copper;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;

public record CopperGolemOxidationLevel(
    SoundEvent spinHeadSound,
    SoundEvent hurtSound,
    SoundEvent deathSound,
    SoundEvent stepSound,
    ResourceLocation texture,
    ResourceLocation eyeTexture
) {
}