package com.botrom.hoshimi_ca_mod.utils;

import net.minecraft.client.color.block.BlockColor;
import net.minecraft.client.color.block.BlockColors;
import net.minecraft.client.color.item.ItemColor;
import net.minecraft.client.color.item.ItemColors;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.RegistryObject;

import java.util.List;

public class BlueprintDataUtils {

    @OnlyIn(Dist.CLIENT)
    public static void registerBlockColor(BlockColors blockColors, BlockColor color, List<RegistryObject<Block>> blocksIn) {
        blocksIn.removeIf((block) -> {
            return !block.isPresent();
        });
        if (blocksIn.size() > 0) {
            Block[] blocks = new Block[blocksIn.size()];

            for(int i = 0; i < blocksIn.size(); ++i) {
                blocks[i] = (Block)((RegistryObject)blocksIn.get(i)).get();
            }

            blockColors.register(color, blocks);
        }

    }

    @OnlyIn(Dist.CLIENT)
    public static void registerBlockItemColor(ItemColors itemColors, ItemColor color, List<RegistryObject<Block>> blocksIn) {
        blocksIn.removeIf((block) -> {
            return !block.isPresent();
        });
        if (blocksIn.size() > 0) {
            Block[] blocks = new Block[blocksIn.size()];

            for(int i = 0; i < blocksIn.size(); ++i) {
                blocks[i] = (Block)((RegistryObject)blocksIn.get(i)).get();
            }

            itemColors.register(color, blocks);
        }

    }
}
