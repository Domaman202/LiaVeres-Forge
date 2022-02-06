package com.algorithmlx.liaveres.common.util.container.yarn.slots;

import net.minecraft.world.Container;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.RecipeHolder;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.ForgeHooks;

public class YarnOutputSkeinSlot extends Slot {
    private final YarnInputSkeinSlot inputSkeinSlot;
    private final Player player;
    private int removeCount;

    public YarnOutputSkeinSlot(Player player, YarnInputSkeinSlot slot, Container pContainer, int pIndex, int pX, int pY) {
        super(pContainer, pIndex, pX, pY);
        this.inputSkeinSlot = slot;
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
        }

        if (this.container instanceof RecipeHolder) {
            ((RecipeHolder) this.container).awardUsedRecipes(this.player);
        }

        this.removeCount = 0;
    }

    @Override
    public void onTake(Player pPlayer, ItemStack pStack) {
        ForgeHooks.setCraftingPlayer(pPlayer);
    }
}
