package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Bird;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import org.jetbrains.annotations.Nullable;
import software.bernie.geckolib.constant.DataTickets;
import software.bernie.geckolib.core.animatable.model.CoreGeoBone;
import software.bernie.geckolib.core.animation.AnimationState;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.model.data.EntityModelData;

//@Environment(EnvType.CLIENT)
public class BirdModel extends GeoModel<Bird> {

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getTextureResource(Bird bird) {
//        if (bird.getType().equals(ModEntities.BLUEJAY.get())) {
//            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/bird/bluejay.png");
//        } else if (bird.getType().equals(ModEntities.CANARY.get())) {
//            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/bird/canary.png");
//        } else
        if (bird.getType().equals(ModEntities.CARDINAL.get())) {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/bird/cardinal.png");
//        } else if (bird.getType().equals(ModEntities.FINCH.get())) {
//            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/bird/finch.png");
//        } else if (bird.getType().equals(ModEntities.ROBIN.get())) {
//            return new ResourceLocation(Naturalist.MOD_ID, "textures/entity/bird/robin.png");
        } else {
            return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/bird/sparrow.png");
        }
    }

    @Override
    @SuppressWarnings("removal")
    public ResourceLocation getModelResource(Bird bird) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "geo/entity/bird.geo.json");
    }

    @Override
    public ResourceLocation getAnimationResource(Bird bird) {
        return new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "animations/entity/bird.rp_anim.json");
    }

    @Override
    public void setCustomAnimations(Bird entity, long instanceId, @Nullable AnimationState<Bird> animationState) {
        super.setCustomAnimations(entity, instanceId, animationState);

        if (animationState == null) return;

        EntityModelData extraDataOfType = animationState.getData(DataTickets.ENTITY_MODEL_DATA);
        CoreGeoBone head = this.getAnimationProcessor().getBone("head");

        head.setRotX(extraDataOfType.headPitch() * Mth.DEG_TO_RAD);
        head.setRotY(extraDataOfType.netHeadYaw() * Mth.DEG_TO_RAD);
    }
}
