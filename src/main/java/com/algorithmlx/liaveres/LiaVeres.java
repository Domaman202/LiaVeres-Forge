package com.algorithmlx.liaveres;

import com.algorithmlx.liaveres.init.ItemGroups;
import com.algorithmlx.liaveres.registry.BlockInit;
import com.algorithmlx.liaveres.registry.ModItems;
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
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//Log
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//LiaVeres Imports


@Mod(LiaVeres.ModId)
public class LiaVeres {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";
    public static final String NAME = "LiaVeres";
    public static final ItemGroup lv_itemgroup = new ItemGroups(LiaVeres.ModId);

    public LiaVeres() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        bus.register(this);
        bus.register(new ModItems());
        bus.register(new TileRegistry());
        bus.register(new BlockInit());
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
