package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.google.common.collect.Lists;
import com.google.common.collect.Sets;
import com.mojang.serialization.Codec;
import net.minecraft.core.GlobalPos;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class ModMemoryModules {
    public static final DeferredRegister<MemoryModuleType<?>> MEMORY_MODULE_TYPES = DeferredRegister.create(ForgeRegistries.MEMORY_MODULE_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<MemoryModuleType<Integer>> ATTACK_TARGET_COOLDOWN = MEMORY_MODULE_TYPES.register("attack_target_cooldown", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final RegistryObject<MemoryModuleType<Integer>> CHARGE_COOLDOWN_TICKS = MEMORY_MODULE_TYPES.register("charge_cooldown_ticks", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final RegistryObject<MemoryModuleType<Boolean>> DANGER_DETECTED_RECENTLY = MEMORY_MODULE_TYPES.register("danger_detected_recently", () -> new MemoryModuleType<>(Optional.of(Codec.BOOL)));

    public static final RegistryObject<MemoryModuleType<Integer>> TRANSPORT_ITEMS_COOLDOWN_TICKS = MEMORY_MODULE_TYPES.register("transport_items_cooldown_ticks", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final RegistryObject<MemoryModuleType<Set<GlobalPos>>> VISITED_BLOCK_POSITIONS = MEMORY_MODULE_TYPES.register("visited_block_positions", () -> new MemoryModuleType<>(Optional.of(GlobalPos.CODEC.listOf().xmap(Sets::newHashSet, Lists::newArrayList))));
    public static final RegistryObject<MemoryModuleType<Set<GlobalPos>>> UNREACHABLE_TRANSPORT_BLOCK_POSITIONS = MEMORY_MODULE_TYPES.register("unreachable_transport_block_positions", () -> new MemoryModuleType<>(Optional.of(GlobalPos.CODEC.listOf().xmap(Sets::newHashSet, Lists::newArrayList))));
    public static final RegistryObject<MemoryModuleType<Integer>> GAZE_COOLDOWN_TICKS = MEMORY_MODULE_TYPES.register("gaze_cooldown_ticks", () -> new MemoryModuleType<>(Optional.of(Codec.INT)));
    public static final RegistryObject<MemoryModuleType<Boolean>> IS_PRESSING_BUTTON = MEMORY_MODULE_TYPES.register("is_pressing_button", () -> new MemoryModuleType<>(Optional.of(Codec.BOOL)));
    public static final RegistryObject<MemoryModuleType<Long>> LAST_CONTAINER_EMPTY = MEMORY_MODULE_TYPES.register("last_container_empty", () -> new MemoryModuleType<>(Optional.of(Codec.LONG)));
    public static final RegistryObject<MemoryModuleType<GlobalPos>> GOLEM_DETECTED_MISC_CHEST = MEMORY_MODULE_TYPES.register("golem_detected_misc_chest", () -> new MemoryModuleType<>(Optional.of(GlobalPos.CODEC)));

    public static void register(IEventBus eventBus) {
        MEMORY_MODULE_TYPES.register(eventBus);
    }
}
