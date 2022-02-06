package com.algorithmlx.liaveres.common.util.recipe;

import com.algorithmlx.liaveres.common.util.container.helper.IngredientHelper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonSyntaxException;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.ForgeRegistryEntry;
import org.jetbrains.annotations.Nullable;

public class LiaVeresRecipeSerializer<T extends LiaVeresRecipe> extends ForgeRegistryEntry<RecipeSerializer<?>> implements RecipeSerializer<T> {
    public final LiaFactory<T> factory;

    public LiaVeresRecipeSerializer(LiaFactory<T> factory) {
        this.factory = factory;
    }

    @Override
    public T fromJson(ResourceLocation pRecipeId, JsonObject json) {
        JsonElement jsonElement = GsonHelper.getAsJsonArray(json, "ingredient");
        Ingredient ingredient = IngredientHelper.fromJson(jsonElement);

        if (!json.has("result"))
            throw new JsonSyntaxException("Missing result, expected to find a string or object");

        ItemStack itemStack;

        if (json.get("result").isJsonObject())
            itemStack = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "result"));
        else {
            String s1 = GsonHelper.getAsString(json, "result");
            ResourceLocation location = new ResourceLocation(s1);
            itemStack = new ItemStack(ForgeRegistries.ITEMS.getValue(location));
        }

        float f = GsonHelper.getAsFloat(json, "exp", 0.0F);
        int i = GsonHelper.getAsInt(json, "cooktime", 0);
        return this.factory.create(pRecipeId, ingredient, itemStack, f, i);
    }

    @Nullable
    @Override
    public T fromNetwork(ResourceLocation pRecipeId, FriendlyByteBuf pBuffer) {
        Ingredient ingredient = Ingredient.fromNetwork(pBuffer);
        ItemStack itemStack = pBuffer.readItem();
        float f = pBuffer.readFloat();
        int i = pBuffer.readInt();
        return this.factory.create(pRecipeId, ingredient, itemStack, f, i);
    }

    @Override
    public void toNetwork(FriendlyByteBuf pBuffer, T pRecipe) {
        pRecipe.ingredient.toNetwork(pBuffer);
        pBuffer.writeItem(pRecipe.result);
        pBuffer.writeFloat(pRecipe.experience);
        pBuffer.writeVarInt(pRecipe.time);
    }

    public interface LiaFactory<T extends LiaVeresRecipe> {
        T create(ResourceLocation pLocation, Ingredient pIngredient, ItemStack pStack, float floatBuffer, int intBuffer);
    }
}
