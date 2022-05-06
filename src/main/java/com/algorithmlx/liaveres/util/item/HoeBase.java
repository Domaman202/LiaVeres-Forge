package com.algorithmlx.liaveres.util.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemHoe;

public class HoeBase extends ItemHoe {
    public HoeBase(ToolMaterial material, String id, CreativeTabs tabs) {
        super(material);
        this.setRegistryName(id);
        this.setUnlocalizedName(LiaVeresLegacy.MOD_ID + "." + id);
        this.setCreativeTab(tabs);
    }
}
