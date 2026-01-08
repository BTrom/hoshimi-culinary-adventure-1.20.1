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

    public static final RegistryObject<SoundEvent> BLOCK_OVEN_CRACKLE = SOUND_EVENTS.register("block.oven.crackle", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block.oven.crackle")));
    public static final RegistryObject<SoundEvent> BLOCK_PIZZA_SIZZLING = SOUND_EVENTS.register("block.pizza.sizzling", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block.pizza.sizzling")));
    public static final RegistryObject<SoundEvent> BLOCK_CHOPPING_BOARD_KNIFE = SOUND_EVENTS.register("block.chopping_board.knife", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block.chopping_board.knife")));
    public static final RegistryObject<SoundEvent> BLOCK_BASIN_FERMENTING = SOUND_EVENTS.register("block.basin.fermenting", () -> SoundEvent.createVariableRangeEvent(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "block.basin.fermenting")));
}
