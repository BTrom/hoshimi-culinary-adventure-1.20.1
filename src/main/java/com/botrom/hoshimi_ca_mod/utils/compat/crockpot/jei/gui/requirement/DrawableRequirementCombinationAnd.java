package com.botrom.hoshimi_ca_mod.utils.compat.crockpot.jei.gui.requirement;

import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.requirement.IRequirement;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.requirement.RequirementCombinationAnd;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class DrawableRequirementCombinationAnd extends AbstractDrawableRequirement<RequirementCombinationAnd> {
    private final AbstractDrawableRequirement<? extends IRequirement> first, second;

    public DrawableRequirementCombinationAnd(RequirementCombinationAnd requirement) {
        super(requirement, null);
        this.first = AbstractDrawableRequirement.createDrawable(requirement.getFirst());
        this.second = AbstractDrawableRequirement.createDrawable(requirement.getSecond());
    }

    @Override
    public int getWidth() {
        return 6 + Math.max(first.getWidth(), second.getWidth());
    }

    @Override
    public int getHeight() {
        return 7 + first.getHeight() + second.getHeight();
    }

    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        super.draw(guiGraphics, xOffset, yOffset);
        first.draw(guiGraphics, xOffset + 3, yOffset + 3);
        second.draw(guiGraphics, xOffset + 3, yOffset + first.getHeight() + 4);
    }

    @Override
    public List<ItemStack> getInvisibleInputs() {
        ImmutableList.Builder<ItemStack> builder = ImmutableList.builder();
        builder.addAll(first.getInvisibleInputs());
        builder.addAll(second.getInvisibleInputs());
        return builder.build();
    }

    @Override
    public List<GuiItemStacksInfo> getGuiItemStacksInfos(int xOffset, int yOffset) {
        ImmutableList.Builder<GuiItemStacksInfo> builder = ImmutableList.builder();
        builder.addAll(first.getGuiItemStacksInfos(xOffset + 3, yOffset + 3));
        builder.addAll(second.getGuiItemStacksInfos(xOffset + 3, yOffset + first.getHeight() + 4));
        return builder.build();
    }
}
