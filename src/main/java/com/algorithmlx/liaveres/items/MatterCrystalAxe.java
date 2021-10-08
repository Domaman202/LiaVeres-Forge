package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.itemtears.MatterTear;
import net.minecraft.item.AxeItem;

public class MatterCrystalAxe extends AxeItem {
    public MatterCrystalAxe()
    {
        super(MatterTear.MatterTear, 901239.0F, 300F, new Properties().group(LiaVeres.lv_itemgroup));
        setRegistryName("matter_crystal_axe");
    }
}
