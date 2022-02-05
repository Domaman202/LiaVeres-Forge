package com.algorithmlx.liaveres.common.util.container.slot;

import com.algorithmlx.liaveres.common.item.backpack.BasicBackpack;
import net.minecraft.world.Container;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class LockableSlot extends Slot {
    private final Player player;
    private final InteractionHand hand;

    public LockableSlot(Container pContainer, int pIndex, int pX, int pY, Player player, InteractionHand hand) {
        super(pContainer, pIndex, pX, pY);

        this.player = player;
        this.hand = hand;
    }

    @Override
    public boolean mayPickup(Player player) {
        return !(getItem().getItem() instanceof BasicBackpack) && getItem() != player.getItemInHand(hand);
    }

    @Override
    public boolean mayPlace(ItemStack stack) {
        return !(stack.getItem() instanceof BasicBackpack) && stack != player.getItemInHand(hand);
    }
}
