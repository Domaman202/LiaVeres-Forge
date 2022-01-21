package com.algorithmlx.liaveres.common.item.basic;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.item.Item;

public class Matter extends Item {

    public Matter() {
        super(new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB));
    }
}