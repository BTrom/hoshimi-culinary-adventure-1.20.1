package com.botrom.hoshimi_ca_mod.utils;

import net.minecraftforge.common.ForgeConfigSpec;

public class ClientConfig {
    public final ForgeConfigSpec.BooleanValue showFoodValuesTooltip;
    public final ForgeConfigSpec.BooleanValue showFoodEffectsTooltip;
    public final ForgeConfigSpec.BooleanValue gnawsGiftHungerOverlay;

    public ClientConfig(final ForgeConfigSpec.Builder builder) {
        builder.comment("Client settings").push("client");
        showFoodValuesTooltip = buildBoolean(builder,
                "showFoodValuesTooltip", "all", ModConfig.showFoodValuesTooltip,
                "Set this to false will disable the food values tooltip.");
        showFoodEffectsTooltip = buildBoolean(builder,
                "showFoodEffectsTooltip", "all", ModConfig.showFoodEffectsTooltip,
                "Set this to false will disable the food effect tooltip.");
        gnawsGiftHungerOverlay = buildBoolean(builder,
                "gnawsGiftHungerOverlay", "all", ModConfig.gnawsGiftHungerOverlay,
                "Set this to false will disable the special hunger bar overlay when the player has Gnaw's Gift effect.");
        builder.pop();
    }

    private static ForgeConfigSpec.BooleanValue buildBoolean(ForgeConfigSpec.Builder builder, String name, String category, boolean defaultValue, String comment) {
        return builder.comment(comment).translation(name).define(name, defaultValue);
    }
}
