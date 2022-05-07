package com.algorithmlx.liaveres.common.container.slots;

import com.algorithmlx.liaveres.common.recipe.YarnRecipe;
import com.algorithmlx.liaveres.common.container.inventory.YarnCraftInventory;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;
import net.minecraftforge.event.ForgeEventFactory;

import java.util.Optional;

public class YarnOutputResultSlot extends Slot {
    private final YarnCraftInventory craftSlots;
    private final Player player;
    private int removeCount;

    public YarnOutputResultSlot(Player player, YarnCraftInventory slot, Container pContainer, int pIndex, int pX, int pY) {
        super(pContainer, pIndex, pX, pY);
        this.craftSlots = slot;
        this.player = player;
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return false;
    }

    @Override
    public ItemStack remove(int pAmount) {
        if (this.hasItem()) {
            this.removeCount += Math.min(pAmount, this.getItem().getCount());
        }

        return super.remove(pAmount);
    }

    @Override
    protected void onQuickCraft(ItemStack pStack, int pAmount) {
        this.removeCount += pAmount;
        this.checkTakeAchievements(pStack);
    }

    @Override
    protected void onSwapCraft(int pNumItemsCrafted) {
        this.removeCount += pNumItemsCrafted;
    }

    @Override
    protected void checkTakeAchievements(ItemStack pStack) {
        if (this.removeCount > 0) {
            pStack.onCraftedBy(this.player.getLevel(), this.player, this.removeCount);
            ForgeEventFactory.firePlayerCraftingEvent(this.player, pStack, this.craftSlots);
        }

        if (this.container instanceof RecipeHolder) {
            ((RecipeHolder) this.container).awardUsedRecipes(this.player);
        }

        this.removeCount = 0;
    }

    public void onTake(Player pPlayer, ItemStack pStack) {
        this.checkTakeAchievements(pStack);
        ForgeHooks.setCraftingPlayer(pPlayer);
        Optional<YarnRecipe> recipe = pPlayer.getLevel().getRecipeManager().getRecipeFor(YarnRecipe.RECIPE_TYPE, this.craftSlots, pPlayer.level);

        NonNullList<ItemStack> nonNullList = pPlayer.level.getRecipeManager().getRemainingItemsFor(YarnRecipe.RECIPE_TYPE, this.craftSlots, pPlayer.level);
        ForgeHooks.setCraftingPlayer(null);
        for (int integer = 0; integer < nonNullList.size(); ++integer) {
            ItemStack original = this.craftSlots.getItem(integer);
            ItemStack itemFromList = nonNullList.get(integer);

            if (!original.isEmpty()) {
                int count = 1;
                if (recipe.isPresent()) {
                    count = recipe.get().getIngredients().get(0).getItems()[integer].getCount();
                }
                this.craftSlots.removeItemWithoutUpdate(integer, count);
                original = this.craftSlots.getItem(integer);
            }

            if (!itemFromList.isEmpty()) {
                if (original.isEmpty()) {
                    this.craftSlots.setItem(integer, itemFromList);
                } else if (ItemStack.isSame(original, itemFromList) && ItemStack.tagMatches(original, itemFromList)) {
                    itemFromList.grow(original.getCount());
                    this.craftSlots.setItem(integer, itemFromList);
                } else if (!this.player.getInventory().add(itemFromList)) {
                    this.player.drop(itemFromList, false);
                }
            }
            this.craftSlots.setChanged();
        }
    }
}