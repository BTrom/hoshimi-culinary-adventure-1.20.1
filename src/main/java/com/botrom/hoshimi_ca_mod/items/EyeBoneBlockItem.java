package com.botrom.hoshimi_ca_mod.items;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.UUID;

public class EyeBoneBlockItem extends BlockItem {

	public EyeBoneBlockItem(Properties properties) {
		super(ModBlocks.EYE_BONE.get(), properties.stacksTo(1).fireResistant().rarity(Rarity.EPIC)); // Important: Eye Bones shouldn't stack!
		HoshimiCulinaryMod.LOGGER.info("EyeBoneBlockItem created.");
	}

	@Override
	public void inventoryTick(@NotNull ItemStack stack, Level level, Entity entity, int slotId, boolean isSelected) {
		if (level.isClientSide) return;

		CompoundTag tag = stack.getOrCreateTag();
		int cooldown;
//		if (tag.contains(Chester.RESPAWN_COOLDOWN_TAG))
			cooldown = tag.getInt(Chester.RESPAWN_COOLDOWN_TAG);
//		else
//			cooldown = 100;

		// 1. Handle Cooldown
		if (cooldown > 0) {
			if (cooldown % 10 == 0)
				HoshimiCulinaryMod.LOGGER.info("Eye Bone Cooldown: {}", cooldown);
			tag.putInt(Chester.RESPAWN_COOLDOWN_TAG, cooldown - 1);
			return;
		} else {
			level.playSound(entity, entity.blockPosition(), SoundEvents.EXPERIENCE_ORB_PICKUP, SoundSource.BLOCKS, 1.0F, 1.0F);
		}

		// 2. If Cooldown is 0, Chester SHOULD exist.
		UUID eyeBoneUUID = getOrCreateUUID(stack);
		// Check if Chester is already in the world to prevent duplicates.
		// This is a simple check: "Is there a Chester with this Bone ID loaded nearby?"
		// A more complex check requires WorldSavedData, but this works for 99% of cases.
		if (!isChesterAlive(level, eyeBoneUUID, entity))
			spawnChester(level, entity, eyeBoneUUID);
	}

	public boolean isChesterAlive (Level level, UUID eyeBoneUUID, Entity entity) {
		// Search for Chesters within a large radius (e.g., 100 blocks)
		AABB searchBox = entity.getBoundingBox().inflate(100); // TODO: Add search radius config
		List<Chester> chesters = level.getEntitiesOfClass(Chester.class, searchBox);

		for (Chester chester : chesters) {
			if (chester.getLinkedEyeBoneUUID() != null && chester.getLinkedEyeBoneUUID().equals(eyeBoneUUID)) return true;
		}
		return false;
	}

	private void spawnChester (Level level, Entity entity, UUID eyeBoneUUID) {
		Chester chester = new Chester(ModEntities.CHESTER.get(), level);
		chester.setLinkedEyeBoneUUID(eyeBoneUUID);
		// Position: "Walks in from far away"
		// We pick a random spot 10 blocks away
		double angle = level.random.nextDouble() * 2 * Math.PI;
		double x = entity.getX() + 10 * Math.cos(angle);
		double z = entity.getZ() + 10 * Math.sin(angle);
		double y = level.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (int) x, (int) z); // Find ground level

		level.addFreshEntity(chester);
		chester.moveTo(x, y, z, 0, 0);
	}

	public static UUID getOrCreateUUID (ItemStack stack) {
		CompoundTag tag = stack.getOrCreateTag();
		if (!tag.hasUUID(Chester.EYE_BONE_UUID_TAG)) {
			UUID newId = UUID.randomUUID();
			tag.putUUID(Chester.EYE_BONE_UUID_TAG, newId);
            HoshimiCulinaryMod.LOGGER.info("Eye Bone has no UUID, generating new one: {}", newId);
			return newId;
		}
		return tag.getUUID(Chester.EYE_BONE_UUID_TAG);
	}

	// Prevent the Eye Bone from despawning with time
	@Override
	public int getEntityLifespan(ItemStack stack, Level level) {
		return Integer.MAX_VALUE;
	}

//	@Override
//	public @Nullable ICapabilityProvider initCapabilities(ItemStack stack, @Nullable CompoundTag nbt) {
//        if (nbt == null)
//			nbt = stack.getOrCreateTag();
//
//        nbt.putInt(Chester.RESPAWN_COOLDOWN_TAG, 100);
//		return super.initCapabilities(stack, nbt);
//	}

	//	private Stream<ItemStack> getContents(ItemStack stack) {
//		CompoundTag compoundtag = stack.getTag();
//		if (compoundtag == null) {
//			return Stream.empty();
//		} else {
//			ListTag listtag = compoundtag.getList(Chester.INVENTORY_TAG, 10);
//			return listtag.stream().map(CompoundTag.class::cast).map(ItemStack::of);
//		}
//	}
//
//	@Override
//	public Optional<TooltipComponent> getTooltipImage(ItemStack stack) {
//		NonNullList<ItemStack> nonnulllist = NonNullList.create();
//		this.getContents(stack).forEach(nonnulllist::add);
//		return nonnulllist.isEmpty() ? Optional.empty() : Optional.of(new Tooltip(nonnulllist, stack));
//	}
//
//	private boolean dropContents(ItemStack stack, Player player) {
//		CompoundTag tag = stack.getTag();
//		if (tag == null || !tag.contains(Chester.INVENTORY_TAG)) {
//			return false;
//		} else {
//			if (player instanceof ServerPlayer) {
//				ListTag listtag = tag.getList(Chester.INVENTORY_TAG, 10);
//
//				for(int i = 0; i < listtag.size(); ++i) {
//					CompoundTag stackTag = listtag.getCompound(i);
//					ItemStack itemstack = ItemStack.of(stackTag);
//					player.drop(itemstack, true);
//				}
//			}
//
//			stack.removeTagKey(Chester.INVENTORY_TAG);
//			return true;
//		}
//	}
//
//	@Override
//	public void onDestroyed(ItemEntity entity, DamageSource source) {
//		//drop all items if luggage is destroyed for any reason whatsoever
//		ItemUtils.onContainerDestroyed(entity, this.getContents(entity.getItem()));
//	}
//
//	public record Tooltip(NonNullList<ItemStack> stacks, ItemStack stack) implements TooltipComponent {
//
//	}
//
//	@Override
//	public void initializeClient(Consumer<IClientItemExtensions> consumer) {
//		consumer.accept(new IClientItemExtensions() {
//
//			@Override
//			public BlockEntityWithoutLevelRenderer getCustomRenderer() {
//				return new EyeBoneRenderer();
//			}
//		});
//	}
}
