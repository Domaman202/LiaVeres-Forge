package com.algorithmlx.liaveres.common.setup;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;

import static com.algorithmlx.liaveres.LiaVeres.ModId;

@Mod.EventBusSubscriber(modid = ModId, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {

    public static final CreativeModeTab CLASSIC_TAB = new CreativeModeTab(ModId + ".classic_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.MATTER_CRYSTAL.get());
        }
    };
    public static final CreativeModeTab ARTIFACT_TAB = new CreativeModeTab(ModId + ".artifact_tab") {
        @Override
        public ItemStack makeIcon() {
            return new ItemStack(Registration.LIGHTNING_ARTIFACT.get());
        }
    };
    public static void init(final FMLCommonSetupEvent event) {

    }

    @SubscribeEvent
    public static void serverLoad(RegisterCommandsEvent event) {
    }
}
