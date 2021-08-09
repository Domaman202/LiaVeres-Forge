package com.algorithmlx.liaveres;

import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
//Hollow, help pls
import software.bernie.example.registry.BlockRegistry;
import software.bernie.geckolib3.GeckoLib;


@Mod("liaveres")
public class LiaVeres {

    private static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";

    public LiaVeres() {
        GeckoLib.initialize();

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
