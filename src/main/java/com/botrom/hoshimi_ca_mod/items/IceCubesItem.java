package com.botrom.hoshimi_ca_mod.items;

import com.botrom.hoshimi_ca_mod.registry.ModSounds;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.Item;

public class IceCubesItem extends Item {

	public IceCubesItem(Properties properties) {
		super(properties);
	}

	@Override
	public SoundEvent getDrinkingSound() {
		return ModSounds.ICE_CUBES_EAT.get();
	}

	@Override
	public SoundEvent getEatingSound() {
		return ModSounds.ICE_CUBES_EAT.get();
	}
}
