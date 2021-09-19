package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.LiaVeres;

import com.algorithmlx.liaveres.blocks.MatterCrystalBlock;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.ObjectHolder;

import java.util.Objects;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

@Mod.EventBusSubscriber(modid = ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModBlocks {
    @ObjectHolder(ModId + ":matter_crystal_block")
    public static Block MatterCrystalBlock = null;

    @SubscribeEvent
    public static void registerBlocks(final RegistryEvent.Register<Block> e) {
        registerBlock(e, new MatterCrystalBlock("matter_crystal_block", 3));
    }

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e) {
        registerItem(e, MatterCrystalBlock);
    }


    private static void registerBlock(RegistryEvent.Register<Block> event, Block block) {
        event.getRegistry().register(block);
    }

    private static void registerItem(RegistryEvent.Register<Item> event, Block block) {
        event.getRegistry().register(new BlockItem(block, new Item.Properties()
                .group(LiaVeres.lv_itemgroup))
                .setRegistryName(Objects.requireNonNull(block.getRegistryName())));
    }

}
