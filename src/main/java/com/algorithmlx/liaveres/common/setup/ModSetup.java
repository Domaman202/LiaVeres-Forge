package com.algorithmlx.liaveres.common.setup;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.server.network.Network;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.registries.RegistryObject;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static final CreativeModeTab CLASSIC_TAB = new CreativeModeTab(LiaVeres.ModId + ".classic_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Registration.MATTER_CRYSTAL_BLOCK.get());
        }
    };

    public static final CreativeModeTab ARTIFACT_TAB = new CreativeModeTab(LiaVeres.ModId + ".artifact_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Registration.LIGHTNING_ARTIFACT.get());
        }
    };

    public static final CreativeModeTab MOBS_TAB = new CreativeModeTab(LiaVeres.ModId + ".mobs_tab") {
        @Override
        public @NotNull ItemStack makeIcon() {
            return new ItemStack(Registration.AMDANOR_SKELETON_EGG.get());
        }
    };

    public static void init(final FMLCommonSetupEvent event) {
        Network.messageRegister();
    }

    @SubscribeEvent
    public static void serverInit(final RegisterCommandsEvent event) {
        Registration.commandRegister(event.getDispatcher());
    }
}
