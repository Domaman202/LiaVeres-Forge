package com.algorithmlx.liaveres.proxy;

import core.liquid.network.proxy.Direction;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ServerProxy implements Direction {
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
