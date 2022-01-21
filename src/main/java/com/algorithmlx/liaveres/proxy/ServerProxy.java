package com.algorithmlx.liaveres.proxy;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class ServerProxy extends Proxies {
    @Override
    public void init() {

    }

    public boolean isClientSide() {
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
