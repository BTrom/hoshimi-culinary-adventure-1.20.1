package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.gui.TeaKettleGuiHandler;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModMenuTypes;
import com.botrom.hoshimi_ca_mod.registry.ModRecipes;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import mezz.jei.api.registration.IRecipeTransferRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Objects;

@JeiPlugin
public class HerbalBrewsJEIPlugin implements IModPlugin {
    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new TeaKettleCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager rm = Objects.requireNonNull(Minecraft.getInstance().level).getRecipeManager();
        List<TeaKettleRecipe> cookingCauldronRecipes = rm.getAllRecipesFor(ModRecipes.TEA_KETTLE_RECIPE_TYPE.get());
        registration.addRecipes(TeaKettleCategory.TEA_KETTLE_TYPE, cookingCauldronRecipes);
    }


    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return Utils.createResourceLocation("jei_plugin");
    }

    @Override
    public void registerRecipeTransferHandlers(IRecipeTransferRegistration registration) {
        registration.addRecipeTransferHandler(TeaKettleGuiHandler.class, ModMenuTypes.TEA_KETTLE_SCREEN_HANDLER.get(), TeaKettleCategory.TEA_KETTLE_TYPE, 1, 6, 7, 36);
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(ModBlocks.TEA_KETTLE.get().asItem().getDefaultInstance(), TeaKettleCategory.TEA_KETTLE_TYPE);
        registration.addRecipeCatalyst(ModBlocks.COPPER_TEA_KETTLE.get().asItem().getDefaultInstance(), TeaKettleCategory.TEA_KETTLE_TYPE);
    }
}
