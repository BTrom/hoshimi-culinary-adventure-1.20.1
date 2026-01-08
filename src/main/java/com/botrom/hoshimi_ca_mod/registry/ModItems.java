package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blockentity.content.SauceType;
import com.botrom.hoshimi_ca_mod.items.PizzaPeelItem;
import com.botrom.hoshimi_ca_mod.items.PizzaSliceItem;
import com.botrom.hoshimi_ca_mod.items.SauceItem;
import net.minecraft.world.item.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

import static vectorwing.farmersdelight.common.registry.ModItems.foodItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HoshimiCulinaryMod.MOD_ID);


    //Seeds
    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds",
            () -> new ItemNameBlockItem(ModBlocks.CUCUMBERS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_KERNELS = ITEMS.register("corn_kernels",
            () -> new ItemNameBlockItem(ModBlocks.CORN_BOTTOM.get(), new Item.Properties()));
    public static final RegistryObject<Item> EGGPLANT_SEEDS = ITEMS.register("eggplant_seeds",
            () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> AVOCADO_SEED = ITEMS.register("avocado_seed",
            () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds",
            () -> new ItemNameBlockItem(ModBlocks.BROCCOLI.get(), new Item.Properties()));
    public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PEPPERS.get(), new Item.Properties()));
    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds",
            () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE.get(), new Item.Properties()));


    //Ingredients
    public static final FoodProperties AVOCADO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final RegistryObject<Item> AVOCADO_ITEM = ITEMS.register("avocado",
            () -> new Item(new Item.Properties().food(AVOCADO)));
    public static final FoodProperties CUT_AVOCADO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast().build();
    public static final RegistryObject<Item> CUT_AVOCADO_ITEM = ITEMS.register("cut_avocado",
            () -> new Item(new Item.Properties().food(CUT_AVOCADO)));

    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();
    public static final RegistryObject<Item> CUCUMBER_ITEM = ITEMS.register("cucumber",
            () -> new Item(new Item.Properties().food(CUCUMBER)));
    public static final RegistryObject<Item> CUCUMBER_SLICE = ITEMS.register("cut_cucumber",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));

    public static final FoodProperties PICKLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();
    public static final RegistryObject<Item> PICKLE_ITEM = ITEMS.register("pickle",
            () -> new Item(new Item.Properties().food(PICKLE)));
    public static final FoodProperties CUT_PICKLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).fast().build();
    public static final RegistryObject<Item> CUT_PICKLE_ITEM = ITEMS.register("cut_pickle",
            () -> new Item(new Item.Properties().food(CUT_PICKLE)));

    public static final FoodProperties EGGPLANT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
    public static final RegistryObject<Item> EGGPLANT_ITEM = ITEMS.register("eggplant",
            () -> new Item(new Item.Properties().food(EGGPLANT)));
    public static final FoodProperties CUT_EGGPLANT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).fast().build();
    public static final RegistryObject<Item> CUT_EGGPLANT_ITEM = ITEMS.register("cut_eggplant",
            () -> new Item(new Item.Properties().food(CUT_EGGPLANT)));

    public static final RegistryObject<Item> TOMATO_SLICE = ITEMS.register("tomato_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));
    public static final FoodProperties SMOKED_TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final RegistryObject<Item> SMOKED_TOMATO_ITEM = ITEMS.register("smoked_tomato",
            () -> new Item(new Item.Properties().food(SMOKED_TOMATO)));

    public static final FoodProperties CORN_COB = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4F).build();
    public static final RegistryObject<Item> CORN_ITEM = ITEMS.register("corn",
            () -> new Item(new Item.Properties().food(CORN_COB)));
    public static final FoodProperties SMOKED_CORN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.7F).build();
    public static final RegistryObject<Item> SMOKED_CORN_ITEM = ITEMS.register("smoked_corn",
            () -> new Item(new Item.Properties().food(SMOKED_CORN)));
    public static final FoodProperties CORN_DOUGH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final RegistryObject<Item> CORN_DOUGH_ITEM = ITEMS.register("corn_dough",
            () -> new Item(new Item.Properties().food(CORN_DOUGH)));
    public static final FoodProperties TORTILLA = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final RegistryObject<Item> TORTILLA_ITEM = ITEMS.register("tortilla",
            () -> new Item(new Item.Properties().food(TORTILLA)));
    public static final FoodProperties NACHOS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast().build();
    public static final RegistryObject<Item> NACHOS_ITEM = ITEMS.register("nachos",
            () -> new Item(new Item.Properties().food(NACHOS)));

    public static final RegistryObject<Item> BREAD_SLICE = ITEMS.register("bread_slice",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(2).saturationMod(0.4f).build())));
    public static final RegistryObject<Item> TOAST = ITEMS.register("toast",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(3).saturationMod(0.4f).build())));

    public static final RegistryObject<Item> MATCHA = ITEMS.register("matcha",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> ACORN = ITEMS.register("acorn",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1F).build())));
    public static final RegistryObject<Item> ROASTED_ACORN = ITEMS.register("roasted_acorn",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build())));

    public static final RegistryObject<Item> CACTUS_FLESH = ITEMS.register("cactus_flesh",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build())));
    public static final RegistryObject<Item> CACTUS_STEAK = ITEMS.register("cactus_steak",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build())));

    public static final FoodProperties JAM_JAR = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).build();
    public static final RegistryObject<Item> JAM_JAR_ITEM = ITEMS.register("jam_jar",
            () -> new ConsumableItem((new Item.Properties()).food(JAM_JAR).craftRemainder(Items.GLASS_BOTTLE), false, false));

    public static final RegistryObject<Item> RAW_PIZZA = ITEMS.register("raw_pizza",
            () -> new BlockItem(ModBlocks.RAW_PIZZA.get(), new Item.Properties().stacksTo(1)));
    // -> new RawPizzaBlockItem...


    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil",
            () -> new SauceItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .nutrition(2).saturationMod(1.2F)
                    .effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 240, 1), 0.75F).build()),
                    SauceType.NONE));
    public static final RegistryObject<Item> TOMATO_SAUCE = ITEMS.register("tomato_sauce",
            () -> new SauceItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .nutrition(10).saturationMod(1.2F).build()),
                    SauceType.TOMATO));
    public static final RegistryObject<Item> HOT_SAUCE = ITEMS.register("hot_sauce",
            () -> new SauceItem(new Item.Properties().stacksTo(1).food(new FoodProperties.Builder()
                    .nutrition(10).saturationMod(1.2F).build()),
                    SauceType.HOT));

    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));

    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> PEPPER_SLICE = ITEMS.register("pepper_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));

    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build())));
    public static final RegistryObject<Item> PINEAPPLE_SLICE = ITEMS.register("pineapple_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));

    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));

    public static final RegistryObject<Item> ONION_SLICE = ITEMS.register("onion_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));

    public static final RegistryObject<Item> MUSHROOM_SLICE = ITEMS.register("mushroom_slice",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build())));

    public static final RegistryObject<Item> CUT_HAM = ITEMS.register("cut_ham",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build())));

    public static final RegistryObject<Item> CHICKEN_WING = ITEMS.register("chicken_wing",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build())));
    public static final RegistryObject<Item> COOKED_WING = ITEMS.register("cooked_wing",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().meat().build())));
    public static final RegistryObject<Item> HOT_WING = ITEMS.register("hot_wing",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).fast().meat().build())));

    public static final RegistryObject<Item> CORN_FLOUR = ITEMS.register("corn_flour",
            () -> new Item(new Item.Properties()));

    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese",
            () -> new Item(new Item.Properties().food(new FoodProperties.Builder().nutrition(4).saturationMod(1.6F).build())));
    public static final RegistryObject<Item> CHEESE_BLOCK = ITEMS.register("cheese_block",
            () -> new ItemNameBlockItem(ModBlocks.CHEESE_BLOCK.get(), new Item.Properties()));


    //Meals
    public static final FoodProperties POPCORN = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().build();
    public static final RegistryObject<Item> POPCORN_ITEM = ITEMS.register("popcorn",
            () -> new Item(new Item.Properties().food(POPCORN)));

    public static final FoodProperties ELOTE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F).build();
    public static final RegistryObject<Item> ELOTE_ITEM = ITEMS.register("elote",
            () -> new Item(new Item.Properties().food(ELOTE)));

    public static final FoodProperties EMPANADA = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    public static final RegistryObject<Item> EMPANADA_ITEM = ITEMS.register("empanada",
            () -> new Item(new Item.Properties().food(EMPANADA)));

    public static final FoodProperties HEARTY_SALAD = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final RegistryObject<Item> HEARTY_SALAD_ITEM = ITEMS.register("hearty_salad",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(HEARTY_SALAD)));

    public static final FoodProperties BEEF_BURRITO = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.7F).build();
    public static final RegistryObject<Item> BEEF_BURRITO_ITEM = ITEMS.register("beef_burrito",
            () -> new Item(new Item.Properties().food(BEEF_BURRITO)));

    public static final FoodProperties CHICKEN_TACO = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final RegistryObject<Item> CHICKEN_TACO_ITEM = ITEMS.register("chicken_taco",
            () -> new Item(new Item.Properties().food(CHICKEN_TACO)));

    public static final FoodProperties SPICY_CURRY = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.3F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final RegistryObject<Item> SPICY_CURRY_ITEM = ITEMS.register("spicy_curry",
            () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(SPICY_CURRY)));

    public static final FoodProperties PORK_WRAP = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final RegistryObject<Item> PORK_WRAP_ITEM = ITEMS.register("pork_wrap",
            () -> new Item(new Item.Properties().food(PORK_WRAP)));

    public static final FoodProperties FISH_TACO = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final RegistryObject<Item> FISH_TACO_ITEM = ITEMS.register("fish_taco",
            () -> new Item(new Item.Properties().food(FISH_TACO)));

    public static final FoodProperties MIDORI_ROLL = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.7F).build();
    public static final RegistryObject<Item> MIDORI_ROLL_ITEM = ITEMS.register("midori_roll",
            () -> new Item(new Item.Properties().food(MIDORI_ROLL)));

    public static final FoodProperties MIDORI_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.4F).fast().build();
    public static final RegistryObject<Item> MIDORI_ROLL_SLICE_ITEM = ITEMS.register("midori_roll_slice",
            () -> new Item(new Item.Properties().food(MIDORI_ROLL_SLICE)));

    public static final FoodProperties EGG_ROLL = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).fast().build();
    public static final RegistryObject<Item> EGG_ROLL_ITEM = ITEMS.register("egg_roll",
            () -> new Item(new Item.Properties().food(EGG_ROLL)));

    public static final FoodProperties TROPICAL_ROLL = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).fast().build();
    public static final RegistryObject<Item> TROPICAL_ROLL_ITEM = ITEMS.register("tropical_roll",
            () -> new Item(new Item.Properties().food(TROPICAL_ROLL)));

    public static final FoodProperties RICE_BALL = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().build();
    public static final RegistryObject<Item> RICE_BALL_ITEM = ITEMS.register("rice_ball",
            () -> new Item(new Item.Properties().food(RICE_BALL)));

    public static final FoodProperties CHOCOLATE_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().build();
    public static final RegistryObject<Item> CHOCOLATE_POPSICLE_ITEM = ITEMS.register("chocolate_popsicle",
            () -> new Item(new Item.Properties().food(CHOCOLATE_POPSICLE)));

    public static final FoodProperties OMELETTE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).fast().build();
    public static final RegistryObject<Item> OMELETTE_ITEM = ITEMS.register("omelette",
            () -> new Item(new Item.Properties().food(OMELETTE)));

    public static final FoodProperties CREAMY_PASTA_WITH_HAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
    public static final RegistryObject<Item> CREAMY_PASTA_WITH_HAM_ITEM = ITEMS.register("creamy_pasta_with_ham",
            () -> new Item(new Item.Properties().food(CREAMY_PASTA_WITH_HAM)));
    public static final FoodProperties CREAMY_PASTA_WITH_CHICKEN_CUTS = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.85F).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
    public static final RegistryObject<Item> CREAMY_PASTA_WITH_CHICKEN_CUTS_ITEM = ITEMS.register("creamy_pasta_with_chicken_cuts",
            () -> new Item(new Item.Properties().food(CREAMY_PASTA_WITH_CHICKEN_CUTS)));

    public static final FoodProperties MASHED_POTATOES = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).fast().build();
    public static final RegistryObject<Item> MASHED_POTATOES_ITEM = ITEMS.register("mashed_potatoes",
            () -> new Item(new Item.Properties().food(MASHED_POTATOES)));

    public static final FoodProperties CHICKEN_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
    public static final RegistryObject<Item> CHICKEN_SALAD_ITEM = ITEMS.register("chicken_salad",
            () -> new Item(new Item.Properties().food(CHICKEN_SALAD)));

    public static final RegistryObject<Item> TOAST_WITH_SWEET_BERRIES = ITEMS.register("toast_with_sweet_berries",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build())));
    public static final RegistryObject<Item> TOAST_WITH_CHOCOLATE = ITEMS.register("toast_with_chocolate",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build())));

    public static final RegistryObject<Item> MATCHA_ICE_CREAM = ITEMS.register("matcha_ice_cream",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F)
//                    .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 500, 1), 1F)
//                    .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 400, 0), 1F)
                    .build())));
    public static final RegistryObject<Item> MATCHA_MILKSHAKE = ITEMS.register("matcha_milkshake",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F)
//                    .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 200, 1), 1F)
//                    .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 300, 0), 1F)
                    .build())));
    public static final FoodProperties MATCHA_LATTE = (new FoodProperties.Builder()).alwaysEat()
            .nutrition(6).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 400, 1), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 3600, 1), 1F)
            .build();
    public static final RegistryObject<Item> MATCHA_LATTE_ITEM = ITEMS.register("matcha_latte",
            () -> new DrinkableItem((new Item.Properties()).food(MATCHA_LATTE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));

    public static final FoodProperties CACTUS_CHILI = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final RegistryObject<Item> CACTUS_CHILI_ITEM = ITEMS.register("cactus_chili",
            () -> new ConsumableItem((new Item.Properties()).food(CACTUS_CHILI).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final FoodProperties CACTUS_SOUP = (new FoodProperties.Builder())
            .nutrition(12).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F).build();
    public static final RegistryObject<Item> CACTUS_SOUP_ITEM = ITEMS.register("cactus_soup",
            () -> new ConsumableItem((new Item.Properties()).food(CACTUS_SOUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));

    public static final FoodProperties FIELD_SALAD = (new FoodProperties.Builder())
            .nutrition(10).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1F).build();
    public static final RegistryObject<Item> FIELD_SALAD_ITEM = ITEMS.register("field_salad",
            () -> new ConsumableItem((new Item.Properties()).food(FIELD_SALAD).stacksTo(16).craftRemainder(Items.BOWL), true, false));

    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder())
                    .nutrition(11).saturationMod(0.85F)
                    .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0), 1F)
                    .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build())));

    public static final FoodProperties MARSHMALLOW_STICK = (new FoodProperties.Builder())
            .nutrition(3).saturationMod(0.35F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 300, 0), 1F)
            .build();
    public static final RegistryObject<Item> MARSHMALLOW_STICK_ITEM = ITEMS.register("marshmallow_stick",
            () -> new ConsumableItem((new Item.Properties()).food(MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final FoodProperties COOKED_MARSHMALLOW_STICK = (new FoodProperties.Builder())
            .nutrition(5).saturationMod(0.35F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0), 1F).build();
    public static final RegistryObject<Item> COOKED_MARSHMALLOW_STICK_ITEM = ITEMS.register("cooked_marshmallow_stick",
            () -> new ConsumableItem((new Item.Properties()).food(COOKED_MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final RegistryObject<Item> SMORE = ITEMS.register("smore",
            () -> new ConsumableItem(foodItem((new FoodProperties.Builder())
                    .nutrition(8).saturationMod(0.4F)
                    .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 1), 1F)
                    .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1F).build())));

    public static final FoodProperties PAELLA = (new FoodProperties.Builder())
            .nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final RegistryObject<Item> PAELLA_ITEM = ITEMS.register("paella_bowl",
            () -> new ConsumableItem((new Item.Properties()).food(PAELLA).stacksTo(16).craftRemainder(Items.BOWL), true));

    public static final RegistryObject<Item> PIZZA_SLICE = ITEMS.register("pizza_slice",
            () -> new PizzaSliceItem(new Item.Properties()));


    // Tools
    public static final RegistryObject<Item> ROLLING_PIN = ITEMS.register("rolling_pin",
            () -> new Item(new Item.Properties().stacksTo(1).durability(60)));

    public static final RegistryObject<Item> PIZZA_PEEL = ITEMS.register("pizza_peel",
            () -> new PizzaPeelItem(Tiers.IRON, 1.5F, -3.0F, new Item.Properties().stacksTo(1)));


    // Registry
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

    public static RegistryObject<Item> registerBlockItem(final String name, RegistryObject<Block> block, Item.Properties properties) {
        return ITEMS.register(name, () -> new BlockItem(block.get(), properties));
    }
}
