package com.algorithmlx.liaveres.registry;

import com.algorithmlx.liaveres.blocks.EnergyFurnace;
import com.algorithmlx.liaveres.blocks.MatterCrystalBlock;
import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.IForgeRegistry;

import static com.algorithmlx.liaveres.LiaVeres.ModId;


public class BlockInit {
    private static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, ModId);
    private static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, ModId);

    public static void init() {
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
    }

    public static final RegistryObject<Block> ENERGY_FURNACE = BLOCKS.register("energy_furnace", () -> new EnergyFurnace());

    public static final RegistryObject<MatterCrystalBlock/*hahaha*/> MATTER_CRYSTAL_BLOCK = BLOCKS.register("matter_crystal_block", MatterCrystalBlock::new);

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event)
    {
        final IForgeRegistry<Item> registry = event.getRegistry();
        BlockInit.BLOCKS.getEntries().stream()
                .map(RegistryObject::get)
                .forEach(block -> {
                    final Item.Properties prop = new Item.Properties();
                    final BlockItem blockItem = new BlockItem(block, prop);
                    blockItem.setRegistryName(block.getRegistryName());
                    registry.register(blockItem);
        });
    }
}
