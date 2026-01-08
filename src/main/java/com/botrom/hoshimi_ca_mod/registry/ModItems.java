package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.content.SauceType;
import com.botrom.hoshimi_ca_mod.pizzacraft.items.*;
import net.minecraft.world.item.*;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HoshimiCulinaryMod.MOD_ID);


    //Seeds
    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds", () -> new ItemNameBlockItem(ModBlocks.CUCUMBERS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_KERNELS = ITEMS.register("corn_kernels", () -> new ItemNameBlockItem(ModBlocks.CORN_BOTTOM.get(), new Item.Properties()));
    public static final RegistryObject<Item> EGGPLANT_SEEDS = ITEMS.register("eggplant_seeds", () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> AVOCADO_SEED = ITEMS.register("avocado_seed", () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(), new Item.Properties()));
//    public static final RegistryObject<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds",
//            () -> new ItemNameBlockItem(ModBlocks.BROCCOLI.get(), new Item.Properties()));
//    public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds",
//            () -> new ItemNameBlockItem(ModBlocks.PEPPERS.get(), new Item.Properties()));
//    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds",
//            () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE.get(), new Item.Properties()));


    //Ingredients
    public static final RegistryObject<Item> AVOCADO = ITEMS.register("avocado", () -> new Item(new Item.Properties().food(ModFoods.AVOCADO)));
    public static final RegistryObject<Item> CUT_AVOCADO = ITEMS.register("cut_avocado", () -> new Item(new Item.Properties().food(ModFoods.CUT_AVOCADO)));
    public static final RegistryObject<Item> CUCUMBER = ITEMS.register("cucumber", () -> new Item(new Item.Properties().food(ModFoods.CUCUMBER)));
    public static final RegistryObject<Item> CUT_CUCUMBER = ITEMS.register("cut_cucumber", () -> new Item(pizzaProperties().food(ModFoods.CUT_CUCUMBER)));
    public static final RegistryObject<Item> PICKLE = ITEMS.register("pickle", () -> new Item(new Item.Properties().food(ModFoods.PICKLE)));
    public static final RegistryObject<Item> CUT_PICKLE = ITEMS.register("cut_pickle", () -> new Item(new Item.Properties().food(ModFoods.CUT_PICKLE)));
    public static final RegistryObject<Item> EGGPLANT = ITEMS.register("eggplant", () -> new Item(new Item.Properties().food(ModFoods.EGGPLANT)));
    public static final RegistryObject<Item> CUT_EGGPLANT = ITEMS.register("cut_eggplant", () -> new Item(new Item.Properties().food(ModFoods.CUT_EGGPLANT)));
    public static final RegistryObject<Item> TOMATO_SLICE = ITEMS.register("tomato_slice", () -> new Item(pizzaProperties().food(ModFoods.TOMATO_SLICE)));
    public static final RegistryObject<Item> SMOKED_TOMATO = ITEMS.register("smoked_tomato", () -> new Item(new Item.Properties().food(ModFoods.SMOKED_TOMATO)));
    public static final RegistryObject<Item> CORN = ITEMS.register("corn", () -> new Item(new Item.Properties().food(ModFoods.CORN)));
    public static final RegistryObject<Item> SMOKED_CORN = ITEMS.register("smoked_corn", () -> new Item(new Item.Properties().food(ModFoods.SMOKED_CORN)));
    public static final RegistryObject<Item> CORN_DOUGH = ITEMS.register("corn_dough", () -> new Item(new Item.Properties().food(ModFoods.CORN_DOUGH)));
    public static final RegistryObject<Item> TORTILLA = ITEMS.register("tortilla", () -> new Item(new Item.Properties().food(ModFoods.TORTILLA)));
    public static final RegistryObject<Item> NACHOS = ITEMS.register("nachos", () -> new Item(new Item.Properties().food(ModFoods.NACHOS)));
    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice", () -> new Item(new Item.Properties().food(ModFoods.BREAD_SLICE)));
    public static final RegistryObject<Item> TOAST = ITEMS.register("toast", () -> new Item(new Item.Properties().food(ModFoods.TOAST)));
    public static final RegistryObject<Item> MATCHA = ITEMS.register("matcha", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> ACORN = ITEMS.register("acorn", () -> new Item(new Item.Properties().food(ModFoods.ACORN)));
    public static final RegistryObject<Item> ROASTED_ACORN = ITEMS.register("roasted_acorn", () -> new Item(new Item.Properties().food(ModFoods.ROASTED_ACORN)));
    public static final RegistryObject<Item> CACTUS_FLESH = ITEMS.register("cactus_flesh", () -> new Item(new Item.Properties().food(ModFoods.CACTUS_FLESH)));
    public static final RegistryObject<Item> CACTUS_STEAK = ITEMS.register("cactus_steak", () -> new Item(new Item.Properties().food(ModFoods.CACTUS_STEAK)));
    public static final RegistryObject<Item> JAM_JAR = ITEMS.register("jam_jar", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.JAM_JAR).craftRemainder(Items.GLASS_BOTTLE), false, false));

//    public static final RegistryObject<Item> RAW_PIZZA = ITEMS.register("raw_pizza",
//            () -> new BlockItem(ModBlocks.RAW_PIZZA.get(), new Item.Properties().stacksTo(1)));
//    // -> new RawPizzaBlockItem...
//
//
//    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil",
//            () -> new SauceItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
//                    .nutrition(2).saturationMod(1.2F)
//                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 240, 1), 0.75F).build()),
//                    SauceType.NONE));
//    public static final RegistryObject<Item> TOMATO_SAUCE = ITEMS.register("tomato_sauce",
//            () -> new SauceItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
//                    .nutrition(10).saturationMod(1.2F).build()),
//                    SauceType.TOMATO));
//    public static final RegistryObject<Item> HOT_SAUCE = ITEMS.register("hot_sauce",
//            () -> new SauceItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
//                    .nutrition(10).saturationMod(1.2F).build()),
//                    SauceType.HOT));
//
//    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
//
//    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
//    public static final RegistryObject<Item> PEPPER_SLICE = ITEMS.register("pepper_slice",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));
//
//    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
//    public static final RegistryObject<Item> PINEAPPLE_SLICE = ITEMS.register("pineapple_slice",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));
//
//    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));
//
//    public static final RegistryObject<Item> ONION_SLICE = ITEMS.register("onion_slice",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));
//
//    public static final RegistryObject<Item> MUSHROOM_SLICE = ITEMS.register("mushroom_slice",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));
//
//    public static final RegistryObject<Item> CUT_HAM = ITEMS.register("cut_ham",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build())));
//
//    public static final RegistryObject<Item> CHICKEN_WING = ITEMS.register("chicken_wing",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build())));
//    public static final RegistryObject<Item> COOKED_WING = ITEMS.register("cooked_wing",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().meat().build())));
//    public static final RegistryObject<Item> HOT_WING = ITEMS.register("hot_wing",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).fast().meat().build())));
//
//    public static final RegistryObject<Item> CORN_FLOUR = ITEMS.register("corn_flour",
//            () -> new Item(new Item.Properties()));
//
//    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
//            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1.6F).build())));
//    public static final RegistryObject<Item> CHEESE_BLOCK = ITEMS.register("cheese_block",
//            () -> new ItemNameBlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties()));


    //Meals
    public static final RegistryObject<Item> POPCORN = ITEMS.register("popcorn", () -> new Item(new Item.Properties().food(ModFoods.POPCORN)));
    public static final RegistryObject<Item> ELOTE = ITEMS.register("elote", () -> new Item(new Item.Properties().food(ModFoods.ELOTE)));
    public static final RegistryObject<Item> EMPANADA = ITEMS.register("empanada", () -> new Item(new Item.Properties().food(ModFoods.EMPANADA)));
    public static final RegistryObject<Item> HEARTY_SALAD = ITEMS.register("hearty_salad", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.HEARTY_SALAD)));
    public static final RegistryObject<Item> BEEF_BURRITO = ITEMS.register("beef_burrito", () -> new Item(new Item.Properties().food(ModFoods.BEEF_BURRITO)));
    public static final RegistryObject<Item> CHICKEN_TACO = ITEMS.register("chicken_taco", () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_TACO)));
    public static final RegistryObject<Item> SPICY_CURRY = ITEMS.register("spicy_curry", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.SPICY_CURRY)));
    public static final RegistryObject<Item> PORK_WRAP = ITEMS.register("pork_wrap", () -> new Item(new Item.Properties().food(ModFoods.PORK_WRAP)));
    public static final RegistryObject<Item> FISH_TACO = ITEMS.register("fish_taco", () -> new Item(new Item.Properties().food(ModFoods.FISH_TACO)));
    public static final RegistryObject<Item> MIDORI_ROLL = ITEMS.register("midori_roll", () -> new Item(new Item.Properties().food(ModFoods.MIDORI_ROLL)));
    public static final RegistryObject<Item> MIDORI_ROLL_SLICE = ITEMS.register("midori_roll_slice", () -> new Item(new Item.Properties().food(ModFoods.MIDORI_ROLL_SLICE)));
    public static final RegistryObject<Item> EGG_ROLL = ITEMS.register("egg_roll", () -> new Item(new Item.Properties().food(ModFoods.EGG_ROLL)));
    public static final RegistryObject<Item> TROPICAL_ROLL = ITEMS.register("tropical_roll", () -> new Item(new Item.Properties().food(ModFoods.TROPICAL_ROLL)));
    public static final RegistryObject<Item> RICE_BALL = ITEMS.register("rice_ball", () -> new Item(new Item.Properties().food(ModFoods.RICE_BALL)));
    public static final RegistryObject<Item> CHOCOLATE_POPSICLE = ITEMS.register("chocolate_popsicle", () -> new Item(new Item.Properties().food(ModFoods.CHOCOLATE_POPSICLE)));
    public static final RegistryObject<Item> OMELETTE = ITEMS.register("omelette", () -> new Item(new Item.Properties().food(ModFoods.OMELETTE)));
    public static final RegistryObject<Item> CREAMY_PASTA_WITH_HAM = ITEMS.register("creamy_pasta_with_ham", () -> new Item(new Item.Properties().food(ModFoods.CREAMY_PASTA_WITH_HAM)));
    public static final RegistryObject<Item> CREAMY_PASTA_WITH_CHICKEN_CUTS = ITEMS.register("creamy_pasta_with_chicken_cuts", () -> new Item(new Item.Properties().food(ModFoods.CREAMY_PASTA_WITH_CHICKEN_CUTS)));
    public static final RegistryObject<Item> MASHED_POTATOES = ITEMS.register("mashed_potatoes", () -> new Item(new Item.Properties().food(ModFoods.MASHED_POTATOES)));
    public static final RegistryObject<Item> CHICKEN_SALAD = ITEMS.register("chicken_salad", () -> new Item(new Item.Properties().food(ModFoods.CHICKEN_SALAD)));
    public static final RegistryObject<Item> TOAST_WITH_SWEET_BERRIES = ITEMS.register("toast_with_sweet_berries", () -> new Item(new Item.Properties().food(ModFoods.TOAST_WITH_SWEET_BERRIES)));
    public static final RegistryObject<Item> TOAST_WITH_CHOCOLATE = ITEMS.register("toast_with_chocolate", () -> new Item(new Item.Properties().food(ModFoods.TOAST_WITH_CHOCOLATE)));
    public static final RegistryObject<Item> MATCHA_ICE_CREAM = ITEMS.register("matcha_ice_cream", () -> new Item(new Item.Properties().food(ModFoods.MATCHA_ICE_CREAM)));
    public static final RegistryObject<Item> MATCHA_MILKSHAKE = ITEMS.register("matcha_milkshake", () -> new Item(new Item.Properties().food(ModFoods.MATCHA_MILKSHAKE)));
    public static final RegistryObject<Item> MATCHA_LATTE = ITEMS.register("matcha_latte", () -> new DrinkableItem((new Item.Properties()).food(ModFoods.MATCHA_LATTE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));
    public static final RegistryObject<Item> CACTUS_CHILI = ITEMS.register("cactus_chili", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.CACTUS_CHILI).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> CACTUS_SOUP = ITEMS.register("cactus_soup", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.CACTUS_SOUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> FIELD_SALAD = ITEMS.register("field_salad", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.FIELD_SALAD).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(new Item.Properties().food(ModFoods.CHEESEBURGER)));
    public static final RegistryObject<Item> MARSHMALLOW_STICK = ITEMS.register("marshmallow_stick", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final RegistryObject<Item> COOKED_MARSHMALLOW_STICK = ITEMS.register("cooked_marshmallow_stick", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.COOKED_MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final RegistryObject<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties().food(ModFoods.SMORE)));
    public static final RegistryObject<Item> PAELLA_BOWL = ITEMS.register("paella_bowl", () -> new ConsumableItem((new Item.Properties()).food(ModFoods.PAELLA_BOWL).stacksTo(16).craftRemainder(Items.BOWL), true));

//    public static final RegistryObject<Item> PIZZA_SLICE = ITEMS.register("pizza_slice",
//            () -> new PizzaSliceItem(new Item.Properties()));
//
//
//    // Tools
//    public static final RegistryObject<Item> ROLLING_PIN = ITEMS.register("rolling_pin",
//            () -> new Item(new Item.Properties().stacksTo(1).durability(60)));
//
//    public static final RegistryObject<Item> PIZZA_PEEL = ITEMS.register("pizza_peel",
//            () -> new PizzaPeelItem(Tiers.IRON, 1.5F, -3.0F, new Item.Properties().stacksTo(1)));

    public static final RegistryObject<Item> WILD_CUCUMBERS = ITEMS.register("wild_cucumbers", () -> new BlockItem(ModBlocks.WILD_CUCUMBERS.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_CORN = ITEMS.register("wild_corn", () -> new BlockItem(ModBlocks.WILD_CORN.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_EGGPLANTS = ITEMS.register("wild_eggplants", () -> new BlockItem(ModBlocks.WILD_EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_COB_CRATE = ITEMS.register("corn_crate", () -> new BlockItem(ModBlocks.CORN_COB_CRATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EXOTIC_ROLL_MEDLEY = ITEMS.register("exotic_roll_medley", () -> new BlockItem(ModBlocks.EXOTIC_ROLL_MEDLEY.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PAELLA = ITEMS.register("paella", () -> new BlockItem(ModBlocks.PAELLA.get(), new Item.Properties().stacksTo(1)));

    // PizzaCraft
    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza", () -> new PizzaBlockItem(ModBlocks.PIZZA.get(), pizzaProperties().stacksTo(1)));
    public static final RegistryObject<Item> RAW_PIZZA = ITEMS.register("raw_pizza", () -> new RawPizzaBlockItem(ModBlocks.RAW_PIZZA.get(), pizzaProperties().stacksTo(1)));
    public static final RegistryObject<Item> PIZZA_DOUGH = registerBlockItem("pizza_dough", ModBlocks.PIZZA_DOUGH, pizzaProperties().stacksTo(16));
    public static final RegistryObject<Item> PIZZA_STATION = registerBlockItem("pizza_station", ModBlocks.PIZZA_STATION, pizzaProperties());
    public static final RegistryObject<Item> PIZZA_OVEN = registerBlockItem("pizza_oven", ModBlocks.PIZZA_OVEN, pizzaProperties());

    //Basins
    public static final RegistryObject<Item> GRANITE_BASIN = registerBlockItem("granite_basin", ModBlocks.GRANITE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> DIORITE_BASIN = registerBlockItem("diorite_basin", ModBlocks.DIORITE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> ANDESITE_BASIN = registerBlockItem("andesite_basin", ModBlocks.ANDESITE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> BASALT_BASIN = registerBlockItem("basalt_basin", ModBlocks.BASALT_BASIN, pizzaProperties());
    public static final RegistryObject<Item> BLACKSTONE_BASIN = registerBlockItem("blackstone_basin", ModBlocks.BLACKSTONE_BASIN, pizzaProperties());

    //Tools
    public static final RegistryObject<Item> ROLLING_PIN = ITEMS.register("rolling_pin", () -> new Item(pizzaProperties().stacksTo(1).durability(60)));
    public static final RegistryObject<Item> PIZZA_PEEL = ITEMS.register("pizza_peel", () -> new PizzaPeelItem(Tiers.IRON, 1.5F, -3.0F, pizzaProperties().stacksTo(1)));

    //Pizza Slice
    public static final RegistryObject<Item> PIZZA_SLICE = ITEMS.register("pizza_slice", () -> new PizzaSliceItem(pizzaProperties()));

    //Sauces
    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil", () -> new SauceItem(pizzaProperties().stacksTo(1).food(ModFoods.OLIVE_OIL), SauceType.NONE));
    public static final RegistryObject<Item> TOMATO_SAUCE = ITEMS.register("tomato_sauce", () -> new SauceItem(pizzaProperties().stacksTo(1).food(ModFoods.TOMATO_SAUCE), SauceType.TOMATO));
    public static final RegistryObject<Item> HOT_SAUCE = ITEMS.register("hot_sauce", () -> new SauceItem(pizzaProperties().stacksTo(1).food(ModFoods.HOT_SAUCE), SauceType.HOT));

    //Vegetables
    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli", () -> new Item(pizzaProperties().food(ModFoods.BROCCOLI)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper", () -> new Item(pizzaProperties().food(ModFoods.PEPPER)));

    //Fruits
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new Item(pizzaProperties().food(ModFoods.PINEAPPLE)));
    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive", () -> new Item(pizzaProperties().food(ModFoods.OLIVE)));

    //Slices
    public static final RegistryObject<Item> ONION_SLICE = ITEMS.register("onion_slice", () -> new Item(pizzaProperties().food(ModFoods.ONION_SLICE)));
    public static final RegistryObject<Item> PEPPER_SLICE = ITEMS.register("pepper_slice", () -> new Item(pizzaProperties().food(ModFoods.PEPPER_SLICE)));
    public static final RegistryObject<Item> PINEAPPLE_SLICE = ITEMS.register("pineapple_slice", () -> new Item(pizzaProperties().food(ModFoods.PINEAPPLE_SLICE)));
    public static final RegistryObject<Item> MUSHROOM_SLICE = ITEMS.register("mushroom_slice", () -> new Item(pizzaProperties().food(ModFoods.MUSHROOM_SLICE)));

    //Meats
    public static final RegistryObject<Item> CUT_HAM = ITEMS.register("cut_ham", () -> new Item(pizzaProperties().food(ModFoods.CUT_HAM)));
    public static final RegistryObject<Item> CHICKEN_WING = ITEMS.register("chicken_wing", () -> new Item(pizzaProperties().food(ModFoods.CHICKEN_WING)));
    public static final RegistryObject<Item> COOKED_WING = ITEMS.register("cooked_wing", () -> new Item(pizzaProperties().food(ModFoods.COOKED_WING)));
    public static final RegistryObject<Item> HOT_WING = ITEMS.register("hot_wing", () -> new Item(pizzaProperties().food(ModFoods.HOT_WING)));

    //Ingredients
    public static final RegistryObject<Item> CORN_FLOUR = ITEMS.register("corn_flour", () -> new Item(pizzaProperties()));
    public static final RegistryObject<Item> CHEESE_BLOCK = registerBlockItem("cheese_block", ModBlocks.CHEESE_BLOCK, pizzaProperties());
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(pizzaProperties().food(ModFoods.CHEESE)));

    //Seeds
    public static final RegistryObject<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds", () -> new ItemNameBlockItem(ModBlocks.BROCCOLI.get(), pizzaProperties()));
    public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds", () -> new ItemNameBlockItem(ModBlocks.PEPPERS.get(), pizzaProperties()));
    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds", () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE.get(), pizzaProperties()));


    // Registry
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static RegistryObject<Item> registerBlockItem(final String name, RegistryObject<Block> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }

    public static Item.Properties pizzaProperties() {
        return new Item.Properties();
    }

}
