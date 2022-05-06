package com.algorithmlx.liaveres.util.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.init.RegistryArray;
import com.algorithmlx.liaveres.util.handler.Model;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class ItemBase extends Item implements Model {
    public ItemBase(String id, CreativeTabs tabs) {
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
