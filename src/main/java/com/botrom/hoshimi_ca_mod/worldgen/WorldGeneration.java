package com.botrom.hoshimi_ca_mod.worldgen;

import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeContext;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.BiomeWriter;

public class WorldGeneration {
    public static void bootstrap(BiomeWriter writer, BiomeContext context) {
        new SpringToLifeFeatureManager(context, writer).bootstrap();
        new ArmoredPawsFeatureManager(context, writer).bootstrap();
    }
}