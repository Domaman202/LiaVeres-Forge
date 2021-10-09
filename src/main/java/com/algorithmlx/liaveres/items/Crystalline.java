package com.algorithmlx.liaveres.items;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemUseContext;
import net.minecraft.util.ActionResultType;
import net.minecraft.util.Hand;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class Crystalline extends Item {

    public Crystalline() {
        super(new Item.Properties().isImmuneToFire().group(LIAVERES_ALL));
    }

}
