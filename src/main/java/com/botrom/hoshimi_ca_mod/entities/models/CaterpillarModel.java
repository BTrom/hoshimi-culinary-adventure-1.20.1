package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Caterpillar;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;

//@Environment(EnvType.CLIENT)
public class CaterpillarModel extends GeoModel<Caterpillar> {
    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getModelResource(Caterpillar object) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "geo/entity/caterpillar.geo.json");
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureResource(Caterpillar object) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/caterpillar/caterpillar.png");
    }

    @Override
    public @NotNull ResourceLocation getAnimationResource(Caterpillar animatable) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "animations/entity/caterpillar.rp_anim.json");
    }
}
