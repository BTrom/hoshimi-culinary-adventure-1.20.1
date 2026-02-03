package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.resources.ResourceLocation;

public record ModelAndTexture<T>(T model, ClientAsset asset) {
    public ModelAndTexture(T model, ResourceLocation path) {
        this(model, new ClientAsset(path));
    }

    public ModelAndTexture(T model, ClientAsset asset) {
        this.model = model;
        this.asset = asset;
    }

    public static <T> MapCodec<ModelAndTexture<T>> codec(Codec<T> codec, T entry) {
        return RecordCodecBuilder.mapCodec((instance) -> {
            return instance.group(codec.optionalFieldOf("model", entry).forGetter(ModelAndTexture::model), ClientAsset.DEFAULT_FIELD_CODEC.forGetter(ModelAndTexture::asset)).apply(instance, ModelAndTexture::new);
        });
    }

    public T model() {
        return this.model;
    }

    public ClientAsset asset() {
        return this.asset;
    }
}