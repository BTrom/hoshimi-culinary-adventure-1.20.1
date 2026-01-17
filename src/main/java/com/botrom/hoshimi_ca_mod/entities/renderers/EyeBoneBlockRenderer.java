package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.blocks.entities.EyeBoneBlockEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedBlockGeoModel;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoBlockRenderer;

public class EyeBoneBlockRenderer extends GeoBlockRenderer<EyeBoneBlockEntity> {

    public EyeBoneBlockRenderer(GeoModel<EyeBoneBlockEntity> model) {
        super(model);
    }

    public static class EyeBoneModel extends DefaultedBlockGeoModel<EyeBoneBlockEntity> {
        private static final ResourceLocation MODEL = Utils.createResourceLocation("eye_bone");

        public EyeBoneModel() {
            super(MODEL);
        }

        @Override
        public ResourceLocation getTextureResource(EyeBoneBlockEntity eyeBoneBlockEntity) {
            return eyeBoneBlockEntity.getRespawnCooldown() > 0 ?
                    Utils.createResourceLocation("textures/block/eye_bone.closed.png") :
                    Utils.createResourceLocation("textures/block/eye_bone.open.png");
        }

        @Override
        public ResourceLocation getAnimationResource(EyeBoneBlockEntity eyeBoneBlockEntity) {
            return Utils.createResourceLocation("animations/block/eye_bone.animation.json");
        }
    }
}
