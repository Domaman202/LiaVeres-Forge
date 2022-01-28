package com.algorithmlx.liaveres.common.gata.generators;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class ItemModels extends ItemModelProvider {
    public ItemModels(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, LiaVeres.ModId, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        standardModel(Registration.GOLDEN_NETHERITE_INGOT.get());

        blockItemModel(Registration.GOLDEN_NETHERITE_BLOCK.get());
    }

    private void standardModel(ItemLike itemName) {
        String itemId = itemName.asItem().getRegistryName().getPath();
        singleTexture(itemId, new ResourceLocation("item/handheld"), "layer0", new ResourceLocation(LiaVeres.ModId, "item/" + itemId));
    }

    private void blockItemModel(ItemLike block) {
        String blockId = block.asItem().getRegistryName().getPath();
        withExistingParent(blockId, new ResourceLocation(LiaVeres.ModId, "block/" + blockId));
    }
}
