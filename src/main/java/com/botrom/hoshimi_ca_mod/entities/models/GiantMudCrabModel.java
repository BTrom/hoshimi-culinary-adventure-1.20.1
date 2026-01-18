package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.GiantMudCrabEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.model.GeoModel;

public class GiantMudCrabModel extends DefaultedEntityGeoModel<GiantMudCrabEntity> {
    private static final ResourceLocation MODEL = Utils.createResourceLocation("giant_mud_crab");
    private static final ResourceLocation ANIMATION = Utils.createResourceLocation("animations/entity/giant_mud_crab.animation.json");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/giant_mud_crab/giant_mud_crab.png");

    public GiantMudCrabModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(GiantMudCrabEntity animatable) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(GiantMudCrabEntity animatable) {
        return ANIMATION;
    }
}
