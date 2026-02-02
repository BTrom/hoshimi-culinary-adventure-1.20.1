package com.botrom.hoshimi_ca_mod.utils.mixins.vanillabackportsmixins.leashable.client;

import net.minecraft.client.renderer.entity.BoatRenderer;
import net.minecraft.world.entity.vehicle.Boat;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(BoatRenderer.class)
public abstract class BoatRendererMixin extends EntityRendererMixin<Boat> {
}