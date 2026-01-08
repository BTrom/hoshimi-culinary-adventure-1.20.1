package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    //public static final TagKey<Item> ...

//        private static TagKey<Item> tag(String name) {
//            return ItemTags.create(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, name));
//        }
//
//        private static TagKey<Item> forgeTag(String name) {
//            return ItemTags.create(new ResourceLocation("forge", name));
//        }

    public static ResourceLocation createResourceLocation(String tagName) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, tagName);
    }
}
