package com.algorithmlx.liaveres.block;

import com.algorithmlx.liaveres.util.block.BlockBase;
import com.algorithmlx.liaveres.util.tab.Tabs;
import net.minecraft.block.material.Material;

public class MatterCrystalBlock extends BlockBase {
    public MatterCrystalBlock(String id) {
        super(id, Material.ROCK, Tabs.LIAVERES);
        this.setHarvestLevel("pickaxe", 2);
    }
}
