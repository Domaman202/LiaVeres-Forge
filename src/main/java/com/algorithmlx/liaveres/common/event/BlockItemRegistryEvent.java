package com.algorithmlx.liaveres.common.event;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.ModSetup;
import com.algorithmlx.liaveres.common.setup.Registration;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.registries.RegistryObject;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class BlockItemRegistryEvent {
    @SubscribeEvent
    public static void registry(final RegistryEvent.Register<Item> event) {
        Registration.BLOCK
                .getEntries()
                .stream()
                .map(RegistryObject::get)
                .forEach(block ->
                        event
                                .getRegistry()
                                .register(
                                        new BlockItem(
                                                block,
                                                new Item.Properties().tab(ModSetup.CLASSIC_TAB).fireResistant()
                                        )
                                                .setRegistryName(
                                                        Objects.requireNonNull(
                                                                block.getRegistryName()
                                                        )
                                                )
                                )
                );
    }
}
