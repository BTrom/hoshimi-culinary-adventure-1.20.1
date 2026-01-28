package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.level.block.SoundType;
import net.minecraftforge.common.util.ForgeSoundType;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModSounds
{
    public static final DeferredRegister<SoundEvent> SOUND_EVENTS = DeferredRegister.create(ForgeRegistries.SOUND_EVENTS, HoshimiCulinaryMod.MOD_ID);

    public static final RegistryObject<SoundEvent> BUBBLE_POP = createSoundEvent("bubble_pop");
    public static final RegistryObject<SoundEvent> LOBSTER_HURT = createSoundEvent("entity/lobster_hurt");
    public static final RegistryObject<SoundEvent> LOBSTER_ATTACK = createSoundEvent("entity/lobster_attack");
    public static final RegistryObject<SoundEvent> GIANT_SQUID_GAMES = createSoundEvent("entity/giant_squid_games");
    public static final RegistryObject<SoundEvent> GIANT_SQUID_HURT = createSoundEvent("entity/giant_squid_hurt");
    public static final RegistryObject<SoundEvent> GIANT_SQUID_TENTACLE = createSoundEvent("entity/giant_squid_tentacle");
    public static final RegistryObject<SoundEvent> COMB_JELLY_HURT = createSoundEvent("entity/comb_jelly_hurt");
    public static final RegistryObject<SoundEvent> MIMIC_OCTOPUS_IDLE = createSoundEvent("entity/mimic_octopus_idle");
    public static final RegistryObject<SoundEvent> MIMIC_OCTOPUS_HURT = createSoundEvent("entity/mimic_octopus_hurt");
    public static final RegistryObject<SoundEvent> SEAGULL_IDLE = createSoundEvent("entity/seagull_idle");
    public static final RegistryObject<SoundEvent> SEAGULL_HURT = createSoundEvent("entity/seagull_hurt");
    public static final RegistryObject<SoundEvent> HUMMINGBIRD_IDLE = createSoundEvent("entity/hummingbird_idle");
    public static final RegistryObject<SoundEvent> HUMMINGBIRD_HURT = createSoundEvent("entity/hummingbird_hurt");
    public static final RegistryObject<SoundEvent> HUMMINGBIRD_LOOP = createSoundEvent("entity/hummingbird_loop");
    public static final RegistryObject<SoundEvent> CROW_IDLE = createSoundEvent("entity/crow_idle");
    public static final RegistryObject<SoundEvent> CROW_HURT = createSoundEvent("entity/crow_hurt");
    public static final RegistryObject<SoundEvent> MANTIS_SHRIMP_SNAP = createSoundEvent("entity/mantis_shrimp_snap");
    public static final RegistryObject<SoundEvent> MANTIS_SHRIMP_HURT = createSoundEvent("entity/mantis_shrimp_hurt");
    public static final RegistryObject<SoundEvent> CACHALOT_WHALE_IDLE = createSoundEvent("entity/cachalot_whale_idle");
    public static final RegistryObject<SoundEvent> CACHALOT_WHALE_HURT = createSoundEvent("entity/cachalot_whale_hurt");
    public static final RegistryObject<SoundEvent> CACHALOT_WHALE_CLICK = createSoundEvent("entity/cachalot_whale_click");
    public static final RegistryObject<SoundEvent> TERRAPIN_HURT = createSoundEvent("entity/terrapin_hurt");
    public static final RegistryObject<SoundEvent> MUDSKIPPER_HURT = createSoundEvent("entity/mudskipper_hurt");
    public static final RegistryObject<SoundEvent> MUDSKIPPER_WALK = createSoundEvent("entity/mudskipper_walk");
    public static final RegistryObject<SoundEvent> MUDSKIPPER_SPIT = createSoundEvent("entity/mudskipper_spit");
    public static final RegistryObject<SoundEvent> SHIBA_EAT_ARROW = createSoundEvent("entity/shiba_eat_arrow");
    public static final RegistryObject<SoundEvent> SHIBA_WHINE = createSoundEvent("entity/shiba_whine");
    public static final RegistryObject<SoundEvent> SHIBA_STEP = createSoundEvent("entity/shiba_step");
    public static final RegistryObject<SoundEvent> SHIBA_AMBIENT = createSoundEvent("entity/shiba_ambient");
    public static final RegistryObject<SoundEvent> SHIBA_PANT = createSoundEvent("entity/shiba_pant");
    public static final RegistryObject<SoundEvent> SHIBA_HURT = createSoundEvent("entity/shiba_hurt");
    public static final RegistryObject<SoundEvent> SHIBA_DEATH = createSoundEvent("entity/shiba_death");
    public static final RegistryObject<SoundEvent> CHESTER_IDLE = createSoundEvent("entity/chester_idle");
    public static final RegistryObject<SoundEvent> CHESTER_JUMP = createSoundEvent("entity/chester_jump");
    public static final RegistryObject<SoundEvent> CHESTER_HURT = createSoundEvent("entity/chester_hurt");
    public static final RegistryObject<SoundEvent> CHESTER_DEATH = createSoundEvent("entity/chester_death");
    public static final RegistryObject<SoundEvent> CHESTER_OPEN_MOUTH = createSoundEvent("entity/chester_open_mouth");
    public static final RegistryObject<SoundEvent> CHESTER_CLOSE_MOUTH = createSoundEvent("entity/chester_close_mouth");
    public static final RegistryObject<SoundEvent> SHIMA_ENAGA_AMBIENT = createSoundEvent("entity/shima_enaga_ambient");
    public static final RegistryObject<SoundEvent> TORTOISE_HIDE = createSoundEvent("entity/tortoise_hide");
    public static final RegistryObject<SoundEvent> TORTOISE_THUD = createSoundEvent("entity/tortoise_thud");
    public static final RegistryObject<SoundEvent> TORTOISE_HURT = createSoundEvent("entity/tortoise_hurt");
    public static final RegistryObject<SoundEvent> TORTOISE_DEATH = createSoundEvent("entity/tortoise_death");
    public static final RegistryObject<SoundEvent> SNAIL_CRUSH = createSoundEvent("entity/snail_crush");
    public static final RegistryObject<SoundEvent> SNAIL_FORWARD = createSoundEvent("entity/snail_forward");
    public static final RegistryObject<SoundEvent> SNAIL_BACK = createSoundEvent("entity/snail_back");
    public static final RegistryObject<SoundEvent> BUCKET_FILL_SNAIL = createSoundEvent("item/bucket_fill_snail");
    public static final RegistryObject<SoundEvent> BUCKET_EMPTY_SNAIL = createSoundEvent("item/bucket_empty_snail");
    public static final RegistryObject<SoundEvent> BIRD_HURT = createSoundEvent("entity/bird_hurt");
    public static final RegistryObject<SoundEvent> BIRD_DEATH = createSoundEvent("entity/bird_death");
    public static final RegistryObject<SoundEvent> BIRD_EAT = createSoundEvent("entity/bird_eat");
    public static final RegistryObject<SoundEvent> BIRD_FLY = createSoundEvent("entity/bird_fly");
    public static final RegistryObject<SoundEvent> BIRD_AMBIENT_BLUEJAY = createSoundEvent("entity/bird_ambient_bluejay");
    public static final RegistryObject<SoundEvent> BIRD_AMBIENT_CANARY = createSoundEvent("entity/bird_ambient_canary");
    public static final RegistryObject<SoundEvent> BIRD_AMBIENT_ROBIN = createSoundEvent("entity/bird_ambient_robin");
    public static final RegistryObject<SoundEvent> BIRD_AMBIENT_CARDINAL = createSoundEvent("entity/bird_ambient_cardinal");
    public static final RegistryObject<SoundEvent> BIRD_AMBIENT_FINCH = createSoundEvent("entity/bird_ambient_finch");
    public static final RegistryObject<SoundEvent> BIRD_AMBIENT_SPARROW = createSoundEvent("entity/bird_ambient_sparrow");


    public static final RegistryObject<SoundEvent> CROCK_POT_CLOSE = createSoundEvent("block/crock_pot_close");
    public static final RegistryObject<SoundEvent> CROCK_POT_OPEN = createSoundEvent("block/crock_pot_open");
    public static final RegistryObject<SoundEvent> CROCK_POT_FINISH = createSoundEvent("block/crock_pot_finish");
    public static final RegistryObject<SoundEvent> CROCK_POT_RATTLE = createSoundEvent("block/crock_pot_rattle");
    public static final RegistryObject<SoundEvent> TORTOISE_EGG_BREAK = createSoundEvent("block/tortoise_egg_break");
    public static final RegistryObject<SoundEvent> TORTOISE_EGG_CRACK = createSoundEvent("block/tortoise_egg_crack");
    public static final RegistryObject<SoundEvent> TORTOISE_EGG_HATCH = createSoundEvent("block/tortoise_egg_hatch");
    public static final RegistryObject<SoundEvent> ICE_CUBES_EAT = createSoundEvent("item/ice_cubes_eat");
    public static final RegistryObject<SoundEvent> ICE_CREAM_EAT = createSoundEvent("item/ice_cream_eat");
    public static final RegistryObject<SoundEvent> BANANA_BUNCH_OPEN = createSoundEvent("item/banana_bunch_open");

    public static final RegistryObject<SoundEvent> SALT_BREAK = createSaltSoundEvent("salt.break");
    public static final RegistryObject<SoundEvent> SALT_STEP = createSaltSoundEvent("salt.step");
    public static final RegistryObject<SoundEvent> SALT_PLACE = createSaltSoundEvent("salt.place");
    public static final RegistryObject<SoundEvent> SALT_HIT = createSaltSoundEvent("salt.hit");
    public static final RegistryObject<SoundEvent> SALT_FALL = createSaltSoundEvent("salt.fall");
    public static final RegistryObject<SoundEvent> SALT_CLUSTER_BREAK = createSaltSoundEvent("salt_cluster.break");
    public static final RegistryObject<SoundEvent> SALT_CLUSTER_STEP = createSaltSoundEvent("salt_cluster.step");
    public static final RegistryObject<SoundEvent> SALT_CLUSTER_PLACE = createSaltSoundEvent("salt_cluster.place");
    public static final RegistryObject<SoundEvent> SALT_CLUSTER_HIT = createSaltSoundEvent("salt_cluster.hit");
    public static final RegistryObject<SoundEvent> SALT_CLUSTER_FALL = createSaltSoundEvent("salt_cluster.fall");
    public static final RegistryObject<SoundEvent> LARGE_SALT_BUD_BREAK = createSaltSoundEvent("large_salt_bud.break");
    public static final RegistryObject<SoundEvent> LARGE_SALT_BUD_STEP = createSaltSoundEvent("large_salt_bud.step");
    public static final RegistryObject<SoundEvent> LARGE_SALT_BUD_PLACE = createSaltSoundEvent("large_salt_bud.place");
    public static final RegistryObject<SoundEvent> LARGE_SALT_BUD_HIT = createSaltSoundEvent("large_salt_bud.hit");
    public static final RegistryObject<SoundEvent> LARGE_SALT_BUD_FALL = createSaltSoundEvent("large_salt_bud.fall");
    public static final RegistryObject<SoundEvent> MEDIUM_SALT_BUD_BREAK = createSaltSoundEvent("medium_salt_bud.break");
    public static final RegistryObject<SoundEvent> MEDIUM_SALT_BUD_STEP = createSaltSoundEvent("medium_salt_bud.step");
    public static final RegistryObject<SoundEvent> MEDIUM_SALT_BUD_PLACE = createSaltSoundEvent("medium_salt_bud.place");
    public static final RegistryObject<SoundEvent> MEDIUM_SALT_BUD_HIT = createSaltSoundEvent("medium_salt_bud.hit");
    public static final RegistryObject<SoundEvent> MEDIUM_SALT_BUD_FALL = createSaltSoundEvent("medium_salt_bud.fall");
    public static final RegistryObject<SoundEvent> SMALL_SALT_BUD_BREAK = createSaltSoundEvent("small_salt_bud.break");
    public static final RegistryObject<SoundEvent> SMALL_SALT_BUD_STEP = createSaltSoundEvent("small_salt_bud.step");
    public static final RegistryObject<SoundEvent> SMALL_SALT_BUD_PLACE = createSaltSoundEvent("small_salt_bud.place");
    public static final RegistryObject<SoundEvent> SMALL_SALT_BUD_HIT = createSaltSoundEvent("small_salt_bud.hit");
    public static final RegistryObject<SoundEvent> SMALL_SALT_BUD_FALL = createSaltSoundEvent("small_salt_bud.fall");
    public static final RegistryObject<SoundEvent> SALT_DISSOLVE = createSaltSoundEvent("salt.dissolve");
    public static final RegistryObject<SoundEvent> MELT = createSaltSoundEvent("melt");
    public static final RegistryObject<SoundEvent> CAULDRON_EVAPORATE = createSaltSoundEvent("cauldron.evaporate");
    public static final RegistryObject<SoundEvent> SALT_BUBBLE_POP = createSaltSoundEvent("bubble_pop");
    public static final RegistryObject<SoundEvent> SALT_CAULDRON_REMOVE_SALT = createSaltSoundEvent("salt_cauldron.remove_salt");

    public static final SoundType SALT = new ForgeSoundType(1.0f, 1.0f, SALT_BREAK, SALT_STEP, SALT_PLACE, SALT_HIT, SALT_FALL);
    public static final SoundType SALT_CLUSTER = new ForgeSoundType(1.0f, 1.0f, SALT_CLUSTER_BREAK, SALT_CLUSTER_STEP, SALT_CLUSTER_PLACE, SALT_CLUSTER_HIT, SALT_CLUSTER_FALL);
    public static final SoundType LARGE_SALT_BUD = new ForgeSoundType(1.0f, 1.0f, LARGE_SALT_BUD_BREAK, LARGE_SALT_BUD_STEP, LARGE_SALT_BUD_PLACE, LARGE_SALT_BUD_HIT, LARGE_SALT_BUD_FALL);
    public static final SoundType MEDIUM_SALT_BUD = new ForgeSoundType(1.0f, 1.0f, MEDIUM_SALT_BUD_BREAK, MEDIUM_SALT_BUD_STEP, MEDIUM_SALT_BUD_PLACE, MEDIUM_SALT_BUD_HIT, MEDIUM_SALT_BUD_FALL);
    public static final SoundType SMALL_SALT_BUD = new ForgeSoundType(1.0f, 1.0f, SMALL_SALT_BUD_BREAK, SMALL_SALT_BUD_STEP, SMALL_SALT_BUD_PLACE, SMALL_SALT_BUD_HIT, SMALL_SALT_BUD_FALL);


    private static RegistryObject<SoundEvent> createSoundEvent(final String soundName) {
        return SOUND_EVENTS.register(soundName, () -> SoundEvent.createVariableRangeEvent(Utils.createResourceLocation(soundName)));
    }

    private static RegistryObject<SoundEvent> createSaltSoundEvent(String name) {
        return SOUND_EVENTS.register("block.salt." + name, () -> SoundEvent.createVariableRangeEvent(Utils.createResourceLocation("block.salt." + name)));
    }
}
