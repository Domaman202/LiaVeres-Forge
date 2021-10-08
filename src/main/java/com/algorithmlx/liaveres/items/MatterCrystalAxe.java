package com.algorithmlx.liaveres.items;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.itemtears.MatterTear;
import net.minecraft.item.AxeItem;

import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;

public class MatterCrystalAxe extends AxeItem {
    public MatterCrystalAxe()
    {
        super(MatterTear.MatterTear, 901239.0F, 300F, new Properties().group(LIAVERES_ALL));
    }
}
