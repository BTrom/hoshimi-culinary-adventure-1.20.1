package com.botrom.hoshimi_ca_mod.events;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.FlyingFishEntity;
import com.botrom.hoshimi_ca_mod.entities.GiantSquidEntity;
import com.botrom.hoshimi_ca_mod.entities.MimicOctopusEntity;
import com.botrom.hoshimi_ca_mod.items.ILeftClick;
import com.botrom.hoshimi_ca_mod.registry.ModEffects;
import com.botrom.hoshimi_ca_mod.registry.ModEntities;
import com.botrom.hoshimi_ca_mod.registry.ModItems;
import com.botrom.hoshimi_ca_mod.utils.ModConfig;
import com.botrom.hoshimi_ca_mod.utils.RainbowUtil;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.AMWorldData;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.BeachedCachalotWhaleSpawner;
import com.botrom.hoshimi_ca_mod.utils.compat.alex.MessageSwingArm;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import it.unimi.dsi.fastutil.objects.ObjectList;
import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.game.ClientboundSetExperiencePacket;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.TicketType;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.stats.Stats;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.AvoidEntityGoal;
import net.minecraft.world.entity.ai.goal.TemptGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.NonTameRandomTargetGoal;
import net.minecraft.world.entity.animal.*;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.monster.Creeper;
import net.minecraft.world.entity.monster.Spider;
import net.minecraft.world.entity.npc.VillagerProfession;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.entity.npc.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.AbstractArrow;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.phys.*;
import net.minecraftforge.client.event.ComputeFovModifierEvent;
import net.minecraftforge.event.AddReloadListenerEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.EntityEvent;
import net.minecraftforge.event.entity.EntityStruckByLightningEvent;
import net.minecraftforge.event.entity.ProjectileImpactEvent;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.ItemTooltipEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.event.village.VillagerTradesEvent;
import net.minecraftforge.event.village.WandererTradesEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.items.ItemHandlerHelper;
import org.antlr.v4.runtime.misc.Triple;

import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ServerEvents {
    private static final Map<ServerLevel, BeachedCachalotWhaleSpawner> BEACHED_CACHALOT_WHALE_SPAWNER_MAP = new HashMap<>();
    public static final ObjectList<Triple<ServerPlayer, ServerLevel, BlockPos>> teleportPlayers = new ObjectArrayList<>();

    @SubscribeEvent
    public static void onServerTick(TickEvent.LevelTickEvent tick) {
        if (!tick.level.isClientSide && tick.level instanceof ServerLevel serverWorld) {
            BEACHED_CACHALOT_WHALE_SPAWNER_MAP.computeIfAbsent(serverWorld,
                k -> new BeachedCachalotWhaleSpawner(serverWorld));
            BeachedCachalotWhaleSpawner spawner = BEACHED_CACHALOT_WHALE_SPAWNER_MAP.get(serverWorld);
            spawner.tick();

            if (!teleportPlayers.isEmpty()) {
                for (final var triple : teleportPlayers) {
                    ServerPlayer player = triple.a;
                    ServerLevel endpointWorld = triple.b;
                    BlockPos endpoint = triple.c;
                    final int heightFromMap = endpointWorld.getHeight(Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, endpoint.getX(), endpoint.getZ());
                    endpoint = new BlockPos(endpoint.getX(), Math.max(heightFromMap, endpoint.getY()), endpoint.getZ());
                    player.teleportTo(endpointWorld, endpoint.getX() + 0.5D, endpoint.getY() + 0.5D, endpoint.getZ() + 0.5D, player.getYRot(), player.getXRot());
                    ChunkPos chunkpos = new ChunkPos(endpoint);
                    endpointWorld.getChunkSource().addRegionTicket(TicketType.POST_TELEPORT, chunkpos, 1, player.getId());
                    player.connection.send(new ClientboundSetExperiencePacket(player.experienceProgress, player.totalExperience, player.experienceLevel));

                }
                teleportPlayers.clear();
            }
        }
    }

    protected static BlockHitResult rayTrace(Level worldIn, Player player, ClipContext.Fluid fluidMode) {
        final float x = player.getXRot();
        final float y = player.getYRot();
        Vec3 vector3d = player.getEyePosition(1.0F);
        final float f0 = -y * Mth.DEG_TO_RAD - Mth.PI;
        final float f1 = -x * Mth.DEG_TO_RAD;
        final float f2 = Mth.cos(f0);
        final float f3 = Mth.sin(f0);
        final float f4 = -Mth.cos(f1);
        final float f5 = Mth.sin(f1);
        final float f6 = f3 * f4;
        final float f7 = f2 * f4;
        final double d0 = player.getAttribute(net.minecraftforge.common.ForgeMod.BLOCK_REACH.get()).getValue();
        Vec3 vector3d1 = vector3d.add(f6 * d0, f5 * d0, f7 * d0);
        return worldIn.clip(new ClipContext(vector3d, vector3d1, ClipContext.Block.OUTLINE, fluidMode, player));
    }

    private static final Random RAND = new Random();


    @SubscribeEvent
    public static void onPlayerLeftClick(PlayerInteractEvent.LeftClickEmpty event) {
        boolean flag = false;
        ItemStack leftItem = event.getEntity().getOffhandItem();
        ItemStack rightItem = event.getEntity().getMainHandItem();
        if(leftItem.getItem() instanceof final ILeftClick iLeftClick){
            iLeftClick.onLeftClick(leftItem, event.getEntity());
            flag = true;
        }
        if(rightItem.getItem() instanceof final ILeftClick iLeftClick){
            iLeftClick.onLeftClick(rightItem, event.getEntity());
            flag = true;
        }
        if (flag && event.getLevel().isClientSide) {
            HoshimiCulinaryMod.sendMSGToServer(MessageSwingArm.INSTANCE);
        }
    }

    @SubscribeEvent
    public static void onStruckByLightning(EntityStruckByLightningEvent event) {
        if (event.getEntity().getType() == EntityType.SQUID && !event.getEntity().level().isClientSide) {
            ServerLevel level = (ServerLevel) event.getEntity().level();
            event.setCanceled(true);
            GiantSquidEntity squid = ModEntities.GIANT_SQUID.get().create(level);
            squid.moveTo(event.getEntity().getX(), event.getEntity().getY(), event.getEntity().getZ(), event.getEntity().getYRot(), event.getEntity().getXRot());
            squid.finalizeSpawn(level, level.getCurrentDifficultyAt(squid.blockPosition()), MobSpawnType.CONVERSION, null, null);
            if (event.getEntity().hasCustomName()) {
                squid.setCustomName(event.getEntity().getCustomName());
                squid.setCustomNameVisible(event.getEntity().isCustomNameVisible());
            }
            squid.setBlue(true);
            squid.setPersistenceRequired();
            level.addFreshEntityWithPassengers(squid);
            event.getEntity().discard();
        }
    }

    @SubscribeEvent
    public void onInteractWithEntity(PlayerInteractEvent.EntityInteract event) {
        if (event.getTarget() instanceof LivingEntity living) {
            if (RainbowUtil.getRainbowType(living) > 0 && (event.getItemStack().getItem() == Items.SPONGE)) {
                event.setCanceled(true);
                event.setCancellationResult(InteractionResult.SUCCESS);
                RainbowUtil.setRainbowType(living, 0);
                if (!event.getEntity().isCreative()) {
                    event.getItemStack().shrink(1);
                }
                ItemStack wetSponge = new ItemStack(Items.WET_SPONGE);
                if (!event.getEntity().addItem(wetSponge)) {
                    event.getEntity().drop(wetSponge, true);
                }
            }
        }
    }

    @SubscribeEvent
    public void onUseItemAir(PlayerInteractEvent.RightClickEmpty event) {
        ItemStack stack = event.getEntity().getItemInHand(event.getHand());
        if (stack.isEmpty()) {
            stack = event.getEntity().getItemBySlot(EquipmentSlot.MAINHAND);
        }
        if (RainbowUtil.getRainbowType(event.getEntity()) > 0 && (stack.is(Items.SPONGE))) {
            event.getEntity().swing(InteractionHand.MAIN_HAND);
            RainbowUtil.setRainbowType(event.getEntity(), 0);
            if (!event.getEntity().isCreative()) {
                stack.shrink(1);
            }
            ItemStack wetSponge = new ItemStack(Items.WET_SPONGE);
            if (!event.getEntity().addItem(wetSponge)) {
                event.getEntity().drop(wetSponge, true);
            }
        }
    }

    @SubscribeEvent
    public void onEntityFinalizeSpawn(MobSpawnEvent.FinalizeSpawn event) {
        final var entity = event.getEntity();
        try {
            if (ModConfig.dolphinsAttackFlyingFish && entity instanceof final Dolphin dolphin) {
                dolphin.targetSelector.addGoal(2,
                    new NearestAttackableTargetGoal<>(dolphin, FlyingFishEntity.class, 70, true, true, null));
            }
        } catch (Exception e) {
            HoshimiCulinaryMod.LOGGER.warn("Tried to add unique behaviors to vanilla mobs and encountered an error");
        }
    }

    @SubscribeEvent
    public void onLivingDamageEvent(LivingDamageEvent event) {
        if (event.getSource().getEntity() instanceof final LivingEntity attacker) {
//            if (event.getAmount() > 0 && attacker.hasEffect(AMEffectRegistry.SOULSTEAL.get()) && attacker.getEffect(AMEffectRegistry.SOULSTEAL.get()) != null) {
//                final int level = attacker.getEffect(AMEffectRegistry.SOULSTEAL.get()).getAmplifier() + 1;
//                if (attacker.getHealth() < attacker.getMaxHealth()
//                    && ThreadLocalRandom.current().nextFloat() < (0.25F + (level * 0.25F))) {
//                    attacker.heal(Math.min(event.getAmount() / 2F * level, 2 + 2 * level));
//                }
//            }

            if (event.getEntity() instanceof final Player player) {
                if (attacker instanceof final MimicOctopusEntity octupus && octupus.isOwnedBy(player)) {
                    event.setCanceled(true);
                    return;
                }
            }
        }
    }

    @SubscribeEvent
    public void onLivingUpdateEvent(LivingEvent.LivingTickEvent event) {
        final var entity = event.getEntity();
        if (entity instanceof Player player) {
            if (player.getEyeHeight() < player.getBbHeight() * 0.5D) {
                player.refreshDimensions();
            }
        }
    }

    @SubscribeEvent
    public void onFOVUpdate(ComputeFovModifierEvent event) {
//        if (event.getPlayer().hasEffect(AMEffectRegistry.FEAR.get()) || event.getPlayer().hasEffect(AMEffectRegistry.POWER_DOWN.get())) {
//            event.setNewFovModifier(1.0F);
//        }
    }
}
