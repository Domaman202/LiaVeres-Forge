package com.algorithmlx.liaveres.setup.proxy;

import com.algorithmlx.liaveres.setup.Registry;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Common {
    public void preInit(FMLPreInitializationEvent e) {
        Registry.init();
    }
    public void init(FMLInitializationEvent e) {

    }
     public void postInit(FMLPostInitializationEvent e) {}
}
