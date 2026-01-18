package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.KingCrabEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class KingCrabModel extends DefaultedEntityGeoModel<KingCrabEntity> {
    private static final ResourceLocation MODEL = Utils.createResourceLocation("king_crab");
    private static final ResourceLocation ANIMATION = Utils.createResourceLocation("animations/entity/king_crab.animation.json");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/king_crab/king_crab.png");

    public KingCrabModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(KingCrabEntity animatable) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(KingCrabEntity animatable) {
        return ANIMATION;
    }
}
