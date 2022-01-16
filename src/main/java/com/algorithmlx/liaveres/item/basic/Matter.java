package com.algorithmlx.liaveres.item.basic;

import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraft.world.item.Item;

public class Matter extends Item {

    public Matter() {
        super(new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB));
    }
}