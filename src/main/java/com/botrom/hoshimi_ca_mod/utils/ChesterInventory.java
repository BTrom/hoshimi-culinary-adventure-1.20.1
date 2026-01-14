package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.items.ItemStackHandler;

public class ChesterInventory extends ItemStackHandler {
    private final Chester chester;
    private int openCount = 0;

    public ChesterInventory(Chester chester, int size) {
        super(size);
        this.chester = chester;
    }

    public boolean isItemValid(int slot, ItemStack stack) {
        return stack.func_77973_b() != ModItems.EYE_BONE;
    }

    public void handleInventoryOpening(Player player) {
        if (!player.field_70170_p.field_72995_K && !player.func_175149_v()) {
            if (++this.openCount == 1) {
                this.chester.openMouth();
            }

        }
    }

    public void handleInventoryClosure(Player player) {
        if (!player.field_70170_p.field_72995_K && !player.func_175149_v()) {
            if (--this.openCount <= 0) {
                this.chester.closeMouth();
            }

        }
    }
}