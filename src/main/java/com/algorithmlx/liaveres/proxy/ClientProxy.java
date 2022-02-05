package com.algorithmlx.liaveres.proxy;

import com.algorithmlx.liaveres.client.render.AmdanorMobRender;
import com.algorithmlx.liaveres.client.screen.container.BackpackScreen;
import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.setup.registries.Registration;
import com.mojang.blaze3d.platform.ScreenManager;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.MenuScreens;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.EntityRenderersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;

import java.util.Objects;

@Mod.EventBusSubscriber(modid = LiaVeres.ModId, bus = Mod.EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ClientProxy extends Proxies {
    @SubscribeEvent
    public static void doClient(final FMLClientSetupEvent event) {
        MenuScreens.register(Registration.BASIC_BACKPACK_CONTAINER.get(), BackpackScreen::new);
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
