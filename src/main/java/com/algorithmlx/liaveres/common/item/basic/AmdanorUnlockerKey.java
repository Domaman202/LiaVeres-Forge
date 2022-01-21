package com.algorithmlx.liaveres.common.item.basic;

import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Rarity;

public class AmdanorUnlockerKey extends Item {
    public AmdanorUnlockerKey() {
        super(new Properties().fireResistant().tab(ModSetup.CLASSIC_TAB).rarity(Rarity.valueOf("LEGENDARY")).stacksTo(1));
    }

    @Override
    public boolean isFoil(ItemStack pStack) {
        return true;
    }
}
