package com.algorithmlx.liaveres.blocks;

import com.algorithmlx.liaveres.registry.TileRegistry;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.IBlockReader;

import javax.annotation.Nullable;

public class EnergyFurnace extends Block {
    public EnergyFurnace() {
        super(AbstractBlock.Properties.create(Material.IRON)
                .hardnessAndResistance(15f)
                .sound(SoundType.METAL));
    }
    @Override
    public boolean hasTileEntity(BlockState state) {
        return  true;
    }

    @Nullable
    @Override
    public TileEntity createTileEntity(BlockState state, IBlockReader world) {
        return TileRegistry.ENERGY_FURNACE_TILE_TYPE.get().create();
    }
}
