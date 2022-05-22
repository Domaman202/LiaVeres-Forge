package com.algorithmlx.liaveres.common.data;

import com.algorithmlx.liaveres.common.setup.Registration;
import core.liquid.objects.data.gen.LootTableProviderBase;
import net.minecraft.data.DataGenerator;

public class LootTables extends LootTableProviderBase {
    public LootTables(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void addTables() {
        lootTable.put(Registration.GILDED_NETHERITE_BLOCK.get(), createWithoutBlockEntity(
                Registration.GILDED_NETHERITE_BLOCK.get().getRegistryName().getPath(),
                Registration.GILDED_NETHERITE_BLOCK.get()
        ));
    }
}
