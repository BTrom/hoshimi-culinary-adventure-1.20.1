package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
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
                        output.accept(ModItems.SHIMA_ENAGA_SPAWN_EGG.get());

                        // Alex's Mobs
                        output.accept(ModItems.LOBSTER_SPAWN_EGG.get());
                        output.accept(ModItems.CATFISH_SPAWN_EGG.get());
                        output.accept(ModItems.GIANT_SQUID_SPAWN_EGG.get());
                        output.accept(ModItems.COMB_JELLY_SPAWN_EGG.get());
                        output.accept(ModItems.MIMIC_OCTOPUS_SPAWN_EGG.get());
                        output.accept(ModItems.SEAGULL_SPAWN_EGG.get());
                        output.accept(ModItems.HUMMINGBIRD_SPAWN_EGG.get());
                        output.accept(ModItems.HAMMERHEAD_SHARK_SPAWN_EGG.get());
                        output.accept(ModItems.CROW_SPAWN_EGG.get());
                        output.accept(ModItems.MANTIS_SHRIMP_SPAWN_EGG.get());
                        output.accept(ModItems.CACHALOT_WHALE_SPAWN_EGG.get());
                        output.accept(ModItems.TERRAPIN_SPAWN_EGG.get());
                        output.accept(ModItems.FLYING_FISH_SPAWN_EGG.get());
                        output.accept(ModItems.LOBSTER_BUCKET.get());
                        output.accept(ModItems.SMALL_CATFISH_BUCKET.get());
                        output.accept(ModItems.MEDIUM_CATFISH_BUCKET.get());
                        output.accept(ModItems.LARGE_CATFISH_BUCKET.get());
                        output.accept(ModItems.TERRAPIN_BUCKET.get());
                        output.accept(ModItems.FLYING_FISH_BUCKET.get());
                        output.accept(ModItems.COMB_JELLY_BUCKET.get());
                        output.accept(ModItems.MIMIC_OCTOPUS_BUCKET.get());
                        output.accept(ModItems.LOBSTER_TAIL.get());
                        output.accept(ModItems.COOKED_LOBSTER_TAIL.get());
                        output.accept(ModItems.RAW_CATFISH.get());
                        output.accept(ModItems.COOKED_CATFISH.get());
                        output.accept(ModItems.CACHALOT_WHALE_TOOTH.get());
                        output.accept(ModItems.AMBERGRIS.get());
                        output.accept(ModItems.ECHOLOCATOR.get());
                        output.accept(ModItems.ENDOLOCATOR.get());
                        output.accept(ModItems.SHARK_TOOTH.get());
                        output.accept(ModItems.SHARK_TOOTH_ARROW.get());
                        output.accept(ModItems.RAINBOW_JELLY.get());
                        output.accept(ModBlocks.HUMMINGBIRD_FEEDER.get());
                        output.accept(ModBlocks.TERRAPIN_EGG.get());
                        output.accept(ModBlocks.RAINBOW_GLASS.get());
                        output.accept(ModItems.RAW_CATFISH_SLICE.get());
                        output.accept(ModItems.COOKED_CATFISH_SLICE.get());
                        output.accept(ModItems.LOBSTER_PASTA.get());

                        // Quark
                        output.accept(ModItems.SHIBA_SPAWN_EGG.get());
                        output.accept(ModItems.CRAB_BARS.get());
                        output.accept(ModItems.COOKED_WHOLE_CRAB.get());
                        output.accept(ModItems.MISO_WITH_BAMBOO_SPROUTS.get());

                        // Untamed Wilds
                        output.accept(ModItems.BALEEN_WHALE_SPAWN_EGG.get());
                        output.accept(ModBlocks.ANEMONE_ROSE_BULB.get());
                        output.accept(ModBlocks.ANEMONE_SAND.get());
                        output.accept(ModBlocks.ANEMONE_SEBAE.get());

                        // HarvestCraft 2
                        output.accept(ModItems.GREEN_ONION_SEEDS.get());
                        output.accept(ModItems.GREEN_ONION.get());

                        // Farmer's Respite
                        output.accept(ModItems.TEA_SEEDS.get());
                        output.accept(ModItems.GREEN_TEA_LEAVES.get());
                        output.accept(ModItems.YELLOW_TEA_LEAVES.get());
                        output.accept(ModItems.BLACK_TEA_LEAVES.get());
                        output.accept(ModItems.GREEN_TEA.get());
                        output.accept(ModItems.YELLOW_TEA.get());
                        output.accept(ModItems.BLACK_TEA.get());
                        output.accept(ModItems.DANDELION_TEA.get());
                        output.accept(ModBlocks.WILD_TEA_BUSH.get());
                        output.accept(ModBlocks.COFFEE_BEANS_SACK.get());

                        // Farm & Charm
                        output.accept(ModItems.OAT_SEEDS.get());
                        output.accept(ModItems.STRAWBERRY_SEEDS.get());
                        output.accept(ModItems.OATMEAL_WITH_STRAWBERRIES.get());
                        output.accept(ModItems.COOKED_SALMON.get());
                        output.accept(ModBlocks.FARMERS_BREAKFAST.get());
                        output.accept(ModBlocks.OAT_PANCAKE_BLOCK.get());
                        output.accept(ModBlocks.POTATO_WITH_ROAST_MEAT.get());
                        output.accept(ModBlocks.ROASTED_CORN_BLOCK.get());
                        output.accept(ModBlocks.FARMERS_BREAD.get());
                        output.accept(ModItems.CAT_FOOD.get());
                        output.accept(ModItems.DOG_FOOD.get());
                        output.accept(ModBlocks.PET_BOWL.get());
                        output.accept(ModBlocks.FEEDING_TROUGH.get());
                        output.accept(ModBlocks.CHICKEN_NEST.get());
                        output.accept(ModBlocks.STOVE.get());
                        output.accept(ModBlocks.WILD_STRAWBERRIES.get());
                        output.accept(ModBlocks.WILD_CORN.get());
                        output.accept(ModBlocks.CAT_FOOD_BAG.get());
                        output.accept(ModBlocks.DOG_FOOD_BAG.get());

                        // Rustic Delight
                        output.accept(ModBlocks.COTTON_BOLL_CRATE.get());
                        output.accept(ModItems.COTTON_SEEDS.get());
                        output.accept(ModItems.COFFEE_BEANS.get());
                        output.accept(ModItems.COFFEE.get());
                        output.accept(ModItems.MILK_COFFEE.get());
                        output.accept(ModItems.COTTON_BOLL.get());
                        output.accept(ModBlocks.CHERRY_BLOSSOM_CHEESECAKE.get());
                        output.accept(ModBlocks.CHOCOLATE_PANCAKES.get());
                        output.accept(ModBlocks.PANCAKES.get());
                        output.accept(ModBlocks.WILD_COFFEE.get());
                        output.accept(ModBlocks.WILD_COTTON.get());

                        // Casualness Delight
                        output.accept(ModBlocks.DEEP_FRYING_PAN.get());
                        output.accept(ModItems.POTATO_SLICE.get());
                        output.accept(ModItems.POTATO_CHIP.get());
                        output.accept(ModItems.FISH_AND_CHIPS.get());
                        output.accept(ModItems.RAW_SPRING_ROLL.get());
                        output.accept(ModItems.SPRING_ROLL.get());
                        output.accept(ModBlocks.SPRING_ROLL_MEDLEY.get());
                        output.accept(ModItems.TONKATSU.get());
                        output.accept(ModItems.RAW_FRIED_DUMPLING.get());
                        output.accept(ModItems.FRIED_DUMPLING.get());
                        output.accept(ModBlocks.PLATE_OF_FRIED_DUMPLING.get());
                        output.accept(ModItems.BOWL_OF_FRIED_DUMPLING.get());

                        // Crockpot
                        output.accept(ModBlocks.CROCK_POT.get());
                        output.accept(ModBlocks.PORTABLE_CROCK_POT.get());
                        output.accept(ModBlocks.BIRDCAGE.get());
                        output.accept(ModItems.ASPARAGUS.get());
                        output.accept(ModItems.GARLIC.get());
                        output.accept(ModItems.CHILI_PEPPER.get());
                        output.accept(ModItems.ASPARAGUS_SEEDS.get());
                        output.accept(ModItems.GARLIC_SEEDS.get());
                        output.accept(ModItems.UNKNOWN_SEEDS.get());
                        ModItems.PARROT_EGGS.values().forEach(item -> {output.accept(item.get());});
                        output.accept(ModItems.CROCK_POT_UPGRADE_SMITHING_TEMPLATE.get());
                        output.accept(ModItems.HOGLIN_NOSE.get());
                        output.accept(ModItems.COOKED_HOGLIN_NOSE.get());
                        output.accept(ModItems.SYRUP.get());
                        output.accept(ModItems.NETHEROSIA.get());
                        output.accept(ModBlocks.BACON_EGGS.get());
                        output.accept(ModBlocks.BONE_SOUP.get());
                        output.accept(ModBlocks.BONE_STEW.get());
                        output.accept(ModBlocks.BREAKFAST_SKILLET.get());
                        output.accept(ModBlocks.BUNNY_STEW.get());
                        output.accept(ModBlocks.CALIFORNIA_ROLL.get());
                        output.accept(ModBlocks.CEVICHE.get());
                        output.accept(ModBlocks.GLOW_BERRY_MOUSSE.get());
                        output.accept(ModBlocks.HONEY_NUGGETS.get());
                        output.accept(ModBlocks.HOT_CHILI.get());
                        output.accept(ModBlocks.ICED_TEA.get());
                        output.accept(ModBlocks.JAMMY_PRESERVES.get());
                        output.accept(ModBlocks.MEAT_BALLS.get());
                        output.accept(ModBlocks.MONSTER_LASAGNA.get());
                        output.accept(ModBlocks.MONSTER_TARTARE.get());
                        output.accept(ModBlocks.PEPPER_POPPER.get());
                        output.accept(ModBlocks.PIEROGI.get());
                        output.accept(ModBlocks.POTATO_TORNADO.get());
                        output.accept(ModBlocks.RATATOUILLE.get());
                        output.accept(ModBlocks.SALMON_SUSHI.get());
                        output.accept(ModBlocks.STEAMED_STICKS.get());
                        output.accept(ModBlocks.STUFFED_EGGPLANT.get());
                        output.accept(ModBlocks.SURF_N_TURF.get());
                        output.accept(ModBlocks.WATERMELON_ICLE.get());
                        output.accept(ModBlocks.WET_GOOP.get());

                        // More Crustaceans
                        output.accept(ModItems.CRAB_SHELL.get());
                        output.accept(ModItems.CRAB_MEAT.get());
                        output.accept(ModItems.CRAB_BUTTER.get());
                        output.accept(ModItems.COOKED_CRAB_MEAT.get());
                        output.accept(ModItems.GIANT_MUD_CRAB.get());
                        output.accept(ModItems.COOKED_GIANT_MUD_CRAB.get());
                        output.accept(ModItems.KING_CRAB.get());
                        output.accept(ModItems.COOKED_KING_CRAB.get());
                        output.accept(ModItems.CRAYFISH.get());
                        output.accept(ModItems.COOKED_CRAYFISH.get());
                        output.accept(ModItems.OYSTER.get());
                        output.accept(ModItems.SPICY_CRAYFISH.get());
                        output.accept(ModItems.CRAB_CAKE.get());
                        output.accept(ModItems.MARINATED_CRAB.get());
                        output.accept(ModItems.GIANT_MUD_CRAB_SPAWN_EGG.get());
                        output.accept(ModItems.KING_CRAB_SPAWN_EGG.get());
                        output.accept(ModItems.SAND_CRAB_SPAWN_EGG.get());
                        output.accept(ModItems.CRAYFISH_SPAWN_EGG.get());
                        output.accept(ModItems.GIANT_MUD_CRAB_BUCKET.get());
                        output.accept(ModItems.KING_CRAB_BUCKET.get());
                        output.accept(ModItems.SAND_CRAB_BUCKET.get());
                        output.accept(ModItems.CRAYFISH_BUCKET.get());

                        // Naturalist
                        output.accept(ModItems.BUTTERFLY_SPAWN_EGG.get());
                        output.accept(ModItems.CATERPILLAR_SPAWN_EGG.get());
                        output.accept(ModItems.SNAIL_SPAWN_EGG.get());
                        output.accept(ModItems.SPARROW_SPAWN_EGG.get());
                        output.accept(ModItems.CARDINAL_SPAWN_EGG.get());
                        output.accept(ModItems.LIZARD_SPAWN_EGG.get());
                        output.accept(ModItems.TORTOISE_SPAWN_EGG.get());
                        output.accept(ModItems.SNAIL_BUCKET.get());
                        output.accept(ModItems.SNAIL_SHELL.get());
                        output.accept(ModItems.GLOW_GOOP.get());
                        output.accept(ModItems.CHRYSALIS.get());
                        output.accept(ModBlocks.TORTOISE_EGG.get());
                        output.accept(ModBlocks.SNAIL_EGGS.get());
                        output.accept(ModBlocks.CATTAIL.get());

                        // Vintage Delight
                        output.accept(ModBlocks.WILD_OATS.get());
                        output.accept(ModBlocks.WILD_PEANUTS.get());

                        // Simple Farming
                        output.accept(ModBlocks.FERMENTER.get());
                        output.accept(ModItems.PEA_SEEDS.get());
                        output.accept(ModItems.CHILI_PEPPER_SEEDS.get());
                        output.accept(ModItems.SOYBEAN_SEEDS.get());
                        output.accept(ModItems.SWEET_POTATO_SEEDS.get());
                        output.accept(ModItems.PEA_POD.get());
                        output.accept(ModItems.SWEET_POTATO.get());
                        output.accept(ModItems.BAKED_SWEET_POTATO.get());

                        // Neapolitan
                        output.accept(ModBlocks.BANANA_FROND.get());
                        output.accept(ModItems.MINT_SPROUT.get());
                        output.accept(ModItems.VANILLA_PODS.get());
                        output.accept(ModItems.DRIED_VANILLA_PODS.get());
                        output.accept(ModItems.CHOCOLATE_BAR.get());
                        output.accept(ModItems.BANANA.get());
                        output.accept(ModItems.BANANA_BUNCH.get());
                        output.accept(ModItems.VANILLA_ICE_CREAM.get());
                        output.accept(ModItems.CHOCOLATE_ICE_CREAM.get());
                        output.accept(ModItems.STRAWBERRY_ICE_CREAM.get());
                        output.accept(ModItems.STRAWBERRY_MILKSHAKE.get());
                        output.accept(ModItems.BANANA_MILKSHAKE.get());
                        output.accept(ModItems.BANANA_BREAD.get());
                        output.accept(ModItems.ADZUKI_BUN.get());
                        output.accept(ModItems.ICE_CUBES.get());

                        // Croptopia
                        output.accept(ModItems.ANCHOVY.get());
                        output.accept(ModItems.APPLE_JUICE.get());
                        output.accept(ModItems.BANANA_CREAM_PIE.get());
                        output.accept(ModItems.BEEF_JERKY.get());
                        output.accept(ModItems.BLACK_PEPPER.get());
                        output.accept(ModItems.BLACK_PEPPER_SEEDS.get());
                        output.accept(ModItems.BLUEBERRY.get());
                        output.accept(ModItems.BROWNIES.get());
                        output.accept(ModItems.CAESAR_SALAD.get());
                        output.accept(ModItems.CHERRIES.get());
                        output.accept(ModItems.CHERRY_JAM.get());
                        output.accept(ModItems.CHERRY_PIE.get());
                        output.accept(ModItems.CHURROS.get());
                        output.accept(ModItems.CINNAMON.get());
                        output.accept(ModItems.CINNAMON_ROLL.get());
                        output.accept(ModItems.COOKED_ANCHOVY.get());
                        output.accept(ModItems.COOKED_TUNA.get());
                        output.accept(ModItems.CRAB.get());
                        output.accept(ModItems.CRAB_LEGS.get());
                        output.accept(ModItems.CROQUE_MONSIEUR.get());
                        output.accept(ModItems.DEEP_FRIED_SHRIMP.get());
                        output.accept(ModItems.DOUGHNUT.get());
                        output.accept(ModItems.ENCHILADA.get());
                        output.accept(ModItems.FAJITAS.get());
                        output.accept(ModItems.FRENCH_FRIES.get());
                        output.accept(ModItems.GRAPES.get());
                        output.accept(ModItems.GRAPE_JUICE.get());
                        output.accept(ModItems.GRAPE_SEEDS.get());
                        output.accept(ModItems.GRILLED_OYSTERS.get());
                        output.accept(ModItems.HASHED_BROWN.get());
                        output.accept(ModItems.LEMONADE.get());
                        output.accept(ModItems.MACARON.get());
                        output.accept(ModItems.MORTAR_AND_PESTLE.get());
                        output.accept(ModItems.OATS.get());
                        output.accept(ModItems.ORANGE_JUICE.get());
                        output.accept(ModItems.PEANUTS.get());
                        output.accept(ModItems.PEPPERONI.get());
                        output.accept(ModItems.PINEAPPLE_JUICE.get());
                        output.accept(ModItems.QUESADILLA.get());
                        output.accept(ModItems.ROASTED_NUTS.get());
                        output.accept(ModItems.ROE.get());
                        output.accept(ModItems.SAUSAGE.get());
                        output.accept(ModItems.SCONES.get());
                        output.accept(ModItems.SCRAMBLED_EGGS.get());
                        output.accept(ModItems.SOYBEAN.get());
                        output.accept(ModItems.SOY_MILK.get());
                        output.accept(ModItems.SOY_SAUCE.get());
                        output.accept(ModItems.SQUASH.get());
                        output.accept(ModItems.STEAMED_CLAMS.get());
                        output.accept(ModItems.STEAMED_CRAB.get());
                        output.accept(ModItems.STRAWBERRY.get());
                        output.accept(ModItems.SWEET_POTATO_FRIES.get());
                        output.accept(ModItems.TOFU.get());
                        output.accept(ModItems.TOFUBURGER.get());
                        output.accept(ModItems.TRAIL_MIX.get());
                        output.accept(ModItems.TUNA.get());
                        output.accept(ModItems.YOGHURT.get());

                        // Ecologics
                        output.accept(ModItems.COCONUT_CRAB_SPAWN_EGG.get());
                        output.accept(ModItems.SANDCASTLE.get());

                        // Corn Delight
                        output.accept(ModItems.CORN_DOG.get());
                        output.accept(ModBlocks.POPCORN_BOX.get());

                        // Create: Food
                        output.accept(ModItems.APPLE_SLICE.get());
                        output.accept(ModItems.BOILED_EGG_PEELED.get());
                        output.accept(ModItems.BREAD_CRUMBS.get());
                        output.accept(ModItems.BUTTER.get());
                        output.accept(ModItems.CARAMEL_POPCORN.get());
                        output.accept(ModItems.CHICKEN_NUGGETS.get());
                        output.accept(ModItems.ICE_CREAM_SANDWICH.get());

                        // Create Gourmet
                        output.accept(ModItems.BUTTER.get());
                        output.accept(ModItems.ICE_CREAM_CONE.get());
                        output.accept(ModItems.NEAPOLITAN_ICE_CREAM_CONE.get());

                        // HerbalBrews
                        output.accept(ModBlocks.WILD_ROOIBOS_PLANT.get());
                        output.accept(ModBlocks.TEA_LEAF_CRATE.get());
                        output.accept(ModBlocks.ROOIBOS_PLANT.get());
                        output.accept(ModItems.ROOIBOS_LEAF.get());
                        output.accept(ModItems.DRIED_OOLONG_TEA.get());
                        output.accept(ModItems.OOLONG_TEA.get());
                        output.accept(ModBlocks.TEA_KETTLE.get());
                        output.accept(ModBlocks.COPPER_TEA_KETTLE.get());

                        // Pineapple Delight
                        output.accept(ModItems.PINEAPPLE_SIDE.get());
                        output.accept(ModItems.PINEAPPLE_PIE_ITEM.get());
                        output.accept(ModItems.PINEAPPLE_PIE_SIDE.get());
                        output.accept(ModBlocks.PINEAPPLE_WILD_CROP.get());
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
