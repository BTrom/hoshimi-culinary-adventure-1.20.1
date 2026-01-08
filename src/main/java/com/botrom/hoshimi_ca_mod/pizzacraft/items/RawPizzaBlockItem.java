package com.botrom.hoshimi_ca_mod.pizzacraft.items;

import com.botrom.hoshimi_ca_mod.pizzacraft.blockentity.PizzaBlockEntity;
import com.botrom.hoshimi_ca_mod.pizzacraft.client.renderer.PizzaWithoutLevelRenderer;
import com.botrom.hoshimi_ca_mod.pizzacraft.client.tooltip.PizzaTooltipComponent;
import com.botrom.hoshimi_ca_mod.registry.ModBlocks;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.inventory.tooltip.TooltipComponent;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;

import java.util.Optional;
import java.util.function.Consumer;

public class RawPizzaBlockItem extends BlockItem
{
    public RawPizzaBlockItem(Block block, Properties properties)
    {
        super(block, properties);
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer)
    {
        super.initializeClient(consumer);

        consumer.accept(new IClientItemExtensions()
        {
            @Override
            public BlockEntityWithoutLevelRenderer getCustomRenderer()
            {
                return new PizzaWithoutLevelRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels(), () -> new PizzaBlockEntity(BlockPos.ZERO, ModBlocks.RAW_PIZZA.get().defaultBlockState()));
            }
        });
    }

    @Override
    public Optional<TooltipComponent> getTooltipImage(ItemStack pStack)
    {
        return Optional.of(new PizzaTooltipComponent(pStack));
    }
}