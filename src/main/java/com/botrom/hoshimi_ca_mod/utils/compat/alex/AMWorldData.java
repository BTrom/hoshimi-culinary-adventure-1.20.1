package com.botrom.hoshimi_ca_mod.utils.compat.alex;

import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.Mth;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraft.world.level.storage.DimensionDataStorage;

import javax.annotation.Nullable;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.function.Predicate;

public class AMWorldData extends SavedData {

    private static final String IDENTIFIER = "alexsmobs_world_data";
    private ServerLevel level;
    private int tickCounter;
    private int beachedCachalotSpawnDelay;
    private int beachedCachalotSpawnChance;
    private UUID beachedCachalotID;
    private static final Map<Level, AMWorldData> dataMap = new HashMap<>();
    private static final Predicate<BlockState> IS_WATER = (state -> state.is(Blocks.WATER));

    public AMWorldData() {
        super();
    }

    public static AMWorldData get(Level world) {
        if (world instanceof ServerLevel) {
            ServerLevel overworld = world.getServer().getLevel(Level.OVERWORLD);
            AMWorldData fromMap = dataMap.get(overworld);
            if(fromMap == null){
                DimensionDataStorage storage = overworld.getDataStorage();
                AMWorldData data = storage.computeIfAbsent(AMWorldData::load, AMWorldData::new, IDENTIFIER);
                if (data != null) {
                    data.level =  overworld;
                    data.setDirty();
                }
                dataMap.put(world, data);
                return data;
            }
            return fromMap;
        }
        return null;
    }

    public static AMWorldData load(CompoundTag nbt) {
        AMWorldData data = new AMWorldData();
        if (nbt.contains("BeachedCachalotSpawnDelay", 99)) {
            data.beachedCachalotSpawnDelay = nbt.getInt("BeachedCachalotSpawnDelay");
        }
        if (nbt.contains("BeachedCachalotSpawnChance", 99)) {
            data.beachedCachalotSpawnChance = nbt.getInt("BeachedCachalotSpawnChance");
        }
        if (nbt.contains("BeachedCachalotId", 8)) {
            data.beachedCachalotID = UUID.fromString(nbt.getString("BeachedCachalotId"));
        }
        return data;
    }

    public int getBeachedCachalotSpawnDelay() {
        return this.beachedCachalotSpawnDelay;
    }

    public void setBeachedCachalotSpawnDelay(int delay) {
        this.beachedCachalotSpawnDelay = delay;
    }

    public int getBeachedCachalotSpawnChance() {
        return this.beachedCachalotSpawnChance;
    }

    public void setBeachedCachalotSpawnChance(int chance) {
        this.beachedCachalotSpawnChance = chance;
    }

    public void setBeachedCachalotID(UUID id) {
        this.beachedCachalotID = id;
    }

    public void debug() {
    }

    public void tick() {
        ++this.tickCounter;
    }

    @Override
    public CompoundTag save(CompoundTag compound) {
        compound.putInt("beachedCachalotSpawnDelay", this.beachedCachalotSpawnDelay);
        compound.putInt("beachedCachalotSpawnChance", this.beachedCachalotSpawnChance);
        if (this.beachedCachalotID != null) {
            compound.putString("beachedCachalotId", this.beachedCachalotID.toString());
        }
        return compound;
    }

    public int getWaterHeight(NoiseBasedChunkGenerator generator, RandomState rand, int x, int z, LevelHeightAccessor level) {
        NoiseSettings noisesettings = generator.settings.value().noiseSettings();
        int i = Math.max(noisesettings.minY(), level.getMinBuildHeight());
        int j = Math.min(noisesettings.minY() + noisesettings.height(), level.getMaxBuildHeight());
        int k = Mth.floorDiv(i, noisesettings.getCellHeight());
        int l = Mth.floorDiv(j - i, noisesettings.getCellHeight());
        return generator.iterateNoiseColumn(level, rand, x, z, null, IS_WATER).orElse(level.getMinBuildHeight());
    }
}
