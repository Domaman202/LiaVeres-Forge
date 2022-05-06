package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.util.item.FoodBase;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.item.ItemStack;

public class EnchantedApple extends FoodBase {
    public EnchantedApple(String id) {
        super(id, 10, 10, true, Tabs.LIAVERES);
    }

    @Override
    public boolean hasEffect(ItemStack stack) {
        return true;
    }
}
