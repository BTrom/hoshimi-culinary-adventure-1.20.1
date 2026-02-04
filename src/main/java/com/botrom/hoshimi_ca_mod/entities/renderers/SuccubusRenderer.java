package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Succubus;
import com.botrom.hoshimi_ca_mod.entities.models.SuccubusModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider.Context;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.layers.CustomHeadLayer;
import net.minecraft.client.renderer.entity.layers.ItemInHandLayer;
import net.minecraft.resources.ResourceLocation;

public class SuccubusRenderer extends MobRenderer<Succubus, SuccubusModel> {
	public static final ResourceLocation[] SUCCUBUS_LOCATIONS = new ResourceLocation[]{
			new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "textures/entity/succubus/succubus.png")};

	public SuccubusRenderer(Context context) {
		super(context, new SuccubusModel(context.bakeLayer(new ModelLayerLocation(Utils.createResourceLocation("succubus"), "main"))), 0.4F);
		this.addLayer(new CustomHeadLayer<>(this, context.getModelSet(), context.getItemInHandRenderer()));
		this.addLayer(new ItemInHandLayer<>(this, context.getItemInHandRenderer()));
	}

	@Override
	public ResourceLocation getTextureLocation(Succubus succubus) {
		return SUCCUBUS_LOCATIONS[succubus.getVariant()];
	}
}
