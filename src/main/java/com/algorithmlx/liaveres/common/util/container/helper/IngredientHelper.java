package com.algorithmlx.liaveres.common.util.container.helper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.registries.ForgeRegistries;

import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public class IngredientHelper {
    public static boolean testInventory(Ingredient ingredient, Container inventory) {
        if (ingredient.getItems().length != inventory.getContainerSize()) return false;

        for (int i = 0; i < inventory.getContainerSize(); i++) {
            ItemStack ingredientItem = ingredient.getItems()[i];
            ItemStack inputItem = inventory.getItem(i);


            if (!ingredientItem.getItem().equals(inputItem.getItem()) || ingredientItem.getCount() > inputItem.getCount()) {
                return false;
            }
        }


        return true;
    }

    public static ItemStack getStack(JsonObject object) {
        int count = 1;
        if (object.has("count")) {
            count = GsonHelper.getAsInt(object, "count");
        }
        ResourceLocation itemLocation = new ResourceLocation(GsonHelper.getAsString(object, "item"));
        Item item = ForgeRegistries.ITEMS.getValue(itemLocation);
        return new ItemStack(item, count);
    }

    public static Ingredient fromJson(JsonElement jsonelement) {
        if (jsonelement.isJsonArray()) {
            return Ingredient.fromValues(
                    StreamSupport.stream(jsonelement.getAsJsonArray().spliterator(), false).map((object) -> {
                        ItemStack stack = getStack(object.getAsJsonObject());
                        return new Ingredient.ItemValue(stack);
                    })
            );
        } else if (jsonelement.isJsonObject()) {
            JsonObject object = jsonelement.getAsJsonObject();

            return Ingredient.fromValues(Stream.of(new Ingredient.ItemValue(getStack(object))));
        }
        return null;
    }
}
