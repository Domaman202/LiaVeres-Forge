package com.algorithmlx.liaveres.common.item.basic;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.item.Item;

@Deprecated
public class Crystalline extends Item {
    public Crystalline() {
        super(new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB));
    }
}
