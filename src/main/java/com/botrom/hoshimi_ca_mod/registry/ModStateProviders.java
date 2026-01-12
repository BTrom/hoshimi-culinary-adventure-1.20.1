package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.worldgen.RandomSeashellStateProvider;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProviderType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModStateProviders {
    public static final DeferredRegister<BlockStateProviderType<?>> PROVIDERS = DeferredRegister.create(Registries.BLOCK_STATE_PROVIDER_TYPE, HoshimiCulinaryMod.MOD_ID);

    public static final Supplier<BlockStateProviderType<RandomSeashellStateProvider>> RANDOM_SEASHELL = PROVIDERS.register("random_seashell",
            () -> new BlockStateProviderType<>(RandomSeashellStateProvider.CODEC));

}