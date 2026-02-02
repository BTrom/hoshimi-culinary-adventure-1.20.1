package com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport;

import com.botrom.hoshimi_ca_mod.entities.HappyGhast;
import com.botrom.hoshimi_ca_mod.registry.ModSounds;
import net.minecraft.client.resources.sounds.AbstractTickableSoundInstance;
import net.minecraft.client.resources.sounds.SoundInstance;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

@OnlyIn(Dist.CLIENT)
public class RidingHappyGhastSoundInstance extends AbstractTickableSoundInstance {
    private static final float VOLUME_MIN = 0.0F;
    private static final float VOLUME_MAX = 1.0F;
    private final Player player;
    private final HappyGhast happyGhast;

    public RidingHappyGhastSoundInstance(Player player, HappyGhast happyGhast) {
        super(ModSounds.HAPPY_GHAST_RIDING.get(), happyGhast.getSoundSource(), SoundInstance.createUnseededRandom());
        this.player = player;
        this.happyGhast = happyGhast;
        this.attenuation = Attenuation.NONE;
        this.looping = true;
        this.delay = 0;
        this.volume = VOLUME_MIN;
    }

    @Override
    public boolean canStartSilent() {
        return true;
    }

    @Override
    public void tick() {
        if (!this.happyGhast.isRemoved() && this.player.isPassenger() && this.player.getVehicle() == this.happyGhast) {
            float velocity = (float) this.happyGhast.getDeltaMovement().length();
            if (velocity >= 0.01F) {
                this.volume = 5.0F * Mth.clampedLerp(VOLUME_MIN, VOLUME_MAX, velocity);
            } else {
                this.volume = VOLUME_MIN;
            }
        } else {
            this.stop();
        }
    }
}