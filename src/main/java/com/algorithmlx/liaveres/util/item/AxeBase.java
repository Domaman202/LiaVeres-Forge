package com.algorithmlx.liaveres.util.item;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.ItemAxe;

public class AxeBase extends ItemAxe {
    protected AxeBase(ToolMaterial material, float damage, float speed, String id, CreativeTabs tabs) {
        super(material, damage, speed);
        this.setRegistryName(id);
        this.setUnlocalizedName(LiaVeresLegacy.MOD_ID + "." + id);
        this.setCreativeTab(tabs);
    }
}
