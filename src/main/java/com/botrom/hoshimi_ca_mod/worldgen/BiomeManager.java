package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.registry.ModBiomes;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeContext;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeWriter;
import com.google.common.collect.Lists;
import terrablender.api.ParameterUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.BiConsumer;

public class BiomeManager {
    private static final List<BiConsumer<BiomeWriter, BiomeContext>> MODIFICATIONS = Lists.newArrayList();
    public static final BiomeManager INSTANCE = new BiomeManager();

    public BiomeManager() {
    }

    public void register(BiomeWriter writer) {
        Objects.requireNonNull(writer);
        MODIFICATIONS.forEach(writer::add);
    }

    public static void add(BiConsumer<BiomeWriter, BiomeContext> modifier) {
        MODIFICATIONS.add(modifier);
    }

    public static class BiomeGeneration {
        public static void bootstrap(BiomePlacement.Event event) {
            if (ModConfig.hasPaleGarden) {
                // Peaks
                event.addSurfaceBiome(BiomePlacement.Placement.PEAK_VARIANT, ParameterUtils.Temperature.NEUTRAL.parameter(), ParameterUtils.Humidity.HUMID.parameter(), ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.FAR_INLAND), ParameterUtils.Erosion.EROSION_2.parameter(), 0.0F, ModBiomes.PALE_GARDEN);
                event.addSurfaceBiome(BiomePlacement.Placement.PEAK_VARIANT, ParameterUtils.Temperature.NEUTRAL.parameter(), ParameterUtils.Humidity.HUMID.parameter(), ParameterUtils.Continentalness.FAR_INLAND.parameter(), ParameterUtils.Erosion.EROSION_3.parameter(), 0.0F, ModBiomes.PALE_GARDEN);

                // High Slice
                event.addSurfaceBiome(BiomePlacement.Placement.HIGH_SLICE_VARIANT, ParameterUtils.Temperature.NEUTRAL.parameter(), ParameterUtils.Humidity.HUMID.parameter(), ParameterUtils.Continentalness.span(ParameterUtils.Continentalness.MID_INLAND, ParameterUtils.Continentalness.FAR_INLAND), ParameterUtils.Erosion.EROSION_2.parameter(), 0.0F, ModBiomes.PALE_GARDEN);
                event.addSurfaceBiome(BiomePlacement.Placement.HIGH_SLICE_VARIANT, ParameterUtils.Temperature.NEUTRAL.parameter(), ParameterUtils.Humidity.HUMID.parameter(), ParameterUtils.Continentalness.FAR_INLAND.parameter(), ParameterUtils.Erosion.EROSION_3.parameter(), 0.0F, ModBiomes.PALE_GARDEN);

                // Mid Slice
                event.addSurfaceBiome(BiomePlacement.Placement.MID_SLICE_VARIANT, ParameterUtils.Temperature.NEUTRAL.parameter(), ParameterUtils.Humidity.HUMID.parameter(), ParameterUtils.Continentalness.FAR_INLAND.parameter(), ParameterUtils.Erosion.EROSION_1.parameter(), 0.0F, ModBiomes.PALE_GARDEN);
                event.addSurfaceBiome(BiomePlacement.Placement.MID_SLICE_VARIANT, ParameterUtils.Temperature.NEUTRAL.parameter(), ParameterUtils.Humidity.HUMID.parameter(), ParameterUtils.Continentalness.FAR_INLAND.parameter(), ParameterUtils.Erosion.EROSION_2.parameter(), 0.0F, ModBiomes.PALE_GARDEN);
            }
        }
    }
}
