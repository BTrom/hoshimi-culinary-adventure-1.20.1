package com.botrom.hoshimi_ca_mod.utils.compat.alex;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeConfig;
import com.github.alexthe666.citadel.config.biome.SpawnBiomeData;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraftforge.registries.ForgeRegistries;
import org.apache.commons.lang3.tuple.Pair;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class AMBiomeConfig {
	public static final Pair<String, SpawnBiomeData> lobster = Pair.of("hoshimimod:lobster_spawns", AMDefaultBiomes.LOBSTER);
	public static final Pair<String, SpawnBiomeData> mimic_octopus = Pair.of("hoshimimod:mimic_octopus_spawns", AMDefaultBiomes.MIMIC_OCTOPUS);
	public static final Pair<String, SpawnBiomeData> seagull = Pair.of("hoshimimod:seagull_spawns", AMDefaultBiomes.SEAGULL);
	public static final Pair<String, SpawnBiomeData> comb_jelly = Pair.of("hoshimimod:comb_jelly_spawns", AMDefaultBiomes.COMB_JELLY);
	public static final Pair<String, SpawnBiomeData> giant_squid = Pair.of("hoshimimod:giant_squid_spawns", AMDefaultBiomes.GIANT_SQUID);
	public static final Pair<String, SpawnBiomeData> catfish = Pair.of("hoshimimod:catfish_spawns", AMDefaultBiomes.CATFISH);

	private static boolean init = false;
	private static final Map<String, SpawnBiomeData> biomeConfigValues = new HashMap<>();

    public static void init() {
        try {
            for (Field f : AMBiomeConfig.class.getDeclaredFields()) {
                Object obj = f.get(null);
               if(obj instanceof Pair){
				   String id = (String)((Pair) obj).getLeft();
				   SpawnBiomeData data = (SpawnBiomeData)((Pair) obj).getRight();
				   biomeConfigValues.put(id, SpawnBiomeConfig.create(new ResourceLocation(id), data));
               }
            }
        }catch (Exception e){
            HoshimiCulinaryMod.loggerWarn("Encountered error building alexsmobs biome config .json files");
            e.printStackTrace();
        }
		init = true;
    }

    public static boolean test(Pair<String, SpawnBiomeData> entry, Holder<Biome> biome, ResourceLocation name){
    	if(!init){
    		return false;
		}
		return biomeConfigValues.get(entry.getKey()).matches(biome, name);
	}

	public static boolean test(Pair<String, SpawnBiomeData> spawns, Holder<Biome> biome) {
		return test(spawns, biome, ForgeRegistries.BIOMES.getKey(biome.value()));
	}
}
