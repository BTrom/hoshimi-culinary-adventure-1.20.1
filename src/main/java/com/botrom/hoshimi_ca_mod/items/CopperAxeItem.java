package com.botrom.hoshimi_ca_mod.items;

import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Tier;

/**
 * Copper Axe item.
 * Uses CopperTier which has stats between Stone and Iron.
 */
public class CopperAxeItem extends AxeItem {
    
    public CopperAxeItem(Tier tier, float attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
}
