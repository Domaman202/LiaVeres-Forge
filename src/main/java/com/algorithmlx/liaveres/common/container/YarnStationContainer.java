package com.algorithmlx.liaveres.common.container;

import com.algorithmlx.liaveres.common.container.slots.YarnInputSlot;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.container.slots.YarnInputSkeinSlot;
import core.liquid.objects.container.BasedContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;

@SuppressWarnings("all")
public class YarnStationContainer extends BasedContainer {
    private final BlockEntity blockEntity;
    private final Player player;

    public YarnStationContainer(int windowId, Level level, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.YARN_STATION_CONTAINER.get(), windowId, playerInventory);
        blockEntity = level.getBlockEntity(pos);
        this.player = player;

        addSlot(new YarnInputSlot(playerInventory, 1, 25,17));
        addSlot(new YarnInputSkeinSlot(playerInventory, 1, 25,53));

        makeInventorySlots(8, 64);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return stillValid(ContainerLevelAccess.create(blockEntity.getLevel(), blockEntity.getBlockPos()), player, Registration.YARN_STATION.get());
    }
}
