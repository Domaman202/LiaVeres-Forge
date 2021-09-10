package com.algorithmlx.liaveres.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MatterCrystalBlock extends Block {
    public MatterCrystalBlock(String name) {
        super(Properties.create(Material.ROCK)
                .hardnessAndResistance(340282356779733661637539395458142568447F)
                .sound(SoundType.STONE)
                .setLightLevel((state) -> 11)
                .variableOpacity());
        this.setRegistryName(name);
    }

}
