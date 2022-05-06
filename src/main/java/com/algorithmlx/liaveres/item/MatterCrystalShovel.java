package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.util.item.ShovelBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;

public class MatterCrystalShovel extends ShovelBase {
    public MatterCrystalShovel(String id) {
        super(LiaMaterials.MATTER_TOOL_MATERIAL, id, Tabs.LIAVERES);
    }
}
