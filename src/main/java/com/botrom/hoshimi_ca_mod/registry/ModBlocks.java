package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.*;
import com.botrom.hoshimi_ca_mod.pizzacraft.blocks.*;
import com.botrom.hoshimi_ca_mod.pizzacraft.blocks.crops.SimpleCropBlock;
import com.botrom.hoshimi_ca_mod.worldgen.tree.PalmTreeGrower;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HoshimiCulinaryMod.MOD_ID);


    // Wild Plants
    public static final RegistryObject<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers", () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_CORN = registerBlock("wild_corn", () -> new WildCropBlock(MobEffects.HUNGER, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_EGGPLANTS = registerBlock("wild_eggplants", () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> LIME_BUSH = registerBlockWithoutBlockItem("lime_bush", () -> new LimeBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DRAGON_BUSH = registerBlock("dragon_bush", () -> new WildCropBlock(MobEffects.GLOWING, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));


    // Crops
    public static final RegistryObject<Block> CUCUMBERS = registerBlockWithoutBlockItem("cucumbers", () -> new SimpleCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT), ModItems.CUCUMBER_SEEDS));
    public static final RegistryObject<Block> EGGPLANTS = registerBlockWithoutBlockItem("eggplants", () -> new EggplantCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> CORN_BOTTOM = registerBlockWithoutBlockItem("corn_bottom", () -> new CornBottomBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> CORN_UPPER = registerBlockWithoutBlockItem("corn_upper", () -> new CornUpperBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> BROCCOLI = registerBlock("broccoli", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.BROCCOLI_SEEDS));
    public static final RegistryObject<Block> PEPPERS = registerBlock("peppers", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.PEPPER_SEEDS));
    public static final RegistryObject<Block> PINEAPPLE = registerBlock("pineapple", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.PINEAPPLE_SEEDS));
    public static final RegistryObject<Block> BUDDING_DRAGON_FRUIT_CROP = registerBlockWithoutBlockItem("budding_dragon_fruits", () -> new BuddingDragonFruitBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> DRAGON_FRUIT_CROP = registerBlockWithoutBlockItem("dragon_fruits", () -> new DragonFruitVineBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    // Saplings
//    public static final RegistryObject<Block> AVOCADO_SEED = registerBlock("avocado_pit", () -> new AvocadoSeedBlock(new AvocadoPitGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), false, 0);
    public static final Supplier<Block> PALM_SAPLING = BLOCKS.register("palm_sapling", () -> new PalmSaplingBlock(new PalmTreeGrower(), Block.Properties.copy(Blocks.OAK_SAPLING), () -> Blocks.SAND));


    // Blocks
    public static final RegistryObject<Block> CORN_COB_CRATE = registerBlock("corn_crate", () -> new Block(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get())));
    public static final RegistryObject<Block> PIZZA_STATION = registerBlock("pizza_station", () -> new PizzaStationBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> PIZZA_OVEN = registerBlock("pizza_oven", () -> new OvenBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F).noOcclusion().lightLevel(getLightValueLit(9))));
    public static final RegistryObject<Block> GRANITE_BASIN = registerBlock("granite_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.DIRT).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BASIN = registerBlock("diorite_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BASIN = registerBlock("andesite_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BASALT_BASIN = registerBlock("basalt_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> BLACKSTONE_BASIN = registerBlock("blackstone_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> COCONUT = registerBlock("coconut", () -> new CoconutBlock(Block.Properties.copy(Blocks.COCOA)));
    public static final RegistryObject<Block> SEASHELLS = registerBlock("seashells", () -> new SeashellBlock(Block.Properties.copy(Blocks.HORN_CORAL).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final Supplier<Block> CRAB_TRAP = registerBlock("crab_trap", () -> new CrabTrapBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));


    // Meal Blocks
    public static final RegistryObject<Block> EXOTIC_ROLL_MEDLEY = registerBlock("exotic_roll_medley", () -> new ExoticRollMedleyBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get()).noOcclusion()));
    public static final RegistryObject<Block> PAELLA = registerBlock("paella", () -> new PaellaBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.METAL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PIZZA = registerBlock("pizza", () -> new PizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> RAW_PIZZA = registerBlock("raw_pizza", () -> new RawPizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DOUGH = registerBlock("pizza_dough", () -> new DoughBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> CHEESE_BLOCK = registerBlock("cheese_block", () -> new CheeseBlock(Block.Properties.copy(Blocks.CAKE).mapColor(MapColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> PANETTONE = registerBlockWithoutBlockItem("panettone", () -> new PanettoneBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE.get()), ModItems.PANETTONE_SLICE));
    public static final RegistryObject<Block> MUSHROOM_QUICHE = registerBlockWithoutBlockItem("mushroom_quiche", () -> new PieBlock(Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE.get()), ModItems.MUSHROOM_QUICHE_SLICE));
    public static final RegistryObject<Block> LIME_PIE = registerBlockWithoutBlockItem("lime_pie", () -> new PieBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE.get()), ModItems.LIME_PIE_SLICE));
    public static final RegistryObject<Block> POMEGRANATE_CAKE = registerBlockWithoutBlockItem("pomegranate_cake", () -> new EffectCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.POMEGRANATE_CAKE_SLICE));
    public static final RegistryObject<Block> DRAGON_FRUIT_CAKE = registerBlockWithoutBlockItem("dragon_fruit_cake", () -> new EffectCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.DRAGON_FRUIT_CAKE_SLICE));


    // Tree Blocks
    public static final Supplier<Block> PALM_LOG = registerBlock("palm_log", () -> new PalmLogBlock(Block.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final Supplier<Block> PALM_WOOD = registerBlock("palm_wood", () -> new PalmLogBlock(Block.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final Supplier<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", () -> new PalmLogBlock(Block.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final Supplier<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", () -> new PalmLogBlock(Block.Properties.copy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final Supplier<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new PalmLeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)));
    
    
    
    // Registry

//    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Integer stackSize, Boolean isFuel, Integer fuelAmount) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn, stackSize, isFuel, fuelAmount);
//        return toReturn;
//    }

    public static RegistryObject<Block> registerBlock(final String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

//    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Integer stackSize, Boolean isFuel, Integer fuelAmount) {
//        if (isFuel == false) {
//            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
//                    new Item.Properties().stacksTo(stackSize != 0 ? stackSize : 64)));
//        } else {
//
//            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
//                    new Item.Properties().stacksTo(stackSize != 0 ? stackSize : 64)) {
//                @Override
//                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
//                    return fuelAmount;
//                }
//            });
//        }
//    }

    public static Block[] getBasins() {
        return new Block[]{
                GRANITE_BASIN.get(),
                DIORITE_BASIN.get(),
                ANDESITE_BASIN.get(),
                BASALT_BASIN.get(),
                BLACKSTONE_BASIN.get()
        };
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}