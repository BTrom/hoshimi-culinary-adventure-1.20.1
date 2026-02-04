package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.registry.ModEffects;
import com.botrom.hoshimi_ca_mod.registry.ModFeatures;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.registry.ModTags;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.CopperGolemSpawnLogic;
import com.botrom.hoshimi_ca_mod.utils.compat.copper.PlayerJoinHandler;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.core.Direction;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.Level;
import net.minecraftforge.common.BasicItemListing;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.event.entity.living.MobEffectEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.tags.ITagManager;

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

    @SubscribeEvent
    public static void onPotionAdded(MobEffectEvent.Applicable event) {
        MobEffect effect = event.getEffectInstance().getEffect();
        LivingEntity entity = event.getEntity();

        if (entity.getEffect(ModEffects.VANILLA_SCENT.get()) != null) {
            ITagManager<MobEffect> mobEffectTags = ForgeRegistries.MOB_EFFECTS.tags();
            if (mobEffectTags != null && !mobEffectTags.getTag(ModTags.UNAFFECTED_BY_VANILLA_SCENT).contains(effect)) {
                event.setResult(Event.Result.DENY);
            }
        }

        if (effect == ModEffects.SUGAR_RUSH.get() && !entity.level().isClientSide()) {
            entity.getPersistentData().putInt("SugarRushDuration", event.getEffectInstance().getDuration());
        }
    }

    @SubscribeEvent
    public static void onBlockPlaced(BlockEvent.EntityPlaceEvent event) {
        Level level = (Level) event.getLevel();
        Direction direction = Direction.NORTH;
        if (event.getEntity() != null) {
            direction = Direction.fromYRot(event.getEntity().getYRot());
        }
        CopperGolemSpawnLogic.handleBlockPlaced(level, event.getPos(), event.getPlacedBlock(), direction);
    }

    @SubscribeEvent
    public static void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
        if (event.getEntity() instanceof net.minecraft.server.level.ServerPlayer serverPlayer) {
            PlayerJoinHandler.onPlayerJoin(serverPlayer);
        }
    }
}
