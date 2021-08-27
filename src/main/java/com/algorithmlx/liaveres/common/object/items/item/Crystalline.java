package com.algorithmlx.liaveres.common.object.items.item;

import com.algorithmlx.liaveres.LiaVeres;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

public class Crystalline extends Item {

    public Crystalline() {
        super(new Item.Properties().group(LiaVeres.lv_itemgroup));
        setRegistryName("crystalline");
    }

    @Override
    public ActionResultType onItemUse(ItemUseContext context) {
        PlayerEntity player = context.getPlayer();
        Hand hand = context.getHand();
        ItemStack itemstack = player.getHeldItem(hand);
        return ActionResultType.SUCCESS;
    }
}