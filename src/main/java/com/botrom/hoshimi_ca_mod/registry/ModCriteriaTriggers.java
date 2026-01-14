package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.advancement.EatFoodTrigger;
import com.botrom.hoshimi_ca_mod.advancement.PiglinBarteringTrigger;
import net.minecraft.advancements.CriteriaTriggers;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModCriteriaTriggers {

    public static PiglinBarteringTrigger PIGLIN_BARTERING_TRIGGER;
    public static EatFoodTrigger EAT_FOOD_TRIGGER;

    @SubscribeEvent
    public static void onCommonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            PIGLIN_BARTERING_TRIGGER = CriteriaTriggers.register(new PiglinBarteringTrigger());
            EAT_FOOD_TRIGGER = CriteriaTriggers.register(new EatFoodTrigger());
        });
    }
}
