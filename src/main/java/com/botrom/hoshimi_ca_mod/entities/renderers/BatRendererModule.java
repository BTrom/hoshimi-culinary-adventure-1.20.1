package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.models.BatModel;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.Entity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

import java.util.Optional;

@OnlyIn(Dist.CLIENT)
public class BatRendererModule<T extends Entity, M extends EntityModel<T>> {
    private final M model;
    public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("bat"), "main");

    public BatRendererModule(EntityRendererProvider.Context context) {
        this.model = (M) new BatModel(context.bakeLayer(LAYER_LOCATION));
    }

    public ResourceLocation getTexture() {
        return Utils.createResourceLocation("textures/entity/bat/bat.png");
    }

    public boolean enabled() {
        return ModConfig.hasUpdatedBatModel;
    }

    public Optional<M> getModel() {
        return this.enabled() ? Optional.ofNullable(this.model) : Optional.empty();
    }
}