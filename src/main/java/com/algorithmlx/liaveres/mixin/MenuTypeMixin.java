package com.algorithmlx.liaveres.mixin;

import com.algorithmlx.liaveres.common.container.BackpackContainer;
import com.algorithmlx.liaveres.common.setup.Config;
import com.algorithmlx.liaveres.common.setup.Constants;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.MenuType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(value = MenuType.class, remap = false)
public class MenuTypeMixin {
    @Shadow
    private static <T extends AbstractContainerMenu> MenuType<T> register(String pKey, MenuType.MenuSupplier<T> pFactory) {
        return null;
    }

    static {
        if (Config.backpackModule.get().equals(true)) {
            Constants.CONTAINER_TYPE = register(Constants.IDMenuString,
                    (windowID, inventory) -> new BackpackContainer(windowID, inventory, inventory.player.getUsedItemHand()));
        }
    }
}
