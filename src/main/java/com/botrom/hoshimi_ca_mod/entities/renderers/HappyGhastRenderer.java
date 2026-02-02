package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.HappyGhast;
import com.botrom.hoshimi_ca_mod.entities.models.HappyGhastHarnessModel;
import com.botrom.hoshimi_ca_mod.entities.models.HappyGhastModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class HappyGhastRenderer extends MobRenderer<HappyGhast, HappyGhastModel<HappyGhast>> {
    private static final ResourceLocation GHAST_LOCATION = Utils.createResourceLocation("textures/entity/ghast/happy_ghast.png");
    private static final ResourceLocation GHAST_BABY_LOCATION = Utils.createResourceLocation("textures/entity/ghast/happy_ghast_baby.png");
    private static final ResourceLocation GHAST_ROPES = Utils.createResourceLocation("textures/entity/ghast/happy_ghast_ropes.png");
    private final HappyGhastModel<HappyGhast> adultModel;
    private final HappyGhastModel<HappyGhast> babyModel;

    public static final ModelLayerLocation HAPPY_GHAST_LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("happy_ghast"), "main");
    public static final ModelLayerLocation HAPPY_GHAST_BABY_LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("happy_ghast"), "baby");
    public static final ModelLayerLocation HAPPY_GHAST_HARNESS_LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("happy_ghast"), "harness");
    public static final ModelLayerLocation HAPPY_GHAST_ROPES_LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("happy_ghast"), "ropes");
    public static final ModelLayerLocation HAPPY_GHAST_BABY_ROPES_LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("happy_ghast"), "baby_ropes");

    public HappyGhastRenderer(EntityRendererProvider.Context context) {
        super(context, new HappyGhastModel<>(context.bakeLayer(HAPPY_GHAST_LAYER_LOCATION)), 1.5F);
        this.addLayer(new GhastHarnessLayer<>(this, new HappyGhastHarnessModel<>(context.bakeLayer(HAPPY_GHAST_HARNESS_LAYER_LOCATION))));
        this.addLayer(new RopesLayer<>(this, context.getModelSet(), GHAST_ROPES));
        this.adultModel = new HappyGhastModel<>(context.bakeLayer(HAPPY_GHAST_LAYER_LOCATION));
        this.babyModel = new HappyGhastModel<>(context.bakeLayer(HAPPY_GHAST_BABY_LAYER_LOCATION));
    }

    @Override
    public void render(HappyGhast entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight) {
        this.model = entity.isBaby() ? this.babyModel : this.adultModel;
        super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);
    }

    @Override
    public ResourceLocation getTextureLocation(HappyGhast entity) {
        return entity.isBaby() ? GHAST_BABY_LOCATION : GHAST_LOCATION;
    }

    @Override
    protected void scale(HappyGhast entity, PoseStack matrices, float partialTicks) {
        float scale = entity.isBaby() ? 0.95F : 4.0F;
        matrices.scale(scale, scale, scale);
    }
}