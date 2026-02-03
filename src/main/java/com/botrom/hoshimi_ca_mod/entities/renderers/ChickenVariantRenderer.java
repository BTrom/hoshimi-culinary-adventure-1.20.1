package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.ChickenVariant;
import com.botrom.hoshimi_ca_mod.entities.ChickenVariants;
import com.botrom.hoshimi_ca_mod.entities.models.ColdChickenModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.VariantHolder;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.VariantUtils;
import com.google.common.collect.Maps;
import net.minecraft.client.model.ChickenModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Chicken;

import java.util.Map;
import java.util.Optional;

public class ChickenVariantRenderer {
    public static final ModelLayerLocation COLD_CHICKEN = new ModelLayerLocation(Utils.createResourceLocation("cold_chicken"), "main");
    protected final Map<ChickenVariant.ModelType, ChickenModel<Chicken>> modelByVariant;

    public ChickenVariantRenderer(EntityRendererProvider.Context context) {
        this.modelByVariant = this.bakeModels(context);
    }

    public Map<ChickenVariant.ModelType, ChickenModel<Chicken>> bakeModels(EntityRendererProvider.Context context) {
        Map<ChickenVariant.ModelType, ChickenModel<Chicken>> map = Maps.newEnumMap(ChickenVariant.ModelType.class);
        map.put(ChickenVariant.ModelType.NORMAL, null);
        map.put(ChickenVariant.ModelType.COLD, new ColdChickenModel<>(context.bakeLayer(COLD_CHICKEN)));
        return map;
    }

    public ResourceLocation getTexture(Chicken entity) {
        ChickenVariant variant = VariantHolder.<ChickenVariant>vb$getVariantHolder(entity).vb$getVariant();
        return variant != null && !VariantUtils.matches(ModBuiltinRegistries.CHICKEN_VARIANTS, variant, ChickenVariants.TEMPERATE)
            ? variant.modelAndTexture().asset().path()
            : null;
    }

    public Optional<ChickenModel<Chicken>> getModel(Chicken entity) {
        ChickenVariant variant = VariantHolder.<ChickenVariant>vb$getVariantHolder(entity).vb$getVariant();
        return variant != null
            ? Optional.ofNullable(this.modelByVariant.get(variant.modelAndTexture().model()))
            : Optional.empty();
    }
}