package com.algorithmlx.liaveres.common.recipe;

import com.algorithmlx.liaveres.common.setup.Registration;
import core.liquid.recipes.LiquidRecipes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;

public class YarnRecipe extends LiquidRecipes {
    public YarnRecipe(ResourceLocation idIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int time) {
        super(RecipeTypes.YARN_RECIPE_TYPE, idIn, ingredientIn, resultIn, experienceIn, time);
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return Registration.YARN_RECIPE.get();
    }
}
