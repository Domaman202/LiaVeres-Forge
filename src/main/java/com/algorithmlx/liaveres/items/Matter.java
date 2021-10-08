package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.LiaVeres;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class Matter extends Item {

    public Matter() {
        super(new Item.Properties().isImmuneToFire().group(LIAVERES_ALL));
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        ItemStack itemstack = player.getHeldItem(hand);
        return ActionResultType.SUCCESS;
    }
}