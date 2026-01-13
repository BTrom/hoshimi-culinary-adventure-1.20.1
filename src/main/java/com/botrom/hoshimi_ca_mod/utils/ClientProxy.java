package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.effects.particle.AcidParticle;
import com.botrom.hoshimi_ca_mod.effects.particle.ParticleSimpleHeart;
import com.botrom.hoshimi_ca_mod.effects.particle.ShockwaveParticle;
import com.botrom.hoshimi_ca_mod.effects.particle.SurgeParticle;
import com.botrom.hoshimi_ca_mod.entities.models.DumboOctopusModel;
import com.botrom.hoshimi_ca_mod.entities.models.KoiFishModel;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.events.ClientEvents;
import com.botrom.hoshimi_ca_mod.registry.*;
import com.botrom.hoshimi_ca_mod.utils.compat.AMItemRenderProperties;
import com.mojang.blaze3d.vertex.BufferBuilder;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {

//    public static final Int2ObjectMap<SoundBearMusicBox> BEAR_MUSIC_BOX_SOUND_MAP = new Int2ObjectOpenHashMap<>();
//    public static final Int2ObjectMap<SoundLaCucaracha> COCKROACH_SOUND_MAP = new Int2ObjectOpenHashMap<>();
//    public static final Int2ObjectMap<SoundWormBoss> WORMBOSS_SOUND_MAP = new Int2ObjectOpenHashMap<>();
    public static final List<UUID> currentUnrenderedEntities = new ArrayList<>();
    public static int voidPortalCreationTime = 0;
    public CameraType prevPOV = CameraType.FIRST_PERSON;
    public boolean initializedRainbowBuffers = false;
    private int pupfishChunkX = 0;
    private int pupfishChunkZ = 0;
    private int singingBlueJayId = -1;
    private final ItemStack[] transmuteStacks = new ItemStack[3];

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {

//        HoshimiCulinaryMod.loggerLog(Level.ALL, "loaded in item colorizer");
//        if(ModItems.STRADDLEBOARD.isPresent()){
//            event.register((stack, colorIn) -> colorIn < 1 ? -1 : ((DyeableLeatherItem) stack.getItem()).getColor(stack), AMItemRegistry.STRADDLEBOARD.get());
//        }else{
//            AlexsMobs.LOGGER.warn("Could not add straddleboard item to colorizer...");
//        }
    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onBlockColors(RegisterColorHandlersEvent.Block event) {
        HoshimiCulinaryMod.loggerLog(Level.ALL, "loaded in block colorizer");
        event.register((state, tintGetter, pos, tint) -> {
            return tintGetter != null && pos != null ? RainbowUtil.calculateGlassColor(pos) : -1;
        }, ModBlocks.RAINBOW_GLASS.get());
    }

    public void init() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();
        bus.addListener(ClientProxy::onBakingCompleted);
        bus.addListener(ClientProxy::onItemColors);
        bus.addListener(ClientProxy::onBlockColors);
        bus.addListener(ClientLayerRegistry::onAddLayers);
        bus.addListener(ClientProxy::setupParticles);
    }

    public void clientInit() {
        MinecraftForge.EVENT_BUS.register(new ClientEvents());
        initRainbowBuffers();
        ItemRenderer itemRendererIn = Minecraft.getInstance().getItemRenderer();
        EntityRenderers.register(ModEntities.TIGER_PRAWN.get(), TigerPrawnRenderer::new);
        EntityRenderers.register(ModEntities.URCHIN.get(), UrchinRenderer::new);
        EntityRenderers.register(ModEntities.PLATINUM_BASS.get(), PlatinumBassRenderer::new);
        EntityRenderers.register(ModEntities.CHIEFTAIN_CRAB.get(), ChieftainCrabRenderer::new);
        EntityRenderers.register(ModEntities.CLAM.get(), ClamRenderer::new);
        EntityRenderers.register(ModEntities.FIDDLER_CRAB.get(), FiddlerCrabRenderer::new);
        EntityRenderers.register(ModEntities.DUMBO_OCTOPUS.get(), context -> new GeoEntityRenderer<>(context, new DumboOctopusModel()));
        EntityRenderers.register(ModEntities.KOI_FISH.get(), context -> new GeoEntityRenderer<>(context, new KoiFishModel()));
        EntityRenderers.register(ModEntities.LOBSTER.get(), LobsterRenderer::new);
        EntityRenderers.register(ModEntities.MIMIC_OCTOPUS.get(), MimicOctopusRenderer::new);
        EntityRenderers.register(ModEntities.SEAGULL.get(), SeagullRenderer::new);
        EntityRenderers.register(ModEntities.COMB_JELLY.get(), CombJellyRenderer::new);
        EntityRenderers.register(ModEntities.GIANT_SQUID.get(), GiantSquidRenderer::new);
        EntityRenderers.register(ModEntities.CATFISH.get(), CatfishRenderer::new);
        EntityRenderers.register(ModEntities.SHIBA.get(), ShibaRenderer::new);
    }

    private void initRainbowBuffers() {
        Minecraft.getInstance().renderBuffers().fixedBuffers.put(ModRenderTypes.COMBJELLY_RAINBOW_GLINT, new BufferBuilder(ModRenderTypes.COMBJELLY_RAINBOW_GLINT.bufferSize()));
        Minecraft.getInstance().renderBuffers().fixedBuffers.put(ModRenderTypes.VOID_WORM_PORTAL_OVERLAY, new BufferBuilder(ModRenderTypes.VOID_WORM_PORTAL_OVERLAY.bufferSize()));
        Minecraft.getInstance().renderBuffers().fixedBuffers.put(ModRenderTypes.STATIC_PORTAL, new BufferBuilder(ModRenderTypes.STATIC_PORTAL.bufferSize()));
        Minecraft.getInstance().renderBuffers().fixedBuffers.put(ModRenderTypes.STATIC_PARTICLE, new BufferBuilder(ModRenderTypes.STATIC_PARTICLE.bufferSize()));
        Minecraft.getInstance().renderBuffers().fixedBuffers.put(ModRenderTypes.STATIC_ENTITY, new BufferBuilder(ModRenderTypes.STATIC_ENTITY.bufferSize()));
        initializedRainbowBuffers = true;
    }

    private static void onBakingCompleted(final ModelEvent.ModifyBakingResult e) {
//        String ghostlyPickaxe = "alexsmobs:ghostly_pickaxe";
//        for (ResourceLocation id : e.getModels().keySet()) {
//            if (id.toString().contains(ghostlyPickaxe)) {
//                e.getModels().put(id, new GhostlyPickaxeBakedModel(e.getModels().get(id)));
//            }
//        }
    }

    public Player getClientSidePlayer() {
        return Minecraft.getInstance().player;
    }

    @OnlyIn(Dist.CLIENT)
    public Object getArmorModel(int armorId, LivingEntity entity) {
        switch (armorId) {
            /*
            case 0:
                return ROADRUNNER_BOOTS_MODEL;
            case 1:
                return MOOSE_HEADGEAR_MODEL;
            case 2:
                return FRONTIER_CAP_MODEL.withAnimations(entity);
            case 3:
                return SOMBRERO_MODEL;
            case 4:
                return SPIKED_TURTLE_SHELL_MODEL;
            case 5:
                return FEDORA_MODEL;
            case 6:
                return ELYTRA_MODEL.withAnimations(entity);

             */
            default:
                return null;
        }
    }

    @OnlyIn(Dist.CLIENT)
    public void onEntityStatus(Entity entity, byte updateKind) {
//        if (updateKind == 67) {
//            if (entity instanceof EntityCockroach && entity.isAlive()) {
//                SoundLaCucaracha sound;
//                if (COCKROACH_SOUND_MAP.get(entity.getId()) == null) {
//                    sound = new SoundLaCucaracha((EntityCockroach) entity);
//                    COCKROACH_SOUND_MAP.put(entity.getId(), sound);
//                } else {
//                    sound = COCKROACH_SOUND_MAP.get(entity.getId());
//                }
//                if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.canPlaySound() && sound.isOnlyCockroach()) {
//                    Minecraft.getInstance().getSoundManager().play(sound);
//                }
//            } else if (entity instanceof EntityVoidWorm && entity.isAlive()) {
//                final float f2 = Minecraft.getInstance().options.getSoundSourceVolume(SoundSource.MUSIC);
//                if (f2 <= 0) {
//                    WORMBOSS_SOUND_MAP.clear();
//                } else {
//                    SoundWormBoss sound;
//                    if (WORMBOSS_SOUND_MAP.get(entity.getId()) == null) {
//                        sound = new SoundWormBoss((EntityVoidWorm) entity);
//                        WORMBOSS_SOUND_MAP.put(entity.getId(), sound);
//                    } else {
//                        sound = WORMBOSS_SOUND_MAP.get(entity.getId());
//                    }
//                    if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.isNearest()) {
//                        Minecraft.getInstance().getSoundManager().play(sound);
//                    }
//                }
//            } else if (entity instanceof EntityGrizzlyBear && entity.isAlive()) {
//                SoundBearMusicBox sound;
//                if (BEAR_MUSIC_BOX_SOUND_MAP.get(entity.getId()) == null) {
//                    sound = new SoundBearMusicBox((EntityGrizzlyBear) entity);
//                    BEAR_MUSIC_BOX_SOUND_MAP.put(entity.getId(), sound);
//                } else {
//                    sound = BEAR_MUSIC_BOX_SOUND_MAP.get(entity.getId());
//                }
//                if (!Minecraft.getInstance().getSoundManager().isActive(sound) && sound.canPlaySound() && sound.isOnlyMusicBox()) {
//                    Minecraft.getInstance().getSoundManager().play(sound);
//                }
//            } else if (entity instanceof EntityBlueJay && entity.isAlive()) {
//                singingBlueJayId = entity.getId();
//            }
//        }
//        if (entity instanceof EntityBlueJay && entity.isAlive() && updateKind == 68) {
//            singingBlueJayId = -1;
//        }
    }

    public void updateBiomeVisuals(int x, int z) {
        Minecraft.getInstance().levelRenderer.setBlocksDirty(x - 32, 0, x - 32, z + 32, 255, z + 32);
    }

    public static void setupParticles(RegisterParticleProvidersEvent registry) {
        HoshimiCulinaryMod.loggerLog(Level.ALL, "Registered particle factories");
        registry.registerSpriteSet(ModParticleTypes.ACID.get(), AcidParticle.Provider::new);
        registry.registerSpriteSet(ModParticleTypes.SHOCKWAVE.get(), ShockwaveParticle.Provider::new);
        registry.registerSpriteSet(ModParticleTypes.SURGE.get(), SurgeParticle.Provider::new);
        registry.registerSpriteSet(ModParticleTypes.SHOCKED.get(), ParticleSimpleHeart.Factory::new);
    }


    public void setRenderViewEntity(Entity entity) {
        prevPOV = Minecraft.getInstance().options.getCameraType();
        Minecraft.getInstance().setCameraEntity(entity);
        Minecraft.getInstance().options.setCameraType(CameraType.THIRD_PERSON_BACK);
    }

    public void resetRenderViewEntity() {
        Minecraft.getInstance().setCameraEntity(Minecraft.getInstance().player);
    }

    public int getPreviousPOV() {
        return prevPOV.ordinal();
    }

    public boolean isFarFromCamera(double x, double y, double z) {
        Minecraft lvt_1_1_ = Minecraft.getInstance();
        return lvt_1_1_.gameRenderer.getMainCamera().getPosition().distanceToSqr(x, y, z) >= 256.0D;
    }

    public void resetVoidPortalCreation(Player player) {

    }

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public void onRegisterEntityRenders(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }

    @Override
    public Object getISTERProperties() {
        return new AMItemRenderProperties();
    }

//    @Override
//    public Object getArmorRenderProperties() {
//        return new CustomArmorRenderProperties();
//    }

//    public void spawnSpecialParticle(int type) {
//        if (type == 0) {
//            Minecraft.getInstance().level.addParticle(AMParticleRegistry.BEAR_FREDDY.get(), Minecraft.getInstance().player.getX(), Minecraft.getInstance().player.getY(), Minecraft.getInstance().player.getZ(), 0, 0, 0);
//        }
//    }

    public void processVisualFlag(Entity entity, int flag) {
        if (entity == Minecraft.getInstance().player && flag == 87) {
            ClientEvents.renderStaticScreenFor = 60;
        }
    }

    public void setPupfishChunkForItem(int chunkX, int chunkZ) {
        this.pupfishChunkX = chunkX;
        this.pupfishChunkZ = chunkZ;
    }

    public void setDisplayTransmuteResult(int slot, ItemStack stack){
        transmuteStacks[Mth.clamp(slot, 0, 2)] = stack;
    }

    public ItemStack getDisplayTransmuteResult(int slot){
        ItemStack stack = transmuteStacks[Mth.clamp(slot, 0, 2)];
        return stack == null ? ItemStack.EMPTY : stack;
    }

    public int getSingingBlueJayId() {
        return singingBlueJayId;
    }

}
