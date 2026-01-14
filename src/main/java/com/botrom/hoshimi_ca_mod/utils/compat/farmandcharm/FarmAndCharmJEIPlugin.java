package com.botrom.hoshimi_ca_mod.utils.compat.farmandcharm;

import com.botrom.hoshimi_ca_mod.gui.StoveGuiHandler;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModMenuTypes;
import com.botrom.hoshimi_ca_mod.registry.ModRecipes;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;


@JeiPlugin
public class FarmAndCharmJEIPlugin implements IModPlugin {

    public static void addSlot(IRecipeLayoutBuilder builder, int x, int y, Ingredient ingredient) {
        builder.addSlot(RecipeIngredientRole.INPUT, x, y).addIngredients(ingredient);
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new StoveCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
//
//        List<CookingPotRecipe> cookingRecipes = rm.getAllRecipesFor(RecipeTypeRegistry.COOKING_POT_RECIPE_TYPE.get());
//        registration.addRecipes(CookingPotCategory.COOKING_POT, cookingRecipes);
        List<StoveRecipe> stoveRecipes = rm.getAllRecipesFor(ModRecipes.STOVE_RECIPE_TYPE.get());
        registration.addRecipes(StoveCategory.STOVE, stoveRecipes);
    }

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return Utils.createResourceLocation("jei_plugin");
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
//        registration.addRecipeTransferHandler(new CookingPotTransferInfo());
        registration.addRecipeTransferHandler(StoveGuiHandler.class, ModMenuTypes.STOVE_SCREEN_HANDLER.get(), StoveCategory.STOVE, 1, 3, 5, 36);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
//        registration.addRecipeCatalyst(ObjectRegistry.COOKING_POT.get().asItem().getDefaultInstance(), CookingPotCategory.COOKING_POT);
        registration.addRecipeCatalyst(ModBlocks.STOVE.get().asItem().getDefaultInstance(), StoveCategory.STOVE);
    }
}
