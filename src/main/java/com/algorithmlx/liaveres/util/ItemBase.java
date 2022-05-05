package com.algorithmlx.liaveres.util;

import net.minecraft.item.Item;

public class ItemBase extends Item {
    public ItemBase(String itemId) {
        this.setRegistryName(itemId);
    }
}
