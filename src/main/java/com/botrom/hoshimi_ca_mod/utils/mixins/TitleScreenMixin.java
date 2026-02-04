package com.botrom.hoshimi_ca_mod.utils.mixins;

import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(TitleScreen.class)
public class TitleScreenMixin {
    @ModifyConstant(method = "<clinit>", constant = @Constant(stringValue = "textures/gui/title/background/panorama"))
    private static String hoshimimod$replacePanoramaPath(String original) {
        return "hoshimimod:textures/gui/title/background/panorama";
    }
}