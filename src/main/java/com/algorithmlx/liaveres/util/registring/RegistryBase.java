package com.algorithmlx.liaveres.util.registring;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import net.minecraft.block.Block;
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
    private static Block block;
    private static Item item;

    protected static void block(Block blockI) {
        block = blockI;

        ForgeRegistries.BLOCKS.register(blockI);
        ForgeRegistries.ITEMS.register(new ItemBlock(blockI).setRegistryName(blockI.getRegistryName()));

        LiaVeresLegacy.LOGGER.info("{} has been registred", blockI.getRegistryName());
    }

    protected static void item(Item itemI) {
        item = itemI;

        ForgeRegistries.ITEMS.register(itemI);


        LiaVeresLegacy.LOGGER.info("{} has been registred", itemI.getRegistryName());
    }

    public static void loadModels() {
        registryModelItem(item);
        registryModelBlock(block);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModelItem(Item item) {
        final ResourceLocation itemRegistryName = item.getRegistryName();
        final ModelResourceLocation modelLocation = new ModelResourceLocation(itemRegistryName, "inventory");
        ModelBakery.registerItemVariants(item, modelLocation);
        ModelLoader.setCustomModelResourceLocation(item, 0, modelLocation);
    }

    @SideOnly(Side.CLIENT)
    private static void registryModelBlock(Block block) {
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
