package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.InventoryMenu;
import net.minecraft.world.inventory.Slot;
import com.mojang.datafixers.util.Pair;
import net.minecraft.world.item.ItemStack;

public class NautilusInventoryMenu extends AbstractMountInventoryMenu {
    private static final ResourceLocation SADDLE_SLOT_SPRITE = Utils.createResourceLocation("textures/gui/slot/saddle");
    private static final ResourceLocation ARMOR_SLOT_SPRITE = Utils.createResourceLocation("textures/gui/slot/nautilus_armor_slot");

    public NautilusInventoryMenu(int containerId, Inventory playerInventory, Container mountInventory, final AbstractNautilus nautilus, int columns) {
        super(containerId, playerInventory, mountInventory, nautilus);

        // Slot 0: Saddle
//        Container container = nautilus.createEquipmentSlotContainer(EquipmentSlot.SADDLE);
        this.addSlot(new Slot(mountInventory, 0, 8, 18) {
            @Override
            public boolean isActive() {
                // canUseSlot was removed in previous file, we check logically
                return !nautilus.isBaby() && nautilus.isAlive();
            }
            // Replaces the sprite method in 1.21
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, SADDLE_SLOT_SPRITE);
            }
        });
        // Slot 1: Armor/Body
//        Container container1 = nautilus.createEquipmentSlotContainer(EquipmentSlot.BODY);

        this.addSlot(new Slot(mountInventory, 1, 8, 36) {
            @Override
            public boolean isActive() {
                return !nautilus.isBaby() && nautilus.isAlive();
            }
            @Override
            public Pair<ResourceLocation, ResourceLocation> getNoItemIcon() {
                return Pair.of(InventoryMenu.BLOCK_ATLAS, ARMOR_SLOT_SPRITE);
            }
            // Optional: Limit what can go here
            @Override
            public boolean mayPlace(ItemStack stack) {
                return false; // TODO: Nautilus armor
            }
        });
        // Add Player Inventory (using helper from AbstractMountInventoryMenu)
        this.addStandardInventorySlots(playerInventory, 8, 84);
    }

    @Override
    protected boolean hasInventoryChanged(Container container) {
        return ((AbstractNautilus)this.mount).hasInventoryChanged(container);
    }
}