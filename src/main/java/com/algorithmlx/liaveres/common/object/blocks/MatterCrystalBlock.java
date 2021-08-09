package com.algorithmlx.liaveres.common.object.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class MatterCrystalBlock extends Block {
    public MatterCrystalBlock(String name) {
        super(Properties.create(Material.ROCK)
                .doesNotBlockMovement()
                .tickRandomly()
                .hardnessAndResistance(80.0F)
                .sound(SoundType.STONE)
                .setLightLevel((state) -> 11));
        this.setRegistryName(name);
    }

}
