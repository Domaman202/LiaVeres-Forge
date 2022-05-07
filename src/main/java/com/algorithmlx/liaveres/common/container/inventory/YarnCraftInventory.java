package com.algorithmlx.liaveres.common.container.inventory;

import core.liquid.objects.container.BasedContainer;
import net.minecraft.core.NonNullList;
import net.minecraft.world.Container;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.StackedContents;
import net.minecraft.world.inventory.StackedContentsCompatible;
import net.minecraft.world.item.ItemStack;

public class YarnCraftInventory implements Container, StackedContentsCompatible {
    private final NonNullList<ItemStack> items;
    private final int size;
    private final BasedContainer menu;

    public YarnCraftInventory(BasedContainer menu, int size) {
        this.items = NonNullList.withSize(size, ItemStack.EMPTY);
        this.menu = menu;
        this.size = size;
    }

    @Override
    public int getContainerSize() {
        return this.items.size();
    }

    @Override
    public boolean isEmpty() {
        for (ItemStack stack : this.items) {
            if (!stack.isEmpty()) {
                return false;
            }
        }
        return true;
    }

    @Override
    public ItemStack getItem(int pIndex) {
        return pIndex >= this.getContainerSize() ? ItemStack.EMPTY : this.items.get(pIndex);
    }

    @Override
    public ItemStack removeItemNoUpdate(int pIndex) {
        return ContainerHelper.takeItem(this.items, pIndex);
    }

    public ItemStack removeItemWithoutUpdate(int slot, int count) {
        return ContainerHelper.removeItem(this.items, slot, count);
    }

    @Override
    public ItemStack removeItem(int pIndex, int pCount) {
        ItemStack itemStack = ContainerHelper.removeItem(this.items, pIndex, pCount);
        if (!itemStack.isEmpty()) {
            this.menu.slotsChanged(this);
        }
        return itemStack;
    }

    @Override
    public void setItem(int pIndex, ItemStack pStack) {
        this.items.set(pIndex, pStack);
        this.menu.slotsChanged(this);
    }

    @Override
    public void setChanged() {
        this.menu.slotsChanged(this);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return true;
    }

    @Override
    public void clearContent() {
        this.items.clear();
    }

    @Override
    public void fillStackedContents(StackedContents pHelper) {
        for (ItemStack itemStack : this.items) {
            pHelper.accountSimpleStack(itemStack);
        }
    }
}
