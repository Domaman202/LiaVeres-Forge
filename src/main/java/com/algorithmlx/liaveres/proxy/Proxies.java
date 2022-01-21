package com.algorithmlx.liaveres.proxy;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class Proxies {
    public void init() { }

    public boolean clientSide() {
        return true;
    }

    public Level clientLevel() {
        return null;
    }

    public Player clientPlayer() {
        return null;
    }
}
