package com.botrom.hoshimi_ca_mod.items;

import com.botrom.hoshimi_ca_mod.registry.ModSounds;
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

	@Override
	public void affectConsumer(@NotNull ItemStack stack, @NotNull Level level, @NotNull LivingEntity consumer) {
		consumer.setTicksFrozen(consumer.getTicksFrozen() + 200);
		super.affectConsumer(stack, level, consumer);
	}

	@Override
	public @NotNull SoundEvent getEatingSound() {
		return ModSounds.ICE_CREAM_EAT.get();
	}
}