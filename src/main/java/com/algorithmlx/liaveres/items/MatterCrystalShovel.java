package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.itemtears.MatterTear;
import net.minecraft.item.ShovelItem;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalShovel extends ShovelItem {
    public MatterCrystalShovel()
    {
        super(MatterTear.MatterTear, 3000,99999999999999999999999999999999999999F, new Properties().isImmuneToFire().group(LIAVERES_ALL));
    }
}
