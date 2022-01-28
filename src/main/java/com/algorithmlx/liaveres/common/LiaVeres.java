package com.algorithmlx.liaveres.common;

import com.algorithmlx.liaveres.common.setup.registries.structures.StructureListener;
import com.algorithmlx.liaveres.common.world.structures.AmdanorBaseStructure;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.EventPriority;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Objects;

@Mod(LiaVeres.ModId)
@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class LiaVeres {
    public static final String ModId = "liaveres";
    public static final Logger LOGGER = LogManager.getLogger();

    public LiaVeres() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        IEventBus forgeEventBus = MinecraftForge.EVENT_BUS;

        Registration.init();

        eventBus.addListener(ModSetup::init);

        forgeEventBus.addListener(EventPriority.NORMAL, StructureListener::addDimensionalSpacing);
        forgeEventBus.addListener(EventPriority.NORMAL, AmdanorBaseStructure::setupStructureSpawns);
    }

    @SubscribeEvent
    public static void onRegisterItems(final RegistryEvent.Register<Item> event) {
        Registration.BLOCK.getEntries().stream().map(RegistryObject::get).forEach(block ->
            event.getRegistry()
                    .register(new BlockItem(block, new Item.Properties().tab(ModSetup.CLASSIC_TAB).fireResistant())
                            .setRegistryName(Objects.requireNonNull(block.getRegistryName()))));
    }
}
