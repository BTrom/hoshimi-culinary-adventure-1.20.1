package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.CatfishEntity;
import com.botrom.hoshimi_ca_mod.entities.models.CatfishLargeModel;
import com.botrom.hoshimi_ca_mod.entities.models.CatfishMediumModel;
import com.botrom.hoshimi_ca_mod.entities.models.CatfishSmallModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class CatfishRenderer extends MobRenderer<CatfishEntity, EntityModel<CatfishEntity>> {
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/catfish/catfish_small.png");
    private static final ResourceLocation TEXTURE_MEDIUM = Utils.createResourceLocation("textures/entity/catfish/catfish_medium.png");
    private static final ResourceLocation TEXTURE_LARGE = Utils.createResourceLocation("textures/entity/catfish/catfish_large.png");
    private static final ResourceLocation TEXTURE_SPIT = Utils.createResourceLocation("textures/entity/catfish/catfish_small_spit.png");
    private static final ResourceLocation TEXTURE_SPIT_MEDIUM = Utils.createResourceLocation("textures/entity/catfish/catfish_medium_spit.png");
    private static final ResourceLocation TEXTURE_SPIT_LARGE = Utils.createResourceLocation("textures/entity/catfish/catfish_large_spit.png");
    private final CatfishSmallModel modelSmall = new CatfishSmallModel();
    private final CatfishMediumModel modelMedium = new CatfishMediumModel();
    private final CatfishLargeModel modelLarge = new CatfishLargeModel();

    public CatfishRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CatfishSmallModel(), 0.5F);
    }

    protected void scale(CatfishEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        if (entitylivingbaseIn.getCatfishSize() == 2) {
            model = modelLarge;
        } else if (entitylivingbaseIn.getCatfishSize() == 1) {
            model = modelMedium;
        } else {
            model = modelSmall;
        }
    }

    public ResourceLocation getTextureLocation(CatfishEntity entity) {
        if(entity.getCatfishSize() == 2){
            return entity.isSpitting() ? TEXTURE_SPIT_LARGE : TEXTURE_LARGE;
        }
        if(entity.getCatfishSize() == 1){
            return entity.isSpitting() ? TEXTURE_SPIT_MEDIUM : TEXTURE_MEDIUM;
        }
        return entity.isSpitting() ? TEXTURE_SPIT : TEXTURE;
    }
}
