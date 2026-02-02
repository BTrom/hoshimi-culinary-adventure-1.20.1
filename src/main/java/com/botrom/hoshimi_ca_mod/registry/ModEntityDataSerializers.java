package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.entities.ArmadilloState;
import net.minecraft.network.syncher.EntityDataSerializer;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEntityDataSerializers {
    public static final DeferredRegister<EntityDataSerializer<?>> SERIALIZERS = DeferredRegister.create(ForgeRegistries.Keys.ENTITY_DATA_SERIALIZERS, "your_mod_id");

    public static final RegistryObject<EntityDataSerializer<ArmadilloState>> ARMADILLO_STATE = SERIALIZERS.register("armadillo_state", () -> EntityDataSerializer.simpleEnum(ArmadilloState.class));
}