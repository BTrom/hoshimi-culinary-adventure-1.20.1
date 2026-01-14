package com.botrom.hoshimi_ca_mod.utils.compat.crockpot.jei.gui.requirement;

import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.FoodCategory;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.requirement.RequirementCategoryMin;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.jei.FoodValuesDefinitionCache;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class DrawableRequirementCategoryMin extends AbstractDrawableRequirement<RequirementCategoryMin> {
    public DrawableRequirementCategoryMin(RequirementCategoryMin requirement) {
        super(requirement, Component.translatable("integration.hoshimimod.jei.crock_pot_cooking.requirement.ge", requirement.getMin()));
    }

    @Override
    public int getWidth() {
        return 23 + Minecraft.getInstance().font.width(description);
    }

    @Override
    public int getHeight() {
        return 22;
    }

    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        super.draw(guiGraphics, xOffset, yOffset);
        guiGraphics.drawString(Minecraft.getInstance().font, description, xOffset + 20, yOffset + 7, 0, false);
    }

    @Override
    public List<ItemStack> getInvisibleInputs() {
        return FoodValuesDefinitionCache.getMatchedItems(requirement.getCategory()).stream().map(Item::getDefaultInstance).toList();
    }

    @Override
    public List<GuiItemStacksInfo> getGuiItemStacksInfos(int xOffset, int yOffset) {
        return List.of(new GuiItemStacksInfo(List.of(FoodCategory.getItemStack(requirement.getCategory())), xOffset + 3, yOffset + 3));
    }
}
