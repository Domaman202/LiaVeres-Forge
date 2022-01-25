package com.algorithmlx.liaveres.server.network;

import com.algorithmlx.liaveres.client.screen.book.LiaBookScreen;
import net.minecraftforge.network.NetworkEvent;

import java.util.function.Supplier;

public class OpenScreenPacket {
    public boolean liaBookHandler(Supplier<NetworkEvent.Context> contextSupplier) {
        contextSupplier.get().enqueueWork(LiaBookScreen::open);
        return true;
    }
}
