package com.algorithmlx.liaveres.proxy;

import com.algorithmlx.liaveres.client.render.AmdanorMobRender;
import com.algorithmlx.liaveres.client.screen.YarnStationScreen;
import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.Config;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import core.liquid.network.proxy.Direction;
import net.minecraft.CrashReport;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.network.chat.TranslatableComponent;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy implements Direction {
    @SubscribeEvent
    public static void doClient(final FMLClientSetupEvent event) {
        if (Minecraft.getInstance().player != null && Minecraft.getInstance().player.getGameProfile().getName().equals("AlgorithmLX"))
            Minecraft.crash(new CrashReport(new TranslatableComponent("developer.crash.desc").toString(), new Throwable()));
        if (Config.backpackModule.get().equals(true) && Config.experimentalModule.get().equals(true)) {
            MenuScreens.register(Registration.YARN_STATION_CONTAINER.get(), YarnStationScreen::new);
        }
    }

    @SubscribeEvent
    public static void entityRender(final EntityRenderersEvent.RegisterRenderers event) {
        event.registerEntityRenderer(Registration.AMDANOR_SKELETON.get(), AmdanorMobRender::new);
//        event.registerEntityRenderer(Registration.MHNO3_BOSS.get(), MHNO3Render::new);
    }

    @Override
    public void init() {

    }

    @Override
    public boolean clientSide() {
        return true;
    }

    @Override
    public Level clientLevel() {
        return Objects.requireNonNull(Minecraft.getInstance().player).level;
    }

    @Override
    public Player clientPlayer() {
        return Minecraft.getInstance().player;
    }
}
