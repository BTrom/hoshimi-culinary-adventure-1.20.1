package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.ai.NautilusAi;
import net.minecraft.world.entity.ai.sensing.SensorType;
import net.minecraft.world.entity.ai.sensing.TemptingSensor;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSensorTypes {
    public static final DeferredRegister<SensorType<?>> SENSOR_TYPES = DeferredRegister.create(ForgeRegistries.SENSOR_TYPES, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<SensorType<NautilusTemptationsSensor>> NAUTILUS_TEMPTATIONS = SENSOR_TYPES.register("nautilus_temptations", () -> new SensorType<>(NautilusTemptationsSensor::new));

    public static void register(IEventBus eventBus) {
        SENSOR_TYPES.register(eventBus);
    }

    public static class NautilusTemptationsSensor extends TemptingSensor {
        public NautilusTemptationsSensor() {
            // We pass the Ingredient predicate here.
            // We use the predicate defined in NautilusAi to keep it synced.
            super(Ingredient.of(ModTags.NAUTILUS_FOOD));
        }
    }
}
