package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.biomes;

import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.AdditionalCodecs;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.SpawnCondition;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.SpawnContext;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.biome.Biome;

// 1. Change record component from HolderSet to TagKey
public record BiomeCheck(TagKey<Biome> tag) implements SpawnCondition {

    // 2. Update Codec to serialize a TagKey directly
    public static final Codec<BiomeCheck> CODEC = RecordCodecBuilder.create(instance -> instance.group(
            TagKey.codec(Registries.BIOME).fieldOf("tag").forGetter(BiomeCheck::tag)
    ).apply(instance, BiomeCheck::new));

    @Override
    public boolean test(SpawnContext context) {
        // 3. Check the tag dynamically at runtime using the biome Holder
        return context.biome().is(this.tag);
    }

    @Override
    public Codec<? extends SpawnCondition> codec() {
        return CODEC;
    }
}