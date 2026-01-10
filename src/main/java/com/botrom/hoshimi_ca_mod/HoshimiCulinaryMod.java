package com.botrom.hoshimi_ca_mod;

import com.botrom.hoshimi_ca_mod.events.ClientEvents;
import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.content.BasinContent;
import com.botrom.hoshimi_ca_mod.pizzacraft.config.PizzaCraftConfig;
import com.botrom.hoshimi_ca_mod.pizzacraft.client.gui.ScreenPizza;
import com.botrom.hoshimi_ca_mod.pizzacraft.client.gui.ScreenPizzaStation;
import com.botrom.hoshimi_ca_mod.pizzacraft.client.renderer.BasinRenderer;
import com.botrom.hoshimi_ca_mod.pizzacraft.client.renderer.PizzaRenderer;
import com.botrom.hoshimi_ca_mod.pizzacraft.init.PizzaLayers;
import com.botrom.hoshimi_ca_mod.registry.*;
import com.mojang.logging.LogUtils;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLLoadCompleteEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.network.simple.SimpleChannel;
import org.slf4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(HoshimiCulinaryMod.MOD_ID)
public class HoshimiCulinaryMod {
    public static final String MOD_ID = "hoshimimod";
    private static final Logger LOGGER = LogUtils.getLogger();
    public static SimpleChannel NETWORK;

    public HoshimiCulinaryMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        PizzaCraftConfig.register(ModLoadingContext.get());
        modEventBus.addListener(this::setup);
        modEventBus.addListener(this::onClientSetup);
        modEventBus.addListener(this::onFinish);
        modEventBus.register(new ClientEvents());

        ModEntities.ENTITIES.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModBlocks.BLOCKS.register(modEventBus);
        ModBlockEntityTypes.BLOCK_ENTITY_TYPES.register(modEventBus);
        ModParticleTypes.PARTICLE_TYPES.register(modEventBus);
        ModMenuTypes.MENU_TYPES.register(modEventBus);
        ModRecipes.SERIALIZERS.register(modEventBus);
        ModRecipes.RECIPE_TYPES.register(modEventBus);
        ModSounds.SOUND_EVENTS.register(modEventBus);
        ModLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        ModCreativeTabs.CREATIVE_MODE_TABS.register(modEventBus);
    }

    private void setup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            ModNetwork.registerNetworkChannel();
//            ModAdvancements.register();
            ModVanillaCompat.setup();
            BasinContent.register();
        });
    }

    // Add the example block item to the building blocks tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == vectorwing.farmersdelight.common.registry.ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {

        }
    }

    // You can use SubscribeEvent and let the Event Bus discover methods to call
    @SubscribeEvent
    public void onServerStarting(ServerStartingEvent event) {
        // Do something when the server starts
//        LOGGER.info("HELLO from server starting");
    }

//    // You can use EventBusSubscriber to automatically register all static methods in the class annotated with @SubscribeEvent
//    @Mod.EventBusSubscriber(modid = MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
//    public static class ClientModEvents {
//        @SubscribeEvent
//    }


    public void onClientSetup(FMLClientSetupEvent event) {
        // Some client setup code
//            LOGGER.info("HELLO FROM CLIENT SETUP");
//            LOGGER.info("MINECRAFT NAME >> {}", Minecraft.getInstance().getUser().getName());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CUCUMBERS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_CORN.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.WILD_EGGPLANTS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CUCUMBERS.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.EGGPLANTS.get(), RenderType.cutoutMipped());
        // ItemBlockRenderTypes.setRenderLayer(ModBlocks.AVOCADO_SEED.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN_BOTTOM.get(), RenderType.cutoutMipped());
        ItemBlockRenderTypes.setRenderLayer(ModBlocks.CORN_UPPER.get(), RenderType.cutoutMipped());

        //Screens
        MenuScreens.register(ModMenuTypes.PIZZA.get(), ScreenPizza::new);
        MenuScreens.register(ModMenuTypes.PIZZA_STATION.get(), ScreenPizzaStation::new);

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
    }

    private void onFinish(final FMLLoadCompleteEvent event) {
        PizzaLayers.setMaps();
    }
}
