package com.botrom.hoshimi_ca_mod.utils.compat.copper;

import net.minecraft.client.multiplayer.ClientLevel;
import org.jetbrains.annotations.Nullable;

/**
 * Interface to access EndFlashState from ClientLevel.
 * Use EndFlashAccessor.get(clientLevel) to get the EndFlashState.
 */
public interface EndFlashAccessor {
    
    @Nullable
    EndFlashState hoshimimod$getEndFlashState();
    
    /**
     * Utility method to get EndFlashState from a ClientLevel
     */
    @Nullable
    static EndFlashState get(ClientLevel level) {
        return ((EndFlashAccessor) level).hoshimimod$getEndFlashState();
    }
}
