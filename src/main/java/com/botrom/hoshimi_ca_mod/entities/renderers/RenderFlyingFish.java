package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.FlyingFishEntity;
import com.botrom.hoshimi_ca_mod.entities.models.ModelFlyingFish;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderFlyingFish extends MobRenderer<FlyingFishEntity, ModelFlyingFish> {
    private static final ResourceLocation TEXTURE_0 = new ResourceLocation("hoshimimod:textures/entity/flying_fish/flying_fish_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation("hoshimimod:textures/entity/flying_fish/flying_fish_1.png");
    private static final ResourceLocation TEXTURE_2 = new ResourceLocation("hoshimimod:textures/entity/flying_fish/flying_fish_2.png");

    public RenderFlyingFish(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelFlyingFish(), 0.2F);
    }

    protected void scale(FlyingFishEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.8F, 0.8F, 0.8F);
    }


    public ResourceLocation getTextureLocation(FlyingFishEntity entity) {
        switch (entity.getVariant()){
            case 0:
                return TEXTURE_0;
            case 1:
                return TEXTURE_1;
            case 2:
                return TEXTURE_2;
        }
        return TEXTURE_0;
    }
}
