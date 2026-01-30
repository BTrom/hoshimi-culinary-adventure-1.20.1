package com.botrom.hoshimi_ca_mod.entities.models;

import com.botrom.hoshimi_ca_mod.entities.Nautilus;
import com.botrom.hoshimi_ca_mod.entities.animations.NautilusAnimation;
import net.minecraft.client.animation.KeyframeAnimations;
import net.minecraft.client.model.HierarchicalModel;
import net.minecraft.util.Mth;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.ModelPart;
import org.jetbrains.annotations.NotNull;

public class NautilusModel extends HierarchicalModel<Nautilus> {
//	private static final float SWIM_ANIMATION_SPEED_MAX = 2.0F;
//	private static final float SWIM_ANIMATION_SCALE_FACTOR = 3.0F;
//	private static final float IDLE_SWIM_ANIMATION_SPEED = 0.2F;
//	private static final float IDLE_SWIM_ANIMATION_SCALE = 5.0F;
	private final ModelPart root;
	private final ModelPart nautilus;
	private final ModelPart body;
//	private final KeyframeAnimations swimAnimation;

	public NautilusModel(ModelPart root) {
		this.root = root;
		this.nautilus = root.getChild("root");
		// 'body' might not exist in Saddle/Armor layers depending on definition, so we check carefully or strictly define layers
		// Based on 1.21 code, body exists in the main mesh.
		this.body = this.nautilus.hasChild("body") ? this.nautilus.getChild("body") : new ModelPart(java.util.Collections.emptyList(), java.util.Collections.emptyMap());
	}

	public static LayerDefinition createBodyLayer() {
		return LayerDefinition.create(createBodyMesh(new CubeDeformation(0.0F)), 128, 128);
	}

	public static LayerDefinition createArmorLayer() {
		// [AI] Created a standard armor layer (inflated body) since 1.21 source was missing.
		// Adjust CubeDeformation(0.25F) if needed.
		return LayerDefinition.create(createBodyMesh(new CubeDeformation(0.25F)), 128, 128);
	}

	// Shared mesh definition for Adult and Armor
	public static MeshDefinition createBodyMesh(CubeDeformation deformation) {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition nautilus = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 29.0F, -6.0F));

		nautilus.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -10.0F, -7.0F, 14.0F, 10.0F, 16.0F, deformation)
				.texOffs(0, 26).addBox(-7.0F, 0.0F, -7.0F, 14.0F, 8.0F, 20.0F, deformation)
				.texOffs(48, 26).addBox(-7.0F, 0.0F, 6.0F, 14.0F, 8.0F, 0.0F, deformation), PartPose.offset(0.0F, -13.0F, 5.0F));

		PartDefinition body = nautilus.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 54).addBox(-5.0F, -4.51F, -3.0F, 10.0F, 8.0F, 14.0F, deformation)
				.texOffs(0, 76).addBox(-5.0F, -4.51F, 7.0F, 10.0F, 8.0F, 0.0F, deformation), PartPose.offset(0.0F, -8.5F, 12.3F));

		body.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(54, 54).addBox(-5.0F, -2.0F, 0.0F, 10.0F, 4.0F, 4.0F, deformation.extend(-0.001F)), PartPose.offset(0.0F, -2.51F, 7.0F));
		body.addOrReplaceChild("inner_mouth", CubeListBuilder.create().texOffs(54, 70).addBox(-3.0F, -2.0F, -0.5F, 6.0F, 4.0F, 4.0F, deformation), PartPose.offset(0.0F, -0.51F, 7.5F));
		body.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(54, 62).addBox(-5.0F, -1.98F, 0.0F, 10.0F, 4.0F, 4.0F, deformation.extend(-0.001F)), PartPose.offset(0.0F, 1.49F, 7.0F));

		return meshdefinition;
	}

	public static LayerDefinition createBabyBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition nautilus = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(-0.5F, 28.0F, -0.5F));

		nautilus.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-6.0F, -4.0F, -1.0F, 7.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 11).addBox(-6.0F, 0.0F, -1.0F, 7.0F, 4.0F, 9.0F, new CubeDeformation(0.0F))
				.texOffs(23, 11).addBox(-6.0F, 0.0F, 5.0F, 7.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(3.0F, -8.0F, -2.0F));

		PartDefinition body = nautilus.addOrReplaceChild("body", CubeListBuilder.create().texOffs(0, 24).addBox(-2.5F, -3.01F, -1.0F, 5.0F, 4.0F, 7.0F, new CubeDeformation(0.0F))
				.texOffs(0, 35).addBox(-2.5F, -3.01F, 4.1F, 5.0F, 4.0F, 0.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, -5.0F, 3.0F));

		body.addOrReplaceChild("upper_mouth", CubeListBuilder.create().texOffs(24, 24).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, -2.01F, 3.9F));
		body.addOrReplaceChild("inner_mouth", CubeListBuilder.create().texOffs(24, 32).addBox(-1.5F, -1.0F, -1.0F, 3.0F, 2.0F, 2.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, -1.01F, 4.9F));
		body.addOrReplaceChild("lower_mouth", CubeListBuilder.create().texOffs(24, 28).addBox(-2.5F, -1.0F, 0.0F, 5.0F, 2.0F, 2.0F, new CubeDeformation(-0.001F)), PartPose.offset(0.0F, -0.01F, 3.9F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}

	public static LayerDefinition createSaddleLayer() {
		// [AI] Recreated from 1.21 NautilusSaddleModel - only renders the shell
		MeshDefinition meshdefinition = new MeshDefinition(); // Start fresh
		PartDefinition partdefinition = meshdefinition.getRoot();
		PartDefinition nautilus = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 29.0F, -6.0F));
		nautilus.addOrReplaceChild("shell", CubeListBuilder.create().texOffs(0, 0).addBox(-7.0F, -10.0F, -7.0F, 14.0F, 10.0F, 16.0F, new CubeDeformation(0.2F)), PartPose.offset(0.0F, -13.0F, 5.0F));
		return LayerDefinition.create(meshdefinition, 128, 128);
	}

	@Override
	public @NotNull ModelPart root() {
		return this.root;
	}

	@Override
	public void setupAnim(@NotNull Nautilus entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
		this.root().getAllParts().forEach(ModelPart::resetPose);
		this.applyBodyRotation(netHeadYaw, headPitch);

		// [AI] Mapped 1.21 applyWalk logic to 1.20.1 animateWalk.
		// 1.21 logic: applyWalk(pos + age/5, speed + 0.2, 2.0, 3.0)
		this.animateWalk(NautilusAnimation.SWIMMING, limbSwing + ageInTicks / 5.0F, limbSwingAmount + 0.2F, 2.0F, 3.0F);
	}

	private void applyBodyRotation(float yRot, float xRot) {
		yRot = Mth.clamp(yRot, -10.0F, 10.0F);
		xRot = Mth.clamp(xRot, -10.0F, 10.0F);
		this.body.yRot = yRot * 0.017453292F;
		this.body.xRot = xRot * 0.017453292F;
	}
}