package com.botrom.hoshimi_ca_mod.items;

import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Tier;

/**
 * Copper Hoe item.
 * Uses CopperTier which has stats between Stone and Iron.
 */
public class CopperHoeItem extends HoeItem {
    
    public CopperHoeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
}
