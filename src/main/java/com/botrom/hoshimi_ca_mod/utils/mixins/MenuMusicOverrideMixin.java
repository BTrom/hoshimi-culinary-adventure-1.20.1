package com.botrom.hoshimi_ca_mod.utils.mixins;

import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.TitleScreen;
import net.minecraft.core.Holder;
import net.minecraft.sounds.Music;
import net.minecraft.sounds.SoundEvent;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

import javax.annotation.Nullable;

@Mixin(Minecraft.class)
public abstract class MenuMusicOverrideMixin {

    // Shadow the 'screen' variable so we can check if we are on the TitleScreen
    @Shadow
    @Nullable
    public Screen screen;

    // Define your custom music logic here.
    // "20" = Min Delay (1 second), "600" = Max Delay (30 seconds).
    // If you want INSTANT looping, set both to 0 or 20.
    @Unique
    private static final Music HOSHIMI_MENU_MUSIC = new Music(Holder.direct(SoundEvent.createVariableRangeEvent(Utils.createResourceLocation("music/menu_music"))), 20, 100, true);

    @Inject(method = "getSituationalMusic", at = @At("HEAD"), cancellable = true)
    private void hoshimimod$overrideMenuMusic(CallbackInfoReturnable<Music> cir) {
        // Check if the current screen is the Title Screen
        if (this.screen instanceof TitleScreen) {
            // Force the game to return our custom music object
            cir.setReturnValue(HOSHIMI_MENU_MUSIC);
        }
    }
}