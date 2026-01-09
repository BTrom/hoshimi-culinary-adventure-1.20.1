package com.botrom.hoshimi_ca_mod.registry;

import com.google.common.collect.Maps;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.FireBlock;

public class ModVanillaCompat {
    public static void setup() {
        registerCompostable(0.3F, ModItems.CORN_KERNELS.get());
        registerCompostable(0.3F, ModItems.EGGPLANT_SEEDS.get());
        registerCompostable(0.3F, ModItems.AVOCADO_SEED.get());
        registerCompostable(0.3F, ModItems.BROCCOLI_SEEDS.get());
        registerCompostable(0.3F, ModItems.CUCUMBER_SEEDS.get());
        registerCompostable(0.3F, ModItems.PEPPER_SEEDS.get());
        registerCompostable(0.3F, ModItems.PINEAPPLE_SEEDS.get());
        registerCompostable(0.3F, ModItems.ACORN.get());
        registerCompostable(0.3F, ModItems.ROASTED_ACORN.get());
        registerCompostable(0.3F, ModItems.CUT_AVOCADO.get());
        registerCompostable(0.3F, ModItems.CUT_EGGPLANT.get());
        registerCompostable(0.3F, ModItems.SMOKED_TOMATO.get());
        registerCompostable(0.3F, ModItems.SMOKED_CORN.get());
        registerCompostable(0.3F, ModItems.CUT_PICKLE.get());
        registerCompostable(0.3F, ModItems.CUT_CUCUMBER.get());
        registerCompostable(0.3F, ModItems.TOMATO_SLICE.get());
        registerCompostable(0.3F, ModItems.ONION_SLICE.get());
        registerCompostable(0.3F, ModItems.PEPPER_SLICE.get());
        registerCompostable(0.3F, ModItems.PINEAPPLE_SLICE.get());
        registerCompostable(0.3F, ModItems.MUSHROOM_SLICE.get());
        registerCompostable(0.5F, ModItems.OLIVE.get());
        registerCompostable(0.5F, ModItems.CACTUS_FLESH.get());
        registerCompostable(0.5F, ModItems.CACTUS_STEAK.get());
        registerCompostable(0.65F, ModItems.BROCCOLI.get());
        registerCompostable(0.65F, ModItems.CUCUMBER.get());
        registerCompostable(0.65F, ModItems.PEPPER.get());
        registerCompostable(0.65F, ModItems.PINEAPPLE.get());
        registerCompostable(0.65F, ModItems.CORN.get());
        registerCompostable(0.65F, ModItems.CORN_FLOUR.get());
    }

    public static void registerCompostable(float chance, ItemLike itemIn) {
        ComposterBlock.COMPOSTABLES.put(itemIn.asItem(), chance);
    }
}