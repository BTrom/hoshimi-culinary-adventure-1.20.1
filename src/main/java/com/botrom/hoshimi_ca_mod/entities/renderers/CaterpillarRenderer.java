package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.Caterpillar;
import com.botrom.hoshimi_ca_mod.entities.models.CaterpillarModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

//@Environment(EnvType.CLIENT)
public class CaterpillarRenderer extends GeoEntityRenderer<Caterpillar> {
    public CaterpillarRenderer(EntityRendererProvider.Context renderManager) {
        super(renderManager, new CaterpillarModel());
        this.shadowRadius = 0.3F;
    }

    @Override
    public float getMotionAnimThreshold(Caterpillar animatable) {
        return 0.000001f;
    }

   public RenderType getRenderType(Caterpillar entity, float partialTicks, PoseStack stack, @Nullable MultiBufferSource renderTypeBuffer, @Nullable VertexConsumer vertexBuilder, int packedLightIn, ResourceLocation textureLocation) {
        return RenderType.entityCutoutNoCull(textureLocation);
    }
}
