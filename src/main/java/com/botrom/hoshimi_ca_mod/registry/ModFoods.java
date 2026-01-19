package com.botrom.hoshimi_ca_mod.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoods
{
    //Seeds
    public static final FoodProperties POMEGRANATE_SEEDS = new FoodProperties.Builder().nutrition(2).saturationMod(0.5F)
//            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 100, 0), 1F)
            .build();

    //Vegetables
    public static final FoodProperties AVOCADO = new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties CUCUMBER = new FoodProperties.Builder().nutrition(2).saturationMod(0.5F).build();
    public static final FoodProperties EGGPLANT = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties CORN = new FoodProperties.Builder().nutrition(2).saturationMod(0.5F).build();
    public static final FoodProperties BROCCOLI = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties PICKLE = new FoodProperties.Builder().nutrition(4).saturationMod(0.7F).build();
    public static final FoodProperties PEPPER = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties ACORN = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1F).build();
    public static final FoodProperties ROASTED_ACORN = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties CACTUS_FLESH = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties CACTUS_STEAK = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties GREEN_ONION = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).build();
    public static final FoodProperties PEA_POD = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties SWEET_POTATO = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();


    //Fruits
    public static final FoodProperties PINEAPPLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties OLIVE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties LIME = new FoodProperties.Builder().nutrition(2).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 200, 0), 1F).build();
    public static final FoodProperties DRAGON_FRUIT = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 400, 0, false, false, true), 1F).build();
    public static final FoodProperties BANANA = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.AGILITY.get(), 300), 1.0F).build();


    //Slices
    public static final FoodProperties CUT_AVOCADO = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    public static final FoodProperties CUT_CUCUMBER = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties CUT_PICKLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.5F).fast().build();
    public static final FoodProperties CUT_EGGPLANT = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).fast().build();
    public static final FoodProperties ONION_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties PEPPER_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties PINEAPPLE_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties TOMATO_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties MUSHROOM_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties LIME_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).fast()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 100, 0), 1F).build();
    public static final FoodProperties POMEGRANATE_SLICE = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 200, 0), 1F).build();
    public static final FoodProperties PANETTONE_SLICE = new FoodProperties.Builder().nutrition(8).saturationMod(0.75F).fast().build();
    public static final FoodProperties MUSHROOM_QUICHE_SLICE = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).build();
    public static final FoodProperties LIME_PIE_SLICE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).fast()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 300, 1), 1F).build();
    public static final FoodProperties POMEGRANATE_CAKE_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 300, 0), 1F).build();
    public static final FoodProperties DRAGON_FRUIT_CAKE_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 300, 0), 1F).build();
    public static final FoodProperties PLATINUM_BASS_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties COOKED_PLATINUM_BASS_SLICE = new FoodProperties.Builder().nutrition(4).saturationMod(0.85F).build();
    public static final FoodProperties COCONUT_HALF = new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build();
    public static final FoodProperties RAW_CATFISH_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).meat().fast().build();
    public static final FoodProperties COOKED_CATFISH_SLICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).meat().fast().build();
    public static final FoodProperties POTATO_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();


    //Meats
    public static final FoodProperties CUT_HAM = new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build();
    public static final FoodProperties CHICKEN_WING = new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build();
    public static final FoodProperties COOKED_WING = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().meat().build();
    public static final FoodProperties HOT_WING = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).fast().meat().build();
    public static final FoodProperties CLAM_MEAT = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties TIGER_PRAWN = new FoodProperties.Builder().nutrition(2).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.75F).build();
    public static final FoodProperties COOKED_TIGER_PRAWN = new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties PLATINUM_BASS = new FoodProperties.Builder().nutrition(3).saturationMod(0.1F).build();
    public static final FoodProperties COOKED_PLATINUM_BASS = new FoodProperties.Builder().nutrition(8).saturationMod(0.85F).build();
    public static final FoodProperties CHIEFTAIN_CLAW = new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).build();
    public static final FoodProperties CHIEFTAIN_LEG = new FoodProperties.Builder().nutrition(3).saturationMod(0.75F).build();
    public static final FoodProperties CHIEFTAIN_CRAB_MEAT = new FoodProperties.Builder().nutrition(2).saturationMod(0.5F).build();
    public static final FoodProperties UNI = new FoodProperties.Builder().nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties RAW_FIDDLER_CRAB = new FoodProperties.Builder().nutrition(2).saturationMod(0.3f).meat().build();
    public static final FoodProperties COOKED_FIDDLER_CRAB = new FoodProperties.Builder().nutrition(4).saturationMod(0.8f).meat().build();
    public static final FoodProperties RAW_LOBSTER = new FoodProperties.Builder().nutrition(3).saturationMod(0.5f).meat().build();
    public static final FoodProperties COOKED_LOBSTER = new FoodProperties.Builder().nutrition(7).saturationMod(0.8f).meat().build();
    public static final FoodProperties RAW_SHRIMP = new FoodProperties.Builder().nutrition(1).saturationMod(0.3f)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.3F).meat().fast().build();
    public static final FoodProperties COOKED_SHRIMP = new FoodProperties.Builder().nutrition(3).saturationMod(0.6f).meat().fast().build();
    public static final FoodProperties FIDDLER_CRAB_LEGS = new FoodProperties.Builder().nutrition(3).saturationMod(0.6f).meat().build();
    public static final FoodProperties COOKED_CLAM_MEAT = new FoodProperties.Builder().nutrition(4).saturationMod(0.8f).meat().fast().build();
    public static final FoodProperties LOBSTER_TAIL = new FoodProperties.Builder().nutrition(2).saturationMod(0.4F).meat().build();
    public static final FoodProperties COOKED_LOBSTER_TAIL = new FoodProperties.Builder().nutrition(6).saturationMod(0.65F).meat().build();
    public static final FoodProperties RAW_CATFISH = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_CATFISH = new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).meat().build();
    public static final FoodProperties TONKATSU = new FoodProperties.Builder().nutrition(8).saturationMod(0.85F).build();
    public static final FoodProperties CRAB_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).meat().build();
    public static final FoodProperties COOKED_CRAB_MEAT = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).meat().build();
    public static final FoodProperties GIANT_MUD_CRAB = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).meat().build();
    public static final FoodProperties KING_CRAB = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).meat().build();
    public static final FoodProperties OYSTER =(new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).build();
    public static final FoodProperties COOKED_GIANT_MUD_CRAB = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.8F).meat().build();
    public static final FoodProperties COOKED_KING_CRAB = (new FoodProperties.Builder()).nutrition(8).saturationMod(1.0F).meat().build();


    //Smoked
    public static final FoodProperties SMOKED_TOMATO = new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties SMOKED_CORN = new FoodProperties.Builder().nutrition(5).saturationMod(0.7F).build();


    //Ingredients
    public static final FoodProperties BREAD_SLICE = new FoodProperties.Builder().nutrition(2).saturationMod(0.4f).build();
    public static final FoodProperties TOAST = new FoodProperties.Builder().nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties CORN_DOUGH = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties TORTILLA = new FoodProperties.Builder().nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties OLIVE_OIL = new FoodProperties.Builder().nutrition(2).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 240, 1), 0.75F).build();
    public static final FoodProperties TOMATO_SAUCE = new FoodProperties.Builder().nutrition(10).saturationMod(1.2F).build();
    public static final FoodProperties HOT_SAUCE = new FoodProperties.Builder().nutrition(10).saturationMod(1.2F).build();
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4).saturationMod(1.6F).build();
    public static final FoodProperties JAM_JAR = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F).build();
    public static final FoodProperties CREAM_CHEESE = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 400, 1), 1F).build();
    public static final FoodProperties COCONUT_MILK = new FoodProperties.Builder().alwaysEat().nutrition(1).saturationMod(0.5f).build();
    public static final FoodProperties RAINBOW_JELLY = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).build();
    public static final FoodProperties RAW_SPRING_ROLL = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 300, 0), 0.8F).build();
    public static final FoodProperties RAW_FRIED_DUMPLING = new FoodProperties.Builder().nutrition(6).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 900, 0), 1F).build();
    protected static final FoodProperties BAKED_SWEET_POTATO = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties DRIED_VANILLA_PODS = new FoodProperties.Builder().nutrition(1).saturationMod(0.1F).effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VANILLA_SCENT.get(), 200), 1.0F).build();
    public static final FoodProperties CHOCOLATE_BAR = new FoodProperties.Builder().nutrition(4).saturationMod(0.3F).effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SUGAR_RUSH.get(), 400, 1), 1.0F).build();
    public static final FoodProperties MINT_LEAVES = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.BERSERKING.get(), 600), 1.0F).build();
    public static final FoodProperties ICE_CUBES = new FoodProperties.Builder().alwaysEat().build();


    //Meals
    public static final FoodProperties NACHOS = new FoodProperties.Builder().nutrition(2).saturationMod(0.3F).fast().build();
    public static final FoodProperties POPCORN = new FoodProperties.Builder().nutrition(1).saturationMod(0.2F).fast().build();
    public static final FoodProperties ELOTE = new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).build();
    public static final FoodProperties EMPANADA = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties HEARTY_SALAD = new FoodProperties.Builder().nutrition(7).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties BEEF_BURRITO = new FoodProperties.Builder().nutrition(14).saturationMod(0.7F).build();
    public static final FoodProperties CHICKEN_TACO = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties SPICY_CURRY = new FoodProperties.Builder().nutrition(12).saturationMod(1.3F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties PORK_WRAP = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties FISH_TACO = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties MIDORI_ROLL = new FoodProperties.Builder().nutrition(14).saturationMod(0.7F).build();
    public static final FoodProperties MIDORI_ROLL_SLICE = new FoodProperties.Builder().nutrition(7).saturationMod(0.4F).fast().build();
    public static final FoodProperties EGG_ROLL = new FoodProperties.Builder().nutrition(5).saturationMod(0.5F).fast().build();
    public static final FoodProperties TROPICAL_ROLL = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).fast().build();
    public static final FoodProperties RICE_BALL = new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).fast().build();
    public static final FoodProperties CHOCOLATE_POPSICLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.5F).fast().build();
    public static final FoodProperties OMELETTE = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).fast().build();
    public static final FoodProperties CREAMY_PASTA_WITH_HAM = new FoodProperties.Builder().nutrition(12).saturationMod(0.8F).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties CREAMY_PASTA_WITH_CHICKEN_CUTS = new FoodProperties.Builder().nutrition(12).saturationMod(0.85F).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties MASHED_POTATOES = new FoodProperties.Builder().nutrition(4).saturationMod(0.5F).fast().build();
    public static final FoodProperties CHICKEN_SALAD = new FoodProperties.Builder().nutrition(6).saturationMod(0.6F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
    public static final FoodProperties TOAST_WITH_SWEET_BERRIES = new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties TOAST_WITH_CHOCOLATE = new FoodProperties.Builder().nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties MATCHA_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.3F)
//             .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 500, 1), 1F)
//             .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 400, 0), 1F)
            .build();
    public static final FoodProperties MATCHA_MILKSHAKE = new FoodProperties.Builder().nutrition(6).saturationMod(0.3F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 200, 1), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 300, 0), 1F)
            .build();
    public static final FoodProperties MATCHA_LATTE = new FoodProperties.Builder().alwaysEat().nutrition(6).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 400, 1), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 3600, 1), 1F)
            .build();
    public static final FoodProperties CACTUS_CHILI = new FoodProperties.Builder().nutrition(10).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final FoodProperties CACTUS_SOUP = new FoodProperties.Builder().nutrition(12).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F).build();
    public static final FoodProperties FIELD_SALAD = new FoodProperties.Builder().nutrition(10).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1F).build();
    public static final FoodProperties CHEESEBURGER = new FoodProperties.Builder().nutrition(11).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final FoodProperties MARSHMALLOW_STICK = new FoodProperties.Builder().nutrition(3).saturationMod(0.35F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SUGAR_RUSH.get(), 300, 0), 1F).build();
    public static final FoodProperties COOKED_MARSHMALLOW_STICK = new FoodProperties.Builder().nutrition(5).saturationMod(0.35F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SUGAR_RUSH.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0), 1F).build();
    public static final FoodProperties SMORE = new FoodProperties.Builder().nutrition(8).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SUGAR_RUSH.get(), 600, 1), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1F).build();
    public static final FoodProperties PAELLA_BOWL = new FoodProperties.Builder().nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties LIME_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 1200, 1), 1F).build();
    public static final FoodProperties SUNNY_ICE_CREAM = new FoodProperties.Builder().nutrition(12).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.REBOUND.get(), 1600, 1), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1F).build();
    public static final FoodProperties LIME_MILKSHAKE = new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 1), 1F).build();
    public static final FoodProperties DRAGON_FRUIT_MILKSHAKE = new FoodProperties.Builder().alwaysEat().nutrition(2).saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F).build();
    public static final FoodProperties POMEGRANATE_SMOOTHIE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).alwaysEat()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.AGILITY.get(), 600, 0), 1F).build();
    public static final FoodProperties BERRY_LIMEADE = new FoodProperties.Builder().alwaysEat().nutrition(5).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 1200, 0), 1F).build();
    public static final FoodProperties PINK_LIMEADE = new FoodProperties.Builder().alwaysEat().nutrition(5).saturationMod(1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 1200, 0), 1F).build();
    public static final FoodProperties DRAGONS_PASSION = new FoodProperties.Builder().alwaysEat().nutrition(5).saturationMod(1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F).build();
    public static final FoodProperties CLAM_MEATBALL_STEW = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties CLAM_MEATBALL_STEW_CUP = new FoodProperties.Builder().nutrition(5).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1F).build();
    public static final FoodProperties PRAWN_STEW = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties PRAWN_STEW_CUP = new FoodProperties.Builder().nutrition(5).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1F).build();
    public static final FoodProperties PLATINUM_BASS_STEW = new FoodProperties.Builder().nutrition(10).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties PLATINUM_BASS_STEW_CUP = new FoodProperties.Builder().nutrition(5).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1F).build();
    public static final FoodProperties POMEGRANATE_CHICKEN = new FoodProperties.Builder().nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties DELUXE_SALAD = new FoodProperties.Builder().nutrition(10).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1F).build();
    public static final FoodProperties TROPICAL_SHAVED_ICE = new FoodProperties.Builder().nutrition(15).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 4, false, true, true), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F).build();
    public static final FoodProperties PINK_NOODLES = new FoodProperties.Builder().nutrition(12).saturationMod(0.9F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties LIME_POPSICLE = new FoodProperties.Builder().nutrition(3).saturationMod(0.2F).fast()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F).build();
    public static final FoodProperties MEDITERRANEAN_SALMON = new FoodProperties.Builder().nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties SALMON_TARTARE = new FoodProperties.Builder().nutrition(7).saturationMod(0.65F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties COD_CEVICHE = new FoodProperties.Builder().nutrition(9).saturationMod(0.7F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties CARBONARA_PASTA = new FoodProperties.Builder().nutrition(14).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 400, 1), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1F).build();
    public static final FoodProperties CLAM_ROLL = new FoodProperties.Builder().nutrition(7).saturationMod(0.5F).build();
    public static final FoodProperties SEA_WRAP = new FoodProperties.Builder().nutrition(14).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1F).build();
    public static final FoodProperties SALMON_WRAPPED_PRAWN = new FoodProperties.Builder().nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties PRAWN_ROLL = new FoodProperties.Builder().nutrition(7).saturationMod(0.6F).build();
    public static final FoodProperties FISH_MIX = new FoodProperties.Builder().nutrition(8).saturationMod(0.85F).build();
    public static final FoodProperties CRAB_MISO = new FoodProperties.Builder().nutrition(9).saturationMod(1F).build();
    public static final FoodProperties CRAB_NOODLES = new FoodProperties.Builder().nutrition(13).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties BUTTERED_LEGS = new FoodProperties.Builder().nutrition(10).saturationMod(0.9F).build();
    public static final FoodProperties BIG_RICE_BALL = new FoodProperties.Builder().nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties STRAWBERRY_JAM_BUN = new FoodProperties.Builder().nutrition(8).saturationMod(0.55F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F).build();
    public static final FoodProperties COCONUT_PUDDING = new FoodProperties.Builder().nutrition(6).saturationMod(0.5f).build();
    public static final FoodProperties SURF_AND_TURF = new FoodProperties.Builder().nutrition(14).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties CLAM_BAKE = new FoodProperties.Builder().nutrition(13).saturationMod(0.9f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1.0F).build();
    public static final FoodProperties BISQUE = new FoodProperties.Builder().nutrition(8).saturationMod(0.75f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
    public static final FoodProperties STUFFED_NAUTILUS_SHELL = new FoodProperties.Builder().nutrition(8).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1.0F).build();
    public static final FoodProperties SHRIMP_FRIED_RICE = new FoodProperties.Builder().nutrition(7).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 600, 0), 1.0F).build();
    public static final FoodProperties LOBSTER_PASTA = new FoodProperties.Builder().nutrition(10).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties CRAB_BARS = new FoodProperties.Builder().nutrition(4).saturationMod(0.7f).build();
    public static final FoodProperties COOKED_WHOLE_CRAB = new FoodProperties.Builder().nutrition(15).saturationMod(0.6f).build();
    public static final FoodProperties MISO_WITH_BAMBOO_SPROUTS = new FoodProperties.Builder().nutrition(10).saturationMod(0.7f).build();
    public static final FoodProperties GREEN_TEA = new FoodProperties.Builder().alwaysEat()
            .effect(new MobEffectInstance(MobEffects.DIG_SPEED, 3600, 0), 1.0F).build();
    public static final FoodProperties YELLOW_TEA = new FoodProperties.Builder().alwaysEat()
            .effect(new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE, 3600, 0), 1.0F).build();
    public static final FoodProperties BLACK_TEA = new FoodProperties.Builder().alwaysEat()
            .effect(new MobEffectInstance(MobEffects.POISON, 200, 0), 1.0F)
            .effect(new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CAFFEINATED.get(), 200, 0), 1.0F).build();
    public static final FoodProperties DANDELION_TEA = new FoodProperties.Builder().alwaysEat()
            .effect(new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1.0F).build();
    public static final FoodProperties OATMEAL_WITH_STRAWBERRIES = new FoodProperties.Builder().nutrition(4).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.FARMERS_BLESSING.get(), 600, 0), 1F).build();
    public static final FoodProperties COOKED_SALMON = new FoodProperties.Builder().nutrition(7).saturationMod(0.9f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 4800, 0), 1F).meat().build();
    public static final FoodProperties FARMERS_BREAKFAST_ITEM = new FoodProperties.Builder().nutrition(12).saturationMod(1.2f)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.FARMERS_BLESSING.get(), 9600, 0), 1F).meat().build();
    public static final FoodProperties OAT_PANCAKE = new FoodProperties.Builder().nutrition(5).saturationMod(0.6f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 2400, 0), 1F).build();
    public static final FoodProperties POTATO_WITH_ROAST_MEAT_ITEM = new FoodProperties.Builder().nutrition(7).saturationMod(0.7f)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F).meat().build();
    public static final FoodProperties ROASTED_CORN = new FoodProperties.Builder().nutrition(5).saturationMod(0.5f)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties FARMERS_BREAD = new FoodProperties.Builder().nutrition(6).saturationMod(0.8f)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.FARMERS_BLESSING.get(), 3600, 0), 1F).build();
    public static final FoodProperties COFFEE = new FoodProperties.Builder().alwaysEat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1800, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1800, 0), 1.0f).build();
    public static final FoodProperties MILK_COFFEE = new FoodProperties.Builder().alwaysEat().fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 1200, 0), 1.0f)
            .effect(() -> new MobEffectInstance(MobEffects.DIG_SPEED, 1200, 0), 1.0f).build();
    public static final FoodProperties PANCAKE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties CHOCOLATE_PANCAKE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 900, 0, false, false), 1.0F).build();
    public static final FoodProperties FISH_AND_CHIPS = new FoodProperties.Builder().nutrition(14).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(),6000,0), 1).build();
    public static final FoodProperties POTATO_CHIP = new FoodProperties.Builder().nutrition(4).saturationMod(1.0F).fast().build();
    public static final FoodProperties SPRING_ROLL = new FoodProperties.Builder().nutrition(6).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1).build();
    public static final FoodProperties FRIED_DUMPLING = new FoodProperties.Builder().nutrition(16).saturationMod(0.7F)
            .effect(()->new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1).build();
    public static final FoodProperties BOWL_OF_FRIED_DUMPLING = new FoodProperties.Builder().nutrition(4).saturationMod(0.7F).build();
    public static final FoodProperties SPICY_CRAYFISH = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST,3600,0),1.0F).build();
    public static final FoodProperties CRAB_CAKE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED,14400,0),1.0F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_RESISTANCE,14400,0),1.0F).build();
    public static final FoodProperties MARINATED_CRAB = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties CRAB_BUTTER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F).meat().build();
    public static final FoodProperties VANILLA_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VANILLA_SCENT.get(), 400), 1.0F).build();
    public static final FoodProperties CHOCOLATE_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SUGAR_RUSH.get(), 600, 2), 1.0F).build();
    public static final FoodProperties STRAWBERRY_ICE_CREAM = new FoodProperties.Builder().nutrition(6).saturationMod(0.3F).build();
    public static final FoodProperties STRAWBERRY_MILKSHAKE = new FoodProperties.Builder().nutrition(2).saturationMod(1.2F).alwaysEat().build();
    public static final FoodProperties BANANA_MILKSHAKE = new FoodProperties.Builder().nutrition(2).saturationMod(1.5F).alwaysEat()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.AGILITY.get(), 600), 1.0F).build();
    public static final FoodProperties BANANA_BREAD = new FoodProperties.Builder().nutrition(5).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.AGILITY.get(), 600), 1.0F).build();
    public static final FoodProperties ADZUKI_BUN = new FoodProperties.Builder().nutrition(5).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.HARMONY.get(), 300), 1.0F).build();



    public static FoodProperties.Builder startBuilding(int nutrition, float saturationMod) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturationMod);
    }
}