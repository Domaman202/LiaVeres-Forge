package com.algorithmlx.liaveres;

import com.algorithmlx.liaveres.init.ItemGroups;
import com.algorithmlx.liaveres.registry.BlockInit;
import com.algorithmlx.liaveres.registry.ModArmor;
import com.algorithmlx.liaveres.registry.TileRegistry;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
//FML
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//Log
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//LiaVeres Imports


@Mod("liaveres")
public class LiaVeres {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";
    //ItemGroups
    public static final ItemGroup lv_itemgroup = new ItemGroups(LiaVeres.ModId);

    public LiaVeres() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModArmor.ITEMS.register(bus);
        TileRegistry.TILE_ENTITY_TYPE.register(bus);
        BlockInit.BLOCKS.register(bus);

        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        BlockInit.BLOCKS.getEntries().stream().map(RegistryObject::get).forEach(block -> {
            event.getRegistry()
                    .register(new BlockItem(block, new Item.Properties().group(lv_itemgroup))
                            .setRegistryName(block.getRegistryName()));
        });
    }
}
