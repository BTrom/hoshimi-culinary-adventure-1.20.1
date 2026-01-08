package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.*;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.block.WildCropBlock;
import net.minecraft.world.level.block.state.BlockBehaviour.Properties;
import java.util.function.Supplier;

public class ModBlocks {

    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, HoshimiCulinaryMod.MOD_ID);


    // Wild Plants
    public static final RegistryObject<Block> WILD_CUCUMBERS = registerBlock("wild_cucumbers",
            () -> new WildCropBlock(MobEffects.FIRE_RESISTANCE, 6,
                    Properties.copy(Blocks.TALL_GRASS)), 0, false, 0);

    public static final RegistryObject<Block> WILD_CORN = registerBlock("wild_corn",
            () -> new WildCropBlock(MobEffects.HUNGER, 6,
                    BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), 0, false, 0);

    public static final RegistryObject<Block> WILD_EGGPLANTS = registerBlock("wild_eggplants",
            () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6,
                    BlockBehaviour.Properties.copy(Blocks.TALL_GRASS)), 0, false, 0);


    // Crops
    public static final RegistryObject<Block> CUCUMBERS = registerBlockWithoutBlockItem("cucumbers",
            () -> new SimpleCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT), ModItems.CUCUMBER_SEEDS));

    public static final RegistryObject<Block> EGGPLANTS = registerBlockWithoutBlockItem("eggplants",
            () -> new EggplantCropBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> CORN_BOTTOM = registerBlockWithoutBlockItem("corn_bottom",
            () -> new CornBottomBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));
    public static final RegistryObject<Block> CORN_UPPER = registerBlockWithoutBlockItem("corn_upper",
            () -> new CornUpperBlock(BlockBehaviour.Properties.copy(Blocks.WHEAT).noOcclusion()));

    public static final RegistryObject<Block> BROCCOLI = registerBlockWithoutBlockItem("broccoli",
            () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.BROCCOLI_SEEDS));

    public static final RegistryObject<Block> PEPPERS = registerBlockWithoutBlockItem("peppers",
            () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.PEPPER_SEEDS));

    public static final RegistryObject<Block> PINEAPPLE = registerBlockWithoutBlockItem("pineapple",
            () -> new SimpleCropBlock(Block.Properties.copy(Blocks.WHEAT), ModItems.PINEAPPLE_SEEDS));


    // Saplings
//    public static final RegistryObject<Block> AVOCADO_SEED = registerBlock("avocado_pit",
//            () -> new AvocadoSeedBlock(new AvocadoPitGrower(), BlockBehaviour.Properties.copy(Blocks.OAK_SAPLING)), false, 0);


    // Blocks
    public static final RegistryObject<Block> CORN_COB_CRATE = registerBlock("corn_crate",
            () -> new Block(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.CARROT_CRATE.get())),0, false, 0);

    public static final RegistryObject<Block> PIZZA_STATION = registerBlock("pizza_station",
            () -> new PizzaStationBlock(BlockBehaviour.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F)), 0, false, 0);

    public static final RegistryObject<Block> PIZZA_OVEN = registerBlock("pizza_oven",
            () -> new OvenBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F).noOcclusion().lightLevel((state) -> state.getValue(BlockStateProperties.LIT) ? 9 : 0)),0,  false, 0);

    public static final RegistryObject<Block> GRANITE_BASIN = registerBlock("granite_basin",
            () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.DIRT).strength(1.5F, 6.0F)), 0, false, 0);
    public static final RegistryObject<Block> DIORITE_BASIN = registerBlock("diorite_basin",
            () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.QUARTZ).strength(1.5F, 6.0F)), 0, false, 0);
    public static final RegistryObject<Block> ANDESITE_BASIN = registerBlock("andesite_basin",
            () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.STONE).strength(1.5F, 6.0F)), 0, false, 0);
    public static final RegistryObject<Block> BASALT_BASIN = registerBlock("basalt_basin",
            () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).strength(1.25F, 4.2F).sound(SoundType.BASALT)),0, false, 0);
    public static final RegistryObject<Block> BLACKSTONE_BASIN = registerBlock("blackstone_basin",
            () -> new BasinBlock(Block.Properties.copy(Blocks.STONE).mapColor(MapColor.COLOR_BLACK).strength(1.5F, 6.0F)), 0, false, 0);


    // Meal Blocks
    public static final RegistryObject<Block> EXOTIC_ROLL_MEDLEY = registerBlock("exotic_roll_medley",
            () -> new ExoticRollMedleyBlock(BlockBehaviour.Properties.copy(vectorwing.farmersdelight.common.registry.ModBlocks.RICE_ROLL_MEDLEY_BLOCK.get()).noOcclusion()), 0, false, 0);

    public static final RegistryObject<Block> PAELLA = registerBlock("paella",
            () -> new PaellaBlock(BlockBehaviour.Properties.of().forceSolidOn().strength(0.5F).sound(SoundType.METAL).pushReaction(PushReaction.DESTROY)), 0, false, 0);

    public static final RegistryObject<Block> PIZZA = registerBlock("pizza",
            () -> new PizzaBlock(Block.Properties.copy(Blocks.CAKE)), 0, false, 0);
    public static final RegistryObject<Block> RAW_PIZZA = registerBlockWithoutBlockItem("raw_pizza",
            () -> new RawPizzaBlock(Block.Properties.copy(Blocks.CAKE)));
    public static final RegistryObject<Block> PIZZA_DOUGH = registerBlock("pizza_dough",
            () -> new DoughBlock(Block.Properties.copy(Blocks.CAKE)), 0, false, 0);
    public static final RegistryObject<Block> CHEESE_BLOCK = registerBlockWithoutBlockItem("cheese_block",
            () -> new CheeseBlock(Block.Properties.copy(Blocks.CAKE).mapColor(MapColor.COLOR_YELLOW).strength(0.5F).sound(SoundType.FUNGUS)));


    // Registry
    private static <T extends Block> RegistryObject<T> registerBlock(String name, Supplier<T> block, Integer stackSize, Boolean isFuel, Integer fuelAmount) {
        RegistryObject<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn, stackSize, isFuel, fuelAmount);
        return toReturn;
    }

    private static <T extends Block> RegistryObject<T> registerBlockWithoutBlockItem(String name, Supplier<T> block) {
        return BLOCKS.register(name, block);
    }

    public static <T extends Block> RegistryObject<Item> registerBlockItem(String name, RegistryObject<T> block, Integer stackSize, Boolean isFuel, Integer fuelAmount) {
        if(isFuel == false) {
            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().stacksTo(stackSize != 0 ? stackSize : 64)));
        } else {

            return ModItems.ITEMS.register(name, () -> new BlockItem(block.get(),
                    new Item.Properties().stacksTo(stackSize != 0 ? stackSize : 64)){
                @Override public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {return fuelAmount;}});
        }
    }

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}