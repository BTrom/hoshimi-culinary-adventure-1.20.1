package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.FiddlerCrab;
import com.botrom.hoshimi_ca_mod.entities.FiddlerCrabVariant;
import com.botrom.hoshimi_ca_mod.entities.models.FiddlerCrabModel;
import com.google.common.collect.Maps;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.Util;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

import java.util.Map;

public class FiddlerCrabRenderer extends MobRenderer<FiddlerCrab, FiddlerCrabModel<FiddlerCrab>> {
    private static final Map<FiddlerCrabVariant, ResourceLocation> LOCATION_BY_VARIANT =
            Util.make(Maps.newEnumMap(FiddlerCrabVariant.class), map -> {
                map.put(FiddlerCrabVariant.BLACK,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/black_crab.png"));
                map.put(FiddlerCrabVariant.BLUE,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/blue_crab.png"));
                map.put(FiddlerCrabVariant.BROWN,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/brown_crab.png"));
                map.put(FiddlerCrabVariant.CYAN,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/cyan_crab.png"));
                map.put(FiddlerCrabVariant.GRAY,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/gray_crab.png"));
                map.put(FiddlerCrabVariant.GREEN,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/green_crab.png"));
                map.put(FiddlerCrabVariant.LIGHT_BLUE,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/light_blue_crab.png"));
                map.put(FiddlerCrabVariant.LIGHT_GRAY,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/light_gray_crab.png"));
                map.put(FiddlerCrabVariant.LIME,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/lime_crab.png"));
                map.put(FiddlerCrabVariant.MAGENTA,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/magenta_crab.png"));
                map.put(FiddlerCrabVariant.ORANGE,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/orange_crab.png"));
                map.put(FiddlerCrabVariant.PINK,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/pink_crab.png"));
                map.put(FiddlerCrabVariant.PURPLE,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/purple_crab.png"));
                map.put(FiddlerCrabVariant.RED,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/red_crab.png"));
                map.put(FiddlerCrabVariant.WHITE,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/white_crab.png"));
                map.put(FiddlerCrabVariant.YELLOW,
                        new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/fiddler_crab/yellow_crab.png"));
            });

    public FiddlerCrabRenderer(EntityRendererProvider.Context context) {
        super(context, new FiddlerCrabModel(context.bakeLayer(FiddlerCrabModel.LAYER_LOCATION)), 0.3f);
    }

    @Override
    public ResourceLocation getTextureLocation(FiddlerCrab entity) {
        return LOCATION_BY_VARIANT.get(entity.getVariant());
    }

    @Override
    public void render(FiddlerCrab entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        if(entity.isBaby()) {
            poseStack.scale(0.5f, 0.5f, 0.5f);
        } else {
            poseStack.scale(1f, 1f, 1f);
        }

        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }
}