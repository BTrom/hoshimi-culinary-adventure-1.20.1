package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<SoundEvent> BUBBLE_POP = createSoundEvent("bubble_pop");
    public static final RegistryObject<SoundEvent> LOBSTER_HURT = createSoundEvent("entity/lobster_hurt");
    public static final RegistryObject<SoundEvent> LOBSTER_ATTACK = createSoundEvent("entity/lobster_attack");
    public static final RegistryObject<SoundEvent> GIANT_SQUID_GAMES = createSoundEvent("entity/giant_squid_games");
    public static final RegistryObject<SoundEvent> GIANT_SQUID_HURT = createSoundEvent("entity/giant_squid_hurt");
    public static final RegistryObject<SoundEvent> GIANT_SQUID_TENTACLE = createSoundEvent("entity/giant_squid_tentacle");
    public static final RegistryObject<SoundEvent> COMB_JELLY_HURT = createSoundEvent("entity/comb_jelly_hurt");
    public static final RegistryObject<SoundEvent> MIMIC_OCTOPUS_IDLE = createSoundEvent("entity/mimic_octopus_idle");
    public static final RegistryObject<SoundEvent> MIMIC_OCTOPUS_HURT = createSoundEvent("entity/mimic_octopus_hurt");
    public static final RegistryObject<SoundEvent> SEAGULL_IDLE = createSoundEvent("entity/seagull_idle");
    public static final RegistryObject<SoundEvent> SEAGULL_HURT = createSoundEvent("entity/seagull_hurt");

//    public static final RegistryObject<SoundEvent> BLOCK_PIZZA_SIZZLING = SOUND_EVENTS.register("block.pizza.sizzling", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block.pizza.sizzling")));



    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.createVariableRangeEvent(Utils.createResourceLocation(soundName)));
    }
}
