package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.Armadillo;
import com.botrom.hoshimi_ca_mod.entities.HappyGhast;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.MobSensor;
import com.google.common.collect.ImmutableSet;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.entity.ai.memory.MemoryModuleType;
import net.minecraft.world.entity.ai.memory.NearestVisibleLivingEntities;
import net.minecraft.world.entity.ai.sensing.Sensor;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.sensing.TemptingSensor;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.Optional;
import java.util.Set;
import java.util.function.Supplier;

public class ModSensorTypes {
    public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<SensorType<NautilusTemptationsSensor>> NAUTILUS_TEMPTATIONS = SENSOR_TYPES.register("nautilus_temptations", () -> new SensorType<>(NautilusTemptationsSensor::new));
    public static final RegistryObject<SensorType<AdultSensorAnyType>> NEAREST_ADULT_ANY_TYPE = SENSOR_TYPES.register("nearest_adult_any_type", () -> new SensorType<>(AdultSensorAnyType::new));
    public static final RegistryObject<SensorType<TemptingSensor>> HAPPY_GHAST_TEMPTATIONS = SENSOR_TYPES.register("happy_ghast_temptations", () -> new SensorType<>(() -> new TemptingSensor(HappyGhast.IS_FOOD)));
    public static final RegistryObject<SensorType<TemptingSensor>> ARMADILLO_TEMPTATIONS = SENSOR_TYPES.register("armadillo_temptations", () -> new SensorType<>(() -> new TemptingSensor(Armadillo.IS_FOOD)));
    public static final RegistryObject<SensorType<MobSensor<Armadillo>>> ARMADILLO_SCARE_DETECTED = SENSOR_TYPES.register("armadillo_scare_detected", () -> new SensorType<>(() -> new MobSensor<>(5, Armadillo::isScaredBy, Armadillo::canStayRolledUp, ModMemoryModules.DANGER_DETECTED_RECENTLY.get(), 80)));


    public static class NautilusTemptationsSensor extends TemptingSensor {
        public NautilusTemptationsSensor() {
            // We pass the Ingredient predicate here.
            // We use the predicate defined in NautilusAi to keep it synced.
            super(Ingredient.of(ModTags.NAUTILUS_FOOD));
        }
    }

    public static class AdultSensorAnyType extends Sensor<AgeableMob> {
        @Override
        public Set<MemoryModuleType<?>> requires() {
            return ImmutableSet.of(MemoryModuleType.NEAREST_VISIBLE_ADULT, MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES);
        }

        protected void doTick(ServerLevel level, AgeableMob entity) {
            entity.getBrain()
                    .getMemory(MemoryModuleType.NEAREST_VISIBLE_LIVING_ENTITIES)
                    .ifPresent(entities -> this.setNearestVisibleAdult(entity, entities));
        }

        private void setNearestVisibleAdult(AgeableMob mob, NearestVisibleLivingEntities entities) {
            Optional<AgeableMob> adult = entities.findClosest(entity -> entity.getType().is(ModTags.FOLLOWABLE_FRIENDLY_MOBS) && !entity.isBaby())
                    .map(AgeableMob.class::cast);
            mob.getBrain().setMemory(MemoryModuleType.NEAREST_VISIBLE_ADULT, adult);
        }
    }
}
