package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.effects.CorrosionEffect;
import com.botrom.hoshimi_ca_mod.effects.ReboundEffect;
import com.botrom.hoshimi_ca_mod.effects.SurgeEffect;
import com.botrom.hoshimi_ca_mod.effects.VolatilityEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, HoshimiCulinaryMod.MOD_ID);

	public static final RegistryObject<MobEffect> CORROSION = EFFECTS.register("corrosion", CorrosionEffect::new);
	public static final RegistryObject<MobEffect> VOLATILITY = EFFECTS.register("volatility", VolatilityEffect::new);
	public static final RegistryObject<MobEffect> SURGE = EFFECTS.register("surge", SurgeEffect::new);
	public static final RegistryObject<MobEffect> REBOUND = EFFECTS.register("rebound", ReboundEffect::new);

	public static void register(IEventBus bus) {
		EFFECTS.register(bus);
	}
}