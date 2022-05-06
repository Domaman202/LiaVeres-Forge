package com.algorithmlx.liaveres.proxy;

import com.algorithmlx.liaveres.init.ModRecipe;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

public class Common {
    public void preInit(FMLPreInitializationEvent e) {

    }
    public void init(FMLInitializationEvent e) {

    }
    public void postInit(FMLPostInitializationEvent e) {
        ModRecipe.init();
    }


    public void getRender(Item item, int meta, String id) {}
}
