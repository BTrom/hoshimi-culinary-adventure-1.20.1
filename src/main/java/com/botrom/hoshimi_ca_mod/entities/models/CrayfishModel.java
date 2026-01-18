package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.entities.CrayfishEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class CrayfishModel extends DefaultedEntityGeoModel<CrayfishEntity> {
    private static final ResourceLocation MODEL = Utils.createResourceLocation("crayfish");
    private static final ResourceLocation ANIMATION = Utils.createResourceLocation("animations/entity/crayfish.animation.json");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/crayfish/crayfish.png");

    public CrayfishModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(CrayfishEntity animatable) {
        return TEXTURE;
    }

    @Override
    public ResourceLocation getAnimationResource(CrayfishEntity animatable) {
        return ANIMATION;
    }
}
