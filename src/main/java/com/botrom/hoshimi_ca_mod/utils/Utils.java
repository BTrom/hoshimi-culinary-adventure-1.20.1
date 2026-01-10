package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;
import java.util.function.Supplier;

public class Utils {


    public static ResourceLocation createResourceLocation(String tagName) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, tagName);
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
}
