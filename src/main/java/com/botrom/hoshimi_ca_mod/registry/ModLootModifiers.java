package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.AddItemModifier;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.AddItemWithLootingEnchantModifier;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.common.SeedsLootModifier;
import com.mojang.serialization.Codec;
import net.minecraft.resources.ResourceLocation;
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

    public static final ResourceLocation CRAB_DIG_LOOT = Utils.createResourceLocation("gameplay/crab_dig_loot");
    public static final ResourceLocation WARM_OCEAN_POT_LOOT = Utils.createResourceLocation("gameplay/warm_ocean_pot_loot");
    public static final ResourceLocation NORMAL_OCEAN_POT_LOOT = Utils.createResourceLocation("gameplay/normal_ocean_pot_loot");
    public static final ResourceLocation COLD_OCEAN_POT_LOOT = Utils.createResourceLocation("gameplay/cold_ocean_pot_loot");
    public static final ResourceLocation DEEP_OCEAN_POT_LOOT = Utils.createResourceLocation("gameplay/deep_ocean_pot_loot");
    public static final ResourceLocation MANGROVE_POT_LOOT = Utils.createResourceLocation("gameplay/mangrove_pot_loot");
    public static final ResourceLocation RIVER_POT_LOOT = Utils.createResourceLocation("gameplay/river_pot_loot");
    public static final ResourceLocation NORMAL_POT_LOOT = Utils.createResourceLocation("gameplay/normal_pot_loot");
}