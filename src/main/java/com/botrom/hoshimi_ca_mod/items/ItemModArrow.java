package com.botrom.hoshimi_ca_mod.items;

import com.botrom.hoshimi_ca_mod.entities.EntitySharkToothArrow;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Arrow;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public class ItemModArrow extends ArrowItem {
    public ItemModArrow(Properties group) {
        super(group);
    }

    public AbstractArrow createArrow(Level worldIn, ItemStack stack, LivingEntity shooter) {
        if(this == ModItems.SHARK_TOOTH_ARROW.get()){
            Arrow arrowentity = new EntitySharkToothArrow(worldIn, shooter);
            arrowentity.setEffectsFromItem(stack);
            return arrowentity;
        }else {
            return super.createArrow(worldIn, stack, shooter);
        }
    }

}
