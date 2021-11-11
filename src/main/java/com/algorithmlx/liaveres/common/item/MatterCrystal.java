package com.algorithmlx.liaveres.common.item;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.item.Item;


public class MatterCrystal extends Item {

    public MatterCrystal() {
        super(new Item.Properties().fireResistant().tab(ModSetup.CLASSIC_TAB));
    }
}
