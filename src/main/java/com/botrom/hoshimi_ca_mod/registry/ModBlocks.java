package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.*;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blocks.*;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blocks.crops.SimpleCropBlock;
import com.botrom.hoshimi_ca_mod.worldgen.tree.PalmTreeGrower;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.ItemLike;
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

import javax.annotation.Nonnull;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HoshimiCulinaryMod.MOD_ID);


    // Wild Plants
    public static final RegistryObject<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers", () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_EGGPLANTS = registerBlock("wild_eggplants", () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> LIME_BUSH = registerBlockWithoutBlockItem("lime_bush", () -> new LimeBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DRAGON_BUSH = registerBlock("dragon_bush", () -> new WildCropBlock(MobEffects.GLOWING, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_TEA_BUSH = registerBlock("wild_tea_bush", () -> new WildTeaBushBlock(Block.Properties.of().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> WILD_CORN = registerBlock("wild_corn", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<Block> WILD_STRAWBERRIES = registerBlock("wild_strawberries", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.AZURE_BLUET)));
    public static final RegistryObject<Block> WILD_COTTON = BLOCKS.register("wild_cotton", () -> new WildCropBlock(MobEffects.JUMP, 5, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_COFFEE = BLOCKS.register("wild_coffee", () -> new WildCropBlock(MobEffects.DIG_SPEED, 8, Block.Properties.copy(Blocks.TALL_GRASS)));


    // Fauna
    public static RegistryObject<Block> ANEMONE_ROSE_BULB  = registerBlock("anemone_rose_bulb", () -> new AnemoneBlock(Block.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).destroyTime(0.1F).sound(SoundType.SLIME_BLOCK)));
    public static RegistryObject<Block> ANEMONE_SAND  = registerBlock("anemone_sand", () -> new AnemoneBlock(Block.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).destroyTime(0.1F).sound(SoundType.SLIME_BLOCK)));
    public static RegistryObject<Block> ANEMONE_SEBAE  = registerBlock("anemone_sebae", () -> new AnemoneBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).destroyTime(0.1F).sound(SoundType.SLIME_BLOCK)));


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
    public static final RegistryObject<Block> GREEN_ONIONS = registerBlockWithoutBlockItem("green_onions", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GARLICS = registerBlockWithoutBlockItem("garlics", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> PEANUT_PLANT = registerBlockWithoutBlockItem("peanuts", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> SQUASHES = registerBlockWithoutBlockItem("squashes", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> TEA_BUSH = registerBlockWithoutBlockItem("tea_bush", () -> new TeaBushBlock(Block.Properties.of().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> SMALL_TEA_BUSH = registerBlockWithoutBlockItem("small_tea_bush", () -> new SmallTeaBushBlock(Block.Properties.of().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> OAT_CROP = registerBlockWithoutBlockItem("oat_crop", () -> new OatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> STRAWBERRY_CROP = registerBlockWithoutBlockItem("strawberry_crop", () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> COTTON_CROP = BLOCKS.register("cotton", () -> new CottonCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> COFFEE_CROP = BLOCKS.register("coffee", () -> new CoffeeCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> UNKNOWN_CROPS = BLOCKS.register("unknown_crops", UnknownCropsBlock::new);
    public static final RegistryObject<Block> ASPARAGUS = BLOCKS.register("asparaguses", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));


    // Saplings
//    public static final RegistryObject<Block> AVOCADO_SEED = registerBlock("avocado_pit", () -> new AvocadoSeedBlock(new AvocadoPitGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), false, 0);
    public static final RegistryObject<Block> PALM_SAPLING = BLOCKS.register("palm_sapling", () -> new PalmSaplingBlock(new PalmTreeGrower(), Block.Properties.copy(Blocks.OAK_SAPLING), () -> Blocks.SAND));


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
    public static final RegistryObject<Block> CRAB_TRAP = registerBlock("crab_trap", () -> new CrabTrapBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> RAINBOW_GLASS = registerBlock("rainbow_glass", BlockRainbowGlass::new);
    public static final RegistryObject<Block> COFFEE_BEANS_SACK = registerBlock("coffee_beans_sack", () -> new Block(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get())));
    public static final RegistryObject<Block> FEEDING_TROUGH = registerBlock("feeding_trough", () -> new FeedingTroughBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PET_BOWL = registerBlock("pet_bowl", () -> new PetBowlBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHICKEN_NEST = registerBlock("chicken_nest", () -> new ChickenNestBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).noCollission().instabreak()));
    public static final RegistryObject<Block> STOVE = registerBlock("stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistryObject<Block> DOG_FOOD_BAG = registerBlock("dog_food_bag", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CARPET), 3));
    public static final RegistryObject<Block> CAT_FOOD_BAG = registerBlock("cat_food_bag", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CARPET), 3));
    public static final RegistryObject<Block> COTTON_BOLL_CRATE = registerBlock("cotton_boll_crate", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DEEP_FRYING_PAN = registerBlock("deep_frying_pan", () -> new DeepFryingPan(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<Block> CROCK_POT = BLOCKS.register("crock_pot", () -> new CrockPotBlock(0));
    public static final RegistryObject<Block> PORTABLE_CROCK_POT = BLOCKS.register("portable_crock_pot", () -> new CrockPotBlock(1));
    public static final RegistryObject<Block> BIRDCAGE = BLOCKS.register("birdcage", BirdcageBlock::new);


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
    public static final RegistryObject<Block> FARMERS_BREAKFAST = registerBlockWithoutBlockItem("farmers_breakfast_block", () -> new FoodBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(12).saturationMod(1.2F).build()));
    public static final RegistryObject<Block> OAT_PANCAKE_BLOCK = registerBlockWithoutBlockItem("oat_pancake_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 7));
    public static final RegistryObject<Block> POTATO_WITH_ROAST_MEAT = registerBlockWithoutBlockItem("potato_with_roast_meat_block", () -> new FoodBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).build()));
    public static final RegistryObject<Block> ROASTED_CORN_BLOCK = registerBlockWithoutBlockItem("roasted_corn_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4));
    public static final RegistryObject<Block> FARMERS_BREAD = registerBlockWithoutBlockItem("farmers_bread_block", () -> new FoodBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(6).saturationMod(0.8F).build()));
    public static final RegistryObject<Block> CHERRY_BLOSSOM_CHEESECAKE = registerBlockWithoutBlockItem("cherry_blossom_cheesecake", () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.CHERRY_BLOSSOM_CHEESECAKE_SLICE));
    public static final RegistryObject<Block> PANCAKES = registerBlockWithoutBlockItem("pancakes", () -> new PancakeBlock(ModItems.PANCAKE, Block.Properties.copy(Blocks.CAKE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHOCOLATE_PANCAKES = BLOCKS.register("chocolate_pancakes", () -> new PancakeBlock(ModItems.CHOCOLATE_PANCAKE, Block.Properties.copy(Blocks.CAKE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRING_ROLL_MEDLEY = BLOCKS.register("spring_roll_medley", () -> new SpringRollMedley(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PLATE_OF_FRIED_DUMPLING = BLOCKS.register("plate_of_fried_dumpling", () -> new PlateOfFriedDumpling(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> BACON_EGGS = BLOCKS.register("bacon_eggs", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> BONE_SOUP = BLOCKS.register("bone_soup", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> BONE_STEW = BLOCKS.register("bone_stew", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.LANTERN), 3));
    public static final RegistryObject<Block> BREAKFAST_SKILLET = BLOCKS.register("breakfast_skillet", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.LANTERN), 3));
    public static final RegistryObject<Block> BUNNY_STEW = BLOCKS.register("bunny_stew", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> CALIFORNIA_ROLL = BLOCKS.register("california_roll", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOL), 3));
    public static final RegistryObject<Block> CEVICHE = BLOCKS.register("ceviche", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> GLOW_BERRY_MOUSSE = BLOCKS.register("glow_berry_mousse", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> HONEY_NUGGETS = BLOCKS.register("honey_nuggets", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> HOT_CHILI = BLOCKS.register("hot_chili", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> ICED_TEA = BLOCKS.register("iced_tea", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.GLASS), 3));
    public static final RegistryObject<Block> JAMMY_PRESERVES = BLOCKS.register("jammy_preserves", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> MEAT_BALLS = BLOCKS.register("meat_balls", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> MONSTER_LASAGNA = BLOCKS.register("monster_lasagna", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> MONSTER_TARTARE = BLOCKS.register("monster_tartare", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> PEPPER_POPPER = BLOCKS.register("pepper_popper", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> PIEROGI = BLOCKS.register("pierogi", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> POTATO_TORNADO = BLOCKS.register("potato_tornado", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> RATATOUILLE = BLOCKS.register("ratatouille", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.LANTERN), 3));
    public static final RegistryObject<Block> SALMON_SUSHI = BLOCKS.register("salmon_sushi", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOL), 3));
    public static final RegistryObject<Block> STEAMED_STICKS = BLOCKS.register("steamed_sticks", () -> new CrockPotFoodBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STUFFED_EGGPLANT = BLOCKS.register("stuffed_eggplant", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.SWEET_BERRY_BUSH), 3));
    public static final RegistryObject<Block> SURF_N_TURF = BLOCKS.register("surf_n_turf", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> WATERMELON_ICLE = BLOCKS.register("watermelon_icle", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.GLASS), 3));
    public static final RegistryObject<Block> WET_GOOP = BLOCKS.register("wet_goop", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> NETHEROSIA = BLOCKS.register("netherosia", CrockPotFoodBlock::new);


    // Tree Blocks
    public static final RegistryObject<Block> PALM_LOG = registerBlock("palm_log", () -> new PalmLogBlock(Block.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> PALM_WOOD = registerBlock("palm_wood", () -> new PalmLogBlock(Block.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", () -> new PalmLogBlock(Block.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", () -> new PalmLogBlock(Block.Properties.copy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new PalmLeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)));



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