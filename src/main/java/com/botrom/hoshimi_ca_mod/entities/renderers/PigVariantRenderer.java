package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.PigVariant;
import com.botrom.hoshimi_ca_mod.entities.PigVariants;
import com.botrom.hoshimi_ca_mod.entities.models.ColdPigModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.VariantHolder;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.VariantUtils;
import com.google.common.collect.Maps;
import net.minecraft.client.model.PigModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Pig;

import java.util.Map;
import java.util.Optional;

public class PigVariantRenderer {
    public static final ModelLayerLocation COLD_PIG = new ModelLayerLocation(Utils.createResourceLocation("cold_pig"), "main");
    protected final Map<PigVariant.ModelType, PigModel<Pig>> modelByVariant;

    public PigVariantRenderer(EntityRendererProvider.Context context) {
        this.modelByVariant = this.bakeModels(context);
    }

    public Map<PigVariant.ModelType, PigModel<Pig>> bakeModels(EntityRendererProvider.Context context) {
        Map<PigVariant.ModelType, PigModel<Pig>> map = Maps.newEnumMap(PigVariant.ModelType.class);
        map.put(PigVariant.ModelType.NORMAL, null);
        map.put(PigVariant.ModelType.COLD, new ColdPigModel<>(context.bakeLayer(COLD_PIG)));
        return map;
    }

    public ResourceLocation getTexture(Pig entity) {
        PigVariant variant = VariantHolder.<PigVariant>vb$getVariantHolder(entity).vb$getVariant();
        return variant != null && !VariantUtils.matches(ModBuiltinRegistries.PIG_VARIANTS, variant, PigVariants.TEMPERATE)
            ? variant.modelAndTexture().asset().path()
            : null;
    }

    public Optional<PigModel<Pig>> getModel(Pig entity) {
        PigVariant variant = VariantHolder.<PigVariant>vb$getVariantHolder(entity).vb$getVariant();
        return variant != null
            ? Optional.ofNullable(this.modelByVariant.get(variant.modelAndTexture().model()))
            : Optional.empty();
    }
}