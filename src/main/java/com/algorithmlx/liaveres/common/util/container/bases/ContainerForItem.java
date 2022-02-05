package com.algorithmlx.liaveres.common.util.container.bases;

import com.algorithmlx.liaveres.common.util.container.nbt.ContainerTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.MenuType;
import net.minecraft.world.item.ItemStack;

public abstract class ContainerForItem extends AbstractContainer{
    public ContainerForItem(MenuType<?> container, int windowId, Inventory playerInventory) {
        super(container, windowId, playerInventory);
    }

    public void loadAndSaveTags(Inventory inventory, ItemStack stack) {
        ListTag tags = stack.getOrCreateTag().getList("Inventory", 10);
        SimpleContainer inv = new SimpleContainer() {
            @Override
            public void setChanged() {
                stack.getOrCreateTag().put("Inventory", ContainerTag.inTag(this));
            }
        };

        ContainerTag.fromTag(tags, inv);
    }
}
