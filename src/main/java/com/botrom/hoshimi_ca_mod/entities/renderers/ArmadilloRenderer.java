package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.Armadillo;
import com.botrom.hoshimi_ca_mod.entities.models.ArmadilloModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;

public class ArmadilloRenderer extends MobRenderer<Armadillo, ArmadilloModel> {
	private static final ResourceLocation ARMADILLO_LOCATION = Utils.createResourceLocation("textures/entity/armadillo/armadillo.png");
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation("armadillo"), "main");

	public ArmadilloRenderer(EntityRendererProvider.Context context) {
		super(context, new ArmadilloModel(context.bakeLayer(LAYER_LOCATION)), 0.4F);
	}

	@Override
	public ResourceLocation getTextureLocation(Armadillo armadillo) {
		return ARMADILLO_LOCATION;
	}
}