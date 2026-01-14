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

import static com.botrom.hoshimi_ca_mod.utils.Utils.createForgeResourceLocation;
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
//    public static final TagKey<Item> CROCK_POTS = bindItemTag("crock_pots");
    public static final TagKey<Item> PARROT_EGGS = bindItemTag("parrot_eggs");

    // Crockpot Item Tags - TODO: These might be redundant with the rest, but we're adding them for safety
    public static final TagKey<Item> CROPS_ASPARAGUS = bindItemForgeTag("crops/asparagus");
    public static final TagKey<Item> CROPS_CORN = bindItemForgeTag("crops/corn");
    public static final TagKey<Item> CROPS_EGGPLANT = bindItemForgeTag("crops/eggplant");
    public static final TagKey<Item> CROPS_GARLIC = bindItemForgeTag("crops/garlic");
    public static final TagKey<Item> CROPS_ONION = bindItemForgeTag("crops/onion");
    public static final TagKey<Item> CROPS_PEPPER = bindItemForgeTag("crops/pepper");
    public static final TagKey<Item> CROPS_TOMATO = bindItemForgeTag("crops/tomato");
    public static final TagKey<Item> SEEDS_ASPARAGUS = bindItemForgeTag("seeds/asparagus");
    public static final TagKey<Item> SEEDS_CORN = bindItemForgeTag("seeds/corn");
    public static final TagKey<Item> SEEDS_EGGPLANT = bindItemForgeTag("seeds/eggplant");
    public static final TagKey<Item> SEEDS_GARLIC = bindItemForgeTag("seeds/garlic");
    public static final TagKey<Item> SEEDS_ONION = bindItemForgeTag("seeds/onion");
    public static final TagKey<Item> SEEDS_PEPPER = bindItemForgeTag("seeds/pepper");
    public static final TagKey<Item> SEEDS_TOMATO = bindItemForgeTag("seeds/tomato");
    public static final TagKey<Item> VEGETABLES = bindItemForgeTag("vegetables");
    public static final TagKey<Item> VEGETABLES_BEETROOT = bindItemForgeTag("vegetables/beetroot");
    public static final TagKey<Item> VEGETABLES_CARROT = bindItemForgeTag("vegetables/carrot");
    public static final TagKey<Item> VEGETABLES_POTATO = bindItemForgeTag("vegetables/potato");
    public static final TagKey<Item> VEGETABLES_PUMPKIN = bindItemForgeTag("vegetables/pumpkin");
    public static final TagKey<Item> VEGETABLES_ASPARAGUS = bindItemForgeTag("vegetables/asparagus");
    public static final TagKey<Item> VEGETABLES_CORN = bindItemForgeTag("vegetables/corn");
    public static final TagKey<Item> VEGETABLES_EGGPLANT = bindItemForgeTag("vegetables/eggplant");
    public static final TagKey<Item> VEGETABLES_GARLIC = bindItemForgeTag("vegetables/garlic");
    public static final TagKey<Item> VEGETABLES_ONION = bindItemForgeTag("vegetables/onion");
    public static final TagKey<Item> VEGETABLES_PEPPER = bindItemForgeTag("vegetables/pepper");
    public static final TagKey<Item> VEGETABLES_TOMATO = bindItemForgeTag("vegetables/tomato");
    public static final TagKey<Item> FRUITS = bindItemForgeTag("fruits");
    public static final TagKey<Item> FRUITS_APPLE = bindItemForgeTag("fruits/apple");
    public static final TagKey<Item> RAW_BEEF = bindItemForgeTag("raw_beef");
    public static final TagKey<Item> RAW_CHICKEN = bindItemForgeTag("raw_chicken");
    public static final TagKey<Item> RAW_MUTTON = bindItemForgeTag("raw_mutton");
    public static final TagKey<Item> RAW_PORK = bindItemForgeTag("raw_pork");
    public static final TagKey<Item> RAW_RABBIT = bindItemForgeTag("raw_rabbit");
    public static final TagKey<Item> COOKED_BEEF = bindItemForgeTag("cooked_beef");
    public static final TagKey<Item> COOKED_CHICKEN = bindItemForgeTag("cooked_chicken");
    public static final TagKey<Item> COOKED_MUTTON = bindItemForgeTag("cooked_mutton");
    public static final TagKey<Item> COOKED_PORK = bindItemForgeTag("cooked_pork");
    public static final TagKey<Item> COOKED_RABBIT = bindItemForgeTag("cooked_rabbit");
    public static final TagKey<Item> RAW_FISHES = bindItemForgeTag("raw_fishes");
    public static final TagKey<Item> RAW_FISHES_COD = bindItemForgeTag("raw_fishes/cod");
    public static final TagKey<Item> RAW_FISHES_SALMON = bindItemForgeTag("raw_fishes/salmon");
    public static final TagKey<Item> RAW_FISHES_TROPICAL_FISH = bindItemForgeTag("raw_fishes/tropical_fish");
    public static final TagKey<Item> COOKED_FISHES = bindItemForgeTag("cooked_fishes");
    public static final TagKey<Item> COOKED_FISHES_COD = bindItemForgeTag("cooked_fishes/cod");
    public static final TagKey<Item> COOKED_FISHES_SALMON = bindItemForgeTag("cooked_fishes/salmon");
    public static final TagKey<Item> COOKED_EGGS = bindItemForgeTag("cooked_eggs");
    public static final TagKey<Item> MILK = bindItemForgeTag("milk");
    public static final TagKey<Item> MILK_BOTTLE = bindItemForgeTag("milk/milk_bottle");
    public static final TagKey<Item> INGREDIENTS_ASPARAGUS = bindItemTag("ingredients/asparagus");
    public static final TagKey<Item> INGREDIENTS_BONE = bindItemTag("ingredients/bone");
    public static final TagKey<Item> INGREDIENTS_CORN = bindItemTag("ingredients/corn");
    public static final TagKey<Item> INGREDIENTS_DRUMSTICK = bindItemTag("ingredients/drumstick");
    public static final TagKey<Item> INGREDIENTS_EGGPLANT = bindItemTag("ingredients/eggplant");
    public static final TagKey<Item> INGREDIENTS_GARLIC = bindItemTag("ingredients/garlic");
    public static final TagKey<Item> INGREDIENTS_HAM = bindItemTag("ingredients/ham");
    public static final TagKey<Item> INGREDIENTS_HONEY = bindItemTag("ingredients/honey");
    public static final TagKey<Item> INGREDIENTS_KELP = bindItemTag("ingredients/kelp");
    public static final TagKey<Item> INGREDIENTS_LARGE_EGG = bindItemTag("ingredients/large_egg");
    public static final TagKey<Item> INGREDIENTS_ONION = bindItemTag("ingredients/onion");
    public static final TagKey<Item> INGREDIENTS_POTATO = bindItemTag("ingredients/potato");
    public static final TagKey<Item> INGREDIENTS_PUMPKIN = bindItemTag("ingredients/pumpkin");
    public static final TagKey<Item> INGREDIENTS_RED_PEPPER = bindItemTag("ingredients/red_pepper");
    public static final TagKey<Item> INGREDIENTS_RABBIT = bindItemTag("ingredients/rabbit");
    public static final TagKey<Item> INGREDIENTS_SALMON = bindItemTag("ingredients/salmon");
    public static final TagKey<Item> INGREDIENTS_SANDWICH_LEAF = bindItemTag("ingredients/sandwich_leaf");
    public static final TagKey<Item> INGREDIENTS_STICK = bindItemTag("ingredients/stick");
    public static final TagKey<Item> INGREDIENTS_SUGARY = bindItemTag("ingredients/sugary");
    public static final TagKey<Item> INGREDIENTS_SYRUP = bindItemTag("ingredients/syrup");
    public static final TagKey<Item> INGREDIENTS_TEA = bindItemTag("ingredients/tea");
    public static final TagKey<Item> INGREDIENTS_TOMATO = bindItemTag("ingredients/tomato");
    public static final TagKey<Item> INGREDIENTS_TROPICAL_FISH = bindItemTag("ingredients/tropical_fish");
    public static final TagKey<Item> INGREDIENTS_WATERMELON = bindItemTag("ingredients/watermelon");
    
    
    // Block Tags
    public static final TagKey<Block> CROPS_PLANTABLE_ON = bindBlockTag("crops_plantable_on");
    public static final TagKey<Block> CRAB_SPAWNABLE_ON = bindBlockTag("crab_spawnable_on");
    public static final TagKey<Block> CATFISH_BLOCK_FASCINATIONS = bindBlockTagAlex("catfish_block_fascinations");
    public static final TagKey<Block> LOBSTER_SPAWNS = bindBlockTagAlex("lobster_spawns");
    public static final TagKey<Block> MIMIC_OCTOPUS_SPAWNS = bindBlockTagAlex("mimic_octopus_spawns");
    public static final TagKey<Block> COOKING_POTS = bindBlockTagAlex("cooking_pots");
    public static final TagKey<Block> ALLOWS_COOKING = bindBlockTagAlex("allows_cooking");
    public static final TagKey<Block> WILD_CROPS = bindBlockTagAlex("wild_crops");
    public static final TagKey<Block> CROCK_POTS = bindBlockTag("crock_pots");
    public static final TagKey<Block> UNKNOWN_CROPS = bindBlockTag("unknown_crops");
    
    // Mob Effects
    public static final TagKey<MobEffect> UNOBTAINABLE_FROM_PANETTONE = bindEffectTag("unobtainable_from_panettone");

    // Damage Tags
    public static final TagKey<DamageType> TRIGGERS_SURGE = bindDamageTag("triggers_surge");
    public static final ResourceKey<DamageType> FALLING_COCONUT = bindDamageType("falling_coconut");
    public static final ResourceKey<DamageType> CANDY = bindDamageType("candy");
    public static final ResourceKey<DamageType> MONSTER_FOOD = bindDamageType("monster_food");
    public static final ResourceKey<DamageType> POW_CAKE = bindDamageType("pow_cake");
    public static final ResourceKey<DamageType> SPICY = bindDamageType("spicy");
    public static final ResourceKey<DamageType> TAFFY = bindDamageType("taffy");


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

    private static TagKey<Item> bindItemForgeTag(String name) {
        return ItemTags.create(createForgeResourceLocation(name));
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