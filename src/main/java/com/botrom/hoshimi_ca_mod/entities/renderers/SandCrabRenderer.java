package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.SandCrabEntity;
import com.botrom.hoshimi_ca_mod.entities.models.SandCrabModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class SandCrabRenderer extends GeoEntityRenderer<SandCrabEntity> {

    public SandCrabRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new SandCrabModel());
        this.shadowRadius = 0.2f;
    }

    @Override
    public ResourceLocation getTextureLocation(SandCrabEntity sandCrabEntity) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/sand_crab.png");
    }

    @Override
    public void render(SandCrabEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
