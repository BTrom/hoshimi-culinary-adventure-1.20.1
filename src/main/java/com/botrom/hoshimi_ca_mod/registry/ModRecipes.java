package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.recipes.crushing.CrushingRecipe;
import com.botrom.hoshimi_ca_mod.pizzacraft.recipes.crushing.CrushingRecipeSerializer;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HoshimiCulinaryMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> CRUSHING_RECIPE_SERIALIZER = SERIALIZERS.register(CrushingRecipeSerializer.ID.getPath(), () -> CrushingRecipeSerializer.INSTANCE);
    public static final RegistryObject<RecipeType<CrushingRecipe>> CRUSHING_RECIPE_TYPE = RECIPE_TYPES.register(CrushingRecipe.Type.ID, () -> CrushingRecipe.Type.CRUSHING_RECIPE_TYPE);
}
