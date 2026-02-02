package com.botrom.hoshimi_ca_mod.worldgen;

import com.google.common.collect.Lists;
import com.mojang.datafixers.util.Pair;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.ParameterUtils;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;

public class BiomePlacement {
    public static final List<Pair<Climate.ParameterPoint, ResourceKey<Biome>>> BIOME_PLACEMENTS = Lists.newArrayList();

    public BiomePlacement() {
    }

    public static void registerBiomePlacements(Consumer<Event> listener) {
        List var10001 = BIOME_PLACEMENTS;
        Objects.requireNonNull(var10001);
        listener.accept(var10001::add);
    }

    public interface Event {
        void add(Pair<Climate.ParameterPoint, ResourceKey<Biome>> var1);

        default void addBiome(Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter depth, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
            this.add(Pair.of(Climate.parameters(temperature, humidity, continentalness, erosion, depth, weirdness, (float)Climate.quantizeCoord(offset)), biome));
        }

        default void addSurfaceBiome(Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, ParameterUtils.Depth.SURFACE.parameter(), weirdness, offset, biome);
            this.addBiome(temperature, humidity, continentalness, erosion, ParameterUtils.Depth.FLOOR.parameter(), weirdness, offset, biome);
        }

        default void addUndergroundBiome(Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, ParameterUtils.Depth.UNDERGROUND.parameter(), weirdness, offset, biome);
        }

        default void addBottomBiome(Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, Climate.Parameter weirdness, float offset, ResourceKey<Biome> biome) {
            this.addBiome(temperature, humidity, continentalness, erosion, ParameterUtils.Depth.FLOOR.parameter(), weirdness, offset, biome);
        }

        default void addSurfaceBiome(Placement placement, Climate.Parameter temperature, Climate.Parameter humidity, Climate.Parameter continentalness, Climate.Parameter erosion, float offset, ResourceKey<Biome> biome) {
            Weirdness[] var8 = placement.getWeirdnesses();
            int var9 = var8.length;

            for(int var10 = 0; var10 < var9; ++var10) {
                Weirdness weirdness = var8[var10];
                this.addSurfaceBiome(temperature, humidity, continentalness, erosion, weirdness.parameter(), offset, biome);
            }

        }
    }

//    public enum Depth {
//        SURFACE(Climate.Parameter.point(0.0F)),
//        UNDERGROUND(Climate.Parameter.span(0.2F, 0.9F)),
//        FLOOR(Climate.Parameter.point(1.0F)),
//        FULL_RANGE(Climate.Parameter.span(-1.0F, 1.0F));
//
//        private final Climate.Parameter parameter;
//
//        private Depth(Climate.Parameter parameter) {
//            this.parameter = parameter;
//        }
//
//        public Climate.Parameter parameter() {
//            return this.parameter;
//        }
//
//        public static Climate.Parameter span(Depth min, Depth max) {
//            return Climate.Parameter.span(Climate.unquantizeCoord(min.parameter().min()), Climate.unquantizeCoord(max.parameter().max()));
//        }
//    }
//
    public enum Placement {
        VALLEY(new Weirdness[]{Weirdness.VALLEY}),
        LOW_SLICE(new Weirdness[]{Weirdness.LOW_SLICE_NORMAL_DESCENDING, Weirdness.LOW_SLICE_VARIANT_ASCENDING}),
        LOW_SLICE_NORMAL(new Weirdness[]{Weirdness.LOW_SLICE_NORMAL_DESCENDING}),
        LOW_SLICE_VARIANT(new Weirdness[]{Weirdness.LOW_SLICE_VARIANT_ASCENDING}),
        MID_SLICE(new Weirdness[]{Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING}),
        MID_SLICE_NORMAL(new Weirdness[]{Weirdness.MID_SLICE_NORMAL_ASCENDING, Weirdness.MID_SLICE_NORMAL_DESCENDING}),
        MID_SLICE_VARIANT(new Weirdness[]{Weirdness.MID_SLICE_VARIANT_ASCENDING, Weirdness.MID_SLICE_VARIANT_DESCENDING}),
        HIGH_SLICE(new Weirdness[]{Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING, Weirdness.HIGH_SLICE_VARIANT_DESCENDING}),
        HIGH_SLICE_NORMAL(new Weirdness[]{Weirdness.HIGH_SLICE_NORMAL_ASCENDING, Weirdness.HIGH_SLICE_NORMAL_DESCENDING}),
        HIGH_SLICE_VARIANT(new Weirdness[]{Weirdness.HIGH_SLICE_VARIANT_ASCENDING, Weirdness.HIGH_SLICE_VARIANT_DESCENDING}),
        PEAK(new Weirdness[]{Weirdness.PEAK_NORMAL, Weirdness.PEAK_VARIANT}),
        PEAK_NORMAL(new Weirdness[]{Weirdness.PEAK_NORMAL}),
        PEAK_VARIANT(new Weirdness[]{Weirdness.PEAK_VARIANT});

        private final Weirdness[] weirdnesses;

        private Placement(Weirdness... weirdnesses) {
            this.weirdnesses = weirdnesses;
        }

        public Weirdness[] getWeirdnesses() {
            return this.weirdnesses;
        }
    }

    public enum Weirdness {
        MID_SLICE_NORMAL_ASCENDING(Climate.Parameter.span(-1.0F, -0.93333334F)),
        HIGH_SLICE_NORMAL_ASCENDING(Climate.Parameter.span(-0.93333334F, -0.7666667F)),
        PEAK_NORMAL(Climate.Parameter.span(-0.7666667F, -0.56666666F)),
        HIGH_SLICE_NORMAL_DESCENDING(Climate.Parameter.span(-0.56666666F, -0.4F)),
        MID_SLICE_NORMAL_DESCENDING(Climate.Parameter.span(-0.4F, -0.26666668F)),
        LOW_SLICE_NORMAL_DESCENDING(Climate.Parameter.span(-0.26666668F, -0.05F)),
        VALLEY(Climate.Parameter.span(-0.05F, 0.05F)),
        LOW_SLICE_VARIANT_ASCENDING(Climate.Parameter.span(0.05F, 0.26666668F)),
        MID_SLICE_VARIANT_ASCENDING(Climate.Parameter.span(0.26666668F, 0.4F)),
        HIGH_SLICE_VARIANT_ASCENDING(Climate.Parameter.span(0.4F, 0.56666666F)),
        PEAK_VARIANT(Climate.Parameter.span(0.56666666F, 0.7666667F)),
        HIGH_SLICE_VARIANT_DESCENDING(Climate.Parameter.span(0.7666667F, 0.93333334F)),
        MID_SLICE_VARIANT_DESCENDING(Climate.Parameter.span(0.93333334F, 1.0F)),
        FULL_RANGE(Climate.Parameter.span(-1.0F, 1.0F));

        private final Climate.Parameter parameter;

        private Weirdness(Climate.Parameter parameter) {
            this.parameter = parameter;
        }

        public Climate.Parameter parameter() {
            return this.parameter;
        }

        public static Climate.Parameter span(Weirdness min, Weirdness max) {
            return Climate.Parameter.span(Climate.unquantizeCoord(min.parameter().min()), Climate.unquantizeCoord(max.parameter().max()));
        }
    }
}
