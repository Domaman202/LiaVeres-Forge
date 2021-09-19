package com.algorithmlx.liaveres.tile;

import net.minecraft.nbt.CompoundNBT;
import net.minecraft.network.NetworkManager;
import net.minecraft.network.play.server.SUpdateTileEntityPacket;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;

public abstract class LiaTile extends TileEntity {

    public LiaTile(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    public CompoundNBT getUpdateTag() {
        return write(new CompoundNBT());
    }

    public abstract SUpdateTileEntityPacket getUpdatePacket();

    public abstract void onDataPacket(NetworkManager net, SUpdateTileEntityPacket pkt);
}