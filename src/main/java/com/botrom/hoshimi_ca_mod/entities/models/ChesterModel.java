package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class ChesterModel extends DefaultedEntityGeoModel<Chester> {
//    private static final ResourceLocation ANIMATION = Utils.createResourceLocation("chester");
    private static final ResourceLocation MODEL = Utils.createResourceLocation("chester");
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/chester/chester.png");

    public ChesterModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(Chester object) {
        return TEXTURE;
    }
}
