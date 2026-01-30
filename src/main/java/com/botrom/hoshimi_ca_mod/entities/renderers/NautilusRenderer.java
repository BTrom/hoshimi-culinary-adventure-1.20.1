package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.entities.Nautilus;
import com.botrom.hoshimi_ca_mod.entities.models.NautilusModel;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.layers.RenderLayer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.MultiBufferSource;

import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack;
import org.jetbrains.annotations.NotNull;

public class NautilusRenderer extends MobRenderer<Nautilus, NautilusModel> {
	// [AI] You must register these LayerLocations in your Client events!
	public static final ModelLayerLocation LAYER_MAIN = new ModelLayerLocation(Utils.createResourceLocation("nautilus"), "main");
	public static final ModelLayerLocation LAYER_BABY = new ModelLayerLocation(Utils.createResourceLocation("nautilus"), "baby");
	public static final ModelLayerLocation LAYER_SADDLE = new ModelLayerLocation(Utils.createResourceLocation("nautilus"), "saddle");
	public static final ModelLayerLocation LAYER_ARMOR = new ModelLayerLocation(Utils.createResourceLocation("nautilus"), "armor");

	private static final ResourceLocation ADULT_TEXTURE = Utils.createResourceLocation("textures/entity/nautilus/nautilus.png");
	private static final ResourceLocation BABY_TEXTURE = Utils.createResourceLocation("textures/entity/nautilus/nautilus_baby.png");

	private final NautilusModel adultModel;
	private final NautilusModel babyModel;

	public NautilusRenderer(EntityRendererProvider.Context context) {
		super(context, new NautilusModel(context.bakeLayer(LAYER_MAIN)), 0.7F);

		this.adultModel = this.getModel();
		this.babyModel = new NautilusModel(context.bakeLayer(LAYER_BABY));

		this.addLayer(new NautilusSaddleLayer(this, context));
		this.addLayer(new NautilusArmorLayer(this, context));
	}

	@Override
	public @NotNull ResourceLocation getTextureLocation(@NotNull Nautilus entity) {
		return entity.isBaby() ? BABY_TEXTURE : ADULT_TEXTURE;
	}

	@Override
	public void render(Nautilus entity, float entityYaw, float partialTicks, @NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight) {
// [AI] Manually swap models based on age
		if (entity.isBaby()) {
			this.model = this.babyModel;
			this.shadowRadius = 0.35F; // Smaller shadow for baby
		} else {
			this.model = this.adultModel;
			this.shadowRadius = 0.7F;
		}
		super.render(entity, entityYaw, partialTicks, poseStack, buffer, packedLight);	}


	// --- Inner Classes for Layers ---

	static class NautilusSaddleLayer extends RenderLayer<Nautilus, NautilusModel> {
		private final ResourceLocation TEXTURE = Utils.createResourceLocation("textures/entity/nautilus/nautilus_saddle.png"); // Adjust path if needed
		private final NautilusModel model;

		public NautilusSaddleLayer(RenderLayerParent<Nautilus, NautilusModel> parent, EntityRendererProvider.Context context) {
			super(parent);
			this.model = new NautilusModel(context.bakeLayer(LAYER_SADDLE));
		}

		@Override
		public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull Nautilus entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
//			ItemStack itemstack = entity.getItemBySlot(EquipmentSlot.SADDLE);
			if (entity.isSaddled()) {
				// Important: Synch the layer model with the parent model (animations/poses)
				this.getParentModel().copyPropertiesTo(this.model);
				this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);

				VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(TEXTURE));
				this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}

	static class NautilusArmorLayer extends RenderLayer<Nautilus, NautilusModel> {
		private final NautilusModel model;

		public NautilusArmorLayer(RenderLayerParent<Nautilus, NautilusModel> parent, EntityRendererProvider.Context context) {
			super(parent);
			this.model = new NautilusModel(context.bakeLayer(LAYER_ARMOR));
		}

		@Override
		public void render(@NotNull PoseStack poseStack, @NotNull MultiBufferSource buffer, int packedLight, @NotNull Nautilus entity, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
			ItemStack itemstack = entity.getItemBySlot(EquipmentSlot.CHEST); // 'Body' usually maps to CHEST in 1.20.1
			if (!itemstack.isEmpty()) {
				// [AI] Simple texture lookup assuming standard naming convention for armor items.
				// In 1.21 this was handled by SimpleEquipmentLayer.
				// You might need a more robust way to get texture from item if you have many armors.
				ResourceLocation texture = Utils.createResourceLocation("textures/entity/nautilus/nautilus_armor.png");

				this.getParentModel().copyPropertiesTo(this.model);
				this.model.prepareMobModel(entity, limbSwing, limbSwingAmount, partialTicks);
				this.model.setupAnim(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch);
				VertexConsumer vertexconsumer = buffer.getBuffer(RenderType.entityCutoutNoCull(texture));
				this.model.renderToBuffer(poseStack, vertexconsumer, packedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
			}
		}
	}
}