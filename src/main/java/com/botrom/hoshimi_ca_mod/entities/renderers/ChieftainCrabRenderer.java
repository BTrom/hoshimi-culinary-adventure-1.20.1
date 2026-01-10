package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.ChieftainCrab;
import com.botrom.hoshimi_ca_mod.entities.models.ChieftainCrabModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import org.jetbrains.annotations.NotNull;

@OnlyIn(Dist.CLIENT)
public class ChieftainCrabRenderer extends MobRenderer<ChieftainCrab, ChieftainCrabModel> {
	private static final String resource = "chieftain_crab";
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(Utils.createResourceLocation(resource), "main");
	private static final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/" + resource + "/" + resource + ".png");

	public ChieftainCrabRenderer(EntityRendererProvider.Context manager) {
		super(manager, new ChieftainCrabModel(manager.bakeLayer(LAYER_LOCATION)), 0.4F);
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull ChieftainCrab pEntity) {
		return TEXTURE;
	}

	@Override
	protected void setupRotations(@NotNull ChieftainCrab entityLiving, @NotNull PoseStack stack, float pAgeInTicks, float pRotationYaw, float pPartialTicks) {
		super.setupRotations(entityLiving, stack, pAgeInTicks, pRotationYaw, pPartialTicks);
	}
}