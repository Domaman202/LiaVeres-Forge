package com.algorithmlx.liaveres.common.object.items.tools;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.common.object.itemtears.MatterTear;
import net.minecraft.item.SwordItem;

public class MatterCrystalSword extends SwordItem
{
    public MatterCrystalSword()
    {
        super(MatterTear.MatterTear, 2147483647,99999999999999999999999999999999999999F, new Properties().group(LiaVeres.lv_itemgroup));
        setRegistryName("matter_crystal_sword");
    }
}