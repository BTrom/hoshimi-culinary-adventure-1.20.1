package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.LobsterEntity;
import com.botrom.hoshimi_ca_mod.entities.models.LobsterModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class LobsterRenderer extends MobRenderer<LobsterEntity, LobsterModel> {
    private static final ResourceLocation TEXTURE_RED = Utils.createResourceLocation("textures/entity/lobster/lobster_red.png");
    private static final ResourceLocation TEXTURE_BLUE = Utils.createResourceLocation("textures/entity/lobster/lobster_blue.png");
    private static final ResourceLocation TEXTURE_YELLOW = Utils.createResourceLocation("textures/entity/lobster/lobster_yellow.png");
    private static final ResourceLocation TEXTURE_REDBLUE = Utils.createResourceLocation("textures/entity/lobster/lobster_redblue.png");
    private static final ResourceLocation TEXTURE_BLACK = Utils.createResourceLocation("textures/entity/lobster/lobster_black.png");
    private static final ResourceLocation TEXTURE_WHITE = Utils.createResourceLocation("textures/entity/lobster/lobster_white.png");

    public LobsterRenderer(EntityRendererProvider.Context renderManagerIn) {
        super(renderManagerIn, new LobsterModel(), 0.25F);
    }

    protected void scale(LobsterEntity entitylivingbaseIn, PoseStack matrixStackIn, float partialTickTime) {
    }


    public ResourceLocation getTextureLocation(LobsterEntity entity) {
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
