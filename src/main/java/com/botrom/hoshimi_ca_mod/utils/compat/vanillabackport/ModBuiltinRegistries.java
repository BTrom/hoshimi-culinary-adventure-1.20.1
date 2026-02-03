package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.ChickenVariant;
import com.botrom.hoshimi_ca_mod.entities.CowVariant;
import com.botrom.hoshimi_ca_mod.entities.PigVariant;

public class ModBuiltinRegistries {
//    public static final BuiltInCoreRegistry<WolfSoundVariant> WOLF_SOUND_VARIANTS = new BuiltInCoreRegistry<>(ModRegistries.WOLF_SOUND_VARIANT.get(), VanillaBackport.NAMESPACE);
    public static final BuiltInCoreRegistry<CowVariant> COW_VARIANTS = new BuiltInCoreRegistry<>(ModRegistries.COW_VARIANT.get(), HoshimiCulinaryMod.MOD_ID);
    public static final BuiltInCoreRegistry<ChickenVariant> CHICKEN_VARIANTS = new BuiltInCoreRegistry<>(ModRegistries.CHICKEN_VARIANT.get(), HoshimiCulinaryMod.MOD_ID);
    public static final BuiltInCoreRegistry<PigVariant> PIG_VARIANTS = new BuiltInCoreRegistry<>(ModRegistries.PIG_VARIANT.get(), HoshimiCulinaryMod.MOD_ID);
//    public static final BuiltInCoreRegistry<WolfVariant> WOLF_VARIANTS = new BuiltInCoreRegistry<>(ModRegistries.WOLF_VARIANT.get(), VanillaBackport.NAMESPACE);
}