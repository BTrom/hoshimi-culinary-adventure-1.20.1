package com.botrom.hoshimi_ca_mod.utils.compat;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.botrom.hoshimi_ca_mod.entities.models.ShibaModel;
import net.minecraft.client.Minecraft;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Mob;
import org.apache.commons.lang3.tuple.Pair;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class QuarkModelHandler {

	private static final Map<ModelLayerLocation, Layer> layers = new HashMap<>();

	public static ModelLayerLocation shiba;

	private static boolean modelsInitted = false;

	private static void initModels() {
		if(modelsInitted)
			return;

		shiba = addModel("shiba", ShibaModel::createBodyLayer, ShibaModel::new);

		modelsInitted = true;
	}

	private static ModelLayerLocation addModel(String name, Supplier<LayerDefinition> supplier, Function<ModelPart, EntityModel<?>> modelConstructor) {
		return addLayer(name, new Layer(supplier, modelConstructor));
	}

	private static ModelLayerLocation addLayer(String name, Layer layer) {
		ModelLayerLocation loc = new ModelLayerLocation(new ResourceLocation(HoshimiCulinaryMod.MOD_ID, name), "main");
		layers.put(loc, layer);
		return loc;
	}

	@SuppressWarnings("unchecked")
	public static <T extends Mob, M extends EntityModel<T>> M model(ModelLayerLocation location) {
		initModels();

		Layer layer = layers.get(location);
		Minecraft mc = Minecraft.getInstance();

		return (M) layer.modelConstructor.apply(mc.getEntityModels().bakeLayer(location));
	}

	public static ModelLayerLocation getShiba() {
		initModels();
		return shiba;
	}

	private static class Layer {
		final Supplier<LayerDefinition> definition;
		final Function<ModelPart, EntityModel<?>> modelConstructor;

		public Layer(Supplier<LayerDefinition> definition, Function<ModelPart, EntityModel<?>> modelConstructor) {
			this.definition = definition;
			this.modelConstructor = modelConstructor;
		}
	}
}
