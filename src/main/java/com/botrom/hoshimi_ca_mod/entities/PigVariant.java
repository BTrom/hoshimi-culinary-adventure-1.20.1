package com.botrom.hoshimi_ca_mod.entities;

import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.*;
import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.StringRepresentable;

import java.util.List;

public record PigVariant(ModelAndTexture<ModelType> modelAndTexture, SpawnPrioritySelectors spawnConditions) implements PriorityProvider<SpawnContext, SpawnCondition> {
    public static final Codec<PigVariant> CODEC = RecordCodecBuilder.create(instance -> instance.group(
        ModelAndTexture.codec(ModelType.CODEC, ModelType.NORMAL).forGetter(PigVariant::modelAndTexture),
        SpawnPrioritySelectors.CODEC.fieldOf("spawn_conditions").forGetter(PigVariant::spawnConditions)
    ).apply(instance, PigVariant::new));

    private PigVariant(ModelAndTexture<ModelType> modelAndTexture) {
        this(modelAndTexture, SpawnPrioritySelectors.EMPTY);
    }

    @Override
    public List<Selector<SpawnContext, SpawnCondition>> selectors() {
        return this.spawnConditions.selectors();
    }

    public enum ModelType implements StringRepresentable {
        NORMAL("normal"),
        COLD("cold");

        public static final Codec<ModelType> CODEC = StringRepresentable.fromEnum(ModelType::values);
        private final String name;

        ModelType(String name) {
            this.name = name;
        }

        @Override
        public String getSerializedName() {
            return this.name;
        }
    }
}