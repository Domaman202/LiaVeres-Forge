package com.algorithmlx.liaveres.common.util.container;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.SlotItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public abstract class AbstractContainer extends AbstractContainerMenu {
    private final IItemHandler playerInventory;

    public AbstractContainer(MenuType<?> container, int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(container, windowId);
        this.playerInventory = new InvWrapper(playerInventory);

        //makeInventorySlots(8, 84);
    }

    private int addSlotRange(IItemHandler handler, int index, int x, int y, int amount, int dx) {
        for (int i = 0 ; i < amount ; i++) {
            addSlot(new SlotItemHandler(handler, index, x, y));
            x += dx;
            index++;
        }
        return index;
    }

    private void addSlotBox(IItemHandler handler, int index, int x, int y, int horAmount, int dx, int verAmount, int dy) {
        for (int j = 0 ; j < verAmount ; j++) {
            index = addSlotRange(handler, index, x, y, horAmount, dx);
            y += dy;
        }
    }

    private void makeInventorySlots(int leftColX, int topRowY) {
        addSlotBox(playerInventory, 9, leftColX, topRowY, 9, 18, 3, 18);

        topRowY += 58;
        addSlotRange(playerInventory, 0, leftColX, topRowY, 9, 18);
    }
}
