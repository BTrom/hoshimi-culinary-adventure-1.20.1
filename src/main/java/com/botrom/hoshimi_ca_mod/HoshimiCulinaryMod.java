package com.botrom.hoshimi_ca_mod;

import com.botrom.hoshimi_ca_mod.gui.FermenterScreen;
import com.botrom.hoshimi_ca_mod.entities.models.BananaPeelModel;
import com.botrom.hoshimi_ca_mod.entities.models.ShibaModel;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.events.ClientEvents;
import com.botrom.hoshimi_ca_mod.gui.CrabTrapGUI;
import com.botrom.hoshimi_ca_mod.gui.TeaKettleGui;
import com.botrom.hoshimi_ca_mod.gui.CrockPotScreen;
import com.botrom.hoshimi_ca_mod.gui.StoveGui;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.*;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.blockentity.content.BasinContent;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.config.PizzaCraftConfig;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.client.gui.ScreenPizza;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.client.gui.ScreenPizzaStation;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.client.renderer.BasinRenderer;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.client.renderer.PizzaRenderer;
import com.botrom.hoshimi_ca_mod.utils.compat.pizzacraft.init.PizzaLayers;
import com.botrom.hoshimi_ca_mod.registry.*;
import com.botrom.hoshimi_ca_mod.utils.CommonProxy;
import com.botrom.hoshimi_ca_mod.utils.ClientProxy;
import com.botrom.hoshimi_ca_mod.utils.ConfigHolder;
import com.botrom.hoshimi_ca_mod.utils.compat.QuarkModelHandler;
import com.botrom.hoshimi_ca_mod.worldgen.AMMobSpawnBiomeModifier;
import com.mojang.serialization.Codec;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.event.config.ModConfigEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.loading.FMLEnvironment;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.simple.SimpleChannel;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.server.ServerLifecycleHooks;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import software.bernie.geckolib.GeckoLib;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HoshimiCulinaryMod.MOD_ID)
public class HoshimiCulinaryMod {
    public static final String MOD_ID = "hoshimimod";
    public static final Logger LOGGER = LogManager.getLogger();
    public static SimpleChannel NETWORK;
    public static final CommonProxy PROXY = DistExecutor.runForDist(() -> ClientProxy::new, () -> CommonProxy::new);
    private static int packetsRegistered;

    public HoshimiCulinaryMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();
        GeckoLib.initialize();

        PizzaCraftConfig.register(ModLoadingContext.get());
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::clientSetup);
        modEventBus.addListener(this::onModConfigEvent);
        modEventBus.addListener(this::onFinish);

        modEventBus.register(new ClientEvents());

        ModEntities.ENTITIES.register(modEventBus);
        ModEffects.EFFECTS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);
        ModRecipes.register(modEventBus);
        ModTreePlacerTypes.FOLIAGE_PLACERS.register(modEventBus);
        ModTreePlacerTypes.TRUNK_PLACERS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        ModStateProviders.PROVIDERS.register(modEventBus);
        AMPointOfInterestRegistry.DEF_REG.register(modEventBus);

        final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MOD_ID);
        biomeModifiers.register(modEventBus);
        biomeModifiers.register("am_mob_spawns", AMMobSpawnBiomeModifier::makeCodec);

        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, "hoshimimod.toml");

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(this::onRegisterLayerDefinitions);
            modEventBus.addListener(this::onRegisterRenderers);
        }
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModNetwork.registerNetworkChannel();

            NETWORK.registerMessage(packetsRegistered++, MessageHurtMultipart.class, MessageHurtMultipart::write, MessageHurtMultipart::read, MessageHurtMultipart.Handler::handle);
            NETWORK.registerMessage(packetsRegistered++, MessageInteractMultipart.class, MessageInteractMultipart::write, MessageInteractMultipart::read, MessageInteractMultipart.Handler::handle);
            NETWORK.registerMessage(packetsRegistered++, MessageCrowMountPlayer.class, MessageCrowMountPlayer::write, MessageCrowMountPlayer::read, MessageCrowMountPlayer.Handler::handle);
            NETWORK.registerMessage(packetsRegistered++, MessageCrowDismount.class, MessageCrowDismount::write, MessageCrowDismount::read, MessageCrowDismount.Handler::handle);

            event.enqueueWork(ModItems::initDispenser);
            ModVanillaCompat.setup();
            BasinContent.register();

            PROXY.init();
            PROXY.initPathfinding();
        });
    }

    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {

    }

    public void clientSetup(FMLClientSetupEvent event) {
        event.enqueueWork(PROXY::clientInit);

        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CUCUMBERS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CORN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_EGGPLANTS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBERS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EGGPLANTS.get(), RenderType.cutoutMipped());
        // ItemBlockRenderTypes.setRenderLayer(ModBlocks.AVOCADO_SEED.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN_BOTTOM.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN_UPPER.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CHRYSALIS_BLOCK.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SNAIL_EGGS.get(), RenderType.cutout());
//        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CATTAIL.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VANILLA_VINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.VANILLA_VINE_PLANT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_VANILLA_VINE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.MINT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_MINT.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SMALL_BANANA_FROND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BANANA_FROND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LARGE_BANANA_FROND.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_BANANA_FROND.get(), RenderType.cutout());
        
        //Screens
        MenuScreens.register(ModMenuTypes.PIZZA.get(), ScreenPizza::new);
        MenuScreens.register(ModMenuTypes.PIZZA_STATION.get(), ScreenPizzaStation::new);
        MenuScreens.register(ModMenuTypes.FERMENTER_MENU.get(), FermenterScreen::new);
        event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.CRAB_TRAP_MENU.get(), CrabTrapGUI::new));
        event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.STOVE_SCREEN_HANDLER.get(), StoveGui::new));
        event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.CROCK_POT_MENU_TYPE.get(), CrockPotScreen::new));
        event.enqueueWork(() -> MenuScreens.register(ModMenuTypes.TEA_KETTLE_SCREEN_HANDLER.get(), TeaKettleGui::new));

        //BlockEntityRenderers
        BlockEntityRenderers.register(ModBlockEntityTypes.BASIN.get(), BasinRenderer::new);
        BlockEntityRenderers.register(ModBlockEntityTypes.PIZZA.get(), PizzaRenderer::new);

        //RenderTypes
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PIZZA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAW_PIZZA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PIZZA_OVEN.get(), RenderType.cutout());

        //Crops
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROCCOLI.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEPPERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINEAPPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAPES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_PEPPER.get(), RenderType.cutout());
    }

    @SubscribeEvent
    public void onModConfigEvent(final ModConfigEvent event) {
        final ModConfig config = event.getConfig();
        // Rebake the configs when they change
        if (config.getSpec() == ConfigHolder.COMMON_SPEC) {
            com.botrom.hoshimi_ca_mod.utils.ModConfig.bake(config);
        }
    }

    private void onFinish(final FMLLoadCompleteEvent event) {
        PizzaLayers.setMaps();
    }

    public static void loggerLog(Level level, String msg) {
        LOGGER.log(level, msg);
    }
    public static void loggerError(String msg) {
        LOGGER.error(msg);
    }
    public static void loggerError(String msg, Object p0, Object p1) {
        LOGGER.error(msg, p0, p1);
    }
    public static void loggerWarn(String msg) {
        LOGGER.warn(msg);
    }

    public static <MSG> void sendMSGToServer(MSG message) {
        NETWORK.sendToServer(message);
    }

    public static <MSG> void sendMSGToAll(MSG message) {
        for (ServerPlayer player : ServerLifecycleHooks.getCurrentServer().getPlayerList().getPlayers()) {
            sendNonLocal(message, player);
        }
    }

    public static <MSG> void sendNonLocal(MSG msg, ServerPlayer player) {
        NETWORK.sendTo(msg, player.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    private void onRegisterLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(QuarkModelHandler.getShiba(), ShibaModel::createBodyLayer);
        event.registerLayerDefinition(BananaPeelRenderer.BANANA_PEEL, BananaPeelModel::createBodyLayer);
    }

    private void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SHIBA.get(), ShibaRenderer::new);
        event.registerEntityRenderer(ModEntities.BIRDCAGE.get(), EmptyRenderer::new);
        event.registerEntityRenderer(ModEntities.PARROT_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.BANANA_PEEL.get(), BananaPeelRenderer::new);
        event.registerEntityRenderer(ModEntities.COCONUT_CRAB.get(), CoconutCrabRenderer::new);
    }
}
