package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.CrockPotBlockEntity;
import com.botrom.hoshimi_ca_mod.blocks.menus.CrabTrapMenu;
import com.botrom.hoshimi_ca_mod.blocks.menus.CrockPotMenu;
import com.botrom.hoshimi_ca_mod.gui.StoveGuiHandler;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.container.PizzaMenu;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.container.PizzaStationMenu;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.gui.screens.inventory.MenuAccess;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModMenuTypes {
    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<MenuType<PizzaStationMenu>> PIZZA_STATION = MENU_TYPES.register("pizza_station", () -> IForgeMenuType.create(PizzaStationMenu::new));
    public static final RegistryObject<MenuType<PizzaMenu>> PIZZA = MENU_TYPES.register("pizza", () -> IForgeMenuType.create(PizzaMenu::new));
    public static final RegistryObject<MenuType<CrabTrapMenu>> CRAB_TRAP_MENU = MENU_TYPES.register("crab_trap_menu", () -> IForgeMenuType.create(CrabTrapMenu::new));
    public static final RegistryObject<MenuType<StoveGuiHandler>> STOVE_SCREEN_HANDLER = MENU_TYPES.register("stove_gui_handler", () -> IForgeMenuType.create(StoveGuiHandler::new));
    public static final RegistryObject<MenuType<CrockPotMenu>> CROCK_POT_MENU_TYPE = MENU_TYPES.register("crock_pot", () -> IForgeMenuType.create((windowId, inv, data) -> new CrockPotMenu(windowId, inv, (CrockPotBlockEntity) inv.player.level().getBlockEntity(data.readBlockPos()))));


//    public static void register(IEventBus eventBus) {
//        MENU_TYPES.register(eventBus);
//    }

    public static <H extends AbstractContainerMenu, S extends Screen & MenuAccess<H>> void registerScreenFactory(MenuType<? extends H> type, ScreenFactory<H, S> factory) {
        throw new AssertionError();
    }

    public interface ScreenFactory<H extends AbstractContainerMenu, S extends Screen & MenuAccess<H>> {
        /**
         * Creates a new {@link S} that extends {@link Screen}
         *
         * @param containerMenu The {@link AbstractContainerMenu} that controls the game logic for the screen
         * @param inventory     The {@link Inventory} for the screen
         * @param component     The {@link Component} for the screen
         * @return A new {@link S} that extends {@link Screen}
         */
        S create(H containerMenu, Inventory inventory, Component component);
    }
}
