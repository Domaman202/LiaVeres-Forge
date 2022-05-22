package com.algorithmlx.liaveres.server.registry;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.server.command.BookCommand;
import com.algorithmlx.liaveres.server.command.DimensionCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandRegister {
    public static void commandRegister(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal(LiaVeres.ModId)
                .then(BookCommand.register())
                .then(DimensionCommand.register())
        );
    }
}
