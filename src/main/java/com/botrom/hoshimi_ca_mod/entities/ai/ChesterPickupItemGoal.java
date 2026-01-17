package com.botrom.hoshimi_ca_mod.entities.ai;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.registry.ModSounds;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.ai.goal.Goal;
import net.minecraft.world.entity.ai.navigation.PathNavigation;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.pathfinder.Path;
import org.jetbrains.annotations.Nullable;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.List;

public class ChesterPickupItemGoal extends Goal {

	private final Chester chester;
	private final PathNavigation navigation;
	@Nullable
	private ItemEntity targetItem = null;

	public ChesterPickupItemGoal(Chester chester) {
		this.chester = chester;
		this.navigation = chester.getNavigation();
		this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));
	}

	@Override
	public boolean canUse() {
		//we only want the luggage to pick up items if it isn't on a cooldown or forced to sit
		if (this.chester.getFetchCooldown() > 0 || this.chester.isInSittingPose() || this.chester.isInventoryOpen() || !this.navigation.isDone())
			return false;

		//sort through items, get the closest one
		List<ItemEntity> items = this.chester.level().getEntitiesOfClass(ItemEntity.class, this.chester.getBoundingBox().inflate(16.0D), item ->
				(item.onGround() || item.isInWater()) &&
						this.chester.hasLineOfSight(item) &&
						this.chester.getInventory().canAddItem(item.getItem()) &&
						item.getItem().getItem().canFitInsideContainerItems());
		items.sort(Comparator.comparingDouble(this.chester::distanceToSqr));

		for (ItemEntity item : items) {
			//please, only go after items you can actually reach
			Path toPath = this.navigation.createPath(item, 1);
			if (toPath != null && toPath.canReach()) {
				this.targetItem = item;
				return true;
			}
		}
		return false;
	}

	@Override
	public boolean canContinueToUse() {
		return this.chester.isAlive() && !this.navigation.isDone() && !this.navigation.isStuck() && this.targetItem != null && !this.targetItem.isRemoved();
	}

	@Override
	public void start() {
		if (this.targetItem != null) {
			this.navigation.moveTo(this.targetItem, 1.2D);
			this.chester.setTryingToFetchItem(true);
		}
	}

	@Override
	public void stop() {
		this.chester.setTryingToFetchItem(false);
	}

	@Override
	public void tick() {
		super.tick();
		if (!this.chester.level().isClientSide()) {
			if (this.targetItem != null && this.chester.distanceToSqr(this.targetItem.position()) < 4.0D) {
				ItemStack item = this.targetItem.getItem();
				if (this.chester.getInventory().canAddItem(this.targetItem.getItem())) {
					if (this.chester.getSoundCooldown() == 0) {
						boolean isFood = item.isEdible();
//						this.chester.playSound(isFood ? ModSounds.LUGGAGE_EAT_FOOD.get() : ModSounds.LUGGAGE_EAT_ITEM.get(),
//								0.5F, 1.0F + (this.chester.getRandom().nextFloat() * 0.2F));
						this.chester.setSoundCooldown(15);
					}

					//stole this from Villager.pickUpItem lol
					SimpleContainer simplecontainer = this.chester.getInventory();
					boolean flag = simplecontainer.canAddItem(item);
					if (!flag) {
						return;
					}

					this.chester.onItemPickup(this.targetItem);
					this.chester.gameEvent(GameEvent.EAT, this.chester);
					this.chester.take(this.targetItem, item.getCount());
					ItemStack consumedStack = simplecontainer.addItem(item);
					if (consumedStack.isEmpty()) {
						this.targetItem.discard();
					} else {
						item.setCount(consumedStack.getCount());
					}
				}
			}
		}
	}
}
