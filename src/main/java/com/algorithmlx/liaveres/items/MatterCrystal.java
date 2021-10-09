package com.algorithmlx.liaveres.items;

import net.minecraft.item.Item;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;


public class MatterCrystal extends Item {

    public MatterCrystal() {
        super(new Item.Properties().isImmuneToFire().group(LIAVERES_ALL));
    }
}
