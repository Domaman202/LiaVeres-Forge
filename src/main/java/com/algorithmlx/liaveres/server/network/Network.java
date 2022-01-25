package com.algorithmlx.liaveres.server.network;

import com.algorithmlx.liaveres.common.LiaVeres;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.event.entity.player.PlayerContainerEvent;
import net.minecraftforge.network.NetworkDirection;
import net.minecraftforge.network.NetworkRegistry;
import net.minecraftforge.network.simple.SimpleChannel;

public class Network {
    private static SimpleChannel simpleChannel;
    private static int ID = 0;

    private static int nextID() {
        return ID++;
    }

    public static void messageRegister() {
        simpleChannel = NetworkRegistry.newSimpleChannel(new ResourceLocation(LiaVeres.ModId, "liaveres"),
                ()-> "1.0",
                s -> true,
                s -> true
        );

        simpleChannel.messageBuilder(OpenScreenPacket.class, nextID())
                .encoder(((openScreenPacket, friendlyByteBuf) -> {}))
                .decoder(friendlyByteBuf -> new OpenScreenPacket())
                .consumer(OpenScreenPacket::liaBookHandler)
                .add();
    }

    public static void clientSender(Object obj, ServerPlayer serverPlayer) {
        simpleChannel.sendTo(obj, serverPlayer.connection.connection, NetworkDirection.PLAY_TO_CLIENT);
    }

    public static void serverSender(Object obj) {
        simpleChannel.sendToServer(obj);
    }
}
