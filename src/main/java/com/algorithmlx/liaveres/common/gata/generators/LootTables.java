package com.algorithmlx.liaveres.common.gata.generators;

import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.algorithmlx.liaveres.common.util.datagen.LootTableProviderBase;
import net.minecraft.data.DataGenerator;

public class LootTables extends LootTableProviderBase {
    public LootTables(DataGenerator pGenerator) {
        super(pGenerator);
    }

    @Override
    protected void addTables() {
        lootTable.put(Registration.GILDED_NETHERITE_BLOCK.get(), createStandardNoBE(Registration.GILDED_NETHERITE_BLOCK.get().getRegistryName().getPath(), Registration.GILDED_NETHERITE_BLOCK.get()));
    }
}
