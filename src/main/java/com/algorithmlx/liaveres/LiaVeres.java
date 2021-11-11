package com.algorithmlx.liaveres;

import com.algorithmlx.liaveres.common.setup.Registration;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LiaVeres.ModId)
public class LiaVeres {
    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";

    public LiaVeres() {

        Registration.init();

        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
    }

}
