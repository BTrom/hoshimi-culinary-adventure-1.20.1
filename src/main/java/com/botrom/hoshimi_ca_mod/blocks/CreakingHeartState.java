package com.botrom.hoshimi_ca_mod.blocks;

import net.minecraft.util.StringRepresentable;

public enum CreakingHeartState implements StringRepresentable {
    UPROOTED("uprooted"),
    DORMANT("dormant"),
    AWAKE("awake");

    private final String name;

    CreakingHeartState(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }

    @Override
    public String getSerializedName() {
        return this.name;
    }
}