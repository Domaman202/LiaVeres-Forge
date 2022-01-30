package com.algorithmlx.liaveres.common.container;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.util.container.AbstractContainer;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class BasicBackpackContainer extends AbstractContainer {
    public BasicBackpackContainer(int windowId, Level world, BlockPos pos, Inventory playerInventory, Player player) {
        super(Registration.BASIC_BACKPACK_CONTAINER.get(), windowId, playerInventory);
    }

    @Override
    public boolean stillValid(Player pPlayer) {
        return false;
    }
}
