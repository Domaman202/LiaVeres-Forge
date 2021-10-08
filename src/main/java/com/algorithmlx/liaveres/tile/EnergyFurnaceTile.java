package com.algorithmlx.liaveres.tile;

import com.algorithmlx.liaveres.registry.TileRegistry;
import net.minecraft.block.Blocks;
import net.minecraft.tileentity.ITickableTileEntity;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public class EnergyFurnaceTile extends TileEntity implements ITickableTileEntity {
    public EnergyFurnaceTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }
    public EnergyFurnaceTile() {
        this(TileRegistry.ENERGY_FURNACE_TILE.get());
    }
    @Override
    public void tick() {
        this.world.setBlockState(this.pos.down(), Blocks.AIR.getDefaultState());
    }
}
