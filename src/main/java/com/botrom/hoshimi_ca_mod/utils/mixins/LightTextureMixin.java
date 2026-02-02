package com.botrom.hoshimi_ca_mod.utils.mixins;

import com.botrom.hoshimi_ca_mod.utils.compat.copper.EndFlashAccessor;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.EndFlashState;
import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.client.renderer.LightTexture;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

/**
 * Recreates the purple End flash tint by modifying the lightmap just before upload.
 * Mirrors the vanilla 1.21.10 behaviour without depending on the new renderer backend.
 */
@Mixin(LightTexture.class)
public abstract class LightTextureMixin {
    
    private static final int PURPLE_R = 230;
    private static final int PURPLE_G = 128;
    private static final int PURPLE_B = 255;

    @Shadow
    @Final
    private Minecraft minecraft;

    @Shadow
    @Final
    private NativeImage lightPixels;

    @Unique
    private float hoshimimod$endFlashIntensity;
    
    /**
     * Calculate End flash intensity before updating light texture
     */
    @Inject(method = "updateLightTexture", at = @At("HEAD"))
    private void hoshimimod$captureEndFlashIntensity(float partialTicks, CallbackInfo ci) {
        this.hoshimimod$endFlashIntensity = 0.0F;
        ClientLevel level = this.minecraft.level;
        if (level == null || level.effects().skyType() != DimensionSpecialEffects.SkyType.END) {
            return;
        }

        EndFlashState state = EndFlashAccessor.get(level);
        if (state == null || this.minecraft.options.hideLightningFlash().get()) {
            return;
        }

        float intensity = state.getIntensity(partialTicks);
        if (intensity <= 0.0F) {
            return;
        }

        if (this.minecraft.gui.getBossOverlay().shouldCreateWorldFog()) {
            intensity /= 3.0F;
        }

        this.hoshimimod$endFlashIntensity = intensity;
    }
    
    /**
     * After the lightmap is calculated but before upload, apply the purple tint.
     * We inject right before the upload() call and modify the pixel data.
     */
    @Inject(method = "updateLightTexture", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/renderer/texture/DynamicTexture;upload()V"))
    private void hoshimimod$applyEndFlashTint(float partialTicks, CallbackInfo ci) {
        if (this.hoshimimod$endFlashIntensity <= 0.0F) {
            return;
        }

        ClientLevel level = this.minecraft.level;
        if (level == null || level.effects().skyType() != DimensionSpecialEffects.SkyType.END) {
            return;
        }

        float intensity = this.hoshimimod$endFlashIntensity;
        float brightnessBoost = 1.0F + intensity * 0.5F;

        for (int sky = 0; sky < 16; ++sky) {
            for (int block = 0; block < 16; ++block) {
                int pixel = this.lightPixels.getPixelRGBA(block, sky);
                int alpha = (pixel >>> 24) & 0xFF;
                int blue = (pixel >>> 16) & 0xFF;
                int green = (pixel >>> 8) & 0xFF;
                int red = pixel & 0xFF;

                red = (int)Math.min(255.0F, (red + (PURPLE_R - red) * intensity) * brightnessBoost);
                green = (int)Math.min(255.0F, (green + (PURPLE_G - green) * intensity) * brightnessBoost);
                blue = (int)Math.min(255.0F, (blue + (PURPLE_B - blue) * intensity) * brightnessBoost);

                this.lightPixels.setPixelRGBA(block, sky, (alpha << 24) | (blue << 16) | (green << 8) | red);
            }
        }
    }
}
