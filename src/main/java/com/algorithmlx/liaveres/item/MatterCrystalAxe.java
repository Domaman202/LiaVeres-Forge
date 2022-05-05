package com.algorithmlx.liaveres.item;

import net.minecraft.item.ItemAxe;

public class MatterCrystalAxe extends ItemAxe {
    public MatterCrystalAxe(ToolMaterial material, String itemId) {
        super(material, Integer.MAX_VALUE, Integer.MAX_VALUE);
        this.setRegistryName(itemId);
    }
}
