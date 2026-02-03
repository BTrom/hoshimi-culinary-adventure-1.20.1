package com.botrom.hoshimi_ca_mod.utils;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.effects.particle.*;
import com.botrom.hoshimi_ca_mod.entities.models.*;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.events.ClientEvents;
import com.botrom.hoshimi_ca_mod.gui.coppergolem.ConfigScreen;
import com.botrom.hoshimi_ca_mod.registry.*;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.AMItemRenderProperties;
import com.botrom.hoshimi_ca_mod.utils.compat.farmandcharm.StorageTypeRegistry;
import com.mojang.blaze3d.vertex.BufferBuilder;
import net.minecraft.client.CameraType;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.particle.FlameParticle;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.EntityRenderers;
import net.minecraft.client.renderer.entity.ItemRenderer;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.client.ConfigScreenHandler;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.Level;
import software.bernie.geckolib.renderer.GeoEntityRenderer;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, value = Dist.CLIENT)
public class ClientProxy extends CommonProxy {

    public static final List<UUID> currentUnrenderedEntities = new ArrayList<>();
    public CameraType prevPOV = CameraType.FIRST_PERSON;
    public boolean initializedRainbowBuffers = false;

    @SubscribeEvent
    @OnlyIn(Dist.CLIENT)
    public static void onItemColors(RegisterColorHandlersEvent.Item event) {

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
//        bus.addListener(ClientProxy::setupParticles);

        StorageBlockEntityRenderer.registerStorageType(StorageTypeRegistry.CHICKEN_NEST, new ChickenNestRenderer());
//        ModMenuTypes.registerScreenFactory(ModMenuTypes.STOVE_SCREEN_HANDLER.get(), StoveGui::new);
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
        EntityRenderers.register(ModEntities.SHIMA_ENAGA.get(), context -> new GeoEntityRenderer<>(context, new ShimaEnagaModel()));
//        EntityRenderers.register(ModEntities.LOBSTER.get(), LobsterRenderer::new);
        EntityRenderers.register(ModEntities.MIMIC_OCTOPUS.get(), MimicOctopusRenderer::new);
        EntityRenderers.register(ModEntities.SEAGULL.get(), SeagullRenderer::new);
        EntityRenderers.register(ModEntities.COMB_JELLY.get(), CombJellyRenderer::new);
        EntityRenderers.register(ModEntities.GIANT_SQUID.get(), GiantSquidRenderer::new);
        EntityRenderers.register(ModEntities.CATFISH.get(), CatfishRenderer::new);
        EntityRenderers.register(ModEntities.HUMMINGBIRD.get(), RenderHummingbird::new);
        EntityRenderers.register(ModEntities.HAMMERHEAD_SHARK.get(), RenderHammerheadShark::new);
        EntityRenderers.register(ModEntities.SHARK_TOOTH_ARROW.get(), RenderSharkToothArrow::new);
        EntityRenderers.register(ModEntities.CROW.get(), RenderCrow::new);
        EntityRenderers.register(ModEntities.MANTIS_SHRIMP.get(), RenderMantisShrimp::new);
        EntityRenderers.register(ModEntities.CACHALOT_WHALE.get(), RenderCachalotWhale::new);
        EntityRenderers.register(ModEntities.CACHALOT_ECHO.get(), RenderCachalotEcho::new);
        EntityRenderers.register(ModEntities.TERRAPIN.get(), RenderTerrapin::new);
        EntityRenderers.register(ModEntities.FLYING_FISH.get(), RenderFlyingFish::new);
        EntityRenderers.register(ModEntities.SHIBA.get(), ShibaRenderer::new);
        EntityRenderers.register(ModEntities.CHESTER.get(), context -> new GeoEntityRenderer<>(context, new ChesterModel()));
        EntityRenderers.register(ModEntities.LOBSTER.get(), context -> new GeoEntityRenderer<>(context, new LobsterModel()));
        EntityRenderers.register(ModEntities.GIANT_MUD_CRAB.get(), context -> new GeoEntityRenderer<>(context, new GiantMudCrabModel()));
        EntityRenderers.register(ModEntities.KING_CRAB.get(), context -> new GeoEntityRenderer<>(context, new KingCrabModel()));
        EntityRenderers.register(ModEntities.SAND_CRAB.get(), context -> new GeoEntityRenderer<>(context, new SandCrabModel()));
        EntityRenderers.register(ModEntities.CRAYFISH.get(), context -> new GeoEntityRenderer<>(context, new CrayfishModel()));
        EntityRenderers.register(ModEntities.CARDINAL.get(), BirdRenderer::new);
        EntityRenderers.register(ModEntities.SPARROW.get(), BirdRenderer::new);
        EntityRenderers.register(ModEntities.BUTTERFLY.get(), ButterflyRenderer::new);
        EntityRenderers.register(ModEntities.CATERPILLAR.get(), CaterpillarRenderer::new);
        EntityRenderers.register(ModEntities.LIZARD.get(), LizardRenderer::new);
        EntityRenderers.register(ModEntities.SNAIL.get(), SnailRenderer::new);
        EntityRenderers.register(ModEntities.TORTOISE.get(), TortoiseRenderer::new);
        EntityRenderers.register(ModEntities.BALEEN_WHALE.get(), RendererBaleenWhale::new);
        EntityRenderers.register(ModEntities.NAUTILUS.get(), NautilusRenderer::new);
        EntityRenderers.register(ModEntities.ARMADILLO.get(), ArmadilloRenderer::new);
        EntityRenderers.register(ModEntities.HAPPY_GHAST.get(), HappyGhastRenderer::new);
//        EntityRenderers.register(ModEntities.COPPER_GOLEM.get(), CopperGolemRenderer::new);

        BlockEntityRenderers.register(ModBlockEntityTypes.STOVE_BLOCK_ENTITY.get(), StoveBlockRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.PET_BOWL_BLOCK_ENTITY.get(), context -> new PetBowlBlockRenderer());
        BlockEntityRenderers.register(ModBlockEntityTypes.STORAGE_ENTITY.get(), context -> new StorageBlockEntityRenderer());
        BlockEntityRenderers.register(ModBlockEntityTypes.EYE_BONE_BLOCK_ENTITY.get(), context -> new EyeBoneBlockRenderer(new EyeBoneBlockRenderer.EyeBoneModel()));
        BlockEntityRenderers.register(ModBlockEntityTypes.COPPER_CHEST_BLOCK_ENTITY.get(), CopperChestRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.COPPER_GOLEM_STATUE_BLOCK_ENTITY.get(), CopperGolemStatueRenderer::new);
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
    public void onEntityStatus(Entity entity, byte updateKind) {

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
        registry.registerSpriteSet(ModParticleTypes.WHALE_SPLASH.get(), ParticleWhaleSplash.Factory::new);
        registry.registerSpriteSet(ModParticleTypes.FIREFLY.get(), FireflyParticle.Provider::new);
        registry.registerSpriteSet(ModParticleTypes.DUST_PLUME.get(), DustPlumeParticle.Provider::new);
        registry.registerSpriteSet(ModParticleTypes.COPPER_FIRE_FLAME.get(), FlameParticle.Provider::new);
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

    public void processVisualFlag(Entity entity, int flag) {
        if (entity == Minecraft.getInstance().player && flag == 87) {
            ClientEvents.renderStaticScreenFor = 60;
        }
    }

    @SubscribeEvent
    public static void registerEntityLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        registerEntityLayers(event::registerLayerDefinition);
    }

    public static void registerEntityLayers(BiConsumer<ModelLayerLocation, Supplier<LayerDefinition>> event) {
        event.accept(BubbleLayer.LAYER_LOCATION, BubbleModel::createLayer);
    }

    public static void registerConfigScreen() {
        ModLoadingContext.get().registerExtensionPoint(
                ConfigScreenHandler.ConfigScreenFactory.class,
                () -> new ConfigScreenHandler.ConfigScreenFactory(
                        (mc, parent) -> ConfigScreen.create(parent)
                )
        );
    }
}
