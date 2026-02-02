package com.botrom.hoshimi_ca_mod.items;

import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.item.Tier;

/**
 * Copper Pickaxe item.
 * Uses CopperTier which has stats between Stone and Iron.
 */
public class CopperPickaxeItem extends PickaxeItem {
    
    public CopperPickaxeItem(Tier tier, int attackDamage, float attackSpeed, Properties properties) {
        super(tier, attackDamage, attackSpeed, properties);
    }
}
