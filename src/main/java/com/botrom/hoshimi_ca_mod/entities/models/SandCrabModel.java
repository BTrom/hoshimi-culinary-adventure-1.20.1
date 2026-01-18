package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.SandCrabEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class SandCrabModel extends DefaultedEntityGeoModel<SandCrabEntity> {
    private static final ResourceLocation MODEL = Utils.createResourceLocation("sand_crab");
    private static final ResourceLocation ANIMATION = Utils.createResourceLocation("animations/entity/sand_crab.animation.json");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/sand_crab/sand_crab.png");

    public SandCrabModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(SandCrabEntity animatable) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(SandCrabEntity animatable) {
        return ANIMATION;
    }
}
