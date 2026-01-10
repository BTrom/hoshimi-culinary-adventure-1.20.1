package com.botrom.hoshimi_ca_mod.registry;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.registry.ModEffects;

public class ModFoods
{
    //Seeds
    public static final FoodProperties POMEGRANATE_SEEDS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F)
//            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 100, 0), 1F)
            .build();

    //Vegetables
    public static final FoodProperties AVOCADO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties CUCUMBER = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();
    public static final FoodProperties EGGPLANT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).build();
    public static final FoodProperties CORN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();
    public static final FoodProperties BROCCOLI = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties PICKLE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.7F).build();
    public static final FoodProperties PEPPER = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties ACORN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).effect(() -> new MobEffectInstance(MobEffects.HUNGER, 200, 0), 1F).build();
    public static final FoodProperties ROASTED_ACORN = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();
    public static final FoodProperties CACTUS_FLESH = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties CACTUS_STEAK = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).build();

    //Fruits
    public static final FoodProperties PINEAPPLE = new FoodProperties.Builder().nutrition(2).saturationMod(0.6F).build();
    public static final FoodProperties OLIVE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties LIME = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 200, 0), 1F)
            .build();
    public static final FoodProperties DRAGON_FRUIT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 400, 0, false, false, true), 1F)
            .build();

    //Slices
    public static final FoodProperties CUT_AVOCADO = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast().build();
    public static final FoodProperties CUT_CUCUMBER = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties CUT_PICKLE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).fast().build();
    public static final FoodProperties CUT_EGGPLANT = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).fast().build();
    public static final FoodProperties ONION_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties PEPPER_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties PINEAPPLE_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties TOMATO_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties MUSHROOM_SLICE = new FoodProperties.Builder().nutrition(1).saturationMod(0.3F).fast().build();
    public static final FoodProperties LIME_SLICE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 100, 0), 1F)
            .build();
    public static final FoodProperties POMEGRANATE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 200, 0), 1F)
            .build();
    public static final FoodProperties PANETTONE_SLICE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.75F).fast().build();
    public static final FoodProperties MUSHROOM_QUICHE_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.4F).build();
    public static final FoodProperties LIME_PIE_SLICE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).fast()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 300, 1), 1F)
            .build();
    public static final FoodProperties POMEGRANATE_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 300, 0), 1F)
            .build();
    public static final FoodProperties DRAGON_FRUIT_CAKE_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SPEED, 400, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 300, 0), 1F)
            .build();
    public static final FoodProperties PLATINUM_BASS_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).build();
    public static final FoodProperties COOKED_PLATINUM_BASS_SLICE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.85F).build();

    //Meats
    public static final FoodProperties CUT_HAM = new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build();
    public static final FoodProperties CHICKEN_WING = new FoodProperties.Builder().nutrition(1).saturationMod(0.15F).fast().meat().build();
    public static final FoodProperties COOKED_WING = new FoodProperties.Builder().nutrition(3).saturationMod(0.3F).fast().meat().build();
    public static final FoodProperties HOT_WING = new FoodProperties.Builder().nutrition(4).saturationMod(0.4F).fast().meat().build();
    public static final FoodProperties CLAM_MEAT = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.3F).build();
    public static final FoodProperties TIGER_PRAWN = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F)
            .effect(() -> new MobEffectInstance(MobEffects.HUNGER, 600, 0), 0.75F).build();
    public static final FoodProperties COOKED_TIGER_PRAWN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();
    public static final FoodProperties PLATINUM_BASS = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.1F).build();
    public static final FoodProperties COOKED_PLATINUM_BASS = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.85F).build();
    public static final FoodProperties CHIEFTAIN_CLAW = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).build();
    public static final FoodProperties CHIEFTAIN_LEG = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.75F).build();
    public static final FoodProperties CHIEFTAIN_CRAB_MEAT = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.5F).build();
    public static final FoodProperties UNI = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();

    //Smoked
    public static final FoodProperties SMOKED_TOMATO = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties SMOKED_CORN = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.7F).build();

    //Ingredients
    public static final FoodProperties BREAD_SLICE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.4f).build();
    public static final FoodProperties TOAST = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.4f).build();
    public static final FoodProperties CORN_DOUGH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();
    public static final FoodProperties TORTILLA = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.6F).build();
    public static final FoodProperties OLIVE_OIL = new FoodProperties.Builder().nutrition(2).saturationMod(1.2F).effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 240, 1), 0.75F).build();
    public static final FoodProperties TOMATO_SAUCE = new FoodProperties.Builder().nutrition(10).saturationMod(1.2F).build();
    public static final FoodProperties HOT_SAUCE = new FoodProperties.Builder().nutrition(10).saturationMod(1.2F).build();
    public static final FoodProperties CHEESE = new FoodProperties.Builder().nutrition(4).saturationMod(1.6F).build();
    public static final FoodProperties JAM_JAR = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.3F).build();
    public static final FoodProperties CREAM_CHEESE = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 400, 1), 1F)
            .build();


    //Meals
    public static final FoodProperties NACHOS = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.3F).fast().build();
    public static final FoodProperties POPCORN = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.2F).fast().build();
    public static final FoodProperties ELOTE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F).build();
    public static final FoodProperties EMPANADA = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();
    public static final FoodProperties HEARTY_SALAD = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties BEEF_BURRITO = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.7F).build();
    public static final FoodProperties CHICKEN_TACO = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties SPICY_CURRY = (new FoodProperties.Builder()).nutrition(12).saturationMod(1.3F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F).build();
    public static final FoodProperties PORK_WRAP = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties FISH_TACO = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F).build();
    public static final FoodProperties MIDORI_ROLL = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.7F).build();
    public static final FoodProperties MIDORI_ROLL_SLICE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.4F).fast().build();
    public static final FoodProperties EGG_ROLL = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F).fast().build();
    public static final FoodProperties TROPICAL_ROLL = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).fast().build();
    public static final FoodProperties RICE_BALL = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().build();
    public static final FoodProperties CHOCOLATE_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.5F).fast().build();
    public static final FoodProperties OMELETTE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).fast().build();
    public static final FoodProperties CREAMY_PASTA_WITH_HAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.8F).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties CREAMY_PASTA_WITH_CHICKEN_CUTS = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.85F).fast()
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.MEDIUM_DURATION, 0), 1.0F).build();
    public static final FoodProperties MASHED_POTATOES = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.5F).fast().build();
    public static final FoodProperties CHICKEN_SALAD = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).fast()
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 100, 0), 1.0F).build();
    public static final FoodProperties TOAST_WITH_SWEET_BERRIES = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties TOAST_WITH_CHOCOLATE = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6f).build();
    public static final FoodProperties MATCHA_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F)
//             .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 500, 1), 1F)
//             .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 400, 0), 1F)
            .build();
    public static final FoodProperties MATCHA_MILKSHAKE = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 200, 1), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 300, 0), 1F)
            .build();
    public static final FoodProperties MATCHA_LATTE = (new FoodProperties.Builder()).alwaysEat().nutrition(6).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getGreenTeaEffect(), 400, 1), 1F)
//            .effect(() -> new MobEffectInstance(TeaCompat.getCaffeinated(), 3600, 1), 1F)
            .build();
    public static final FoodProperties CACTUS_CHILI = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.7F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final FoodProperties CACTUS_SOUP = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 3600, 0), 1F).build();
    public static final FoodProperties FIELD_SALAD = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.REGENERATION, 200, 0), 1F).build();
    public static final FoodProperties CHEESEBURGER = (new FoodProperties.Builder()).nutrition(11).saturationMod(0.85F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.DAMAGE_BOOST, 400, 0), 1F).build();
    public static final FoodProperties MARSHMALLOW_STICK = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.35F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 300, 0), 1F)
            .build();
    public static final FoodProperties COOKED_MARSHMALLOW_STICK = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.35F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 300, 0), 1F).build();
    public static final FoodProperties SMORE = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.COMFORT.get(), 2400, 0), 1F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getSugarRush(), 600, 1), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.SLOW_FALLING, 200, 0), 1F).build();
    public static final FoodProperties PAELLA_BOWL = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), FoodValues.LONG_DURATION, 0), 1.0F)
            .build();
    public static final FoodProperties LIME_ICE_CREAM = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 1200, 1), 1F)
            .build();
    public static final FoodProperties SUNNY_ICE_CREAM = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.3F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.REBOUND.get(), 1600, 1), 1F)
            .effect(() -> new MobEffectInstance(MobEffects.CONFUSION, 200, 0), 1F)
            .build();
    public static final FoodProperties LIME_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(2).saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 1), 1F)
            .build();
    public static final FoodProperties DRAGON_FRUIT_MILKSHAKE = (new FoodProperties.Builder()).alwaysEat().nutrition(2).saturationMod(1.5F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F)
            .build();
    public static final FoodProperties POMEGRANATE_SMOOTHIE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).alwaysEat()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 600, 0), 1F)
//            .effect(() -> new MobEffectInstance(NeapolitanCompat.getAgility(), 600, 0), 1F)
            .build();
    public static final FoodProperties BERRY_LIMEADE = (new FoodProperties.Builder()).alwaysEat().nutrition(5).saturationMod(0.2F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 1200, 0), 1F)
            .build();
    public static final FoodProperties PINK_LIMEADE = (new FoodProperties.Builder()).alwaysEat().nutrition(5).saturationMod(1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 1200, 0), 1F)
            .build();
    public static final FoodProperties DRAGONS_PASSION = (new FoodProperties.Builder()).alwaysEat().nutrition(5).saturationMod(1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F)
//            .effect(() -> new MobEffectInstance(CompatEffects.getSpitting(), 800, 1), 1F)
            .build();
    public static final FoodProperties CLAM_MEATBALL_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties CLAM_MEATBALL_STEW_CUP = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1F)
            .build();
    public static final FoodProperties PRAWN_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties PRAWN_STEW_CUP = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.4F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1F)
            .build();
    public static final FoodProperties PLATINUM_BASS_STEW = (new FoodProperties.Builder()).nutrition(10).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties PLATINUM_BASS_STEW_CUP = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.5F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 1800, 0), 1F)
            .build();
    public static final FoodProperties POMEGRANATE_CHICKEN = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 1200, 0), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties DELUXE_SALAD = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.VOLATILITY.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 600, 0), 1F)
            .build();
    public static final FoodProperties TROPICAL_SHAVED_ICE = (new FoodProperties.Builder()).nutrition(15).saturationMod(0.6F)
            .effect(() -> new MobEffectInstance(MobEffects.MOVEMENT_SLOWDOWN, 300, 4, false, true, true), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F)
            .build();
    public static final FoodProperties PINK_NOODLES = (new FoodProperties.Builder()).nutrition(12).saturationMod(0.9F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.SURGE.get(), 800, 0, false, false, true), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties LIME_POPSICLE = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).fast()
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F)
            .build();
    public static final FoodProperties MEDITERRANEAN_SALMON = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties SALMON_TARTARE = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.65F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F)
            .build();
    public static final FoodProperties COD_CEVICHE = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.7F).effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties CARBONARA_PASTA = (new FoodProperties.Builder()).nutrition(14).saturationMod(0.8F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 400, 1), 1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1F)
            .build();
    public static final FoodProperties CLAM_ROLL = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.5F).build();
    public static final FoodProperties SEA_WRAP = (new FoodProperties.Builder()).nutrition(14).saturationMod(1F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 6000, 0), 1F).build();
    public static final FoodProperties SALMON_WRAPPED_PRAWN = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties PRAWN_ROLL = (new FoodProperties.Builder()).nutrition(7).saturationMod(0.6F).build();
    public static final FoodProperties FISH_MIX = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.85F).build();
    public static final FoodProperties CRAB_MISO = (new FoodProperties.Builder()).nutrition(9).saturationMod(1F).build();
    public static final FoodProperties CRAB_NOODLES = (new FoodProperties.Builder()).nutrition(13).saturationMod(0.75F)
            .effect(() -> new MobEffectInstance(ModEffects.NOURISHMENT.get(), 3600, 0), 1F).build();
    public static final FoodProperties BUTTERED_LEGS = (new FoodProperties.Builder()).nutrition(10).saturationMod(0.9F).build();
    public static final FoodProperties BIG_RICE_BALL = (new FoodProperties.Builder()).nutrition(9).saturationMod(0.9F).build();
    public static final FoodProperties STRAWBERRY_JAM_BUN = (new FoodProperties.Builder()).nutrition(8).saturationMod(0.55F)
            .effect(() -> new MobEffectInstance(MobEffects.HEAL, 1, 0), 1F)
            .effect(() -> new MobEffectInstance(com.botrom.hoshimi_ca_mod.registry.ModEffects.CORROSION.get(), 600, 0), 1F)
            .build();



    public static FoodProperties.Builder startBuilding(int nutrition, float saturationMod) {
        return new FoodProperties.Builder().nutrition(nutrition).saturationMod(saturationMod);
    }
}