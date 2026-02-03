package com.botrom.hoshimi_ca_mod;

import com.botrom.hoshimi_ca_mod.effects.particle.FireflyParticle;
import com.botrom.hoshimi_ca_mod.entities.CopperGolemEntity;
import com.botrom.hoshimi_ca_mod.entities.models.CopperGolemModel;
import com.botrom.hoshimi_ca_mod.gui.FermenterScreen;
import com.botrom.hoshimi_ca_mod.entities.models.BananaPeelModel;
import com.botrom.hoshimi_ca_mod.entities.models.ShibaModel;
import com.botrom.hoshimi_ca_mod.entities.renderers.*;
import com.botrom.hoshimi_ca_mod.events.ClientEvents;
import com.botrom.hoshimi_ca_mod.gui.CrabTrapGUI;
import com.botrom.hoshimi_ca_mod.gui.TeaKettleGui;
import com.botrom.hoshimi_ca_mod.gui.CrockPotScreen;
import com.botrom.hoshimi_ca_mod.gui.StoveGui;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.*;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.ForgeLootTableModifier;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.ForgeRegistryHelper;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.RegistryHelper;
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
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.ModBuiltinRegistries;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.SpawnConditions;
import com.botrom.hoshimi_ca_mod.worldgen.*;
import com.mojang.serialization.Codec;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.renderer.entity.ThrownItemRenderer;
import net.minecraft.core.RegistryAccess;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.animal.Parrot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Items;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.client.event.RegisterParticleProvidersEvent;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
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
import terrablender.api.RegionType;
import terrablender.api.Regions;

import java.lang.ref.WeakReference;

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
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientProxy::registerConfigScreen);
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
        ModMemoryModules.register(modEventBus);
        ModSensorTypes.SENSOR_TYPES.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        ModConfiguredFeatures.FEATURES.register(modEventBus);
        ModPlacedFeatures.FEATURES.register(modEventBus);
        ModTreePlacerTypes.FOLIAGE_PLACERS.register(modEventBus);
        ModTreePlacerTypes.TRUNK_PLACERS.register(modEventBus);
        ModTreePlacerTypes.TREE_DECORATORS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        ModStateProviders.PROVIDERS.register(modEventBus);
        ModEntityDataSerializers.SERIALIZERS.register(modEventBus);
        AMPointOfInterestRegistry.DEF_REG.register(modEventBus);

        RegistryHelper.setInstance(new ForgeRegistryHelper()); // TODO: From CopperAge
        modEventBus.addListener(this::registerEntityAttributes);
        modEventBus.addListener(this::commonSetup);
        ForgeLootTableModifier.register(modEventBus);

        // From VanillaBackport TODO
//        ModBuiltinRegistries.WOLF_SOUND_VARIANTS.register();
        ModBuiltinRegistries.COW_VARIANTS.register();
        ModBuiltinRegistries.CHICKEN_VARIANTS.register();
        ModBuiltinRegistries.PIG_VARIANTS.register();
        SpawnConditions.CONDITIONS.register();

        final DeferredRegister<Codec<? extends BiomeModifier>> biomeModifiers = DeferredRegister.create(ForgeRegistries.Keys.BIOME_MODIFIER_SERIALIZERS, MOD_ID);
        biomeModifiers.register(modEventBus);
        biomeModifiers.register("am_mob_spawns", AMMobSpawnBiomeModifier::makeCodec);
//        modEventBus.addListener(this::gatherData);
        modEventBus.addListener(this::creativeTabsInjection);


        final ModLoadingContext modLoadingContext = ModLoadingContext.get();
        modLoadingContext.registerConfig(ModConfig.Type.COMMON, ConfigHolder.COMMON_SPEC, "hoshimimod.toml");

        if (FMLEnvironment.dist == Dist.CLIENT) {
            modEventBus.addListener(this::onRegisterLayerDefinitions);
            modEventBus.addListener(this::onRegisterRenderers);
            modEventBus.addListener(ClientProxy::setupParticles);
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
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TEA_KETTLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_TEA_KETTLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_OAK_LEAVES.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_MOSS_CARPET.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_HANGING_MOSS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OPEN_EYEBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CLOSED_EYEBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_OPEN_EYEBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_CLOSED_EYEBLOSSOM.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PALE_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.POTTED_PALE_OAK_SAPLING.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RESIN_CLUMP.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.FIREFLY_BUSH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILDFLOWERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.LEAF_LITTER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CACTUS_FLOWER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.SHORT_DRY_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.TALL_DRY_GRASS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_WALL_TORCH.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_LANTERN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_CHAIN.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_BARS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EXPOSED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WEATHERED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.OXIDIZED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_EXPOSED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_WEATHERED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WAXED_OXIDIZED_COPPER_GRATE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BROCCOLI.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PEPPERS.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PINEAPPLE.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.GRAPES.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.BLACK_PEPPER.get(), RenderType.cutout());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PIZZA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.RAW_PIZZA.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.PIZZA_OVEN.get(), RenderType.cutout());

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
    }

    private void creativeTabsInjection(BuildCreativeModeTabContentsEvent event) {
        // Building Blocks
        if (event.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
            var entries = event.getEntries();
            entries.putAfter(Items.CHERRY_BUTTON.getDefaultInstance(), ModItems.PALE_OAK_LOG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_LOG.get().getDefaultInstance(), ModItems.PALE_OAK_WOOD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_WOOD.get().getDefaultInstance(), ModItems.STRIPPED_PALE_OAK_LOG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.STRIPPED_PALE_OAK_LOG.get().getDefaultInstance(), ModItems.STRIPPED_PALE_OAK_WOOD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.STRIPPED_PALE_OAK_WOOD.get().getDefaultInstance(), ModItems.PALE_OAK_PLANKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_PLANKS.get().getDefaultInstance(), ModItems.PALE_OAK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_STAIRS.get().getDefaultInstance(), ModItems.PALE_OAK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_SLAB.get().getDefaultInstance(), ModItems.PALE_OAK_FENCE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_FENCE.get().getDefaultInstance(), ModItems.PALE_OAK_FENCE_GATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_FENCE_GATE.get().getDefaultInstance(), ModItems.PALE_OAK_DOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_DOOR.get().getDefaultInstance(), ModItems.PALE_OAK_TRAPDOOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_TRAPDOOR.get().getDefaultInstance(), ModItems.PALE_OAK_PRESSURE_PLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_PRESSURE_PLATE.get().getDefaultInstance(), ModItems.PALE_OAK_BUTTON.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.MUD_BRICK_WALL.getDefaultInstance(), ModItems.RESIN_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.RESIN_BRICKS.get().getDefaultInstance(), ModItems.RESIN_BRICK_STAIRS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.RESIN_BRICK_STAIRS.get().getDefaultInstance(), ModItems.RESIN_BRICK_SLAB.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.RESIN_BRICK_SLAB.get().getDefaultInstance(), ModItems.RESIN_BRICK_WALL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.RESIN_BRICK_WALL.get().getDefaultInstance(), ModItems.CHISELED_RESIN_BRICKS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.COPPER_BLOCK.getDefaultInstance(), ModItems.CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.CUT_COPPER_SLAB.getDefaultInstance(), ModItems.COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.EXPOSED_COPPER.getDefaultInstance(), ModItems.EXPOSED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.EXPOSED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.EXPOSED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WEATHERED_COPPER.getDefaultInstance(), ModItems.WEATHERED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WEATHERED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.WEATHERED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.OXIDIZED_COPPER.getDefaultInstance(), ModItems.OXIDIZED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.OXIDIZED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.OXIDIZED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_COPPER_BLOCK.getDefaultInstance(), ModItems.WAXED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.WAXED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_EXPOSED_COPPER.getDefaultInstance(), ModItems.WAXED_EXPOSED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_EXPOSED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_WEATHERED_COPPER.getDefaultInstance(), ModItems.WAXED_WEATHERED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_WEATHERED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_OXIDIZED_COPPER.getDefaultInstance(), ModItems.WAXED_OXIDIZED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_OXIDIZED_CHISELED_COPPER_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_GRATE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.WAXED_OXIDIZED_CUT_COPPER_SLAB.getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_BARS_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_OXIDIZED_COPPER_BARS_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_DOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_OXIDIZED_COPPER_DOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_OXIDIZED_COPPER_TRAPDOOR_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
            var entries = event.getEntries();

            entries.putAfter(Items.MOSS_CARPET.getDefaultInstance(), ModItems.PALE_MOSS_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_MOSS_BLOCK.get().getDefaultInstance(), ModItems.PALE_MOSS_CARPET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_MOSS_CARPET.get().getDefaultInstance(), ModItems.PALE_HANGING_MOSS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.CHERRY_LOG.getDefaultInstance(), ModItems.PALE_OAK_LOG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(Items.CHERRY_LEAVES.getDefaultInstance(), ModItems.PALE_OAK_LEAVES.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(Items.CHERRY_SAPLING.getDefaultInstance(), ModItems.PALE_OAK_SAPLING.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.FERN.getDefaultInstance(), ModItems.SHORT_DRY_GRASS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.SHORT_DRY_GRASS.get().getDefaultInstance(), ModItems.BUSH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.TORCHFLOWER.getDefaultInstance(), ModItems.CACTUS_FLOWER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.CACTUS_FLOWER.get().getDefaultInstance(), ModItems.CLOSED_EYEBLOSSOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.CLOSED_EYEBLOSSOM.get().getDefaultInstance(), ModItems.OPEN_EYEBLOSSOM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.PINK_PETALS.getDefaultInstance(), ModItems.WILDFLOWERS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WILDFLOWERS.get().getDefaultInstance(), ModItems.LEAF_LITTER.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.SPORE_BLOSSOM.getDefaultInstance(), ModItems.FIREFLY_BUSH.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.LARGE_FERN.getDefaultInstance(), ModItems.TALL_DRY_GRASS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.SNIFFER_EGG.getDefaultInstance(), ModItems.DRIED_GHAST.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.HONEY_BLOCK.getDefaultInstance(), ModItems.RESIN_BLOCK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
            var entries = event.getEntries();

            entries.putAfter(Items.SOUL_TORCH.getDefaultInstance(), ModItems.COPPER_TORCH_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.SOUL_LANTERN.getDefaultInstance(), ModItems.COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_LANTERN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.CHAIN.getDefaultInstance(), ModItems.COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_CHAIN_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.REDSTONE_LAMP.getDefaultInstance(), ModItems.COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.LIGHTNING_ROD.getDefaultInstance(), ModItems.EXPOSED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), ModItems.WAXED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_LIGHTNING_ROD_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.CHERRY_HANGING_SIGN.getDefaultInstance(), ModItems.PALE_OAK_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PALE_OAK_SIGN.get().getDefaultInstance(), ModItems.PALE_OAK_HANGING_SIGN.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.CHEST.getDefaultInstance(), ModItems.COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_CHEST_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.ENDER_EYE.getDefaultInstance(), ModItems.COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.EXPOSED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WEATHERED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_GOLEM_STATUE_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
            var entries = event.getEntries();
            entries.putAfter(Items.TARGET.getDefaultInstance(), ModItems.WAXED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_EXPOSED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WAXED_WEATHERED_COPPER_BULB_ITEM.get().getDefaultInstance(), ModItems.WAXED_OXIDIZED_COPPER_BULB_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.CHEST.getDefaultInstance(), ModItems.WAXED_COPPER_CHEST_ITEM.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            event.accept(ModItems.COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.EXPOSED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.WEATHERED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.OXIDIZED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.WAXED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.WAXED_EXPOSED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.WAXED_WEATHERED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
            event.accept(ModItems.WAXED_OXIDIZED_COPPER_BUTTON_ITEM, CreativeModeTab.TabVisibility.SEARCH_TAB_ONLY);
        }

        if (event.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
            var entries = event.getEntries();

            entries.putAfter(Items.STONE_HOE.getDefaultInstance(), ModItems.COPPER_SHOVEL.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_SHOVEL.get().getDefaultInstance(), ModItems.COPPER_PICKAXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_PICKAXE.get().getDefaultInstance(), ModItems.COPPER_AXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_AXE.get().getDefaultInstance(), ModItems.COPPER_HOE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.SADDLE.getDefaultInstance(), ModItems.WHITE_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.WHITE_HARNESS.get().getDefaultInstance(), ModItems.LIGHT_GRAY_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.LIGHT_GRAY_HARNESS.get().getDefaultInstance(), ModItems.GRAY_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.GRAY_HARNESS.get().getDefaultInstance(), ModItems.BLACK_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.BLACK_HARNESS.get().getDefaultInstance(), ModItems.BROWN_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.BROWN_HARNESS.get().getDefaultInstance(), ModItems.RED_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.RED_HARNESS.get().getDefaultInstance(), ModItems.ORANGE_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.ORANGE_HARNESS.get().getDefaultInstance(), ModItems.YELLOW_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.YELLOW_HARNESS.get().getDefaultInstance(), ModItems.LIME_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.LIME_HARNESS.get().getDefaultInstance(), ModItems.GREEN_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.GREEN_HARNESS.get().getDefaultInstance(), ModItems.CYAN_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.CYAN_HARNESS.get().getDefaultInstance(), ModItems.LIGHT_BLUE_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.LIGHT_BLUE_HARNESS.get().getDefaultInstance(), ModItems.BLUE_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.BLUE_HARNESS.get().getDefaultInstance(), ModItems.PURPLE_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.PURPLE_HARNESS.get().getDefaultInstance(), ModItems.MAGENTA_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.MAGENTA_HARNESS.get().getDefaultInstance(), ModItems.PINK_HARNESS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.EGG.getDefaultInstance(), ModItems.BLUE_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.BLUE_EGG.get().getDefaultInstance(), ModItems.BROWN_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            var entries = event.getEntries();
            entries.putAfter(Items.STONE_SWORD.getDefaultInstance(), ModItems.COPPER_SWORD.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(Items.STONE_AXE.getDefaultInstance(), ModItems.COPPER_AXE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.LEATHER_BOOTS.getDefaultInstance(), ModItems.COPPER_HELMET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_HELMET.get().getDefaultInstance(), ModItems.COPPER_CHESTPLATE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_CHESTPLATE.get().getDefaultInstance(), ModItems.COPPER_LEGGINGS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            entries.putAfter(ModItems.COPPER_LEGGINGS.get().getDefaultInstance(), ModItems.COPPER_BOOTS.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);

            entries.putAfter(Items.LEATHER_HORSE_ARMOR.getDefaultInstance(), ModItems.COPPER_HORSE_ARMOR.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.INGREDIENTS) {
            event.getEntries().putAfter(Items.AMETHYST_SHARD.getDefaultInstance(), ModItems.COPPER_NUGGET.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.HONEYCOMB.getDefaultInstance(), ModItems.RESIN_CLUMP.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.SCUTE.getDefaultInstance(), ModItems.ARMADILLO_SCUTE.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.NETHER_BRICK.getDefaultInstance(), ModItems.RESIN_BRICK.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }

        if (event.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
            event.getEntries().putAfter(Items.WOLF_SPAWN_EGG.getDefaultInstance(), ModItems.ARMADILLO_SPAWN_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.FROG_SPAWN_EGG.getDefaultInstance(), ModItems.NAUTILUS_SPAWN_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.SNIFFER_SPAWN_EGG.getDefaultInstance(), ModItems.COPPER_GOLEM_SPAWN_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
            event.getEntries().putAfter(Items.GHAST_SPAWN_EGG.getDefaultInstance(), ModItems.HAPPY_GHAST_SPAWN_EGG.get().getDefaultInstance(), CreativeModeTab.TabVisibility.PARENT_AND_SEARCH_TABS);
        }
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
        Regions.register(new OverworldRegion(Utils.createResourceLocation("overworld"), RegionType.OVERWORLD, 1));
        BiomeManager.add(WorldGeneration::bootstrap);
        BiomePlacement.registerBiomePlacements(BiomeManager.BiomeGeneration::bootstrap);
        ModBlocks.registerButtons();
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
        event.registerLayerDefinition(CopperGolemModel.STATUE_STANDING, CopperGolemModel::createStandingStatueBodyLayer);
        event.registerLayerDefinition(CopperGolemModel.STATUE_RUNNING, CopperGolemModel::createRunningPoseBodyLayer);
        event.registerLayerDefinition(CopperGolemModel.STATUE_SITTING, CopperGolemModel::createSittingPoseBodyLayer);
        event.registerLayerDefinition(CopperGolemModel.STATUE_STAR, CopperGolemModel::createStarPoseBodyLayer);
        event.registerLayerDefinition(CopperGolemModel.LAYER_LOCATION, CopperGolemModel::createBodyLayer);
    }

    private void onRegisterRenderers(EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(ModEntities.SHIBA.get(), ShibaRenderer::new);
        event.registerEntityRenderer(ModEntities.BIRDCAGE.get(), EmptyRenderer::new);
        event.registerEntityRenderer(ModEntities.PARROT_EGG.get(), ThrownItemRenderer::new);
        event.registerEntityRenderer(ModEntities.BANANA_PEEL.get(), BananaPeelRenderer::new);
        event.registerEntityRenderer(ModEntities.COCONUT_CRAB.get(), CoconutCrabRenderer::new);
        event.registerEntityRenderer(ModEntities.COPPER_GOLEM.get(), CopperGolemRenderer::new);
    }

//    private void onRegisterParticles(RegisterParticleProvidersEvent event) {
//        event.registerSpriteSet(ModParticleTypes.FIREFLY.get(), FireflyParticle.Provider::new);
//    }

//    private void gatherData(net.minecraftforge.data.event.GatherDataEvent event) {
//        net.minecraft.data.DataGenerator generator = event.getGenerator();
//        net.minecraft.data.PackOutput output = generator.getPackOutput();
//        java.util.concurrent.CompletableFuture<net.minecraft.core.HolderLookup.Provider> lookupProvider = event.getLookupProvider();
//
//        // Register the RegistrySetBuilder that creates the JSONs
//        generator.addProvider(event.includeServer(), new net.minecraftforge.common.data.DatapackBuiltinEntriesProvider(
//                output,
//                lookupProvider,
//                new net.minecraft.core.RegistrySetBuilder()
//                        // 1. Add Configured Features (So Placed Features can find them)
//                        .add(net.minecraft.core.registries.Registries.CONFIGURED_FEATURE, ModConfiguredFeatures::bootstrap)
//
//                        // 2. Add Placed Features (So Biome Modifiers can find them)
//                        .add(net.minecraft.core.registries.Registries.PLACED_FEATURE, ModPlacedFeatures::bootstrap)
//
//                        // 3. Add Biome Modifiers (The files you are missing)
//                        .add(net.minecraftforge.registries.ForgeRegistries.Keys.BIOME_MODIFIERS, BiomeModifiers::bootstrap),
//                java.util.Set.of(HoshimiCulinaryMod.MOD_ID)
//        ));
//    }
    // TODO: Here to remove as many differences from the copper mod as we can. Replace later on
    private void registerEntityAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.COPPER_GOLEM.get(), CopperGolemEntity.createAttributes().build());
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        // Fire registration callbacks (like button waxed references)
        event.enqueueWork(() -> {
            if (RegistryHelper.getInstance() instanceof ForgeRegistryHelper helper) {
                helper.fireRegistrationCallbacks();
            }
        });
    }
}