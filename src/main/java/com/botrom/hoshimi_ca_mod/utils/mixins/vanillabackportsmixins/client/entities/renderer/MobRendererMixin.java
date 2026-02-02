package com.botrom.hoshimi_ca_mod.utils.mixins.vanillabackportsmixins.client.entities.renderer;

import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.api.leash.LeashRenderer;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.api.leash.Leashable;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.entity.LivingEntityRenderer;
import net.minecraft.client.renderer.entity.MobRenderer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MobRenderer.class)
public abstract class MobRendererMixin<T extends Mob, M extends EntityModel<T>> extends LivingEntityRenderer<T, M> {
    public MobRendererMixin(EntityRendererProvider.Context context, M model, float shadowRadius) {
        super(context, model, shadowRadius);
    }

    @Unique protected M defaultModel;
    @Unique protected EntityRendererProvider.Context context;
    @Unique private LeashRenderer<T> vb$leashRenderer;

    @Inject(method = "<init>", at = @At("TAIL"))
    private void vb$init(EntityRendererProvider.Context context, M model, float shadowRadius, CallbackInfo ci) {
        this.context = context;
        this.defaultModel = model;
    }

    // Target the specific method that renders leashes in vanilla
    @Inject(method = "renderLeash", at = @At("HEAD"), cancellable = true)
    private <E extends Entity> void vb$cancelVanillaLeash(T entity, float partialTick, PoseStack poseStack, MultiBufferSource bufferSource, E leashHolder, CallbackInfo ci) {
        // If the entity is using our custom Leashable interface, cancel the vanilla render.
        // The custom renderer (e.g. HappyGhastRenderer) is responsible for calling the new LeashRenderer.
        if (entity instanceof Leashable) {
            ci.cancel();
        }
    }

    @Inject(
            method = "render(Lnet/minecraft/world/entity/Mob;FFLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;I)V",
            at = @At(
                    value = "INVOKE",
                    target = "Lnet/minecraft/client/renderer/entity/MobRenderer;renderLeash(Lnet/minecraft/world/entity/Mob;FLcom/mojang/blaze3d/vertex/PoseStack;Lnet/minecraft/client/renderer/MultiBufferSource;Lnet/minecraft/world/entity/Entity;)V"
            ),
            cancellable = true
    )
    private void onRenderLeash(T entity, float entityYaw, float partialTicks, PoseStack poseStack, MultiBufferSource buffer, int packedLight, CallbackInfo ci) {
        // Check if the entity uses the custom Leashable interface
        if (entity instanceof Leashable) {
            // Lazy initialization: Create the renderer only when needed
            if (this.vb$leashRenderer == null) {
                this.vb$leashRenderer = new LeashRenderer<>(this.entityRenderDispatcher);
            }

            // Render the 4 custom ropes (or 1, depending on the entity's setup)
            this.vb$leashRenderer.render(entity, partialTicks, poseStack, buffer);

            // Cancel the vanilla renderLeash call so we don't get the ugly center line
            ci.cancel();
        }
    }
}