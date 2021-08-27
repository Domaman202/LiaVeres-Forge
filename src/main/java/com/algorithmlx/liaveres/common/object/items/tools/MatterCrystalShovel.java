package com.algorithmlx.liaveres.common.object.items.tools;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.common.object.itemtears.MatterTear;
import net.minecraft.item.ShovelItem;

public class MatterCrystalShovel extends ShovelItem
{
    public MatterCrystalShovel()
    {
        super(MatterTear.MatterTear,  3000,99999999999999999999999999999999999999F, new Properties().group(LiaVeres.lv_itemgroup));
        setRegistryName("matter_crystal_shovel");
    }
}