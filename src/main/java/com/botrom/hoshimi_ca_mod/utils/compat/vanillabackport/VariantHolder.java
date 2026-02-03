package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.LivingEntity;

@SuppressWarnings("unchecked")
public interface VariantHolder<T> {
    static <T> VariantHolder<T> vb$getVariantHolder(LivingEntity entity) {
        return entity instanceof VariantHolder<?> ? (VariantHolder<T>) entity : null;
    }

    static void vb$trySetOffspringVariant(LivingEntity child, LivingEntity father, LivingEntity mother) {
        if (ModConfig.hasFarmAnimalVariants) return;

        RandomSource random = father.getRandom();
        vb$getVariantHolder(child).vb$setVariant(random.nextBoolean() ? vb$getVariantHolder(father).vb$getVariant() : vb$getVariantHolder(mother).vb$getVariant());
    }

    T vb$getVariant();

    void vb$setVariant(T variant);
}