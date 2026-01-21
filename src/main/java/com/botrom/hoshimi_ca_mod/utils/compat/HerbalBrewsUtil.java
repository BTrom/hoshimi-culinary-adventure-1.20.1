package com.botrom.hoshimi_ca_mod.utils.compat;

import com.google.gson.JsonArray;
import net.minecraft.core.Direction;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.phys.shapes.BooleanOp;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Supplier;

public class HerbalBrewsUtil {

    public static VoxelShape rotateShape(Direction from, Direction to, VoxelShape shape) {
        VoxelShape[] buffer = new VoxelShape[]{shape, Shapes.empty()};
        int times = (to.get2DDataValue() - from.get2DDataValue() + 4) % 4;

        for(int i = 0; i < times; ++i) {
            buffer[0].forAllBoxes((minX, minY, minZ, maxX, maxY, maxZ) -> buffer[1] = Shapes.joinUnoptimized(buffer[1], Shapes.box(1.0 - maxZ, minY, minX, 1.0 - minZ, maxY, maxX), BooleanOp.OR));
            buffer[0] = buffer[1];
            buffer[1] = Shapes.empty();
        }

        return buffer[0];
    }

    public static NonNullList<Ingredient> deserializeIngredients(JsonArray json) {
        NonNullList<Ingredient> ingredients = NonNullList.create();

        for(int i = 0; i < json.size(); ++i) {
            Ingredient ingredient = Ingredient.fromJson(json.get(i));
            if (!ingredient.isEmpty()) {
                ingredients.add(ingredient);
            }
        }
        return ingredients;
    }

    public static boolean matchesRecipe(Container inventory, NonNullList<Ingredient> recipe, int startIndex, int endIndex) {
        List<ItemStack> validStacks = new ArrayList<>();

        for(int i = startIndex; i <= endIndex; ++i) {
            ItemStack stackInSlot = inventory.getItem(i);
            if (!stackInSlot.isEmpty()) {
                validStacks.add(stackInSlot);
            }
        }

        Iterator<Ingredient> var10 = recipe.iterator();

        boolean matches;
        do {
            if (!var10.hasNext()) {
                return true;
            }

            Ingredient entry = var10.next();
            matches = false;

            for (ItemStack item : validStacks) {
                if (entry.test(item)) {
                    matches = true;
                    validStacks.remove(item);
                    break;
                }
            }
        } while(matches);

        return false;
    }
}
