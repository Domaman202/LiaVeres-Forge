package com.algorithmlx.liaveres.common.container;

import com.algorithmlx.liaveres.common.item.backpack.BasicBackpack;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.util.container.bases.ContainerForItem;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.jetbrains.annotations.NotNull;

public class BasicBackpackContainer extends ContainerForItem {
    public BasicBackpackContainer(int windowId, Inventory playerInventory, InteractionHand hand) {
        this(windowId, playerInventory, hand, new SimpleContainer(10));
        makeInventorySlots(8, 84);
    }

    //For slots
    public BasicBackpackContainer(int windowId, Inventory playerInventory, InteractionHand hand, Container container) {
        super(Registration.BASIC_BACKPACK_CONTAINER.get(), windowId, playerInventory);
        Player player = playerInventory.player;

        addSlot(new Slot(container, 0, 8, 33));
        addSlot(new Slot(container, 1, 26, 33));
        addSlot(new Slot(container, 2, 44, 33));
        addSlot(new Slot(container, 3, 62, 33));
        addSlot(new Slot(container, 4, 80, 33));
        addSlot(new Slot(container, 5, 98, 33));
        addSlot(new Slot(container, 6, 116, 33));
        addSlot(new Slot(container, 7, 134, 33));
        addSlot(new Slot(container, 8, 152, 33));

        ItemStack itemStack = player.getItemInHand(hand);
        if (itemStack.getItem() instanceof BasicBackpack) {
            loadAndSaveTags(playerInventory, itemStack);
        }
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        ItemStack stack = pPlayer.getItemBySlot(EquipmentSlot.MAINHAND);
        return stack.getItem() instanceof BasicBackpack;
    }

    @Override
    public @NotNull ItemStack quickMoveStack(Player pPlayer, int pIndex) {
        ItemStack stack = ItemStack.EMPTY;
        Slot slot = this.slots.get(pIndex);

        if (slot != null && slot.hasItem()) {
            ItemStack insert = slot.getItem();
            stack = insert.copy();

            if (insert.isEmpty()) {
                slot.set(ItemStack.EMPTY);
            } else {
                slot.setChanged();
            }
        }
        return stack;
    }
}
