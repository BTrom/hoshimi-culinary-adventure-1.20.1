package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.KingCrabEntity;
import com.botrom.hoshimi_ca_mod.entities.models.KingCrabModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class KingCrabRenderer extends GeoEntityRenderer<KingCrabEntity> {

    public KingCrabRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new KingCrabModel());
        this.shadowRadius = 0.8F;
    }

    @Override
    public ResourceLocation getTextureLocation(KingCrabEntity kingCrabEntity) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/king_crab.png");
    }

    @Override
    public void render(KingCrabEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1.2F, 1.2F, 1.2F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
