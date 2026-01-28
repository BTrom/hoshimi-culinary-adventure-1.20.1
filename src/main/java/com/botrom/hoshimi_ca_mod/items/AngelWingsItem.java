package com.botrom.hoshimi_ca_mod.items;

import com.botrom.hoshimi_ca_mod.utils.WingLogicHandler;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Equipable;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class AngelWingsItem extends Item implements Equipable {

    public AngelWingsItem(Properties properties) {
        super(properties.stacksTo(1));
    }

    @Override
    public @NotNull EquipmentSlot getEquipmentSlot() {
        return EquipmentSlot.CHEST;
    }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return !stack.getOrCreateTag().getBoolean(WingLogicHandler.WING_STATE_TAG);
    }

    @Override
    public boolean elytraFlightTick(ItemStack stack, LivingEntity entity, int flightTicks) {
//        return !stack.getOrCreateTag().getBoolean(WingLogicHandler.WING_STATE_TAG);
        return true;
    }

    // This runs every tick (20 times a second) on both Client and Server
    @Override
    public void onArmorTick(ItemStack stack, Level level, Player player) {
        // Pass control to our logic handler
        WingLogicHandler.onTick(player, stack);
    }

    // Safety check: ensure it stays in the chest slot
    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.CHEST;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pHand) {
        return this.swapWithEquipmentSlot(this, pLevel, pPlayer, pHand);
    }
}