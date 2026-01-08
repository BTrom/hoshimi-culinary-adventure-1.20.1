package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.util.NBTUtils;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.items.ItemStackHandler;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<CreativeModeTab> INGREDIENTS_TAB = CREATIVE_MODE_TABS.register("hoshimi_ingredients_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("Hoshimi's Culinary Ingredients"))
                    .icon(ModItems.CORN_ITEM.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        // Cultural Delight:
                        output.accept(ModItems.CUCUMBER_SEEDS.get());
                        output.accept(ModItems.CORN_KERNELS.get());
                        output.accept(ModItems.EGGPLANT_SEEDS.get());
                        output.accept(ModItems.AVOCADO_SEED.get());
                        output.accept(ModItems.AVOCADO_ITEM.get());
                        output.accept(ModItems.CUT_AVOCADO_ITEM.get());
                        output.accept(ModItems.CUCUMBER_ITEM.get());
                        output.accept(ModItems.CUCUMBER_SLICE.get());
                        output.accept(ModItems.PICKLE_ITEM.get());
                        output.accept(ModItems.CUT_PICKLE_ITEM.get());
                        output.accept(ModItems.EGGPLANT_ITEM.get());
                        output.accept(ModItems.CUT_EGGPLANT_ITEM.get());
                        output.accept(ModItems.TOMATO_SLICE.get());
                        output.accept(ModItems.SMOKED_TOMATO_ITEM.get());
                        output.accept(ModItems.CORN_ITEM.get());
                        output.accept(ModItems.SMOKED_CORN_ITEM.get());
                        output.accept(ModItems.POPCORN_ITEM.get());
                        output.accept(ModItems.CORN_DOUGH_ITEM.get());
                        output.accept(ModItems.TORTILLA_ITEM.get());
                        output.accept(ModItems.NACHOS_ITEM.get());
                        output.accept(ModItems.ELOTE_ITEM.get());
                        output.accept(ModItems.EMPANADA_ITEM.get());
                        output.accept(ModItems.HEARTY_SALAD_ITEM.get());
                        output.accept(ModItems.BEEF_BURRITO_ITEM.get());
                        output.accept(ModItems.CHICKEN_TACO_ITEM.get());
                        output.accept(ModItems.SPICY_CURRY_ITEM.get());
                        output.accept(ModItems.PORK_WRAP_ITEM.get());
                        output.accept(ModItems.FISH_TACO_ITEM.get());
                        output.accept(ModItems.MIDORI_ROLL_ITEM.get());
                        output.accept(ModItems.MIDORI_ROLL_SLICE_ITEM.get());
                        output.accept(ModItems.EGG_ROLL_ITEM.get());
                        output.accept(ModItems.TROPICAL_ROLL_ITEM.get());
                        output.accept(ModItems.RICE_BALL_ITEM.get());

                        output.accept(ModBlocks.WILD_CUCUMBERS.get());
                        output.accept(ModBlocks.WILD_CORN.get());
                        output.accept(ModBlocks.WILD_EGGPLANTS.get());
//                      output.accept(ModBlocks.AVOCADO_);
                        output.accept(ModBlocks.CORN_COB_CRATE.get());
                        output.accept(ModBlocks.EXOTIC_ROLL_MEDLEY.get());

                        // More Delight:
                        output.accept(ModItems.CHOCOLATE_POPSICLE_ITEM.get());
                        output.accept(ModItems.OMELETTE_ITEM.get());
                        output.accept(ModItems.CREAMY_PASTA_WITH_HAM_ITEM.get());
                        output.accept(ModItems.CREAMY_PASTA_WITH_CHICKEN_CUTS_ITEM.get());
                        output.accept(ModItems.MASHED_POTATOES_ITEM.get());
                        output.accept(ModItems.CHICKEN_SALAD_ITEM.get());
                        output.accept(ModItems.BREAD_SLICE.get());
                        output.accept(ModItems.TOAST.get());
                        output.accept(ModItems.TOAST_WITH_SWEET_BERRIES.get());
                        output.accept(ModItems.TOAST_WITH_CHOCOLATE.get());

                        // Delightful
                        output.accept(ModItems.MATCHA.get());
                        output.accept(ModItems.MATCHA_ICE_CREAM.get());
                        output.accept(ModItems.MATCHA_MILKSHAKE.get());
                        output.accept(ModItems.MATCHA_LATTE_ITEM.get());
                        output.accept(ModItems.ACORN.get());
                        output.accept(ModItems.ROASTED_ACORN.get());
                        output.accept(ModItems.CACTUS_FLESH.get());
                        output.accept(ModItems.CACTUS_STEAK.get());
                        output.accept(ModItems.CACTUS_CHILI_ITEM.get());
                        output.accept(ModItems.CACTUS_SOUP_ITEM.get());
                        output.accept(ModItems.JAM_JAR_ITEM.get());
                        output.accept(ModItems.FIELD_SALAD_ITEM.get());
                        output.accept(ModItems.CHEESEBURGER.get());
                        output.accept(ModItems.MARSHMALLOW_STICK_ITEM.get());
                        output.accept(ModItems.COOKED_MARSHMALLOW_STICK_ITEM.get());
                        output.accept(ModItems.SMORE.get());

                        // Oceanic Delight
                        output.accept(ModBlocks.PAELLA.get());
                        output.accept(ModItems.PAELLA_ITEM.get());

                        // PizzaCraft
//                        output.accept(ModItems.BROCCOLI_SEEDS.get());
//                        output.accept(ModItems.PEPPER_SEEDS.get());
//                        output.accept(ModItems.PINEAPPLE_SEEDS.get());
//                        output.accept(ModItems.RAW_PIZZA.get());
//                        output.accept(ModItems.OLIVE_OIL.get());
//                        output.accept(ModItems.TOMATO_SAUCE.get());
//                        output.accept(ModItems.HOT_SAUCE.get());
//                        output.accept(ModItems.BROCCOLI.get());
//                        output.accept(ModItems.PEPPER.get());
//                        output.accept(ModItems.PEPPER_SLICE.get());
//                        output.accept(ModItems.PINEAPPLE.get());
//                        output.accept(ModItems.PINEAPPLE_SLICE.get());
//                        output.accept(ModItems.OLIVE.get());
//                        output.accept(ModItems.ONION_SLICE.get());
//                        output.accept(ModItems.MUSHROOM_SLICE.get());
//                        output.accept(ModItems.CUT_HAM.get());
//                        output.accept(ModItems.CHICKEN_WING.get());
//                        output.accept(ModItems.COOKED_WING.get());
//                        output.accept(ModItems.HOT_WING.get());
//                        output.accept(ModItems.CORN_FLOUR.get());
//                        output.accept(ModItems.CHEESE.get());
//                        output.accept(ModItems.ROLLING_PIN.get());
//                        output.accept(ModItems.PIZZA_PEEL.get());
//
//                        output.accept(ModBlocks.BROCCOLI.get());
//                        output.accept(ModBlocks.PEPPERS.get());
//                        output.accept(ModBlocks.PINEAPPLE.get());
//                        output.accept(ModBlocks.PIZZA_STATION.get());
//                        output.accept(ModBlocks.PIZZA_OVEN.get());
//                        output.accept(ModBlocks.GRANITE_BASIN.get());
//                        output.accept(ModBlocks.DIORITE_BASIN.get());
//                        output.accept(ModBlocks.ANDESITE_BASIN.get());
//                        output.accept(ModBlocks.BASALT_BASIN.get());
//                        output.accept(ModBlocks.BLACKSTONE_BASIN.get());
//                        output.accept(ModBlocks.PIZZA.get());
//                        output.accept(ModBlocks.RAW_PIZZA.get());
//                        output.accept(ModBlocks.PIZZA_DOUGH.get());
//                        output.accept(ModBlocks.CHEESE_BLOCK.get());

                        output.accept(ModBlocks.PIZZA_STATION.get());
                        output.accept(ModBlocks.OVEN.get());
                        output.accept(ModBlocks.GRANITE_BASIN.get());
                        output.accept(ModBlocks.DIORITE_BASIN.get());
                        output.accept(ModBlocks.ANDESITE_BASIN.get());
                        output.accept(ModBlocks.BASALT_BASIN.get());
                        output.accept(ModBlocks.BLACKSTONE_BASIN.get());

                        output.accept(ModBlocks.DOUGH.get());
                        output.accept(ModBlocks.RAW_PIZZA.get());
                        output.accept(ModBlocks.PIZZA.get());

                        output.accept(ModItems.STONE_KNIFE.get());
                        output.accept(ModItems.GOLDEN_KNIFE.get());
                        output.accept(ModItems.IRON_KNIFE.get());
                        output.accept(ModItems.DIAMOND_KNIFE.get());
                        output.accept(ModItems.NETHERITE_KNIFE.get());

                        output.accept(ModItems.STONE_PIZZA_PEEL.get());
                        output.accept(ModItems.GOLDEN_PIZZA_PEEL.get());
                        output.accept(ModItems.IRON_PIZZA_PEEL.get());
                        output.accept(ModItems.DIAMOND_PIZZA_PEEL.get());
                        output.accept(ModItems.NETHERITE_PIZZA_PEEL.get());

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
                        output.accept(ModItems.HAM.get());
                        output.accept(ModItems.WING.get());
                        output.accept(ModItems.COOKED_WING.get());
                        output.accept(ModItems.HOT_WING.get());
                        output.accept(ModItems.FISH_FILLET.get());
                        output.accept(ModItems.COOKED_FISH_FILLET.get());
                        output.accept(ModItems.FLOUR.get());
                        output.accept(ModItems.CORN_FLOUR.get());

                        output.accept(ModItems.TOMATO_SAUCE.get());
                        output.accept(ModItems.HOT_SAUCE.get());
                        output.accept(ModItems.OLIVE_OIL.get());

                        output.accept(ModItems.BROCCOLI_SEEDS.get());
                        output.accept(ModItems.PEPPER_SEEDS.get());
                        output.accept(ModItems.PINEAPPLE_SEEDS.get());
                    })
                    .build());

    public static final RegistryObject<CreativeModeTab> MEALS_TAB = CREATIVE_MODE_TABS.register("hoshimi_meals_tab",
            () -> CreativeModeTab.builder()
                    .title(Component.translatable("Hoshimi's Culinary Meals"))
                    .icon(ModItems.CREAMY_PASTA_WITH_HAM_ITEM.get()::getDefaultInstance)
                    .displayItems((displayParameters, output) -> {
                        // Cultural Delight:
                        output.accept(ModItems.CUCUMBER_SEEDS.get());
                    })
                    .build());

    public static ItemStack createIcon() {
        ItemStack stack = ModItems.PIZZA_SLICE.get().getDefaultInstance();
        ItemStackHandler handler = new ItemStackHandler(6);
        handler.setStackInSlot(0, ModItems.CHEESE.get().getDefaultInstance());
        //handler.setStackInSlot(1, ModItems.PEPPER_SLICE.get().getDefaultInstance());
        //handler.setStackInSlot(2, ModItems.WING.get().getDefaultInstance());
        //handler.setStackInSlot(3, ModItems.BROCCOLI.get().getDefaultInstance());
        //handler.setStackInSlot(4, ModItems.ONION_SLICE.get().getDefaultInstance());
        //handler.setStackInSlot(5, ModItems.TOMATO_SLICE.get().getDefaultInstance());
        NBTUtils.saveInventoryToStack(stack, handler);
        return stack;
    }

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
