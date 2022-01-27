package com.algorithmlx.liaveres.server.command;

import com.algorithmlx.liaveres.common.LiaVeres;
import com.algorithmlx.liaveres.common.util.TpTool;
import com.mojang.brigadier.Command;
import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.builder.ArgumentBuilder;
import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public class DimensionCommand implements Command<CommandSourceStack> {
    private static final DimensionCommand COMMAND = new DimensionCommand();

    public static ArgumentBuilder<CommandSourceStack, ?> register(CommandDispatcher<CommandSourceStack> dispatcher) {
        return Commands.literal("dimension")
                .requires(commandSourceStack -> commandSourceStack.hasPermission(Commands.LEVEL_ADMINS))
                .executes(COMMAND);
    }

    @Override
    public int run(CommandContext<CommandSourceStack> context) throws CommandSyntaxException {
        ServerPlayer player = context.getSource().getPlayerOrException();
        int x = player.blockPosition().getX();
        int y = player.blockPosition().getY();
        int z = player.blockPosition().getZ();
        if (player.getCommandSenderWorld().dimension().equals(Level.NETHER)) {
            ServerLevel level = player.getServer().getLevel(Level.OVERWORLD);
            TpTool.tp(player, level, new BlockPos(x, y, z));
            LiaVeres.LOGGER.debug("Teleported to: Overworld");
        } else if (player.getCommandSenderWorld().dimension().equals(Level.OVERWORLD)) {
            ServerLevel level = player.getServer().getLevel(Level.END);
            TpTool.tp(player, level, new BlockPos(x, y, z));
            LiaVeres.LOGGER.debug("Teleported to: End");
        } else if (player.getCommandSenderWorld().dimension().equals(Level.END)) {
            ServerLevel level = player.getServer().getLevel(Level.NETHER);
            TpTool.tp(player, level, new BlockPos(x, y, z));
            LiaVeres.LOGGER.debug("Teleported to: Nether");
        }
        return 0;
    }
}
