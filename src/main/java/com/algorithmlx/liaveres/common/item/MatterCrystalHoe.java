package com.algorithmlx.liaveres.common.item;

import com.algorithmlx.liaveres.common.api.enums.LVItemTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

import static com.algorithmlx.liaveres.common.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalHoe extends HoeItem {
    public MatterCrystalHoe() {
        super(LVItemTiers.MatterTear, 2147483647, 2147483647, new Item.Properties().fireResistant().tab(LIAVERES_ALL));
    }
    @Override
    public boolean hasContainerItem(ItemStack stack) {
        return true;
    }

    @Override
    public ItemStack getContainerItem(ItemStack stack) {
        return stack.copy();
    }
}
