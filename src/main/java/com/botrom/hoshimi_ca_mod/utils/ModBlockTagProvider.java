package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
	public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
		super(output, lookupProvider, HoshimiCulinaryMod.MOD_ID, existingFileHelper);
	}

	@Override
	public void addTags(HolderLookup.@NotNull Provider provider) {
		// Collector's Reap
		this.tag(ModTags.CROPS_PLANTABLE_ON)
			.add(Blocks.FARMLAND)
			.add(vectorwing.farmersdelight.common.registry.ModBlocks.RICH_SOIL_FARMLAND.get());
//		this.tag(ModTags.PORTOBELLO_SPAWNABLE_ON)
//			.addTag(ModTags.MUSHROOM_COLONY_GROWABLE_ON)
//			.addTag(BlockTags.MUSHROOM_GROW_BLOCK)
//			.addTag(BlockTags.DIRT);
//		this.tag(ModTags.DRAGON_FRUIT_SPAWNABLE_ON)
//			.addTag(Tags.Blocks.SAND_RED);
//		this.tag(ModTags.STYGIAN_POMEGRANATE_GROWABLE_ON)
//			.addOptional(Modid.MND.rl("resurgent_soil"))
//			.addOptional(Modid.MND.rl("resurgent_soil_farmland"))
//			.addOptional(Modid.ND.rl("rich_soul_soil"));
//		this.tag(ModTags.POMEGRANATE_FAST_ON)
//			.addTag(ModTags.STYGIAN_POMEGRANATE_GROWABLE_ON)
//			.addTag(BlockTags.NYLIUM);
		this.tag(ModTags.CRAB_SPAWNABLE_ON)
			.addTag(BlockTags.SAND)
			.addTag(Tags.Blocks.GRAVEL)
			.add(Blocks.WATER)
			.add(Blocks.CLAY);
//		this.tag(ModTags.LUCUMA_LOGS)
//			.add(ModBlocks.LUCUMA_LOG.get())
//			.add(ModBlocks.LUCUMA_WOOD.get())
//			.add(ModBlocks.STRIPPED_LUCUMA_LOG.get())
//			.add(ModBlocks.STRIPPED_LUCUMA_WOOD.get());
//		this.tag(ModTags.LUCUMA_ROOTS_CAN_GROW_THROUGH)
//			.addTag(ModTags.LUCUMA_LOGS)
//			.addTag(BlockTags.SNOW)
//			.add(Blocks.MUD)
//			.add(Blocks.VINE);

		// Minecraft
//		ModBlocks.BLOCKS.getDeferredRegister().getEntries()
//			.stream()
//			.map(RegistryObject::get)
//			.filter(b -> b instanceof EffectCandleCakeBlock)
//			.forEach(b -> this.tag(BlockTags.CANDLE_CAKES).add(b));
//		this.tag(BlockTags.LOGS_THAT_BURN).addTag(ModTags.LUCUMA_LOGS);
//		this.tag(BlockTags.PLANKS).add(ModBlocks.LUCUMA_PLANKS.get());
//		this.tag(BlockTags.WOODEN_STAIRS).add(ModBlocks.LUCUMA_STAIRS.get());
//		this.tag(BlockTags.WOODEN_SLABS).add(ModBlocks.LUCUMA_SLAB.get());
//		this.tag(BlockTags.WOODEN_FENCES).add(ModBlocks.LUCUMA_FENCE.get());
//		this.tag(BlockTags.FENCE_GATES).add(ModBlocks.LUCUMA_FENCE_GATE.get());
//		this.tag(BlockTags.WOODEN_DOORS).add(ModBlocks.LUCUMA_DOOR.get());
//		this.tag(BlockTags.WOODEN_TRAPDOORS).add(ModBlocks.LUCUMA_TRAPDOOR.get());
//		this.tag(BlockTags.WOODEN_PRESSURE_PLATES).add(ModBlocks.LUCUMA_PRESSURE_PLATE.get());
//		this.tag(BlockTags.WOODEN_BUTTONS).add(ModBlocks.LUCUMA_BUTTON.get());
//		this.tag(BlockTags.STANDING_SIGNS).add(ModBlocks.LUCUMA_SIGN.get());
//		this.tag(BlockTags.WALL_SIGNS).add(ModBlocks.LUCUMA_WALL_SIGN.get());
//		this.tag(BlockTags.CEILING_HANGING_SIGNS).add(ModBlocks.LUCUMA_HANGING_SIGN.get());
//		this.tag(BlockTags.WALL_HANGING_SIGNS).add(ModBlocks.LUCUMA_WALL_HANGING_SIGN.get());
//		this.tag(BlockTags.SAPLINGS).add(ModBlocks.LUCUMA_SAPLING.get());
//		this.tag(BlockTags.LEAVES).add(ModBlocks.LUCUMA_LEAVES.get());
//		this.tag(BlockTags.FLOWER_POTS)
//			.add(ModBlocks.POTTED_LUCUMA_SAPLING.get())
//			.add(ModBlocks.POTTED_DAMSELFLOWER.get())
//			.add(ModBlocks.POTTED_MOONTEAR.get())
//			.add(ModBlocks.POTTED_SKULL_LILY.get());
//		this.tag(BlockTags.SMALL_FLOWERS)
//			.add(ModBlocks.DRAGON_BUSH.get())
//			.add(ModBlocks.DAMSELFLOWER.get())
//			.add(ModBlocks.MOONTEAR.get())
//			.add(ModBlocks.SKULL_LILY.get());
//		this.tag(BlockTags.TALL_FLOWERS)
//			.add(ModBlocks.BULBOUS_ROSE.get())
//			.add(ModBlocks.HEARTPETALS.get());
//		this.tag(BlockTags.CROPS)
//			.add(ModBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get())
//			.add(ModBlocks.BULBOUS_ROSE_CROP.get())
//			.add(ModBlocks.HEARTPETALS_CROP.get());
//		this.tag(BlockTags.BEE_GROWABLES)
//			.add(ModBlocks.LIME_BUSH.get())
//			.add(ModBlocks.POMEGRANATE_BUSH.get())
//			.add(ModBlocks.BULBOUS_ROSE_CROP.get())
//			.add(ModBlocks.HEARTPETALS_CROP.get());
//		this.tag(BlockTags.MAINTAINS_FARMLAND)
//			.add(ModBlocks.DAMSELFLOWER.get())
//			.add(ModBlocks.DAMSELFLOWER_CROP.get())
//			.add(ModBlocks.MOONTEAR.get())
//			.add(ModBlocks.MOONTEAR_CROP.get())
//			.add(ModBlocks.SKULL_LILY.get())
//			.add(ModBlocks.SKULL_LILY_CROP.get())
//			.add(ModBlocks.BULBOUS_ROSE.get())
//			.add(ModBlocks.BULBOUS_ROSE_CROP.get())
//			.add(ModBlocks.HEARTPETALS.get())
//			.add(ModBlocks.HEARTPETALS_CROP.get());
//		this.tag(BlockTags.MINEABLE_WITH_SHOVEL)
//			.add(ModBlocks.LIME_ICE_CREAM_BLOCK.get())
//			.add(ModBlocks.POMEGRANATE_ICE_CREAM_BLOCK.get())
//			.add(ModBlocks.PINK_DRAGON_FRUIT_ICE_CREAM_BLOCK.get())
//			.add(ModBlocks.PLATINUM_BASS_ROE.get())
//			.add(ModBlocks.TIGER_PRAWN_ROE.get());
//		this.tag(BlockTags.MINEABLE_WITH_AXE)
//			.add(ModBlocks.LUCUMA_CABINET.get())
//			.add(ModBlocks.PORTOBELLO.get())
//			.add(ModBlocks.LIME_CRATE.get())
//			.add(ModBlocks.POMEGRANATE_CRATE.get())
//			.add(ModBlocks.STYGIAN_POMEGRANATE_CRATE.get())
//			.add(ModBlocks.PINK_DRAGON_FRUIT_CRATE.get())
//			.add(ModBlocks.LUCUMA_CRATE.get())
//			.add(ModBlocks.GILDED_LUCUMA_CRATE.get());
//		this.tag(BlockTags.MINEABLE_WITH_HOE).add(ModBlocks.LUCUMA_LEAVES.get());
//		this.tag(BlockTags.CLIMBABLE).add(ModBlocks.PINK_DRAGON_FRUIT_CROP.get());
//		this.tag(BlockTags.WALLS)
//			.add(ModBlocks.URCHIN_TEST_BRICK_WALL.get())
//			.add(ModBlocks.URCHIN_TEST_TILE_WALL.get());
//		this.tag(BlockTags.SLABS)
//			.add(ModBlocks.URCHIN_TEST_BRICK_SLAB.get())
//			.add(ModBlocks.URCHIN_TEST_TILE_SLAB.get());
//		this.tag(BlockTags.STAIRS)
//			.add(ModBlocks.URCHIN_TEST_BRICK_STAIRS.get())
//			.add(ModBlocks.URCHIN_TEST_TILE_STAIRS.get());
//		this.tag(BlockTags.CAULDRONS)
//			.add(ModBlocks.LIME_MILKSHAKE_CAULDRON.get())
//			.add(ModBlocks.POMEGRANATE_MILKSHAKE_CAULDRON.get())
//			.add(ModBlocks.PINK_DRAGON_FRUIT_MILKSHAKE_CAULDRON.get())
//			.add(ModBlocks.LUCUMA_MILKSHAKE_CAULDRON.get());
//
//		// Forge
//		this.tag(Tags.Blocks.FENCE_GATES_WOODEN).add(ModBlocks.LUCUMA_FENCE_GATE.get());
//		this.tag(ModTags.STORAGE_BLOCKS_LIME).add(ModBlocks.LIME_CRATE.get());
//		this.tag(ModTags.STORAGE_BLOCKS_POMEGRANATE).add(ModBlocks.POMEGRANATE_CRATE.get());
//		this.tag(ModTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE).add(ModBlocks.STYGIAN_POMEGRANATE_CRATE.get());
//		this.tag(ModTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT).add(ModBlocks.PINK_DRAGON_FRUIT_CRATE.get());
//		this.tag(ModTags.STORAGE_BLOCKS_LUCUMA).add(ModBlocks.LUCUMA_CRATE.get());
//		this.tag(ModTags.STORAGE_BLOCKS_GILDED_LUCUMA).add(ModBlocks.GILDED_LUCUMA_CRATE.get());
//		this.tag(Tags.Blocks.STORAGE_BLOCKS)
//			.addTag(ModTags.STORAGE_BLOCKS_LIME)
//			.addTag(ModTags.STORAGE_BLOCKS_POMEGRANATE)
//			.addTag(ModTags.STORAGE_BLOCKS_STYGIAN_POMEGRANATE)
//			.addTag(ModTags.STORAGE_BLOCKS_PINK_DRAGON_FRUIT)
//			.addTag(ModTags.STORAGE_BLOCKS_LUCUMA)
//			.addTag(ModTags.STORAGE_BLOCKS_GILDED_LUCUMA);
//		this.tag(ForgeTags.MINEABLE_WITH_KNIFE)
//			.add(ModBlocks.PORTOBELLO_QUICHE.get())
//			.add(ModBlocks.LIME_PIE.get())
//			.add(ModBlocks.LIME_CAKE.get())
//			.add(ModBlocks.POMEGRANATE_CAKE.get())
//			.add(ModBlocks.PINK_DRAGON_FRUIT_CAKE.get())
//			.add(ModBlocks.LUCUMA_CAKE.get())
//			.add(ModBlocks.PANETTONE.get());
//
//		// Farmer's Delight
//		this.tag(ModTags.COMPOST_ACTIVATORS)
//			.add(ModBlocks.PORTOBELLO.get())
//			.add(ModBlocks.PORTOBELLO_COLONY.get());
//		this.tag(ModTags.UNAFFECTED_BY_RICH_SOIL)
//			.add(ModBlocks.PORTOBELLO_COLONY.get());
//		this.tag(ModTags.WILD_CROPS)
//			.add(ModBlocks.DRAGON_BUSH.get());
//
//		// Blueprint
//		this.tag(BlueprintBlockTags.LEAF_PILES).add(ModBlocks.LUCUMA_LEAF_PILE.get());
//		this.tag(BlueprintBlockTags.WOODEN_BEEHIVES).add(ModBlocks.LUCUMA_BEEHIVE.get());
//		this.tag(BlueprintBlockTags.WOODEN_LADDERS).add(ModBlocks.LUCUMA_LADDER.get());
//		this.tag(BlueprintBlockTags.WOODEN_BOOKSHELVES).add(ModBlocks.LUCUMA_BOOKSHELF.get());
//		this.tag(BlueprintBlockTags.WOODEN_CHISELED_BOOKSHELVES).add(ModBlocks.CHISELED_LUCUMA_BOOKSHELF.get());
//		this.tag(BlueprintBlockTags.WOODEN_BOARDS).add(ModBlocks.LUCUMA_BOARDS.get());
//		this.tag(BlueprintBlockTags.WOODEN_CHESTS).add(ModBlocks.LUCUMA_CHEST.get());
//		this.tag(BlueprintBlockTags.WOODEN_TRAPPED_CHESTS).add(ModBlocks.TRAPPED_LUCUMA_CHEST.get());
//
//		// Serene Seasons
//		this.tag(ModTags.WINTER_CROPS);
//		this.tag(ModTags.AUTUMN_CROPS)
//			.add(ModBlocks.POMEGRANATE_BUSH.get());
//		this.tag(ModTags.SUMMER_CROPS)
//			.add(ModBlocks.POMEGRANATE_BUSH.get())
//			.add(ModBlocks.BUDDING_PINK_DRAGON_FRUIT_CROP.get())
//			.add(ModBlocks.PINK_DRAGON_FRUIT_CROP.get());
//		this.tag(ModTags.SPRING_CROPS)
//			.add(ModBlocks.LIME_BUSH.get());
//
//		// My Nether's Delight
//		this.tag(ModTags.SHOWCASE_ACTIVATORS)
//			.add(ModBlocks.PORTOBELLO.get())
//			.add(ModBlocks.PORTOBELLO_COLONY.get());
//		this.tag(ModTags.NOT_PROPAGATE_PLANT)
//			.add(ModBlocks.LIME_BUSH.get())
//			.add(ModBlocks.POMEGRANATE_BUSH.get());
//
//		// Let Fish Love
//		this.tag(ModTags.FISH_ROE_PLATINUM_BASS).add(ModBlocks.PLATINUM_BASS_ROE.get());
//		this.tag(ModTags.FISH_ROE_TIGER_PRAWN).add(ModBlocks.TIGER_PRAWN_ROE.get());
//
//		// Supplementaries
//		this.tag(ModTags.HANG_FROM_ROPES).add(ModBlocks.PINK_DRAGON_FRUIT_CROP.get());
//
//		// Other
//		this.tag(Modid.TF.bt("portal/decoration")).add(ModBlocks.PORTOBELLO.get());
//		this.tag(Modid.IW.bt("small_mushrooms")).add(ModBlocks.PORTOBELLO.get());
//		this.tag(Modid.AUT.bt("snail_snacks")).add(ModBlocks.PORTOBELLO.get());
	}
}