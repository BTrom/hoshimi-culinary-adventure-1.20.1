package com.botrom.hoshimi_ca_mod.items;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;

public interface ILeftClick {

    boolean onLeftClick(ItemStack stack, LivingEntity playerIn);
}
