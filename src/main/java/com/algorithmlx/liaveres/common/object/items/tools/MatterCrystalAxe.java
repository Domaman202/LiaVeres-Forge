package com.algorithmlx.liaveres.common.object.items.tools;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.common.object.itemtears.MatterTear;
import net.minecraft.item.AxeItem;

public class MatterCrystalAxe extends AxeItem
{
    public MatterCrystalAxe()
    {
        super(MatterTear.MatterTear, 901239.0F, 300F, new Properties().group(LiaVeres.lv_itemgroup));
        setRegistryName("matter_crystal_axe");
    }
}
