package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.Shiba;
import com.botrom.hoshimi_ca_mod.entities.models.ShibaModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.QuarkModelHandler;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import org.jetbrains.annotations.NotNull;

public class ShibaRenderer extends MobRenderer<Shiba, ShibaModel> {

	private static final ResourceLocation[] SHIBA_BASES = {
			Utils.createResourceLocation("textures/entity/shiba/shiba0.png"),
			Utils.createResourceLocation("textures/entity/shiba/shiba1.png"),
			Utils.createResourceLocation("textures/entity/shiba/shiba2.png")
	};

	private static final ResourceLocation SHIBA_RARE = Utils.createResourceLocation("textures/entity/shiba/shiba_rare.png");
	private static final ResourceLocation SHIBA_DOGE = Utils.createResourceLocation("textures/entity/shiba/shiba_doge.png");

	public ShibaRenderer(EntityRendererProvider.Context context) {
		super(context, QuarkModelHandler.model(QuarkModelHandler.getShiba()), 0.5F);
		addLayer(new ShibaCollarLayer(this));
		addLayer(new ShibaMouthItemLayer(this, context.getItemInHandRenderer()));
	}

	@NotNull
	@Override
	public ResourceLocation getTextureLocation(Shiba entity) {
		if(entity.hasCustomName() && entity.getCustomName().getString().trim().equalsIgnoreCase("doge"))
			return SHIBA_DOGE;

		long least = Math.abs(entity.getUUID().getLeastSignificantBits());
		if((least % 200) == 0)
			return SHIBA_RARE;

		int type = (int) (least % SHIBA_BASES.length);
		return SHIBA_BASES[type];
	}

}
