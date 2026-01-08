package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.BasinBlockEntity;
import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.PizzaBlockEntity;
import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.PizzaStationBlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockEntityTypes {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITY_TYPES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<BlockEntityType<PizzaBlockEntity>> PIZZA = BLOCK_ENTITY_TYPES.register("pizza",
            () -> BlockEntityType.Builder.of(PizzaBlockEntity::new, ModBlocks.RAW_PIZZA.get(), ModBlocks.PIZZA.get()).build(null));

    public static final RegistryObject<BlockEntityType<BasinBlockEntity>> BASIN = BLOCK_ENTITY_TYPES.register("basin",
            () -> BlockEntityType.Builder.of(BasinBlockEntity::new,
                    ModBlocks.GRANITE_BASIN.get(),
                    ModBlocks.DIORITE_BASIN.get(),
                    ModBlocks.ANDESITE_BASIN.get(),
                    ModBlocks.BASALT_BASIN.get(),
                    ModBlocks.BLACKSTONE_BASIN.get()).build(null));

    public static final RegistryObject<BlockEntityType<PizzaStationBlockEntity>> PIZZA_STATION = BLOCK_ENTITY_TYPES.register("pizza_station",
            () -> BlockEntityType.Builder.of(PizzaStationBlockEntity::new,
                    ModBlocks.PIZZA_STATION.get()).build(null));

//    public static void register(IEventBus eventBus) {
//        BLOCK_ENTITY_TYPES.register(eventBus);
//    }
}
