package com.algorithmlx.liaveres;

import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
//FML
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
//Log
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//LiaVeres Imports
import com.algorithmlx.liaveres.common.object.itemgroups.*;


@Mod("liaveres")
public class LiaVeres {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";
    //ItemGroups
    public static final ItemGroup lv_itemgroup = new lv_itemgroup(LiaVeres.ModId);

    public LiaVeres() {

        IEventBus forgeBus = MinecraftForge.EVENT_BUS;

        forgeBus.addListener(this::setup);
        forgeBus.register(this);
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        eventBus.addListener(this::setup);
        eventBus.addListener(this::doClientStuff);

    }

    private void setup(final FMLCommonSetupEvent event) {

    }

    private void doClientStuff(final FMLClientSetupEvent event) {

    }

}
