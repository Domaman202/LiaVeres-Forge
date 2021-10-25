package com.algorithmlx.liaveres.items;

import net.minecraft.world.item.Item;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class Crystalline extends Item {

    public Crystalline() {
        super(new Item.Properties().fireResistant().tab(LIAVERES_ALL));
    }

}
