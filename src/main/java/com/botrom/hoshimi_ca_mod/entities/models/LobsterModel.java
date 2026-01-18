package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.entities.LobsterEntity;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.AMMaths;
import com.github.alexthe666.citadel.client.model.AdvancedEntityModel;
import com.github.alexthe666.citadel.client.model.AdvancedModelBox;
import com.github.alexthe666.citadel.client.model.basic.BasicModelPart;
import com.google.common.collect.ImmutableList;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import software.bernie.geckolib.model.DefaultedEntityGeoModel;

public class LobsterModel extends DefaultedEntityGeoModel<LobsterEntity> {
	private static final ResourceLocation MODEL = Utils.createResourceLocation("clawster");
	private static final ResourceLocation ANIMATION = Utils.createResourceLocation("animations/entity/clawster.animation.json");
	private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/clawster/clawster.png");

	public LobsterModel() {
		super(MODEL, false);
	}

	@Override
	public ResourceLocation getTextureResource(LobsterEntity lobsterModel) {
		return TEXTURE;
	}

	@Override
	public ResourceLocation getAnimationResource(LobsterEntity lobsterModel) {
		return ANIMATION;
	}
}