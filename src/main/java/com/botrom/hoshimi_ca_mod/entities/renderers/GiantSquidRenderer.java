package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.GiantSquidEntity;
import com.botrom.hoshimi_ca_mod.entities.GiantSquidPartEntity;
import com.botrom.hoshimi_ca_mod.entities.models.GiantSquidModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;

public class GiantSquidRenderer extends MobRenderer<GiantSquidEntity, GiantSquidModel> {
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/giant_squid/giant_squid.png");
    private static final ResourceLocation TEXTURE_BLUE = Utils.createResourceLocation("textures/entity/giant_squid/giant_squid_blue.png");
    private static final ResourceLocation TEXTURE_DEPRESSURIZED = Utils.createResourceLocation("textures/entity/giant_squid/giant_squid_depressurized.png");

    public GiantSquidRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new GiantSquidModel(), 1F);
        this.addLayer(new LayerDepressurization(this));
    }

    protected float getFlipDegrees(GiantSquidEntity squid) {
        return 0.0F;
    }

    public boolean shouldRender(GiantSquidEntity livingEntityIn, Frustum camera, double camX, double camY, double camZ) {
        if(livingEntityIn.isCaptured() && livingEntityIn.isAlive()){
            return false;
        }
        if (super.shouldRender(livingEntityIn, camera, camX, camY, camZ)) {
            return true;
        } else {
            for (GiantSquidPartEntity part : livingEntityIn.allParts) {
                if (camera.isVisible(part.getBoundingBox())) {
                    return true;
                }
            }
            return false;
        }
    }

    protected void scale(GiantSquidEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }

    public ResourceLocation getTextureLocation(GiantSquidEntity entity) {
        return entity.isBlue() ? TEXTURE_BLUE : TEXTURE;
    }

    static class LayerDepressurization extends RenderLayer<GiantSquidEntity, GiantSquidModel> {

        public LayerDepressurization(GiantSquidRenderer render) {
            super(render);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, GiantSquidEntity squid, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            VertexConsumer ivertexbuilder = bufferIn.getBuffer(RenderType.entityTranslucent(TEXTURE_DEPRESSURIZED));
            float alpha = squid.prevDepressurization + (squid.getDepressurization() - squid.prevDepressurization) * partialTicks;
            this.getParentModel().renderToBuffer(matrixStackIn, ivertexbuilder, packedLightIn, LivingEntityRenderer.getOverlayCoords(squid, 0.0F), 1.0F, 1.0F, 1.0F, alpha);
        }
    }
}
