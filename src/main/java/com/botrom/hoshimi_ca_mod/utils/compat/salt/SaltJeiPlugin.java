package com.botrom.hoshimi_ca_mod.utils.compat.salt;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.google.common.collect.ImmutableList;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.NotNull;

import java.util.Objects;

@JeiPlugin
public class SaltJeiPlugin implements IModPlugin {
    public static final RecipeType<SaltEvaporationDummy> SALT_EVAPORATION_RECIPE_TYPE =
            RecipeType.create(HoshimiCulinaryMod.MOD_ID, "salt_evaporation", SaltEvaporationDummy.class);
    public static final RecipeType<SaltCrystalGrowingDummy> SALT_CRYSTAL_GROWING_RECIPE_TYPE =
            RecipeType.create(HoshimiCulinaryMod.MOD_ID, "salt_crystal_growing", SaltCrystalGrowingDummy.class);

    private static final ResourceLocation ID = Utils.createResourceLocation("jei_plugin");

    @Override
    public @NotNull ResourceLocation getPluginUid() {
        return ID;
    }

    @Override
    public void registerCategories(@NotNull IRecipeCategoryRegistration registration) {
        if (isSaltEvaporationEnabled())
            registration.addRecipeCategories(new SaltEvaporationCategory(registration.getJeiHelpers().getGuiHelper()));

        if (isSaltCrystalGrowingEnabled())
            registration.addRecipeCategories(new SaltCrystalGrowingCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipeCatalysts(@NotNull IRecipeCatalystRegistration registration) {
        if (isSaltEvaporationEnabled())
            registration.addRecipeCatalyst(new ItemStack(Items.CAULDRON), SALT_EVAPORATION_RECIPE_TYPE);

        if (isSaltCrystalGrowingEnabled())
            registration.addRecipeCatalyst(new ItemStack(ModItems.RAW_ROCK_SALT_BLOCK.get()), SALT_CRYSTAL_GROWING_RECIPE_TYPE);
    }

    @Override
    public void registerRecipes(@NotNull IRecipeRegistration registration) {
        if (isSaltEvaporationEnabled())
            registration.addRecipes(SALT_EVAPORATION_RECIPE_TYPE, ImmutableList.of(new SaltEvaporationDummy()));

        if (isSaltCrystalGrowingEnabled())
            registration.addRecipes(SALT_CRYSTAL_GROWING_RECIPE_TYPE, ImmutableList.of(new SaltCrystalGrowingDummy()));
    }

//    @Override
//    public void registerVanillaCategoryExtensions(IVanillaCategoryExtensionRegistration registration) {
//        registration.getCraftingCategory()
//                .addCategoryExtension(SaltingRecipe.class, SaltingShapelessExtension::new);
//    }

    private boolean isSaltEvaporationEnabled() {
        return ModConfig.evaporationChance > 0.0d
                && !Objects.requireNonNull(ForgeRegistries.BLOCKS.tags()).getTag(ModTags.HEATERS).isEmpty();
    }

    private boolean isSaltCrystalGrowingEnabled() {
        return ModConfig.saltClusterGrowingChance > 0.0d;
    }
}
