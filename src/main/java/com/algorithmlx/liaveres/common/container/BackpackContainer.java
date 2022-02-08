package com.algorithmlx.liaveres.common.container;

import com.algorithmlx.liaveres.common.container.api.Dimension;
import com.algorithmlx.liaveres.common.container.api.Point;
import com.algorithmlx.liaveres.common.gata.BackpackData;
import com.algorithmlx.liaveres.common.item.backpack.BackpackItem;
import com.algorithmlx.liaveres.common.setup.Constants;
import com.algorithmlx.liaveres.common.util.container.bases.AbstractContainer;
import com.algorithmlx.liaveres.common.util.container.nbt.ContainerTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BackpackContainer extends AbstractContainer {
    public static final int BACKPACK_INVENTORY = 1;
    private final Player player;
    private final InteractionHand hand;
    private ItemStack itemStack;
    int padding = 8;
    int titleSpace = 10;

    public BackpackContainer(int windowId, Inventory playerInventory, InteractionHand hand) {
        super(Constants.CONTAINER_TYPE, windowId, playerInventory);
        this.player = playerInventory.player;
        this.hand = hand;
        ItemStack stack = player.getItemInHand(hand);

        if (stack.getItem() instanceof BackpackItem) {
            this.loadContainer(playerInventory, stack);
        }
    }

    private void loadContainer(Inventory inventory, ItemStack itemStack) {
        Dimension dimension = this.getDimension();
        BackpackData type = this.getBackpack().getType();
        int rowWidth = type.getRowWidth();
        int rows = type.getRowHeight();

        ListTag tags = itemStack.getOrCreateTag().getList("Inventory", 10);
        SimpleContainer simpleContainer = new SimpleContainer(rowWidth * rows) {
            @Override
            public void setChanged() {
                itemStack.getOrCreateTag().put("Inventory", ContainerTag.inTag(this));
                super.setChanged();
            }
        };

        ContainerTag.fromTag(tags, simpleContainer);

        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < rowWidth; x++) {
                Point backpackSlotPosition = getBackpackSlotPosition(dimension, x, y);
                addSlot(new LockableSlot(simpleContainer, y * rowWidth + x, backpackSlotPosition.x + 1, backpackSlotPosition.y + 1));
            }
        }

        for (int y = 0; y < 3; ++y) {
            for (int x = 0; x < 9; ++x) {
                Point playerInvSlotPosition = getPlayerInvSlotPosition(dimension, x, y);
                this.addSlot(new LockableSlot(inventory, x + y * 9 + 9, playerInvSlotPosition.x + 1, playerInvSlotPosition.y + 1));
            }
        }

        for (int x = 0; x < 9; ++x) {
            Point playerInvSlotPosition = getPlayerInvSlotPosition(dimension, x, 3);
            this.addSlot(new LockableSlot(inventory, x, playerInvSlotPosition.x + 1, playerInvSlotPosition.y + 1));
        }
    }

    public BackpackItem getBackpack() {
        return (BackpackItem) player.getItemInHand(hand).getItem();
    }

    public Dimension getDimension() {
        BackpackData type = getBackpack().getType();
        return new Dimension(padding * 2 + Math.max(type.getRowWidth(), 9) * 18, padding * 2 + titleSpace * 2 + 8 + (type.getRowHeight() + 4) * 18);
    }

    public Point getBackpackSlotPosition(Dimension dimension, int x, int y) {
        BackpackData type = getBackpack().getType();
        return new Point(dimension.width / 2 - type.getRowWidth() * 9 + x * 18, padding + titleSpace + y * 18);
    }

    public Point getPlayerInvSlotPosition(Dimension dimension, int x, int y) {
        return new Point(dimension.width / 2 - 9 * 9 + x * 18, dimension.height - padding - 4 * 18 - 3 + y * 18 + (y == 3 ? 4 : 0));
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        ItemStack stack = pPlayer.getItemInHand(hand);
        return stack.getItem() instanceof BackpackItem;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player player, int index) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot = this.slots.get(index);
        if (slot != null && slot.hasItem()) {
            ItemStack toInsert = slot.getItem();
            itemStack = toInsert.copy();
            BackpackData type = getBackpack().getType();
            if (index < type.getRowHeight() * type.getRowWidth()) {
                if (!this.moveItemStackTo(toInsert, type.getRowHeight() * type.getRowWidth(), this.slots.size(), true)) {
                    return ItemStack.EMPTY;
                }
            } else if (!this.moveItemStackTo(toInsert, 0, type.getRowHeight() * type.getRowWidth(), false)) {
                return ItemStack.EMPTY;
            }

            if (toInsert.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }

        return itemStack;
    }

    public class LockableSlot extends Slot {
        public LockableSlot(Container container, int index, int x, int y) {
            super(container, index, x, y);
        }

        @Override
        public boolean mayPickup(Player player) {
            return !(getItem().getItem() instanceof BackpackItem) && getItem() != player.getItemInHand(hand);
        }

        @Override
        public boolean mayPlace(ItemStack stack) {
            return !(stack.getItem() instanceof BackpackItem) && stack != player.getItemInHand(hand);
        }
    }
}
