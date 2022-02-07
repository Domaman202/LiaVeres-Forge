package com.algorithmlx.liaveres.common.item.backpack;

import com.algorithmlx.liaveres.common.container.BackpackContainer;
import com.algorithmlx.liaveres.common.gata.BackpackData;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BackpackItem extends Item {
    private final BackpackData backpackData;
    public BackpackItem(BackpackData data, Item.Properties properties) {
        super(properties);
        this.backpackData = data;
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.startUsingItem(pUsedHand);

        if (!pLevel.isClientSide()) {
            pPlayer.openMenu(new SimpleMenuProvider((id, inv, player) -> new BackpackContainer(id, inv, pUsedHand), this.getDescription()));
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(pUsedHand));
    }

    @Override
    public boolean shouldCauseReequipAnimation(ItemStack oldStack, ItemStack newStack, boolean slotChanged) {
        return false;
    }

    public BackpackData getBackpackType() {
        return this.backpackData;
    }
}
