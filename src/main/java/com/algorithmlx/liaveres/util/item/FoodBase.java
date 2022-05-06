package com.algorithmlx.liaveres.util.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.init.RegistryArray;
import com.algorithmlx.liaveres.util.handler.Model;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemFood;

public class FoodBase extends ItemFood implements Model {
    public FoodBase(String id, int amount, float saturation, boolean isWolfFood, CreativeTabs tabs) {
        super(amount, saturation, isWolfFood);
        this.setRegistryName(id);
        this.setUnlocalizedName(LiaVeresLegacy.MOD_ID + "." + id);
        this.setCreativeTab(tabs);
        RegistryArray.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        LiaVeresLegacy.proxy.getRender(this, 0, "inventory");
    }
}
