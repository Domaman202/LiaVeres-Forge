package com.algorithmlx.liaveres.proxy;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.server.registry.CommandRegister;
import core.liquid.network.proxy.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(value = Dist.DEDICATED_SERVER, bus = Mod.EventBusSubscriber.Bus.FORGE, modid = LiaVeres.ModId)
public class ServerProxy implements Direction {
    @SubscribeEvent
    public static void doServer(final RegisterCommandsEvent event) {
        CommandRegister.commandRegister(event.getDispatcher());
    }

    @Override
    public void init() {

    }

    public boolean clientSide() {
        return false;
    }

    @Override
    public Level clientLevel() {
        throw new IllegalStateException("Cannot be run on the server!");
    }

    @Override
    public Player clientPlayer() {
        throw new IllegalStateException("Cannot be run on the server!");
    }
}
