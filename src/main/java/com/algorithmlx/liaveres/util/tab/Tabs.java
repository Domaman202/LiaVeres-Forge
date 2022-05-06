package com.algorithmlx.liaveres.util.tab;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.util.registring.Registry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemStack;

public class Tabs {
    public static final CreativeTabs LIAVERES = new CreativeTabs(LiaVeresLegacy.MOD_ID + ".tab_main") {
        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(Registry.MATTER_CRYSTAL);
        }
    };
}
