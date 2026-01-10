package com.botrom.hoshimi_ca_mod.items;

import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import vectorwing.farmersdelight.common.item.ConsumableItem;

public class IceCreamItem extends ConsumableItem {
	public IceCreamItem(Item.Properties properties) {
		super(properties.craftRemainder(Items.BOWL).stacksTo(1), false, false);
	}

//	public IceCreamItem(Item.Properties properties, float heal) {
//		super(properties.craftRemainder(Items.BOWL).stacksTo(1), false, false, heal, Modid.N);
//	}

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		consumer.setTicksFrozen(consumer.getTicksFrozen() + 200);
		super.affectConsumer(stack, level, consumer);
	}

//	@Override
//	public @NotNull SoundEvent getEatingSound() {
//		return NeapolitanCompat.getIceCreamEatSound();
//	}
}