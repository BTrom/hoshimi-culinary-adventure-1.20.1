package com.botrom.hoshimi_ca_mod.entities;

import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;

public interface EggLayingAnimal {
    boolean hasEgg();
    void setHasEgg(boolean hasEgg);
    boolean isLayingEgg();
    void setLayingEgg(boolean isLayingEgg);
    int getLayEggCounter();
    void setLayEggCounter(int layEggCounter);
    Block getEggBlock();
    TagKey<Block> getEggLayableBlockTag();
}
