package com.algorithmlx.liaveres.common.object.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockRenderType;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;

public class EnergyStorageBlock extends Block {
    public EnergyStorageBlock(String name) {
        super(Properties.create(Material.ROCK)
                .doesNotBlockMovement()
                .tickRandomly()
                .hardnessAndResistance(2.0F)
                .sound(SoundType.STONE)
                .setLightLevel((state) -> 11));
        this.setRegistryName(name);
    }
    @Override
    public BlockRenderType getRenderType(BlockState state)
    {
        return BlockRenderType.ENTITYBLOCK_ANIMATED;
    }
}
