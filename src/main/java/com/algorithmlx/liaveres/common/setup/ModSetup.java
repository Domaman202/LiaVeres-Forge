package com.algorithmlx.liaveres.common.setup;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.world.levelgen.OreConfigured;
import com.algorithmlx.liaveres.common.world.levelgen.OrePlacement;
import com.algorithmlx.liaveres.common.world.levelgen.feature.StructureConfigured;
import com.algorithmlx.liaveres.common.world.structures.StructureRegistry;
import com.algorithmlx.liaveres.proxy.ClientProxy;
import com.algorithmlx.liaveres.proxy.Proxies;
import com.algorithmlx.liaveres.proxy.ServerProxy;
import com.algorithmlx.liaveres.server.network.Network;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.jetbrains.annotations.NotNull;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.FORGE)
public class ModSetup {
    public static Proxies proxy = DistExecutor.safeRunForDist(()-> ClientProxy::new, ()-> ServerProxy::new);

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
        proxy.init();
        event.enqueueWork(()-> {
            StructureRegistry.setupStructures();
            StructureConfigured.registerConfiguredStructures();
        });
        OreConfigured.register();
        OrePlacement.register();
    }

    @SubscribeEvent
    public static void serverInit(final RegisterCommandsEvent event) {
        Registration.commandRegister(event.getDispatcher());
    }
}
