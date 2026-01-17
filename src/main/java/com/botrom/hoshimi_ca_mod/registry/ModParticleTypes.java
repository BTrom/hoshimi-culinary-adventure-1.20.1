package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.core.particles.ParticleType;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> PARTICLE_TYPES = DeferredRegister.create(ForgeRegistries.PARTICLE_TYPES, HoshimiCulinaryMod.MOD_ID);

	public static final RegistryObject<SimpleParticleType> ACID = PARTICLE_TYPES.register("acid", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SHOCKWAVE = PARTICLE_TYPES.register("shockwave", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SURGE = PARTICLE_TYPES.register("surge", () -> new SimpleParticleType(true));
	public static final RegistryObject<SimpleParticleType> SHOCKED = PARTICLE_TYPES.register("shocked", ()-> new SimpleParticleType(false));
	public static final RegistryObject<SimpleParticleType> WHALE_SPLASH = PARTICLE_TYPES.register("whale_splash", ()-> new SimpleParticleType(false));

	public static void create(IEventBus bus) {
		PARTICLE_TYPES.register(bus);
	}
}