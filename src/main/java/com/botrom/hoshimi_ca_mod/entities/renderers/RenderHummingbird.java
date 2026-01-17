package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.EntityHummingbird;
import com.botrom.hoshimi_ca_mod.entities.models.ModelHummingbird;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderHummingbird extends MobRenderer<EntityHummingbird, ModelHummingbird> {
    private static final ResourceLocation TEXTURE_0 = new ResourceLocation("hoshimimod:textures/entity/hummingbird/hummingbird_0.png");
    private static final ResourceLocation TEXTURE_1 = new ResourceLocation("hoshimimod:textures/entity/hummingbird/hummingbird_1.png");
    private static final ResourceLocation TEXTURE_2 = new ResourceLocation("hoshimimod:textures/entity/hummingbird/hummingbird_2.png");

    public RenderHummingbird(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelHummingbird(), 0.15F);
    }

    protected void scale(EntityHummingbird entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(0.75F, 0.75F, 0.75F);
    }


    public ResourceLocation getTextureLocation(EntityHummingbird entity) {
        return entity.getVariant() == 0 ? TEXTURE_0 : entity.getVariant() == 1 ? TEXTURE_1 : TEXTURE_2;
    }
}
