package com.algorithmlx.liaveres.blocks;

import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MatterCrystalBlock extends Block {

    public MatterCrystalBlock() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(9999999f)
                .sound(SoundType.METAL)
        );
    }
}
