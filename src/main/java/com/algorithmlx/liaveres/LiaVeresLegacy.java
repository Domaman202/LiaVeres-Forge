package com.algorithmlx.liaveres;

import com.algorithmlx.liaveres.util.proxy.Common;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = LiaVeresLegacy.MOD_ID,
        name = LiaVeresLegacy.MOD_NAME,
        version = LiaVeresLegacy.VERSION
)
public class LiaVeresLegacy {
    public static final Logger LOGGER = LogManager.getLogger("LiaVeres Logging");

    public static final String MOD_ID = "liaveres";
    public static final String MOD_NAME = "LiaVeres Legacy";
    public static final String VERSION = "1.12.2_R1";

    public static final String CLIENT = "com.algorithmlx.liaveres.util.proxy.Common";
    public static final String SERVER = "com.algorithmlx.liaveres.util.proxy.Common";

    @Mod.Instance(MOD_ID)
    public static LiaVeresLegacy INSTANCE;

    @SidedProxy(clientSide = CLIENT, serverSide = SERVER)
    public static Common proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e) {
        proxy.preInit(e);
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e) {
        proxy.init(e);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e) {
        proxy.postInit(e);
    }
}
