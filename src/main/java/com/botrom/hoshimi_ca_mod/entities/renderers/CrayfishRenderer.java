package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.CrayfishEntity;
import com.botrom.hoshimi_ca_mod.entities.models.CrayfishModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

public class CrayfishRenderer extends GeoEntityRenderer<CrayfishEntity> {

    public CrayfishRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CrayfishModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public ResourceLocation getTextureLocation(CrayfishEntity crayfish) {
        String string = crayfish.getName().getString().strip();
        if ("Cooked Crayfish".equals(string)) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/crayfish_cook.png");
        } else {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/crayfish.png");
        }
    }

    @Override
    public void render(CrayfishEntity animatable, float entityYaw, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight) {
        if (animatable.isBaby()) {
            poseStack.scale(0.5F, 0.5F, 0.5F);
        } else {
            poseStack.scale(1.0F, 1.0F, 1.0F);
        }
        super.render(animatable, entityYaw, partialTick, poseStack, bufferSource, packedLight);
    }
}
