package com.algorithmlx.liaveres.util.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.init.RegistryArray;
import com.algorithmlx.liaveres.util.handler.Model;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemPickaxe;

public class PickaxeBase extends ItemPickaxe implements Model {
    protected PickaxeBase(String id, ToolMaterial material, CreativeTabs tabs) {
        super(material);
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
