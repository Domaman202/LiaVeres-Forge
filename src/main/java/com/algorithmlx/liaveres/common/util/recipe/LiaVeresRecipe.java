package com.algorithmlx.liaveres.common.util.recipe;

import com.algorithmlx.liaveres.common.util.container.helper.IngredientHelper;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public abstract class LiaVeresRecipe implements Recipe<Container> {
    protected final RecipeType<?> type;
    protected final ResourceLocation id;
    protected final Ingredient ingredient;
    protected final ItemStack result;
    protected final float experience;
    protected final int time;

    public LiaVeresRecipe(RecipeType<?> typeIn, ResourceLocation idIn, Ingredient ingredientIn, ItemStack resultIn, float experienceIn, int time) {
        this.type = typeIn;
        this.id = idIn;
        this.ingredient = ingredientIn;
        this.result = resultIn;
        this.experience = experienceIn;
        this.time = time;
    }

    public LiaVeresRecipe(RecipeType<?> typeIn, ResourceLocation idIn, Ingredient ingredientIn, ItemStack resultIn) {
        this.type = typeIn;
        this.id = idIn;
        this.ingredient = ingredientIn;
        this.result = resultIn;
        this.experience = 0;
        this.time = 0;
    }

    @Override
    public boolean matches(Container pContainer, Level pLevel) {
        return IngredientHelper.testInventory(this.ingredient, pContainer);
    }

    @Override
    public ItemStack assemble(Container pContainer) {
        return this.result.copy();
    }

    @Override
    public boolean canCraftInDimensions(int pWidth, int pHeight) {
        return true;
    }

    @Override
    public ItemStack getResultItem() {
        return this.result.copy();
    }

    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> nonNull = NonNullList.create();
        nonNull.add(this.ingredient);
        return nonNull;
    }

    public float getExperience() {
        return this.experience;
    }

    public ItemStack getResult() {
        return this.result;
    }

    public int getTime() {
        return this.time;
    }

    @Override
    public ResourceLocation getId() {
        return this.id;
    }

    @Override
    public RecipeType<?> getType() {
        return this.type;
    }

    @Override
    public String toString() {
        return "LiaVeresRecipe{" +
                "type=" + type +
                ", id=" + id +
                ", ingredient=" + ingredient +
                ", result=" + result +
                ", experience=" + experience +
                ", time=" + time +
                '}';
    }
}
