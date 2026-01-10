package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.resources.ResourceLocation;

public class Utils {


    public static ResourceLocation createResourceLocation(String tagName) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, tagName);
    }
}
