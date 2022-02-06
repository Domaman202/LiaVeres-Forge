package com.algorithmlx.liaveres.common.recipe;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.util.recipe.LiaVeresRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;

public class YarnRecipe extends LiaVeresRecipe {
    public static final RecipeType<YarnRecipe> RECIPE_TYPE = new RecipeType<>() {
        @Override
        public String toString() {
            return LiaVeres.ModId + ":yarn";
        }
    };

    public YarnRecipe(ResourceLocation idIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int time) {
        super(RECIPE_TYPE, idIn, ingredientIn, resultIn, experienceIn, time);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Registration.YARN_RECIPE.get();
    }
}
