package com.algorithmlx.liaveres.server.command;

import com.algorithmlx.liaveres.server.network.Network;
import com.algorithmlx.liaveres.server.network.OpenScreenPacket;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.server.level.ServerPlayer;

public class BookCommand implements Command<CommandSourceStack> {
    private static final BookCommand COMMAND = new BookCommand();

    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dspt) {
        return Commands.literal("liaBook")
                .requires(css -> css.hasPermission(Commands.LEVEL_ADMINS))
                .executes(COMMAND);
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        Network.clientSender(new OpenScreenPacket(), player);
        return 0;
    }
}
