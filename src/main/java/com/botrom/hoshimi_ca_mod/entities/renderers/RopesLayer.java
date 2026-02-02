package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.HappyGhast;
import com.botrom.hoshimi_ca_mod.entities.models.HappyGhastModel;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.resources.ResourceLocation;

//@Environment(EnvType.CLIENT)
public class RopesLayer<T extends HappyGhast> extends RenderLayer<T, HappyGhastModel<T>> {
    private final RenderType ropes;
    private final HappyGhastModel<T> adultModel;
    private final HappyGhastModel<T> babyModel;

    public RopesLayer(RenderLayerParent<T, HappyGhastModel<T>> renderer, EntityModelSet modelSet, ResourceLocation texture) {
        super(renderer);
        this.ropes = RenderType.entityCutoutNoCull(texture);
        this.adultModel = new HappyGhastModel<>(modelSet.bakeLayer(HappyGhastRenderer.HAPPY_GHAST_ROPES_LAYER_LOCATION));
        this.babyModel = new HappyGhastModel<>(modelSet.bakeLayer(HappyGhastRenderer.HAPPY_GHAST_BABY_ROPES_LAYER_LOCATION));
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource buffer, int packedLight, T entity, float limbSwing, float limbSwingAmount, float partialTick, float ageInTicks, float netHeadYaw, float headPitch) {
        if (entity.isLeashHolder() && entity.isHarnessed()) {
            HappyGhastModel<T> model = entity.isBaby() ? this.babyModel : this.adultModel;
            model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
            model.renderToBuffer(poseStack, buffer.getBuffer(this.ropes), packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        }
    }
}