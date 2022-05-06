package com.algorithmlx.liaveres.util.proxy;

import com.algorithmlx.liaveres.recipe.ModRecipe;
import com.algorithmlx.liaveres.util.registring.Registry;
import com.algorithmlx.liaveres.util.registring.RegistryBase;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Common {
    public void preInit(FMLPreInitializationEvent e) {
        Registry.init();
    }
    public void init(FMLInitializationEvent e) {
        if (e.getSide().isClient()) {
            RegistryBase.loadModels();
        }
    }
    public void postInit(FMLPostInitializationEvent e) {
        ModRecipe.init();
    }
}
