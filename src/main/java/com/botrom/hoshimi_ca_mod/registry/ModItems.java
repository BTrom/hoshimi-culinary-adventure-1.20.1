package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.ParrotEggItem;
import com.botrom.hoshimi_ca_mod.items.*;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.CrockPotFoodProperties;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.CrockPotBaseItem;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.FoodCategory;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.FoodUseDuration;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.util.I18nUtils;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blockentity.content.SauceType;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.items.*;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.common.ForgeSpawnEggItem;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.item.ConsumableItem;
import vectorwing.farmersdelight.common.item.DrinkableItem;
import vectorwing.farmersdelight.common.item.FuelItem;
import vectorwing.farmersdelight.common.item.MilkBottleItem;

import java.util.EnumMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import static vectorwing.farmersdelight.common.registry.ModItems.*;
import static vectorwing.farmersdelight.common.registry.ModItems.bowlFoodItem;

public class ModItems {

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, HoshimiCulinaryMod.MOD_ID);


    //Block Items
    public static final RegistryObject<Item> WILD_CUCUMBERS = ITEMS.register("wild_cucumbers", () -> new BlockItem(ModBlocks.WILD_CUCUMBERS.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_EGGPLANTS = ITEMS.register("wild_eggplants", () -> new BlockItem(ModBlocks.WILD_EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> LIME_BUSH = ITEMS.register("lime_bush", () -> new BlockItem(ModBlocks.LIME_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_BUSH = ITEMS.register("dragon_bush", () -> new BlockItem(ModBlocks.DRAGON_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_COB_CRATE = ITEMS.register("corn_crate", () -> new BlockItem(ModBlocks.CORN_COB_CRATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> EXOTIC_ROLL_MEDLEY = ITEMS.register("exotic_roll_medley", () -> new BlockItem(ModBlocks.EXOTIC_ROLL_MEDLEY.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PAELLA = ITEMS.register("paella", () -> new BlockItem(ModBlocks.PAELLA.get(), new Item.Properties().stacksTo(1)));
    public static final RegistryObject<Item> PIZZA = ITEMS.register("pizza", () -> new PizzaBlockItem(ModBlocks.PIZZA.get(), pizzaProperties().stacksTo(1)));
    public static final RegistryObject<Item> RAW_PIZZA = ITEMS.register("raw_pizza", () -> new RawPizzaBlockItem(ModBlocks.RAW_PIZZA.get(), pizzaProperties().stacksTo(1)));
    public static final RegistryObject<Item> PIZZA_DOUGH = registerBlockItem("pizza_dough", ModBlocks.PIZZA_DOUGH, pizzaProperties().stacksTo(16));
    public static final RegistryObject<Item> PIZZA_STATION = registerBlockItem("pizza_station", ModBlocks.PIZZA_STATION, pizzaProperties());
    public static final RegistryObject<Item> PIZZA_OVEN = registerBlockItem("pizza_oven", ModBlocks.PIZZA_OVEN, pizzaProperties());
    public static final RegistryObject<Item> CHEESE_BLOCK = registerBlockItem("cheese_block", ModBlocks.CHEESE_BLOCK, pizzaProperties());
    public static final RegistryObject<Item> GRANITE_BASIN = registerBlockItem("granite_basin", ModBlocks.GRANITE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> DIORITE_BASIN = registerBlockItem("diorite_basin", ModBlocks.DIORITE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> ANDESITE_BASIN = registerBlockItem("andesite_basin", ModBlocks.ANDESITE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> BASALT_BASIN = registerBlockItem("basalt_basin", ModBlocks.BASALT_BASIN, pizzaProperties());
    public static final RegistryObject<Item> BLACKSTONE_BASIN = registerBlockItem("blackstone_basin", ModBlocks.BLACKSTONE_BASIN, pizzaProperties());
    public static final RegistryObject<Item> PANETTONE = registerBlockItem("panettone", ModBlocks.PANETTONE, new Item.Properties());
    public static final RegistryObject<Item> MUSHROOM_QUICHE = registerBlockItem("mushroom_quiche", ModBlocks.MUSHROOM_QUICHE, new Item.Properties());
    public static final RegistryObject<Item> LIME_PIE = registerBlockItem("lime_pie", ModBlocks.LIME_PIE, new Item.Properties());
    public static final RegistryObject<Item> POMEGRANATE_CAKE = registerBlockItem("pomegranate_cake", ModBlocks.POMEGRANATE_CAKE, new Item.Properties().stacksTo(1));
    public static final RegistryObject<Item> DRAGON_FRUIT_CAKE = registerBlockItem("dragon_fruit_cake", ModBlocks.DRAGON_FRUIT_CAKE, new Item.Properties().stacksTo(1));
    public static final RegistryObject<Item> COCONUT = ITEMS.register("coconut", () -> new BlockItem(ModBlocks.COCONUT.get(), basicItem()));
    public static final RegistryObject<Item> SEASHELLS = ITEMS.register("seashells", () -> new BlockItem(ModBlocks.SEASHELLS.get(), basicItem()));
    public static final RegistryObject<Item> CRAB_TRAP = ITEMS.register("crab_trap", () -> new BlockItem(ModBlocks.CRAB_TRAP.get(), basicItem()));
    public static final RegistryObject<Item> PALM_LOG = ITEMS.register("palm_log", () -> new BlockItem(ModBlocks.PALM_LOG.get(), basicItem()));
    public static final RegistryObject<Item> PALM_WOOD = ITEMS.register("palm_wood", () -> new BlockItem(ModBlocks.PALM_WOOD.get(), basicItem()));
    public static final RegistryObject<Item> STRIPPED_PALM_LOG = ITEMS.register("stripped_palm_log", () -> new BlockItem(ModBlocks.STRIPPED_PALM_LOG.get(), basicItem()));
    public static final RegistryObject<Item> STRIPPED_PALM_WOOD = ITEMS.register("stripped_palm_wood", () -> new BlockItem(ModBlocks.STRIPPED_PALM_WOOD.get(), basicItem()));
    public static final RegistryObject<Item> PALM_LEAVES = ITEMS.register("palm_leaves", () -> new BlockItem(ModBlocks.PALM_LEAVES.get(), basicItem()));
    public static final RegistryObject<Item> PALM_SAPLING = ITEMS.register("palm_sapling", () -> new BlockItem(ModBlocks.PALM_SAPLING.get(), basicItem()));
    public static final RegistryObject<Item> HUMMINGBIRD_FEEDER = ITEMS.register("hummingbird_feeder", () -> new BlockItem(ModBlocks.HUMMINGBIRD_FEEDER.get(), basicItem()));
    public static final RegistryObject<Item> TERRAPIN_EGG = ITEMS.register("terrapin_egg", () -> new BlockItem(ModBlocks.TERRAPIN_EGG.get(), basicItem()));
    public static final RegistryObject<Item> RAINBOW_GLASS = ITEMS.register("rainbow_glass", () -> new BlockItem(ModBlocks.RAINBOW_GLASS.get(), basicItem()));
    public static final RegistryObject<Item> ANEMONE_ROSE_BULB = ITEMS.register("anemone_rose_bulb", () -> new BlockItem(ModBlocks.ANEMONE_ROSE_BULB.get(), basicItem()));
    public static final RegistryObject<Item> ANEMONE_SAND = ITEMS.register("anemone_sand", () -> new BlockItem(ModBlocks.ANEMONE_SAND.get(), basicItem()));
    public static final RegistryObject<Item> ANEMONE_SEBAE = ITEMS.register("anemone_sebae", () -> new BlockItem(ModBlocks.ANEMONE_SEBAE.get(), basicItem()));
    public static final RegistryObject<Item> WILD_TEA_BUSH = ITEMS.register("wild_tea_bush", () -> new BlockItem(ModBlocks.WILD_TEA_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEANS_SACK = ITEMS.register("coffee_beans_sack", () -> new BlockItem(ModBlocks.COFFEE_BEANS_SACK.get(), new Item.Properties()));
    public static final RegistryObject<Item> FEEDING_TROUGH = ITEMS.register("feeding_trough", () -> new BlockItem(ModBlocks.FEEDING_TROUGH.get(), new Item.Properties()));
    public static final RegistryObject<Item> PET_BOWL = ITEMS.register("pet_bowl", () -> new BlockItem(ModBlocks.PET_BOWL.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHICKEN_NEST = ITEMS.register("chicken_nest", () -> new BlockItem(ModBlocks.CHICKEN_NEST.get(), new Item.Properties()));
    public static final RegistryObject<Item> STOVE = ITEMS.register("stove", () -> new BlockItem(ModBlocks.STOVE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_CORN = ITEMS.register("wild_corn", () -> new BlockItem(ModBlocks.WILD_CORN.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_STRAWBERRIES = ITEMS.register("wild_strawberries", () -> new BlockItem(ModBlocks.WILD_STRAWBERRIES.get(), new Item.Properties()));
    public static final RegistryObject<Item> DOG_FOOD_BAG = ITEMS.register("dog_food_bag", () -> new BlockItem(ModBlocks.DOG_FOOD_BAG.get(), new Item.Properties()));
    public static final RegistryObject<Item> CAT_FOOD_BAG = ITEMS.register("cat_food_bag", () -> new BlockItem(ModBlocks.CAT_FOOD_BAG.get(), new Item.Properties()));
    public static final RegistryObject<Item> FARMERS_BREAKFAST_ITEM = ITEMS.register("farmers_breakfast", () -> new EffectBlockItem(ModBlocks.FARMERS_BREAKFAST.get(), new Item.Properties().stacksTo(16).food(ModFoods.FARMERS_BREAKFAST_ITEM)));
    public static final RegistryObject<Item> OAT_PANCAKE = ITEMS.register("oat_pancake", () -> new EffectBlockItem(ModBlocks.OAT_PANCAKE_BLOCK.get(), new Item.Properties().stacksTo(16).food(ModFoods.OAT_PANCAKE)));
    public static final RegistryObject<Item> POTATO_WITH_ROAST_MEAT_ITEM = ITEMS.register("potato_with_roast_meat", () -> new EffectBlockItem(ModBlocks.POTATO_WITH_ROAST_MEAT.get(), new Item.Properties().stacksTo(16).food(ModFoods.POTATO_WITH_ROAST_MEAT_ITEM)));
    public static final RegistryObject<Item> ROASTED_CORN = ITEMS.register("roasted_corn", () -> new EffectBlockItem(ModBlocks.ROASTED_CORN_BLOCK.get(), new Item.Properties().stacksTo(16).food(ModFoods.ROASTED_CORN)));
    public static final RegistryObject<Item> FARMERS_BREAD_ITEM = ITEMS.register("farmers_bread", () -> new EffectBlockItem(ModBlocks.FARMERS_BREAD.get(), new Item.Properties().stacksTo(16).food(ModFoods.FARMERS_BREAD)));
    public static final RegistryObject<Item> COTTON_BOLL_CRATE = ITEMS.register("cotton_boll_crate", () -> new BlockItem(ModBlocks.COTTON_BOLL_CRATE.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_COTTON = ITEMS.register("wild_cotton", () -> new BlockItem(ModBlocks.WILD_COTTON.get(), new Item.Properties()));
    public static final RegistryObject<Item> WILD_COFFEE = ITEMS.register("wild_coffee", () -> new BlockItem(ModBlocks.WILD_COFFEE.get(), new Item.Properties()));
    public static final RegistryObject<Item> CHERRY_BLOSSOM_CHEESECAKE = ITEMS.register("cherry_blossom_cheesecake", () -> new BlockItem(ModBlocks.CHERRY_BLOSSOM_CHEESECAKE.get(), new Item.Properties()));
    public static final RegistryObject<Item> PANCAKES = ITEMS.register("pancakes", () -> new BlockItem(ModBlocks.PANCAKES.get(), new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> CHOCOLATE_PANCAKES = ITEMS.register("chocolate_pancakes", () -> new BlockItem(ModBlocks.CHOCOLATE_PANCAKES.get(), new Item.Properties().craftRemainder(Items.BOWL).stacksTo(16)));
    public static final RegistryObject<Item> DEEP_FRYING_PAN = ITEMS.register("deep_frying_pan", () -> new BlockItem(ModBlocks.DEEP_FRYING_PAN.get(), new Item.Properties()));
    public static final RegistryObject<Item> SPRING_ROLL_MEDLEY = ITEMS.register("spring_roll_medley", () -> new BlockItem(ModBlocks.SPRING_ROLL_MEDLEY.get(), new Item.Properties()));
    public static final RegistryObject<Item> PLATE_OF_FRIED_DUMPLING = ITEMS.register("plate_of_fried_dumpling", () -> new BlockItem(ModBlocks.PLATE_OF_FRIED_DUMPLING.get(), new Item.Properties()));
    public static final RegistryObject<Item> CROCK_POT = ITEMS.register("crock_pot", () -> new CrockPotBlockItem(ModBlocks.CROCK_POT.get()));
    public static final RegistryObject<Item> PORTABLE_CROCK_POT = ITEMS.register("portable_crock_pot", () -> new CrockPotBlockItem(ModBlocks.PORTABLE_CROCK_POT.get(), new Item.Properties().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<Item> BIRDCAGE = ITEMS.register("birdcage", () -> new BlockItem(ModBlocks.BIRDCAGE.get(), new Item.Properties()));
    public static final RegistryObject<Item> BACON_EGGS = ITEMS.register("bacon_eggs", () -> new CrockPotFoodBlockItem(ModBlocks.BACON_EGGS.get(), CrockPotFoodProperties.builder(12, 0.8F).heal(4.0F).meat().build()));
    public static final RegistryObject<Item> BONE_SOUP = ITEMS.register("bone_soup", () -> new CrockPotFoodBlockItem(ModBlocks.BONE_SOUP.get(), CrockPotFoodProperties.builder(10, 0.6F).effect(MobEffects.ABSORPTION, 2 * 60 * 20, 1).meat().rarity(Rarity.UNCOMMON).build()));
    public static final RegistryObject<Item> BONE_STEW = ITEMS.register("bone_stew", () -> new CrockPotFoodBlockItem(ModBlocks.BONE_STEW.get(), CrockPotFoodProperties.builder(20, 0.4F).duration(FoodUseDuration.SUPER_SLOW).effect(MobEffects.HEAL, 1, 1).meat().build()));
    public static final RegistryObject<Item> BREAKFAST_SKILLET = ITEMS.register("breakfast_skillet", () -> new CrockPotFoodBlockItem(ModBlocks.BREAKFAST_SKILLET.get(), CrockPotFoodProperties.builder(8, 0.8F).meat().build()));
    public static final RegistryObject<Item> BUNNY_STEW = ITEMS.register("bunny_stew", () -> new CrockPotFoodBlockItem(ModBlocks.BUNNY_STEW.get(), CrockPotFoodProperties.builder(6, 0.8F).effect(MobEffects.REGENERATION, 5 * 20).effect(ModEffects.WELL_FED, 2 * 60 * 20).meat().build()));
    public static final RegistryObject<Item> CALIFORNIA_ROLL = ITEMS.register("california_roll", () -> new CrockPotFoodBlockItem(ModBlocks.CALIFORNIA_ROLL.get(), CrockPotFoodProperties.builder(10, 0.6F).heal(4.0F).effect(MobEffects.ABSORPTION, 60 * 20).meat().build()));
    public static final RegistryObject<Item> CEVICHE = ITEMS.register("ceviche", () -> new CrockPotFoodBlockItem(ModBlocks.CEVICHE.get(), CrockPotFoodProperties.builder(7, 0.7F).alwaysEat().effect(MobEffects.DAMAGE_RESISTANCE, 20 * 20, 1).effect(MobEffects.ABSORPTION, 20 * 20, 1).meat().build()));
    public static final RegistryObject<Item> GLOW_BERRY_MOUSSE = ITEMS.register("glow_berry_mousse", () -> new CrockPotFoodBlockItem(ModBlocks.GLOW_BERRY_MOUSSE.get(), CrockPotFoodProperties.builder(6, 0.6F).duration(FoodUseDuration.FAST).effect(MobEffects.GLOWING, 10 * 20).rarity(Rarity.UNCOMMON).build()));
    public static final RegistryObject<Item> HONEY_NUGGETS = ITEMS.register("honey_nuggets", () -> new CrockPotFoodBlockItem(ModBlocks.HONEY_NUGGETS.get(), CrockPotFoodProperties.builder(8, 0.3F).effect(MobEffects.REGENERATION, 10 * 20).effect(MobEffects.ABSORPTION, 60 * 20).heal(4.0F).meat().build()));
    public static final RegistryObject<Item> HOT_CHILI = ITEMS.register("hot_chili", () -> new CrockPotFoodBlockItem(ModBlocks.HOT_CHILI.get(), CrockPotFoodProperties.builder(9, 0.8F).effect(MobEffects.DAMAGE_BOOST, (60 + 30) * 20).effect(MobEffects.DIG_SPEED, (60 + 30) * 20).meat().build()));
    public static final RegistryObject<Item> ICED_TEA = ITEMS.register("iced_tea", () -> new CrockPotFoodBlockItem(ModBlocks.ICED_TEA.get(), CrockPotFoodProperties.builder(3, 0.1F).duration(FoodUseDuration.FAST).alwaysEat().drink().effect(MobEffects.MOVEMENT_SPEED, 10 * 60 * 20, 1).effect(MobEffects.JUMP, 5 * 60 * 20, 1).build()));
    public static final RegistryObject<Item> JAMMY_PRESERVES = ITEMS.register("jammy_preserves", () -> new CrockPotFoodBlockItem(ModBlocks.JAMMY_PRESERVES.get(), CrockPotFoodProperties.builder(6, 0.3F).duration(FoodUseDuration.FAST).build()));
    public static final RegistryObject<Item> MEAT_BALLS = ITEMS.register("meat_balls", () -> new CrockPotFoodBlockItem(ModBlocks.MEAT_BALLS.get(), CrockPotFoodProperties.builder(9, 0.5F).meat().build()));
    public static final RegistryObject<Item> MONSTER_LASAGNA = ITEMS.register("monster_lasagna", () -> new CrockPotFoodBlockItem(ModBlocks.MONSTER_LASAGNA.get(), CrockPotFoodProperties.builder(7, 0.2F).effect(MobEffects.HUNGER, 15 * 20).effect(MobEffects.POISON, 2 * 20).damage(ModTags.MONSTER_FOOD, 6.0F).meat().build()));
    public static final RegistryObject<Item> MONSTER_TARTARE = ITEMS.register("monster_tartare", () -> new CrockPotFoodBlockItem(ModBlocks.MONSTER_TARTARE.get(), CrockPotFoodProperties.builder(8, 0.7F).effect(MobEffects.DAMAGE_BOOST, 2 * 60 * 20, 1).meat().rarity(Rarity.UNCOMMON).build()));
    public static final RegistryObject<Item> PEPPER_POPPER = ITEMS.register("pepper_popper", () -> new CrockPotFoodBlockItem(ModBlocks.PEPPER_POPPER.get(), CrockPotFoodProperties.builder(8, 0.8F).effect(MobEffects.DAMAGE_BOOST, 60 * 20, 1).meat().build()));
    public static final RegistryObject<Item> PIEROGI = ITEMS.register("pierogi", () -> new CrockPotFoodBlockItem(ModBlocks.PIEROGI.get(), CrockPotFoodProperties.builder(8, 0.8F).heal(6.0F).meat().build()));
    public static final RegistryObject<Item> POTATO_TORNADO = ITEMS.register("potato_tornado", () -> new CrockPotFoodBlockItem(ModBlocks.POTATO_TORNADO.get(), CrockPotFoodProperties.builder(8, 0.6F).duration(FoodUseDuration.FAST).removeEffect(MobEffects.HUNGER).build()));
    public static final RegistryObject<Item> RATATOUILLE = ITEMS.register("ratatouille", () -> new CrockPotFoodBlockItem(ModBlocks.RATATOUILLE.get(), CrockPotFoodProperties.builder(6, 0.4F).duration(FoodUseDuration.FAST).build()));
    public static final RegistryObject<Item> SALMON_SUSHI = ITEMS.register("salmon_sushi", () -> new CrockPotFoodBlockItem(ModBlocks.SALMON_SUSHI.get(), CrockPotFoodProperties.builder(5, 0.8F).duration(FoodUseDuration.FAST).heal(1.0F).meat().build()));
    public static final RegistryObject<Item> STEAMED_STICKS = ITEMS.register("steamed_sticks", SteamedSticksItem::new);
    public static final RegistryObject<Item> STUFFED_EGGPLANT = ITEMS.register("stuffed_eggplant", () -> new CrockPotFoodBlockItem(ModBlocks.STUFFED_EGGPLANT.get(), CrockPotFoodProperties.builder(7, 0.6F).duration(FoodUseDuration.FAST).heal(2.0F).build()));
    public static final RegistryObject<Item> SURF_N_TURF = ITEMS.register("surf_n_turf", () -> new CrockPotFoodBlockItem(ModBlocks.SURF_N_TURF.get(), CrockPotFoodProperties.builder(8, 1.2F).alwaysEat().effect(MobEffects.REGENERATION, 30 * 20, 1).heal(8.0F).meat().build()));
    public static final RegistryObject<Item> WATERMELON_ICLE = ITEMS.register("watermelon_icle", () -> new CrockPotFoodBlockItem(ModBlocks.WATERMELON_ICLE.get(), CrockPotFoodProperties.builder(5, 0.4F).duration(FoodUseDuration.FAST).effect(MobEffects.MOVEMENT_SPEED, 3 * 60 * 20).effect(MobEffects.JUMP, 3 * 60 * 20).removeEffect(MobEffects.MOVEMENT_SLOWDOWN).build()));
    public static final RegistryObject<Item> WET_GOOP = ITEMS.register("wet_goop", () -> new CrockPotFoodBlockItem(ModBlocks.WET_GOOP.get(), CrockPotFoodProperties.builder().duration(FoodUseDuration.SUPER_SLOW).alwaysEat().effect(MobEffects.CONFUSION, 10 * 20).tooltip("wet_goop", ChatFormatting.DARK_AQUA).build()));
    public static final RegistryObject<Item> NETHEROSIA = ITEMS.register("netherosia", NetherosiaItem::new);
    public static final RegistryObject<Item> EYE_BONE = ITEMS.register("eye_bone", () -> new EyeBoneBlockItem(new Item.Properties()));


    //Seeds
    public static final RegistryObject<Item> CUCUMBER_SEEDS = ITEMS.register("cucumber_seeds", () -> new ItemNameBlockItem(ModBlocks.CUCUMBERS.get(), new Item.Properties()));
    public static final RegistryObject<Item> CORN_KERNELS = ITEMS.register("corn_kernels", () -> new ItemNameBlockItem(ModBlocks.CORN_BOTTOM.get(), new Item.Properties()));
    public static final RegistryObject<Item> EGGPLANT_SEEDS = ITEMS.register("eggplant_seeds", () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> AVOCADO_SEED = ITEMS.register("avocado_seed", () -> new ItemNameBlockItem(ModBlocks.EGGPLANTS.get(), new Item.Properties()));
    public static final RegistryObject<Item> BROCCOLI_SEEDS = ITEMS.register("broccoli_seeds", () -> new ItemNameBlockItem(ModBlocks.BROCCOLI.get(), pizzaProperties()));
    public static final RegistryObject<Item> PEPPER_SEEDS = ITEMS.register("pepper_seeds", () -> new ItemNameBlockItem(ModBlocks.PEPPERS.get(), pizzaProperties()));
    public static final RegistryObject<Item> PINEAPPLE_SEEDS = ITEMS.register("pineapple_seeds", () -> new ItemNameBlockItem(ModBlocks.PINEAPPLE.get(), pizzaProperties()));
//    public static final RegistryObject<Item> POMEGRANATE_SEEDS = ITEMS.register("pomegranate_seeds", () -> new ItemNameBlockItem(ModBlocks.POMEGRANATE_BUSH.get(), (new Item.Properties()).food(ModFoods.POMEGRANATE_SEEDS)));
    public static final RegistryObject<Item> LIME_SEEDS = ITEMS.register("lime_seeds", () -> new ItemNameBlockItem(ModBlocks.LIME_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> DRAGON_FRUIT_SEEDS = ITEMS.register("dragon_fruit_seeds", () -> new ItemNameBlockItem(ModBlocks.BUDDING_DRAGON_FRUIT_CROP.get(), basicItem()));
    public static final RegistryObject<Item> DRAGON_FRUIT_CROP = ITEMS.register("dragon_fruits", () -> new ItemNameBlockItem(ModBlocks.DRAGON_FRUIT_CROP.get(), basicItem()));
    public static final RegistryObject<Item> GREEN_ONION_SEEDS = ITEMS.register("green_onion_seeds", () -> new ItemNameBlockItem(ModBlocks.GREEN_ONIONS.get(), new Item.Properties()));
    public static final RegistryObject<Item> TEA_SEEDS = ITEMS.register("tea_seeds", () -> new BlockItem(ModBlocks.SMALL_TEA_BUSH.get(), new Item.Properties()));
    public static final RegistryObject<Item> OAT_SEEDS = ITEMS.register("oat_seeds", () -> new ItemNameBlockItem(ModBlocks.OAT_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY_SEEDS = ITEMS.register("strawberry_seeds", () -> new ItemNameBlockItem(ModBlocks.STRAWBERRY_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> COTTON_SEEDS = ITEMS.register("cotton_seeds", () -> new ItemNameBlockItem(ModBlocks.COTTON_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> COFFEE_BEANS = ITEMS.register("coffee_beans", () -> new ItemNameBlockItem(ModBlocks.COFFEE_CROP.get(), new Item.Properties()));
    public static final RegistryObject<Item> UNKNOWN_SEEDS = ITEMS.register("unknown_seeds", () -> new CrockPotSeedsItem(ModBlocks.UNKNOWN_CROPS.get()));
    public static final RegistryObject<Item> ASPARAGUS_SEEDS = ITEMS.register("asparagus_seeds", () -> new CrockPotSeedsItem(ModBlocks.ASPARAGUS.get()));
    public static final RegistryObject<Item> GARLIC_SEEDS = ITEMS.register("garlic_seeds", () -> new CrockPotSeedsItem(ModBlocks.GARLICS.get()));


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
    public static final RegistryObject<Item> JAM_JAR = ITEMS.register("jam_jar", () -> new ConsumableItem(new Item.Properties().food(ModFoods.JAM_JAR).craftRemainder(Items.GLASS_BOTTLE), false, false));
    public static final RegistryObject<Item> BROCCOLI = ITEMS.register("broccoli", () -> new Item(pizzaProperties().food(ModFoods.BROCCOLI)));
    public static final RegistryObject<Item> PEPPER = ITEMS.register("pepper", () -> new Item(pizzaProperties().food(ModFoods.PEPPER)));
    public static final RegistryObject<Item> PINEAPPLE = ITEMS.register("pineapple", () -> new Item(pizzaProperties().food(ModFoods.PINEAPPLE)));
    public static final RegistryObject<Item> OLIVE = ITEMS.register("olive", () -> new Item(pizzaProperties().food(ModFoods.OLIVE)));
    public static final RegistryObject<Item> ONION_SLICE = ITEMS.register("onion_slice", () -> new Item(pizzaProperties().food(ModFoods.ONION_SLICE)));
    public static final RegistryObject<Item> PEPPER_SLICE = ITEMS.register("pepper_slice", () -> new Item(pizzaProperties().food(ModFoods.PEPPER_SLICE)));
    public static final RegistryObject<Item> PINEAPPLE_SLICE = ITEMS.register("pineapple_slice", () -> new Item(pizzaProperties().food(ModFoods.PINEAPPLE_SLICE)));
    public static final RegistryObject<Item> MUSHROOM_SLICE = ITEMS.register("mushroom_slice", () -> new Item(pizzaProperties().food(ModFoods.MUSHROOM_SLICE)));
    public static final RegistryObject<Item> CUT_HAM = ITEMS.register("cut_ham", () -> new Item(pizzaProperties().food(ModFoods.CUT_HAM)));
    public static final RegistryObject<Item> CHICKEN_WING = ITEMS.register("chicken_wing", () -> new Item(pizzaProperties().food(ModFoods.CHICKEN_WING)));
    public static final RegistryObject<Item> COOKED_WING = ITEMS.register("cooked_wing", () -> new Item(pizzaProperties().food(ModFoods.COOKED_WING)));
    public static final RegistryObject<Item> HOT_WING = ITEMS.register("hot_wing", () -> new Item(pizzaProperties().food(ModFoods.HOT_WING)));
    public static final RegistryObject<Item> CORN_FLOUR = ITEMS.register("corn_flour", () -> new Item(pizzaProperties()));
    public static final RegistryObject<Item> CHEESE = ITEMS.register("cheese", () -> new Item(pizzaProperties().food(ModFoods.CHEESE)));
    public static final RegistryObject<Item> OLIVE_OIL = ITEMS.register("olive_oil", () -> new SauceItem(pizzaProperties().stacksTo(1).food(ModFoods.OLIVE_OIL), SauceType.NONE));
    public static final RegistryObject<Item> TOMATO_SAUCE = ITEMS.register("tomato_sauce", () -> new SauceItem(pizzaProperties().stacksTo(1).food(ModFoods.TOMATO_SAUCE), SauceType.TOMATO));
    public static final RegistryObject<Item> HOT_SAUCE = ITEMS.register("hot_sauce", () -> new SauceItem(pizzaProperties().stacksTo(1).food(ModFoods.HOT_SAUCE), SauceType.HOT));
    public static final RegistryObject<Item> POMEGRANATE = ITEMS.register("pomegranate", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> POMEGRANATE_SLICE = ITEMS.register("pomegranate_slice", () -> new Item(new Item.Properties().food(ModFoods.POMEGRANATE_SLICE)));
    public static final RegistryObject<Item> LIME = ITEMS.register("lime", () -> new Item(new Item.Properties().food(ModFoods.LIME)));
    public static final RegistryObject<Item> LIME_SLICE = ITEMS.register("lime_slice", () -> new Item(new Item.Properties().food(ModFoods.LIME_SLICE)));
    public static final RegistryObject<Item> DRAGON_FRUIT = ITEMS.register("dragon_fruit", () -> new Item(new Item.Properties().food(ModFoods.DRAGON_FRUIT)));
    public static final RegistryObject<Item> CREAM_CHEESE = ITEMS.register("cream_cheese", () -> new ConsumableItem(bowlFoodItem(ModFoods.CREAM_CHEESE), true, false));
    public static final RegistryObject<Item> CLAM = ITEMS.register("clam", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CLAM_MEAT = ITEMS.register("clam_meat", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CLAM_MEAT)));
    public static final RegistryObject<Item> TIGER_PRAWN = ITEMS.register("tiger_prawn", () -> new ConsumableItem(new Item.Properties().food(ModFoods.TIGER_PRAWN), true, false));
    public static final RegistryObject<Item> COOKED_TIGER_PRAWN = ITEMS.register("cooked_tiger_prawn", () -> new ConsumableItem(new Item.Properties().food(ModFoods.COOKED_TIGER_PRAWN)));
    public static final RegistryObject<Item> PLATINUM_BASS = ITEMS.register("platinum_bass", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PLATINUM_BASS)));
    public static final RegistryObject<Item> COOKED_PLATINUM_BASS = ITEMS.register("cooked_platinum_bass", () -> new ConsumableItem(new Item.Properties().food(ModFoods.COOKED_PLATINUM_BASS)));
    public static final RegistryObject<Item> PLATINUM_BASS_SLICE = ITEMS.register("platinum_bass_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PLATINUM_BASS_SLICE)));
    public static final RegistryObject<Item> COOKED_PLATINUM_BASS_SLICE = ITEMS.register("cooked_platinum_bass_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.COOKED_PLATINUM_BASS_SLICE)));
    public static final RegistryObject<Item> CHIEFTAIN_CRAB = ITEMS.register("chieftain_crab", () -> new Item(new Item.Properties().stacksTo(1).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> CHIEFTAIN_CLAW = ITEMS.register("chieftain_claw", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CHIEFTAIN_CLAW)));
    public static final RegistryObject<Item> CHIEFTAIN_LEG = ITEMS.register("chieftain_leg", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CHIEFTAIN_LEG)));
    public static final RegistryObject<Item> CHIEFTAIN_CRAB_MEAT = ITEMS.register("chieftain_crab_meat", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CHIEFTAIN_CRAB_MEAT)));
    public static final RegistryObject<Item> URCHIN = ITEMS.register("urchin", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> UNI = ITEMS.register("uni", () -> new ConsumableItem(new Item.Properties().food(ModFoods.UNI)));
    public static final RegistryObject<Item> URCHIN_TEST = ITEMS.register("urchin_test", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> URCHIN_NEEDLE = ITEMS.register("urchin_needle", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> PEARL = ITEMS.register("pearl", () -> new Item(basicItem()));
    public static final RegistryObject<Item> CAN = ITEMS.register("can", () -> new Item(basicItem()));
    public static final RegistryObject<Item> FISH_BONES = ITEMS.register("fish_bones", () -> new Item(basicItem()));
    public static final RegistryObject<Item> COCONUT_HALF = ITEMS.register("coconut_half", () -> new ConsumableItem(foodItem(ModFoods.COCONUT_HALF)));
    public static final RegistryObject<Item> COCONUT_MILK = ITEMS.register("coconut_milk", () -> new MilkBottleItem(foodItem(ModFoods.COCONUT_MILK).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> RAW_FIDDLER_CRAB = ITEMS.register("fiddler_crab", () -> new ConsumableItem(foodItem(ModFoods.RAW_FIDDLER_CRAB)));
    public static final RegistryObject<Item> COOKED_FIDDLER_CRAB = ITEMS.register("cooked_fiddler_crab", () -> new ConsumableItem(foodItem(ModFoods.COOKED_FIDDLER_CRAB)));
    public static final RegistryObject<Item> RAW_LOBSTER = ITEMS.register("lobster", () -> new ConsumableItem(foodItem(ModFoods.RAW_LOBSTER)));
    public static final RegistryObject<Item> COOKED_LOBSTER = ITEMS.register("cooked_lobster", () -> new ConsumableItem(foodItem(ModFoods.COOKED_LOBSTER)));
    public static final RegistryObject<Item> RAW_SHRIMP = ITEMS.register("shrimp", () -> new ConsumableItem(foodItem(ModFoods.RAW_SHRIMP), true));
    public static final RegistryObject<Item> COOKED_SHRIMP = ITEMS.register("cooked_shrimp", () -> new ConsumableItem(foodItem(ModFoods.COOKED_SHRIMP)));
    public static final RegistryObject<Item> FIDDLER_CRAB_LEGS = ITEMS.register("fiddler_crab_legs", () -> new ConsumableItem(foodItem(ModFoods.FIDDLER_CRAB_LEGS)));
    public static final RegistryObject<Item> FIDDLER_CRAB_CLAW = ITEMS.register("fiddler_crab_claw", () -> new Item(basicItem()));
    public static final RegistryObject<Item> COOKED_CLAM_MEAT = ITEMS.register("cooked_clam_meat", () -> new ConsumableItem(foodItem(ModFoods.COOKED_CLAM_MEAT)));
    public static final RegistryObject<Item> LOBSTER_TAIL = ITEMS.register("lobster_tail", () -> new Item(new Item.Properties().food(ModFoods.LOBSTER_TAIL)));
    public static final RegistryObject<Item> COOKED_LOBSTER_TAIL = ITEMS.register("cooked_lobster_tail", () -> new Item(new Item.Properties().food(ModFoods.COOKED_LOBSTER_TAIL)));
    public static final RegistryObject<Item> RAW_CATFISH = ITEMS.register("raw_catfish", () -> new Item(new Item.Properties().food(ModFoods.RAW_CATFISH)));
    public static final RegistryObject<Item> COOKED_CATFISH = ITEMS.register("cooked_catfish", () -> new Item(new Item.Properties().food(ModFoods.COOKED_CATFISH)));
    public static final RegistryObject<Item> COOKED_CATFISH_SLICE = ITEMS.register("cooked_catfish_slice", () -> new Item(new Item.Properties().food(ModFoods.COOKED_CATFISH_SLICE)));
    public static final RegistryObject<Item> RAW_CATFISH_SLICE = ITEMS.register("raw_catfish_slice", () -> new Item(new Item.Properties().food(ModFoods.RAW_CATFISH_SLICE)));
    public static final RegistryObject<Item> SHARK_TOOTH = ITEMS.register("shark_tooth", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CACHALOT_WHALE_TOOTH = ITEMS.register("cachalot_whale_tooth", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> AMBERGRIS = ITEMS.register("ambergris", () -> new FuelItem(new Item.Properties(), 12800));
    public static final RegistryObject<Item> LOST_TENTACLE = ITEMS.register("lost_tentacle", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> RAINBOW_JELLY = ITEMS.register("rainbow_jelly", () -> new Item(new Item.Properties().food(ModFoods.RAINBOW_JELLY)));
    public static final RegistryObject<Item> ECHOLOCATOR = ITEMS.register("echolocator", () -> new ItemEcholocator(new Item.Properties().durability(100), ItemEcholocator.EchoType.ECHOLOCATION));
    public static final RegistryObject<Item> ENDOLOCATOR = ITEMS.register("endolocator", () -> new ItemEcholocator(new Item.Properties().durability(25), ItemEcholocator.EchoType.ENDER));
    public static final RegistryObject<Item> GREEN_ONION = ITEMS.register("green_onion", () -> new Item(pizzaProperties().food(ModFoods.GREEN_ONION)));
    public static final RegistryObject<Item> GREEN_TEA_LEAVES = ITEMS.register("green_tea_leaves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> YELLOW_TEA_LEAVES = ITEMS.register("yellow_tea_leaves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> BLACK_TEA_LEAVES = ITEMS.register("black_tea_leaves", () -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> STRAWBERRY = ITEMS.register("strawberry", () -> new Item(new Item.Properties())); // TODO
    public static final RegistryObject<Item> COTTON_BOLL = ITEMS.register("cotton_boll", () -> new FuelItem(new Item.Properties(), 100));
    public static final RegistryObject<Item> POTATO_SLICE = ITEMS.register("potato_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.POTATO_SLICE)));
    public static final RegistryObject<Item> RAW_SPRING_ROLL = ITEMS.register("raw_spring_roll", () -> new ConsumableItem(new Item.Properties().food(ModFoods.RAW_SPRING_ROLL)));
    public static final RegistryObject<Item> TONKATSU = ITEMS.register("tonkatsu", () -> new ConsumableItem(new Item.Properties().food(ModFoods.TONKATSU)));
    public static final RegistryObject<Item> RAW_FRIED_DUMPLING = ITEMS.register("raw_fried_dumpling", () -> new ConsumableItem(new Item.Properties().food(ModFoods.RAW_FRIED_DUMPLING)));
    public static final RegistryObject<Item> ASPARAGUS = ITEMS.register("asparagus", () -> new CrockPotFoodItem(CrockPotFoodProperties.builder(3, 0.6F).hideEffects().build()));
    public static final RegistryObject<Item> GARLIC = ITEMS.register("garlic", () -> new CrockPotFoodItem(CrockPotFoodProperties.builder(3, 0.6F).hideEffects().build()));
    public static final RegistryObject<Item> CHILI_PEPPER = ITEMS.register("chili_pepper", () -> new CrockPotFoodItem(CrockPotFoodProperties.builder(3, 0.6F).damage(ModTags.SPICY, 1).hideEffects().build()));
//    public static final RegistryObject<Item> PARROT_EGG_RED_BLUE = ITEMS.register("parrot_egg_red_blue", () -> new ParrotEggItem(Parrot.Variant.RED_BLUE));
//    public static final RegistryObject<Item> PARROT_EGG_BLUE = ITEMS.register("parrot_egg_blue", () -> new ParrotEggItem(Parrot.Variant.BLUE));
//    public static final RegistryObject<Item> PARROT_EGG_GREEN = ITEMS.register("parrot_egg_green", () -> new ParrotEggItem(Parrot.Variant.GREEN));
//    public static final RegistryObject<Item> PARROT_EGG_YELLOW_BLUE = ITEMS.register("parrot_egg_yellow_blue", () -> new ParrotEggItem(Parrot.Variant.YELLOW_BLUE));
//    public static final RegistryObject<Item> PARROT_EGG_GRAY = ITEMS.register("parrot_egg_gray", () -> new ParrotEggItem(Parrot.Variant.GRAY));
    public static final RegistryObject<Item> CROCK_POT_UPGRADE_SMITHING_TEMPLATE = ITEMS.register("pot_upgrade_smithing_template", () -> new SmithingTemplateItem(I18nUtils.createTooltipComponent("smithing_template.pot_upgrade.applies_to").withStyle(ChatFormatting.BLUE), I18nUtils.createTooltipComponent("smithing_template.pot_upgrade.ingredients").withStyle(ChatFormatting.BLUE), I18nUtils.createComponent("upgrade", "pot_upgrade").withStyle(ChatFormatting.GRAY), I18nUtils.createTooltipComponent("smithing_template.pot_upgrade.base_slot_description"), I18nUtils.createTooltipComponent("smithing_template.pot_upgrade.additions_slot_description"), List.of(Utils.createResourceLocation("item/empty_slot_pot")), List.of(Utils.createResourceLocation("item/empty_slot_block"))));
    public static final RegistryObject<Item> HOGLIN_NOSE = ITEMS.register("hoglin_nose", () -> new CrockPotFoodItem(CrockPotFoodProperties.builder(3, 0.2F).meat().hideEffects().build()));
    public static final RegistryObject<Item> COOKED_HOGLIN_NOSE = ITEMS.register("cooked_hoglin_nose", () -> new CrockPotFoodItem(CrockPotFoodProperties.builder(8, 0.7F).meat().hideEffects().build()));
    public static final RegistryObject<Item> SYRUP = ITEMS.register("syrup", () -> new CrockPotFoodItem(CrockPotFoodProperties.builder(1, 0.3F).drink().sound(SoundEvents.HONEY_DRINK).hideEffects().build()));
    public static final RegistryObject<Item> CRAB_SHELL = ITEMS.register("crab_shell",() -> new Item(new Item.Properties()));
    public static final RegistryObject<Item> CRAB_MEAT = ITEMS.register("crab_meat",() -> new Item(new Item.Properties().food(ModFoods.CRAB_MEAT)));
    public static final RegistryObject<Item> COOKED_CRAB_MEAT = ITEMS.register("cooked_crab_meat",() -> new Item(new Item.Properties().food(ModFoods.COOKED_CRAB_MEAT)));
    public static final RegistryObject<Item> GIANT_MUD_CRAB = ITEMS.register("giant_mud_crab",() -> new Item(new Item.Properties().food(ModFoods.GIANT_MUD_CRAB)));
    public static final RegistryObject<Item> KING_CRAB = ITEMS.register("king_crab",() -> new Item(new Item.Properties().food(ModFoods.KING_CRAB)));
    public static final RegistryObject<Item> CRAYFISH = ITEMS.register("crayfish",() -> new Item(new Item.Properties().food(ModFoods.CRAB_MEAT)));
    public static final RegistryObject<Item> OYSTER = ITEMS.register("oyster",() -> new Item(new Item.Properties().food(ModFoods.OYSTER)));
    public static final RegistryObject<Item> COOKED_GIANT_MUD_CRAB = ITEMS.register("cooked_giant_mud_crab",() -> new Item(new Item.Properties().food(ModFoods.COOKED_GIANT_MUD_CRAB)));
    public static final RegistryObject<Item> COOKED_KING_CRAB = ITEMS.register("cooked_king_crab",() -> new Item(new Item.Properties().food(ModFoods.COOKED_KING_CRAB)));
    public static final RegistryObject<Item> COOKED_CRAYFISH = ITEMS.register("cooked_crayfish",() -> new Item(new Item.Properties().food(ModFoods.COOKED_CRAB_MEAT)));


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
    public static final RegistryObject<Item> MATCHA_ICE_CREAM = ITEMS.register("matcha_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ModFoods.MATCHA_ICE_CREAM)));
    public static final RegistryObject<Item> MATCHA_MILKSHAKE = ITEMS.register("matcha_milkshake", () -> new Item(new Item.Properties().food(ModFoods.MATCHA_MILKSHAKE)));
    public static final RegistryObject<Item> MATCHA_LATTE = ITEMS.register("matcha_latte", () -> new DrinkableItem(new Item.Properties().food(ModFoods.MATCHA_LATTE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE), true, false));
    public static final RegistryObject<Item> CACTUS_CHILI = ITEMS.register("cactus_chili", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CACTUS_CHILI).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> CACTUS_SOUP = ITEMS.register("cactus_soup", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CACTUS_SOUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> FIELD_SALAD = ITEMS.register("field_salad", () -> new ConsumableItem(new Item.Properties().food(ModFoods.FIELD_SALAD).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> CHEESEBURGER = ITEMS.register("cheeseburger", () -> new Item(new Item.Properties().food(ModFoods.CHEESEBURGER)));
    public static final RegistryObject<Item> MARSHMALLOW_STICK = ITEMS.register("marshmallow_stick", () -> new ConsumableItem(new Item.Properties().food(ModFoods.MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final RegistryObject<Item> COOKED_MARSHMALLOW_STICK = ITEMS.register("cooked_marshmallow_stick", () -> new ConsumableItem(new Item.Properties().food(ModFoods.COOKED_MARSHMALLOW_STICK).stacksTo(16).craftRemainder(Items.STICK), true));
    public static final RegistryObject<Item> SMORE = ITEMS.register("smore", () -> new Item(new Item.Properties().food(ModFoods.SMORE)));
    public static final RegistryObject<Item> PAELLA_BOWL = ITEMS.register("paella_bowl", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PAELLA_BOWL).stacksTo(16).craftRemainder(Items.BOWL), true));
    public static final RegistryObject<Item> PIZZA_SLICE = ITEMS.register("pizza_slice", () -> new PizzaSliceItem(pizzaProperties()));
    public static final RegistryObject<Item> PANETTONE_SLICE = ITEMS.register("panettone_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PANETTONE_SLICE), false, true));
    public static final RegistryObject<Item> MUSHROOM_QUICHE_SLICE = ITEMS.register("mushroom_quiche_slice", () -> new Item(new Item.Properties().food(ModFoods.MUSHROOM_QUICHE_SLICE)));
    public static final RegistryObject<Item> LIME_PIE_SLICE = ITEMS.register("lime_pie_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.LIME_PIE_SLICE)));
    public static final RegistryObject<Item> POMEGRANATE_CAKE_SLICE = ITEMS.register("pomegranate_cake_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.POMEGRANATE_CAKE_SLICE)));
    public static final RegistryObject<Item> DRAGON_FRUIT_CAKE_SLICE = ITEMS.register("dragon_fruit_cake_slice", () -> new ConsumableItem(new Item.Properties().food(ModFoods.DRAGON_FRUIT_CAKE_SLICE)));
    public static final RegistryObject<Item> LIME_ICE_CREAM = ITEMS.register("lime_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ModFoods.LIME_ICE_CREAM)));
    public static final RegistryObject<Item> SUNNY_ICE_CREAM = ITEMS.register("sunny_ice_cream", () -> new IceCreamItem(new Item.Properties().food(ModFoods.SUNNY_ICE_CREAM)));
    public static final RegistryObject<Item> LIME_MILKSHAKE = ITEMS.register("lime_milkshake", () -> new DrinkableItem(new Item.Properties().food(ModFoods.LIME_MILKSHAKE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> DRAGON_FRUIT_MILKSHAKE = ITEMS.register("dragon_fruit_milkshake", () -> new DrinkableItem(new Item.Properties().food(ModFoods.DRAGON_FRUIT_MILKSHAKE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> POMEGRANATE_SMOOTHIE = ITEMS.register("pomegranate_smoothie", () -> new DrinkableItem(new Item.Properties().food(ModFoods.POMEGRANATE_SMOOTHIE).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> BERRY_LIMEADE = ITEMS.register("berry_limeade", () -> new ConsumableItem((drinkItem()).food(ModFoods.BERRY_LIMEADE), true, false));
    public static final RegistryObject<Item> PINK_LIMEADE = ITEMS.register("pink_limeade", () -> new ConsumableItem((drinkItem()).food(ModFoods.PINK_LIMEADE), true, false));
    public static final RegistryObject<Item> DRAGONS_PASSION = ITEMS.register("dragons_passion", () -> new ConsumableItem((drinkItem()).food(ModFoods.DRAGONS_PASSION), true, false));
    public static final RegistryObject<Item> CLAM_MEATBALL_STEW = ITEMS.register("clam_meatball_stew", () -> new ConsumableItem(bowlFoodItem(ModFoods.CLAM_MEATBALL_STEW)));
    public static final RegistryObject<Item> CLAM_MEATBALL_STEW_CUP = ITEMS.register("clam_meatball_stew_cup", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CLAM_MEATBALL_STEW_CUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> PRAWN_STEW = ITEMS.register("prawn_stew", () -> new ConsumableItem(bowlFoodItem(ModFoods.PRAWN_STEW)));
    public static final RegistryObject<Item> PRAWN_STEW_CUP = ITEMS.register("prawn_stew_cup", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PRAWN_STEW_CUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> PLATINUM_BASS_STEW = ITEMS.register("platinum_bass_stew", () -> new ConsumableItem(bowlFoodItem(ModFoods.PLATINUM_BASS_STEW)));
    public static final RegistryObject<Item> PLATINUM_BASS_STEW_CUP = ITEMS.register("platinum_bass_stew_cup", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PLATINUM_BASS_STEW_CUP).stacksTo(16).craftRemainder(Items.BOWL), true, false));
    public static final RegistryObject<Item> POMEGRANATE_CHICKEN = ITEMS.register("pomegranate_chicken", () -> new ConsumableItem(bowlFoodItem(ModFoods.POMEGRANATE_CHICKEN), true, false));
    public static final RegistryObject<Item> DELUXE_SALAD = ITEMS.register("deluxe_salad", () -> new ConsumableItem(bowlFoodItem(ModFoods.DELUXE_SALAD), true, false));
    public static final RegistryObject<Item> TROPICAL_SHAVED_ICE = ITEMS.register("tropical_shaved_ice", () -> new ConsumableItem(bowlFoodItem(ModFoods.TROPICAL_SHAVED_ICE), true, false));
    public static final RegistryObject<Item> PINK_NOODLES = ITEMS.register("pink_noodles", () -> new ConsumableItem(bowlFoodItem(ModFoods.PINK_NOODLES), true, false));
    public static final RegistryObject<Item> LIME_POPSICLE = ITEMS.register("lime_popsicle", () -> new ConsumableItem(new Item.Properties().food(ModFoods.LIME_POPSICLE).craftRemainder(Items.STICK), true, false));
    public static final RegistryObject<Item> MEDITERRANEAN_SALMON = ITEMS.register("mediterranean_salmon", () -> new ConsumableItem( bowlFoodItem(ModFoods.MEDITERRANEAN_SALMON), true, false));
    public static final RegistryObject<Item> SALMON_TARTARE = ITEMS.register("salmon_tartare", () -> new ConsumableItem(bowlFoodItem(ModFoods.SALMON_TARTARE), true, false));
    public static final RegistryObject<Item> COD_CEVICHE = ITEMS.register("cod_ceviche", () -> new ConsumableItem(bowlFoodItem(ModFoods.COD_CEVICHE), true, false));
    public static final RegistryObject<Item> CARBONARA_PASTA = ITEMS.register("carbonara_pasta", () -> new ConsumableItem(bowlFoodItem(ModFoods.CARBONARA_PASTA), true, false));
    public static final RegistryObject<Item> CLAM_ROLL = ITEMS.register("clam_roll", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CLAM_ROLL)));
    public static final RegistryObject<Item> SEA_WRAP = ITEMS.register("sea_wrap", () -> new ConsumableItem(new Item.Properties().food(ModFoods.SEA_WRAP), true, false));
    public static final RegistryObject<Item> SALMON_WRAPPED_PRAWN = ITEMS.register("salmon_wrapped_prawn", () -> new ConsumableItem(bowlFoodItem(ModFoods.SALMON_WRAPPED_PRAWN), false, false));
    public static final RegistryObject<Item> PRAWN_ROLL = ITEMS.register("prawn_roll", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PRAWN_ROLL)));
    public static final RegistryObject<Item> FISH_MIX = ITEMS.register("fish_mix", () -> new ConsumableItem(bowlFoodItem(ModFoods.FISH_MIX), false, false));
    public static final RegistryObject<Item> CRAB_MISO = ITEMS.register("crab_miso", () -> new ConsumableItem(bowlFoodItem(ModFoods.CRAB_MISO), false, false));
    public static final RegistryObject<Item> CRAB_NOODLES = ITEMS.register("crab_noodles", () -> new ConsumableItem(bowlFoodItem(ModFoods.CRAB_NOODLES), true, false));
    public static final RegistryObject<Item> BUTTERED_LEGS = ITEMS.register("buttered_legs", () -> new ConsumableItem(bowlFoodItem(ModFoods.BUTTERED_LEGS), false, false));
    public static final RegistryObject<Item> BIG_RICE_BALL = ITEMS.register("big_rice_ball", () -> new ConsumableItem(new Item.Properties().food(ModFoods.BIG_RICE_BALL)));
    public static final RegistryObject<Item> STRAWBERRY_JAM_BUN = ITEMS.register("strawberry_jam_bun", () -> new ConsumableItem(new Item.Properties().food(ModFoods.STRAWBERRY_JAM_BUN), true, false));
    public static final RegistryObject<Item> COCONUT_PUDDING = ITEMS.register("coconut_pudding", () -> new ConsumableItem(foodItem(ModFoods.COCONUT_PUDDING).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> SURF_AND_TURF = ITEMS.register("surf_and_turf", () -> new ConsumableItem(foodItem(ModFoods.SURF_AND_TURF), true));
    public static final RegistryObject<Item> CLAM_BAKE = ITEMS.register("clam_bake", () -> new ConsumableItem(foodItem(ModFoods.CLAM_BAKE), true));
    public static final RegistryObject<Item> STUFFED_NAUTILUS_SHELL = ITEMS.register("stuffed_nautilus_shell", () -> new ConsumableItem(foodItem(ModFoods.STUFFED_NAUTILUS_SHELL).craftRemainder(Items.NAUTILUS_SHELL), true));
    public static final RegistryObject<Item> BISQUE = ITEMS.register("bisque", () -> new ConsumableItem(bowlFoodItem(ModFoods.BISQUE), true));
    public static final RegistryObject<Item> SHRIMP_FRIED_RICE = ITEMS.register("shrimp_fried_rice", () -> new ConsumableItem(bowlFoodItem(ModFoods.SHRIMP_FRIED_RICE), true));
    public static final RegistryObject<Item> LOBSTER_PASTA = ITEMS.register("lobster_pasta", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.LOBSTER_PASTA)));
    public static final RegistryObject<Item> CRAB_BARS = ITEMS.register("crab_bars", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CRAB_BARS)));
    public static final RegistryObject<Item> COOKED_WHOLE_CRAB = ITEMS.register("cooked_whole_crab", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.COOKED_WHOLE_CRAB)));
    public static final RegistryObject<Item> MISO_WITH_BAMBOO_SPROUTS = ITEMS.register("miso_with_bamboo_sprouts", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.MISO_WITH_BAMBOO_SPROUTS)));
    public static final RegistryObject<Item> GREEN_TEA = ITEMS.register("green_tea", () -> new DrinkableItem(new Item.Properties().food(ModFoods.GREEN_TEA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> YELLOW_TEA = ITEMS.register("yellow_tea", () -> new DrinkableItem(new Item.Properties().food(ModFoods.YELLOW_TEA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> BLACK_TEA = ITEMS.register("black_tea", () -> new DrinkableItem(new Item.Properties().food(ModFoods.BLACK_TEA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> DANDELION_TEA = ITEMS.register("dandelion_tea", () -> new DrinkableItem(new Item.Properties().food(ModFoods.DANDELION_TEA).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16), true, false));
    public static final RegistryObject<Item> OATMEAL_WITH_STRAWBERRIES = ITEMS.register("oatmeal_with_strawberries", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.OATMEAL_WITH_STRAWBERRIES)));
    public static final RegistryObject<Item> COOKED_SALMON = ITEMS.register("cooked_salmon", () -> new BowlFoodItem(new Item.Properties().stacksTo(16).food(ModFoods.COOKED_SALMON)));
    public static final RegistryObject<Item> COFFEE = ITEMS.register("coffee", () -> new DrinkableItem(new Item.Properties().stacksTo(16).food(ModFoods.COFFEE).craftRemainder(Items.GLASS_BOTTLE), true));
    public static final RegistryObject<Item> MILK_COFFEE = ITEMS.register("milk_coffee", () -> new MilkCoffeeItem(new Item.Properties().stacksTo(16).food(ModFoods.MILK_COFFEE).craftRemainder(Items.GLASS_BOTTLE)));
    public static final RegistryObject<Item> CHERRY_BLOSSOM_CHEESECAKE_SLICE = ITEMS.register("cherry_blossom_cheesecake_slice", () -> new Item(new Item.Properties().food(vectorwing.farmersdelight.common.FoodValues.PIE_SLICE)));
    public static final RegistryObject<Item> PANCAKE = ITEMS.register("pancake", () -> new ConsumableItem(new Item.Properties().food(ModFoods.PANCAKE)));
    public static final RegistryObject<Item> CHOCOLATE_PANCAKE = ITEMS.register("chocolate_pancake", () -> new ConsumableItem(new Item.Properties().food(ModFoods.CHOCOLATE_PANCAKE), true));
    public static final RegistryObject<Item> FISH_AND_CHIPS = ITEMS.register("fish_and_chips", () -> new ConsumableItem(new Item.Properties().food(ModFoods.FISH_AND_CHIPS).craftRemainder(Items.BOWL), false));
    public static final RegistryObject<Item> POTATO_CHIP = ITEMS.register("potato_chip", () -> new ConsumableItem(new Item.Properties().food(ModFoods.POTATO_CHIP)));
    public static final RegistryObject<Item> SPRING_ROLL = ITEMS.register("spring_roll", () -> new ConsumableItem(new Item.Properties().food(ModFoods.SPRING_ROLL)));
    public static final RegistryObject<Item> FRIED_DUMPLING = ITEMS.register("fried_dumpling", () -> new ConsumableItem(new Item.Properties().food(ModFoods.FRIED_DUMPLING)));
    public static final RegistryObject<Item> BOWL_OF_FRIED_DUMPLING = ITEMS.register("bowl_of_fried_dumpling", () -> new ConsumableItem(new Item.Properties().food(ModFoods.BOWL_OF_FRIED_DUMPLING).craftRemainder(Items.BOWL)));
    public static final RegistryObject<Item> CRAB_BUTTER = ITEMS.register("crab_butter", () -> new Item(new Item.Properties().food(ModFoods.CRAB_BUTTER)));
    public static final RegistryObject<Item> SPICY_CRAYFISH = ITEMS.register("spicy_crayfish", () -> new Item(new Item.Properties().food(ModFoods.SPICY_CRAYFISH)));
    public static final RegistryObject<Item> CRAB_CAKE = ITEMS.register("crab_cake", () -> new BowlFoodItem(new Item.Properties().food(ModFoods.CRAB_CAKE)));
    public static final RegistryObject<Item> MARINATED_CRAB = ITEMS.register("marinated_crab", () -> new Item(new Item.Properties().food(ModFoods.MARINATED_CRAB)));


    //Tools
    public static final RegistryObject<Item> ROLLING_PIN = ITEMS.register("rolling_pin", () -> new Item(pizzaProperties().stacksTo(1).durability(60)));
    public static final RegistryObject<Item> PIZZA_PEEL = ITEMS.register("pizza_peel", () -> new PizzaPeelItem(Tiers.IRON, 1.5F, -3.0F, pizzaProperties().stacksTo(1)));
    public static final RegistryObject<Item> BUCKET_OF_CRAB_CHUM = ITEMS.register("bucket_of_crab_chum", () -> new ChumItem(basicItem())); // TODO: Replace for the source function if checks are not by instance
    public static final RegistryObject<Item> BUCKET_OF_LOBSTER_CHUM = ITEMS.register("bucket_of_lobster_chum", () -> new ChumItem(basicItem()));
    public static final RegistryObject<Item> BUCKET_OF_CLAM_CHUM = ITEMS.register("bucket_of_clam_chum", () -> new ChumItem(basicItem()));
    public static final RegistryObject<Item> BUCKET_OF_SHRIMP_CHUM = ITEMS.register("bucket_of_shrimp_chum", () -> new ChumItem(basicItem()));
    public static final RegistryObject<Item> CAT_FOOD = ITEMS.register("cat_food", () -> new Item(basicItem()));
    public static final RegistryObject<Item> DOG_FOOD = ITEMS.register("dog_food", () -> new DogFoodItem(new Item.Properties()));
    public static final RegistryObject<Item> SHARK_TOOTH_ARROW = ITEMS.register("shark_tooth_arrow", () -> new ItemModArrow(new Item.Properties()));


    // Farmer's Respite Drinks #TODO
//    public static final RegistryObject<Item> LIME_GREEN_TEA = ITEMS.register("lime_green_tea",
//            drinkItem().food(ModFoods.LIME_GREEN_TEA), true, false, Modid.FR);
//    public static final RegistryObject<Item> POMEGRANATE_BLACK_TEA = ITEMS.register("pomegranate_black_tea",
//            drinkItem().food(ModFoods.POMEGRANATE_BLACK_TEA), true, false, Modid.FR);
//    public static final RegistryObject<Item> VERNAL_PURGE = ITEMS.register("vernal_purge", () ->
//            new VernalPurgeItem(drinkItem().food(ModFoods.VERNAL_PURGE), true, true, Modid.FR));
//    public static final RegistryObject<Item> STRONG_VERNAL_PURGE = ITEMS.register("strong_vernal_purge", () ->
//            new VernalPurgeItem(drinkItem().food(ModFoods.STRONG_VERNAL_PURGE), true, true, Modid.FR));
//    public static final RegistryObject<Item> LIMBO_BREW = ITEMS.register("limbo_brew", () ->
//            new LimboBrewItem(drinkItem().food(ModFoods.LIMBO_BREW), true, true, 600, Modid.FR));
//    public static final RegistryObject<Item> LONG_LIMBO_BREW = ITEMS.register("long_limbo_brew", () ->
//            new LimboBrewItem(drinkItem(), false, true, 300, Modid.FR));
//    public static final RegistryObject<Item> STRONG_LIMBO_BREW = ITEMS.register("strong_limbo_brew", () ->
//            new LimboBrewItem(drinkItem().food(ModFoods.STRONG_LIMBO_BREW), true, true, 1200, Modid.FR));
//    public static final RegistryObject<Item> SWEET_RECOVERY = ITEMS.register("sweet_recovery",
//            drinkItem().food(ModFoods.SWEET_RECOVERY), true, false, Modid.FR);
//    public static final RegistryObject<Item> LONG_SWEET_RECOVERY = ITEMS.register("long_sweet_recovery",
//            drinkItem().food(ModFoods.LONG_SWEET_RECOVERY), true, false, Modid.FR);
//    public static final RegistryObject<Item> STRONG_SWEET_RECOVERY = ITEMS.register("strong_sweet_recovery",
//            drinkItem().food(ModFoods.STRONG_SWEET_RECOVERY), true, false, Modid.FR);


    public static final RegistryObject<Item> TIGER_PRAWN_SPAWN_EGG = ITEMS.register("tiger_prawn_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.TIGER_PRAWN, 0x091442, 0x7B8698, new Item.Properties()));
    public static final RegistryObject<Item> PLATINUM_BASS_SPAWN_EGG = ITEMS.register("platinum_bass_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.PLATINUM_BASS, 0x091442, 0x7B8698, new Item.Properties()));
    public static final RegistryObject<Item> CHIEFTAIN_CRAB_SPAWN_EGG = ITEMS.register("chieftain_crab_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CHIEFTAIN_CRAB, 0xB13125, 0xE1B865, new Item.Properties()));
    public static final RegistryObject<Item> URCHIN_SPAWN_EGG = ITEMS.register("urchin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.URCHIN, 0x9990d7, 0x21132d, new Item.Properties()));
    public static final RegistryObject<Item> CLAM_SPAWN_EGG = ITEMS.register("clam_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CLAM, 0x775745, 0xC5A877, new Item.Properties()));
    public static final RegistryObject<Item> FIDDLER_CRAB_SPAWN_EGG = ITEMS.register("fiddler_crab_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.FIDDLER_CRAB, 0x2f437c, 0xf48b45, new Item.Properties()));
    public static final RegistryObject<Item> DUMBO_OCTOPUS_SPAWN_EGG = ITEMS.register("dumbo_octopus_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.DUMBO_OCTOPUS, 0xFCDC4C, 0x162630, new Item.Properties()));
    public static final RegistryObject<Item> KOI_FISH_SPAWN_EGG = ITEMS.register("koi_fish_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.KOI_FISH, 0xF3ECED, 0xFB5321, new Item.Properties()));
    public static final RegistryObject<Item> LOBSTER_SPAWN_EGG = ITEMS.register("lobster_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.LOBSTER, 0XC43123,0XDD5F38, new Item.Properties()));
    public static final RegistryObject<Item> CATFISH_SPAWN_EGG = ITEMS.register("catfish_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CATFISH, 0X807757, 0X8A7466, new Item.Properties()));
    public static final RegistryObject<Item> GIANT_SQUID_SPAWN_EGG = ITEMS.register("giant_squid_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.GIANT_SQUID, 0XAB4B4D, 0XD67D6B, new Item.Properties()));
    public static final RegistryObject<Item> COMB_JELLY_SPAWN_EGG = ITEMS.register("comb_jelly_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.COMB_JELLY, 0XCFE9FE, 0X6EFF8B, new Item.Properties()));
    public static final RegistryObject<Item> MIMIC_OCTOPUS_SPAWN_EGG = ITEMS.register("mimic_octopus_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.MIMIC_OCTOPUS, 0XFFEBDC,0X1D1C1F, new Item.Properties()));
    public static final RegistryObject<Item> SEAGULL_SPAWN_EGG = ITEMS.register("seagull_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SEAGULL, 0XC9D2DC,0XFFD850, new Item.Properties()));
    public static final RegistryObject<Item> HUMMINGBIRD_SPAWN_EGG = ITEMS.register("hummingbird_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.HUMMINGBIRD, 0X325E7F,0X44A75F, new Item.Properties()));
    public static final RegistryObject<Item> HAMMERHEAD_SHARK_SPAWN_EGG = ITEMS.register("hammerhead_shark_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.HAMMERHEAD_SHARK, 0X8A92B5,0XB9BED8, new Item.Properties()));
    public static final RegistryObject<Item> CROW_SPAWN_EGG = ITEMS.register("crow_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CROW, 0X0D111C,0X1C2030, new Item.Properties()));
    public static final RegistryObject<Item> MANTIS_SHRIMP_SPAWN_EGG = ITEMS.register("mantis_shrimp_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.MANTIS_SHRIMP, 0XDB4858,0X15991E, new Item.Properties()));
    public static final RegistryObject<Item> CACHALOT_WHALE_SPAWN_EGG = ITEMS.register("cachalot_whale_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CACHALOT_WHALE, 0X949899,0X5F666E, new Item.Properties()));
    public static final RegistryObject<Item> TERRAPIN_SPAWN_EGG = ITEMS.register("terrapin_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.TERRAPIN, 0X6E6E30, 0X929647, new Item.Properties()));
    public static final RegistryObject<Item> FLYING_FISH_SPAWN_EGG = ITEMS.register("flying_fish_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.FLYING_FISH, 0X7BBCED, 0X6881B3, new Item.Properties()));
    public static final RegistryObject<Item> SHIBA_SPAWN_EGG = ITEMS.register("shiba_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SHIBA, 0xa86741, 0xe8d5b6, new Item.Properties()));
    public static final RegistryObject<Item> CHESTER_SPAWN_EGG = ITEMS.register("chester_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CHESTER, 0xd48f43, 0x942020, new Item.Properties()));
    public static final RegistryObject<Item> GIANT_MUD_CRAB_SPAWN_EGG = ITEMS.register("giant_mud_crab_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.GIANT_MUD_CRAB,0x444722,0x5f2d2d,new Item.Properties()));
    public static final RegistryObject<Item> KING_CRAB_SPAWN_EGG = ITEMS.register("king_crab_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.KING_CRAB,0x40191b,0xf9f4e9,new Item.Properties()));
    public static final RegistryObject<Item> SAND_CRAB_SPAWN_EGG = ITEMS.register("sand_crab_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.SAND_CRAB,0xc6d2cb,0x291616,new Item.Properties()));
    public static final RegistryObject<Item> CRAYFISH_SPAWN_EGG = ITEMS.register("crayfish_spawn_egg", () -> new ForgeSpawnEggItem(ModEntities.CRAYFISH,0x671620,0x2e181b,new Item.Properties()));


//    public static final RegistryObject<Item> GIANT_MUD_CRAB_SPAWN_EGG = ITEMS.register("giant_mud_crab_spawn_egg",new ForgeSpawnEggItem(ModEntities.GIANT_MUD_CRAB,0x444722,0x5f2d2d, new Item.Properties()));
//    public static final RegistryObject<Item> KING_CRAB_SPAWN_EGG = ITEMS.register("king_crab_spawn_egg", new ForgeSpawnEggItem(ModEntities.KING_CRAB,0x40191b,0xf9f4e9, new Item.Properties()));
//    public static final RegistryObject<Item> SAND_CRAB_SPAWN_EGG = ITEMS.register("sand_crab_spawn_egg", new ForgeSpawnEggItem(ModEntities.SAND_CRAB,0xc6d2cb,0x291616, new Item.Properties()));
//    public static final RegistryObject<Item> LAND_CRAB_SPAWN_EGG = ITEMS.register("land_crab_spawn_egg", new ForgeSpawnEggItem(ModEntities.LAND_CRAB,0x3f5589,0xf3e8e9, new Item.Properties()));
//    public static final RegistryObject<Item> CLAWSTER_SPAWN_EGG = ITEMS.register("clawster_spawn_egg", new ForgeSpawnEggItem(ModEntities.CLAWSTER,0x9a4e26,0x583726, new Item.Properties()));
//    public static final RegistryObject<Item> LOBSTER_SPAWN_EGG = ITEMS.register("lobster_spawn_egg", new ForgeSpawnEggItem(ModEntities.LOBSTER,0x6d3307,0x3c030f, new Item.Properties()));
//    public static final RegistryObject<Item> CRAYFISH_SPAWN_EGG = ITEMS.register("crayfish_spawn_egg", new ForgeSpawnEggItem(ModEntities.CRAYFISH,0x671620,0x2e181b, new Item.Properties()));

    public static final RegistryObject<Item> TIGER_PRAWN_BUCKET = ITEMS.register("tiger_prawn_bucket",
            () -> new MobBucketItem(ModEntities.TIGER_PRAWN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> PLATINUM_BASS_BUCKET = ITEMS.register("platinum_bass_bucket",
            () -> new MobBucketItem(ModEntities.PLATINUM_BASS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> CHIEFTAIN_CRAB_BUCKET = ITEMS.register("chieftain_crab_bucket",
            () -> new MobBucketItem(ModEntities.CHIEFTAIN_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_AXOLOTL, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> URCHIN_BUCKET = ITEMS.register("urchin_bucket",
            () -> new MobBucketItem(ModEntities.URCHIN, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> CLAM_BUCKET = ITEMS.register("clam_bucket",
            () -> new MobBucketItem(ModEntities.CLAM, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_TADPOLE, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> FIDDLER_CRAB_BUCKET = ITEMS.register("fiddler_crab_bucket",
            () -> new MobBucketItem(ModEntities.FIDDLER_CRAB, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> DUMBO_OCTOPUS_BUCKET = ITEMS.register("dumbo_octopus_bucket",
            () -> new MobBucketItem(ModEntities.DUMBO_OCTOPUS, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> KOI_FISH_BUCKET = ITEMS.register("koi_fish_bucket",
            () -> new MobBucketItem(ModEntities.KOI_FISH, () -> Fluids.WATER, () -> SoundEvents.BUCKET_EMPTY_FISH, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> LOBSTER_BUCKET = ITEMS.register("lobster_bucket",
            () -> new ItemModFishBucket(ModEntities.LOBSTER, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> SMALL_CATFISH_BUCKET = ITEMS.register("small_catfish_bucket",
            () -> new ItemModFishBucket(ModEntities.CATFISH, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> MEDIUM_CATFISH_BUCKET = ITEMS.register("medium_catfish_bucket",
            () -> new ItemModFishBucket(ModEntities.CATFISH, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> LARGE_CATFISH_BUCKET = ITEMS.register("large_catfish_bucket",
            () -> new ItemModFishBucket(ModEntities.CATFISH, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> COMB_JELLY_BUCKET = ITEMS.register("comb_jelly_bucket",
            () -> new ItemModFishBucket(ModEntities.COMB_JELLY, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> MIMIC_OCTOPUS_BUCKET = ITEMS.register("mimic_octopus_bucket",
            () -> new ItemModFishBucket(ModEntities.MIMIC_OCTOPUS, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> TERRAPIN_BUCKET = ITEMS.register("terrapin_bucket",
            () -> new ItemModFishBucket(ModEntities.TERRAPIN, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> FLYING_FISH_BUCKET = ITEMS.register("flying_fish_bucket",
            () -> new ItemModFishBucket(ModEntities.FLYING_FISH, Fluids.WATER, new Item.Properties()));
    public static final RegistryObject<Item> GIANT_MUD_CRAB_BUCKET = ITEMS.register("giant_mud_crab_bucket",
            () -> new ItemModFishBucket(ModEntities.GIANT_MUD_CRAB, Fluids.WATER, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> KING_CRAB_BUCKET = ITEMS.register("king_crab_bucket",
            () -> new ItemModFishBucket(ModEntities.KING_CRAB, Fluids.WATER, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> SAND_CRAB_BUCKET = ITEMS.register("sand_crab_bucket",
            () -> new ItemModFishBucket(ModEntities.SAND_CRAB, Fluids.WATER, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));
    public static final RegistryObject<Item> CRAYFISH_BUCKET = ITEMS.register("crayfish_bucket",
            () -> new ItemModFishBucket(ModEntities.CRAYFISH, Fluids.WATER, new Item.Properties().stacksTo(1).craftRemainder(Items.BUCKET)));

    public static final Map<Parrot.Variant, RegistryObject<Item>> PARROT_EGGS = Util.make(new EnumMap<>(Parrot.Variant.class), map -> {
        for (var variant : Parrot.Variant.values()) {
            map.put(variant, ITEMS.register("parrot_egg_" + variant.getSerializedName(), () -> new ParrotEggItem(variant)));
        }
    });
    public static final Map<FoodCategory, RegistryObject<Item>> FOOD_CATEGORY_ITEMS = Util.make(new EnumMap<>(FoodCategory.class), map -> {
        for (FoodCategory category : FoodCategory.values()) {
            map.put(category, ITEMS.register("food_category_" + category.name().toLowerCase(Locale.ROOT), CrockPotBaseItem::new));
        }
    });



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

    public static void initDispenser(){
        DispenseItemBehavior bucketDispenseBehavior = new DefaultDispenseItemBehavior() {
            private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

            public ItemStack execute(BlockSource blockSource, ItemStack stack) {
                DispensibleContainerItem dispensiblecontaineritem = (DispensibleContainerItem)stack.getItem();
                BlockPos blockpos = blockSource.getPos().relative(blockSource.getBlockState().getValue(DispenserBlock.FACING));
                Level level = blockSource.getLevel();
                if (dispensiblecontaineritem.emptyContents((Player)null, level, blockpos, (BlockHitResult)null)) {
                    dispensiblecontaineritem.checkExtraContent((Player)null, level, stack, blockpos);
                    return new ItemStack(Items.BUCKET);
                } else {
                    return this.defaultDispenseItemBehavior.dispense(blockSource, stack);
                }
            }
        };
        DispenserBlock.registerBehavior(LOBSTER_BUCKET.get(), bucketDispenseBehavior);
        DispenserBlock.registerBehavior(MIMIC_OCTOPUS_BUCKET.get(), bucketDispenseBehavior);
        DispenserBlock.registerBehavior(COMB_JELLY_BUCKET.get(), bucketDispenseBehavior);
        DispenserBlock.registerBehavior(SMALL_CATFISH_BUCKET.get(), bucketDispenseBehavior);
        DispenserBlock.registerBehavior(MEDIUM_CATFISH_BUCKET.get(), bucketDispenseBehavior);
        DispenserBlock.registerBehavior(LARGE_CATFISH_BUCKET.get(), bucketDispenseBehavior);
//        ComposterBlock.COMPOSTABLES.put(BANANA.get(), 0.65F);                                 TODO
//        ComposterBlock.COMPOSTABLES.put(ModItems.BANANA_PEEL.get().asItem(), 1F);
        ComposterBlock.COMPOSTABLES.put(ModItems.KING_CRAB.get(), 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.GIANT_MUD_CRAB.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(ModItems.CRAYFISH.get(), 0.2F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_KING_CRAB.get(), 0.6F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_GIANT_MUD_CRAB.get(), 0.5F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_CRAYFISH.get(), 0.2F);
        ComposterBlock.COMPOSTABLES.put(ModItems.CRAB_MEAT.get(), 0.1F);
        ComposterBlock.COMPOSTABLES.put(ModItems.COOKED_CRAB_MEAT.get(), 0.1F);
    }
}
