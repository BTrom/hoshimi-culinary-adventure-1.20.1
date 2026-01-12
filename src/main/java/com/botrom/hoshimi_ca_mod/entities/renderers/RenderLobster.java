package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.EntityLobster;
import com.botrom.hoshimi_ca_mod.entities.models.ModelLobster;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class RenderLobster extends MobRenderer<EntityLobster, ModelLobster> {
    private static final ResourceLocation TEXTURE_RED = new ResourceLocation("alexsmobs:textures/entity/lobster_red.png");
    private static final ResourceLocation TEXTURE_BLUE = new ResourceLocation("alexsmobs:textures/entity/lobster_blue.png");
    private static final ResourceLocation TEXTURE_YELLOW = new ResourceLocation("alexsmobs:textures/entity/lobster_yellow.png");
    private static final ResourceLocation TEXTURE_REDBLUE = new ResourceLocation("alexsmobs:textures/entity/lobster_redblue.png");
    private static final ResourceLocation TEXTURE_BLACK = new ResourceLocation("alexsmobs:textures/entity/lobster_black.png");
    private static final ResourceLocation TEXTURE_WHITE = new ResourceLocation("alexsmobs:textures/entity/lobster_white.png");

    public RenderLobster(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new ModelLobster(), 0.25F);
    }

    protected void scale(EntityLobster entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }


    public ResourceLocation getTextureLocation(EntityLobster entity) {
        return switch (entity.getVariant()) {
            case 1 -> TEXTURE_BLUE;
            case 2 -> TEXTURE_YELLOW;
            case 3 -> TEXTURE_REDBLUE;
            case 4 -> TEXTURE_BLACK;
            case 5 -> TEXTURE_WHITE;
            default -> TEXTURE_RED;
        };
    }
}
