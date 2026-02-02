package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.*;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blocks.*;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blocks.crops.SimpleCropBlock;
import com.botrom.hoshimi_ca_mod.worldgen.tree.PaleOakTreeGrower;
import com.botrom.hoshimi_ca_mod.worldgen.tree.PalmTreeGrower;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.cauldron.CauldronInteraction;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.food.FoodProperties;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.NoteBlockInstrument;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import vectorwing.farmersdelight.common.block.PieBlock;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;

import java.util.function.Supplier;
import java.util.function.ToIntFunction;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HoshimiCulinaryMod.MOD_ID);


    // Wild Plants
    public static final RegistryObject<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers", () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_EGGPLANTS = registerBlock("wild_eggplants", () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> LIME_BUSH = registerBlockWithoutBlockItem("lime_bush", () -> new LimeBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).forceSolidOff().instabreak().sound(SoundType.SWEET_BERRY_BUSH).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> DRAGON_BUSH = registerBlock("dragon_bush", () -> new WildCropBlock(MobEffects.GLOWING, 6, BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_TEA_BUSH = registerBlock("wild_tea_bush", () -> new WildTeaBushBlock(Block.Properties.of().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> WILD_CORN = registerBlock("wild_corn", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<Block> WILD_STRAWBERRIES = registerBlock("wild_strawberries", () -> new TallGrassBlock(BlockBehaviour.Properties.copy(Blocks.AZURE_BLUET)));
    public static final RegistryObject<Block> WILD_COTTON = BLOCKS.register("wild_cotton", () -> new WildCropBlock(MobEffects.JUMP, 5, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_COFFEE = BLOCKS.register("wild_coffee", () -> new WildCropBlock(MobEffects.DIG_SPEED, 8, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> CATTAIL = registerBlock("cattail", () -> new TallFlowerBlock(BlockBehaviour.Properties.copy(Blocks.ROSE_BUSH)));
    public static final RegistryObject<Block> WILD_OATS = registerBlock("wild_oats", () -> new WildCropBlock(MobEffects.SATURATION, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_PEANUTS = registerBlock("wild_peanuts", () -> new WildCropBlock(MobEffects.DAMAGE_RESISTANCE, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_ROOIBOS_PLANT = registerBlock("wild_rooibos_plant", () -> new FlowerBlock(MobEffects.HEAL, 1, BlockBehaviour.Properties.copy(Blocks.DANDELION)));
    public static final RegistryObject<Block> PINEAPPLE_WILD_CROP = registerBlock("pineapple_wild_crop", () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6, Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> OPEN_EYEBLOSSOM = BLOCKS.register("open_eyeblossom", () -> new EyeblossomBlock(EyeblossomBlock.Type.OPEN, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> CLOSED_EYEBLOSSOM = BLOCKS.register("closed_eyeblossom", () -> new EyeblossomBlock(EyeblossomBlock.Type.CLOSED, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().instabreak().sound(SoundType.GRASS).offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> BUSH = BLOCKS.register("bush", () -> new BushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FIREFLY_BUSH = BLOCKS.register("firefly_bush", () -> new FireflyBushBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).ignitedByLava().lightLevel(state -> 2).noCollission().instabreak().sound(SoundType.SWEET_BERRY_BUSH).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WILDFLOWERS = BLOCKS.register("wildflowers", () -> new PinkPetalsBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().sound(SoundType.PINK_PETALS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LEAF_LITTER = BLOCKS.register("leaf_litter", () -> new LeafLitterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_BROWN).replaceable().noCollission().sound(ModSounds.LEAF_LITTER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CACTUS_FLOWER = BLOCKS.register("cactus_flower", () -> new CactusFlowerBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().instabreak().ignitedByLava().sound(ModSounds.CACTUS_FLOWER).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SHORT_DRY_GRASS = BLOCKS.register("short_dry_grass", () -> new ShortDryGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> TALL_DRY_GRASS = BLOCKS.register("tall_dry_grass", () -> new TallDryGrassBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_YELLOW).replaceable().noCollission().instabreak().sound(SoundType.GRASS).ignitedByLava().offsetType(BlockBehaviour.OffsetType.XYZ).pushReaction(PushReaction.DESTROY)));


    // Fauna
    public static RegistryObject<Block> ANEMONE_ROSE_BULB  = registerBlock("anemone_rose_bulb", () -> new AnemoneBlock(Block.Properties.of().mapColor(MapColor.COLOR_RED).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).destroyTime(0.1F).sound(SoundType.SLIME_BLOCK)));
    public static RegistryObject<Block> ANEMONE_SAND  = registerBlock("anemone_sand", () -> new AnemoneBlock(Block.Properties.of().mapColor(MapColor.COLOR_PINK).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).destroyTime(0.1F).sound(SoundType.SLIME_BLOCK)));
    public static RegistryObject<Block> ANEMONE_SEBAE  = registerBlock("anemone_sebae", () -> new AnemoneBlock(Block.Properties.of().mapColor(MapColor.TERRACOTTA_WHITE).noCollission().noOcclusion().pushReaction(PushReaction.DESTROY).destroyTime(0.1F).sound(SoundType.SLIME_BLOCK)));


    // Crops
    public static final RegistryObject<Block> CUCUMBERS = registerBlockWithoutBlockItem("cucumbers", () -> new SimpleCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT), ModItems.CUCUMBER_SEEDS));
    public static final RegistryObject<Block> EGGPLANTS = registerBlockWithoutBlockItem("eggplants", () -> new EggplantCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> CORN_BOTTOM = registerBlockWithoutBlockItem("corn_bottom", () -> new CornBottomBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> CORN_UPPER = registerBlockWithoutBlockItem("corn_upper", () -> new CornUpperBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> BROCCOLI = registerBlock("broccoli", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.BROCCOLI_SEEDS));
    public static final RegistryObject<Block> PEPPERS = registerBlock("peppers", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.PEPPER_SEEDS));
    public static final RegistryObject<Block> PINEAPPLE = registerBlock("pineapple", () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.PINEAPPLE_SEEDS));
    public static final RegistryObject<Block> BUDDING_DRAGON_FRUIT_CROP = registerBlockWithoutBlockItem("budding_dragon_fruits", () -> new BuddingDragonFruitBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> DRAGON_FRUIT_CROP = registerBlockWithoutBlockItem("dragon_fruits", () -> new DragonFruitVineBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GREEN_ONIONS = registerBlockWithoutBlockItem("green_onions", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> GARLICS = registerBlockWithoutBlockItem("garlics", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> PEANUT_PLANT = registerBlockWithoutBlockItem("peanuts", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> SQUASHES = registerBlockWithoutBlockItem("squashes", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> TEA_BUSH = registerBlockWithoutBlockItem("tea_bush", () -> new TeaBushBlock(Block.Properties.of().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> SMALL_TEA_BUSH = registerBlockWithoutBlockItem("small_tea_bush", () -> new SmallTeaBushBlock(Block.Properties.of().instabreak().sound(SoundType.GRASS).noOcclusion()));
    public static final RegistryObject<Block> OAT_CROP = registerBlockWithoutBlockItem("oat_crop", () -> new OatCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> STRAWBERRY_CROP = registerBlockWithoutBlockItem("strawberry_crop", () -> new StrawberryCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));
    public static final RegistryObject<Block> COTTON_CROP = BLOCKS.register("cotton", () -> new CottonCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> COFFEE_CROP = BLOCKS.register("coffee", () -> new CoffeeCropBlock(BlockBehaviour.Properties.copy(Blocks.CARROTS).noOcclusion().noCollission()));
    public static final RegistryObject<Block> UNKNOWN_CROPS = BLOCKS.register("unknown_crops", UnknownCropsBlock::new);
    public static final RegistryObject<Block> ASPARAGUS = BLOCKS.register("asparaguses", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> PEAS = BLOCKS.register("peas", () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().pushReaction(PushReaction.DESTROY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> CHILI_PEPPERS = BLOCKS.register("chili_peppers", () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().pushReaction(PushReaction.DESTROY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> SOYBEANS = BLOCKS.register("soybeans", () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().pushReaction(PushReaction.DESTROY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> SWEET_POTATOES = BLOCKS.register("sweet_potatoes", () -> new CropBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().randomTicks().instabreak().pushReaction(PushReaction.DESTROY).sound(SoundType.CROP)));
    public static final RegistryObject<Block> VANILLA_VINE = BLOCKS.register("vanilla_vine", () -> new VanillaVineTopBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).randomTicks().instabreak().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> VANILLA_VINE_PLANT = BLOCKS.register("vanilla_vine_plant", () -> new VanillaVineBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).randomTicks().instabreak().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> MINT = BLOCKS.register("mint", () -> new MintBlock(BlockBehaviour.Properties.of().mapColor(MapColor.PLANT).noCollission().instabreak().randomTicks().sound(SoundType.CROP).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> GRAPES = BLOCKS.register("grape_crop", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> BLACK_PEPPER = BLOCKS.register("black_pepper_crop", () -> new CropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> ROOIBOS_PLANT = BLOCKS.register("rooibos_plant", () -> new CottonCropBlock(BlockBehaviour.Properties.copy(Blocks.SWEET_BERRY_BUSH)));


    // Saplings
//    public static final RegistryObject<Block> AVOCADO_SEED = registerBlock("avocado_pit", () -> new AvocadoSeedBlock(new AvocadoPitGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), false, 0);
    public static final RegistryObject<Block> PALM_SAPLING = BLOCKS.register("palm_sapling", () -> new PalmSaplingBlock(new PalmTreeGrower(), Block.Properties.copy(Blocks.OAK_SAPLING), () -> Blocks.SAND));
    public static final RegistryObject<Block> PALE_OAK_SAPLING = BLOCKS.register("pale_oak_sapling", () -> new SaplingBlock(new PaleOakTreeGrower(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().randomTicks().instabreak().sound(SoundType.GRASS).pushReaction(PushReaction.DESTROY)));


    // Tree Blocks
    public static final RegistryObject<Block> PALM_LOG = registerBlock("palm_log", () -> new PalmLogBlock(Block.Properties.copy(Blocks.JUNGLE_LOG)));
    public static final RegistryObject<Block> PALM_WOOD = registerBlock("palm_wood", () -> new PalmLogBlock(Block.Properties.copy(Blocks.JUNGLE_WOOD)));
    public static final RegistryObject<Block> STRIPPED_PALM_LOG = registerBlock("stripped_palm_log", () -> new PalmLogBlock(Block.Properties.copy(Blocks.STRIPPED_JUNGLE_LOG)));
    public static final RegistryObject<Block> STRIPPED_PALM_WOOD = registerBlock("stripped_palm_wood", () -> new PalmLogBlock(Block.Properties.copy(Blocks.STRIPPED_JUNGLE_WOOD)));
    public static final RegistryObject<Block> PALM_LEAVES = registerBlock("palm_leaves", () -> new PalmLeavesBlock(Block.Properties.copy(Blocks.OAK_LEAVES)));
    public static final RegistryObject<Block> PALE_OAK_LEAVES = BLOCKS.register("pale_oak_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_GREEN).strength(0.2F).randomTicks().sound(SoundType.GRASS).noOcclusion().isSuffocating(ModBlocks::never).isViewBlocking(ModBlocks::never).ignitedByLava().pushReaction(PushReaction.DESTROY).isRedstoneConductor(ModBlocks::never)));
    public static final RegistryObject<Block> PALE_OAK_WOOD = BLOCKS.register("pale_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> PALE_OAK_LOG = BLOCKS.register("pale_oak_log", () -> new RotatedPillarBlock(logProperties(MapColor.QUARTZ, MapColor.STONE, SoundType.WOOD)));
    public static final RegistryObject<Block> STRIPPED_PALE_OAK_WOOD = BLOCKS.register("stripped_pale_oak_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> STRIPPED_PALE_OAK_LOG = BLOCKS.register("stripped_pale_oak_log", () -> new RotatedPillarBlock(logProperties(MapColor.QUARTZ, MapColor.QUARTZ, SoundType.WOOD)));


    // Block Sets and Types
    public static final BlockSetType PALE_OAK_BLOCK_SET = new BlockSetType("pale_oak");
    public static final Supplier<BlockSetType> COPPER = () -> new BlockSetType("copper", true, SoundType.COPPER,
            ModSounds.COPPER_DOOR_CLOSE_SOUND.get(),
            ModSounds.COPPER_DOOR_OPEN_SOUND.get(),
            ModSounds.COPPER_TRAPDOOR_CLOSE_SOUND.get(),
            ModSounds.COPPER_TRAPDOOR_OPEN_SOUND.get(),
            SoundEvents.METAL_PRESSURE_PLATE_CLICK_OFF,
            SoundEvents.METAL_PRESSURE_PLATE_CLICK_ON,
            SoundEvents.STONE_BUTTON_CLICK_OFF,
            SoundEvents.STONE_BUTTON_CLICK_ON
    );
    public static final WoodType PALE_OAK_WOOD_TYPE = new WoodType("pale_oak", PALE_OAK_BLOCK_SET);


    // Blocks
    public static final RegistryObject<Block> CORN_COB_CRATE = registerBlock("corn_crate", () -> new Block(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get())));
    public static final RegistryObject<Block> PIZZA_STATION = registerBlock("pizza_station", () -> new PizzaStationBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> PIZZA_OVEN = registerBlock("pizza_oven", () -> new OvenBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F).noOcclusion().lightLevel(getLightValueLit(9))));
    public static final RegistryObject<Block> GRANITE_BASIN = registerBlock("granite_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.DIRT).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> DIORITE_BASIN = registerBlock("diorite_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> ANDESITE_BASIN = registerBlock("andesite_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> BASALT_BASIN = registerBlock("basalt_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).strength(1.25F, 4.2F).sound(SoundType.BASALT)));
    public static final RegistryObject<Block> BLACKSTONE_BASIN = registerBlock("blackstone_basin", () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> COCONUT = registerBlock("coconut", () -> new CoconutBlock(Block.Properties.copy(Blocks.COCOA)));
    public static final RegistryObject<Block> SEASHELLS = registerBlock("seashells", () -> new SeashellBlock(Block.Properties.copy(Blocks.HORN_CORAL).offsetType(BlockBehaviour.OffsetType.XZ)));
    public static final RegistryObject<Block> CRAB_TRAP = registerBlock("crab_trap", () -> new CrabTrapBlock(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> HUMMINGBIRD_FEEDER = registerBlock("hummingbird_feeder", BlockHummingbirdFeeder::new);
    public static final RegistryObject<Block> TERRAPIN_EGG = registerBlock("terrapin_egg", BlockTerrapinEgg::new);
    public static final RegistryObject<Block> RAINBOW_GLASS = registerBlock("rainbow_glass", BlockRainbowGlass::new);
    public static final RegistryObject<Block> COFFEE_BEANS_SACK = registerBlock("coffee_beans_sack", () -> new Block(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get())));
    public static final RegistryObject<Block> FEEDING_TROUGH = registerBlock("feeding_trough", () -> new FeedingTroughBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> PET_BOWL = registerBlock("pet_bowl", () -> new PetBowlBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS).strength(1.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHICKEN_NEST = registerBlock("chicken_nest", () -> new ChickenNestBlock(BlockBehaviour.Properties.copy(Blocks.GRASS_BLOCK).noCollission().instabreak()));
    public static final RegistryObject<Block> STOVE = registerBlock("stove", () -> new StoveBlock(BlockBehaviour.Properties.copy(Blocks.BRICKS).lightLevel(state -> state.getValue(StoveBlock.LIT) ? 13 : 0)));
    public static final RegistryObject<Block> DOG_FOOD_BAG = registerBlock("dog_food_bag", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.CYAN_CARPET), 3));
    public static final RegistryObject<Block> CAT_FOOD_BAG = registerBlock("cat_food_bag", () -> new StackableBlock(BlockBehaviour.Properties.copy(Blocks.PINK_CARPET), 3));
    public static final RegistryObject<Block> COTTON_BOLL_CRATE = registerBlock("cotton_boll_crate", () -> new Block(Block.Properties.copy(Blocks.OAK_PLANKS).strength(2.0F, 3.0F).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> DEEP_FRYING_PAN = registerBlock("deep_frying_pan", () -> new DeepFryingPan(BlockBehaviour.Properties.of().mapColor(MapColor.METAL).strength(0.5F, 6.0F).sound(SoundType.LANTERN)));
    public static final RegistryObject<Block> CROCK_POT = BLOCKS.register("crock_pot", () -> new CrockPotBlock(0));
    public static final RegistryObject<Block> PORTABLE_CROCK_POT = BLOCKS.register("portable_crock_pot", () -> new CrockPotBlock(1));
    public static final RegistryObject<Block> BIRDCAGE = BLOCKS.register("birdcage", BirdcageBlock::new);
    public static final RegistryObject<Block> EYE_BONE = BLOCKS.register("eye_bone", EyeBoneBlock::new);
    public static final RegistryObject<Block> TORTOISE_EGG = BLOCKS.register("tortoise_egg", () -> new TortoiseEggBlock(BlockBehaviour.Properties.copy(Blocks.TURTLE_EGG)));
    public static final RegistryObject<Block> SNAIL_EGGS = BLOCKS.register("snail_eggs", () -> new SnailEggBlock(BlockBehaviour.Properties.copy(Blocks.FROGSPAWN)));
    public static final RegistryObject<Block> GLOW_GOOP_BLOCK = BLOCKS.register("glow_goop", () -> new GlowGoopBlock(BlockBehaviour.Properties.of().strength(0.5F).replaceable().noOcclusion().noCollission().lightLevel(GlowGoopBlock.LIGHT_EMISSION).sound(SoundType.HONEY_BLOCK)));
    public static final RegistryObject<Block> CHRYSALIS_BLOCK = BLOCKS.register("chrysalis", () -> new ChrysalisBlock(BlockBehaviour.Properties.of().randomTicks().strength(0.2F, 3.0F).sound(SoundType.GRASS).noOcclusion().noCollission().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> FERMENTER = BLOCKS.register("fermenter", () -> new FermenterBlock(BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(3.5F).noOcclusion().requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> SMALL_BANANA_FROND = BLOCKS.register("small_banana_frond", () -> new BananaFrondBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).randomTicks().instabreak().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> BANANA_FROND = BLOCKS.register("banana_frond", () -> new BananaFrondBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).randomTicks().instabreak().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> LARGE_BANANA_FROND = BLOCKS.register("large_banana_frond", () -> new BananaFrondBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GREEN).randomTicks().instabreak().noCollission().sound(SoundType.WEEPING_VINES).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_BANANA_FROND = BLOCKS.register("potted_banana_frond", () -> new FlowerPotBlock(SMALL_BANANA_FROND.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_VANILLA_VINE = BLOCKS.register("potted_vanilla_vine", () -> new FlowerPotBlock(VANILLA_VINE.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_MINT = BLOCKS.register("potted_mint", () -> new FlowerPotBlock(MINT.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> SANDCASTLE = BLOCKS.register("sandcastle", SandcastleBlock::new);
    public static final RegistryObject<Block> TEA_KETTLE = BLOCKS.register("tea_kettle", () -> new TeaKettleBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> COPPER_TEA_KETTLE = BLOCKS.register("copper_tea_kettle", () -> new TeaKettleBlock(BlockBehaviour.Properties.copy(Blocks.IRON_BLOCK)));
    public static final RegistryObject<Block> TEA_LEAF_CRATE = BLOCKS.register("tea_leaf_crate", () -> new Block(BlockBehaviour.Properties.copy(Blocks.RED_WOOL)));
    public static final RegistryObject<Block> ROCK_SALT_ORE = BLOCKS.register("rock_salt_ore", () -> new SaltBlock(Blocks.STONE.defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).randomTicks().strength(2.5F).requiresCorrectToolForDrops().sound(ModSounds.SALT)));
    public static final RegistryObject<Block> DEEPSLATE_ROCK_SALT_ORE = BLOCKS.register("deepslate_rock_salt_ore", () -> new SaltBlock(net.minecraft.world.level.block.Blocks.DEEPSLATE.defaultBlockState(), BlockBehaviour.Properties.copy(ROCK_SALT_ORE.get()).mapColor(MapColor.COLOR_GRAY)));
    public static final RegistryObject<Block> RAW_ROCK_SALT_BLOCK = BLOCKS.register("raw_rock_salt_block", () -> new SaltBlock(BlockBehaviour.Properties.copy(ROCK_SALT_ORE.get()).sound(ModSounds.SALT_CLUSTER)));
    public static final RegistryObject<Block> SALT_CLUSTER = BLOCKS.register("salt_cluster", () -> new SaltClusterBlock(7, 3, BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_LIGHT_GRAY).noOcclusion().randomTicks().strength(1.5F).sound(ModSounds.SALT_CLUSTER).lightLevel(state -> 3).dynamicShape()));
    public static final RegistryObject<Block> LARGE_SALT_BUD = BLOCKS.register("large_salt_bud", () -> new SaltClusterBlock(5, 3, BlockBehaviour.Properties.copy(SALT_CLUSTER.get()).lightLevel(state -> 2).sound(ModSounds.LARGE_SALT_BUD)));
    public static final RegistryObject<Block> MEDIUM_SALT_BUD = BLOCKS.register("medium_salt_bud", () -> new SaltClusterBlock(4, 3, BlockBehaviour.Properties.copy(SALT_CLUSTER.get()).lightLevel(state -> 2).sound(ModSounds.MEDIUM_SALT_BUD)));
    public static final RegistryObject<Block> SMALL_SALT_BUD = BLOCKS.register("small_salt_bud", () -> new SaltClusterBlock(3, 4, BlockBehaviour.Properties.copy(SALT_CLUSTER.get()).lightLevel(state -> 1).sound(ModSounds.SMALL_SALT_BUD)));
    public static final RegistryObject<Block> SALT_CAULDRON = BLOCKS.register("salt_cauldron", () -> new SaltCauldronBlock(LayeredCauldronBlock.RAIN, CauldronInteraction.EMPTY));
    public static final RegistryObject<Block> PALE_OAK_PLANKS = BLOCKS.register("pale_oak_planks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> PALE_OAK_STAIRS = BLOCKS.register("pale_oak_stairs", () -> new StairBlock(PALE_OAK_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> PALE_OAK_SLAB = BLOCKS.register("pale_oak_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> PALE_OAK_FENCE = BLOCKS.register("pale_oak_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).sound(SoundType.WOOD).ignitedByLava()));
    public static final RegistryObject<Block> PALE_OAK_FENCE_GATE = BLOCKS.register("pale_oak_fence_gate", () -> new FenceGateBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASS).strength(2.0F, 3.0F).ignitedByLava(), PALE_OAK_WOOD_TYPE));
    public static final RegistryObject<Block> PALE_OAK_DOOR = BLOCKS.register("pale_oak_door", () -> new DoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().ignitedByLava().pushReaction(PushReaction.DESTROY), PALE_OAK_BLOCK_SET));
    public static final RegistryObject<Block> PALE_MOSS_BLOCK = BLOCKS.register("pale_moss_block", () -> new PaleMossBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PALE_MOSS_CARPET = BLOCKS.register("pale_moss_carpet", () -> new MossyCarpetBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GRAY).strength(0.1F).sound(SoundType.MOSS).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PALE_HANGING_MOSS = BLOCKS.register("pale_hanging_moss", () -> new HangingMossBlock(BlockBehaviour.Properties.of().ignitedByLava().mapColor(MapColor.COLOR_LIGHT_GRAY).noCollission().sound(SoundType.MOSS_CARPET).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> POTTED_OPEN_EYEBLOSSOM = BLOCKS.register("potted_open_eyeblossom", () -> new EyeblossomFlowerPotBlock(OPEN_EYEBLOSSOM.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> POTTED_CLOSED_EYEBLOSSOM = BLOCKS.register("potted_closed_eyeblossom", () -> new EyeblossomFlowerPotBlock(CLOSED_EYEBLOSSOM.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> POTTED_PALE_OAK_SAPLING = BLOCKS.register("potted_pale_oak_sapling", () -> new FlowerPotBlock(PALE_OAK_SAPLING.get(), BlockBehaviour.Properties.of().instabreak().noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> CREAKING_HEART = BLOCKS.register("creaking_heart", () -> new CreakingHeartBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).strength(10.0F).sound(ModSounds.CREAKING_HEART)));
    public static final RegistryObject<Block> PALE_OAK_SIGN = BLOCKS.register("pale_oak_sign", () -> new StandingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), PALE_OAK_WOOD_TYPE));
    public static final RegistryObject<Block> PALE_OAK_WALL_SIGN = BLOCKS.register("pale_oak_wall_sign", () -> new WallSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(PALE_OAK_SIGN.get()), PALE_OAK_WOOD_TYPE));
    public static final RegistryObject<Block> PALE_OAK_HANGING_SIGN = BLOCKS.register("pale_oak_hanging_sign", () -> new CeilingHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava(), PALE_OAK_WOOD_TYPE));
    public static final RegistryObject<Block> PALE_OAK_WALL_HANGING_SIGN = BLOCKS.register("pale_oak_wall_hanging_sign", () -> new WallHangingSignBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(1.0F).ignitedByLava().dropsLike(PALE_OAK_HANGING_SIGN.get()), PALE_OAK_WOOD_TYPE));
    public static final RegistryObject<Block> PALE_OAK_PRESSURE_PLATE = BLOCKS.register("pale_oak_pressure_plate", () -> new PressurePlateBlock(PressurePlateBlock.Sensitivity.EVERYTHING, BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).forceSolidOn().instrument(NoteBlockInstrument.BASS).noCollission().strength(0.5F).ignitedByLava().pushReaction(PushReaction.DESTROY), PALE_OAK_BLOCK_SET));
    public static final RegistryObject<Block> PALE_OAK_TRAPDOOR = BLOCKS.register("pale_oak_trapdoor", () -> new TrapDoorBlock(BlockBehaviour.Properties.of().mapColor(MapColor.QUARTZ).instrument(NoteBlockInstrument.BASS).strength(3.0F).noOcclusion().isValidSpawn(ModBlocks::never).ignitedByLava(), PALE_OAK_BLOCK_SET));
    public static final RegistryObject<Block> PALE_OAK_BUTTON = BLOCKS.register("pale_oak_button", () -> new ButtonBlock(BlockBehaviour.Properties.of().noCollission().strength(0.5F).pushReaction(PushReaction.DESTROY), PALE_OAK_BLOCK_SET, 30, true));
    public static final RegistryObject<Block> RESIN_CLUMP = BLOCKS.register("resin_clump", () -> new ResinClumpBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).replaceable().noCollission().sound(ModSounds.RESIN).ignitedByLava().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> RESIN_BLOCK = BLOCKS.register("resin_block", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).sound(ModSounds.RESIN)));
    public static final RegistryObject<Block> RESIN_BRICKS = BLOCKS.register("resin_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> RESIN_BRICK_STAIRS = BLOCKS.register("resin_brick_stairs", () -> new StairBlock(RESIN_BRICKS.get().defaultBlockState(), BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> RESIN_BRICK_SLAB = BLOCKS.register("resin_brick_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> RESIN_BRICK_WALL = BLOCKS.register("resin_brick_wall", () -> new WallBlock(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> CHISELED_RESIN_BRICKS = BLOCKS.register("chiseled_resin_bricks", () -> new Block(BlockBehaviour.Properties.of().mapColor(MapColor.TERRACOTTA_ORANGE).instrument(NoteBlockInstrument.BASEDRUM).requiresCorrectToolForDrops().sound(ModSounds.RESIN_BRICKS).strength(1.5F, 6.0F)));
    public static final RegistryObject<Block> DRIED_GHAST = BLOCKS.register("dried_ghast", () -> new DriedGhastBlock(BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).instabreak().sound(ModSounds.DRIED_GHAST).noOcclusion().randomTicks()));


    // Meal Blocks
    public static final RegistryObject<Block> EXOTIC_ROLL_MEDLEY = registerBlock("exotic_roll_medley", () -> new ExoticRollMedleyBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get()).noOcclusion()));
    public static final RegistryObject<Block> PAELLA = registerBlock("paella", () -> new PaellaBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.METAL).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> PIZZA = registerBlock("pizza", () -> new PizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> RAW_PIZZA = registerBlock("raw_pizza", () -> new RawPizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DOUGH = registerBlock("pizza_dough", () -> new DoughBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> CHEESE_BLOCK = registerBlock("cheese_block", () -> new CheeseBlock(Block.Properties.copy(Blocks.CAKE).mapColor(MapColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.FUNGUS)));
    public static final RegistryObject<Block> PANETTONE = registerBlockWithoutBlockItem("panettone", () -> new PanettoneBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE.get()), ModItems.PANETTONE_SLICE));
    public static final RegistryObject<Block> MUSHROOM_QUICHE = registerBlockWithoutBlockItem("mushroom_quiche", () -> new PieBlock(Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE.get()), ModItems.MUSHROOM_QUICHE_SLICE));
    public static final RegistryObject<Block> LIME_PIE = registerBlockWithoutBlockItem("lime_pie", () -> new PieBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.APPLE_PIE.get()), ModItems.LIME_PIE_SLICE));
    public static final RegistryObject<Block> POMEGRANATE_CAKE = registerBlockWithoutBlockItem("pomegranate_cake", () -> new EffectCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.POMEGRANATE_CAKE_SLICE));
    public static final RegistryObject<Block> DRAGON_FRUIT_CAKE = registerBlockWithoutBlockItem("dragon_fruit_cake", () -> new EffectCakeBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), ModItems.DRAGON_FRUIT_CAKE_SLICE));
    public static final RegistryObject<Block> FARMERS_BREAKFAST = registerBlockWithoutBlockItem("farmers_breakfast_block", () -> new FoodBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(12).saturationMod(1.2F).build()));
    public static final RegistryObject<Block> OAT_PANCAKE_BLOCK = registerBlockWithoutBlockItem("oat_pancake_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 7));
    public static final RegistryObject<Block> POTATO_WITH_ROAST_MEAT = registerBlockWithoutBlockItem("potato_with_roast_meat_block", () -> new FoodBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(7).saturationMod(0.7F).build()));
    public static final RegistryObject<Block> ROASTED_CORN_BLOCK = registerBlockWithoutBlockItem("roasted_corn_block", () -> new StackableEatableBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4));
    public static final RegistryObject<Block> FARMERS_BREAD = registerBlockWithoutBlockItem("farmers_bread_block", () -> new FoodBlock(BlockBehaviour.Properties.copy(Blocks.CAKE), 4, new FoodProperties.Builder().nutrition(6).saturationMod(0.8F).build()));
    public static final RegistryObject<Block> CHERRY_BLOSSOM_CHEESECAKE = registerBlockWithoutBlockItem("cherry_blossom_cheesecake", () -> new PieBlock(Block.Properties.copy(Blocks.CAKE), ModItems.CHERRY_BLOSSOM_CHEESECAKE_SLICE));
    public static final RegistryObject<Block> PANCAKES = registerBlockWithoutBlockItem("pancakes", () -> new PancakeBlock(ModItems.PANCAKE, Block.Properties.copy(Blocks.CAKE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> CHOCOLATE_PANCAKES = BLOCKS.register("chocolate_pancakes", () -> new PancakeBlock(ModItems.CHOCOLATE_PANCAKE, Block.Properties.copy(Blocks.CAKE).sound(SoundType.WOOD)));
    public static final RegistryObject<Block> SPRING_ROLL_MEDLEY = BLOCKS.register("spring_roll_medley", () -> new SpringRollMedley(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PLATE_OF_FRIED_DUMPLING = BLOCKS.register("plate_of_fried_dumpling", () -> new PlateOfFriedDumpling(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> BACON_EGGS = BLOCKS.register("bacon_eggs", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> BONE_SOUP = BLOCKS.register("bone_soup", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> BONE_STEW = BLOCKS.register("bone_stew", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.LANTERN), 3));
    public static final RegistryObject<Block> BREAKFAST_SKILLET = BLOCKS.register("breakfast_skillet", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.LANTERN), 3));
    public static final RegistryObject<Block> BUNNY_STEW = BLOCKS.register("bunny_stew", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> CALIFORNIA_ROLL = BLOCKS.register("california_roll", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOL), 3));
    public static final RegistryObject<Block> CEVICHE = BLOCKS.register("ceviche", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> GLOW_BERRY_MOUSSE = BLOCKS.register("glow_berry_mousse", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> HONEY_NUGGETS = BLOCKS.register("honey_nuggets", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> HOT_CHILI = BLOCKS.register("hot_chili", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> ICED_TEA = BLOCKS.register("iced_tea", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.GLASS), 3));
    public static final RegistryObject<Block> JAMMY_PRESERVES = BLOCKS.register("jammy_preserves", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> MEAT_BALLS = BLOCKS.register("meat_balls", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> MONSTER_LASAGNA = BLOCKS.register("monster_lasagna", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> MONSTER_TARTARE = BLOCKS.register("monster_tartare", () -> CrockPotStackableFoodBlock.of(3));
    public static final RegistryObject<Block> PEPPER_POPPER = BLOCKS.register("pepper_popper", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> PIEROGI = BLOCKS.register("pierogi", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> POTATO_TORNADO = BLOCKS.register("potato_tornado", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> RATATOUILLE = BLOCKS.register("ratatouille", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.LANTERN), 3));
    public static final RegistryObject<Block> SALMON_SUSHI = BLOCKS.register("salmon_sushi", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOL), 3));
    public static final RegistryObject<Block> STEAMED_STICKS = BLOCKS.register("steamed_sticks", () -> new CrockPotFoodBlock(BlockBehaviour.Properties.of().sound(SoundType.WOOD)));
    public static final RegistryObject<Block> STUFFED_EGGPLANT = BLOCKS.register("stuffed_eggplant", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.SWEET_BERRY_BUSH), 3));
    public static final RegistryObject<Block> SURF_N_TURF = BLOCKS.register("surf_n_turf", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.WOOD), 3));
    public static final RegistryObject<Block> WATERMELON_ICLE = BLOCKS.register("watermelon_icle", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.GLASS), 3));
    public static final RegistryObject<Block> WET_GOOP = BLOCKS.register("wet_goop", () -> CrockPotStackableFoodBlock.of(BlockBehaviour.Properties.of().sound(SoundType.CORAL_BLOCK), 3));
    public static final RegistryObject<Block> NETHEROSIA = BLOCKS.register("netherosia", CrockPotFoodBlock::new);
    public static final RegistryObject<Block> POPCORN_BOX = BLOCKS.register("popcorn_box", PopcornBoxBlock::new);
    public static final RegistryObject<Block> PINEAPPLE_PIE = BLOCKS.register("pineapple_pie", () -> new PieBlock(Properties.copy(Blocks.CAKE), ModItems.PINEAPPLE_PIE_SIDE));

    // Copper blocks - TODO: Sort
    public static final RegistryObject<Block> COPPER_CHEST = BLOCKS.register("copper_chest", () -> new WeatheringCopperChestBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().randomTicks()));
    public static final RegistryObject<Block> EXPOSED_COPPER_CHEST = BLOCKS.register("exposed_copper_chest", () -> new WeatheringCopperChestBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().randomTicks()));
    public static final RegistryObject<Block> WEATHERED_COPPER_CHEST = BLOCKS.register("weathered_copper_chest", () -> new WeatheringCopperChestBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_COPPER_CHEST = BLOCKS.register("oxidized_copper_chest", () -> new WeatheringCopperChestBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops().randomTicks()));

    // Register Waxed Copper Chest Blocks
    public static final RegistryObject<Block> WAXED_COPPER_CHEST = BLOCKS.register("waxed_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_CHEST = BLOCKS.register("waxed_exposed_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_CHEST = BLOCKS.register("waxed_weathered_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops()));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_CHEST = BLOCKS.register("waxed_oxidized_copper_chest", () -> new CopperChestBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(SoundType.COPPER).requiresCorrectToolForDrops()));

    // Register Copper Golem Statue Blocks
    public static final RegistryObject<Block> COPPER_GOLEM_STATUE = BLOCKS.register("copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().randomTicks().noOcclusion()));
    public static final RegistryObject<Block> EXPOSED_COPPER_GOLEM_STATUE = BLOCKS.register("exposed_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().randomTicks().noOcclusion()));
    public static final RegistryObject<Block> WEATHERED_COPPER_GOLEM_STATUE = BLOCKS.register("weathered_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().randomTicks().noOcclusion()));
    public static final RegistryObject<Block> OXIDIZED_COPPER_GOLEM_STATUE = BLOCKS.register("oxidized_copper_golem_statue", () -> new WeatheringCopperGolemStatueBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().randomTicks().noOcclusion()));

    // Register Waxed Copper Golem Statue Blocks
    public static final RegistryObject<Block> WAXED_COPPER_GOLEM_STATUE = BLOCKS.register("waxed_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_GOLEM_STATUE = BLOCKS.register("waxed_exposed_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_GOLEM_STATUE = BLOCKS.register("waxed_weathered_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().noOcclusion()));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_GOLEM_STATUE = BLOCKS.register("waxed_oxidized_copper_golem_statue", () -> new WaxedCopperGolemStatueBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).sound(ModSounds.COPPER_STATUE).requiresCorrectToolForDrops().noOcclusion()));

    // Register Copper Torch Blocks
    public static final RegistryObject<Block> COPPER_TORCH = BLOCKS.register("copper_torch", () -> new CopperTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(p -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> COPPER_WALL_TORCH = BLOCKS.register("copper_wall_torch", () -> new CopperWallTorchBlock(BlockBehaviour.Properties.of().noCollission().instabreak().lightLevel(p -> 14).sound(SoundType.WOOD).pushReaction(PushReaction.DESTROY).dropsLike(COPPER_TORCH.get())));

    // Register Copper Lantern Blocks (Weathering)
    public static final RegistryObject<Block> COPPER_LANTERN = BLOCKS.register("copper_lantern", () -> new WeatheringCopperLanternBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> EXPOSED_COPPER_LANTERN = BLOCKS.register("exposed_copper_lantern", () -> new WeatheringCopperLanternBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> WEATHERED_COPPER_LANTERN = BLOCKS.register("weathered_copper_lantern", () -> new WeatheringCopperLanternBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_COPPER_LANTERN = BLOCKS.register("oxidized_copper_lantern", () -> new WeatheringCopperLanternBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));

    // Register Waxed Copper Lantern Blocks
    public static final RegistryObject<Block> WAXED_COPPER_LANTERN = BLOCKS.register("waxed_copper_lantern", () -> new CopperLanternBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_LANTERN = BLOCKS.register("waxed_exposed_copper_lantern", () -> new CopperLanternBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_LANTERN = BLOCKS.register("waxed_weathered_copper_lantern", () -> new CopperLanternBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_LANTERN = BLOCKS.register("waxed_oxidized_copper_lantern", () -> new CopperLanternBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.5F).sound(SoundType.LANTERN).lightLevel(p -> 15).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // Register Copper Chain Blocks
    public static final RegistryObject<Block> COPPER_CHAIN = BLOCKS.register("copper_chain", () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> EXPOSED_COPPER_CHAIN = BLOCKS.register("exposed_copper_chain", () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> WEATHERED_COPPER_CHAIN = BLOCKS.register("weathered_copper_chain", () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_COPPER_CHAIN = BLOCKS.register("oxidized_copper_chain", () -> new WeatheringCopperChainBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion().randomTicks()));

    // Register Waxed Copper Chain Blocks
    public static final RegistryObject<Block> WAXED_COPPER_CHAIN = BLOCKS.register("waxed_copper_chain", () -> new CopperChainBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion()));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_CHAIN = BLOCKS.register("waxed_exposed_copper_chain", () -> new CopperChainBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion()));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_CHAIN = BLOCKS.register("waxed_weathered_copper_chain", () -> new CopperChainBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion()));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_CHAIN = BLOCKS.register("waxed_oxidized_copper_chain", () -> new CopperChainBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().forceSolidOn().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.CHAIN).noOcclusion()));

    // Register Copper Bars Blocks (Weathering)
    public static final RegistryObject<Block> COPPER_BARS = BLOCKS.register("copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> EXPOSED_COPPER_BARS = BLOCKS.register("exposed_copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> WEATHERED_COPPER_BARS = BLOCKS.register("weathered_copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_COPPER_BARS = BLOCKS.register("oxidized_copper_bars", () -> new WeatheringCopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));

    // Register Waxed Copper Bars Blocks
    public static final RegistryObject<Block> WAXED_COPPER_BARS = BLOCKS.register("waxed_copper_bars", () -> new CopperBarsBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_BARS = BLOCKS.register("waxed_exposed_copper_bars", () -> new CopperBarsBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_BARS = BLOCKS.register("waxed_weathered_copper_bars", () -> new CopperBarsBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_BARS = BLOCKS.register("waxed_oxidized_copper_bars", () -> new CopperBarsBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));

    // Register Copper Lightning Rod Blocks (Weathering)
    // Note: Base lightning_rod is vanilla, extended via Mixin (LightningRodBlockMixin)
    public static final RegistryObject<Block> EXPOSED_LIGHTNING_ROD = BLOCKS.register("exposed_lightning_rod", () -> new WeatheringCopperLightningRodBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> WEATHERED_LIGHTNING_ROD = BLOCKS.register("weathered_lightning_rod", () -> new WeatheringCopperLightningRodBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_LIGHTNING_ROD = BLOCKS.register("oxidized_lightning_rod", () -> new WeatheringCopperLightningRodBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));

    // Register Waxed Copper Lightning Rod Blocks
    public static final RegistryObject<Block> WAXED_LIGHTNING_ROD = BLOCKS.register("waxed_lightning_rod", () -> new WaxedCopperLightningRodBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> WAXED_EXPOSED_LIGHTNING_ROD = BLOCKS.register("waxed_exposed_lightning_rod", () -> new WaxedCopperLightningRodBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> WAXED_WEATHERED_LIGHTNING_ROD = BLOCKS.register("waxed_weathered_lightning_rod", () -> new WaxedCopperLightningRodBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<Block> WAXED_OXIDIZED_LIGHTNING_ROD = BLOCKS.register("waxed_oxidized_lightning_rod", () -> new WaxedCopperLightningRodBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));

    // Register Copper Trapdoor Blocks (Weathering)
    public static final RegistryObject<WeatheringCopperTrapDoorBlock> COPPER_TRAPDOOR = BLOCKS.register("copper_trapdoor", () -> new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<WeatheringCopperTrapDoorBlock> EXPOSED_COPPER_TRAPDOOR = BLOCKS.register("exposed_copper_trapdoor", () -> new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<WeatheringCopperTrapDoorBlock> WEATHERED_COPPER_TRAPDOOR = BLOCKS.register("weathered_copper_trapdoor", () -> new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion().randomTicks()));
    public static final RegistryObject<WeatheringCopperTrapDoorBlock> OXIDIZED_COPPER_TRAPDOOR = BLOCKS.register("oxidized_copper_trapdoor", () -> new WeatheringCopperTrapDoorBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));

    // Register Waxed Copper Trapdoor Blocks
    public static final RegistryObject<WaxedCopperTrapDoorBlock> WAXED_COPPER_TRAPDOOR = BLOCKS.register("waxed_copper_trapdoor", () -> new WaxedCopperTrapDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED, COPPER_TRAPDOOR, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<WaxedCopperTrapDoorBlock> WAXED_EXPOSED_COPPER_TRAPDOOR = BLOCKS.register("waxed_exposed_copper_trapdoor", () -> new WaxedCopperTrapDoorBlock(WeatheringCopper.WeatherState.EXPOSED, EXPOSED_COPPER_TRAPDOOR, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<WaxedCopperTrapDoorBlock> WAXED_WEATHERED_COPPER_TRAPDOOR = BLOCKS.register("waxed_weathered_copper_trapdoor", () -> new WaxedCopperTrapDoorBlock(WeatheringCopper.WeatherState.WEATHERED, WEATHERED_COPPER_TRAPDOOR, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));
    public static final RegistryObject<WaxedCopperTrapDoorBlock> WAXED_OXIDIZED_COPPER_TRAPDOOR = BLOCKS.register("waxed_oxidized_copper_trapdoor", () -> new WaxedCopperTrapDoorBlock(WeatheringCopper.WeatherState.OXIDIZED, OXIDIZED_COPPER_TRAPDOOR, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).noOcclusion()));

    // Register Copper Bulb Blocks (Weathering)
    public static final RegistryObject<CopperBulbBlock> COPPER_BULB = BLOCKS.register("copper_bulb", () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelUnaffected).randomTicks()));
    public static final RegistryObject<CopperBulbBlock> EXPOSED_COPPER_BULB = BLOCKS.register("exposed_copper_bulb", () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelExposed).randomTicks()));
    public static final RegistryObject<CopperBulbBlock> WEATHERED_COPPER_BULB = BLOCKS.register("weathered_copper_bulb", () -> new WeatheringCopperBulbBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelWeathered).randomTicks()));
    public static final RegistryObject<CopperBulbBlock> OXIDIZED_COPPER_BULB = BLOCKS.register("oxidized_copper_bulb", () -> new CopperBulbBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelOxidized)));

    // Register Waxed Copper Bulb Blocks
    public static final RegistryObject<WaxedCopperBulbBlock> WAXED_COPPER_BULB = BLOCKS.register("waxed_copper_bulb", () -> new WaxedCopperBulbBlock(WeatheringCopper.WeatherState.UNAFFECTED, COPPER_BULB, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelUnaffected)));
    public static final RegistryObject<WaxedCopperBulbBlock> WAXED_EXPOSED_COPPER_BULB = BLOCKS.register("waxed_exposed_copper_bulb", () -> new WaxedCopperBulbBlock(WeatheringCopper.WeatherState.EXPOSED, EXPOSED_COPPER_BULB, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelExposed)));
    public static final RegistryObject<WaxedCopperBulbBlock> WAXED_WEATHERED_COPPER_BULB = BLOCKS.register("waxed_weathered_copper_bulb", () -> new WaxedCopperBulbBlock(WeatheringCopper.WeatherState.WEATHERED, WEATHERED_COPPER_BULB, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelWeathered)));
    public static final RegistryObject<WaxedCopperBulbBlock> WAXED_OXIDIZED_COPPER_BULB = BLOCKS.register("waxed_oxidized_copper_bulb", () -> new WaxedCopperBulbBlock(WeatheringCopper.WeatherState.OXIDIZED, OXIDIZED_COPPER_BULB, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).lightLevel(CopperBulbBlock::getLightLevelOxidized)));

    // Register Copper Grate Blocks (Weathering)
    public static final RegistryObject<Block> COPPER_GRATE = BLOCKS.register("copper_grate", () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> EXPOSED_COPPER_GRATE = BLOCKS.register("exposed_copper_grate", () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> WEATHERED_COPPER_GRATE = BLOCKS.register("weathered_copper_grate", () -> new WeatheringCopperGrateBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion().randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_COPPER_GRATE = BLOCKS.register("oxidized_copper_grate", () -> new CopperGrateBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion()));

    // Register Waxed Copper Grate Blocks
    public static final RegistryObject<Block> WAXED_COPPER_GRATE = BLOCKS.register("waxed_copper_grate", () -> new CopperGrateBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion()));
    public static final RegistryObject<Block> WAXED_EXPOSED_COPPER_GRATE = BLOCKS.register("waxed_exposed_copper_grate", () -> new CopperGrateBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion()));
    public static final RegistryObject<Block> WAXED_WEATHERED_COPPER_GRATE = BLOCKS.register("waxed_weathered_copper_grate", () -> new CopperGrateBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion()));
    public static final RegistryObject<Block> WAXED_OXIDIZED_COPPER_GRATE = BLOCKS.register("waxed_oxidized_copper_grate", () -> new CopperGrateBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(ModSounds.COPPER_GRATE).noOcclusion()));

    // Register Chiseled Copper Blocks (Weathering)
    public static final RegistryObject<Block> CHISELED_COPPER = BLOCKS.register("chiseled_copper", () -> new WeatheringChiseledCopperBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).randomTicks()));
    public static final RegistryObject<Block> EXPOSED_CHISELED_COPPER = BLOCKS.register("exposed_chiseled_copper", () -> new WeatheringChiseledCopperBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).randomTicks()));
    public static final RegistryObject<Block> WEATHERED_CHISELED_COPPER = BLOCKS.register("weathered_chiseled_copper", () -> new WeatheringChiseledCopperBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER).randomTicks()));
    public static final RegistryObject<Block> OXIDIZED_CHISELED_COPPER = BLOCKS.register("oxidized_chiseled_copper", () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));

    // Register Waxed Chiseled Copper Blocks
    public static final RegistryObject<Block> WAXED_CHISELED_COPPER = BLOCKS.register("waxed_chiseled_copper", () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_EXPOSED_CHISELED_COPPER = BLOCKS.register("waxed_exposed_chiseled_copper", () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_WEATHERED_CHISELED_COPPER = BLOCKS.register("waxed_weathered_chiseled_copper", () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));
    public static final RegistryObject<Block> WAXED_OXIDIZED_CHISELED_COPPER = BLOCKS.register("waxed_oxidized_chiseled_copper", () -> new ChiseledCopperBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().requiresCorrectToolForDrops().strength(3.0F, 6.0F).sound(SoundType.COPPER)));

    // Register Copper Door Blocks
    public static final RegistryObject<WeatheringCopperDoorBlock> COPPER_DOOR = BLOCKS.register("copper_door", () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<WeatheringCopperDoorBlock> EXPOSED_COPPER_DOOR = BLOCKS.register("exposed_copper_door", () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<WeatheringCopperDoorBlock> WEATHERED_COPPER_DOOR = BLOCKS.register("weathered_copper_door", () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY).randomTicks()));
    public static final RegistryObject<WeatheringCopperDoorBlock> OXIDIZED_COPPER_DOOR = BLOCKS.register("oxidized_copper_door", () -> new WeatheringCopperDoorBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // Register Waxed Copper Door Blocks
    public static final RegistryObject<CopperDoorBlock> WAXED_COPPER_DOOR = BLOCKS.register("waxed_copper_door", () -> new CopperDoorBlock(WeatheringCopper.WeatherState.UNAFFECTED, COPPER_DOOR, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<CopperDoorBlock> WAXED_EXPOSED_COPPER_DOOR = BLOCKS.register("waxed_exposed_copper_door", () -> new CopperDoorBlock(WeatheringCopper.WeatherState.EXPOSED, EXPOSED_COPPER_DOOR, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<CopperDoorBlock> WAXED_WEATHERED_COPPER_DOOR = BLOCKS.register("waxed_weathered_copper_door", () -> new CopperDoorBlock(WeatheringCopper.WeatherState.WEATHERED, WEATHERED_COPPER_DOOR, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));
    public static final RegistryObject<CopperDoorBlock> WAXED_OXIDIZED_COPPER_DOOR = BLOCKS.register("waxed_oxidized_copper_door", () -> new CopperDoorBlock(WeatheringCopper.WeatherState.OXIDIZED, OXIDIZED_COPPER_DOOR, BlockBehaviour.Properties.of().strength(3.0F, 6.0F).noOcclusion().pushReaction(PushReaction.DESTROY)));

    // Register Copper Button Blocks
    public static final RegistryObject<CopperButtonBlock> COPPER_BUTTON = BLOCKS.register("copper_button", () -> new CopperButtonBlock(WeatheringCopper.WeatherState.UNAFFECTED, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));
    public static final RegistryObject<CopperButtonBlock> EXPOSED_COPPER_BUTTON = BLOCKS.register("exposed_copper_button", () -> new CopperButtonBlock(WeatheringCopper.WeatherState.EXPOSED, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));
    public static final RegistryObject<CopperButtonBlock> WEATHERED_COPPER_BUTTON = BLOCKS.register("weathered_copper_button", () -> new CopperButtonBlock(WeatheringCopper.WeatherState.WEATHERED, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));
    public static final RegistryObject<CopperButtonBlock> OXIDIZED_COPPER_BUTTON = BLOCKS.register("oxidized_copper_button", () -> new CopperButtonBlock(WeatheringCopper.WeatherState.OXIDIZED, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));

    // Register Waxed Copper Button Blocks
    public static final RegistryObject<WaxedCopperButtonBlock> WAXED_COPPER_BUTTON = BLOCKS.register("waxed_copper_button", () -> new WaxedCopperButtonBlock(WeatheringCopper.WeatherState.UNAFFECTED, COPPER_BUTTON, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));
    public static final RegistryObject<WaxedCopperButtonBlock> WAXED_EXPOSED_COPPER_BUTTON = BLOCKS.register("waxed_exposed_copper_button", () -> new WaxedCopperButtonBlock(WeatheringCopper.WeatherState.EXPOSED, EXPOSED_COPPER_BUTTON, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));
    public static final RegistryObject<WaxedCopperButtonBlock> WAXED_WEATHERED_COPPER_BUTTON = BLOCKS.register("waxed_weathered_copper_button", () -> new WaxedCopperButtonBlock(WeatheringCopper.WeatherState.WEATHERED, WEATHERED_COPPER_BUTTON, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));
    public static final RegistryObject<WaxedCopperButtonBlock> WAXED_OXIDIZED_COPPER_BUTTON = BLOCKS.register("waxed_oxidized_copper_button", () -> new WaxedCopperButtonBlock(WeatheringCopper.WeatherState.OXIDIZED, OXIDIZED_COPPER_BUTTON, BlockBehaviour.Properties.of().noCollission().strength(0.5F).sound(SoundType.COPPER)));



    // Registry

//    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Integer stackSize, Boolean isFuel, Integer fuelAmount) {
//        RegistryObject<T> toReturn = BLOCKS.register(name, block);
//        registerBlockItem(name, toReturn, stackSize, isFuel, fuelAmount);
//        return toReturn;
//    }

    public static RegistryObject<Block> registerBlock(final String name, Supplier<Block> block) {
        return BLOCKS.register(name, block);
    }

    private static ToIntFunction<BlockState> getLightValueLit(int lightValue) {
        return (state) -> state.getValue(BlockStateProperties.LIT) ? lightValue : 0;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

//    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Integer stackSize, Boolean isFuel, Integer fuelAmount) {
//        if (isFuel == false) {
//            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
//                    new Item.Properties().stacksTo(stackSize != 0 ? stackSize : 64)));
//        } else {
//
//            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
//                    new Item.Properties().stacksTo(stackSize != 0 ? stackSize : 64)) {
//                @Override
//                public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
//                    return fuelAmount;
//                }
//            });
//        }
//    }

    public static Block[] getBasins() {
        return new Block[]{
                GRANITE_BASIN.get(),
                DIORITE_BASIN.get(),
                ANDESITE_BASIN.get(),
                BASALT_BASIN.get(),
                BLACKSTONE_BASIN.get()
        };
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }

    private static boolean never(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }

    private static boolean never(BlockState state, BlockGetter level, BlockPos pos, EntityType<?> type) {
        return false;
    }

    private static BlockBehaviour.Properties logProperties(MapColor topColor, MapColor sideColor, SoundType sound) {
        return BlockBehaviour.Properties.of().mapColor(state -> state.getValue(RotatedPillarBlock.AXIS) == Direction.Axis.Y ? topColor : sideColor).instrument(NoteBlockInstrument.BASS).strength(2.0F).sound(sound).ignitedByLava();
    }

    public static void registerButtons() {
        COPPER_BUTTON.get().setWaxedButton(WAXED_COPPER_BUTTON);
        EXPOSED_COPPER_BUTTON.get().setWaxedButton(WAXED_EXPOSED_COPPER_BUTTON);
        WEATHERED_COPPER_BUTTON.get().setWaxedButton(WAXED_WEATHERED_COPPER_BUTTON);
        OXIDIZED_COPPER_BUTTON.get().setWaxedButton(WAXED_OXIDIZED_COPPER_BUTTON);

        // Setup trapdoor references
        COPPER_TRAPDOOR.get().setWaxedTrapdoor(WAXED_COPPER_TRAPDOOR);
        EXPOSED_COPPER_TRAPDOOR.get().setWaxedTrapdoor(WAXED_EXPOSED_COPPER_TRAPDOOR);
        WEATHERED_COPPER_TRAPDOOR.get().setWaxedTrapdoor(WAXED_WEATHERED_COPPER_TRAPDOOR);
        OXIDIZED_COPPER_TRAPDOOR.get().setWaxedTrapdoor(WAXED_OXIDIZED_COPPER_TRAPDOOR);

        // Setup bulb references
        COPPER_BULB.get().setWaxedBulb(WAXED_COPPER_BULB);
        EXPOSED_COPPER_BULB.get().setWaxedBulb(WAXED_EXPOSED_COPPER_BULB);
        WEATHERED_COPPER_BULB.get().setWaxedBulb(WAXED_WEATHERED_COPPER_BULB);
        OXIDIZED_COPPER_BULB.get().setWaxedBulb(WAXED_OXIDIZED_COPPER_BULB);

        // Setup door references
        COPPER_DOOR.get().setWaxedDoor(WAXED_COPPER_DOOR);
        EXPOSED_COPPER_DOOR.get().setWaxedDoor(WAXED_EXPOSED_COPPER_DOOR);
        WEATHERED_COPPER_DOOR.get().setWaxedDoor(WAXED_WEATHERED_COPPER_DOOR);
        OXIDIZED_COPPER_DOOR.get().setWaxedDoor(WAXED_OXIDIZED_COPPER_DOOR);
    }
}