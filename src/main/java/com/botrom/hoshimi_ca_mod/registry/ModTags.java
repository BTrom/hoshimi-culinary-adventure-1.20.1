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

    // Item Tags
    public static final TagKey<Item> CHIEFTAIN_CRAB_FOOD = bindItemTag("chieftain_crab_food");
    public static final TagKey<Item> CRAB_TEMPT_ITEM = bindItemTag("crab_tempt_item");
    public static final TagKey<Item> CRAB_TRAP_BAIT = bindItemTag("crab_trap_bait");
    public static final TagKey<Item> CREATURE_CHUMS = bindItemTag("creature_chums");
    public static final TagKey<Item> CATFISH_ITEM_FASCINATIONS = bindItemTag("catfish_item_fascinations");
    public static final TagKey<Item> MIMIC_OCTOPUS_CREEPER_ITEMS = bindItemTag("mimic_octopus_creeper_items");
    public static final TagKey<Item> MIMIC_OCTOPUS_GUARDIAN_ITEMS = bindItemTag("mimic_octopus_guardian_items");
    public static final TagKey<Item> MIMIC_OCTOPUS_PUFFERFISH_ITEMS = bindItemTag("mimic_octopus_pufferfish_items");
    public static final TagKey<Item> MIMIC_OCTOPUS_BREEDABLES = bindItemTag("mimic_octopus_breedables");
    public static final TagKey<Item> MIMIC_OCTOPUS_TAMEABLES = bindItemTag("mimic_octopus_tameables");
    public static final TagKey<Item> MIMIC_OCTOPUS_ATTACK_FOODS = bindItemTag("mimic_octopus_attack_foods");
    public static final TagKey<Item> MIMIC_OCTOPUS_TOGGLES_MIMIC = bindItemTag("mimic_octopus_toggles_mimic");
    public static final TagKey<Item> MIMIC_OCTOPUS_MOISTURIZES = bindItemTag("mimic_octopus_moisturizes");
    public static final TagKey<Item> SEAGULL_BREEDABLES = bindItemTag("seagull_breedables");
    public static final TagKey<Item> SEAGULL_OFFERINGS = bindItemTag("seagull_offerings");
    public static final TagKey<Item> CROW_BREEDABLES = bindItemTag("crow_breedables");
    public static final TagKey<Item> CROW_FOODSTUFFS = bindItemTag("crow_foodstuffs");
    public static final TagKey<Item> CROW_TAMEABLES = bindItemTag("crow_tameables");
    public static final TagKey<Item> HUMMINGBIRD_BREEDABLES = bindItemTag("hummingbird_breedables");
    public static final TagKey<Item> HUMMINGNBIRD_FEEDER_SWEETENERS = bindItemTag("hummingnbird_feeder_sweeteners");
    public static final TagKey<Item> MANTIS_SHRIMP_BREEDABLES = bindItemTag("mantis_shrimp_breedables");
    public static final TagKey<Item> MANTIS_SHRIMP_TAMEABLES = bindItemTag("mantis_shrimp_tameables");
    public static final TagKey<Item> SHRIMP_RICE_FRYABLES = bindItemTag("shrimp_rice_fryables");
    public static final TagKey<Item> TERRAPIN_BREEDABLES = bindItemTag("terrapin_breedables");
    public static final TagKey<Item> FEEDING_TROUGH_FODDER = bindItemTag("feeding_trough_fodder");
//    public static final TagKey<Item> CROCK_POTS = bindItemTag("crock_pots");
    public static final TagKey<Item> PARROT_EGGS = bindItemTag("parrot_eggs");
    public static final TagKey<Item> CRAB_ITEMS = bindItemTag("crabs");
    public static final TagKey<Item> BIRD_FOOD_ITEMS = bindItemTag("bird_food_items");
    public static final TagKey<Item> LIZARD_TEMPT_ITEMS = bindItemTag("lizard_tempt_items");
    public static final TagKey<Item> TORTOISE_TEMPT_ITEMS = bindItemTag("tortoise_tempt_items");
    public static final TagKey<Item> FERMENTABLE = bindItemTag("fermentable");
    public static final TagKey<Item> ICE_CREAM = bindItemTag("ice_cream");
    public static final TagKey<Item> ICE_CUBES = bindItemForgeTag("ice_cubes");
    public static final TagKey<Item> CONTAINER_ITEMS = bindItemForgeTag("container_items");
    public static final TagKey<Item> SMALL_WATER_FILL = bindItemForgeTag("small_water_fill");
    public static final TagKey<Item> LARGE_WATER_FILL = bindItemForgeTag("large_water_fill");
    public static final TagKey<Item> HEAT_ITEMS = bindItemForgeTag("heat_items");
    public static final TagKey<Item> CAN_BE_SALTED = bindItemTag("can_be_salted");
    public static final TagKey<Item> FORGE_SALTS = bindItemForgeTag("salts");
    public static final TagKey<Item> FORGE_TORCHES = bindItemForgeTag("torches");
    public static final TagKey<Item> NAUTILUS_TAMING_ITEMS = bindItemTag("nautilus_taming_items");
    public static final TagKey<Item> NAUTILUS_FOOD = bindItemTag("nautilus_food");
    public static final TagKey<Item> NAUTILUS_BUCKET_FOOD = bindItemTag("nautilus_bucket_food");
    public static final TagKey<Item> PALE_OAK_LOGS_ITEMS = bindItemTag("pale_oak_logs");
    public static final TagKey<Item> HAPPY_GHAST_TEMPT_ITEMS = bindItemTag("happy_ghast_tempt_items");
    public static final TagKey<Item> HAPPY_GHAST_FOOD = bindItemTag("happy_ghast_food");
    public static final TagKey<Item> HARNESSES = bindItemTag("harnesses");
    public static final TagKey<Item> ARMADILLO_FOOD = bindItemTag("armadillo_food");

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
    public static final TagKey<Block> CATFISH_BLOCK_FASCINATIONS = bindBlockTag("catfish_block_fascinations");
    public static final TagKey<Block> LOBSTER_SPAWNS = bindBlockTag("lobster_spawns");
    public static final TagKey<Block> MIMIC_OCTOPUS_SPAWNS = bindBlockTag("mimic_octopus_spawns");
    public static final TagKey<Block> CACHALOT_WHALE_BREAKABLES = bindBlockTag("cachalot_whale_breakables");
    public static final TagKey<Block> CROCODILE_SPAWNS = bindBlockTag("crocodile_spawns");
    public static final TagKey<Block> CROW_FEARS = bindBlockTag("crow_fears");
    public static final TagKey<Block> CROW_FOODBLOCKS = bindBlockTag("crow_foodblocks");
    public static final TagKey<Block> CROW_HOME_BLOCKS = bindBlockTag("crow_home_blocks");
    public static final TagKey<Block> HUMMINGBIRD_POLLINATES = bindBlockTag("hummingbird_pollinates");
    public static final TagKey<Block> HUMMINGBIRD_SPAWNS = bindBlockTag("hummingbird_spawns");
    public static final TagKey<Block> MANTIS_SHRIMP_SPAWNS = bindBlockTag("mantis_shrimp_spawns");
    public static final TagKey<Block> ORCA_BREAKABLES = bindBlockTag("orca_breakables");
    public static final TagKey<Block> COOKING_POTS = bindBlockTag("cooking_pots");
    public static final TagKey<Block> ALLOWS_COOKING = bindBlockTag("allows_cooking");
    public static final TagKey<Block> WILD_CROPS = bindBlockTag("wild_crops");
    public static final TagKey<Block> CROCK_POTS = bindBlockTag("crock_pots");
    public static final TagKey<Block> UNKNOWN_CROPS = bindBlockTag("unknown_crops");
    public static final TagKey<Block> CRAB_DIGGABLE_BLOCKS = bindBlockTag("crab_diggable_blocks");
    public static final TagKey<Block> CRAB_SPAWN_BLOCKS = bindBlockTag("crab_spawn_blocks");
    public static final TagKey<Block> CRAB_COMFORT_BLOCKS = bindBlockTag("crab_comfort_blocks");
    public static final TagKey<Block> BUTTERFLIES_SPAWNABLE_ON = bindBlockTag("butterflies_spawnable_on");
    public static final TagKey<Block> TORTOISE_EGG_LAYABLE_ON = bindBlockTag("tortoise_egg_layable_on");
    public static final TagKey<Block> CATTAIL_PLACEABLE = bindBlockTag("cattail_placeable");
    public static final TagKey<Block> VANILLA_PLANTABLE_ON = bindBlockTag("vanilla_plantable_on");
    public static final TagKey<Block> UNAFFECTED_BY_MINT = bindBlockTag("unaffected_by_mint");
    public static final TagKey<Block> HEATERS = bindBlockTag("heaters");
    public static final TagKey<Block> SALT_CLUSTER_GROWABLES = bindBlockTag("salt_cluster_growables");
    public static final TagKey<Block> SALT_DISSOLVABLES = bindBlockTag("salt_dissolvables");
    public static final TagKey<Block> MELTABLES = bindBlockTag("meltables");
    public static final TagKey<Block> SALT_CLUSTER_REPLACEABLES = bindBlockTag("salt_cluster_replaceables");
    public static final TagKey<Block> PALE_OAK_LOGS_BLOCKS = bindBlockTag("pale_oak_logs");
    public static final TagKey<Block> HAPPY_GHAST_AVOIDS = bindBlockTag("happy_ghast_avoids");
    public static final TagKey<Block> TRIGGERS_AMBIENT_DESERT_SAND_BLOCK_SOUNDS = bindBlockTag("triggers_ambient_desert_sand_block_sounds");
    public static final TagKey<Block> TRIGGERS_AMBIENT_DESERT_DRY_VEGETATION_BLOCK_SOUNDS = bindBlockTag("triggers_ambient_desert_dry_vegetation_block_sounds");
    public static final TagKey<Block> TRIGGERS_AMBIENT_DRIED_GHAST_BLOCK_SOUNDS = bindBlockTag("triggers_ambient_dried_ghast_block_sounds");
    public static final TagKey<Block> ALLOWS_LEAF_LITTER = bindBlockTag("allows_leaf_litter");
    public static final TagKey<Block> SPAWN_FALLING_LEAVES = bindBlockTag("spawn_falling_leaves");
    public static final TagKey<Block> SPAWN_FALLING_NEEDLES = bindBlockTag("spawn_falling_needles");
    public static final TagKey<Block> ARMADILLO_SPAWNABLE_ON = bindBlockTag("armadillo_spawnable_on");
    public static final TagKey<Block> COPPER = bindBlockTag("copper");
    public static final TagKey<Block> COPPER_CHESTS = bindBlockTag("copper_chests");


    // Mob Effects
    public static final TagKey<MobEffect> UNOBTAINABLE_FROM_PANETTONE = bindEffectTag("unobtainable_from_panettone");
    public static final TagKey<MobEffect> UNAFFECTED_BY_VANILLA_SCENT = bindEffectTag("unaffected_by_vanilla_scent");


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
    public static final TagKey<EntityType<?>> MANTIS_SHRIMP_TARGETS = bindEntityTag("mantis_shrimp_targets");
    public static final TagKey<EntityType<?>> CACHALOT_WHALE_TARGETS = bindEntityTag("cachalot_whale_targets");
    public static final TagKey<EntityType<?>> IS_WOLF = bindEntityTag("is_wolf");
    public static final TagKey<EntityType<?>> SAFE_EGG_WALKERS = bindEntityTag("safe_egg_walkers");
    public static final TagKey<EntityType<?>> UNAFFECTED_BY_SLIPPING = bindEntityTag("unaffected_by_slipping");
    public static final TagKey<EntityType<?>> UNAFFECTED_BY_HARMONY = bindEntityTag("unaffected_by_harmony");
    public static final TagKey<EntityType<?>> NAUTILUS_HOSTILES = bindEntityTag("nautilus_hostiles");
    public static final TagKey<EntityType<?>> FOLLOWABLE_FRIENDLY_MOBS = bindEntityTag("followable_friendly_mobs");


    // Biome Tags
    public static final TagKey<Biome> SPAWNS_HUGE_CATFISH = bindBiomeTag("spawns_huge_catfish");
    public static final TagKey<Biome> SPAWNS_WHITE_MANTIS_SHRIMP = bindBiomeTag("spawns_white_mantis_shrimp");
    public static final TagKey<Biome> HAS_BUTTERFLY = bindBiomeTag("has_butterfly");
    public static final TagKey<Biome> HAS_CARDINAL = bindBiomeTag("has_cardinal");
    public static final TagKey<Biome> HAS_SPARROW = bindBiomeTag("has_sparrow");
    public static final TagKey<Biome> HAS_TORTOISE = bindBiomeTag("has_tortoise");
    public static final TagKey<Biome> HAS_SNAIL = bindBiomeTag("has_snail");
    public static final TagKey<Biome> HAS_LIZARD = bindBiomeTag("has_lizard");
    public static final TagKey<Biome> HAS_VANILLA_VINE = bindBiomeTag("has_feature/vanilla_vine");
    public static final TagKey<Biome> HAS_MINT_POND = bindBiomeTag("has_feature/mint_pond");
    public static final TagKey<Biome> HAS_COMMON_BANANA_PLANT = bindBiomeTag("has_feature/banana_plant/common");
    public static final TagKey<Biome> HAS_UNCOMMON_BANANA_PLANT = bindBiomeTag("has_feature/banana_plant/uncommon");
    public static final TagKey<Biome> HAS_RARE_BANANA_PLANT = bindBiomeTag("has_feature/banana_plant/rare");
    public static final TagKey<Biome> BANANA_PLANT_REQUIRES_SAND = bindBiomeTag("banana_plant_requires_sand");
    public static final TagKey<Biome> HAS_ROCK_SALT_DEPOSITS = bindBiomeTag("has_rock_salt_deposits");
    public static final TagKey<Biome> SPAWNS_WARM_VARIANT_FARM_ANIMALS = bindBiomeTag("spawns_warm_variant_farm_animals");
    public static final TagKey<Biome> SPAWNS_COLD_VARIANT_FARM_ANIMALS = bindBiomeTag("spawns_cold_variant_farm_animals");
    public static final TagKey<Biome> SPAWNS_ARMADILLOS_FREQUENTLY = bindBiomeTag("spawns_armadillos_frequently");
    public static final TagKey<Biome> SPAWNS_ARMADILLOS = bindBiomeTag("spawns_armadillos");
    public static final TagKey<Biome> SPAWNS_BUSHES = bindBiomeTag("spawns_bushes");
    public static final TagKey<Biome> SPAWNS_FIREFLY_BUSHES = bindBiomeTag("spawns_firefly_bushes");
    public static final TagKey<Biome> SPAWNS_FIREFLY_BUSHES_SWAMP = bindBiomeTag("spawns_firefly_bushes_swamp");
    public static final TagKey<Biome> SPAWNS_WILDFLOWERS = bindBiomeTag("spawns_wildflowers");
    public static final TagKey<Biome> SPAWNS_NOISE_BASED_WILDFLOWERS = bindBiomeTag("spawns_noise_based_wildflowers");
    public static final TagKey<Biome> SPAWNS_DRY_GRASS = bindBiomeTag("spawns_dry_grass");
    public static final TagKey<Biome> SPAWNS_DRY_GRASS_RARELY = bindBiomeTag("spawns_dry_grass_rarely");
    public static final TagKey<Biome> SPAWNS_FALLEN_OAK_TREES = bindBiomeTag("spawns_fallen_oak_trees");
    public static final TagKey<Biome> SPAWNS_FALLEN_BIRCH_TREES = bindBiomeTag("spawns_fallen_birch_trees");
    public static final TagKey<Biome> SPAWNS_FALLEN_BIRCH_TREES_RARELY = bindBiomeTag("spawns_fallen_birch_trees_rarely");
    public static final TagKey<Biome> SPAWNS_FALLEN_SUPER_BIRCH_TREES = bindBiomeTag("spawns_fallen_super_birch_trees");
    public static final TagKey<Biome> SPAWNS_FALLEN_JUNGLE_TREES = bindBiomeTag("spawns_fallen_jungle_trees");
    public static final TagKey<Biome> SPAWNS_FALLEN_SPRUCE_TREES = bindBiomeTag("spawns_fallen_spruce_trees");
    public static final TagKey<Biome> SPAWNS_FALLEN_SPRUCE_TREES_RARELY = bindBiomeTag("spawns_fallen_spruce_trees_rarely");
    public static final TagKey<Biome> SPAWNS_LEAF_LITTER = bindBiomeTag("spawns_leaf_litter");
    public static final TagKey<Biome> SPAWNS_LEAF_LITTER_PATCHES = bindBiomeTag("spawns_leaf_litter_patches");

    // TODO: Try to add Neapolitan's Strawberry Fields


    // Registry
    private static TagKey<Item> bindItemTag(String name) {
        return ItemTags.create(createResourceLocation(name));
    }

    private static TagKey<Item> bindItemForgeTag(String name) {
        return ItemTags.create(createForgeResourceLocation(name));
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