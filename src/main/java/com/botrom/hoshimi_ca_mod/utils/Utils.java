package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.google.gson.JsonArray;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.StringRepresentable;
import net.minecraft.util.Tuple;
import net.minecraft.world.Container;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.*;
import java.util.function.Supplier;

public class Utils {

    public static ResourceLocation createResourceLocation(String path) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, path);
    }

    public static ResourceLocation createForgeResourceLocation(String path) {
        return new ResourceLocation("forge", path);
    }

    public static ItemStack getStack(@Nullable Supplier<? extends ItemLike> r, int... count) { // Only considers first vararg entry
        if (r == null || r.get() == null) return ItemStack.EMPTY;
        return new ItemStack(Objects.requireNonNull(r.get()), count.length > 0 ? count[0] : 1);
    }

    public static boolean removeEffect(@NotNull LivingEntity entity, @NotNull MobEffect effect) {
        if (
                entity.hasEffect(effect) &&
                        !MinecraftForge.EVENT_BUS.post(new MobEffectEvent.Remove(entity, effect)) // True if event is canceled
        ) {
            entity.removeEffect(effect);
            return true;
        }
        return false;
    }

    public static boolean isMoonVisible(Level level) {
        if (!level.dimensionType().natural()) {
            return false;
        } else {
            int ticks = (int) (level.getDayTime() % 24000L);
            return ticks >= 12600 && ticks <= 23400;
        }
    }
}
