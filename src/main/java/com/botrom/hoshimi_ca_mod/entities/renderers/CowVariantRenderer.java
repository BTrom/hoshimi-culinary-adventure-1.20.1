package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.CowVariant;
import com.botrom.hoshimi_ca_mod.entities.CowVariants;
import com.botrom.hoshimi_ca_mod.entities.models.ColdCowModel;
import com.botrom.hoshimi_ca_mod.entities.models.WarmCowModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.VariantHolder;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.VariantUtils;
import com.google.common.collect.Maps;
import net.minecraft.client.model.CowModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.animal.Cow;

import java.util.Map;
import java.util.Optional;

public class CowVariantRenderer {
    public static final ModelLayerLocation COLD_COW = new ModelLayerLocation(Utils.createResourceLocation("cold_cow"), "main");
    public static final ModelLayerLocation WARM_COW = new ModelLayerLocation(Utils.createResourceLocation("warm_cow"), "main");
    protected final Map<CowVariant.ModelType, CowModel<Cow>> modelByVariant;

    public CowVariantRenderer(EntityRendererProvider.Context context) {
        this.modelByVariant = this.bakeModels(context);
    }

    public Map<CowVariant.ModelType, CowModel<Cow>> bakeModels(EntityRendererProvider.Context context) {
        Map<CowVariant.ModelType, CowModel<Cow>> map = Maps.newEnumMap(CowVariant.ModelType.class);
        map.put(CowVariant.ModelType.NORMAL, null);
        map.put(CowVariant.ModelType.WARM, new WarmCowModel<>(context.bakeLayer(WARM_COW)));
        map.put(CowVariant.ModelType.COLD, new ColdCowModel<>(context.bakeLayer(COLD_COW)));
        return map;
    }

    public ResourceLocation getTexture(Cow entity) {
        CowVariant variant = VariantHolder.<CowVariant>vb$getVariantHolder(entity).vb$getVariant();
        return variant != null && !VariantUtils.matches(ModBuiltinRegistries.COW_VARIANTS, variant, CowVariants.TEMPERATE)
            ? variant.modelAndTexture().asset().path()
            : null;
    }

    public Optional<CowModel<Cow>> getModel(Cow entity) {
        CowVariant variant = VariantHolder.<CowVariant>vb$getVariantHolder(entity).vb$getVariant();
        return variant != null
            ? Optional.ofNullable(this.modelByVariant.get(variant.modelAndTexture().model()))
            : Optional.empty();
    }
}