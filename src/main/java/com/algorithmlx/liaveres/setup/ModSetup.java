package com.algorithmlx.liaveres.setup;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.registry.ModItems;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static final ItemGroup LIAVERES_ALL = new ItemGroup("liaveres_all") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(ModItems.MATTER_CRYSTAL.get());
        }
    };
    public static void init(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
    }
}
