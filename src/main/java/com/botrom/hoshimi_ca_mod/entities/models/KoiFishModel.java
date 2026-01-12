package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.entities.KoiFishEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class KoiFishModel extends DefaultedEntityGeoModel<KoiFishEntity> {
    private static final ResourceLocation MODEL = Utils.createResourceLocation("koi_fish");
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_1.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_2.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_3.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_4.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_5.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_6.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_7.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_8.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_9.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_10.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_11.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_12.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_13.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_14.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_15.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_16.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_17.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_18.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_19.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_20.png"),
            Utils.createResourceLocation("textures/entity/koi_fish/koi_fish_21.png")};

    public KoiFishModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(KoiFishEntity object) {
        return TEXTURES[object.getVariant()];
    }
}
