package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.util.item.AxeBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;

public class MatterCrystalAxe extends AxeBase {
    public MatterCrystalAxe(String id) {
        super(LiaMaterials.MATTER_TOOL_MATERIAL, Integer.MAX_VALUE, Integer.MAX_VALUE, id, Tabs.LIAVERES);
    }
}
