package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.CombJellyEntity;
import com.botrom.hoshimi_ca_mod.entities.models.CombJellyModel;
import com.botrom.hoshimi_ca_mod.registry.ModRenderTypes;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

import javax.annotation.Nullable;

public class CombJellyRenderer extends MobRenderer<CombJellyEntity, CombJellyModel> {
    private static final ResourceLocation TEXTURE_0 = Utils.createResourceLocation("textures/entity/comb_jelly/comb_jelly_blue.png");
    private static final ResourceLocation TEXTURE_1 = Utils.createResourceLocation("textures/entity/comb_jelly/comb_jelly_green.png");
    private static final ResourceLocation TEXTURE_2 = Utils.createResourceLocation("textures/entity/comb_jelly/comb_jelly_red.png");
    private static final ResourceLocation TEXTURE_OVERLAY = Utils.createResourceLocation("textures/entity/comb_jelly/comb_jelly_overlay.png");
    private static final CombJellyModel STRIPES_MODEL = new CombJellyModel(0.05F);
    public CombJellyRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new CombJellyModel(0.0F), 0.3F);
        this.addLayer(new RainbowLayer(this));
    }

    protected void scale(CombJellyEntity jelly, PoseStack matrixStackIn, float partialTickTime) {
        matrixStackIn.scale(jelly.getJellyScale(), jelly.getJellyScale(), jelly.getJellyScale());
    }

    protected float getFlipDegrees(CombJellyEntity jelly) {
        return 0.0F;
    }

    @Nullable
    protected RenderType getRenderType(CombJellyEntity jelly, boolean normal, boolean invis, boolean outline) {
        ResourceLocation resourcelocation = this.getTextureLocation(jelly);
        if (invis) {
            return RenderType.itemEntityTranslucentCull(resourcelocation);
        } else if (normal) {
            return RenderType.entityTranslucent(resourcelocation);
        } else {
            return outline ? RenderType.outline(resourcelocation) : null;
        }
    }


    public ResourceLocation getTextureLocation(CombJellyEntity entity) {
        return entity.getVariant() == 0 ? TEXTURE_0 : entity.getVariant() == 1 ? TEXTURE_1 : TEXTURE_2;
    }

    static class RainbowLayer extends RenderLayer<CombJellyEntity, CombJellyModel> {

        public RainbowLayer(CombJellyRenderer render) {
            super(render);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, CombJellyEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer rainbow = ModRenderTypes.createMergedVertexConsumer(bufferIn.getBuffer(ModRenderTypes.COMBJELLY_RAINBOW_GLINT), bufferIn.getBuffer(RenderType.entityCutoutNoCull(TEXTURE_OVERLAY)));
            STRIPES_MODEL.setupAnim(entitylivingbaseIn, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            STRIPES_MODEL.renderToBuffer(matrixStackIn, rainbow, packedLightIn, OverlayTexture.NO_OVERLAY, 1, 1, 1, 1.0F);
        }
    }
}
