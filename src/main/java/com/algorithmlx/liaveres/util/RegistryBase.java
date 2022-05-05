package com.algorithmlx.liaveres.util;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelBakery;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@SuppressWarnings("ConstantConditions")
public class RegistryBase {
    protected static void block(BlockBase block) {
        ForgeRegistries.BLOCKS.register(block);
        ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
        registryModelBlock(block);

        LiaVeresLegacy.LOGGER.info("{} has been registred", block);
    }

    protected static void item(ItemBase item) {
        ForgeRegistries.ITEMS.register(item);
        registryModelItem(item);

        LiaVeresLegacy.LOGGER.info("{} has been registred", item);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModelItem(ItemBase item) {
        final ResourceLocation itemRegistryName = item.getRegistryName();
        final ModelResourceLocation modelLocation = new ModelResourceLocation(itemRegistryName, "inventory");
        ModelBakery.registerItemVariants(item, modelLocation);
        ModelLoader.setCustomModelResourceLocation(item, 0, modelLocation);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModelBlock(BlockBase block) {
        Minecraft.getMinecraft()
                .getRenderItem()
                .getItemModelMesher()
                .register(
                        Item.getItemFromBlock(block),
                        0,
                        new ModelResourceLocation(block.getRegistryName(), "inventory")
                );
    }
}
