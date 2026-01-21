package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.CoconutCrab;
import com.botrom.hoshimi_ca_mod.entities.models.CoconutCrabModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CoconutCrabRenderer extends MobRenderer<CoconutCrab, CoconutCrabModel> {

    public CoconutCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new CoconutCrabModel(context.bakeLayer(CoconutCrabModel.LAYER_LOCATION)), 0.6F);
    }

    @Override
    public ResourceLocation getTextureLocation(CoconutCrab entity) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/coconut_crab/coconut_crab.png");
    }
}