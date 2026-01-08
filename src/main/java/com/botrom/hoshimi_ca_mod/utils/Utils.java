package com.botrom.hoshimi_ca_mod.utils;

import com.mojang.datafixers.util.Pair;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.Containers;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityTicker;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraftforge.items.ItemStackHandler;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Utils {
    public static final String TAG_INVENTORY = "Inventory";
    public static final String TAG_UNIQUENESS = "Uniqueness";
    public static final String TAG_HUNGER = "Hunger";
    public static final String TAG_SATURATION = "Saturation";
    public static final String TAG_PROBABILITY = "Probability";
    public static final String TAG_EFFECTS = "Effects";

    public static ItemStackHandler createHandlerFromStack(ItemStack stack, int size) {
        ItemStackHandler handler = new ItemStackHandler(size);

        if (stack.getTag() != null) {
            handler.deserializeNBT(stack.getTag().getCompound(TAG_INVENTORY));
        }
        return handler;
    }

    public static List<ItemStack> getIngredients(ItemStack stack) {
        ItemStackHandler handler = createHandlerFromStack(stack, 10);
        List<ItemStack> list = new ArrayList<>();

        for (int i = 0; i < handler.getSlots(); i++) {
            if (!handler.getStackInSlot(i).isEmpty()) {
                list.add(handler.getStackInSlot(i));
            }
        }
        return list;
    }

    public static void saveInventoryToStack(ItemStack stack, ItemStackHandler handler) {
        CompoundTag compound = new CompoundTag();
        compound.put(TAG_INVENTORY, handler.serializeNBT());
        stack.setTag(compound);
    }

    public static void loadInventoryFromStack(ItemStack stack, ItemStackHandler handler) {
        if (stack.getTag() == null) return;

        if (stack.getTag().contains(TAG_INVENTORY)) {
            handler.deserializeNBT(stack.getTag().getCompound(TAG_INVENTORY));
            //handler.setSize(10);
        }
    }

    public static ItemStack getSauceStack(ItemStack stack) {
        ItemStackHandler handler = createHandlerFromStack(stack, 10);
        return handler.getStackInSlot(9);
    }

    public static void setUniqueness(ItemStack stack, int uniqueness) {
        CompoundTag compound = stack.getOrCreateTag();
        compound.putInt(TAG_UNIQUENESS, uniqueness);
    }

    public static int getUniqueness(ItemStack stack) {
        CompoundTag compound = stack.getTag();
        if (compound == null) return 0;
        if (compound.contains(TAG_UNIQUENESS)) {
            return compound.getInt(TAG_UNIQUENESS);
        }
        return 0;
    }

    public static void setHunger(ItemStack stack, int hunger) {
        CompoundTag compound = stack.getOrCreateTag();
        compound.putInt(TAG_HUNGER, hunger);
    }

    public static int getHunger(ItemStack stack) {
        CompoundTag compound = stack.getOrCreateTag();
        if (compound == null) return 0;
        if (compound.contains(TAG_HUNGER)) {
            return compound.getInt(TAG_HUNGER);
        }
        return 0;
    }

    public static void setSaturation(ItemStack stack, float saturation) {
        CompoundTag compound = stack.getOrCreateTag();
        compound.putFloat(TAG_SATURATION, saturation);
    }

    public static float getSaturation(ItemStack stack) {
        CompoundTag compound = stack.getOrCreateTag();
        if (compound == null) return 0;
        if (compound.contains(TAG_SATURATION)) {
            return compound.getFloat(TAG_SATURATION);
        }
        return 0;
    }

    public static void setEffects(ItemStack stack, List<Pair<MobEffectInstance, Float>> effects) {
        CompoundTag compound = stack.getOrCreateTag();
        compound.put(TAG_EFFECTS, writeEffectsToTag(effects));
    }

    public static List<Pair<MobEffectInstance, Float>> getEffects(ItemStack stack) {
        CompoundTag compound = stack.getOrCreateTag();
        if (compound == null) return List.of();
        if (compound.contains(TAG_EFFECTS)) {
            return readEffectsFromTag(compound);
        }
        return List.of();
    }

    public static CompoundTag writeEffectsToTag(List<Pair<MobEffectInstance, Float>> effects) {
        CompoundTag compound = new CompoundTag();

        if (!effects.isEmpty()) {
            int i = 0;

            for (Pair<MobEffectInstance, Float> pair : effects) {
                CompoundTag effect = new CompoundTag();
                pair.getFirst().writeCurativeItems(effect);
                effect.putFloat(TAG_PROBABILITY, pair.getSecond());
                compound.put(String.valueOf(i), effect);
                i++;
            }
        }
        return compound;
    }

    public static List<Pair<MobEffectInstance, Float>> readEffectsFromTag(CompoundTag effectsNBT) {
        List<Pair<MobEffectInstance, Float>> effects = new ArrayList<>();

        if (!effectsNBT.isEmpty()) {
            for (int i = 0; i < effectsNBT.size(); i++) {
                CompoundTag effect = effectsNBT.getCompound(String.valueOf(i));
                if (!effect.isEmpty()) {
                    Pair<MobEffectInstance, Float> effectPair = Pair.of(MobEffectInstance.load(effect), effect.getFloat(TAG_PROBABILITY));
                    effects.add(effectPair);
                }
            }
        }
        return effects;
    }

    public static void spawnItemStackInWorld(Level level, BlockPos pos, ItemStack stack) {
        ItemEntity itemEntity = new ItemEntity(level, pos.getX() + 0.5D, pos.getY() + 0.5D, pos.getZ() + 0.5D, stack);
        itemEntity.setDefaultPickUpDelay();
        level.addFreshEntity(itemEntity);
    }

    @Nullable
    public static <E extends BlockEntity, A extends BlockEntity> BlockEntityTicker<A> getTicker(BlockEntityType<A> type, BlockEntityType<E> targetType, BlockEntityTicker<? super E> ticker) {
        return targetType == type ? (BlockEntityTicker<A>) ticker : null;
    }

    public static boolean isEmpty(ItemStackHandler handler) {
        for (int i = 0; i < handler.getSlots(); i++) {
            if (!handler.getStackInSlot(i).isEmpty()) {
                return false;
            }
        }
        return true;
    }

    public static void dropContents(Level pLevel, BlockPos pPos, ItemStackHandler handler) {
        IntStream.range(0, handler.getSlots() - 1).forEach(i -> Containers.dropItemStack(pLevel, (double) pPos.getX(), (double) pPos.getY(), (double) pPos.getZ(), handler.getStackInSlot(i)));
    }

    // Render Utils
    public static double[] getPosRandomAboveBlockHorizontal(Level level, BlockPos pos) {
        double d0 = 0.5D;
        double d5 = 0.5D - d0;
        double d6 = (double) pos.getX() + d5 + level.random.nextDouble() * d0 * 2.0D;
        //double d7 = (double)pos.getY() + world.rand.nextDouble() * y;
        double d8 = (double) pos.getZ() + d5 + level.random.nextDouble() * d0 * 2.0D;

        return new double[]{d6, d8};
    }
}
