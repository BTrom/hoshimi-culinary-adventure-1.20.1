package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Lizard;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

//@Environment(EnvType.CLIENT)
public class LizardModel extends GeoModel<Lizard> {
    public static final ResourceLocation[] TEXTURE_LOCATIONS = new ResourceLocation[]{
            new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/lizard/beardie.png"),
            new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/lizard/leopard_gecko.png")
    };

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getModelResource(Lizard lizard) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "geo/entity/lizard.geo.json");
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureResource(@NotNull Lizard lizard) {
        return TEXTURE_LOCATIONS[Math.min(lizard.getVariant(), TEXTURE_LOCATIONS.length - 1)];
    }

    @Override
    public @NotNull ResourceLocation getAnimationResource(Lizard lizard) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "animations/entity/lizard.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(@NotNull Lizard entity, long instanceId, AnimationState<Lizard> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        if (animationState == null) return;

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");
        CoreGeoBone tail = this.getAnimationProcessor().getBone("tail");
        CoreGeoBone basiliskBody = this.getAnimationProcessor().getBone("basilisk_body");
        CoreGeoBone basiliskTail = this.getAnimationProcessor().getBone("basilisk_tail");
        CoreGeoBone beardieHead = this.getAnimationProcessor().getBone("beardie_head");
        CoreGeoBone beardieBody = this.getAnimationProcessor().getBone("beardie_body");
        CoreGeoBone gecko = this.getAnimationProcessor().getBone("gecko");

        head.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
        head.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);

        tail.setHidden(!entity.hasTail());
    }
}
