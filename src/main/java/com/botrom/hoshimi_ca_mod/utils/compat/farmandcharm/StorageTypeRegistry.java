package com.botrom.hoshimi_ca_mod.utils.compat.farmandcharm;

import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;

import java.util.Set;

public class StorageTypeRegistry {
    public static final ResourceLocation CHICKEN_NEST = Utils.createResourceLocation("chicken_nest");

    public static Set<Block> registerBlocks(Set<Block> blocks) {
        blocks.add(ModBlocks.CHICKEN_NEST.get());
        return blocks;
    }
}
