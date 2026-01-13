package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.recipes.crushing.CrushingRecipe;
import com.botrom.hoshimi_ca_mod.pizzacraft.recipes.crushing.CrushingRecipeSerializer;
import com.botrom.hoshimi_ca_mod.utils.compat.StoveRecipe;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Supplier;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HoshimiCulinaryMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> CRUSHING_RECIPE_SERIALIZER = SERIALIZERS.register(CrushingRecipeSerializer.ID.getPath(), () -> CrushingRecipeSerializer.INSTANCE);
    public static final RegistryObject<RecipeType<CrushingRecipe>> CRUSHING_RECIPE_TYPE = RECIPE_TYPES.register(CrushingRecipe.Type.ID, () -> CrushingRecipe.Type.CRUSHING_RECIPE_TYPE);

    public static final RegistryObject<RecipeType<StoveRecipe>> STOVE_RECIPE_TYPE =
            RECIPE_TYPES.register("stove", () -> new RecipeType<StoveRecipe>() {
                @Override
                public String toString() { return HoshimiCulinaryMod.MOD_ID + ":stove"; }
            });

    public static final RegistryObject<RecipeSerializer<StoveRecipe>> STOVE_RECIPE_SERIALIZER =
            SERIALIZERS.register("stove", StoveRecipe.Serializer::new);

    public static void register(IEventBus bus) {
        RECIPE_TYPES.register(bus);
        SERIALIZERS.register(bus);
    }
}
