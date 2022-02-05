package com.algorithmlx.liaveres.common.util.container.nbt;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;

public class ContainerTag {
    public static ListTag inTag(SimpleContainer simpleContainer) {
        ListTag tag = new ListTag();

        for(int i = 0; i < simpleContainer.getContainerSize(); i++) {
            CompoundTag stackTag = new CompoundTag();
            stackTag.putInt("Slot", i);
            stackTag.put("Stack", simpleContainer.getItem(i).save(new CompoundTag()));
            tag.add(stackTag);
        }

        return tag;
    }

    public static void fromTag(ListTag tag, SimpleContainer simpleContainer) {
        simpleContainer.clearContent();

        tag.forEach(element -> {
            CompoundTag stackTag = (CompoundTag) element;
            int slot = stackTag.getInt("Slot");
            ItemStack stack = ItemStack.of(stackTag.getCompound("Stack"));
            simpleContainer.setItem(slot, stack);
        });
    }
}
