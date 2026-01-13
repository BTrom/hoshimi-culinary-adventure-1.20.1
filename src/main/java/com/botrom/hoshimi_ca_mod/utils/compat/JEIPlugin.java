package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.gui.CrabTrapCategory;
import com.botrom.hoshimi_ca_mod.gui.CrabTrapRecipeWrapper;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.recipe.RecipeType;
import mezz.jei.api.registration.IRecipeCatalystRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.ArrayList;
import java.util.List;

@JeiPlugin
public class JEIPlugin implements IModPlugin {
    private static final ResourceLocation PLUGIN_ID = Utils.createResourceLocation("jei_plugin");
    public static final RecipeType<CrabTrapRecipeWrapper> CRAB_TRAP_RECIPE = RecipeType.create(HoshimiCulinaryMod.MOD_ID, "crab_trap_loot", CrabTrapRecipeWrapper.class);


    @Override
    public ResourceLocation getPluginUid() {
        return PLUGIN_ID;
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new CrabTrapCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        registration.addRecipes(CRAB_TRAP_RECIPE, addWrappers());
    }

    @Override
    public void registerRecipeCatalysts(IRecipeCatalystRegistration registration) {
        registration.addRecipeCatalyst(new ItemStack(ModItems.CRAB_TRAP.get()), CRAB_TRAP_RECIPE);
    }

    public List<CrabTrapRecipeWrapper> addWrappers() {
        List<CrabTrapRecipeWrapper> list = new ArrayList<>();
        for (ItemStack item : ForgeRegistries.ITEMS.getValues().stream().map(ItemStack::new).toList()) {
            if (item.is(ModTags.CRAB_TRAP_BAIT)) {
                ResourceLocation registryName = ForgeRegistries.ITEMS.getKey(item.getItem());
                TagKey<Item> outputTag = TagKey.create(Registries.ITEM, Utils.createResourceLocation("jei_display_results/" + registryName.getNamespace() + "/" + registryName.getPath()));
                if (ForgeRegistries.ITEMS.tags().isKnownTagName(outputTag)) {
                    list.add(new CrabTrapRecipeWrapper(item, Ingredient.of(outputTag)));
                }

            }
        }
        return list;
    }
}
