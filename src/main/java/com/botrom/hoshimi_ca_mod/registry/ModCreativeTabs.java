package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGREDIENTS_TAB = CREATIVE_MODE_TABS.register("hoshimi_ingredients_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("Hoshimi's Culinary Ingredients"))
                    .icon(ModItems.CORN.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        // Cultural Delight:
                        output.accept(ModItems.CUCUMBER_SEEDS.get());
                        output.accept(ModItems.CORN_KERNELS.get());
                        output.accept(ModItems.EGGPLANT_SEEDS.get());
                        output.accept(ModItems.AVOCADO_SEED.get());
                        output.accept(ModItems.AVOCADO.get());
                        output.accept(ModItems.CUT_AVOCADO.get());
                        output.accept(ModItems.CUCUMBER.get());
                        output.accept(ModItems.CUT_CUCUMBER.get());
                        output.accept(ModItems.PICKLE.get());
                        output.accept(ModItems.CUT_PICKLE.get());
                        output.accept(ModItems.EGGPLANT.get());
                        output.accept(ModItems.CUT_EGGPLANT.get());
                        output.accept(ModItems.TOMATO_SLICE.get());
                        output.accept(ModItems.SMOKED_TOMATO.get());
                        output.accept(ModItems.CORN.get());
                        output.accept(ModItems.SMOKED_CORN.get());
                        output.accept(ModItems.POPCORN.get());
                        output.accept(ModItems.CORN_DOUGH.get());
                        output.accept(ModItems.TORTILLA.get());
                        output.accept(ModItems.NACHOS.get());
                        output.accept(ModItems.ELOTE.get());
                        output.accept(ModItems.EMPANADA.get());
                        output.accept(ModItems.HEARTY_SALAD.get());
                        output.accept(ModItems.BEEF_BURRITO.get());
                        output.accept(ModItems.CHICKEN_TACO.get());
                        output.accept(ModItems.SPICY_CURRY.get());
                        output.accept(ModItems.PORK_WRAP.get());
                        output.accept(ModItems.FISH_TACO.get());
                        output.accept(ModItems.MIDORI_ROLL.get());
                        output.accept(ModItems.MIDORI_ROLL_SLICE.get());
                        output.accept(ModItems.EGG_ROLL.get());
                        output.accept(ModItems.TROPICAL_ROLL.get());
                        output.accept(ModItems.RICE_BALL.get());

                        output.accept(ModBlocks.WILD_CUCUMBERS.get());
                        output.accept(ModBlocks.WILD_CORN.get());
                        output.accept(ModBlocks.WILD_EGGPLANTS.get());
//                      output.accept(ModBlocks.AVOCADO_SEED);
                        output.accept(ModBlocks.CORN_COB_CRATE.get());
                        output.accept(ModBlocks.EXOTIC_ROLL_MEDLEY.get());

                        // More Delight:
                        output.accept(ModItems.CHOCOLATE_POPSICLE.get());
                        output.accept(ModItems.OMELETTE.get());
                        output.accept(ModItems.CREAMY_PASTA_WITH_HAM.get());
                        output.accept(ModItems.CREAMY_PASTA_WITH_CHICKEN_CUTS.get());
                        output.accept(ModItems.MASHED_POTATOES.get());
                        output.accept(ModItems.CHICKEN_SALAD.get());
                        output.accept(ModItems.BREAD_SLICE.get());
                        output.accept(ModItems.TOAST.get());
                        output.accept(ModItems.TOAST_WITH_SWEET_BERRIES.get());
                        output.accept(ModItems.TOAST_WITH_CHOCOLATE.get());

                        // Delightful
                        output.accept(ModItems.MATCHA.get());
                        output.accept(ModItems.MATCHA_ICE_CREAM.get());
                        output.accept(ModItems.MATCHA_MILKSHAKE.get());
                        output.accept(ModItems.MATCHA_LATTE.get());
                        output.accept(ModItems.ACORN.get());
                        output.accept(ModItems.ROASTED_ACORN.get());
                        output.accept(ModItems.CACTUS_FLESH.get());
                        output.accept(ModItems.CACTUS_STEAK.get());
                        output.accept(ModItems.CACTUS_CHILI.get());
                        output.accept(ModItems.CACTUS_SOUP.get());
                        output.accept(ModItems.JAM_JAR.get());
                        output.accept(ModItems.FIELD_SALAD.get());
                        output.accept(ModItems.CHEESEBURGER.get());
                        output.accept(ModItems.MARSHMALLOW_STICK.get());
                        output.accept(ModItems.COOKED_MARSHMALLOW_STICK.get());
                        output.accept(ModItems.SMORE.get());

                        // Oceanic Delight
                        output.accept(ModBlocks.PAELLA.get());
                        output.accept(ModItems.PAELLA_BOWL.get());

                        // PizzaCraft
                        output.accept(ModBlocks.PIZZA_STATION.get());
                        output.accept(ModBlocks.PIZZA_OVEN.get());
                        output.accept(ModBlocks.GRANITE_BASIN.get());
                        output.accept(ModBlocks.DIORITE_BASIN.get());
                        output.accept(ModBlocks.ANDESITE_BASIN.get());
                        output.accept(ModBlocks.BASALT_BASIN.get());
                        output.accept(ModBlocks.BLACKSTONE_BASIN.get());
                        output.accept(ModBlocks.PIZZA_DOUGH.get());
                        output.accept(ModBlocks.RAW_PIZZA.get());
                        output.accept(ModBlocks.PIZZA.get());
                        output.accept(ModItems.PIZZA_PEEL.get());
                        output.accept(ModItems.ROLLING_PIN.get());
                        output.accept(ModItems.PIZZA_SLICE.get());
                        output.accept(ModBlocks.CHEESE_BLOCK.get());
                        output.accept(ModItems.CHEESE.get());
                        output.accept(ModItems.PEPPER.get());
                        output.accept(ModItems.BROCCOLI.get());
                        output.accept(ModItems.PINEAPPLE.get());
                        output.accept(ModItems.OLIVE.get());
                        output.accept(ModItems.TOMATO_SLICE.get());
                        output.accept(ModItems.ONION_SLICE.get());
                        output.accept(ModItems.PEPPER_SLICE.get());
                        output.accept(ModItems.PINEAPPLE_SLICE.get());
                        output.accept(ModItems.MUSHROOM_SLICE.get());
                        output.accept(ModItems.CUT_HAM.get());
                        output.accept(ModItems.CHICKEN_WING.get());
                        output.accept(ModItems.COOKED_WING.get());
                        output.accept(ModItems.HOT_WING.get());
                        output.accept(ModItems.CORN_FLOUR.get());
                        output.accept(ModItems.TOMATO_SAUCE.get());
                        output.accept(ModItems.HOT_SAUCE.get());
                        output.accept(ModItems.OLIVE_OIL.get());
                        output.accept(ModItems.BROCCOLI_SEEDS.get());
                        output.accept(ModItems.PEPPER_SEEDS.get());
                        output.accept(ModItems.PINEAPPLE_SEEDS.get());

                        // Collector's Reap
                        output.accept(ModItems.POMEGRANATE.get());
                        output.accept(ModItems.POMEGRANATE_SLICE.get());
                        output.accept(ModItems.LIME.get());
                        output.accept(ModItems.LIME_SLICE.get());
                        output.accept(ModItems.DRAGON_FRUIT.get());
                        output.accept(ModItems.CREAM_CHEESE.get());
                        output.accept(ModItems.CLAM.get());
                        output.accept(ModItems.CLAM_MEAT.get());
                        output.accept(ModItems.TIGER_PRAWN.get());
                        output.accept(ModItems.COOKED_TIGER_PRAWN.get());
                        output.accept(ModItems.PLATINUM_BASS.get());
                        output.accept(ModItems.COOKED_PLATINUM_BASS.get());
                        output.accept(ModItems.PLATINUM_BASS_SLICE.get());
                        output.accept(ModItems.COOKED_PLATINUM_BASS_SLICE.get());
                        output.accept(ModItems.CHIEFTAIN_CRAB.get());
                        output.accept(ModItems.CHIEFTAIN_CLAW.get());
                        output.accept(ModItems.CHIEFTAIN_LEG.get());
                        output.accept(ModItems.CHIEFTAIN_CRAB_MEAT.get());
                        output.accept(ModItems.URCHIN.get());
                        output.accept(ModItems.UNI.get());
                        output.accept(ModItems.URCHIN_TEST.get());
                        output.accept(ModItems.URCHIN_NEEDLE.get());
                        output.accept(ModBlocks.PANETTONE.get());
                        output.accept(ModItems.PANETTONE_SLICE.get());
                        output.accept(ModBlocks.MUSHROOM_QUICHE.get());
                        output.accept(ModItems.MUSHROOM_QUICHE_SLICE.get());
                        output.accept(ModBlocks.LIME_PIE.get());
                        output.accept(ModItems.LIME_PIE_SLICE.get());
                        output.accept(ModBlocks.POMEGRANATE_CAKE.get());
                        output.accept(ModItems.POMEGRANATE_CAKE_SLICE.get());
                        output.accept(ModBlocks.DRAGON_FRUIT_CAKE.get());
                        output.accept(ModItems.DRAGON_FRUIT_CAKE_SLICE.get());
                        output.accept(ModItems.LIME_ICE_CREAM.get());
                        output.accept(ModItems.SUNNY_ICE_CREAM.get());
                        output.accept(ModItems.LIME_MILKSHAKE.get());
                        output.accept(ModItems.DRAGON_FRUIT_MILKSHAKE.get());
                        output.accept(ModItems.POMEGRANATE_SMOOTHIE.get());
                        output.accept(ModItems.BERRY_LIMEADE.get());
                        output.accept(ModItems.PINK_LIMEADE.get());
                        output.accept(ModItems.DRAGONS_PASSION.get());
                        output.accept(ModItems.CLAM_MEATBALL_STEW.get());
                        output.accept(ModItems.CLAM_MEATBALL_STEW_CUP.get());
                        output.accept(ModItems.PRAWN_STEW.get());
                        output.accept(ModItems.PRAWN_STEW_CUP.get());
                        output.accept(ModItems.PLATINUM_BASS_STEW.get());
                        output.accept(ModItems.PLATINUM_BASS_STEW_CUP.get());
                        output.accept(ModItems.POMEGRANATE_CHICKEN.get());
                        output.accept(ModItems.DELUXE_SALAD.get());
                        output.accept(ModItems.TROPICAL_SHAVED_ICE.get());
                        output.accept(ModItems.PINK_NOODLES.get());
                        output.accept(ModItems.LIME_POPSICLE.get());
                        output.accept(ModItems.MEDITERRANEAN_SALMON.get());
                        output.accept(ModItems.SALMON_TARTARE.get());
                        output.accept(ModItems.COD_CEVICHE.get());
                        output.accept(ModItems.CARBONARA_PASTA.get());
                        output.accept(ModItems.CLAM_ROLL.get());
                        output.accept(ModItems.SEA_WRAP.get());
                        output.accept(ModItems.SALMON_WRAPPED_PRAWN.get());
                        output.accept(ModItems.PRAWN_ROLL.get());
                        output.accept(ModItems.FISH_MIX.get());
                        output.accept(ModItems.CRAB_MISO.get());
                        output.accept(ModItems.CRAB_NOODLES.get());
                        output.accept(ModItems.BUTTERED_LEGS.get());
                        output.accept(ModItems.BIG_RICE_BALL.get());
                        output.accept(ModBlocks.LIME_BUSH.get());
                        output.accept(ModBlocks.DRAGON_BUSH.get());
                        output.accept(ModBlocks.BUDDING_DRAGON_FRUIT_CROP.get());
                        output.accept(ModItems.STRAWBERRY_JAM_BUN.get());
                        output.accept(ModItems.TIGER_PRAWN_SPAWN_EGG.get());
                        output.accept(ModItems.PLATINUM_BASS_SPAWN_EGG.get());
                        output.accept(ModItems.CHIEFTAIN_CRAB_SPAWN_EGG.get());
                        output.accept(ModItems.URCHIN_SPAWN_EGG.get());
                        output.accept(ModItems.CLAM_SPAWN_EGG.get());
                        output.accept(ModItems.TIGER_PRAWN_BUCKET.get());
                        output.accept(ModItems.PLATINUM_BASS_BUCKET.get());
                        output.accept(ModItems.CHIEFTAIN_CRAB_BUCKET.get());
                        output.accept(ModItems.URCHIN_BUCKET.get());
                        output.accept(ModItems.CLAM_BUCKET.get());

                        // Crabber's Delight
                        output.accept(ModItems.PEARL.get());
                        output.accept(ModItems.CAN.get());
                        output.accept(ModItems.FISH_BONES.get());
                        output.accept(ModBlocks.COCONUT.get());
                        output.accept(ModItems.COCONUT_HALF.get());
                        output.accept(ModItems.COCONUT_MILK.get());
                        output.accept(ModItems.RAW_FIDDLER_CRAB.get());
                        output.accept(ModItems.COOKED_FIDDLER_CRAB.get());
                        output.accept(ModItems.RAW_LOBSTER.get());
                        output.accept(ModItems.COOKED_LOBSTER.get());
                        output.accept(ModItems.RAW_SHRIMP.get());
                        output.accept(ModItems.COOKED_SHRIMP.get());
                        output.accept(ModItems.FIDDLER_CRAB_LEGS.get());
                        output.accept(ModItems.COCONUT_PUDDING.get());
                        output.accept(ModItems.SURF_AND_TURF.get());
                        output.accept(ModItems.CLAM_BAKE.get());
                        output.accept(ModItems.STUFFED_NAUTILUS_SHELL.get());
                        output.accept(ModItems.BISQUE.get());
                        output.accept(ModItems.SHRIMP_FRIED_RICE.get());
                        output.accept(ModItems.BUCKET_OF_CRAB_CHUM.get());
                        output.accept(ModItems.BUCKET_OF_LOBSTER_CHUM.get());
                        output.accept(ModItems.BUCKET_OF_CLAM_CHUM.get());
                        output.accept(ModItems.BUCKET_OF_SHRIMP_CHUM.get());
                        output.accept(ModItems.FIDDLER_CRAB_CLAW.get());
                        output.accept(ModItems.COOKED_CLAM_MEAT.get());
                        output.accept(ModItems.FIDDLER_CRAB_SPAWN_EGG.get());
                        output.accept(ModItems.FIDDLER_CRAB_BUCKET.get());
                        output.accept(ModItems.CLAM_BUCKET.get());
                        output.accept(ModBlocks.PALM_SAPLING.get());
                        output.accept(ModBlocks.PALM_LOG.get());
                        output.accept(ModBlocks.PALM_WOOD.get());
                        output.accept(ModBlocks.STRIPPED_PALM_LOG.get());
                        output.accept(ModBlocks.STRIPPED_PALM_WOOD.get());
                        output.accept(ModBlocks.PALM_LEAVES.get());
                        output.accept(ModBlocks.CRAB_TRAP.get());
                        output.accept(ModBlocks.SEASHELLS.get());

                        // Critters and Companions
                        output.accept(ModItems.DUMBO_OCTOPUS_SPAWN_EGG.get());
                        output.accept(ModItems.KOI_FISH_SPAWN_EGG.get());
                        output.accept(ModItems.DUMBO_OCTOPUS_BUCKET.get());
                        output.accept(ModItems.KOI_FISH_BUCKET.get());

                        // Alex's Mobs
                        output.accept(ModItems.LOBSTER_SPAWN_EGG.get());
                        output.accept(ModItems.CATFISH_SPAWN_EGG.get());
                        output.accept(ModItems.GIANT_SQUID_SPAWN_EGG.get());
                        output.accept(ModItems.COMB_JELLY_SPAWN_EGG.get());
                        output.accept(ModItems.MIMIC_OCTOPUS_SPAWN_EGG.get());
                        output.accept(ModItems.SEAGULL_SPAWN_EGG.get());
                        output.accept(ModItems.LOBSTER_BUCKET.get());
                        output.accept(ModItems.SMALL_CATFISH_BUCKET.get());
                        output.accept(ModItems.MEDIUM_CATFISH_BUCKET.get());
                        output.accept(ModItems.LARGE_CATFISH_BUCKET.get());
                        output.accept(ModItems.COMB_JELLY_BUCKET.get());
                        output.accept(ModItems.MIMIC_OCTOPUS_BUCKET.get());
                        output.accept(ModItems.LOBSTER_TAIL.get());
                        output.accept(ModItems.COOKED_LOBSTER_TAIL.get());
                        output.accept(ModItems.RAW_CATFISH.get());
                        output.accept(ModItems.COOKED_CATFISH.get());
                        output.accept(ModItems.RAINBOW_JELLY.get());
                        output.accept(ModBlocks.RAINBOW_GLASS.get());
                        output.accept(ModItems.RAW_CATFISH_SLICE.get());
                        output.accept(ModItems.COOKED_CATFISH_SLICE.get());
                        output.accept(ModItems.LOBSTER_PASTA.get());

                        // Quark
                        output.accept(ModItems.SHIBA_SPAWN_EGG.get());
                        output.accept(ModItems.CRAB_BARS.get());
                        output.accept(ModItems.COOKED_WHOLE_CRAB.get());
                        output.accept(ModItems.MISO_WITH_BAMBOO_SPROUTS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MEALS_TAB = CREATIVE_MODE_TABS.register("hoshimi_meals_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("Hoshimi's Culinary Meals"))
                    .icon(ModItems.CREAMY_PASTA_WITH_HAM.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        // Cultural Delight:
                        output.accept(ModItems.CUCUMBER_SEEDS.get());
                    })
                    .build());

//    public static ItemStack createIcon() {
//        ItemStack stack = ModItems.PIZZA_SLICE.get().getDefaultInstance();
//        ItemStackHandler handler = new ItemStackHandler(6);
//        handler.setStackInSlot(0, ModItems.CHEESE.get().getDefaultInstance());
//        //handler.setStackInSlot(1, ModItems.PEPPER_SLICE.get().getDefaultInstance());
//        //handler.setStackInSlot(2, ModItems.WING.get().getDefaultInstance());
//        //handler.setStackInSlot(3, ModItems.BROCCOLI.get().getDefaultInstance());
//        //handler.setStackInSlot(4, ModItems.ONION_SLICE.get().getDefaultInstance());
//        //handler.setStackInSlot(5, ModItems.TOMATO_SLICE.get().getDefaultInstance());
//        NBTUtils.saveInventoryToStack(stack, handler);
//        return stack;
//    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
