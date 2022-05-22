package com.algorithmlx.liaveres.common.recipe;

import com.algorithmlx.liaveres.common.LiaVeres;
import core.liquid.recipes.LiquidRecipeType;
import net.minecraft.world.item.crafting.Recipe;

@SuppressWarnings("SameParameterValue")
public class RecipeTypes {
    public static final LiquidRecipeType<YarnRecipe> YARN_RECIPE_TYPE = standardLiaVeresRecipe("yarn_recipe");

    private static <T extends Recipe<?>> LiquidRecipeType<T> standardLiaVeresRecipe(String recipeId) {
        return new LiquidRecipeType<>(LiaVeres.ModId, recipeId);
    }
}
