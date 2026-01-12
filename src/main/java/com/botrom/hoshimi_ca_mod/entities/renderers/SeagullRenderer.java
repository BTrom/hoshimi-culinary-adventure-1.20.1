package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.SeagullEntity;
import com.botrom.hoshimi_ca_mod.entities.models.SeagullModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.ItemInHandRenderer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public class SeagullRenderer extends MobRenderer<SeagullEntity, SeagullModel> {
    private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/seagull/seagull.png");
    private static final ResourceLocation TEXTURE_WINGULL = Utils.createResourceLocation("textures/entity/seagull/seagull_wingull.png");

    public SeagullRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new SeagullModel(), 0.2F);
        this.addLayer(new LayerHeldItem(this));
    }

    protected void scale(SeagullEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }

    public ResourceLocation getTextureLocation(SeagullEntity entity) {
        return entity.isWingull() ? TEXTURE_WINGULL : TEXTURE;
    }

    static class LayerHeldItem extends RenderLayer<SeagullEntity, SeagullModel> {

        public LayerHeldItem(SeagullRenderer render) {
            super(render);
        }

        public void render(PoseStack matrixStackIn, MultiBufferSource bufferIn, int packedLightIn, SeagullEntity entitylivingbaseIn, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
            ItemStack itemstack = entitylivingbaseIn.getItemBySlot(EquipmentSlot.MAINHAND);
            matrixStackIn.pushPose();
            if (entitylivingbaseIn.isBaby()) {
                matrixStackIn.scale(0.5F, 0.5F, 0.5F);
                matrixStackIn.translate(0.0D, 1.5D, 0D);
            }
            matrixStackIn.pushPose();
            translateToHand(matrixStackIn);
            matrixStackIn.translate(0, -0.24F, -0.25F);
            matrixStackIn.mulPose(Axis.YP.rotationDegrees(-2.5F));
            matrixStackIn.mulPose(Axis.XP.rotationDegrees(-90F));
            ItemInHandRenderer renderer = Minecraft.getInstance().getEntityRenderDispatcher().getItemInHandRenderer();
            renderer.renderItem(entitylivingbaseIn, itemstack, ItemDisplayContext.GROUND, false, matrixStackIn, bufferIn, packedLightIn);
            matrixStackIn.popPose();
            matrixStackIn.popPose();
        }

        protected void translateToHand(PoseStack matrixStack) {
            this.getParentModel().root.translateAndRotate(matrixStack);
            this.getParentModel().body.translateAndRotate(matrixStack);
            this.getParentModel().head.translateAndRotate(matrixStack);

        }
    }
}
