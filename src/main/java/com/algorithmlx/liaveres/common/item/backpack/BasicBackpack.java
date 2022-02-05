package com.algorithmlx.liaveres.common.item.backpack;

import com.algorithmlx.liaveres.common.container.BasicBackpackContainer;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;

public class BasicBackpack extends Item {
    public BasicBackpack() {
        super(new Properties().tab(ModSetup.CLASSIC_TAB));
    }

    @Override
    public @NotNull InteractionResultHolder<ItemStack> use(Level pLevel, Player pPlayer, InteractionHand pUsedHand) {
        pPlayer.startUsingItem(InteractionHand.MAIN_HAND);

        if (!pLevel.isClientSide()) {
            pPlayer.openMenu(new SimpleMenuProvider((id, inv, player) -> new BasicBackpackContainer(id, inv, pUsedHand), this.getDescription()));
        }

        return InteractionResultHolder.success(pPlayer.getItemInHand(InteractionHand.MAIN_HAND));
    }
}
