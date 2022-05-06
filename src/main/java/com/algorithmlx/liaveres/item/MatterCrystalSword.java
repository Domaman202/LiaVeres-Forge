package com.algorithmlx.liaveres.item;

import com.algorithmlx.liaveres.util.item.SwordBase;
import com.algorithmlx.liaveres.util.material.LiaMaterials;
import com.algorithmlx.liaveres.util.tab.Tabs;

public class MatterCrystalSword extends SwordBase {
    public MatterCrystalSword(String id) {
        super(LiaMaterials.MATTER_TOOL_MATERIAL, id, Tabs.LIAVERES);
    }
}
