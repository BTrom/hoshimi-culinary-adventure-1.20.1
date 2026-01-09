package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvent;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HoshimiCulinaryMod.MOD_ID);

//    public static final RegistryObject<SoundEvent> BLOCK_PIZZA_SIZZLING = SOUND_EVENTS.register("block.pizza.sizzling", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block.pizza.sizzling")));
}
