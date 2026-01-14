package com.botrom.hoshimi_ca_mod.utils.compat.crockpot.jei.gui.requirement;

import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.requirement.IRequirement;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.cooking.requirement.RequirementCombinationOr;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;

import java.util.List;

public class DrawableRequirementCombinationOr extends AbstractDrawableRequirement<RequirementCombinationOr> {
    private final AbstractDrawableRequirement<? extends IRequirement> first, second;

    public DrawableRequirementCombinationOr(RequirementCombinationOr requirement) {
        super(requirement, Component.translatable("integration.hoshimimod.jei.crock_pot_cooking.requirement.or"));
        this.first = AbstractDrawableRequirement.createDrawable(requirement.getFirst());
        this.second = AbstractDrawableRequirement.createDrawable(requirement.getSecond());
    }

    @Override
    public int getWidth() {
        return 8 + first.getWidth() + second.getWidth() + Minecraft.getInstance().font.width(description);
    }

    @Override
    public int getHeight() {
        return 6 + Math.max(first.getHeight(), second.getHeight());
    }

    @Override
    public void draw(GuiGraphics guiGraphics, int xOffset, int yOffset) {
        super.draw(guiGraphics, xOffset, yOffset);
        first.draw(guiGraphics, xOffset + 3, yOffset + (this.getHeight() / 2) - (first.getHeight() / 2));
        guiGraphics.drawString(Minecraft.getInstance().font, description, xOffset + first.getWidth() + 4, yOffset + (this.getHeight() / 2) - 4, 0, false);
        second.draw(guiGraphics, xOffset + this.getWidth() - second.getWidth() - 3, yOffset + (this.getHeight() / 2) - (second.getHeight() / 2));
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
        builder.addAll(first.getGuiItemStacksInfos(xOffset + 3, yOffset + (this.getHeight() / 2) - (first.getHeight() / 2)));
        builder.addAll(second.getGuiItemStacksInfos(xOffset + this.getWidth() - second.getWidth() - 3, yOffset + (this.getHeight() / 2) - (second.getHeight() / 2)));
        return builder.build();
    }
}
