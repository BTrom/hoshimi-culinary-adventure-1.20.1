package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.mojang.blaze3d.systems.RenderSystem;
import com.mojang.blaze3d.vertex.DefaultVertexFormat;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.VertexFormat;
import com.mojang.blaze3d.vertex.VertexMultiConsumer;
import net.minecraft.Util;
import net.minecraft.client.renderer.GameRenderer;
import net.minecraft.client.renderer.RenderStateShard;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.resources.ResourceLocation;
import org.joml.Matrix4f;

public class ModRenderTypes extends RenderType {

    public static final ResourceLocation STATIC_TEXTURE = new ResourceLocation(HoshimiCulinaryMod.MOD_ID + ":textures/static.png");
    private static boolean encounteredMultiConsumerError = false;

    public ModRenderTypes(String pName, VertexFormat pFormat, VertexFormat.Mode pMode, int pBufferSize, boolean pAffectsCrumbling, boolean pSortOnUpload, Runnable pSetupState, Runnable pClearState) {
        super(pName, pFormat, pMode, pBufferSize, pAffectsCrumbling, pSortOnUpload, pSetupState, pClearState);
    }


    protected static final RenderStateShard.TexturingStateShard COMB_JELLY_TEXTURING = new RenderStateShard.TexturingStateShard("entity_glint_texturing", () -> {
        setupRainbowTexturing(2F, 16L);
    }, () -> {
        RenderSystem.resetTextureMatrix();
    });

    public static final RenderType COMBJELLY_RAINBOW_GLINT = RenderType.create("cj_rainbow_glint", DefaultVertexFormat.POSITION_TEX, VertexFormat.Mode.QUADS, 256, false, false, RenderType.CompositeState.builder().setShaderState(new RenderStateShard.ShaderStateShard(GameRenderer::getRendertypeEntityGlintShader)).setTextureState(new RenderStateShard.TextureStateShard(new ResourceLocation("hoshimimod:textures/entity/rainbow_jelly_overlays/glint_rainbow.png"), true, false)).setWriteMaskState(new RenderStateShard.WriteMaskStateShard(true, true)).setCullState(new RenderStateShard.CullStateShard(false)).setDepthTestState(new RenderStateShard.DepthTestStateShard("==", 514)).setTransparencyState(new RenderStateShard.TransparencyStateShard("no_transparency", () -> {RenderSystem.disableBlend();}, () -> {})).setTexturingState(COMB_JELLY_TEXTURING).createCompositeState(false));



    public static VertexConsumer createMergedVertexConsumer(VertexConsumer consumer1, VertexConsumer consumer2){
        VertexConsumer vertexConsumer = consumer2;
        if(!encounteredMultiConsumerError){
            try{
                vertexConsumer = VertexMultiConsumer.create(consumer1, consumer2);
            }catch (Exception e){
                HoshimiCulinaryMod.loggerWarn("Encountered issue mixing two render types together. Likely an issue with Optifine or other rendering mod. This warning will only display once.");
                encounteredMultiConsumerError = true;
            }
        }
        return vertexConsumer;
    }

    private static void setupRainbowTexturing(float in, long time) {
        long i = Util.getMillis() * time;
        float f = (float)(i % 110000L) / 110000.0F;
        float f1 = (float)(i % 30000L) / 30000.0F;
        Matrix4f matrix4f = (new Matrix4f()).translation(0, f1, 0.0F);
        matrix4f.scale(in);
        RenderSystem.setTextureMatrix(matrix4f);
    }
}
