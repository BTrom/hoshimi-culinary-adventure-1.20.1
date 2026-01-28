package com.botrom.hoshimi_ca_mod.utils.compat.salt;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import mezz.jei.api.constants.VanillaTypes;
import mezz.jei.api.gui.builder.IRecipeLayoutBuilder;
import mezz.jei.api.gui.drawable.IDrawable;
import mezz.jei.api.gui.ingredient.IRecipeSlotsView;
import mezz.jei.api.helpers.IGuiHelper;
import mezz.jei.api.recipe.IFocusGroup;
import mezz.jei.api.recipe.RecipeIngredientRole;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.recipe.category.IRecipeCategory;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class SaltEvaporationCategory implements IRecipeCategory<SaltEvaporationDummy> {
    public static final ResourceLocation UID = Utils.createResourceLocation("salt_evaporation");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/gui/jei/salt_evaporation.png");
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    private final List<Component> waterCauldronTooltip = List.of(Component.translatable("block.minecraft.water_cauldron"));
    private final List<Component> saltCauldronTooltip = List.of(Component.translatable("block.salt.salt_cauldron"));
    private final List<Component> heatSourceTooltip = List.of(
            Component.translatable("integration.hoshimimod.jei.salt_evaporation.heat_source.tooltip"),
            Component.translatable("integration.hoshimimod.jei.salt_evaporation.heat_source.tooltip_2").withStyle(ChatFormatting.GRAY)
                    .append(Component.literal(ModTags.HEATERS.location().toString()).withStyle(ChatFormatting.GOLD)));

    public SaltEvaporationCategory(IGuiHelper guiHelper) {
        title = Component.translatable("integration.hoshimimod.jei.salt_evaporation");
        background = guiHelper.createDrawable(TEXTURE, 0, 0, 168, 90);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.SALT.get()));
    }

    @Override
    public @NotNull List<Component> getTooltipStrings(@NotNull SaltEvaporationDummy recipe, @NotNull IRecipeSlotsView recipeSlotsView, double mouseX, double mouseY) {
        if ( (mouseX >= 15 && mouseX < 60) && (mouseY >= 8 && mouseY < 50))
            return waterCauldronTooltip;
        else if ( (mouseX >= 15 && mouseX < 60) && (mouseY >= 50 && mouseY < 85))
            return heatSourceTooltip;
        else if ( (mouseX >= 106 && mouseX < 153) && (mouseY >= 31 && mouseY < 76))
            return saltCauldronTooltip;

        return Collections.emptyList();
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, @NotNull SaltEvaporationDummy recipe, @NotNull IFocusGroup focuses) {
        Item salt = Objects.requireNonNull(ForgeRegistries.ITEMS.tags()).getTag(ModTags.FORGE_SALTS).stream().findFirst()
                .orElse(ModItems.SALT.get());

        builder.addSlot(RecipeIngredientRole.OUTPUT, 122, 14)
                .addItemStack(new ItemStack(salt));
    }

    @Override
    public @NotNull RecipeType<SaltEvaporationDummy> getRecipeType() {
        return SaltJeiPlugin.SALT_EVAPORATION_RECIPE_TYPE;
    }

    @Override
    public @NotNull Component getTitle() {
        return title;
    }
    @Override
    public @NotNull IDrawable getBackground() {
        return background;
    }
    @Override
    public @NotNull IDrawable getIcon() {
        return icon;
    }
}
