package com.algorithmlx.liaveres.container;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.util.container.yarn.inventory.YarnCraftInventory;
import com.algorithmlx.liaveres.common.util.container.yarn.inventory.YarnResultInventory;
import com.algorithmlx.liaveres.common.util.container.yarn.slots.YarnInputSkeinSlot;
import com.algorithmlx.liaveres.common.util.container.yarn.slots.YarnInputSlot;
import core.liquid.objects.container.BasedContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.CapabilityItemHandler;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;

public class YarnStationContainer extends BasedContainer {
    private IItemHandler iItemHandler;
    private BlockEntity blockEntity;
    private Player player;

    public YarnStationContainer(int windowId, Level level, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.YARN_STATION_CONTAINER.get(), windowId, playerInventory);
        blockEntity = level.getBlockEntity(pos);
        this.player = player;
        this.iItemHandler = new InvWrapper(playerInventory);

        addSlot(new YarnInputSlot(playerInventory, 1, 25,17));
        addSlot(new YarnInputSkeinSlot(playerInventory, 1, 25,53));

        makeInventorySlots(8, 64);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), player, Registration.YARN_STATION.get());
    }
}
