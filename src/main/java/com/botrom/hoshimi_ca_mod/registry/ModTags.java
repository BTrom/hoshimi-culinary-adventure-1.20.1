package com.botrom.hoshimi_ca_mod.registry;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.NotNull;

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
    public static final TagKey<Item> CRAB_TEMPT_ITEM = bindItemTag("crab_tempt_item");
    public static final TagKey<Item> CRAB_TRAP_BAIT = bindItemTag("crab_trap_bait");
    public static final TagKey<Item> CREATURE_CHUMS = bindItemTag("creature_chums");
    public static final TagKey<Item> CATFISH_ITEM_FASCINATIONS = bindItemTagAlex("catfish_item_fascinations");
    public static final TagKey<Item> MIMIC_OCTOPUS_CREEPER_ITEMS = bindItemTagAlex("mimic_octopus_creeper_items");
    public static final TagKey<Item> MIMIC_OCTOPUS_GUARDIAN_ITEMS = bindItemTagAlex("mimic_octopus_guardian_items");
    public static final TagKey<Item> MIMIC_OCTOPUS_PUFFERFISH_ITEMS = bindItemTagAlex("mimic_octopus_pufferfish_items");
    public static final TagKey<Item> MIMIC_OCTOPUS_BREEDABLES = bindItemTagAlex("mimic_octopus_breedables");
    public static final TagKey<Item> MIMIC_OCTOPUS_TAMEABLES = bindItemTagAlex("mimic_octopus_tameables");
    public static final TagKey<Item> MIMIC_OCTOPUS_ATTACK_FOODS = bindItemTagAlex("mimic_octopus_attack_foods");
    public static final TagKey<Item> MIMIC_OCTOPUS_TOGGLES_MIMIC = bindItemTagAlex("mimic_octopus_toggles_mimic");
    public static final TagKey<Item> MIMIC_OCTOPUS_MOISTURIZES = bindItemTagAlex("mimic_octopus_moisturizes");
    public static final TagKey<Item> SEAGULL_BREEDABLES = bindItemTagAlex("seagull_breedables");
    public static final TagKey<Item> SEAGULL_OFFERINGS = bindItemTagAlex("seagull_offerings");
    public static final TagKey<Item> FEEDING_TROUGH_FODDER = bindItemTagAlex("feeding_trough_fodder");

    // Block Tags
    public static final TagKey<Block> CROPS_PLANTABLE_ON = bindBlockTag("crops_plantable_on");
    public static final TagKey<Block> CRAB_SPAWNABLE_ON = bindBlockTag("crab_spawnable_on");
    public static final TagKey<Block> CATFISH_BLOCK_FASCINATIONS = bindBlockTagAlex("catfish_block_fascinations");
    public static final TagKey<Block> LOBSTER_SPAWNS = bindBlockTagAlex("lobster_spawns");
    public static final TagKey<Block> MIMIC_OCTOPUS_SPAWNS = bindBlockTagAlex("mimic_octopus_spawns");
    public static final TagKey<Block> COOKING_POTS = bindBlockTagAlex("cooking_pots");
    public static final TagKey<Block> ALLOWS_COOKING = bindBlockTagAlex("allows_cooking");
    public static final TagKey<Block> WILD_CROPS = bindBlockTagAlex("wild_crops");

    // Mob Effects
    public static final TagKey<MobEffect> UNOBTAINABLE_FROM_PANETTONE = bindEffectTag("unobtainable_from_panettone");

    // Damage Tags
    public static final TagKey<DamageType> TRIGGERS_SURGE = bindDamageTag("triggers_surge");

    public static final ResourceKey<DamageType> FALLING_COCONUT = bindDamageType("falling_coconut");

    // Entity Tags
    public static final TagKey<EntityType<?>> CORROSION_IMMUNE = bindEntityTag("corrosion_immune");
    public static final TagKey<EntityType<?>> VOLATILITY_IMMUNE = bindEntityTag("volatility_immune");
    public static final TagKey<EntityType<?>> INVOLATILE = bindEntityTag("involatile");
    public static final TagKey<EntityType<?>> GIANT_SQUID_TARGETS = bindEntityTag("giant_squid_targets");
    public static final TagKey<EntityType<?>> MIMIC_OCTOPUS_FEARS = bindEntityTag("mimic_octopus_fears");
    public static final TagKey<EntityType<?>> CATFISH_IGNORE_EATING = bindEntityTag("catfish_ignore_eating");
    public static final TagKey<EntityType<?>> SCATTERS_CROWS = bindEntityTag("scatters_crows");
    public static final TagKey<EntityType<?>> IS_WOLF = bindEntityTag("is_wolf");

    // Biome Tags
    public static final TagKey<Biome> SPAWNS_HUGE_CATFISH = bindBiomeTag("spawns_huge_catfish");
    


    // Registry
    private static TagKey<Item> bindItemTag(String name) {
        return ItemTags.create(createResourceLocation(name));
    }

    private static TagKey<Item> bindItemTagAlex(String name) { //TODO: Made to be sure, but do try the one above
        return TagKey.create(Registries.ITEM, createResourceLocation(name));
    }

    private static TagKey<Block> bindBlockTag(String name) {
        return BlockTags.create(createResourceLocation(name));
    }

    private static TagKey<Block> bindBlockTagAlex(String name) { //TODO: Made to be sure, but do try the one above
        return TagKey.create(Registries.BLOCK, createResourceLocation(name));
    }

    private static TagKey<MobEffect> bindEffectTag(@NotNull String name) {
        return TagKey.create(Registries.MOB_EFFECT, createResourceLocation(name));
    }

    private static TagKey<DamageType> bindDamageTag(@NotNull String name) {
        return TagKey.create(Registries.DAMAGE_TYPE, createResourceLocation(name));
    }

    private static ResourceKey<DamageType> bindDamageType(String name) {
        return ResourceKey.create(Registries.DAMAGE_TYPE, createResourceLocation(name));
    }

    private static TagKey<EntityType<?>> bindEntityTag(@NotNull String name) {
        return TagKey.create(Registries.ENTITY_TYPE, createResourceLocation(name));
    }

    private static TagKey<Biome> bindBiomeTag(String name) {
        return TagKey.create(Registries.BIOME, createResourceLocation(name));
    }
}