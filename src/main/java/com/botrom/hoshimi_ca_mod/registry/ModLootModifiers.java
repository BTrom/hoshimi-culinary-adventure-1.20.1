package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.AddItemModifier;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.AddItemWithLootingEnchantModifier;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.common.SeedsLootModifier;
import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModLootModifiers
{
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<Codec<SeedsLootModifier>> SEEDS_LOOT_MODIFIER = LOOT_MODIFIERS.register("seeds_harvesting", () -> SeedsLootModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM = LOOT_MODIFIERS.register("add_item", AddItemModifier.CODEC);
    public static final RegistryObject<Codec<? extends IGlobalLootModifier>> ADD_ITEM_WITH_LOOTING_ENCHANT = LOOT_MODIFIERS.register("add_item_with_looting_enchant", AddItemWithLootingEnchantModifier.CODEC);
}