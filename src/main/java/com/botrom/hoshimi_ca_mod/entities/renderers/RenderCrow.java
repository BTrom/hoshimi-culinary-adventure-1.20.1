package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.EntityCrow;
import com.botrom.hoshimi_ca_mod.entities.models.ModelCrow;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderCrow extends MobRenderer<EntityCrow, ModelCrow> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("hoshimimod:textures/entity/crow/crow.png");

    public RenderCrow(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelCrow(), 0.2F);
        this.addLayer(new LayerCrowItem(this));
    }

    protected void scale(EntityCrow entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }


    public ResourceLocation getTextureLocation(EntityCrow entity) {
        return TEXTURE;
    }
}
