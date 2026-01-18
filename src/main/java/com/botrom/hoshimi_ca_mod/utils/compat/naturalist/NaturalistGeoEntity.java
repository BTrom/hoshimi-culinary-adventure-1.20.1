package com.botrom.hoshimi_ca_mod.utils.compat.naturalist;

import software.bernie.geckolib.animatable.GeoEntity;

public interface NaturalistGeoEntity extends GeoEntity {

    @Override
    default double getBoneResetTime() {
        return 5;
    }
}
