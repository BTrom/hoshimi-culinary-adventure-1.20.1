package com.botrom.hoshimi_ca_mod.registry;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.utils.mixins.vanillabackportsmixins.access.TreeDecoratorTypeAccessor;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.treedecorators.AttachedToLogsDecorator;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.treedecorators.CreakingHeartDecorator;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.treedecorators.PaleMossDecorator;
import com.botrom.hoshimi_ca_mod.utils.compat.vanillabackport.treedecorators.PlaceOnGroundDecorator;
import com.botrom.hoshimi_ca_mod.worldgen.tree.PalmFoliagePlacer;
import com.botrom.hoshimi_ca_mod.worldgen.tree.PalmTrunkPlacer;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.foliageplacers.FoliagePlacerType;
import net.minecraft.world.level.levelgen.feature.treedecorators.TreeDecoratorType;
import net.minecraft.world.level.levelgen.feature.trunkplacers.TrunkPlacerType;
import net.minecraftforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModTreePlacerTypes {
    public static final DeferredRegister<FoliagePlacerType<?>> FOLIAGE_PLACERS = DeferredRegister.create(Registries.FOLIAGE_PLACER_TYPE, HoshimiCulinaryMod.MOD_ID);
    public static final DeferredRegister<TrunkPlacerType<?>> TRUNK_PLACERS = DeferredRegister.create(Registries.TRUNK_PLACER_TYPE, HoshimiCulinaryMod.MOD_ID);
    public static final DeferredRegister<TreeDecoratorType<?>> TREE_DECORATORS = DeferredRegister.create(Registries.TREE_DECORATOR_TYPE, HoshimiCulinaryMod.MOD_ID);

    public static final Supplier<FoliagePlacerType<PalmFoliagePlacer>> PALM_FOLIAGE_PLACER = FOLIAGE_PLACERS.register("palm_foliage_placer", () -> new FoliagePlacerType<>(PalmFoliagePlacer.CODEC));
    public static final Supplier<TrunkPlacerType<PalmTrunkPlacer>> PALM = TRUNK_PLACERS.register("palm_trunk_placer", () -> new TrunkPlacerType<>(PalmTrunkPlacer.CODEC));
    public static final Supplier<TreeDecoratorType<PaleMossDecorator>> PALE_MOSS = TREE_DECORATORS.register("pale_moss", () -> TreeDecoratorTypeAccessor.createTreeDecorator(PaleMossDecorator.CODEC));
    public static final Supplier<TreeDecoratorType<CreakingHeartDecorator>> CREAKING_HEART = TREE_DECORATORS.register("creaking_heart", () -> TreeDecoratorTypeAccessor.createTreeDecorator(CreakingHeartDecorator.CODEC));
    public static final Supplier<TreeDecoratorType<AttachedToLogsDecorator>> ATTACHED_TO_LOGS = TREE_DECORATORS.register("attached_to_logs", () -> TreeDecoratorTypeAccessor.createTreeDecorator(AttachedToLogsDecorator.CODEC));
    public static final Supplier<TreeDecoratorType<PlaceOnGroundDecorator>> PLACE_ON_GROUND = TREE_DECORATORS.register("place_on_ground", () -> TreeDecoratorTypeAccessor.createTreeDecorator(PlaceOnGroundDecorator.CODEC));
}
