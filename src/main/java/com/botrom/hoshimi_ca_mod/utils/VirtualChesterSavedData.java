package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.entities.Chester;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import net.minecraft.ChatFormatting;
import net.minecraft.Util;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.saveddata.SavedData;
import net.minecraftforge.common.util.INBTSerializable;

import javax.swing.text.Position;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class VirtualChesterSavedData extends SavedData {
    private static final String ID = "hoshimimod.virtualchester";
    private static final VirtualChesterSavedData INSTANCE = new VirtualChesterSavedData();
    private static final int TICK_DEAD_TIME_STEP = 600;
    private final Map<UUID, VirtualChester> virtualChesterByPlayerId = new HashMap();
    private int tickCount = 0;

    public VirtualChesterSavedData() {}

//    public VirtualChesterSavedData(String id) {super(id);}

    public static VirtualChesterSavedData getServerInstance(Level level) {
        if (level.isClientSide)
            throw new IllegalArgumentException("The world must be an instance of ServerLevel.");
        else {
            ServerLevel serverLevel = (ServerLevel) level;
            return (VirtualChesterSavedData) serverLevel.getServer().overworld().getDataStorage().computeIfAbsent(VirtualChesterSavedData::new, ID);
        }
    }

    public static VirtualChesterSavedData getClientInstance(Level level) {
        if (!level.isClientSide)
            throw new IllegalArgumentException("The world must be an instance of ClientLevel.");
        else
            return INSTANCE;
    }
    
    public VirtualChester getVirtualChester(UUID playerId) {
        return (VirtualChester) this.virtualChesterByPlayerId.computeIfAbsent(playerId, (key) -> {
            return new VirtualChester();
        });
    }
    
    public void spawnChester(ServerPlayer player, BlockPos pos) {
        if (!player.level.isClientSide) {
            VirtualChester virtualChester = this.getVirtualChester(player.getUUID());
            ServerLevel world = (ServerLevel) player.level;
            if (!virtualChester.isSpawned()) {
                if (virtualChester.isDead()) {
                    int minutes = (int) Math.ceil((double) virtualChester.getDeadTime() / 20.0F / 60.0F);
                    player.sendSystemMessage(Component.literal("Ooh, looks like your Chester is dead. You still need to wait " + ChatFormatting.RED + minutes + " minute" + (minutes > 1 ? "s " : " ") + ChatFormatting.WHITE + "before you can summon him again."));
                } else if (world.getBlockState(pos.above()).isAir()) {
                    Chester chester = (Chester) ModEntities.CHESTER.get().spawn(world, (ItemStack) null, null, player.blockPosition(), MobSpawnType.TRIGGERED, true, false);
                    if (VirtualChester.getAdditionalSaveData() != null) {
                        assert chester != null;
                        chester.load(virtualChester.getAdditionalSaveData());
                        virtualChester.setAdditionalSaveData((CompoundTag) null);
                    }
                }
            }
        }
    }

    @Override
    public CompoundTag save(CompoundTag compoundTag) {
        return null;
    }
    
    public class VirtualChester implements INBTSerializable<CompoundTag> {
        private CompoundTag additionalSaveData = null;
        private int deadTime = 0;
        private UUID uniqueId = null;
        private ChesterPosition position = null;

        public VirtualChester() {}

        public VirtualChester(CompoundTag nbt) {
            this.deserializeNBT(nbt);
        }

        public boolean isDead() {
            return this.deadTime > 0;
        }

        public int getDeadTime() {
            return this.deadTime;
        }

        private void setDeadTime(int deadTime) {
            this.deadTime = deadTime;
            VirtualChesterSavedData.this.setDirty();
        }
        
        public boolean isSpawned() {
            return this.uniqueId != null;
        }
        
        private void setIsSpawned(UUID uuid) {
            this.setUniqueId(uuid);
        }

        private void setIsDespawned() {
            this.setUniqueId((UUID)null);
        }

        private CompoundTag getAdditionalSaveData() {
            return this.additionalSaveData;
        }

        private void setAdditionalSaveData(CompoundTag compoundTag) {
            this.additionalSaveData = compoundTag;
            VirtualChesterSavedData.this.setDirty();
        }

        public UUID getUniqueId() {
            return this.uniqueId;
        }

        private void setUniqueId(UUID uniqueId) {
            this.uniqueId = uniqueId;
            VirtualChesterSavedData.this.setDirty();
        }

        public ChesterPosition getPosition() {
            return this.position;
        }

        private void setPosition(Chester chester) {
            this.setPosition(chester.getX(), chester.getY(), chester.getZ(), chester.level.dimension().location().toString());}

        private void setPosition(double posX, double posY, double posZ, String dim) {
            if (this.position == null) {
                this.position = new ChesterPosition(posX, posY, posZ, dim);
            } else {
                this.position.setPosition(posX, posY, posZ, dim);
            }
            VirtualChesterSavedData.this.setDirty();
        }

        @Override
        public CompoundTag serializeNBT() {
            CompoundTag nbt = new CompoundTag();
            if (additionalSaveData != null) {
                nbt.put("AdditionalSaveData", additionalSaveData);
            }
            if (deadTime > 0) {
                nbt.putInt("DeadTime", deadTime);
            }
            if (uniqueId != null) {
                nbt.putUUID("UniqueId", uniqueId);
            }
            if (position != null) {
                nbt.put("Position", position.serializeNBT());
            }
            return nbt;
        }

        @Override
        public void deserializeNBT(CompoundTag nbt) {
            if (nbt.contains("AdditionalSaveData"))
                this.additionalSaveData = nbt.getCompound("AdditionalSaveData");
            if (nbt.contains("DeadTime"))
                this.deadTime = nbt.getInt("DeadTime");
            if (nbt.hasUUID("UniqueId"))
                this.uniqueId = nbt.getUUID("UniqueId");
            if (nbt.contains("Position"))
                this.position = new ChesterPosition(nbt.getCompound("Position"));
        }

        class NbtKey {
            public static final String ADDITIONAL_SAVE_DATA = "AdditionalSaveData";
            public static final String DEAD_TIME = "DeadTime";
            public static final String UNIQUE_ID = "UniqueId";
            public static final String POSITION = "Position";

            NbtKey() {}
        }
    }

    class NbtKey {
        public static final String VIRTUAL_CHESTER_LIST = "VirtualChesterList";

        NbtKey() {}
    }
}
