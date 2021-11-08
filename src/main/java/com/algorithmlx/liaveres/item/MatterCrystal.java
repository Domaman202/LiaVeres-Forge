package com.algorithmlx.liaveres.item;

import net.minecraft.item.Item;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;


public class MatterCrystal extends Item {
    public MatterCrystal() {
        super(new Properties().fireResistant().tab(LIAVERES_ALL));
    }
}
