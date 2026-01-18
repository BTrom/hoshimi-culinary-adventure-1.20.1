package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Butterfly;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.model.GeoModel;

//@Environment(EnvType.CLIENT)
public class ButterflyModel extends GeoModel<Butterfly> {
    @Override
    @SuppressWarnings("removal")
    public @NotNull ResourceLocation getModelResource(Butterfly butterfly) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "geo/entity/butterfly.geo.json");
    }

    @Override
    @SuppressWarnings("removal")
    public @NotNull ResourceLocation getTextureResource(Butterfly butterfly) {
        if (butterfly.getVariant().getName().equals("cabbage_white")) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/butterfly/cabbage_white.png");
        } else if (butterfly.getVariant().getName().equals("monarch")) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/butterfly/monarch.png");
        } else if (butterfly.getVariant().getName().equals("clouded_yellow")) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/butterfly/clouded_yellow.png");
        } else if (butterfly.getVariant().getName().equals("swallowtail")) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/butterfly/swallowtail.png");
        } else if (butterfly.getVariant().getName().equals("blue_morpho")) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/butterfly/blue_morpho.png");
        } else {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/butterfly/monarch.png");
        }
    }

    @Override
    public ResourceLocation getAnimationResource(Butterfly butterfly) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "animations/entity/butterfly.rp_anim.json");
    }
}
