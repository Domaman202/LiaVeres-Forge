package com.algorithmlx.liaveres.common.util.container.yarn.slots;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.world.Container;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;

public class YarnInputSkeinSlot extends Slot {
    public YarnInputSkeinSlot(Container pContainer, int pIndex, int pX, int pY) {
        super(pContainer, pIndex, pX, pY);
    }

    @Override
    public boolean mayPlace(ItemStack pStack) {
        return pStack.getItem() == Registration.STRING_SKEIN.get();
    }
}
