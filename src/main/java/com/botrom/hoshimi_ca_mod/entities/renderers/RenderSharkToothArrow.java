package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.SharkToothArrowEntity;
import net.minecraft.client.renderer.entity.ArrowRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;

public class RenderSharkToothArrow extends ArrowRenderer<SharkToothArrowEntity> {
    private static final ResourceLocation TEXTURE = new ResourceLocation("hoshimimod:textures/entity/shark_tooth_arrow.png");

    public RenderSharkToothArrow(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn);
    }

    @Override
    public ResourceLocation getTextureLocation(SharkToothArrowEntity entity) {
        return TEXTURE;
    }
}
