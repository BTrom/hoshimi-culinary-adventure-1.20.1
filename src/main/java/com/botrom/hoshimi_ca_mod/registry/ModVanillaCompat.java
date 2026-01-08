package com.botrom.hoshimi_ca_mod.registry;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class ModVanillaCompat
{
    public static void setup()
    {
        registerCompostable(0.3F, ModItems.BROCCOLI_SEEDS.get());
        registerCompostable(0.3F, ModItems.CUCUMBER_SEEDS.get());
        registerCompostable(0.3F, ModItems.PEPPER_SEEDS.get());
        registerCompostable(0.3F, ModItems.PINEAPPLE_SEEDS.get());
        registerCompostable(0.3F, ModItems.CUT_CUCUMBER.get());
        registerCompostable(0.3F, ModItems.TOMATO_SLICE.get());
        registerCompostable(0.3F, ModItems.ONION_SLICE.get());
        registerCompostable(0.3F, ModItems.PEPPER_SLICE.get());
        registerCompostable(0.3F, ModItems.PINEAPPLE_SLICE.get());
        registerCompostable(0.3F, ModItems.MUSHROOM_SLICE.get());
        registerCompostable(0.5F, ModItems.OLIVE.get());
        registerCompostable(0.65F, ModItems.BROCCOLI.get());
        registerCompostable(0.65F, ModItems.CUCUMBER.get());
        registerCompostable(0.65F, ModItems.PEPPER.get());
        registerCompostable(0.65F, ModItems.PINEAPPLE.get());
        registerCompostable(0.65F, ModItems.CORN.get());
        registerCompostable(0.65F, ModItems.CORN_FLOUR.get());
    }

    public static void registerStrippable(Block log, Block strippedLog)
    {
        AxeItem.STRIPPABLES = Maps.newHashMap(AxeItem.STRIPPABLES);
        AxeItem.STRIPPABLES.put(log, strippedLog);
    }

    public static void registerFlammable(Block blockIn, int encouragement, int flammability)
    {
        FireBlock fireblock = (FireBlock) Blocks.FIRE;
        fireblock.setFlammable(blockIn, encouragement, flammability);
    }

    public static void registerCompostable(float chance, ItemLike itemIn)
    {
        ComposterBlock.COMPOSTABLES.put(itemIn.asItem(), chance);
    }
}