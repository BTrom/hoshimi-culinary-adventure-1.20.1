package com.botrom.hoshimi_ca_mod.utils;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

import static com.botrom.hoshimi_ca_mod.utils.Utils.createResourceLocation;
import static net.minecraft.resources.ResourceKey.createRegistryKey;

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

    // Mob Effects
    public static final TagKey<MobEffect> UNOBTAINABLE_FROM_PANETTONE = bindEffectTag("unobtainable_from_panettone");

    // Damage Tags
    public static final TagKey<DamageType> TRIGGERS_SURGE = bindDamageTag("triggers_surge");

    // Entity Tags
    public static final TagKey<EntityType<?>> CORROSION_IMMUNE = bindEntityTag("corrosion_immune");
    public static final TagKey<EntityType<?>> VOLATILITY_IMMUNE = bindEntityTag("volatility_immune");
    public static final TagKey<EntityType<?>> INVOLATILE = bindEntityTag("involatile");



    private static TagKey<Item> bindItemTag(String name) {
        return ItemTags.create(createResourceLocation(name));
    }

    private static TagKey<Block> bindBlockTag(String name) {
        return BlockTags.create(createResourceLocation(name));
    }

    private static TagKey<MobEffect> bindEffectTag(@NotNull String name) {
        return TagKey.create(Registries.MOB_EFFECT, createResourceLocation(name));
    }

    private static TagKey<DamageType> bindDamageTag(@NotNull String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, createResourceLocation(name));
    }

    private static TagKey<EntityType<?>> bindEntityTag(@NotNull String name) {
        return TagKey.create(Registries.ENTITY_TYPE, createResourceLocation(name));
    }
}