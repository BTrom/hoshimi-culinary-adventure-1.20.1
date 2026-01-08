package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.pizzacraft.container.PizzaMenu;
import com.botrom.hoshimi_ca_mod.pizzacraft.container.PizzaStationMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<MenuType<PizzaStationMenu>> PIZZA_STATION = MENU_TYPES.register("pizza_station", () -> IForgeMenuType.create(PizzaStationMenu::new));
    public static final RegistryObject<MenuType<PizzaMenu>> PIZZA = MENU_TYPES.register("pizza", () -> IForgeMenuType.create(PizzaMenu::new));
//    public static final RegistryObject<MenuType<PizzaBagMenu>> PIZZA_BAG = MENU_TYPES.register("pizza_bag", () -> IForgeMenuType.create(PizzaBagMenu::new));

//    public static void register(IEventBus eventBus) {
//        MENU_TYPES.register(eventBus);
//    }
}
