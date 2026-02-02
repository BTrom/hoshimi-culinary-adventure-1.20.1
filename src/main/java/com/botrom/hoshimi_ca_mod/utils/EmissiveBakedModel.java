package com.botrom.hoshimi_ca_mod.utils;

import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.ItemOverrides;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.model.BakedModel;
import net.minecraft.core.Direction;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.client.model.BakedModelWrapper;
import net.minecraftforge.client.model.data.ModelData;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class EmissiveBakedModel implements BakedModel {
    private final BakedModel baseModel;
    private final BakedModel emissiveModel;

    public EmissiveBakedModel(BakedModel baseModel, BakedModel emissiveModel) {
        this.baseModel = baseModel;
        this.emissiveModel = emissiveModel;
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState state, @Nullable Direction side, @NotNull RandomSource rand, @NotNull ModelData data, @Nullable RenderType renderType) {
        List<BakedQuad> combinedQuads = new ArrayList<>();

        // 1. Get the normal bush quads
        combinedQuads.addAll(baseModel.getQuads(state, side, rand, data, renderType));

        // 2. Get the emissive quads and make them glow
        List<BakedQuad> emissiveQuads = emissiveModel.getQuads(state, side, rand, data, renderType);
        for (BakedQuad quad : emissiveQuads) {
            // We create a copy of the quad with max light levels
            combinedQuads.add(makeEmissive(quad));
        }

        return combinedQuads;
    }

    @Override
    public @NotNull List<BakedQuad> getQuads(@Nullable BlockState blockState, @Nullable Direction direction, @NotNull RandomSource randomSource) {
        return getQuads(blockState, direction, randomSource, ModelData.EMPTY, null);
    }

    private BakedQuad makeEmissive(BakedQuad original) {
        int[] vertexData = original.getVertices().clone();

        // The vertex data format is usually [x, y, z, color, u, v, lu, lv]
        // We iterate through the 4 vertices
        int step = vertexData.length / 4;
        for (int i = 0; i < 4; i++) {
            // The lightmap coordinate is usually the 6th element in the vertex stride (index 6)
            // But to be safe in Forge, we set the lightmap to the packed value of (15, 15)
            // 15 (block) << 4 | 15 (sky) << 20.
            // However, simpler implementation:
            // VertexFormat usually puts lightmap at offset 6.

            // Set Block Light (0-15) and Sky Light (0-15) to max
            // Packed Light map: (sky << 16) | block.
            // Vanilla Full bright is often 0x00F000F0 (decimal 15728880)

            vertexData[i * step + 6] = 0x00F000F0;
        }

        // To prevent Z-fighting (flickering), you might need a tiny scale transform,
        // but often if the textures are perfectly aligned it's okay.
        // If it flickers, we can manually nudge the XYZ here.

        return new BakedQuad(vertexData, original.getTintIndex(), original.getDirection(), original.getSprite(), original.isShade());
    }

    @Override
    public boolean useAmbientOcclusion() { return baseModel.useAmbientOcclusion(); }
    @Override
    public boolean isGui3d() { return baseModel.isGui3d(); }
    @Override
    public boolean usesBlockLight() { return baseModel.usesBlockLight(); }
    @Override
    public boolean isCustomRenderer() { return baseModel.isCustomRenderer(); }
    @Override
    public TextureAtlasSprite getParticleIcon() { return baseModel.getParticleIcon(); }
    @Override
    public ItemOverrides getOverrides() { return baseModel.getOverrides(); }
}