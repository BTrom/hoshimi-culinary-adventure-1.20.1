package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.*;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blockentity.BasinBlockEntity;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blockentity.PizzaBlockEntity;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blockentity.PizzaStationBlockEntity;
import com.botrom.hoshimi_ca_mod.utils.compat.farmandcharm.StorageTypeRegistry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashSet;
import java.util.function.Supplier;

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
            () -> BlockEntityType.Builder.of(PizzaStationBlockEntity::new, ModBlocks.PIZZA_STATION.get()).build(null));

    public static final Supplier<BlockEntityType<CrabTrapBlockEntity>> CRAB_TRAP = BLOCK_ENTITY_TYPES.register("crab_trap",
            () -> BlockEntityType.Builder.of(CrabTrapBlockEntity::new, new Block[]{ModBlocks.CRAB_TRAP.get()}).build(null));

    public static final RegistryObject<BlockEntityType<BlockEntityTerrapinEgg>> TERRAPIN_EGG = BLOCK_ENTITY_TYPES.register("terrapin_egg_te",
            () -> BlockEntityType.Builder.of(BlockEntityTerrapinEgg::new, ModBlocks.TERRAPIN_EGG.get()).build(null));

    public static final Supplier<BlockEntityType<StorageBlockEntity>> STORAGE_ENTITY = BLOCK_ENTITY_TYPES.register("storage",
            () -> BlockEntityType.Builder.of(StorageBlockEntity::new, StorageTypeRegistry.registerBlocks(new HashSet<>()).toArray(new Block[0])).build(null));

    public static final Supplier<BlockEntityType<FeedingTroughBlockEntity>> FEEDING_TROUGH_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("feeding_trough",
            () -> BlockEntityType.Builder.of(FeedingTroughBlockEntity::new, ModBlocks.FEEDING_TROUGH.get()).build(null));

    public static final Supplier<BlockEntityType<PetBowlBlockEntity>> PET_BOWL_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("pet_bowl",
            () -> BlockEntityType.Builder.of(PetBowlBlockEntity::new, ModBlocks.PET_BOWL.get()).build(null));

    public static final Supplier<BlockEntityType<StoveBlockEntity>> STOVE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("stove_block",
            () -> BlockEntityType.Builder.of(StoveBlockEntity::new, ModBlocks.STOVE.get()).build(null));

    public static final RegistryObject<BlockEntityType<DeepFryingPanEntity>> DEEP_FRYING_PAN = BLOCK_ENTITY_TYPES.register("deep_frying_pan",
            () -> BlockEntityType.Builder.of(DeepFryingPanEntity::new, ModBlocks.DEEP_FRYING_PAN.get()).build(null));

    public static final RegistryObject<BlockEntityType<CrockPotBlockEntity>> CROCK_POT_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("crock_pot",
            () -> BlockEntityType.Builder.of(CrockPotBlockEntity::new, ModBlocks.CROCK_POT.get(), ModBlocks.PORTABLE_CROCK_POT.get()).build(null));

    public static final RegistryObject<BlockEntityType<BirdcageBlockEntity>> BIRDCAGE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("birdcage",
            () -> BlockEntityType.Builder.of(BirdcageBlockEntity::new, ModBlocks.BIRDCAGE.get()).build(null));

    public static final RegistryObject<BlockEntityType<EyeBoneBlockEntity>> EYE_BONE_BLOCK_ENTITY = BLOCK_ENTITY_TYPES.register("eye_bone",
            () -> BlockEntityType.Builder.of(EyeBoneBlockEntity::new, ModBlocks.EYE_BONE.get()).build(null));



//    public static void register(IEventBus eventBus) {
//        BLOCK_ENTITY_TYPES.register(eventBus);
//    }
}
