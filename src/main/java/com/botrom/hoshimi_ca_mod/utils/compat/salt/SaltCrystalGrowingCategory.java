package com.botrom.hoshimi_ca_mod.utils.compat.salt;

import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
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
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class SaltCrystalGrowingCategory implements IRecipeCategory<SaltCrystalGrowingDummy> {
    public static final ResourceLocation UID = Utils.createResourceLocation("salt_crystal_growing");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/gui/jei/salt_crystal_growing.png");
    private final Component title;
    private final IDrawable background;
    private final IDrawable icon;

    public SaltCrystalGrowingCategory(IGuiHelper guiHelper) {
        title = Component.translatable("integration.hoshimimod.jei.salt_crystal_growing");
        background = guiHelper.createDrawable(TEXTURE, 0, 0, 168, 152);
        icon = guiHelper.createDrawableIngredient(VanillaTypes.ITEM_STACK, new ItemStack(ModItems.SALT_CLUSTER.get()));
    }

    @Override
    public void setRecipe(IRecipeLayoutBuilder builder, @NotNull SaltCrystalGrowingDummy recipe, @NotNull IFocusGroup focuses) {
        builder.addSlot(RecipeIngredientRole.INPUT, 104, 8)
                .addItemStack(new ItemStack(Items.WATER_BUCKET));

        builder.addSlot(RecipeIngredientRole.INPUT, 104, 37)
                .addItemStack(new ItemStack(Items.DRIPSTONE_BLOCK));

        builder.addSlot(RecipeIngredientRole.INPUT, 104, 66)
                .addItemStack(new ItemStack(Items.POINTED_DRIPSTONE));

        builder.addSlot(RecipeIngredientRole.OUTPUT, 104, 98)
                .addItemStacks(List.of(
                        new ItemStack(ModItems.SMALL_SALT_BUD.get()),
                        new ItemStack(ModItems.MEDIUM_SALT_BUD.get()),
                        new ItemStack(ModItems.LARGE_SALT_BUD.get()),
                        new ItemStack(ModItems.SALT_CLUSTER.get())));

        //noinspection DataFlowIssue
        List<ItemStack> growables = ForgeRegistries.BLOCKS.tags().getTag(ModTags.SALT_CLUSTER_GROWABLES).stream().map(ItemStack::new).toList();
        builder.addSlot(RecipeIngredientRole.INPUT, 104, 127)
                .addItemStacks(growables);
    }

    @Override
    public @NotNull RecipeType<SaltCrystalGrowingDummy> getRecipeType() {
        return SaltJeiPlugin.SALT_CRYSTAL_GROWING_RECIPE_TYPE;
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
