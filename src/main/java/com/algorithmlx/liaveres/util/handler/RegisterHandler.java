package com.algorithmlx.liaveres.util.handler;

import com.algorithmlx.liaveres.LiaVeresLegacy;
import com.algorithmlx.liaveres.init.RegistryArray;
import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.util.List;

@SuppressWarnings("ConfusingArgumentToVarargsMethod")
@Mod.EventBusSubscriber
public class RegisterHandler {
    @SubscribeEvent
    public static void itemRegister(RegistryEvent.Register<Item> register) {
        Item[] itemArray = RegistryArray.ITEMS.toArray(new Item[0]);
        register.getRegistry().registerAll(itemArray);
    }
    @SubscribeEvent
    public static void blockRegister(RegistryEvent.Register<Block> register) {
        Block[] blockArray = RegistryArray.BLOCKS.toArray(new Block[0]);
        register.getRegistry().registerAll(blockArray);
    }

    @SubscribeEvent
    public static void modelRegister(ModelRegistryEvent event) {
        for (Item item : RegistryArray.ITEMS) {
            if (item instanceof Model) {
                ((Model)item).registerModels();
                LiaVeresLegacy.LOGGER.debug("Registration and modelling next items: {}", item.getRegistryName());
            }
        }

        for (Block block : RegistryArray.BLOCKS) {
            if (block instanceof Model) {
                ((Model) block).registerModels();
                LiaVeresLegacy.LOGGER.debug("Registration and modelling next blocks: {}", block.getRegistryName());
            }
        }
    }
}
