package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.entities.DumboOctopusEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class DumboOctopusModel extends DefaultedEntityGeoModel<DumboOctopusEntity> {
    private static final ResourceLocation MODEL = Utils.createResourceLocation("dumbo_octopus");
    private static final ResourceLocation[] TEXTURES = new ResourceLocation[]{
            Utils.createResourceLocation("textures/entity/dumbo_octopus/dumbo_octopus_1.png"),
            Utils.createResourceLocation("textures/entity/dumbo_octopus/dumbo_octopus_2.png"),
            Utils.createResourceLocation("textures/entity/dumbo_octopus/dumbo_octopus_3.png"),
            Utils.createResourceLocation("textures/entity/dumbo_octopus/dumbo_octopus_4.png")};

    public DumboOctopusModel() {
        super(MODEL, false);
    }

    @Override
    public ResourceLocation getTextureResource(DumboOctopusEntity object) {
        return TEXTURES[object.getVariant()];
    }
}
