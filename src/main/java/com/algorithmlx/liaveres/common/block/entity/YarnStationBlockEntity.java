package com.algorithmlx.liaveres.common.block.entity;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.core.BlockPos;
import net.minecraft.core.NonNullList;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.ContainerHelper;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;

public class YarnStationBlockEntity extends BlockEntity {
    protected NonNullList<ItemStack> items = NonNullList.withSize(3, ItemStack.EMPTY);

    public YarnStationBlockEntity(BlockPos pWorldPosition, BlockState pBlockState) {
        super(Registration.YARN_STATION_BLOCK_ENTITY.get(), pWorldPosition, pBlockState);
    }

    @Override
    protected void saveAdditional(CompoundTag pTag) {
        super.saveAdditional(pTag);
        ContainerHelper.saveAllItems(pTag, this.items);
    }

    @Override
    public void load(CompoundTag pTag) {
        super.load(pTag);
        this.items = NonNullList.withSize(this.getContainerSize(), ItemStack.EMPTY);
        ContainerHelper.loadAllItems(pTag, this.items);
    }

    public int getContainerSize() {
        return this.items.size();
    }
}
