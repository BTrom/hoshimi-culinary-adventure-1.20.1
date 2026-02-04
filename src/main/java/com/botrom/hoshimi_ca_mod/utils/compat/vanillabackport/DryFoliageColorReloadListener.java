package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.api.DryFoliageColor;
import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.resources.LegacyStuffWrapper;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.packs.resources.ResourceManager;
import net.minecraft.server.packs.resources.SimplePreparableReloadListener;
import net.minecraft.util.profiling.ProfilerFiller;

import java.io.IOException;
import java.io.InputStream;

public class DryFoliageColorReloadListener extends SimplePreparableReloadListener<int[]> {
    private static final ResourceLocation LOCATION = new ResourceLocation("minecraft", "textures/colormap/dry_foliage.png");
    public static final DryFoliageColorReloadListener INSTANCE = new DryFoliageColorReloadListener();

    @Override
    protected int[] prepare(ResourceManager resourceManager, ProfilerFiller profiler) {
        return resourceManager.getResource(LOCATION).map(resource -> {
            try (InputStream stream = resource.open()) {
                NativeImage image = NativeImage.read(stream);
                int w = image.getWidth();
                int h = image.getHeight();
                int[] pixels = new int[w * h];

                for (int y = 0; y < h; y++) {
                    for (int x = 0; x < w; x++) {
                        int color = image.getPixelRGBA(x, y);

                        // NativeImage returns ABGR (0xAABBGGRR) on most systems.
                        // We need to convert it to ARGB (0xAARRGGBB) for the colormap.

                        int alpha = (color >> 24) & 0xFF;
                        int blue  = (color >> 16) & 0xFF;
                        int green = (color >> 8)  & 0xFF;
                        int red   = (color)       & 0xFF;

                        // Reassemble as ARGB
                        pixels[x + y * w] = (alpha << 24) | (red << 16) | (green << 8) | blue;
                    }
                }
                image.close(); // Don't forget to close the native image to free memory!
                return pixels;
            } catch (IOException e) {
                throw new IllegalStateException("Failed to load dry foliage color texture", e);
            }
        }).orElseThrow(() -> new IllegalStateException("Dry foliage texture not found at " + LOCATION));
    }

    @Override
    protected void apply(int[] object, ResourceManager resourceManager, ProfilerFiller profiler) {
        DryFoliageColor.init(object);
    }
}