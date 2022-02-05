package com.algorithmlx.liaveres.common.setup.registries;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.server.command.BookCommand;
import com.algorithmlx.liaveres.server.command.DimensionCommand;
import com.mojang.brigadier.CommandDispatcher;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;

public class CommandRegister {
    public static void commandRegister(CommandDispatcher<CommandSourceStack> commandDispatcher) {
        commandDispatcher.register(Commands.literal(LiaVeres.ModId)
                .then(BookCommand.register(commandDispatcher))
                .then(DimensionCommand.register(commandDispatcher))
        );
    }
}
