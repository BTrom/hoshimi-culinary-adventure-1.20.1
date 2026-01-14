package com.botrom.hoshimi_ca_mod.blocks.menus;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.CrockPotBlockEntity;
import net.minecraft.world.inventory.MenuType;
import net.minecraftforge.common.extensions.IForgeMenuType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public final class CrockPotMenuTypes {
    private CrockPotMenuTypes() {
    }

    public static final DeferredRegister<MenuType<?>> MENU_TYPES = DeferredRegister.create(ForgeRegistries.MENU_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<MenuType<CrockPotMenu>> CROCK_POT_MENU_TYPE = MENU_TYPES.register("crock_pot", () -> IForgeMenuType.create((windowId, inv, data) -> new CrockPotMenu(windowId, inv, (CrockPotBlockEntity) inv.player.level().getBlockEntity(data.readBlockPos()))));
}
