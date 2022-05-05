package com.algorithmlx.liaveres.item;

import net.minecraft.item.ItemAxe;
import net.minecraft.item.ItemSword;

public class MatterCrystalSword extends ItemSword {
    public MatterCrystalSword(ToolMaterial material, String itemId) {
        super(material);
        this.setRegistryName(itemId);
    }
}
