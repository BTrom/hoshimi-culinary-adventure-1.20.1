package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.effects.*;
import com.botrom.hoshimi_ca_mod.utils.compat.crockpot.CrockPotEffect;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraftforge.common.ForgeMod;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class ModEffects {
	public static final DeferredRegister<MobEffect> EFFECTS = DeferredRegister.create(ForgeRegistries.MOB_EFFECTS, HoshimiCulinaryMod.MOD_ID);

	public static final RegistryObject<MobEffect> CORROSION = EFFECTS.register("corrosion", CorrosionEffect::new);
	public static final RegistryObject<MobEffect> VOLATILITY = EFFECTS.register("volatility", VolatilityEffect::new);
	public static final RegistryObject<MobEffect> SURGE = EFFECTS.register("surge", SurgeEffect::new);
	public static final RegistryObject<MobEffect> REBOUND = EFFECTS.register("rebound", ReboundEffect::new);
	public static final RegistryObject<MobEffect> CAFFEINATED = EFFECTS.register("caffeinated", CaffeinatedEffect::new);
	public static final RegistryObject<MobEffect> DOG_FOOD = EFFECTS.register("dog_food", DogFoodEffect::new);
	public static final RegistryObject<MobEffect> SWEETS = EFFECTS.register("sweets", SweetsEffect::new);
	public static final RegistryObject<MobEffect> RESTED = EFFECTS.register("rested", RestedEffect::new);
	public static final RegistryObject<MobEffect> FARMERS_BLESSING = EFFECTS.register("farmers_blessing", FarmersBlessingEffect::new);
	public static final RegistryObject<MobEffect> CHARGE = EFFECTS.register("charge", () -> new CrockPotEffect(MobEffectCategory.BENEFICIAL, 0x4ea4ff).addAttributeModifier(Attributes.ATTACK_DAMAGE, "7CC714DA-8444-4ECE-88A2-6A566E54A896", 0.35, AttributeModifier.Operation.MULTIPLY_BASE));
	public static final RegistryObject<MobEffect> GNAWS_GIFT = EFFECTS.register("gnaws_gift", () -> new CrockPotEffect(MobEffectCategory.BENEFICIAL, 0x650808));
	public static final RegistryObject<MobEffect> OCEAN_AFFINITY = EFFECTS.register("ocean_affinity", () -> new CrockPotEffect(MobEffectCategory.BENEFICIAL, 0x15ddf4).addAttributeModifier(ForgeMod.SWIM_SPEED.get(), "0216DFD0-874B-45F6-B030-D298D365C8D0", 0.15, AttributeModifier.Operation.MULTIPLY_BASE));
	public static final RegistryObject<MobEffect> WELL_FED = EFFECTS.register("well_fed", () -> new CrockPotEffect(MobEffectCategory.BENEFICIAL, 0xda765b).addAttributeModifier(Attributes.ARMOR, "095FA141-E902-4BEF-99DB-DDC55213C07A", 1.0, AttributeModifier.Operation.ADDITION).addAttributeModifier(Attributes.ATTACK_DAMAGE, "5762F89C-8317-4021-B7EE-4DD93902941C", 1.0, AttributeModifier.Operation.ADDITION));
	public static final RegistryObject<MobEffect> WITHER_RESISTANCE = EFFECTS.register("wither_resistance", () -> new CrockPotEffect(MobEffectCategory.BENEFICIAL, 0x72008f));

	public static void register(IEventBus bus) {
		EFFECTS.register(bus);
	}
}