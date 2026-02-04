package com.botrom.hoshimi_ca_mod.utils.mixins;

import net.minecraft.client.gui.components.LogoRenderer;
import net.minecraft.client.gui.screens.TitleScreen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.*;

@Mixin(LogoRenderer.class)
public class LogoRendererMixin {
    @ModifyArg(method = "<clinit>", at = @At(value = "INVOKE", target = "Lnet/minecraft/resources/ResourceLocation;<init>(Ljava/lang/String;)V"))
    private static String hoshimimod$replaceEditionPath(String original) {
        if ("textures/gui/title/edition.png".equals(original)) {
            return "hoshimimod:textures/gui/title/edition.png";
        }
        // if ("textures/gui/title/minecraft.png".equals(original)) {
        //     return "hoshimimod:textures/gui/title/minecraft.png";
        // }
        return original;
    }

    @ModifyConstant(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V", constant = @Constant(intValue = 128, ordinal = 1))
    private int changeRenderWidth(int original) {
        return 192;
    }

    @ModifyConstant(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V", constant = @Constant(intValue = 128, ordinal = 2))
    private int changeTextureWidth(int original) {
        return 192;
    }

    @ModifyConstant(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V", constant = @Constant(intValue = 64, ordinal = 1))
    private int centerNewWidth(int original) {
        return 96;
    }

    @ModifyConstant(method = "renderLogo(Lnet/minecraft/client/gui/GuiGraphics;IFI)V", constant = @Constant(intValue = 14))
    private int changeRenderHeight(int original) {
        return 16;
    }
}