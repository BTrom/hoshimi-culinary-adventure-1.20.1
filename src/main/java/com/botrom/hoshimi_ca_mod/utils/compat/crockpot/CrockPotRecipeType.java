package com.botrom.hoshimi_ca_mod.utils.compat.crockpot;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;

public class CrockPotRecipeType<T extends Recipe<?>> implements RecipeType<T> {
    private final String name;

    public CrockPotRecipeType(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return HoshimiCulinaryMod.MOD_ID + ":" + this.name;
    }
}
