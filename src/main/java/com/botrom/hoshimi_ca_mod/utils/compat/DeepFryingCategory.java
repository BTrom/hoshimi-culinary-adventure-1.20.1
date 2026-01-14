package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;

public class DeepFryingCategory implements IRecipeCategory<DeepFryingRecipe> {
    public static final ResourceLocation UID = Utils.createResourceLocation("deep_frying");
    public static final ResourceLocation TEXTURE =
            Utils.createResourceLocation("textures/gui/jei/deep_frying.png");
    private final IDrawable background;
    private final IDrawable icon;
    public DeepFryingCategory(IGuiHelper helper){
        this.background=helper.createDrawable(TEXTURE,0,0,117,57);
        this.icon=helper.createDrawableIngredient(VanillaTypes.ITEM_STACK,new ItemStack(ModBlocks.DEEP_FRYING_PAN.get()));
    }
    @Override
    public RecipeType<DeepFryingRecipe> getRecipeType() {
        return JEIPlugin.INFUSION_TYPE;
    }
    @Override
    public Component getTitle() {
        return Component.translatable("casualness_delight.jei.deep_frying");
    }

    @Override
    public IDrawable getBackground() {
        return this.background;
    }

    @Override
    public IDrawable getIcon() {
        return this.icon;
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, DeepFryingRecipe deepFryingRecipe, IFocusGroup iFocusGroup) {
        builder.addSlot(RecipeIngredientRole.INPUT, 16, 8).addIngredients(deepFryingRecipe.getIngredients().get(0));
        builder.addSlot(RecipeIngredientRole.OUTPUT, 79, 21).addItemStack(deepFryingRecipe.getResultItem());
    }
}
