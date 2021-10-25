package com.algorithmlx.liaveres;

import com.algorithmlx.liaveres.registry.Registration;
import com.algorithmlx.liaveres.setup.ModSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


@Mod(LiaVeres.ModId)
public class LiaVeres {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";
    public static final String NAME = "LiaVeres";

    public LiaVeres() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        Registration.init();;

        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
    }

}
