package com.botrom.hoshimi_ca_mod.pizzacraft.advancement;

import com.botrom.hoshimi_ca_mod.HoshimiCulinaryMod;
import com.google.gson.JsonObject;
import net.minecraft.advancements.critereon.AbstractCriterionTriggerInstance;
import net.minecraft.advancements.critereon.ContextAwarePredicate;
import net.minecraft.advancements.critereon.DeserializationContext;
import net.minecraft.advancements.critereon.SimpleCriterionTrigger;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;

public class ChoppingBoardTrigger extends SimpleCriterionTrigger<ChoppingBoardTrigger.Instance>
{
    private static final ResourceLocation ID = new ResourceLocation(HoshimiCulinaryMod.MOD_ID, "use_chopping_board");

    public ResourceLocation getId() {
        return ID;
    }

    public void trigger(ServerPlayer player) {
        this.trigger(player, Instance::test);
    }

    @Override
    protected Instance createInstance(JsonObject pJson, ContextAwarePredicate pPredicate, DeserializationContext pDeserializationContext)
    {
        return new Instance(pPredicate);
    }

    public static class Instance extends AbstractCriterionTriggerInstance
    {
        public Instance(ContextAwarePredicate player) {
            super(ChoppingBoardTrigger.ID, player);
        }

        public static Instance simple() {
            return new Instance(ContextAwarePredicate.ANY);
        }

        public boolean test() {
            return true;
        }
    }
}