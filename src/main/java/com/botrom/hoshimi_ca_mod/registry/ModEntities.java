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
import java.util.function.Supplier;

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

	public static final RegistryObject<EntityType<ShimaEnagaEntity>> SHIMA_ENAGA = ENTITIES.register("shima_enaga",
			() -> EntityType.Builder.of(ShimaEnagaEntity::new, MobCategory.CREATURE)
					.sized(0.5F, 0.6F)
					.build("shima_enaga"));


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

	public static final RegistryObject<EntityType<HummingbirdEntity>> HUMMINGBIRD = ENTITIES.register("hummingbird",
			() -> EntityType.Builder.of(HummingbirdEntity::new, MobCategory.CREATURE)
					.sized(0.45F, 0.45F)
					.setTrackingRange(5)
					.build("hummingbird"));

	public static final RegistryObject<EntityType<HammerheadSharkEntity>> HAMMERHEAD_SHARK = ENTITIES.register("hammerhead_shark",
			() -> EntityType.Builder.of(HammerheadSharkEntity::new, MobCategory.WATER_CREATURE)
					.sized(2.4F, 1.25F)
					.setTrackingRange(10)
					.build("hammerhead_shark"));

	public static final RegistryObject<EntityType<CrowEntity>> CROW = ENTITIES.register("crow",
			() -> EntityType.Builder.of(CrowEntity::new, MobCategory.CREATURE)
					.sized(0.45F, 0.45F)
					.setTrackingRange(10)
					.build("crow"));

	public static final RegistryObject<EntityType<MantisShrimpEntity>> MANTIS_SHRIMP = ENTITIES.register("mantis_shrimp",
			() -> EntityType.Builder.of(MantisShrimpEntity::new, MobCategory.WATER_CREATURE)
					.sized(1.25F, 1.2F)
					.setTrackingRange(10)
					.build("mantis_shrimp"));

	public static final RegistryObject<EntityType<CachalotWhaleEntity>> CACHALOT_WHALE = ENTITIES.register("cachalot_whale",
			() -> EntityType.Builder.of(CachalotWhaleEntity::new, MobCategory.WATER_CREATURE)
					.sized(9F, 4.0F)
					.setTrackingRange(10)
					.build("cachalot_whale"));

	public static final RegistryObject<EntityType<TerrapinEntity>> TERRAPIN = ENTITIES.register("terrapin",
			() -> EntityType.Builder.of(TerrapinEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.75F, 0.45F)
					.setTrackingRange(5)
					.build("terrapin"));

	public static final RegistryObject<EntityType<FlyingFishEntity>> FLYING_FISH = ENTITIES.register("flying_fish",
			() -> EntityType.Builder.of(FlyingFishEntity::new, MobCategory.WATER_AMBIENT)
					.sized(0.6F, 0.4F)
					.setTrackingRange(5)
					.build("flying_fish"));

	public static final RegistryObject<EntityType<Shiba>> SHIBA = ENTITIES.register("shiba",
			() -> EntityType.Builder.of(Shiba::new, MobCategory.CREATURE)
					.sized(0.8F, 0.8F)
					.clientTrackingRange(8)
					.build("shiba"));

	public static final RegistryObject<EntityType<GiantMudCrabEntity>> GIANT_MUD_CRAB = ENTITIES.register("giant_mud_crab",
			() -> EntityType.Builder.of(GiantMudCrabEntity::new, MobCategory.WATER_CREATURE)
					.sized(0.9F, 0.6F)
					.build("giant_mud_crab"));

	public static final RegistryObject<EntityType<KingCrabEntity>> KING_CRAB = ENTITIES.register("king_crab",
			() -> EntityType.Builder.of(KingCrabEntity::new, MobCategory.WATER_CREATURE)
					.sized(1.0F, 0.8F)
					.build("king_crab"));

	public static final RegistryObject<EntityType<SandCrabEntity>> SAND_CRAB = ENTITIES.register("sand_crab",
			() -> EntityType.Builder.of(SandCrabEntity::new, MobCategory.WATER_CREATURE)
					.sized(0.4F, 0.2F)
					.build("sand_crab"));

	public static final RegistryObject<EntityType<CrayfishEntity>> CRAYFISH = ENTITIES.register("crayfish",
			() -> EntityType.Builder.of(CrayfishEntity::new, MobCategory.WATER_CREATURE)
					.sized(0.6F, 0.4F)
					.build("crayfish"));

	public static final RegistryObject<EntityType<Chester>> CHESTER = ENTITIES.register("chester",
			() -> EntityType.Builder.of(Chester::new, MobCategory.MISC)
					.sized(1F, 1F)
					.build("chester"));

	public static final RegistryObject<EntityType<Butterfly>> BUTTERFLY = ENTITIES.register("butterfly",
			() -> EntityType.Builder.of(Butterfly::new, MobCategory.AMBIENT)
					.sized(0.7F, 0.6F)
					.clientTrackingRange(8)
					.build("butterfly"));

	public static final RegistryObject<EntityType<Caterpillar>> CATERPILLAR = ENTITIES.register("caterpillar",
			() -> EntityType.Builder.of(Caterpillar::new, MobCategory.CREATURE)
					.sized(0.4F, 0.4F)
					.clientTrackingRange(10)
					.build("caterpillar"));

	public static final RegistryObject<EntityType<Lizard>> LIZARD = ENTITIES.register("lizard",
			() -> EntityType.Builder.of(Lizard::new, MobCategory.CREATURE)
					.sized(0.8F, 0.5F)
					.clientTrackingRange(10)
					.build("lizard"));

	public static final RegistryObject<EntityType<Tortoise>> TORTOISE = ENTITIES.register("tortoise",
			() -> EntityType.Builder.of(Tortoise::new, MobCategory.CREATURE)
					.sized(1.2F, 0.875F)
					.clientTrackingRange(10)
					.build("tortoise"));

	public static final RegistryObject<EntityType<Bird>> SPARROW = ENTITIES.register("sparrow",
			() -> EntityType.Builder.of(Bird::new, MobCategory.CREATURE)
					.sized(0.5F, 0.6F)
					.clientTrackingRange(8)
					.build("sparrow"));

	public static final RegistryObject<EntityType<Bird>> CARDINAL = ENTITIES.register("cardinal",
			() -> EntityType.Builder.of(Bird::new, MobCategory.CREATURE)
					.sized(0.5F, 0.6F)
					.clientTrackingRange(8)
					.build("cardinal"));

	public static final RegistryObject<EntityType<Snail>> SNAIL = ENTITIES.register("snail",
			() -> EntityType.Builder.of(Snail::new, MobCategory.CREATURE)
					.sized(0.7F, 0.7F)
					.clientTrackingRange(10)
					.build("snail"));

	public static RegistryObject<EntityType<EntityBaleenWhale>> BALEEN_WHALE = ENTITIES.register("baleen_whale",
			() -> EntityType.Builder.of(EntityBaleenWhale::new, MobCategory.CREATURE)
					.sized(2.6F, 1.6F)
					.setTrackingRange(10)
					.build("baleen_whale"));



	// Projectiles
	public static final RegistryObject<EntityType<ThrownParrotEgg>> PARROT_EGG = ENTITIES.register("parrot_egg",
			() -> EntityType.Builder.<ThrownParrotEgg>of(ThrownParrotEgg::new, MobCategory.MISC)
					.sized(0.25F, 0.25F)
					.updateInterval(10)
					.clientTrackingRange(4)
					.build(Utils.createResourceLocation("parrot_egg").toString()));

	public static final RegistryObject<EntityType<SharkToothArrowEntity>> SHARK_TOOTH_ARROW = ENTITIES.register("shark_tooth_arrow",
			() -> EntityType.Builder.<SharkToothArrowEntity>of(SharkToothArrowEntity::new, MobCategory.MISC)
					.sized(0.5F, 0.5F)
					.setCustomClientFactory(SharkToothArrowEntity::new)
					.build("shark_tooth_arrow"));

	public static final RegistryObject<EntityType<CachalotEchoEntity>> CACHALOT_ECHO = ENTITIES.register("cachalot_echo",
			() -> EntityType.Builder.<CachalotEchoEntity>of(CachalotEchoEntity::new, MobCategory.MISC)
					.sized(2F, 2F)
					.setCustomClientFactory(CachalotEchoEntity::new)
					.fireImmune()
					.build("cachalot_echo"));



	// Blocks
	public static final RegistryObject<EntityType<Birdcage>> BIRDCAGE = ENTITIES.register("birdcage",
			() -> EntityType.Builder.of(Birdcage::new, MobCategory.MISC)
					.sized(0.0001F, 0.0001F)
					.setUpdateInterval(20)
					.setTrackingRange(256)
					.build(Utils.createResourceLocation("birdcage").toString()));



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
		event.put(SHIMA_ENAGA.get(), ShimaEnagaEntity.createAttributes().build());
		event.put(LOBSTER.get(), LobsterEntity.bakeAttributes().build());
		event.put(CATFISH.get(), CatfishEntity.bakeAttributes().build());
		event.put(GIANT_SQUID.get(), GiantSquidEntity.bakeAttributes().build());
		event.put(COMB_JELLY.get(), CombJellyEntity.bakeAttributes().build());
		event.put(MIMIC_OCTOPUS.get(), MimicOctopusEntity.bakeAttributes().build());
		event.put(SEAGULL.get(), SeagullEntity.bakeAttributes().build());
		event.put(HUMMINGBIRD.get(), HummingbirdEntity.bakeAttributes().build());
		event.put(HAMMERHEAD_SHARK.get(), HammerheadSharkEntity.bakeAttributes().build());
		event.put(CROW.get(), CrowEntity.bakeAttributes().build());
		event.put(MANTIS_SHRIMP.get(), MantisShrimpEntity.bakeAttributes().build());
		event.put(CACHALOT_WHALE.get(), CachalotWhaleEntity.bakeAttributes().build());
		event.put(TERRAPIN.get(), TerrapinEntity.bakeAttributes().build());
		event.put(FLYING_FISH.get(), FlyingFishEntity.bakeAttributes().build());
		event.put(SHIBA.get(), Shiba.bakeAttributes().build());
		event.put(GIANT_MUD_CRAB.get(), GiantMudCrabEntity.setAttributes().build());
		event.put(SAND_CRAB.get(), SandCrabEntity.setAttributes().build());
		event.put(KING_CRAB.get(), KingCrabEntity.setAttributes().build());
		event.put(CRAYFISH.get(), CrayfishEntity.setAttributes().build());
		event.put(CHESTER.get(), Chester.registerAttributes().build());
		event.put(SNAIL.get(), Snail.createAttributes().build());
		event.put(BUTTERFLY.get(), Butterfly.createAttributes().build());
		event.put(CARDINAL.get(), Bird.createAttributes().build());
		event.put(SPARROW.get(), Bird.createAttributes().build());
		event.put(CATERPILLAR.get(), Caterpillar.createAttributes().build());
		event.put(LIZARD.get(), Lizard.createAttributes().build());
		event.put(TORTOISE.get(), Tortoise.createAttributes().build());
		event.put(BALEEN_WHALE.get(), EntityBaleenWhale.registerAttributes().build());
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
		event.register(SHIMA_ENAGA.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, FlyingMob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(LOBSTER.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, LobsterEntity::canLobsterSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CATFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CatfishEntity::canCatfishSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(GIANT_SQUID.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantSquidEntity::canGiantSquidSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(COMB_JELLY.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CombJellyEntity::canCombJellySpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(MIMIC_OCTOPUS.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MimicOctopusEntity::canMimicOctopusSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SEAGULL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SeagullEntity::canSeagullSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(HUMMINGBIRD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, HummingbirdEntity::canHummingbirdSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(HAMMERHEAD_SHARK.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, HammerheadSharkEntity::canHammerheadSharkSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CROW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, CrowEntity::canCrowSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(MANTIS_SHRIMP.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, MantisShrimpEntity::canMantisShrimpSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CACHALOT_WHALE.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CachalotWhaleEntity::canCachalotWhaleSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(TERRAPIN.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, TerrapinEntity::canTerrapinSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(FLYING_FISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, WaterAnimal::checkSurfaceWaterAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(GIANT_MUD_CRAB.get(), SpawnPlacements.Type.NO_RESTRICTIONS, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, GiantMudCrabEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(KING_CRAB.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, KingCrabEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SAND_CRAB.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, SandCrabEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CRAYFISH.get(), SpawnPlacements.Type.IN_WATER, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, CrayfishEntity::canSpawn, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SHIBA.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Animal::checkAnimalSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SNAIL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(BUTTERFLY.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Butterfly::checkButterflySpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(CARDINAL.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(SPARROW.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING, Bird::checkBirdSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(LIZARD.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
		event.register(TORTOISE.get(), SpawnPlacements.Type.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, Mob::checkMobSpawnRules, SpawnPlacementRegisterEvent.Operation.AND);
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