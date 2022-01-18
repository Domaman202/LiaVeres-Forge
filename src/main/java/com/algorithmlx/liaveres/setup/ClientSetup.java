package com.algorithmlx.liaveres.setup;

import com.algorithmlx.liaveres.LiaVeres;
import com.algorithmlx.liaveres.client.render.AmdanorMobRender;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD)
public class ClientSetup {
    public ClientSetup() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
    }

    public void init(FMLClientSetupEvent event) {}
    @SubscribeEvent
    public static void registryEntityRenderers(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.AMDANOR_SKELETON.get(), AmdanorMobRender::new);
    }
}
