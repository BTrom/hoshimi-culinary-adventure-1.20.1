package com.botrom.hoshimi_ca_mod.utils;

import net.minecraftforge.common.ForgeConfigSpec;
import org.apache.commons.lang3.tuple.Pair;

public final class ConfigHolder {

    public static final ForgeConfigSpec COMMON_SPEC;
    public static final CommonConfig COMMON;
    public static final ForgeConfigSpec CLIENT_SPEC;
    public static final ClientConfig CLIENT;

    static {
        {
            final Pair<CommonConfig, ForgeConfigSpec> commonSpecPair = new ForgeConfigSpec.Builder().configure(CommonConfig::new);
            COMMON = commonSpecPair.getLeft();
            COMMON_SPEC = commonSpecPair.getRight();

            final Pair<ClientConfig, ForgeConfigSpec> clientSpecPair = new ForgeConfigSpec.Builder().configure(ClientConfig::new);
            CLIENT = clientSpecPair.getLeft();
            CLIENT_SPEC = commonSpecPair.getRight();
        }
    }
}