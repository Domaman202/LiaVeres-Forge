package com.algorithmlx.liaveres.common.item;

import net.minecraft.world.item.Item;

import static com.algorithmlx.liaveres.common.setup.ModSetup.LIAVERES_ALL;

public class Crystalline extends Item {

    public Crystalline() {
        super(new Item.Properties().fireResistant().tab(LIAVERES_ALL));
    }

}
