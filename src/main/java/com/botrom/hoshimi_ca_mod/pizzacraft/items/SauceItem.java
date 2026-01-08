package com.botrom.hoshimi_ca_mod.pizzacraft.items;

import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.content.SauceType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.UseAnim;

public class SauceItem extends Item
{
    private final SauceType type;
    public SauceItem(Properties properties, SauceType type)
    {
        super(properties);
        this.type = type;
    }

    public SauceType getSauceType()
    {
        return this.type;
    }

    @Override
    public UseAnim getUseAnimation(ItemStack stack)
    {
        return UseAnim.DRINK;
    }
}