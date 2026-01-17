package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.blocks.entities.Birdcage;
import com.botrom.hoshimi_ca_mod.entities.*;
import com.botrom.hoshimi_ca_mod.utils.Utils;
import com.google.common.base.Predicates;
import net.minecraft.tags.TagKey;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.*;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.animal.WaterAnimal;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraftforge.event.entity.EntityAttributeCreationEvent;
import net.minecraftforge.event.entity.SpawnPlacementRegisterEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.function.Predicate;

@Mod.EventBusSubscriber(modid = HoshimiCulinaryMod.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModEntities {
	public static final DeferredRegister<EntityType<?>> ENTITIES = DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, HoshimiCulinaryMod.MOD_ID);

	public static final RegistryObject<EntityType<TigerPrawn>> TIGER_PRAWN = ENTITIES.register("tiger_prawn",
		() -> EntityType.Builder.of(TigerPrawn::new, MobCategory.CREATURE)
			.sized(0.7F, 0.35F)
			.clientTrackingRange(4)
			.build(HoshimiCulinaryMod.MOD_ID + ".tiger_prawn"));

	public static final RegistryObject<EntityType<Urchin>> URCHIN = ENTITIES.register("urchin",
		() -> EntityType.Builder.of(Urchin::new, MobCategory.CREATURE)
			.sized(0.5F, 0.4F)
			.clientTrackingRange(4)
			.build(HoshimiCulinaryMod.MOD_ID + ".urchin"));

	public static final RegistryObject<EntityType<PlatinumBass>> PLATINUM_BASS = ENTITIES.register("platinum_bass",
		() -> EntityType.Builder.of(PlatinumBass::new, MobCategory.CREATURE)
			.sized(1F, 0.6F)
			.clientTrackingRange(4)
			.build(HoshimiCulinaryMod.MOD_ID + ".platinum_bass"));

	public static final RegistryObject<EntityType<Clam>> CLAM = ENTITIES.register("clam",
		() -> EntityType.Builder.of(Clam::new, MobCategory.CREATURE)
			.sized(0.6F, 0.5F)
			.clientTrackingRange(8)
			.build(HoshimiCulinaryMod.MOD_ID + ".clam"));

	public static final RegistryObject<EntityType<ChieftainCrab>> CHIEFTAIN_CRAB = ENTITIES.register("chieftain_crab",
	 	() -> EntityType.Builder.of(ChieftainCrab::new, MobCategory.CREATURE)
			.sized(0.7F, 0.65F)
			.clientTrackingRange(10)
			.build(HoshimiCulinaryMod.MOD_ID + ".chieftain_crab"));

//	public static final RegistryObject<EntityType<UrchinDart>> URCHIN_DART = ENTITIES.register("urchin_dart",
//		() -> EntityType.Builder.<UrchinDart>of(UrchinDart::new, MobCategory.MISC)
//			.sized(0.5F, 0.5F)
//			.clientTrackingRange(4)
//			.updateInterval(20)
//			.build(HoshimiCulinaryMod.MOD_ID + ".urchin_dart"));

//	public static final RegistryObject<EntityType<ThrownShimmeringPearl>> SHIMMERING_PEARL = ENTITIES.register("shimmering_pearl",
//		() -> EntityType.Builder.<ThrownShimmeringPearl>of(ThrownShimmeringPearl::new, MobCategory.MISC)
//			.sized(0.25F, 0.25F)
//			.clientTrackingRange(4)
//			.updateInterval(10)
//			.build(HoshimiCulinaryMod.MOD_ID + ".shimmering_pearl"));

	public static final RegistryObject<EntityType<FiddlerCrab>> FIDDLER_CRAB = ENTITIES.register("fiddler_crab",
			() -> EntityType.Builder.of(FiddlerCrab::new, MobCategory.CREATURE)
				.sized(.7f, .7f)
				.clientTrackingRange(10)
				.build(HoshimiCulinaryMod.MOD_ID + ".fiddler_crab"));

	public static final RegistryObject<EntityType<DumboOctopusEntity>> DUMBO_OCTOPUS = ENTITIES.register("dumbo_octopus",
			() -> EntityType.Builder.of(DumboOctopusEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.4F, 0.4F)
					.build("dumbo_octopus"));

	public static final RegistryObject<EntityType<KoiFishEntity>> KOI_FISH = ENTITIES.register("koi_fish",
			() -> EntityType.Builder.of(KoiFishEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.6F, 0.3F)
					.build("koi_fish"));

	public static final RegistryObject<EntityType<LobsterEntity>> LOBSTER = ENTITIES.register("lobster",
			() -> EntityType.Builder.of(LobsterEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.7F, 0.4F)
					.setTrackingRange(5)
					.build("lobster"));

	public static final RegistryObject<EntityType<CatfishEntity>> CATFISH = ENTITIES.register("catfish",
			() -> EntityType.Builder.of(CatfishEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.9F, 0.6F)
					.setTrackingRange(5)
					.build("catfish"));

	public static final RegistryObject<EntityType<GiantSquidEntity>> GIANT_SQUID = ENTITIES.register("giant_squid",
			() -> EntityType.Builder.of(GiantSquidEntity::new, MobCategory.WATER_CREATURE)
					.sized(0.9F, 1.2F)
					.setTrackingRange(10)
					.build("giant_squid"));

	public static final RegistryObject<EntityType<CombJellyEntity>> COMB_JELLY = ENTITIES.register("comb_jelly",
			() -> EntityType.Builder.of(CombJellyEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.65F, 0.8F)
					.setTrackingRange(5)
					.build("comb_jelly"));

	public static final RegistryObject<EntityType<MimicOctopusEntity>> MIMIC_OCTOPUS = ENTITIES.register("mimic_octopus",
			() -> EntityType.Builder.of(MimicOctopusEntity::new, MobCategory.WATER_CREATURE)
					.sized(0.9F, 0.6F)
					.setTrackingRange(8)
					.build("mimic_octopus"));

	public static final RegistryObject<EntityType<SeagullEntity>> SEAGULL = ENTITIES.register("seagull",
			() -> EntityType.Builder.of(SeagullEntity::new, MobCategory.CREATURE)
					.sized(0.45F, 0.45F)
					.setTrackingRange(10)
					.build("seagull"));

	public static final RegistryObject<EntityType<EntityHummingbird>> HUMMINGBIRD = ENTITIES.register("hummingbird",
			() -> EntityType.Builder.of(EntityHummingbird::new, MobCategory.CREATURE)
					.sized(0.45F, 0.45F)
					.setTrackingRange(5)
					.build("hummingbird"));

	public static final RegistryObject<EntityType<EntityHammerheadShark>> HAMMERHEAD_SHARK = ENTITIES.register("hammerhead_shark",
			() -> EntityType.Builder.of(EntityHammerheadShark::new, MobCategory.WATER_CREATURE)
					.sized(2.4F, 1.25F)
					.setTrackingRange(10)
					.build("hammerhead_shark"));

	public static final RegistryObject<EntityType<EntityCrow>> CROW = ENTITIES.register("crow",
			() -> EntityType.Builder.of(EntityCrow::new, MobCategory.CREATURE)
					.sized(0.45F, 0.45F)
					.setTrackingRange(10)
					.build("crow"));

	public static final RegistryObject<EntityType<EntityMantisShrimp>> MANTIS_SHRIMP = ENTITIES.register("mantis_shrimp",
			() -> EntityType.Builder.of(EntityMantisShrimp::new, MobCategory.WATER_CREATURE)
					.sized(1.25F, 1.2F)
					.setTrackingRange(10)
					.build("mantis_shrimp"));

	public static final RegistryObject<EntityType<EntityCachalotWhale>> CACHALOT_WHALE = ENTITIES.register("cachalot_whale",
			() -> EntityType.Builder.of(EntityCachalotWhale::new, MobCategory.WATER_CREATURE)
					.sized(9F, 4.0F)
					.setTrackingRange(10)
					.build("cachalot_whale"));

	public static final RegistryObject<EntityType<EntityTerrapin>> TERRAPIN = ENTITIES.register("terrapin",
			() -> EntityType.Builder.of(EntityTerrapin::new, MobCategory.WATER_AMBIENT)
					.sized(0.75F, 0.45F)
					.setTrackingRange(5)
					.build("terrapin"));

	public static final RegistryObject<EntityType<EntityFlyingFish>> FLYING_FISH = ENTITIES.register("flying_fish",
			() -> EntityType.Builder.of(EntityFlyingFish::new, MobCategory.WATER_AMBIENT)
					.sized(0.6F, 0.4F)
					.setTrackingRange(5)
					.build("flying_fish"));

	public static final RegistryObject<EntityType<Shiba>> SHIBA = ENTITIES.register("shiba",
			() -> EntityType.Builder.of(Shiba::new, MobCategory.CREATURE)
					.sized(0.8F, 0.8F)
					.clientTrackingRange(8)
					.build("shiba"));

//	public static final EntityType<KingCrabEntity> KING_CRAB =Registry.register(Registries.ENTITY_TYPE,
//			new Identifier(MoreCrustacean.MOD_ID,"king_crab"),
//			FabricEntityTypeBuilder.create(SpawnGroup.WATER_CREATURE, KingCrabEntity::new).dimensions(EntityDimensions.fixed(1.0f,0.8f)).build());

//	public static RegistryObject<EntityType<EntityBaleenWhale>> BALEEN_WHALE = ENTITIES.register("baleen_whale",
//			() -> EntityType.Builder.of(EntityBaleenWhale::new, MobCategory.CREATURE)
//					.sized(2.6F, 1.6F)
//					.clientTrackingRange(64)
//					.setUpdateInterval(1)
//					.setShouldReceiveVelocityUpdates(true)
//					.build("baleen_whale"));

	public static final RegistryObject<EntityType<Birdcage>> BIRDCAGE = ENTITIES.register("birdcage",
			() -> EntityType.Builder.of(Birdcage::new, MobCategory.MISC)
					.sized(0.0001F, 0.0001F)
					.setUpdateInterval(20)
					.setTrackingRange(256)
					.build(Utils.createResourceLocation("birdcage").toString()));

	public static final RegistryObject<EntityType<Chester>> CHESTER = ENTITIES.register("chester",
			() -> EntityType.Builder.of(Chester::new, MobCategory.MISC)
					.sized(1F, 1F)
					.build("chester"));



	// Projectiles
	public static final RegistryObject<EntityType<ThrownParrotEgg>> PARROT_EGG = ENTITIES.register("parrot_egg",
			() -> EntityType.Builder.<ThrownParrotEgg>of(ThrownParrotEgg::new, MobCategory.MISC)
					.sized(0.25F, 0.25F)
					.updateInterval(10)
					.clientTrackingRange(4)
					.build(Utils.createResourceLocation("parrot_egg").toString()));

	public static final RegistryObject<EntityType<EntitySharkToothArrow>> SHARK_TOOTH_ARROW = ENTITIES.register("shark_tooth_arrow",
			() -> EntityType.Builder.<EntitySharkToothArrow>of(EntitySharkToothArrow::new, MobCategory.MISC)
					.sized(0.5F, 0.5F)
					.setCustomClientFactory(EntitySharkToothArrow::new)
					.build("shark_tooth_arrow"));

	public static final RegistryObject<EntityType<EntityCachalotEcho>> CACHALOT_ECHO = ENTITIES.register("cachalot_echo",
			() -> EntityType.Builder.<EntityCachalotEcho>of(EntityCachalotEcho::new, MobCategory.MISC)
					.sized(2F, 2F)
					.setCustomClientFactory(EntityCachalotEcho::new)
					.fireImmune()
					.build("cachalot_echo"));



	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(TIGER_PRAWN.get(), TigerPrawn.createAttributes().build());
		event.put(URCHIN.get(), Urchin.createAttributes().build());
		event.put(PLATINUM_BASS.get(), PlatinumBass.createAttributes().build());
		event.put(CLAM.get(), Clam.createAttributes().build());
		event.put(CHIEFTAIN_CRAB.get(), ChieftainCrab.createAttributes().build());
		event.put(FIDDLER_CRAB.get(), FiddlerCrab.createAttributes().build());
		event.put(DUMBO_OCTOPUS.get(), DumboOctopusEntity.createAttributes().build());
		event.put(KOI_FISH.get(), KoiFishEntity.createAttributes().build());
		event.put(LOBSTER.get(), LobsterEntity.bakeAttributes().build());
		event.put(CATFISH.get(), CatfishEntity.bakeAttributes().build());
		event.put(GIANT_SQUID.get(), GiantSquidEntity.bakeAttributes().build());
		event.put(COMB_JELLY.get(), CombJellyEntity.bakeAttributes().build());
		event.put(MIMIC_OCTOPUS.get(), MimicOctopusEntity.bakeAttributes().build());
		event.put(SEAGULL.get(), SeagullEntity.bakeAttributes().build());
		event.put(HUMMINGBIRD.get(), EntityHummingbird.bakeAttributes().build());
		event.put(HAMMERHEAD_SHARK.get(), EntityHammerheadShark.bakeAttributes().build());
		event.put(CROW.get(), EntityCrow.bakeAttributes().build());
		event.put(MANTIS_SHRIMP.get(), EntityMantisShrimp.bakeAttributes().build());
		event.put(CACHALOT_WHALE.get(), EntityCachalotWhale.bakeAttributes().build());
		event.put(TERRAPIN.get(), EntityTerrapin.bakeAttributes().build());
		event.put(FLYING_FISH.get(), EntityFlyingFish.bakeAttributes().build());
		event.put(SHIBA.get(), Shiba.bakeAttributes().build());
		event.put(CHESTER.get(), Chester.registerAttributes().build());
	}

	@SubscribeEvent
	public static void registerEntitySpawnPlacements(SpawnPlacementRegisterEvent event) {
		event.register(PLATINUM_BASS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, PlatinumBass::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(TIGER_PRAWN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TigerPrawn::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(URCHIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Urchin::checkWaterGroundSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CLAM.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Clam::checkWaterGroundSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CHIEFTAIN_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, ChieftainCrab::checkCrabSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(FIDDLER_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.WORLD_SURFACE, FiddlerCrab::checkCrabSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(DUMBO_OCTOPUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(KOI_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(LOBSTER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LobsterEntity::canLobsterSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CATFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CatfishEntity::canCatfishSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(GIANT_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantSquidEntity::canGiantSquidSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(COMB_JELLY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CombJellyEntity::canCombJellySpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(MIMIC_OCTOPUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MimicOctopusEntity::canMimicOctopusSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SEAGULL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeagullEntity::canSeagullSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(HUMMINGBIRD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, EntityHummingbird::canHummingbirdSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(HAMMERHEAD_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityHammerheadShark::canHammerheadSharkSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CROW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, EntityCrow::canCrowSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(MANTIS_SHRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityMantisShrimp::canMantisShrimpSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CACHALOT_WHALE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityCachalotWhale::canCachalotWhaleSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(TERRAPIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, EntityTerrapin::canTerrapinSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(FLYING_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SHIBA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
	}

	public static Predicate<LivingEntity> buildPredicateFromTag(TagKey<EntityType<?>> entityTag){
		if(entityTag == null){
			return Predicates.alwaysFalse();
		} else {
			return (com.google.common.base.Predicate<LivingEntity>) e -> e.isAlive() && e.getType().is(entityTag);
		}
	}

	public static boolean rollSpawn(int rolls, RandomSource random, MobSpawnType reason){
		if(reason == MobSpawnType.SPAWNER){
			return true;
		}else{
			return rolls <= 0 || random.nextInt(rolls) == 0;
		}
	}

	public static void register(IEventBus bus) {
		ENTITIES.register(bus);
	}
}