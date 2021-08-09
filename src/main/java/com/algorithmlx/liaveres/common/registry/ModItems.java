package com.algorithmlx.liaveres.common.registry;

import net.minecraft.item.Item;

import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import com.algorithmlx.liaveres.common.object.items.MatterCrystal;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

@Mod.EventBusSubscriber(modid = ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ModItems {
    public static Item MatterCrystal = new MatterCrystal();

    @SubscribeEvent
    public static void registerItems(final RegistryEvent.Register<Item> e) {
        register(e, MatterCrystal);
    }

    private static void register(RegistryEvent.Register<Item> event, Item item) {
        event.getRegistry().register(item);
    }
}
