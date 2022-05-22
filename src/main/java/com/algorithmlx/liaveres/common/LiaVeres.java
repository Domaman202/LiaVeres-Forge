package com.algorithmlx.liaveres.common;

import com.algorithmlx.liaveres.common.setup.Config;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import com.algorithmlx.liaveres.common.setup.Registration;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.ModLoadingContext;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.config.ModConfig;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(LiaVeres.ModId)
public class LiaVeres {
    public static final String ModId = "liaveres";
    public static final Logger LOGGER = LogManager.getLogger(LiaVeres.ModId);

    public LiaVeres() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        ModLoadingContext.get().registerConfig(ModConfig.Type.COMMON, Config.COMMON_CFG, LiaVeres.ModId + "/config.toml");
        Registration.init();
        eventBus.addListener(ModSetup::init);
    }
}
