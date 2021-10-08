package com.algorithmlx.liaveres;

import com.algorithmlx.liaveres.registry.BlockInit;
import com.algorithmlx.liaveres.registry.ModItems;
import com.algorithmlx.liaveres.registry.TileRegistry;
import com.algorithmlx.liaveres.setup.ModSetup;
import jdk.nashorn.internal.ir.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import static com.algorithmlx.liaveres.setup.ModSetup.LIAVERES_ALL;


@Mod(LiaVeres.ModId)
public class LiaVeres {

    public static final Logger LOGGER = LogManager.getLogger();
    public static final String ModId = "liaveres";
    public static final String NAME = "LiaVeres";

    public LiaVeres() {
        IEventBus bus = FMLJavaModLoadingContext.get().getModEventBus();

        ModItems.init();
        BlockInit.init();

        MinecraftForge.EVENT_BUS.register(this);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(ModSetup::init);
    }

}
