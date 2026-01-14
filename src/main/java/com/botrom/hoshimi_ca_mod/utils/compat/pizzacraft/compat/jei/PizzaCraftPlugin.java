package com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.compat.jei;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.recipes.crushing.CrushingRecipe;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModRecipes;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.category.IRecipeCategory;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.runtime.IIngredientManager;
import mezz.jei.library.plugins.vanilla.crafting.CategoryRecipeValidator;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeManager;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@JeiPlugin
public class PizzaCraftPlugin implements IModPlugin {
    @Nullable
    private IRecipeCategory<CrushingRecipe> crushingCategory;

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(crushingCategory = new CrushingRecipeCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        for (Block basin : ModBlocks.getBasins()) {
            registration.addRecipeCatalyst(new ItemStack(basin), CrushingRecipeCategory.CRUSHING);
        }
    }

    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "hoshimimod");
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        IIngredientManager ingredientManager = registration.getIngredientManager();

        registration.addRecipes(CrushingRecipeCategory.CRUSHING, getCrushing(crushingCategory, ingredientManager));
    }

    public List<CrushingRecipe> getCrushing(IRecipeCategory<CrushingRecipe> crushing, IIngredientManager ingredientManager) {
        CategoryRecipeValidator<CrushingRecipe> validator = new CategoryRecipeValidator<>(crushing, ingredientManager, 1);
        return getValidHandledRecipes(Minecraft.getInstance().level.getRecipeManager(), ModRecipes.CRUSHING_RECIPE_TYPE.get(), validator);
    }

    private static <C extends Container, T extends Recipe<C>> List<T> getValidHandledRecipes(
            RecipeManager recipeManager,
            RecipeType<T> recipeType,
            CategoryRecipeValidator<T> validator
    ) {
        return recipeManager.getAllRecipesFor(recipeType)
                .stream()
                .filter(validator::isRecipeHandled)  /*validator.isRecipeValid(r) &&  */
                .toList();
    }
}
