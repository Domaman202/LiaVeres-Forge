package com.algorithmlx.liaveres.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.shapes.ISelectionContext;
import net.minecraft.util.math.shapes.VoxelShape;
import net.minecraft.world.IBlockReader;

public class MatterCrystalBlock extends BlockBase {
    public MatterCrystalBlock(String name, int lvl){
        super(name, lvl);
    }
    protected static final VoxelShape MATTERCRYSTALBLOCK = Block.makeCuboidShape(4.0D, 0.0D, 4.0D, 12.0D, 4.0D, 12.0D);

    public VoxelShape getShape(BlockState state, IBlockReader worldIn, BlockPos pos, ISelectionContext context)
    {
        return MATTERCRYSTALBLOCK;
    }
}