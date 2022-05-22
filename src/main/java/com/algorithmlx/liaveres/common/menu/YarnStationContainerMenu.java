package com.algorithmlx.liaveres.common.menu;

import com.algorithmlx.liaveres.common.menu.container.YarnCraftContainer;
import com.algorithmlx.liaveres.common.menu.container.YarnResultContainer;
import com.algorithmlx.liaveres.common.menu.slots.YarnInputSlot;
import com.algorithmlx.liaveres.common.menu.slots.YarnOutputResultSlot;
import com.algorithmlx.liaveres.common.setup.Registration;
import com.algorithmlx.liaveres.common.menu.slots.YarnInputSkeinSlot;
import core.liquid.objects.container.AdvancedContainerMenu;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

@SuppressWarnings("all")
public class YarnStationContainerMenu extends AdvancedContainerMenu {
    private final ContainerLevelAccess access;
    private final YarnCraftContainer craftSlot = new YarnCraftContainer(this, 3);
    private final YarnResultContainer resultSlot = new YarnResultContainer();

    public YarnStationContainerMenu(int windowId, Inventory inv) {
        this(windowId, inv, ContainerLevelAccess.NULL);
    }

    public YarnStationContainerMenu(int windowId, Inventory inv, ContainerLevelAccess access) {
        super(Registration.YARN_STATION_CONTAINER.get(), windowId, inv);
        this.access = access;

        this.makeInventorySlots(8, 64);
        this.addSlot(new YarnInputSlot(craftSlot, 0, 25, 17));
        this.addSlot(new YarnInputSkeinSlot(craftSlot, 2, 25, 53));
        this.addSlot(new YarnOutputResultSlot(inv.player, this.craftSlot, this.resultSlot, 1, 134, 35));
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return this.craftSlot.stillValid(pPlayer);
    }

    @Override
    public ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack itemStack1 = slot.getItem();
            itemStack = itemStack1;

            if (pIndex == 2) {
                this.access.execute(((level, blockPos) -> itemStack1.getItem().onCraftedBy(itemStack1, level, pPlayer)));
                if (!this.moveItemStackTo(itemStack1, 3, 39, true)) {
                    return ItemStack.EMPTY;
                }

                slot.onQuickCraft(itemStack1, itemStack);
            } else if (pIndex >= 1 && pIndex < 46) {
                if (!this.moveItemStackTo(itemStack1, 1, 10, false)) {
                    if (pIndex < 37) {
                        if (!this.moveItemStackTo(itemStack1, 37, 46, false)) {
                            return ItemStack.EMPTY;
                        }
                    } else if (!this.moveItemStackTo(itemStack1, 10, 37, false)) {
                        return ItemStack.EMPTY;
                    }
                }
            } else if (!this.moveItemStackTo(itemStack1, 10, 46, false)) {
                return ItemStack.EMPTY;
            }

            if (itemStack1.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }

            if (itemStack1.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot.onTake(pPlayer, itemStack1);
        }
        return itemStack;
    }

    @Override
    public boolean canTakeItemForPickAll(ItemStack pStack, Slot pSlot) {
        return pSlot.container != this.resultSlot && super.canTakeItemForPickAll(pStack, pSlot);
    }
}
