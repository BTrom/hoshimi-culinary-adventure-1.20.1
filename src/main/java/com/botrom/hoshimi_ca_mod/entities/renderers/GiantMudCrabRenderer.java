package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.GiantMudCrabEntity;
import com.botrom.hoshimi_ca_mod.entities.models.GiantMudCrabModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class GiantMudCrabRenderer extends GeoEntityRenderer<GiantMudCrabEntity> {

    public GiantMudCrabRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new GiantMudCrabModel());
        this.shadowRadius = 0.8F;
    }

    @Override
    public ResourceLocation getTextureLocation(GiantMudCrabEntity giantMudCrabEntity) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/giant_mud_crab.png");
    }

    @Override
    public void render(GiantMudCrabEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
