package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.itemtears.MatterTear;
import net.minecraft.item.SwordItem;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalSword extends SwordItem {
    public MatterCrystalSword()
    {
        super(MatterTear.MatterTear, 2147483647,99999999999999999999999999999999999999F, new Properties().isImmuneToFire().group(LIAVERES_ALL));
    }
}