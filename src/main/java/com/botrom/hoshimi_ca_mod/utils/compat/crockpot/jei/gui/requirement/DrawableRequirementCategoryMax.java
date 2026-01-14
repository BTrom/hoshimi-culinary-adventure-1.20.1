package com.botrom.hoshimi_ca_mod.utils.compat.crockpot.jei.gui.requirement;

import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.FoodCategory;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.requirement.RequirementCategoryMax;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.jei.FoodValuesDefinitionCache;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.util.MathUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class DrawableRequirementCategoryMax extends AbstractDrawableRequirement<RequirementCategoryMax> {
    public DrawableRequirementCategoryMax(RequirementCategoryMax requirement) {
        super(requirement, MathUtils.fuzzyIsZero(requirement.getMax()) ? Component.translatable("integration.hoshimimod.jei.crock_pot_cooking.requirement.no") : Component.translatable("integration.hoshimimod.jei.crock_pot_cooking.requirement.le", requirement.getMax()));
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
        guiGraphics.drawString(Minecraft.getInstance().font, description, MathUtils.fuzzyIsZero(requirement.getMax()) ? xOffset + 3 : xOffset + 20, yOffset + 7, 0, false);
    }

    @Override
    public List<ItemStack> getInvisibleInputs() {
        return MathUtils.fuzzyIsZero(requirement.getMax()) ? List.of() : FoodValuesDefinitionCache.getMatchedItems(requirement.getCategory()).stream().map(Item::getDefaultInstance).toList();
    }

    @Override
    public List<GuiItemStacksInfo> getGuiItemStacksInfos(int xOffset, int yOffset) {
        return List.of(new GuiItemStacksInfo(List.of(FoodCategory.getItemStack(requirement.getCategory())), MathUtils.fuzzyIsZero(requirement.getMax()) ? xOffset + this.getWidth() - 19 : xOffset + 3, yOffset + 3, MathUtils.fuzzyIsZero(requirement.getMax())));
    }
}
