package com.botrom.hoshimi_ca_mod.utils.mixins;

import com.botrom.hoshimi_ca_mod.registry.ModSounds;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.DirectionalSoundInstance;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.EndFlashAccessor;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.EndFlashState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.DimensionSpecialEffects;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.BooleanSupplier;

/**
 * Mixin to add End Flash functionality to ClientLevel.
 * Ported from Minecraft 1.21.10 to 1.20.1
 */
@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin extends Level implements EndFlashAccessor {
    
    @Shadow
    public abstract DimensionSpecialEffects effects();
    
    @Shadow
    @Final
    private Minecraft minecraft;
    
    @Unique
    private EndFlashState hoshimimod$endFlashState;
    
    protected ClientLevelMixin() {
        super(null, null, null, null, null, false, false, 0, 0);
    }
    
    /**
     * Initialize EndFlashState for End dimension
     */
    @Inject(method = "<init>", at = @At("RETURN"))
    private void hoshimimod$onInit(CallbackInfo ci) {
        // Check if we're in the End dimension (SkyType.END means it has end effects)
        // and if End Flash is enabled in config
        if (this.effects().skyType() == DimensionSpecialEffects.SkyType.END && ModConfig.endFlashEnabled) {
            this.hoshimimod$endFlashState = new EndFlashState();
        }
    }
    
    /**
     * Tick the EndFlashState and play sound when flash starts
     */
    @Inject(method = "tick", at = @At("TAIL"))
    private void hoshimimod$onTick(BooleanSupplier hasTimeLeft, CallbackInfo ci) {
        if (this.hoshimimod$endFlashState != null) {
            this.hoshimimod$endFlashState.tick(this.getGameTime());
            
            // Play directional sound when flash starts
            if (this.hoshimimod$endFlashState.flashStartedThisTick()) {
                this.minecraft.getSoundManager().playDelayed(
                    new DirectionalSoundInstance(
                        ModSounds.WEATHER_END_FLASH.get(),
                        SoundSource.WEATHER,
                        this.random,
                        this.minecraft.gameRenderer.getMainCamera(),
                        this.hoshimimod$endFlashState.getXAngle(),
                        this.hoshimimod$endFlashState.getYAngle()
                    ),
                    EndFlashState.SOUND_DELAY_IN_TICKS
                );
            }
        }
    }
    
    /**
     * Accessor for the EndFlashState
     */
    @Override
    @Unique
    public EndFlashState hoshimimod$getEndFlashState() {
        return this.hoshimimod$endFlashState;
    }
}
