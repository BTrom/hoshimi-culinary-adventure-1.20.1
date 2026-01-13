package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.List;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID)
public class ModEvents {

    @SubscribeEvent
    public static void addCustomTrades(VillagerTradesEvent event) {

        if(event.getType() == VillagerProfession.FARMER) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            ItemStack stack = new ItemStack(Items.EMERALD, 1);
            int villagerLevel = 1;

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CUCUMBER.get(), 22),
                    stack,10,2,0.02F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.EGGPLANT.get(), 15),
                    stack,10,2,0.02F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.CORN.get(), 15),
                    stack,10,2,0.02F));

            trades.get(villagerLevel).add((trader, rand) -> new MerchantOffer(
                    new ItemStack(ModItems.AVOCADO.get(), 20),
                    stack,10,2,0.02F));
        }

        if(event.getType() == VillagerProfession.FISHERMAN) {
            Int2ObjectMap<List<VillagerTrades.ItemListing>> trades = event.getTrades();
            VillagerProfession profession = event.getType();
            ResourceLocation professionKey = ForgeRegistries.VILLAGER_PROFESSIONS.getKey(profession);
            if (professionKey == null) return;
            if (professionKey.getPath().equals("fisherman")) {
                trades.get(1).add(
                        new BasicItemListing(new ItemStack(ModItems.RAW_FIDDLER_CRAB.get(), 6),
                        new ItemStack(Items.EMERALD), 16, 2, 0.05F));
                trades.get(1).add(
                        new BasicItemListing(new ItemStack(ModItems.RAW_SHRIMP.get(), 8),
                        new ItemStack(Items.EMERALD), 16, 2, 0.05F));
                trades.get(2).add(
                        new BasicItemListing(new ItemStack(ModItems.RAW_LOBSTER.get(), 4),
                        new ItemStack(Items.EMERALD), 16, 5, 0.05F));
                trades.get(2).add(
                        new BasicItemListing(new ItemStack(ModItems.CLAM.get(), 3),
                        new ItemStack(Items.EMERALD), 16, 5, 0.05F));
                trades.get(4).add(
                        new BasicItemListing(new ItemStack(ModItems.PEARL.get(), 1),
                        new ItemStack(Items.EMERALD), 16, 5, 0.05F));
                trades.get(4).add(
                        new BasicItemListing(new ItemStack(Items.TRIDENT, 64),
                        new ItemStack(ModItems.PEARL.get()), 1, 12, 0.05F));
            }
        }
    }
}
