package com.botrom.hoshimi_ca_mod.entities.renderers;

import com.botrom.hoshimi_ca_mod.blocks.CopperGolemStatueBlock;
import com.botrom.hoshimi_ca_mod.blocks.entities.CopperGolemStatueBlockEntity;
import com.botrom.hoshimi_ca_mod.entities.models.CopperGolemModel;
import com.botrom.hoshimi_ca_mod.entities.models.CopperGolemStatueModel;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.CopperGolemOxidationLevels;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.state.BlockState;

import java.util.HashMap;
import java.util.Map;

public class CopperGolemStatueRenderer implements BlockEntityRenderer<CopperGolemStatueBlockEntity> {
    private final Map<CopperGolemStatueBlock.Pose, CopperGolemStatueModel> models = new HashMap<>();

    public CopperGolemStatueRenderer(BlockEntityRendererProvider.Context context) {
        // Register each pose with its own model layer
        this.models.put(CopperGolemStatueBlock.Pose.STANDING, 
            new CopperGolemStatueModel(context.bakeLayer(CopperGolemModel.STATUE_STANDING)));
        this.models.put(CopperGolemStatueBlock.Pose.RUNNING, 
            new CopperGolemStatueModel(context.bakeLayer(CopperGolemModel.STATUE_RUNNING)));
        this.models.put(CopperGolemStatueBlock.Pose.SITTING, 
            new CopperGolemStatueModel(context.bakeLayer(CopperGolemModel.STATUE_SITTING)));
        this.models.put(CopperGolemStatueBlock.Pose.STAR, 
            new CopperGolemStatueModel(context.bakeLayer(CopperGolemModel.STATUE_STAR)));
    }

    @Override
    public void render(CopperGolemStatueBlockEntity blockEntity, float partialTick, PoseStack poseStack,
                       MultiBufferSource bufferSource, int packedLight, int packedOverlay) {
        BlockState blockState = blockEntity.getBlockState();
        
        if (!(blockState.getBlock() instanceof CopperGolemStatueBlock statueBlock)) {
            return;
        }

        // Get the pose and facing direction
        CopperGolemStatueBlock.Pose pose = blockState.getValue(CopperGolemStatueBlock.POSE);
        Direction facing = blockState.getValue(CopperGolemStatueBlock.FACING);
        if (blockEntity.getLevel() == null) {
            facing = Direction.SOUTH;
        }
        
        // Get the appropriate model for this pose
        CopperGolemStatueModel model = this.models.get(pose);
        if (model == null) {
            return;
        }

        // Get the texture based on oxidation level
        ResourceLocation texture = CopperGolemOxidationLevels.getOxidationLevel(
            statueBlock.getWeatheringState()
        ).texture();

        // Setup rendering
        poseStack.pushPose();
        poseStack.translate(0.5D, 0.0D, 0.5D); // Center in block
        
        // Setup model animation (rotation based on facing)
        model.setupAnim(facing);
        
        // Render the model
        RenderType renderType = RenderType.entityCutoutNoCull(texture);
        model.renderToBuffer(
            poseStack,
            bufferSource.getBuffer(renderType),
            packedLight,
            packedOverlay,
            1.0F, 1.0F, 1.0F, 1.0F // RGBA color in 1.20.1
        );
        
        poseStack.popPose();
    }
}

