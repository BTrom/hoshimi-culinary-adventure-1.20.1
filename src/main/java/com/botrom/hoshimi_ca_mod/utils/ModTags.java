package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import static com.botrom.hoshimi_ca_mod.utils.Utils.createResourceLocation;

public class ModTags {
    //public static final TagKey<Item> ...

//        private static TagKey<Item> tag(String name) {
//            return ItemTags.create(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, name));
//        }
//
//        private static TagKey<Item> forgeTag(String name) {
//            return ItemTags.create(new ResourceLocation("forge", name));
//        }

    // Item Tags
    public static final TagKey<Item> CHIEFTAIN_CRAB_FOOD = bindItemTag("chieftain_crab_food");

    // Block Tags
    public static final TagKey<Block> CROPS_PLANTABLE_ON = bindBlockTag("crops_plantable_on");
    public static final TagKey<Block> CRAB_SPAWNABLE_ON = bindBlockTag("crab_spawnable_on");



    private static TagKey<Item> bindItemTag(String name) {
        return ItemTags.create(createResourceLocation(name));
    }

    private static TagKey<Block> bindBlockTag(String name) {
        return BlockTags.create(createResourceLocation(name));
    }
}