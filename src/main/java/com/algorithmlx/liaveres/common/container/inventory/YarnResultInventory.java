package com.algorithmlx.liaveres.common.container.inventory;

import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Recipe;
import org.jetbrains.annotations.Nullable;

public class YarnResultInventory implements Container, RecipeHolder {
    private final NonNullList<ItemStack> itemStacks = NonNullList.withSize(1, ItemStack.EMPTY);
    @Nullable
    private Recipe<?> recipeUsed;

    @Override
    public int getContainerSize() {
        return 2;
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.itemStacks) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return this.itemStacks.get(0);
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        return ContainerHelper.takeItem(this.itemStacks, 0);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        return ContainerHelper.takeItem(this.itemStacks, 0);
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        this.itemStacks.set(0, pStack);
    }

    @Override
    public void setChanged() {

    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    @Override
    public void clearContent() {
        this.itemStacks.clear();
    }

    @Override
    public void setRecipeUsed(@Nullable Recipe<?> pRecipe) {
        this.recipeUsed = pRecipe;
    }

    @Nullable
    @Override
    public Recipe<?> getRecipeUsed() {
        return this.recipeUsed;
    }
}
