package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.mojang.serialization.Codec;

public interface SpawnCondition extends PriorityProvider.SelectorCondition<SpawnContext> {
    Codec<SpawnCondition> CODEC = ModRegistries.SPAWN_CONDITION_TYPE.get().byNameCodec().dispatch(SpawnCondition::codec, codec -> codec);

    Codec<? extends SpawnCondition> codec();
}