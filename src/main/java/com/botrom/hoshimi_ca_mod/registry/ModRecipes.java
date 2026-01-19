package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.compat.FermenterRecipe;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.recipes.crushing.CrushingRecipe;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.recipes.crushing.CrushingRecipeSerializer;
import com.botrom.hoshimi_ca_mod.utils.compat.DeepFryingRecipe;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.*;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.CrockPotCookingRecipe;
import com.botrom.hoshimi_ca_mod.utils.compat.farmandcharm.StoveRecipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModRecipes
{
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.RECIPE_SERIALIZERS, HoshimiCulinaryMod.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> RECIPE_TYPES = DeferredRegister.create(ForgeRegistries.RECIPE_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<RecipeSerializer<?>> CRUSHING_RECIPE_SERIALIZER = SERIALIZERS.register(CrushingRecipeSerializer.ID.getPath(), () -> CrushingRecipeSerializer.INSTANCE);
    public static final RegistryObject<RecipeType<CrushingRecipe>> CRUSHING_RECIPE_TYPE = RECIPE_TYPES.register(CrushingRecipe.Type.ID, () -> CrushingRecipe.Type.CRUSHING_RECIPE_TYPE);

    public static final RegistryObject<RecipeType<StoveRecipe>> STOVE_RECIPE_TYPE = RECIPE_TYPES.register("stove", () -> new RecipeType<StoveRecipe>() {
                @Override
                public String toString() { return HoshimiCulinaryMod.MOD_ID + ":stove"; }
            });

    public static final RegistryObject<RecipeSerializer<StoveRecipe>> STOVE_RECIPE_SERIALIZER = SERIALIZERS.register("stove", StoveRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<DeepFryingRecipe>> DEEP_FRYING_SERIALIZER = SERIALIZERS.register("deep_frying", () -> DeepFryingRecipe.Serializer.INSTANCE);

    public static final RegistryObject<RecipeType<CrockPotCookingRecipe>> CROCK_POT_COOKING_RECIPE_TYPE = RECIPE_TYPES.register("crock_pot_cooking", () -> new CrockPotRecipeType<>("crock_pot_cooking"));
    public static final RegistryObject<RecipeType<ExplosionCraftingRecipe>> EXPLOSION_CRAFTING_RECIPE_TYPE = RECIPE_TYPES.register("explosion_crafting", () -> new CrockPotRecipeType<>("explosion_crafting"));
    public static final RegistryObject<RecipeType<FoodValuesDefinition>> FOOD_VALUES_RECIPE_TYPE = RECIPE_TYPES.register("food_values", () -> new CrockPotRecipeType<>("food_values"));
    public static final RegistryObject<RecipeType<ParrotFeedingRecipe>> PARROT_FEEDING_RECIPE_TYPE = RECIPE_TYPES.register("parrot_feeding", () -> new CrockPotRecipeType<>("parrot_feeding"));
    public static final RegistryObject<RecipeType<PiglinBarteringRecipe>> PIGLIN_BARTERING_RECIPE_TYPE = RECIPE_TYPES.register("piglin_bartering", () -> new CrockPotRecipeType<>("piglin_bartering"));

    public static final RegistryObject<RecipeSerializer<CrockPotCookingRecipe>> CROCK_POT_COOKING_RECIPE_SERIALIZER = SERIALIZERS.register("crock_pot_cooking", CrockPotCookingRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<ExplosionCraftingRecipe>> EXPLOSION_CRAFTING_RECIPE_SERIALIZER = SERIALIZERS.register("explosion_crafting", ExplosionCraftingRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<FoodValuesDefinition>> FOOD_VALUES_RECIPE_SERIALIZER = SERIALIZERS.register("food_values", FoodValuesDefinition.Serializer::new);
    public static final RegistryObject<RecipeSerializer<ParrotFeedingRecipe>> PARROT_FEEDING_RECIPE_SERIALIZER = SERIALIZERS.register("parrot_feeding", ParrotFeedingRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<PiglinBarteringRecipe>> PIGLIN_BARTERING_RECIPE_SERIALIZER = SERIALIZERS.register("piglin_bartering", PiglinBarteringRecipe.Serializer::new);
    public static final RegistryObject<RecipeSerializer<FermenterRecipe>> FERMENTING_SERIALIZER = SERIALIZERS.register(FermenterRecipe.Type.ID, FermenterRecipe.Serializer::new);


    public static void register(IEventBus bus) {
        RECIPE_TYPES.register(bus);
        SERIALIZERS.register(bus);
    }
}
